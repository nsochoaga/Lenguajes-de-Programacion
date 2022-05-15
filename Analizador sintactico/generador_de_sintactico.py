from prediccion import get_prediccion
from gramatica import gramatica, palabras_reservadas, tokens_especiales

file = open("main.py", "w")

file.write("from analizador_lexico import get_tokens\n")
file.write("from prediccion import get_prediccion\n\nprediccion,primeros,siguientes = get_prediccion()\n")
file.write("from gramatica import tokens_especiales, palabras_reservadas\n\n")

file.write ("def emparejar(letra): \n    global token\n    if token[0] == letra: \n")
file.write ("        token = getNextToken()\n    else:\n        errorSintaxis(letra)\n\n")

file.write ("def getNextToken():\n    if len(tokenList) == 0:\n        return '$'\n    else: return tokenList.pop(0)\n\n")

file.write("def errorSintaxis(regla): \n    if regla in palabras_reservadas or regla in tokens_especiales:\n        print(f'error se esperaba {regla }')\n    else:\n        return prediccion[regla]\n")
listgram=list(gramatica)

conjuntos,primeros,siguientes = get_prediccion()

for regla in list(conjuntos):
    file.write(f"def {regla}(): \n",)
    file.write(f"    if  ") 
    for primero in primeros[regla]:
        
        for valor in primero:
            if primero.index(valor) == 0:
                file.write(f"token[0] == '{valor}' ")
            else:
                file.write(f"or token[0] == '{valor}' ")
        file.write(": \n")
        

        for letra in gramatica[regla][primeros[regla].index(primero)]:
            if letra == 'epsilon':
                file.write(f"        pass \n")
            elif letra in palabras_reservadas or letra in tokens_especiales:
                file.write(f"        emparejar('{letra}')\n")
            else:
                file.write(f"        {letra}()\n")
        file.write(f"    elif ")
    
    file.seek(file.tell()-len("    elif "))
    file.truncate()
    file.write(f"    else: errorSintaxis('{regla}')\n")


file.write("tokenList = get_tokens()\n")
file.write("token = getNextToken()\n")
file.write("INICIO()\n")
file.write("if token[0] != '$':\n    print('Error sintactico: se esperaba fin')\n    exit()\n\n")
file.write("print('El analisis sintactico ha finalizado exitosamente.')")