#from gramatica import gramatica, palabras_reservadas, tokens_especiales
from gramatica_de_prueba import gramatica, palabras_reservadas, tokens_especiales

primeros= {}

siguientes={}

prediccion={}

def generar_primeros ():
    
    for g in palabras_reservadas:
        primeros[g]=[g]
    for g in tokens_especiales:
        primeros[g]=[g]
    primeros['epsilon'] = ['epsilon']
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
                            siguientes[i].remove('epsilon')
                            siguientes[i].extend(siguientes[j])
                        else:
                            siguientes[i].extend(primeros[h[h.index(k)+1]])


def generar_prediccion():
    noter=0
    auxiliar=[]
    lisGrama= list(gramatica)
    for b in list(gramatica):
        prediccion[b]=[]
    for i in lisGrama:
        
        for j in gramatica[i]:
            for h in j:
                if h in palabras_reservadas or h in tokens_especiales:
                    prediccion[i].append([h])
                    break
                else:
                    noter=1
                    if 'epsilon' in primeros[h]:
                        auxiliar = primeros[h]
                        auxiliar.extend(siguientes[i])
                        auxiliar.remove('epsilon')
                        
                    else:
                        auxiliar.extend(primeros[h])
            if noter:
                prediccion[i].append(auxiliar)
                noter = 0

        
        
        

generar_primeros()

"""for i in list(gramatica):
   print (i, end=' - ')
   print (primeros[i])"""

generar_siguientes()

"""print("\n suiguiente:\n")

for i in list(gramatica):
   print (i, end=' - ')
   print (set(siguientes[i]))"""

generar_prediccion()

for i in list(gramatica):
   print (i, end=' - ')
   print (prediccion[i])