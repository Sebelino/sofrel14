#!/usr/bin/python

def sort(alist):
    A = alist
    for i in range(len(A)):
        j = i
        while j > 0 and A[j-1] > A[j]:
            temp = A[j-1]
            A[j-1] = A[j]
            A[j] = temp
            j = j-1
    return A

def memberBin(el, alist):
    left = 0
    right = len(alist) - 1

    x = (left + right) // 2
    while alist[x] != el and left <= right:
        if el < alist[x]:
            right = x - 1
        else:
            left = x + 1
        x = (left + right) // 2
    
    return (alist[x] == el)

def member(el, alist):
    A = sort(alist)
    return memberBin(el, A)
