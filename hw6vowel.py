import time
def rvowel(s):
##recursive vowel counter
    if len(s) == 1 and s.upper() in ['A','E','I','O','U']:
        return 1
    elif len(s) == 1 and not(s.upper() in ['A','E','I','O','U']):
        return 0
    else:
        return rvowel(s[:int((len(s))/2)]) + rvowel(s[int((len(s))/2):])
    
def vowel(s):
#regular cowel counter
    count = 0
    for i in range(len(s)):
        if s[i].upper() in ['A','E','I','O','U']:
            count+=1
    return count

def timing(func, inp, fName):
	#function to time functions to enable complexities
    runs = int(input('Number of Samples for '+ fName+': '))
    print('\n'+'//\\'*8)
    print('Run\tN\t# of Vowels\tmsec\tratio')
    lst = []
    for i in range(runs):
        start = time.time()
        ans = func(inp)
        end = time.time()
        lst.append(end-start)

        print(i+1, end = '\t')#run number
        
        print(len(inp), end='\t')#number of characters in string
        inp = inp * 2#double the input

        print(ans, end ='\t\t')#number of Vowels found

        print(int(round(lst[i]*1000)), end = '\t')#the milliseconds it took

        if i == 0:#the efficiency ratio
            print('-----')
        else:
            print(lst[i]/lst[i-1])
    print('\n'+'//\\'*8)
        

s = 'this is a test to see if my program can accurately count the vowels'*1000
timing(vowel, s, 'vowel')
timing(rvowel, s,'rvowel')

