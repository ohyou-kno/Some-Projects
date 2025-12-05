# ITP 115, Fall 2024
# Final Project
# Name: Gray Ren
# Email: juliaren@usc.edu
# Section: ITP115, 31870

import helper as h
import interface as inter

#function: main
#param: n/a
#return: n/a
def main():
    print("Connections!")
    print("Group words that share a common thread")
    inter.displayRules()
    helper =  h.createPuzzleList()
    dict=inter.pickPuzzle(helper)
    inter.playGame(dict)

main()


