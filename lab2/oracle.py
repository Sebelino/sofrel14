# Determines whether the function returned the correct value
# for a given input
def oracle(el, alist, func):
    found = False
    for val in alist:
        if val == el:
            found = True
            break
    return func(el, alist) == found

# Tests the given function on a test suite
# Returns the result on each test as compared to the oracle
def testsuite(tests, func):
    results = []
    for case in tests:
        results += [oracle(case[0], case[1], func)]
    return results

# Returns the number of tests needed to find the first error
# for a given function on a given test suite
def firsterror(tests, func):
    i = 0
    for case in tests:
        i += 1
        if not oracle(case[0], case[1], func):
            return i
    return -1

# Tests all functions in funcs[] on the test cases in tests[]
# Returns the indices of the first error for each function
def testall(tests, funcs):
    results = []
    for func in funcs:
        results += [firsterror(tests, func)]
    return results
