import os
import Lexico
from prediccion import get_prediccion
from gramatica import gramatica, palabras_reservadas, tokens_especiales

file = open("main.py", "r+")

file.write("entra = input() \n lexico(entrada)")

file.write ("def emparejar(letra): \n\tif token == tokEsperado: \n")
file.write ("\t\ttoken = lexico.getNextToken()\n\telse:\n\t\terrorSintaxis(tokEsperado)\n")

file.write("def errorSintaxis(regla): \n\treturn 'prediccion[regla]'")
listgram=list(gramatica)

conjuntos,primeros,siguientes = get_prediccion()

for regla in list(conjuntos):
    file.write(f"def {regla}(): \n ",)
    file.write(f"\tif  ") 
    for primero in primeros[regla]:
        
        for valor in primero:
            if primero.index(valor) == 0:
                file.write(f"token == '{valor}' ")
            else:
                file.write(f"or token == '{valor}' ")
        file.write(": \n")
        

        for letra in gramatica[regla][primeros[regla].index(primero)]:
            if letra == 'epsilon':
                file.write(f"\t\tpass \n")
            elif letra in palabras_reservadas or letra in tokens_especiales:
                file.write(f"\t\temparejar('{letra}')\n")
            else:
                file.write(f"\t\t{letra}()\n")
        file.write(f"\telif ")
    
    file.seek(file.tell()-len("\telif "))
    file.truncate()
    file.write(f"\telse: errorSintaxis('{regla}')\n")
