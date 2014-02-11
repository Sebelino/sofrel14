#/usr/bin/python

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

def member(el, list):
    left = 0
    right = len(list) - 1

    x = (left + right) // 2
    while list[x] != el and left <= right:
        if el < list[x]:
            right = x - 1
        else:
            left = x + 1
        x = (left + right) // 2
    
    return (list[x] == el)

def member2(el, alist):
    A = sort(alist)
    return member(el, A)

print member2(3, [1, 4, 2, 15, 6])
print member2(4, [1, 4, 2, 15, 6])
