package compilador;
import java_cup.runtime.Symbol;

%%

%cup
%public
%class Lexer
%line
%column
%ignorecase

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

DEF = "def"
IF = "if"
ELSE = "else"
THEN = "then"

%%
{DEF}						 { return new Symbol(Sym.DEF, new Token( yytext() ));}	
{IF}                         { return new Symbol(Sym.IF, new Token( yytext() ));}
{ELSE}						 { return new Symbol(Sym.ELSE, new Token( yytext() ));}
{THEN}                       { return new Symbol(Sym.THEN, new Token( yytext() ));}

{SUM}                        { return new Symbol(Sym.SUM, new Token( yytext() ));}
{MINUS}                      { return new Symbol(Sym.MINUS, new Token( yytext() ));}
{MULTIPLICATION}             { return new Symbol(Sym.MULTIPLICATION, new Token( yytext() ));}
{DIVISION}                   { return new Symbol(Sym.DIVISION, new Token( yytext() ));}

{OPEN}						 { return new Symbol(Sym.OPEN, new Token( yytext() ));}
{CLOSE}					 	 { return new Symbol(Sym.CLOSE, new Token( yytext() ));}
{EQUAL}						 { return new Symbol(Sym.EQUAL, new Token( yytext() ));}
{ENDSTATEMENT}				 { return new Symbol(Sym.ENDSTMT, new Token( yytext() ));}
{COMMA}						 { return new Symbol(Sym.COMMA, new Token( yytext() ));}
{GREATERTHAN}				 { return new Symbol(Sym.GREATERTHAN, new Token( yytext() ));}
{LESSTHAN}					 { return new Symbol(Sym.LESSTHAN, new Token( yytext() ));}

{BLANK}                      {  }
{ID}                         { return new Symbol(Sym.ID, new Token( yytext() )); }
{INTEGER}                    { return new Symbol(Sym.INTEGER, new Token( yytext() ) );}


. { throw new RuntimeException("Caracter invalido " + yytext() ); }
 
 
 
 
 
 
 