#!/usr/local/bin/python2

from pprint import pprint

# Generates a pairwise test suite for typicals typicals with default values defaults.
# pairwise([1,2,3,4],[{1,2,3},{1,2,3},{1,2,3},{1,2,3,4}]) = {(4,4,3,4), (1,2,3,4),...}
def pairwise(defaults,typicals):
    result = set()
    # First element
    for i in range(len(typicals)):
        v = typicals[i]
        for element in v:
            instance = defaults[:]
            instance[i] = element
            # Second element
            for j in [x for x in range(len(typicals)) if x != i]:
                w = typicals[j]
                for element2 in w:
                    newerinstance = instance[:]
                    newerinstance[j] = element2
                    result.add(tuple(newerinstance))
    return result

def pairwise2(defaults,typicals):
    testsuite = pairwise(defaults,typicals)
    return [(t[0],list(t[1:])) for t in testsuite]

# Frontend for pairwise.
# easypairwise([1,2,3]) = pairwise([1,2,3],[{1,2,3},{1,2,3},{1,2,3}])
def easypairwise(defaults):
    return pairwise(defaults,[set(defaults)]*len(defaults))

def onewise(defaults,typicals):
    result = set()
    for i in range(len(typicals)):
        v = typicals[i]
        for element in v:
            instance = defaults[:]
            instance[i] = element
            print("adding %s"% instance)
            result.add(tuple(instance))
    return result

#pprint(pairwise([3,1,2,4],[{1,2,3,4}]*4))
#pprint(easypairwise([1,2,3,4]))
#pprint(easypairwise([1,2]))
