package compilador;
import java_cup.runtime.Symbol;

%%

%cup
%cupdebug
%cupsym Sym
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

%%
{DEF}               { imprimir("function def",yytext()); return new Symbol(Sym.DEF);}	
{IF}                { imprimir("if statement",yytext()); return new Symbol(Sym.IF);}
{ELSE}              { imprimir("else statement",yytext()); return new Symbol(Sym.ELSE);}
{THEN}              { imprimir("then statement",yytext()); return new Symbol(Sym.THEN);}

{SUM}               { imprimir("sum operator",yytext()); return new Symbol(Sym.SUM);}
{MINUS}             { imprimir("minus operator",yytext()); return new Symbol(Sym.MINUS);}
{MULTIPLICATION}    { imprimir("multiplication operator",yytext()); return new Symbol(Sym.MULTIPLICATION);}
{DIVISION}          { imprimir("division operator",yytext()); return new Symbol(Sym.DIVISION);}

{OPEN}              { imprimir("open parenthesis",yytext()); return new Symbol(Sym.OPEN);}
{CLOSE}             { imprimir("close parenthesis",yytext()); return new Symbol(Sym.CLOSE);}
{EQUAL}             { imprimir("equal sign",yytext()); return new Symbol(Sym.EQUAL);}
{ENDSTATEMENT}      { imprimir("end-statement sign",yytext()); return new Symbol(Sym.ENDSTMT);}
{COMMA}             { imprimir("comma sign",yytext()); return new Symbol(Sym.COMMA);}
{GREATERTHAN}       { imprimir("greater than",yytext()); return new Symbol(Sym.GREATERTHAN);}
{LESSTHAN}          { imprimir("less than",yytext()); return new Symbol(Sym.LESSTHAN);}
{EQUALITY}          { imprimir("equality",yytext()); return new Symbol(Sym.EQUALITY);}

{BLANK}             { 	}
{ID}                { imprimir("identificator",yytext()); return new Symbol(Sym.ID); }
{INTEGER}           { imprimir("integer",yytext()); return new Symbol(Sym.INTEGER);}

/* error fallback */
[^]                 { throw new RuntimeException("Caractere invalido " + yytext() + " na linha " + (yyline+1) + ", coluna " +(yycolumn+1)); }
