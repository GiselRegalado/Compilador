import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
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


/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Número */
Numero = -?[1-9][0-9]*.[[0-9]*[1-9]]?[e|E][-|+][1-9][0-9]* | -?[1-9][0-9]*[e|E][-|+][1-9][0-9]* | -?[1-9][0-9]*.[0-9]*[1-9] | -?[1-9][0-9]* | 0.0 | 0

/* Literal Cadena */
Cadena = "\"" [^\"]* "\""

/* Literal Caracter */
Caracter = "'" [^'\n\\'] "'"

/*Palabras reservadas*/
ReservadasP= programa|metodo|si|sino|hacer|mientras|para|verdadero|falso|mensaje|lectura|llamar

/*Tipos de Datos*/
ReservadasD= Entero|Cadena|Flotante|Doble|Boleano|Caracter

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
Identificador = {Letra}({Letra}|{Digito})*

CaracterE = "'" [^'\n\\']* "'"

%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(146, 146, 146)); }

/* Literal Cadena */
{Cadena} { return textColor(yychar, yylength(), new Color(55, 225, 55)); }

/* Literal Caracter */
{Caracter} { return textColor(yychar, yylength(), new Color(55, 225, 55)); }

/* e */
{CaracterE} { return textColor(yychar, yylength(), new Color(55, 225, 55)); }

/* Reservadas */
{ReservadasP} { return textColor(yychar, yylength(), new Color(200, 100, 20)); }

/* Tipo de Dato */
{ReservadasD} { return textColor(yychar, yylength(), new Color(200, 100, 20)); }

/* Identificador */
{Identificador} { return textColor(yychar, yylength(), new Color(0, 100, 200)); }

/* Numero */
{Numero} { return textColor(yychar, yylength(), new Color(100, 0, 200)); }

/* b */
{EspacioEnBlanco} { /*Ignorar*/ }
. { /* Ignorar */ }

/* E */
{Numero}{Identificador} { /*Ignorar*/ }
{Numero}{ReservadasP} { /*Ignorar*/ }
{Numero}{ReservadasD} { /*Ignorar*/ }

