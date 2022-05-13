# Este es un conjunto de palabra reservadas
palabras_reservadas = [
    'and', 'archivo', 'caso', 'const', 'constantes', 'desde', 'eval', 'fin',
    'hasta', 'inicio', 'lib', 'libext', 'matriz', 'mientras', 'not', 'or',
    'paso', 'subrutina', 'programa', 'ref', 'registro', 'repetir', 'retorna', 'si',
    'sino', 'tipos', 'var', 'variables', 'vector', 'numerico', 'imprimir', 'tan', 'logico',
    'TRUE', 'FALSE', 'SI', 'NO', 'leer', 'cadena', 'dim', 'int', 'cos', 'sin', 'cls', 'set_ifs', 
    'abs', 'arctan', 'ascii','dec', 'eof', 'exp', 'get_ifs', 'inc', 'log', 'lower', 'mem',
    'ord', 'paramval', 'pcount', 'pos', 'random', 'sec', 'set_stdin', 'set_stdout', 'sqrt',
    'str', 'strdup', 'strlen', 'substr', 'upper', 'val', 'alen', 'tk_numero', 'tk_cadena', 'id'
]

#Un diccionario para acceder al nombre de cada token especial
tokens_especiales =[    
    "tk_asignacion",
    "tk_cadena",
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
    "tk_numero" ,
    "tk_numero" ,
    "tk_parentesis_derecho" ,
    "tk_parentesis_izquierdo" ,
    "tk_potenciacion" ,
    "tk_punto_y_coma",
    "tk_resta" ,
    "tk_suma" ,
    "id"
]



gramatica = {
    'INICIO':           [['PROG','ESPECIFICACION','inicio','SENTENCIAS','fin','SUBRUTINAS']],
    'PROG':             [['programa','id'],['epsilon']],
    'ESPECIFICACION':   [['var','VAR','ESPECIFICACION'],['const','CONST','ESPECIFICACION'],['tipos','TIPOS','ESPECIFICACION'],['epsilon']],
    'VAR':              [['ID','tk_dos_puntos','RMT','VAR'],['epsilon']],
    'ID':               [['id','ID2']],
    'ID2':              [['tk_coma','ID'],['epsilon']],
    'CONST':            [['id','tk_asignacion','CONST2','CONST'],['epsilon']],
    'CONST2':           [['tk_numero'],['tk_cadena'],['TRUE'],['FALSE'],['SI'],['NO']],
    'RMT':              [['TIPODATO'],['vector','tk_corchete_izquierdo','tk_numero','tk_corchete_derecho','TIPODATO'],
                          ['matriz','tk_corchete_izquierdo','tk_numero','tk_coma','tk_numero','tk_corchete_derecho','TIPODATO'],
                          ['registro','REGISTRO']],
    'TIPODATO':         [['numerico'],['cadena'],['logico']],
    'REGISTRO':         [['tk_llave_izquierda','VAR','tk_llave_derecha']],
    'TIPOS':            [['id','tk_dos_puntos','RMT','TIPOS'],['epsilon']],
    'SENTENCIAS':       [['id','tk_dos_puntos','EXPRE','SENTENCIAS'],
                        ['si','tk_parentesis_izquierdo','EXPRECON','tk_parentesis_derecho','tk_llave_izquierda','SENTENCIAS','ELSE','tk_llave_derecha','SENTENCIAS'],
                        ['mientras', 'tk_parentesis_izquierdo','EXPRE', 'tk_parentesis_derecho', 'tk_llave_izquierda', 'SENTENCIAS', 'tk_parentesis_derecho','SENTENCIAS'],
                        ['repetir', 'SENTENCIAS', 'hasta', 'tk_parentesis_izquierdo', 'EXPRE', 'tk_parentesis_derecho', 'SENTENCIAS'],
                        ['eval', 'tk_llave_izquierda','CASO', 'sino', 'SENTENCIAS', 'tk_llave_derecha', 'SENTENCIAS'],
                        ['desde', 'id', 'tk_asignacion', 'tk_numero', 'hasta', 'HASTA', 'INCREMENTO', 'tk_lleva_izquierda', 'SENTENCIAS','tk_llave_derecha', 'SENTENCIAS'],
                        ['id','tk_parentesis_izquierdo','ARGUMENTOS','tk_parentesis_derecho','SENTENCIAS'],
                        ['epsilon']],
    'EXPRE':            [['EXPRE','OPER','EXPRE','AND'],['tk_parentesis_izquierdo','EXPRE','tk_parentesis_derecho'],['tk_numero'],['tk_cadena'],['id']],
    'AND':              [['and','EXPRE'],['or','EXPRE'],['epsilon']],
    'OPER':             [['tk_mayor'],["tk_mayor_igual"],["tk_menor"],["tk_menor_igual"],["tk_igual_que"]],
    'ARGUMENTOS':       [[]],


}
