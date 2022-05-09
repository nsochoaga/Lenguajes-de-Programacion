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
tokens_especiales = {
    '=' : 'tk_asignacion',          ',': 'tk_coma',                  ']' : 'tk_corchete_derecho',
    '[' : 'tk_corchete_izquierdo',  '<>' : 'tk_distinto_de',         '/' : 'tk_division',
    ':' : 'tk_dos_puntos',          '==': 'tk_igual_que',            '}' : 'tk_llave_derecha',
    '{' : 'tk_llave_izquierda',     '>' : 'tk_mayor',                '>=' : 'tk_mayor_igual',
    '<' : 'tk_menor',               '<=' : 'tk_menor_igual',         '%' : 'tk_modulo',           '*': 'tk_multiplicacion',
    ')' : 'tk_parentesis_derecho',  '(' : 'tk_parentesis_izquierdo', '^' : 'tk_potenciacion',
    '.' : 'tk_punto',               ';' : 'tk_punto_y_coma',         '-' : 'tk_resta',            '+' : 'tk_suma'
    }



gramatica = {
    'primera':      [['var','segunda'], ['const', 'segunda']],
    'segunda':      ['id','tercera'],
    'tercera':      [['tk_coma', 'segunda'], ['tk_asignacion', 'cuarta']],
    'cuarta' :      [['tk_numero','tk_punto_y_coma','primerbloque'], ['tk_cadena','tk_punto_y_coma','primerbloque']],
    'primerbloque': [['primera'], ['inicio','bloque2']],
    'bloque2-1':    [['imprimir','tk_parentesis_izquierdo','bloque2-2']],
    'bloque2-2' :   [['tk_cadena', 'tk_parentesis_derecho'], ['id','tk_parentesis_derecho'],['tk_numero']], 
    'bloque2-fin':  [['fin']]
}

indices = []