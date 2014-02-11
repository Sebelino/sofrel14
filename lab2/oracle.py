def oracle(el, alist, func):
    found = False
    for val in alist:
        if val == el:
            found = True
            break
    return func(el, alist) == found
