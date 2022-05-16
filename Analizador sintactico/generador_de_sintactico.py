from prediccion import get_prediccion
from gramatica import gramatica, palabras_reservadas, tokens_especiales

file = open("main.py", "w")

file.write("from analizador_lexico import get_tokens\n")
file.write("from analizador_lexico import tokens_especiales2 as tk\n")
file.write("from prediccion import get_prediccion\n\nprediccion,primeros,siguientes = get_prediccion()\n")
file.write("from gramatica import tokens_especiales, palabras_reservadas\n\n")

file.write ("def emparejar(letra): \n    global token\n    if token[0] == letra: \n")
file.write ("        token = getNextToken()\n    else:\n        errorSintaxis(letra)\n\n")

file.write ("def getNextToken():\n    if len(tokenList) == 0:\n        return ['$','$','$']\n    else: return tokenList.pop(0)\n\n")

file.write("def errorSintaxis(regla): \n    if regla in palabras_reservadas or regla in tokens_especiales:\n        print(f\'<{token[-2] }:{token [-1]}> Error sintactico: se encontro: ', end='')\n")

file.write("        if token[0] in tokens_especiales:\n            print(f\"'{tk[token[0]] }'\",end='')\n")
file.write("        else:\n            print(f\"'{token[0] }'\",end='')\n")
file.write("        print('; se esperaba: ',end='')\n")
file.write("        if regla in tokens_especiales:\n            print(f\"'{tk[regla] }'.\")\n        else:\n            print(f\"'{regla }'.\")\n        exit()\n")        
file.write("    else:\n        print(f'<{token[-2] }:{token [-1]}> Error sintactico: se encontro: {token[0] }; se esperaba:', prediccion[regla])\n        exit()\n\n")
listgram=list(gramatica)

conjuntos,primeros,siguientes = get_prediccion()
esEpsilon=0
for regla in list(conjuntos):
    file.write(f"def {regla}(): \n",)
    file.write(f"    if  ") 
    for primero in primeros[regla]:
        
        for valor in primero:
            if valor == 'epsilon':
                pass
            elif primero.index(valor) == 0:
                file.write(f"token[0] == '{valor}' ")
            else:
                file.write(f"or token[0] == '{valor}' ")
        file.write(": \n")
        

        for letra in gramatica[regla][primeros[regla].index(primero)]:
            if letra == 'epsilon':
                esEpsilon=1
            elif letra in palabras_reservadas or letra in tokens_especiales:
                file.write(f"        emparejar('{letra}')\n")
            else:
                file.write(f"        {letra}()\n")
        file.write(f"    elif ")
    
    file.seek(file.tell()-len("    elif "))
    file.truncate()
    if esEpsilon:
        file.seek(file.tell()-len("    elif "))
        file.truncate()
        file.write(f" else: pass\n")
        esEpsilon=0
    else:
        file.write(f"    else: errorSintaxis('{regla}')\n")


file.write("tokenList = get_tokens()\n")
file.write("token = getNextToken()\n")
file.write("INICIO()\n")
file.write("if token[0] != '$':\n    print('Error sintactico: se esperaba fin')\n    exit()\n\n")
file.write("print('El analisis sintactico ha finalizado exitosamente.')")