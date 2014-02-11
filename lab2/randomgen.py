#!/usr/bin/python

from random import randint

def randomdata(amount):
    dimension = 11
    lowerbound = 0
    upperbound = 20
    return [[randint(lowerbound,upperbound) for _ in range(dimension)] for _ in range(amount)]
