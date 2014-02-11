def oracle(el, alist, func):
    found = False
    for val in alist:
        if val == el:
            found = True
            break
    return func(el, alist) == found

def testsuite(tests, func):
    results = []
    for case in tests:
        results += [oracle(case[0], case[1], func)]
    return results
