from algorithm import member2

def oracle(el, alist, func):
    found = False
    for val in alist:
        if val == el:
            found = True
            break
    return func(el, alist) == found

print oracle(3, [1, 4, 2, 15, 6], member2)
print oracle(4, [1, 4, 2, 15, 6], member2)
