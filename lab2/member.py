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
