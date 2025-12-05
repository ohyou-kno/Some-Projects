# ITP 115, Fall 2024
# Final Project
# Name: Gray Ren
# Email: juliaren@usc.edu
# Section: ITP115, 31870

import helper as h
import pretty_print as pp

# define a function called displayRules
# parameter/input 1: n/a
# return value: n/a

# define a function called displayRules
# parameter/input 1: textfileStr is a string with name of the text file to read and it has a default
# value of "rules.txt"
# return value: n/a
def displayRules(testfileStr = "rules.txt"):
    fileObj = open(testfileStr, "r")
    for line in fileObj:
        print(line)
    fileObj.close()

# define a function called isValidNumber
# parameter/input 1: userStr is a string with input from the user
# parameter/input 2: startNum is an integer which is the first number in the range of valid
# numbers
# parameter/input 3: endNum is an integer which is the last number in the range of valid
# numbers (inclusive)
# return value: n/a
def isValidNumber(userStr, startNum, endNum):
    if userStr.isdigit() == True and int(userStr) in range(startNum,endNum+1):
        validNumber = True
    else:
        validNumber = False
    return validNumber

# define a function called pickPuzzle
# parameter/input 1: puzzleList is a list of dictionaries where each dictionary represents a puzzle
# return value: a dictionary representing one puzzle based on the user’s input for the
# puzzle number
def pickPuzzle(puzzleList):
    length = len(puzzleList)
    lengthStr = str(length)
    userStr = input("Enter a puzzle number(1- "+lengthStr+" ):")
    validNum = isValidNumber(userStr,1,length+1)
    while validNum ==False:
        userStr = input("Enter a puzzle number(1- "+ lengthStr+" ):")
        validNum = isValidNumber(userStr, 1, lengthStr)
    puzzle = h.getPuzzle(puzzleList,userStr)
    return puzzle

# define a function called getGuessList
# parameter/input 1: wordList is a list of strings which are the words from the puzzle that have
# not been connected yet
# return value: a list of strings containing four items entered by the user that are sorted
# in alphabetical order
def getGuessList(wordList):
    print("Enter four items for your guess")
    guessList = []
    for num in range(1,5):
        count = str(num)
        guess = input("Item #"+ count+": ").strip().upper()
        while guess not in wordList or guess in guessList:
            guess = input("Item #" +count+": ").strip().upper()
        guessList.append(guess)
    guessList.sort()
    return guessList

# define a function called checkConnection
# parameter/input 1: puzzleDict is a dictionary that represents one puzzle
# parameter/input 2: guessList is an alphabetically sorted list of strings with four items
# return value: an integer that is the difficulty number (1 – 4) of the connection group
# that matches guessList, otherwise 0 if guessList is not one of the connection groups
def checkConnection(puzzleDict,guessList):
    connection = 0
    for num in range(1,5):
        wordsGroup = h.getWordsInGroup(puzzleDict, num)
        if guessList == wordsGroup:
            connection = num
    return connection

# define a function called savePuzzle
# parameter/input 1: puzzleDict is a dictionary that represents one puzzle
# parameter/input 2: groupsFound is a list of integers with the difficulty number and has a
# default value of [1, 2, 3, 4]
# return value: n/a
def savePuzzle(puzzleDict, groupsFound = [1,2,3,4]):
    number = puzzleDict.get("num")
    fileName = "puzzle"+number+".txt"
    puzzleText = open(fileName, "w")
    date = puzzleDict.get("date")
    for num in groupsFound:
        color = h.getColor(puzzleDict,num)
        connection = h.getConnection(puzzleDict,num)
        words = h.getWordsInGroup(puzzleDict,num)
        print(color, ":", connection, words)
    puzzleText.close()
    print("Puzzle from", date, "has been saved to", fileName)

# define a function called playGame
# parameter/input 1: puzzleDict is a dictionary that represents one puzzle
# return value: n/a
def playGame(puzzleDict):
    correctDifficulty = []
    incorrectDifficult = 0
    while len(correctDifficulty) != 4 and incorrectDifficult<4:
        pp.displayGrid(puzzleDict, correctDifficulty, incorrectDifficult)
        words = h.getUnconnectedWords(puzzleDict, correctDifficulty)
        guesses = getGuessList(words)
        yay = checkConnection(puzzleDict, guesses)
        if yay == 0:
            incorrectDifficult += 1
        else:
            correctDifficulty.append(yay)
            correctDifficulty.sort()
    if incorrectDifficult ==4:
        pp.displayGrid(puzzleDict)
        print("Better luck next time :(")
    else:
        pp.displayGrid(puzzleDict, correctDifficulty)
        print("Congratulations :D")
        savePuzzle(puzzleDict, correctDifficulty)

























