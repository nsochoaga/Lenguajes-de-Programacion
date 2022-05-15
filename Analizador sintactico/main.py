from analizador_lexico import get_tokens
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
        return '$'
    else: return tokenList.pop(0)

def errorSintaxis(regla): 
    if regla in palabras_reservadas or regla in tokens_especiales:
        print(f'error se esperaba {regla }')
    else:
        return prediccion[regla]
def INICIO(): 
    if  token[0] == 'var' or token[0] == 'programa' or token[0] == 'inicio' or token[0] == 'const' or token[0] == 'tipos' : 
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
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('PROG')
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
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('ESPECIFICACION')
def VAR(): 
    if  token[0] == 'tk_dos_puntos' or token[0] == 'id' : 
        ID()
        emparejar('tk_dos_puntos')
        RMT()
        VAR()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('VAR')
def ID(): 
    if  token[0] == 'id' : 
        emparejar('id')
        ID2()
    else: errorSintaxis('ID')
def ID2(): 
    if  token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        ID()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('ID2')
def CONST(): 
    if  token[0] == 'id' : 
        emparejar('id')
        emparejar('tk_asignacion')
        CONST2()
        CONST()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('CONST')
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
    if  token[0] == 'numerico' or token[0] == 'cadena' or token[0] == 'logico' : 
        TIPODATO()
    elif token[0] == 'vector' : 
        emparejar('vector')
        emparejar('tk_corchete_izquierdo')
        emparejar('tk_numero')
        emparejar('tk_corchete_derecho')
        TIPODATO()
    elif token[0] == 'matriz' : 
        emparejar('matriz')
        emparejar('tk_corchete_izquierdo')
        emparejar('tk_numero')
        emparejar('tk_coma')
        emparejar('tk_numero')
        emparejar('tk_corchete_derecho')
        TIPODATO()
    elif token[0] == 'registro' : 
        emparejar('registro')
        REGISTRO()
    else: errorSintaxis('RMT')
def TIPODATO(): 
    if  token[0] == 'numerico' : 
        emparejar('numerico')
    elif token[0] == 'cadena' : 
        emparejar('cadena')
    elif token[0] == 'logico' : 
        emparejar('logico')
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
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('TIPOS')
def SENTENCIAS(): 
    if  token[0] == 'id' : 
        emparejar('id')
        ASIGID()
        EXPRE()
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
        emparejar('tk_parentesis_derecho')
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
    elif token[0] == 'id' : 
        emparejar('id')
        ASIGID()
        EXPRE()
        SENTENCIAS()
    elif token[0] == 'imprimir' : 
        emparejar('imprimir')
        emparejar('tk_parentesis_izquierdo')
        emparejar('tk_cadena')
        emparejar('tk_coma')
        emparejar('tk_cadena')
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
    elif token[0] == 'leer' : 
        emparejar('leer')
        emparejar('tk_parentesis_izquierdo')
        emparejar('id')
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('SENTENCIAS')
def ASIGID(): 
    if  token[0] == 'tk_dos_puntos' : 
        emparejar('tk_dos_puntos')
    elif token[0] == 'tk_asignacion' : 
        emparejar('tk_asignacion')
    else: errorSintaxis('ASIGID')
def EXPRE(): 
    if  token[0] == 'tk_igual_que' or token[0] == 'or' or token[0] == 'tk_suma' or token[0] == 'tk_menor_igual' or token[0] == 'tk_menor' or token[0] == 'tk_division' or token[0] == 'and' or token[0] == 'tk_mayor' or token[0] == 'tk_modulo' or token[0] == 'tk_mayor_igual' or token[0] == 'tk_potenciacion' or token[0] == 'tk_resta' : 
        EXPRE()
        OPER()
        EXPRE()
        AND()
    elif token[0] == 'tk_parentesis_izquierdo' : 
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
    elif token[0] == 'tk_numero' : 
        emparejar('tk_numero')
    elif token[0] == 'tk_cadena' : 
        emparejar('tk_cadena')
    elif token[0] == 'id' : 
        emparejar('id')
    else: errorSintaxis('EXPRE')
def AND(): 
    if  token[0] == 'and' : 
        emparejar('and')
        EXPRE()
    elif token[0] == 'or' : 
        emparejar('or')
        EXPRE()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('AND')
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
        SENTENCIAS()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('ELSE')
def CASO(): 
    if  token[0] == 'caso' : 
        emparejar('caso')
        emparejar('tk_parentesis_izquierdo')
        EXPRE()
        emparejar('tk_parentesis_derecho')
        SENTENCIAS()
        CASO()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('CASO')
def INCREMENTO(): 
    if  token[0] == 'paso' : 
        emparejar('paso')
        EXPRE()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('INCREMENTO')
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
    else: errorSintaxis('ARGUMENTOS')
def ARGUMENTOS2(): 
    if  token[0] == 'tk_coma' : 
        emparejar('tk_coma')
        ARGUMENTOS()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('ARGUMENTOS2')
def SUBRUTINAS(): 
    if  token[0] == 'subrutina' : 
        emparejar('subrutina')
        emparejar('id')
        emparejar('tk_parentesis_izquierdo')
        REF()
        EXPRESUB()
        emparejar('tk_parentesis_derecho')
        VALOREF()
        SUBRUTINAS()
    else: errorSintaxis('SUBRUTINAS')
def REF(): 
    if  token[0] == 'ref' : 
        emparejar('ref')
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('REF')
def EXPRESUB(): 
    if  token[0] == 'tk_dos_puntos' : 
        ID()
        emparejar('tk_dos_puntos')
        TIPODATO()
        EXPRESUB2()
    else: errorSintaxis('EXPRESUB')
def EXPRESUB2(): 
    if  token[0] == 'tk_punto_y_coma' : 
        emparejar('tk_punto_y_coma')
        EXPRESUB()
    elif token[0] == 'epsilon' : 
        pass 
    else: errorSintaxis('EXPRESUB2')
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
    elif token[0] == 'inicio' : 
        ESPECIFICACION()
        emparejar('inicio')
        SENTENCIAS()
        emparejar('fin')
    else: errorSintaxis('VALOREF')
tokenList = get_tokens()
token = getNextToken()
INICIO()
if token[0] != '$':
    print('Error sintactico: se esperaba fin')
    exit()

print('El analisis sintactico ha finalizado exitosamente.')