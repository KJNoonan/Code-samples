##method to recursively check if a word is a palendrome
##racecar
def palindrome(s, l):
    if l <= 1:##base case
        return True
    elif l > 1 and s[0].upper() == s[l-1].upper():
        return palindrome(s[1:l-1],l-2)
    else:
        return False
s = "racecar"
print(palindrome(s,len(s)))
