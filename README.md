#Trabalho da disciplina de Compiladores

##Compilador para a seguinte gramática:
```
    P → id '=' int ; P | I
    I → D ';' I | D
    D → def id '('ARGS')' '=' E';'
    ARGS → id', ' ARGS | id
    SEQ → E| SEQ ',' E
    E → int | id | if E opRel E then E else E
    | E opArit E | id'(' SEQ ')'
```

##Exemplo de código:
```
    a = 312;
    b = 111;
    def mdc(a,b) =
        if mod(a,b) = 0 then b
        else mdc(b,mod(a,b));
    def mod(a,b) =
        if a < b then a
        else mod(a-b,b)
```

###Como gerar o analisador léxico:
```
    java -jar jflex-1.6.1.jar src/compilador/language.lex
```

###Como gerar o analisador sintático:
```
    java -jar java-cup-11a.jar -parser Parser -symbols Sym src/compilador/language.cup
```
