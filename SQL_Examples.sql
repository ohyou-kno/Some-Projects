CREATE VIEW StoreOrderSummary AS
SELECT
r.StoreNumber,
r.StoreZip,
COUNT(o.OrderNumber) as TotalOrders,
SUM(o.ExtendedPrice) as TotalSales
FROM `order_item[1]` o
LEFT JOIN `sku_data[1]` s ON o.SKU = 5.SKU
LEFT JOIN `retail_order[1]`r ON o.OrderNumber GROUP BY r.StoreNumber, r.StoreZip;
=
r.OrderNumber


CREATE VIEW ProductSalesSummary AS
SELECT
5.SKU,
s.SKU_Description,
SUM(o.Quantity) as OrderQuantity, SUM(o.ExtendedPrice) as productRevenue
FROM `sku_data[1]`s
LEFT JOIN `order_item[1] o ON s.SKU = o.SKU GROUP BY s.SKU, S.SKU_Description;
