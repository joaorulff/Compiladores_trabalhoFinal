package compilador;
import java_cup.runtime.Symbol;

%%

%public
%class Lexer
%type void

%{

private void imprimir(String descricao, String lexema) {
    System.out.println(lexema + " - " + descricao);
}

%}


BLANK = [\n| |\t|\r]
ID = [_|a-z|A-Z][a-z|A-Z|0-9|_]*
INTEGER = 0|[1-9][0-9]*

SUM = "+"
MINUS = "-"
MULTIPLICATION = "*"
DIVISION = "/"

OPEN = "("
CLOSE = ")"
EQUAL = "="
ENDSTATEMENT = ";"
COMMA = ","
GREATERTHAN = ">"
LESSTHAN = "<"
EQUALITY = "=="

DEF = "def"
IF = "if"
ELSE = "else"
THEN = "then"
TRUE = "true"
FALSE = "false"

%%
{DEF}						 { imprimir("function def", 			yytext());}	
{IF}                         { imprimir("if statement", 			yytext());}
{ELSE}						 { imprimir("else statement", 			yytext());}
{THEN}                       { imprimir("then statement", 			yytext());}
{TRUE}						 { imprimir("false variable", 			yytext());}	
{FALSE}                      { imprimir("true variable", 			yytext());}

{SUM}                        { imprimir("sum operator", 			yytext());}
{MINUS}                      { imprimir("minus operator", 			yytext());}
{MULTIPLICATION}             { imprimir("multiplication operator", 	yytext());}
{DIVISION}                   { imprimir("division operator", 		yytext());}

{OPEN}						 { imprimir("open parenthesis",			yytext());}
{CLOSE}					 	 { imprimir("close parenthesis",		yytext());}
{EQUAL}						 { imprimir("equal sign",				yytext());}
{ENDSTATEMENT}				 { imprimir("end-statement sign",		yytext());}
{COMMA}						 { imprimir("comma sign",				yytext());}
{GREATERTHAN}				 { imprimir("greater than",				yytext());}
{LESSTHAN}					 { imprimir("less than",				yytext());}
{EQUALITY}					 { imprimir("equality",					yytext());}

{BLANK}                      { }
{ID}                         { imprimir("identificator", 			yytext());}
{INTEGER}                    { imprimir("integer", 					yytext());}




. { throw new RuntimeException("Caractere inválido " + yytext()); }