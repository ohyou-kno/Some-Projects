import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import tensorflow as tf
from tensorflow import keras
import seaborn as sb
import random
from sklearn.metrics import confusion_matrix
import kagglehub

# Download latest version
path = kagglehub.dataset_download("zalando-research/fashionmnist")
print("Path to dataset files:", path)

#2.	Print the shapes of the train and test sets for the features and target. (2)
fashion = tf.keras.datasets.fashion_mnist
(train_images, train_labels), (test_images, test_labels) = fashion.load_data()

print(f"Shape of train_images: {train_images.shape}")
print(f"Shape of train_labels: {train_labels.shape}")
print(f"Shape of test_images: {test_images.shape}")
print(f"Shape of test_labels: {test_labels.shape}")

#3.	Is the target variable values clothing or numbers? (2)
# It's numbers

#4.	If it is numbers, then how would you map numbers to clothing? Hint: Use a data dictionary
clothes_dict = {0:"T-shirt/top", 1:"Trousers", 2:"Pullover", 3:"Dress", 4:"Coat", 5:"Sandal",
                6:"Shirt", 7:"Sneaker", 8:"Bag", 9:"Ankle Boot"}

#5.	Show a histogram (count) of the apparel. (2)
plt.figure(figsize = (10, 6))
plt.hist(train_labels, bins=range(len(clothes_dict) + 1), align='left', rwidth=0.7)
plt.xticks(range(len(clothes_dict)), [clothes_dict[i] for i in range(len(clothes_dict))])
plt.xlabel("Clothes Type")
plt.ylabel("Count")
plt.show()

#6.	Display 25 random apparel from the train dataset. Display their labels as shown below.
plt.figure(figsize=(10, 10))
for i in range(25):
    plt.subplot(5, 5, i +1)
    plt.xticks([])
    plt.yticks([])
    plt.grid(False)
    random_index = random.randint(0, len(train_images) - 1)
    plt.imshow(train_images[random_index], cmap=plt.cm.binary)
    plt.xlabel(clothes_dict[train_labels[random_index]])
plt.show()

#7.	Scale the train and test features. (2)
trainImages_scaled = train_images/255.0
testImages_scaled = test_images/255.0

#8.	Create a keras model of sequence of layers.  (6)
model = keras.models.Sequential()
model.add(keras.layers.Flatten(input_shape=(28, 28)))
model.add(keras.layers.Dense(200, activation = "relu"))
model.add(keras.layers.Dense(400, activation = "relu"))
#9.	Add a dense layer as output layer. Choose the appropriate number of neurons and activation function
model.add(keras.layers.Dense(10, activation = "softmax")) #output layer

#10. Display the model summary. (2)
model.summary()

#11. Set the model loss function as sparse_categorical_crossentropy.
#Set the optimizer as sgd. Set the metrics as accuracy.
model.compile(loss = "sparse_categorical_crossentropy",
              optimizer = "sgd", metrics = ["accuracy"])

#12. Fit to train the model. Use at least 100 epochs. (2)
h = model.fit(train_images, train_labels, epochs = 10, verbose=1)

#13. Plot the loss curve. (2)
pd.DataFrame(h.history).plot()
plt.show()

#14. Display the accuracy of your model. (2)
model.evaluate(test_images, test_labels)

#15. display the predicted apparel of the first row in the test dataset. Also display the actual apparel.
#Show both actual and predicted letters (as title) on the image of the apparel
y_pred = model.predict(test_images)
y_pred = np.argmax(y_pred, axis=1)
image_number = random.randint(0, 10000)
test_sample = np.array(test_images.iloc[image_number]).reshape(28, 28)
plt.imshow(test_sample, cmap="gray")
plt.title("The predicted apparel is "+ str(y_pred[image_number]))
plt.show()

#16. Finally, display the actual and predicted label of a misclassified apparel. (6)
failed_df = train_images[y_pred != train_labels]
print("Dataframe of incorrect predictions ", failed_df)
failed_index = failed_df.sample(n=1).index
failed_sample = np.array(train_images.iloc[failed_index]).reshape(28, 28)
print("The failed sample is ", failed_sample)
plt.imshow(failed_sample, cmap="gray")
plt.title("The failed predicted digit is "+ str(y_pred[failed_index]) +
          " whereas the actual digit is" + str(train_labels[failed_index].values))
