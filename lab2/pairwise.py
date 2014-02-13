#!/usr/local/bin/python2

# Generates a pairwise test suite for typicals v with default values d.
# pairwise([1,2,3,4],[{1,2,3},{1,2,3},{1,2,3},{1,2,3,4}]) = {[4,4,3,4],...}
#def pairwise(defaults,typicals):
#    len(defaults)
    

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

print(onewise([1,2,3],[{1,2,3}]*3))
