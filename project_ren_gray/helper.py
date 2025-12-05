# ITP 115, Fall 2024
# Final Project
# Name: Gray Ren
# Email: juliaren@usc.edu
# Section: ITP115, 31870
# Description:

import pretty_print


# define a function called createPuzzleList
# parameter/input 1:filenameStr is a string with name of the CSV file to read
# and it has a default value of "puzzles.csv"
# return value: a list of dictionaries where each dictionary represents one puzzle
def createPuzzleList(filenameStr="puzzles.csv"):
    puzzles = []
    fileObj = open(filenameStr, "r")
    keys = fileObj.readline()
    keys = keys.strip()
    keys = keys.split(",")
    for line in fileObj:
        puzzleDict = {}
        data = line.strip()
        data = data.split(",")
        for line in keys:
            index = keys.index(line)
            value = data[index]
            puzzleDict[line]=value
        puzzles.append(puzzleDict)
    fileObj.close()
    return puzzles

# define a function called getPuzzle
# parameter/input 1: puzzleList is a list of dictionaries where each
# dictionary represents a puzzle
# parameter/inpit 2: numStr is a string which is one of the valid values
# in puzzleList for the "num" key
# return value: a dictionary representing one puzzle where the value for
# the "num" key is the numStr parameter
def getPuzzle(puzzleList, numStr):
    for puzzleDict in puzzleList:
        if "num" in puzzleDict:
            num = puzzleDict["num"]
            if num == numStr:
                dictMatch = puzzleDict
    return dictMatch

# define a function called getColor
# parameter/input 1: puzzleDict is a dictionary that represents one puzzle
# parameter/input 2:difficultyNum is an integer which is one of the difficulty levels (1 – 4)
# Return value: a string with the color that corresponds to the difficulty level
# return value: a string ("YELLOW", "GREEN", "BLUE", "PURPLE") based on
# the difficultyNum parameter.
def getColor(puzzleDict, difficultyNum):
    color = "color"+str(difficultyNum)
    colorStr = ""
    if color in puzzleDict:
        colorStr = puzzleDict[color]
    else:
        colorStr = "GREY"
    return colorStr

# define a function called getConnection
# parameter/input 1: puzzleDict is a dictionary that represents one puzzle
# parameter/input 2:difficultyNum is an integer which is one of the difficulty levels (1 – 4)
# return value: a string with the connection that corresponds to the difficulty level
def getConnection(puzzleDict, difficultyNum):
    connection = "connection"+str(difficultyNum)
    if connection in puzzleDict:
        connectionStr = puzzleDict[connection]
    else:
        connectionStr = "CONNECTION ERROR"
    return connectionStr

# define a function called getConnection
# parameter/input 1: puzzleDict is a dictionary that represents one puzzle
# parameter/input 2:difficultyNum is an integer which is one of the difficulty levels (1 – 4)
# return value: difficultyNum is an integer which is one of the difficulty levels (1 – 4)
def getWordsInGroup(puzzleDict, difficultyNum):
    wordList = []
    for item in range(1,5):
        words ="word"+str(difficultyNum)+str(item)
        if words in puzzleDict:
            word =puzzleDict[words]
            wordList.append(word)
    wordList.sort()
    return wordList

# define a function called getUnconnectedWords
# parameter/input 1: puzzleDict is a dictionary that represents one puzzle
#parameter/input 2: foundGroupList is a list of integers holding the
# difficulty levels (1 – 4) that have already been found
# Return value: a list of strings which are the items in the puzzle that have not been
# connected yet
def getUnconnectedWords(puzzleDict,foundGroupList):
    unconnectedWords = []
    for num in range(1, 5):
        if num not in foundGroupList:
            word = getWordsInGroup(puzzleDict,num)
            for item in word:
                unconnectedWords.append(item)
    return unconnectedWords







