
palabras_reservadas = [
    'and', 'archivo', 'caso', 'const', 'constantes', 'desde', 'eval', 'fin',
    'hasta', 'inicio', 'lib', 'libext', 'matriz', 'mientras', 'not', 'or',
    'paso', 'subrutina', 'programa', 'ref', 'registro', 'repetir', 'retorna', 'si',
    'sino', 'tipos', 'var', 'variables', 'vector', 'numerico', 'imprimir', 'tan', 'logico',
    'TRUE', 'FALSE', 'SI', 'NO', 'leer', 'cadena', 'dim', 'int', 'cos', 'sin', 'cls', 'set_ifs', 
    'abs', 'arctan', 'ascii','dec', 'eof', 'exp', 'get_ifs', 'inc', 'log', 'lower', 'mem',
    'ord', 'paramval', 'pcount', 'pos', 'random', 'sec', 'set_stdin', 'set_stdout', 'sqrt',
    'str', 'strdup', 'strlen', 'substr', 'upper', 'val', 'alen'
]
tokens_especiales = {
    '=' : 'tk_asignacion',          ',': 'tk_coma',                  ']' : 'tk_corchete_derecho',
    '[' : 'tk_corchete_izquierdo',  '<>' : 'tk_distinto_de',         '/' : 'tk_division',
    ':' : 'tk_dos_puntos',          '==': 'tk_igual_que',            '}' : 'tk_llave_derecha',
    '{' : 'tk_llave_izquierda',     '>' : 'tk_mayor',                '>=' : 'tk_mayor_igual',
    '<' : 'tk_menor',               '<=' : 'tk_menor_igual',         '%' : 'tk_modulo',           '*': 'tk_multiplicacion',
    ')' : 'tk_parentesis_derecho',  '(' : 'tk_parentesis_izquierdo', '^' : 'tk_potenciacion',
    '.' : 'tk_punto',               ';' : 'tk_punto_y_coma',         '-' : 'tk_resta',            '+' : 'tk_suma'
    }

import re
import sys

tipo_token = 'nulo'
cadena=''
lineas= []
fila = 0 
columna = 0
contador_col =  0
contador_fil = 0
multilinea = 0
token_cadena= 0
distinto = 0
numero_caracteres= 0

identificadores = re.compile(r'[A-Za-zñÑ_]+[A-Za-zñÑ0-9_]*')
numero = re.compile(r'(\d+(\.?\d*))?([eE][\+,\-]?(\d*?))?')
cadenas = re.compile(r'("[\s\S]*")|(\'[\s\S]*\')')
posible_numero = re.compile(r'(\d+(\.?\d*))?([eE][+-]?)')



while True:
    try:
        entrada = input()
    except EOFError:
        break
    entrada.rstrip('\n')
    lineas.append([entrada])



for i in lineas:
    contador_col=0
    contador_fil+=1
    if cadena != '' and not token_cadena :
        if cadena in palabras_reservadas:
            tipo_token = cadena
        elif cadena in tokens_especiales.keys():
            tipo_token = tokens_especiales[cadena]
        
        if tipo_token == 'id':
            print("<id,{},{},{}>".format(cadena,fila, columna))
            cadena= ''
            tipo_token='nulo'
        elif tipo_token == 'tk_cadena':
            print("<tk_cadena,{},{},{}>".format(cadena,fila, columna))
            cadena= ''
            tipo_token='nulo'
        elif tipo_token == 'tk_numero':
            print("<{},{},{},{}>".format(tipo_token,cadena,fila, columna))
            cadena= ''
            tipo_token='nulo'
        elif tipo_token == 'posible' or tipo_token == 'nulo':
            print(">>> Error lexico(linea:{},posicion:{})".format(fila,columna))
            sys.exit()
        else :
            print("<{},{},{}>".format(tipo_token, fila, columna))
            cadena= ''
            tipo_token='nulo'
    elif token_cadena:
        print(">>> Error lexico(linea:{},posicion:{})".format(fila,columna))
        sys.exit()
    for k in i:
        for j in k:
            contador_col+=1
            if multilinea:
                if j=='*':
                    cadena+=j
                    continue
                elif j=='/':
                    cadena+=j
                    if cadena == '*/':
                        multilinea=0
                        cadena=''
                        continue
                continue
                
            elif cadena=='':
                columna=contador_col
                fila = contador_fil
                numero_caracteres=0

            cadena+=j
            numero_caracteres+=1

            if j=='"' or j=="“" or j=="'" or token_cadena :
                if not token_cadena:
                    token_cadena=1
                    
                elif cadenas.fullmatch(cadena):
                    tipo_token='tk_cadena'
                    token_cadena=0
                    continue
                else:
                    continue
                    
            elif j=='/':
                if cadena=='//':
                    cadena=''
                    break
                continue
            elif j=='*':
                if cadena=='/*':
                    cadena=''
                    multilinea=1
                    continue
            elif j=='<' and len(cadena)==1:
                continue
            elif j=='=' and len(cadena)==1:
                continue
            elif j=='>' and len(cadena)==1:
                continue
            elif identificadores.fullmatch(cadena) and numero_caracteres<33 :
                tipo_token = 'id'
                continue
            elif posible_numero.fullmatch(cadena):
                tipo_token= 'posible'
                continue
            elif numero.fullmatch(cadena):
                tipo_token= 'tk_numero'
                continue

            if cadena!='<>' and cadena!='<=' and  cadena!='>=' and cadena!='==':
                cadena=cadena[:-1]
            else:
                distinto=1
            if cadena in palabras_reservadas:
                tipo_token = cadena
            elif cadena in tokens_especiales.keys():
                tipo_token = tokens_especiales[cadena]
            
            if cadena != '':
                if tipo_token == 'id':
                    print("<id,{},{},{}>".format(cadena,fila, columna))
                    cadena= ''
                    tipo_token='nulo'
                elif tipo_token == 'tk_cadena':
                    print("<tk_cadena,{},{},{}>".format(cadena,fila, columna))
                    cadena= ''
                    tipo_token='nulo'
                elif tipo_token == 'tk_numero':
                    print("<{},{},{},{}>".format(tipo_token,cadena,fila, columna))
                    cadena= ''
                    tipo_token='nulo'
                elif tipo_token == 'posible' or tipo_token == 'nulo':
                    print(">>> Error lexico(linea:{},posicion:{})".format(fila,columna))
                    sys.exit()
                else :
                    print("<{},{},{}>".format(tipo_token, fila, columna))
                    cadena= ''
                    tipo_token='nulo'
            if j != ' ' and not distinto:
                if cadena=='':
                    columna=contador_col
                    fila = contador_fil
                    numero_caracteres=0
                cadena+=j
                numero_caracteres+=1
                if cadena in tokens_especiales.keys():
                    tipo_token = tokens_especiales[cadena]
                elif identificadores.fullmatch(cadena) :
                    tipo_token = 'id'
                elif posible_numero.fullmatch(cadena):
                    tipo_token= 'posible'
                elif numero.fullmatch(cadena):
                    tipo_token= 'tk_numero'
            else: 
                distinto = 0 


if cadena != '':
    if multilinea:
        sys.exit()
    if cadena in palabras_reservadas:
        tipo_token = cadena
    elif cadena in tokens_especiales.keys():
        tipo_token = tokens_especiales[cadena]
    elif identificadores.fullmatch(cadena) :
        tipo_token = 'id'
    elif posible_numero.fullmatch(cadena):
        tipo_token= 'posible'
    elif numero.fullmatch(cadena):
        tipo_token= 'tk_numero'
    if tipo_token == 'id':
        print("<id,{},{},{}>".format(cadena,fila, columna))
        cadena= ''
        tipo_token='nulo'
    elif tipo_token == 'tk_cadena':
        print("<tk_cadena,{},{},{}>".format(cadena,fila, columna))
        cadena= ''
        tipo_token='nulo'
    elif tipo_token == 'tk_numero':
        print("<{},{},{},{}>".format(tipo_token,cadena,fila, columna))
        cadena= ''
        tipo_token='nulo'
    elif tipo_token == 'posible' or tipo_token == 'nulo' :
        print(">>> Error lexico(linea:{},posicion:{})".format(fila,columna))
        sys.exit()
    else :
        print("<{},{},{}>".format(tipo_token, fila, columna))
        cadena= ''
        tipo_token='nulo'