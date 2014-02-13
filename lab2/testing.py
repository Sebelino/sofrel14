from values import *
from generator import randomdata
from oracle import testall
from mutants import *
from pairwise import pairwise2

pairtests = pairwise2(defaults500, typicals500)
rndtests = randomdata(10000, dimension=500, lowerbound = -1000, upperbound = 1000)
funcs = [member1, member2, member3, member4, member5, member6]

pairRes = testall(pairtests, funcs)
rndRes = testall(rndtests, funcs)

print zip(pairRes, rndRes)
