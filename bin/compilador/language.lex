package compilador;
import java_cup.runtime.Symbol;

%%

%cup
%public
%class Lexer
%line
%column
%ignorecase

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
{DEF}						 { imprimir("function def", 			yytext()); return new Symbol(Sym.DEF, new Token( yytext() ));}	
{IF}                         { imprimir("if statement", 			yytext()); return new Symbol(Sym.IF, new Token( yytext() ));}
{ELSE}						 { imprimir("else statement", 			yytext()); return new Symbol(Sym.ELSE, new Token( yytext() ));}
{THEN}                       { imprimir("then statement", 			yytext()); return new Symbol(Sym.THEN, new Token( yytext() ));}

{SUM}                        { imprimir("sum operator", 			yytext()); return new Symbol(Sym.SUM, new Token( yytext() ));}
{MINUS}                      { imprimir("minus operator", 			yytext()); return new Symbol(Sym.MINUS, new Token( yytext() ));}
{MULTIPLICATION}             { imprimir("multiplication operator", 	yytext()); return new Symbol(Sym.MULTIPLICATION, new Token( yytext() ));}
{DIVISION}                   { imprimir("division operator", 		yytext()); return new Symbol(Sym.DIVISION, new Token( yytext() ));}

{OPEN}						 { imprimir("open parenthesis",			yytext()); return new Symbol(Sym.OPEN, new Token( yytext() ));}
{CLOSE}					 	 { imprimir("close parenthesis",		yytext()); return new Symbol(Sym.CLOSE, new Token( yytext() ));}
{EQUAL}						 { imprimir("equal sign",				yytext()); return new Symbol(Sym.EQUAL, new Token( yytext() ));}
{ENDSTATEMENT}				 { imprimir("end-statement sign",		yytext()); return new Symbol(Sym.ENDSTMT, new Token( yytext() ));}
{COMMA}						 { imprimir("comma sign",				yytext()); return new Symbol(Sym.COMMA, new Token( yytext() ));}
{GREATERTHAN}				 { imprimir("greater than",				yytext()); return new Symbol(Sym.GREATERTHAN, new Token( yytext() ));}
{LESSTHAN}					 { imprimir("less than",				yytext()); return new Symbol(Sym.LESSTHAN, new Token( yytext() ));}

{BLANK}                      {  }
{ID}                         { imprimir("identificator", 			yytext()); return new Symbol(Sym.ID, new Token( yytext() )); }
{INTEGER}                    { imprimir("integer", 					yytext()); return new Symbol(Sym.INTEGER, new Token( yytext() ) );}


. { throw new RuntimeException("Caractere inválido " + yytext() ); }
 
 
 
 
 
 
 