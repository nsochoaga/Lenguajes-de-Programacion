from analizador_lexico import get_tokens
from analizador_lexico import tokens_especiales2 as tk
from prediccion import get_prediccion

prediccion,primeros,siguientes = get_prediccion()
from gramatica import tokens_especiales, palabras_reservadas

def emparejar(letra): 
    global token
    if token[0] == letra: 
        token = getNextToken()
    else:
        errorSintaxis(letra)

def getNextToken():
    if len(tokenList) == 0:
        return ['$','$','$']
    else: return tokenList.pop(0)

def errorSintaxis(regla): 
    if regla in palabras_reservadas or regla in tokens_especiales:
        print(f'<{token[-2] }:{token [-1]}> Error sintactico: se encontro: ', end='')
        if token[0] in tokens_especiales:
            print(f"'{tk[token[0]] }'",end='')
        else:
            print(f"'{token[0] }'",end='')
        print('; se esperaba: ',end='')
        if regla in tokens_especiales:
            print(f"'{tk[regla] }'.")
        else:
            print(f"'{regla }'.")
        exit()
    else:
        print(f'<{token[-2] }:{token [-1]}> Error sintactico: se encontro: {token[0] }; se esperaba:', prediccion[regla])
        exit()

def INICIO(): 
    if  token[0] == 'const' or token[0] == 'var' or token[0] == 'tipos' or token[0] == 'programa' : 
        PROG()
        ESPECIFICACION()
        emparejar('inicio')
        SENTENCIAS()
        emparejar('fin')
        SUBRUTINAS()
    else: errorSintaxis('INICIO')
def PROG(): 
    if  token[0] == 'programa' : 
        emparejar('programa')
        emparejar('id')
    else: pass
def ESPECIFICACION(): 
    if  token[0] == 'var' : 
        emparejar('var')
        VAR()
        ESPECIFICACION()
    elif token[0] == 'const' : 
        emparejar('const')
        CONST()
        ESPECIFICACION()
    elif token[0] == 'tipos' : 
        emparejar('tipos')
        TIPOS()
        ESPECIFICACION()
    else: pass
def VAR(): 
    if  token[0] == 'id' : 
        ID()
        emparejar('tk_dos_puntos')
        RMT()
        PC()
        VAR()
    else: pass
def CONST(): 
    if  token[0] == 'id' : 
        emparejar('id')
        emparejar('tk_asignacion')
        CONST2()
        PC()
        CONST()
    else: pass
def CONST2(): 
    if  token[0] == 'tk_numero' : 
        emparejar('tk_numero')
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
    elif token[0] == 'TRUE' : 
        emparejar('TRUE')
    elif token[0] == 'FALSE' : 
        emparejar('FALSE')
    elif token[0] == 'SI' : 
        emparejar('SI')
    elif token[0] == 'NO' : 
        emparejar('NO')
    else: errorSintaxis('CONST2')
def RMT(): 
    if  token[0] == 'logico' or token[0] == 'id' or token[0] == 'cadena' or token[0] == 'numerico' : 
        TIPODATO()
    elif token[0] == 'vector' : 
        emparejar('vector')
        emparejar('tk_corchete_izquierdo')
        VECTOR2()
        emparejar('tk_corchete_derecho')
        TIPODATO()
    elif token[0] == 'matriz' : 
        emparejar('matriz')
        emparejar('tk_corchete_izquierdo')
        MATRIZ()
        emparejar('tk_corchete_derecho')
        TIPODATO()
    elif token[0] == 'registro' : 
        emparejar('registro')
        REGISTRO()
    else: errorSintaxis('RMT')
def VECTOR2(): 
    if  token[0] == 'tk_numero' : 
        emparejar('tk_numero')
    elif token[0] == 'id' : 
        emparejar('id')
    elif token[0] == 'tk_multiplicacion' : 
        emparejar('tk_multiplicacion')
    else: errorSintaxis('VECTOR2')
def MATRIZ(): 
    if  token[0] == 'tk_numero' : 
        emparejar('tk_numero')
        MATRIZ2()
    elif token[0] == 'tk_multiplicacion' : 
        emparejar('tk_multiplicacion')
        MATRIZ2()
    else: errorSintaxis('MATRIZ')
def MATRIZ2(): 
    if  token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        MATRIZ()
    else: pass
def TIPODATO(): 
    if  token[0] == 'numerico' : 
        emparejar('numerico')
    elif token[0] == 'cadena' : 
        emparejar('cadena')
    elif token[0] == 'logico' : 
        emparejar('logico')
    elif token[0] == 'id' : 
        emparejar('id')
    else: errorSintaxis('TIPODATO')
def REGISTRO(): 
    if  token[0] == 'tk_llave_izquierda' : 
        emparejar('tk_llave_izquierda')
        VAR()
        emparejar('tk_llave_derecha')
    else: errorSintaxis('REGISTRO')
def TIPOS(): 
    if  token[0] == 'id' : 
        emparejar('id')
        emparejar('tk_dos_puntos')
        RMT()
        TIPOS()
    else: pass
def PC(): 
    if  token[0] == 'tk_punto_y_coma' : 
        emparejar('tk_punto_y_coma')
    else: pass
def SENTENCIAS(): 
    if  token[0] == 'id' : 
        emparejar('id')
        IDSENTENCIA()
        SENTENCIAS()
    elif token[0] == 'si' : 
        emparejar('si')
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        emparejar('tk_llave_izquierda')
        SENTENCIAS()
        ELSE()
        emparejar('tk_llave_derecha')
        SENTENCIAS()
    elif token[0] == 'mientras' : 
        emparejar('mientras')
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        emparejar('tk_llave_izquierda')
        SENTENCIAS()
        emparejar('tk_llave_derecha')
        SENTENCIAS()
    elif token[0] == 'repetir' : 
        emparejar('repetir')
        SENTENCIAS()
        emparejar('hasta')
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
    elif token[0] == 'eval' : 
        emparejar('eval')
        emparejar('tk_llave_izquierda')
        CASO()
        emparejar('sino')
        SENTENCIAS()
        emparejar('tk_llave_derecha')
        SENTENCIAS()
    elif token[0] == 'desde' : 
        emparejar('desde')
        emparejar('id')
        emparejar('tk_asignacion')
        EXPRE()
        emparejar('hasta')
        EXPRE()
        INCREMENTO()
        emparejar('tk_llave_izquierda')
        SENTENCIAS()
        emparejar('tk_llave_derecha')
        SENTENCIAS()
    elif token[0] == 'imprimir' : 
        emparejar('imprimir')
        emparejar('tk_parentesis_izquierdo')
        IMPRIMIR()
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
    elif token[0] == 'leer' : 
        emparejar('leer')
        emparejar('tk_parentesis_izquierdo')
        LEER()
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
    elif token[0] == 'dim' : 
        emparejar('dim')
        emparejar('tk_parentesis_izquierdo')
        LEER()
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
    elif token[0] == 'cls' : 
        emparejar('cls')
        emparejar('tk_parentesis_izquierdo')
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
    else: pass
def IDSENTENCIA(): 
    if  token[0] == 'tk_asignacion' or token[0] == 'tk_dos_puntos' : 
        ASIGID()
        INT()
    elif token[0] == 'tk_parentesis_izquierdo' : 
        emparejar('tk_parentesis_izquierdo')
        ARGUMENTOS()
        emparejar('tk_parentesis_derecho')
    else: errorSintaxis('IDSENTENCIA')
def INT(): 
    if  token[0] == 'int' : 
        emparejar('int')
        EXPRE()
    elif token[0] == 'tk_parentesis_izquierdo' or token[0] == 'tk_llave_izquierda' or token[0] == 'tk_numero' or token[0] == 'alen' or token[0] == 'id' or token[0] == 'tk_cadena' : 
        EXPRE()
    else: errorSintaxis('INT')
def LEER(): 
    if  token[0] == 'id' : 
        emparejar('id')
        LEER2()
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
    else: errorSintaxis('LEER')
def LEER2(): 
    if  token[0] == 'tk_corchete_izquierdo' : 
        emparejar('tk_corchete_izquierdo')
        LEER3()
        emparejar('tk_corchete_derecho')
    elif token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        LEER()
    else: pass
def LEER3(): 
    if  token[0] == 'id' : 
        emparejar('id')
    elif token[0] == 'tk_numero' : 
        emparejar('tk_numero')
    else: errorSintaxis('LEER3')
def IMPRIMIR(): 
    if  token[0] == 'id' : 
        IDV()
        IMPRIMIR2()
    elif token[0] == 'tk_numero' : 
        emparejar('tk_numero')
        IMPRIMIR2()
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
        IMPRIMIR2()
    else: errorSintaxis('IMPRIMIR')
def IMPRIMIR2(): 
    if  token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        IMPRIMIR()
    else: pass
def ASIGID(): 
    if  token[0] == 'tk_dos_puntos' : 
        emparejar('tk_dos_puntos')
    elif token[0] == 'tk_asignacion' : 
        emparejar('tk_asignacion')
    else: errorSintaxis('ASIGID')
def EXPRE(): 
    if  token[0] == 'tk_parentesis_izquierdo' : 
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        LOGIC()
    elif token[0] == 'tk_numero' : 
        emparejar('tk_numero')
        EXPRE2()
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
    elif token[0] == 'id' : 
        IDV()
        EXPRE2()
    elif token[0] == 'tk_llave_izquierda' : 
        emparejar('tk_llave_izquierda')
        LISTA()
        emparejar('tk_llave_derecha')
    elif token[0] == 'alen' : 
        emparejar('alen')
        emparejar('tk_parentesis_izquierdo')
        emparejar('id')
        emparejar('tk_parentesis_derecho')
    else: errorSintaxis('EXPRE')
def LOGIC(): 
    if  token[0] == 'or' : 
        emparejar('or')
        EXPRE()
    else: pass
def LISTA(): 
    if  token[0] == 'tk_numero' : 
        emparejar('tk_numero')
        LISTA2()
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
        LISTA2()
    elif token[0] == 'tk_llave_izquierda' : 
        emparejar('tk_llave_izquierda')
        LISTA3()
        emparejar('tk_llave_derecha')
        LISTA2()
    else: errorSintaxis('LISTA')
def LISTA3(): 
    if  token[0] == 'tk_numero' : 
        emparejar('tk_numero')
        LISTA2()
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
        LISTA2()
    else: pass
def LISTA2(): 
    if  token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        LISTA()
    else: pass
def EXPRE2(): 
    if  token[0] == 'tk_suma' : 
        emparejar('tk_suma')
        EXPRE3()
    elif token[0] == 'tk_multiplicacion' : 
        emparejar('tk_multiplicacion')
        EXPRE3()
    elif token[0] == 'tk_mayor' or token[0] == 'tk_resta' or token[0] == 'tk_division' or token[0] == 'tk_menor' or token[0] == 'tk_mayor_igual' or token[0] == 'tk_igual_que' or token[0] == 'tk_modulo' or token[0] == 'tk_potenciacion' or token[0] == 'tk_suma' or token[0] == 'tk_menor_igual' : 
        OPER()
        EXPRE()
    else: pass
def EXPRE3(): 
    if  token[0] == 'id' : 
        IDV()
    elif token[0] == 'tk_numero' : 
        emparejar('tk_numero')
    else: errorSintaxis('EXPRE3')
def AND(): 
    if  token[0] == 'and' : 
        emparejar('and')
        EXPRE()
    elif token[0] == 'or' : 
        emparejar('or')
        EXPRE()
    else: pass
def OPER(): 
    if  token[0] == 'tk_mayor' : 
        emparejar('tk_mayor')
    elif token[0] == 'tk_mayor_igual' : 
        emparejar('tk_mayor_igual')
    elif token[0] == 'tk_menor' : 
        emparejar('tk_menor')
    elif token[0] == 'tk_menor_igual' : 
        emparejar('tk_menor_igual')
    elif token[0] == 'tk_igual_que' : 
        emparejar('tk_igual_que')
    elif token[0] == 'tk_suma' : 
        emparejar('tk_suma')
    elif token[0] == 'tk_resta' : 
        emparejar('tk_resta')
    elif token[0] == 'tk_potenciacion' : 
        emparejar('tk_potenciacion')
    elif token[0] == 'tk_modulo' : 
        emparejar('tk_modulo')
    elif token[0] == 'tk_division' : 
        emparejar('tk_division')
    else: errorSintaxis('OPER')
def ELSE(): 
    if  token[0] == 'sino' : 
        emparejar('sino')
        SIELSE()
        ELSE()
    else: pass
def SIELSE(): 
    if  token[0] == 'si' : 
        emparejar('si')
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        ELSE()
        SENTENCIAS()
    else: errorSintaxis('SIELSE')
def CASO(): 
    if  token[0] == 'caso' : 
        emparejar('caso')
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
        CASO()
    else: pass
def INCREMENTO(): 
    if  token[0] == 'paso' : 
        emparejar('paso')
        EXPRE()
    else: pass
def ARGUMENTOS(): 
    if  token[0] == 'tk_numero' : 
        emparejar('tk_numero')
        ARGUMENTOS2()
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
        ARGUMENTOS2()
    elif token[0] == 'id' : 
        emparejar('id')
        ARGUMENTOS2()
    else: pass
def ARGUMENTOS2(): 
    if  token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        ARGUMENTOS()
    else: pass
def SUBRUTINAS(): 
    if  token[0] == 'subrutina' : 
        emparejar('subrutina')
        emparejar('id')
        emparejar('tk_parentesis_izquierdo')
        REF2()
        emparejar('tk_parentesis_derecho')
        VALOREF()
        SUBRUTINAS()
    else: pass
def REF2(): 
    if  token[0] == 'ref' or token[0] == 'id' : 
        REF()
        EXPRESUB()
        REF2()
    else: pass
def REF(): 
    if  token[0] == 'ref' : 
        emparejar('ref')
    else: pass
def EXPRESUB(): 
    if  token[0] == 'id' : 
        emparejar('id')
        emparejar('tk_dos_puntos')
        RMT()
        EXPRESUB2()
    else: pass
def EXPRESUB2(): 
    if  token[0] == 'tk_punto_y_coma' : 
        emparejar('tk_punto_y_coma')
        EXPRESUB()
    else: pass
def VALOREF(): 
    if  token[0] == 'retorna' : 
        emparejar('retorna')
        TIPODATO()
        ESPECIFICACION()
        emparejar('inicio')
        SENTENCIAS()
        emparejar('retorna')
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        emparejar('fin')
    elif token[0]=='inicio' or  token[0] == 'const' or token[0] == 'var' or token[0] == 'tipos' : 
        REFSUB()
        emparejar('inicio')
        SENTENCIAS()
        emparejar('fin')
    else: errorSintaxis('VALOREF')
def REFSUB(): 
    if  token[0] == 'var' : 
        emparejar('var')
        VAR()
        ESPECIFICACION()
    elif token[0] == 'const' : 
        emparejar('const')
        CONST()
        ESPECIFICACION()
    elif token[0] == 'tipos' : 
        emparejar('tipos')
        TIPOS()
        ESPECIFICACION()
    else: pass
def ID(): 
    if  token[0] == 'id' : 
        emparejar('id')
        ID2()
    else: errorSintaxis('ID')
def ID2(): 
    if  token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        ID()
    else: pass
def IDV(): 
    if  token[0] == 'id' : 
        emparejar('id')
        IDV2()
    else: errorSintaxis('IDV')
def IDV2(): 
    if  token[0] == 'tk_corchete_izquierdo' : 
        emparejar('tk_corchete_izquierdo')
        VECTORDEF()
        emparejar('tk_corchete_derecho')
    else: pass
def VECTORDEF(): 
    if  token[0] == 'tk_numero' : 
        emparejar('tk_numero')
    elif token[0] == 'id' : 
        emparejar('id')
    else: errorSintaxis('VECTORDEF')
tokenList = get_tokens()
token = getNextToken()
INICIO()
if token[0] != '$':
    print('Error sintactico: se esperaba fin')
    exit()

print('El analisis sintactico ha finalizado exitosamente.')