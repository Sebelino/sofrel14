def oracle(el, alist, func):
    found = False
    for val in alist:
        if val == el:
            found = True
            break
    return func(el, alist) == found

def testsuite(tests, func):
    for case in tests:
        if not oracle(case[0], case[1:], func):
            return False
    return True
