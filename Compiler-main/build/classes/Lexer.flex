import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}

/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Número */
Numero = -?[1-9][0-9]*.[[0-9]*[1-9]]?[e|E][-|+][1-9][0-9]* | -?[1-9][0-9]*[e|E][-|+][1-9][0-9]* | -?[1-9][0-9]*.[0-9]*[1-9] | -?[1-9][0-9]* | 0.0 | 0

/* Literal Caracter */
Caracter = "'" [^'\n\\'] "'"

/*Tipos de Datos*/
int= int
float= float
char= char

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

CaracterE = "'" [^'\n\\']* "'"
%%


/* Comentarios o espacios en blanco */
{EspacioEnBlanco} { /*Ignorar*/ }

/* Literal Caracter */
{Caracter} { return token(yytext(), "id", yyline, yycolumn);}

/* Tipos de dato */
{int} {return token(yytext(), "int", yyline, yycolumn);}
{float} {return token(yytext(), "float", yyline, yycolumn);}
{char} {return token(yytext(), "char", yyline, yycolumn);}

/* Identificador */
{Identificador} { return token(yytext(), "id", yyline, yycolumn);}

/* Numeros */
{Numero} { return token(yytext(), "num", yyline, yycolumn);}

/* c */
\( { return token(yytext(), "(", yyline, yycolumn); }
\) { return token(yytext(), ")", yyline, yycolumn); }
\, { return token(yytext(), ",", yyline, yycolumn); }
\; { return token(yytext(), ";", yyline, yycolumn); }
\= { return token(yytext(), "=", yyline, yycolumn); }

[+] { return token(yytext(), "+", yyline, yycolumn); }
[-] { return token(yytext(), "-", yyline, yycolumn); }
[*] { return token(yytext(), "*", yyline, yycolumn); }
[/] { return token(yytext(), "/", yyline, yycolumn); }

. { return token(yytext(), "ERROR", yyline, yycolumn); }
{Numero}{Identificador} { return token(yytext(), "ERROR", yyline, yycolumn); }

/* caracter de error */
{CaracterE} { return token(yytext(), "ERROR", yyline, yycolumn);}

