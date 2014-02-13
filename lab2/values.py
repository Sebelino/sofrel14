#!/usr/bin/python2

# Default values in the first column + additional typical values.
allvalues = [
     [0,1,-1,-3425234234,9223372036854775807,-9223372036854775808]
    ,[0,10]
    ,[-1,1234]
    ,[1,-3425234234]
    ,[9223372036854775807,0]
    ,[-9223372036854775808,-101]
    ,[2,7]
    ,[-2,4]
    ,[1234,-9274917]
    ,[-25546,0]
    ,[748485,8768]
]

defaults = [t[0] for t in allvalues]
typicals = [set(t[1:]) for t in allvalues]
