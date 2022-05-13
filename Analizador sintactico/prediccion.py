#from gramatica import gramatica, palabras_reservadas, tokens_especiales
from gramatica import gramatica, palabras_reservadas, tokens_especiales

primeros= {}

siguientes={}

def generar_primeros ():
    
    for g in palabras_reservadas:
        primeros[g]=[g]
    for g in tokens_especiales:
        primeros[g]=[g]

    for b in list(gramatica):
        primeros[b]=[]
    
    for i in reversed(list(gramatica)):
        for j in gramatica[i]:
            for h in j:
                if h == 'epsilon' and len(j) == 1:
                    primeros[i].append('epsilon')
                elif h in palabras_reservadas or h in tokens_especiales:
                    primeros[i].append(h)
                    
                    break
                elif h in gramatica.keys():
                    primeros[i].extend(primeros[h])
                    if 'epsilon' in primeros[h]:
                        primeros[i].remove('epsilon') 

def generar_siguientes():
    lisGrama= list(gramatica)
    for g in lisGrama:
        siguientes[g]=[]

    for i in lisGrama:
        if lisGrama.index(i)==0:
            siguientes[i].append('$')
        for j in lisGrama:
            values= gramatica[j]
            for h in values:
                for k in h:
                    if k == i :
                        if h.index(k) == len(h)-1:
                            siguientes[k].extend(siguientes[j])
                            break
                        elif 'epsilon' in primeros[h[h.index(k)+1]]:
                            siguientes[i].extend(primeros[h[h.index(k)+1]])
                            siguientes[i].extend(siguientes[j])
                        else:
                            siguientes[i].extend(primeros[h[h.index(k)+1]])



        
        
        

generar_primeros()

for i in list(gramatica):
   print (i, end=' - ')
   print (primeros[i])

generar_siguientes()

print("\n suiguiente:\n")

for i in list(gramatica):
   print (i, end=' - ')
   print (set(siguientes[i]))