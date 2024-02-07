t = int (input())

for i in range(t):
    women = list()
    men = list()

    n = int (input())
    for j in range(n):
        l = input().split()
        men.append([int(i)for i in l])
    for j in range(n):
        l = input().split()
        women.append([int(i)for i in l])

    wi = [-1]*n
    mi = [1]*n
    #print("wi",wi)
    #print("mi",mi)
    while -1 in wi:
        for m0 in range (n):
            
            w0 = men[m0][mi[m0]]-1
            if(wi[w0]<0):
                wi[w0] = m0
            else:
                
                p0 = women[w0][1:].index(wi[w0]+1)
                p1 = women[w0][1:].index(m0+1)
                
                if p1<p0 : 
                    mi[wi[w0]] = mi[wi[e0]]+1
                    wi[w0] = m0
                elif p0<p1: 
                    mi[m0] = mi[m0]+1


    for w in range (n):
        print(w+1,wi[w]+1)

#2
#4
#1 4 3 1 2
#2 2 1 3 4
#3 1 3 4 2
#4 4 3 1 2
#1 3 2 4 1
#2 2 3 1 4
#3 3 1 2 4
#4 3 2 4 1
#7
#1 3 4 2 1 6 7 5
#2 6 4 2 3 5 1 7
#3 6 3 5 7 2 4 1
#4 1 6 3 2 4 7 5
#5 1 6 5 3 4 7 2
#6 1 7 3 4 5 6 2
#7 5 6 2 4 3 7 1
#1 4 5 3 7 2 6 1
#2 5 6 4 7 3 2 1
#3 1 6 5 4 3 7 2
#4 3 5 6 7 2 4 1
#5 1 7 6 4 3 5 2
#6 3 7 5 2 4 1
#7 1 7 4 2 6 5 3