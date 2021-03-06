# Este es un conjunto de palabra reservadas
palabras_reservadas = [
    'and', 'archivo', 'caso', 'const', 'constantes', 'desde', 'eval', 'fin',
    'hasta', 'inicio', 'lib', 'libext', 'matriz', 'mientras', 'not', 'or',
    'paso', 'subrutina', 'programa', 'ref', 'registro', 'repetir', 'retorna', 'si',
    'sino', 'tipos', 'var', 'variables', 'vector', 'numerico', 'imprimir', 'tan', 'logico',
    'TRUE', 'FALSE', 'SI', 'NO', 'leer', 'cadena', 'dim', 'int', 'cos', 'sin', 'cls', 'set_ifs', 
    'abs', 'arctan', 'ascii','dec', 'eof', 'exp', 'get_ifs', 'inc', 'log', 'lower', 'mem',
    'ord', 'paramval', 'pcount', 'pos', 'random', 'sec', 'set_stdin', 'set_stdout', 'sqrt',
    'str', 'strdup', 'strlen', 'substr', 'upper', 'val', 'alen', 'tk_numero', 'tk_cadena', 'id','tk_numero',
    "tk_cadena"
]

#Un diccionario para acceder al nombre de cada token especial
tokens_especiales =[    
    "tk_asignacion",
    "tk_coma" ,
    "tk_corchete_derecho",
    "tk_corchete_izquierdo" ,
    "tk_distinto_de" ,
    "tk_division",
    "tk_dos_puntos" ,
    "tk_igual_que" ,
    'tk_llave_izquierda',
    'tk_llave_derecha',
    "tk_mayor" ,
    "tk_mayor_igual",
    "tk_menor" , 
    "tk_menor_igual" ,
    "tk_modulo" ,
    "tk_multiplicacion",
    "tk_parentesis_derecho" ,
    "tk_parentesis_izquierdo" ,
    "tk_potenciacion" ,
    "tk_punto_y_coma",
    "tk_resta" ,
    "tk_suma" 
    
]



gramatica = {
    'INICIO':           [['PROG','ESPECIFICACION','inicio','SENTENCIAS','fin','SUBRUTINAS']],
    'PROG':             [['programa','id'],['epsilon']],
    'ESPECIFICACION':   [['var','VAR','ESPECIFICACION'],['const','CONST','ESPECIFICACION'],['tipos','TIPOS','ESPECIFICACION'],['epsilon']],
    'VAR':              [['ID','tk_dos_puntos','RMT','PC','VAR'],['epsilon']],
    'CONST':            [['id','tk_asignacion','CONST2','PC','CONST'],['epsilon']],
    'CONST2':           [['tk_numero'],['tk_cadena'],['TRUE'],['FALSE'],['SI'],['NO']],
    'RMT':              [['TIPODATO'],
                        ['vector','tk_corchete_izquierdo','VECTOR2','tk_corchete_derecho','TIPODATO'],
                        ['matriz','tk_corchete_izquierdo','MATRIZ','tk_corchete_derecho','TIPODATO'],
                        ['registro','REGISTRO']],
    'VECTOR2':          [['tk_numero'],['id'],['tk_multiplicacion']],
    'MATRIZ':          [['tk_numero','MATRIZ2'],['tk_multiplicacion','MATRIZ2']],
    'MATRIZ2':          [['tk_coma','MATRIZ'],['epsilon']],
    'TIPODATO':         [['numerico'],['cadena'],['logico'],['id']],
    'REGISTRO':         [['tk_llave_izquierda','VAR','tk_llave_derecha']],
    'TIPOS':            [['id','tk_dos_puntos','RMT','TIPOS'],['epsilon']],
    'PC':               [['tk_punto_y_coma'],['epsilon']],
    'SENTENCIAS':       [['id','IDSENTENCIA','PC','SENTENCIAS',],
                        ['si','tk_parentesis_izquierdo','EXPRE','tk_parentesis_derecho','tk_llave_izquierda','SENTENCIAS','ELSE','tk_llave_derecha','SENTENCIAS'],
                        ['mientras', 'tk_parentesis_izquierdo','EXPRE', 'tk_parentesis_derecho', 'tk_llave_izquierda', 'SENTENCIAS', 'tk_llave_derecha','SENTENCIAS'],
                        ['repetir', 'SENTENCIAS', 'hasta', 'tk_parentesis_izquierdo', 'EXPRE', 'tk_parentesis_derecho', 'SENTENCIAS'],
                        ['eval', 'tk_llave_izquierda','CASO', 'sino', 'SENTENCIAS', 'tk_llave_derecha', 'SENTENCIAS'],
                        ['desde', 'id', 'tk_asignacion', 'EXPRE', 'hasta', 'EXPRE', 'INCREMENTO', 'tk_llave_izquierda', 'SENTENCIAS','tk_llave_derecha', 'SENTENCIAS'],
                        ['imprimir','tk_parentesis_izquierdo','IMPRIMIR','tk_parentesis_derecho','SENTENCIAS'],
                        ['leer','tk_parentesis_izquierdo','LEER','tk_parentesis_derecho','SENTENCIAS'],
                        ['dim','tk_parentesis_izquierdo','LEER','tk_parentesis_derecho','SENTENCIAS'],
                        ['cls','tk_parentesis_izquierdo','tk_parentesis_derecho','SENTENCIAS'],
                        ['epsilon']],
    'IDSENTENCIA':      [['ASIGID','INT'],['tk_parentesis_izquierdo','ARGUMENTOS','tk_parentesis_derecho']],
    'INT':              [['int','EXPRE'],['EXPRE']],
    'LEER':             [['id','LEER2'],['tk_cadena']],
    'LEER2':            [['tk_corchete_izquierdo','LEER3','tk_corchete_derecho'],['tk_coma','LEER'],['epsilon']],
    'LEER3':            [['id'],['tk_numero']],
    'IMPRIMIR':         [['IDV','IMPRIMIR2'],['tk_numero','IMPRIMIR2'],['tk_cadena','IMPRIMIR2']],
    'IMPRIMIR2':        [['tk_coma','IMPRIMIR'],['epsilon']],
    'ASIGID':           [['tk_dos_puntos'],['tk_asignacion']],
    'EXPRE':            [['tk_parentesis_izquierdo','EXPRE','tk_parentesis_derecho','LOGIC'],['tk_numero','EXPRE2'],['tk_cadena'],['IDV','EXPRE2'],
                        ['tk_llave_izquierda','LISTA','tk_llave_derecha'],['alen','tk_parentesis_izquierdo','id','tk_parentesis_derecho']],
    'LOGIC':            [['or','EXPRE'],['and','EXPRE'],['epsilon']],
    'LISTA':            [['tk_numero','LISTA2'],['tk_cadena','LISTA2'],['tk_llave_izquierda','LISTA3','tk_llave_derecha','LISTA2']],
    'LISTA3':           [['tk_numero','LISTA2'],['tk_cadena','LISTA2'],['epsilon']],
    'LISTA2':           [['tk_coma','LISTA'],['epsilon']],
    'EXPRE2':           [['tk_suma','EXPRE3'],['tk_multiplicacion','EXPRE3'],['OPER','EXPRE'],['epsilon']],
    'EXPRE3':           [['IDV'],['tk_numero']],
    'OPER':             [['tk_mayor'],["tk_mayor_igual"],["tk_menor"],["tk_menor_igual"],["tk_igual_que"],['tk_suma'],["tk_resta" ],["tk_potenciacion"],
                            ["tk_modulo"],["tk_division"]],
    'ELSE':             [['sino','SIELSE','ELSE'],['epsilon']],
    'SIELSE':           [['si','tk_parentesis_izquierdo','EXPRE','tk_parentesis_derecho','ELSE','SENTENCIAS'],['SENTENCIAS']],
    'CASO':             [['caso','tk_parentesis_izquierdo','EXPRE','AND','tk_parentesis_derecho', 'SENTENCIAS', 'CASO'],['epsilon']],
    'AND':              [['and','EXPRE'],['epsilon']],
    'INCREMENTO':       [['paso','NEGATIVO','EXPRE'],['epsilon']],
    'NEGATIVO':         [['tk_resta'],['epsilon']],
    'ARGUMENTOS':       [['tk_numero','ARGUMENTOS2'],['tk_cadena','ARGUMENTOS2'],['id','ARGUMENTOS2'],['epsilon']],
    'ARGUMENTOS2':      [['tk_coma','ARGUMENTOS'],['epsilon']],
    'SUBRUTINAS':       [['subrutina','id', 'tk_parentesis_izquierdo','REF2','tk_parentesis_derecho', 'VALOREF','SUBRUTINAS'],
                        ['epsilon']],
    'REF2':             [['REF','EXPRESUB','REF2'],['epsilon']],
    'REF':              [['ref'],['epsilon']],
     
    'EXPRESUB':         [['ID','tk_dos_puntos','RMT','EXPRESUB2'],['epsilon']],
    'EXPRESUB2':        [['tk_punto_y_coma','EXPRESUB'],['epsilon']],
    'VALOREF':          [['retorna','TIPODATO','ESPECIFICACION','inicio','SENTENCIAS','retorna','tk_parentesis_izquierdo','EXPRE','tk_parentesis_derecho','fin'],
                        ['REFSUB','inicio','SENTENCIAS','fin']],
    'REFSUB':           [['var','VAR','ESPECIFICACION'],['const','CONST','ESPECIFICACION'],['tipos','TIPOS','ESPECIFICACION'],['epsilon']],
    'ID':               [['id','ID2']],
    'ID2':              [['tk_coma','ID'],['epsilon']],
    'IDV':              [['id','IDV2'],['ascii','IDV2']],
    'IDV2':             [['tk_parentesis_izquierdo','VECTORDEF','tk_parentesis_derecho'],['tk_corchete_izquierdo','VECTORDEF','tk_corchete_derecho'],['tk_potenciacion','VECTORDEF'], ['epsilon']],
    'VECTORDEF':        [['tk_numero'],['id'],]
}