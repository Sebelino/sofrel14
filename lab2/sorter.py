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

print(sort([8,5,6,5,2234,632,73512]))
