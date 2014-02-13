#!/usr/bin/python

from algorithm import sort, memberBin

#
#	Mutant 1
#
def memberBin1(el, alist):
    left = 0
    right = len(alist) - 1

    x = (left + right) // 2
    while alist[x] != el and left > right:	# left <= right -> left > right
        if el < alist[x]:
            right = x - 1
        else:
            left = x + 1
        x = (left + right) // 2
    
    return (alist[x] == el)

def member1(el, alist):
    A = sort(alist)
    return memberBin1(el, A)

#
#	Mutant 2
#
def sort2(alist):
    A = alist[:]
    for i in range(len(A)):
        j = i
        while j >= 0 and A[j-1] > A[j]:	# j > 0 -> j >= 0
            temp = A[j-1]
            A[j-1] = A[j]
            A[j] = temp
            j = j-1
    return A

def member2(el, alist):
    A = sort2(alist)
    return memberBin(el, A)


#
#	Mutant 3
#
def memberBin3(el, alist):
    left = 0
    right = len(alist) - 2	# 1 -> 2

    x = (left + right) // 2
    while alist[x] != el and left <= right:
        if el < alist[x]:
            right = x - 1
        else:
            left = x + 1
        x = (left + right) // 2
    
    return (alist[x] == el)

def member3(el, alist):
    A = sort(alist)
    return memberBin3(el, A)


#
#	Mutant 4
#
def sort4(alist):
    A = alist[:]
    for i in range(len(A)):
        j = i
        while j > 0 and A[j-1] < A[j]: # A[j-1] > A[j] -> A[j-1] < A[j]
            temp = A[j-1]
            A[j-1] = A[j]
            A[j] = temp
            j = j-1
    return A

def member4(el, alist):
    A = sort4(alist)
    return memberBin(el, A)


#
#	Mutant 5
#
def member5(el, alist):
    A = sort(alist)
    return memberBin(el, alist)	# memberBin(el, A) -> memberBin(el, alist)

#
#	Mutant 6
#
def sort6(alist):
    A = alist[:]
    for i in range(len(A)):
        j = i
        while j > 0 and A[j-1] > A[j]:
            temp = A[i-1]	# A[j-1] ->A[i-1]
            A[j-1] = A[j]
            A[j] = temp
            j = j-1
    return A

def member6(el, alist):
    A = sort6(alist)
    return memberBin(el, A)
