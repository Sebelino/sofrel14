#!/usr/bin/python

from algorithm import member2
from generator import randomdata

def results(amount):
    return [member2(x,y) for (x,y) in randomdata(amount)]
