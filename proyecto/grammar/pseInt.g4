grammar pseInt;
start: subproceso proceso;

WS: [ \t\r\n]+ -> skip;
CM: '//' ~('\r' | '\n')* -> skip;

CADENA : ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ;
CARACTER : ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ;
ENTERO : ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ;
LOGICO : ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'G' | 'g' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ;
NUMERICO : ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ;
NUMERO : ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ;
REAL : ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ;
TEXTO : ( 'T' | 't' ) ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'O' | 'o' ) ;
VERDADERO : ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ;
FALSO : ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'O' | 'o' ) ;
PROCESO : ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'O' | 'o' ) ;
ALGORITMO : ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ;
FINPROCESO : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'O' | 'o' ) ;
FINALGORITMO : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ;
SUBPROCESO : ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' ) ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'O' | 'o' ) ;
FUNCION : ( 'F' | 'f' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ;
FINSUBPROCESO : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'U' | 'u' ) ( 'B' | 'b' ) ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'O' | 'o' ) ;
FINFUNCION : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ;
DEFINIR : ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ;
COMO : ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ;
LEER : ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ;
ESCRIBIR : ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'B' | 'b' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ;
DIMENSION : ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ;
SI : ( 'S' | 's' ) ( 'I' | 'i' ) ;
ENTONCES : ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ;
FINSI : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ;
SINO : ( 'S' | 's' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ;
PARA : ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ;
HASTA : ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ;
HACER : ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ;
FINPARA : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ;
CON : ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ;
PASO : ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'O' | 'o' ) ;
MIENTRAS : ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'S' | 's' ) ;
FINMIENTRAS : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'S' | 's' ) ;
REPETIR : ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ;
QUE : ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ;
SEGUN : ( 'S' | 's' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ;
FINSEGUN : ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ;
CASO : ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'O' | 'o' ) ;
DE : ( 'D' | 'd' ) ( 'E' | 'e' ) ;
OTRO : ( 'O' | 'o' ) ( 'T' | 't' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ;
MODO : ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'O' | 'o' ) ;
ESPERAR : ( 'E' | 'e' ) ( 'S' | 's' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ;
TECLA : ( 'T' | 't' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ;
SEGUNDOS : ( 'S' | 's' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'S' | 's' ) ;
SEGUNDO : ( 'S' | 's' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'O' | 'o' ) ;
MILISEGUNDOS : ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'S' | 's' ) ;
PANTALLA : ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ;
BORRAR : ( 'B' | 'b' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ;
LIMPIAR : ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ;

TOKEN_PAR_IZQ: '(';
TOKEN_PAR_DER: ')';
TOKEN_ENTERO: ('0'..'9')+;
TOKEN_REAL: ('0'..'9')+ '.' ('0'..'9')+;

TOKEN_IGUAL: '=';
TOKEN_MAYOR_IGUAL: '>=';
TOKEN_MENOR_IGUAL: '<=';
TOKEN_DIF: '<>';
TOKEN_MAYOR: '>';
TOKEN_MENOR: '<';

TOKEN_O: 'o' | '|';
TOKEN_Y: 'y' | '&';
TOKEN_NO: 'no' | '~';

TOKEN_MOD: 'mod' | '%';
TOKEN_MAS: '+';
TOKEN_MENOS: '-';
TOKEN_MUL: '*';
TOKEN_DIV: '/';
TOKEN_POT: '^';

TOKEN_PYC: ';';
TOKEN_COMA: ',';
TOKEN_COR_DER: ']';
TOKEN_COR_IZQ: '[';
TOKEN_DOSP: ':';

TOKEN_ASIG: '<-';

TOKEN_CADENA: ('"' | '\'') ~('\r' | '\n')* ('"' | '\'');
ID: ('a'..'z' | 'A'..'Z') ('a'..'z' | '_' | '0'..'9' | 'A'..'Z')*;



tipo: CADENA
    | CARACTER
    | ENTERO
    | LOGICO
    | NUMERICO
    | NUMERO
    | REAL
    | TEXTO
    ;

logicvalues: VERDADERO
           | FALSO
           ;

numbervalues: TOKEN_ENTERO
            | TOKEN_REAL
            ;

operrel: TOKEN_IGUAL
       | TOKEN_DIF
       | TOKEN_MAYOR
       | TOKEN_MENOR
       | TOKEN_MAYOR_IGUAL
       | TOKEN_MENOR_IGUAL
       ;

opermas: TOKEN_MAS
       | TOKEN_MENOS
       ;

opermul: TOKEN_MUL
       | TOKEN_DIV
       ;

inicioproceso: PROCESO
             | ALGORITMO
             ;

finproceso: FINPROCESO
          | FINALGORITMO
          ;

iniciosubproceso: SUBPROCESO
                | FUNCION
                ;

finsubproceso: FINSUBPROCESO
             | FINFUNCION
             ;

subproceso: iniciosubproceso ID TOKEN_ASIG ID subparametros comandos finsubproceso subproceso
          | iniciosubproceso ID comandos finsubproceso subproceso
          | iniciosubproceso ID subparametros comandos finsubproceso subproceso
          |
          ;

subparametros: TOKEN_PAR_IZQ ID (TOKEN_COMA ID)* TOKEN_PAR_DER
             | TOKEN_PAR_IZQ TOKEN_PAR_DER
             |
             ;

proceso: inicioproceso ID comandos finproceso;

comandos: comando
        | comandos comando
        |
        ;

comando: definir
       | asignar
       | leer
       | escribir
       | dimension
       | si
       | para
       | mientras
       | repetir
       | segun
       | esperar
       | limpiar
       | func TOKEN_PYC
       ;

definir: DEFINIR listaIds COMO tipo TOKEN_PYC;

listaGen: valor (TOKEN_COMA valor)*
        ;

valor: arit1
     | bool1
     ;

listaMatrix: ID matrix
           | listaMatrix TOKEN_COMA ID matrix
           ;

listaIds: ids (TOKEN_COMA ids)*
        ;

ids: ID
   | ID matrix
   ;

matrix: TOKEN_COR_IZQ listaGen TOKEN_COR_DER;

func: ID TOKEN_PAR_IZQ listaGen TOKEN_PAR_DER
    | ID TOKEN_PAR_IZQ TOKEN_PAR_DER
    ;

asignar: ID TOKEN_ASIG arit1 TOKEN_PYC
       | ID TOKEN_ASIG bool1 TOKEN_PYC
       | ID matrix TOKEN_ASIG arit1 TOKEN_PYC
       | ID matrix TOKEN_ASIG bool1 TOKEN_PYC
       ;


bool1: bool1 TOKEN_O bool2
     | bool2
     ;

bool2: bool2 TOKEN_Y bool3
     | bool3
     ;

bool3: TOKEN_NO bool4
     | bool4
     ;

bool4: arit1 operrel arit1
     | TOKEN_PAR_IZQ bool1 TOKEN_PAR_DER
     | logicvalues
     | ID
     | ID matrix
     | func
     ;

arit1: arit1 TOKEN_MOD arit2
     | arit2
     ;

arit2: arit2 opermas arit3
     | arit3
     ;

arit3: arit3 opermul arit4
     | arit4
     ;

arit4: arit4 TOKEN_POT arit5
     | arit5
     ;

arit5: TOKEN_MENOS arit6
     | arit6
     ;

arit6: ID
     | ID matrix
     | func
     | numbervalues
     | TOKEN_CADENA
     | logicvalues
     | TOKEN_PAR_IZQ arit1 TOKEN_PAR_DER
     ;

leer: LEER listaIds TOKEN_PYC;

escribir: ESCRIBIR listaGen TOKEN_PYC;

dimension: DIMENSION listaMatrix TOKEN_PYC;

si: SI bool1 ENTONCES comandos sino FINSI;

sino: SINO comandos
|
;

para: PARA ID TOKEN_ASIG arit1 HASTA arit1 paso HACER comandos FINPARA;

paso: CON PASO arit1
|
;

mientras: MIENTRAS bool1 HACER comandos FINMIENTRAS;

repetir: REPETIR comandos HASTA QUE bool1;

segun: SEGUN ID HACER casos otro FINSEGUN
     | SEGUN ID matrix HACER casos otro FINSEGUN;

casos: CASO arit1 TOKEN_DOSP comandos casos
     | CASO bool1 TOKEN_DOSP comandos casos
     |
     ;

otro: DE OTRO MODO TOKEN_DOSP comandos
|
;

esperar: ESPERAR evento TOKEN_PYC;

evento: TECLA
| arit1 tiempo;

tiempo: SEGUNDOS
| SEGUNDO
| MILISEGUNDOS;


limpiar: limpieza PANTALLA TOKEN_PYC;

limpieza: BORRAR
| LIMPIAR;