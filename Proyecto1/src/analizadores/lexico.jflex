package analizadores;
import java_cup.runtime.Symbol;

%%

%class lexico
%public
%line
%char
%cup
%unicode
%ignorecase

%init{
    yyline = 1;
    yychar = 1;
%init}

BLANCOS=[ \r\t]+
D=[0-9]+
DD=[0-9]+("."[ |0-9]+)?
CADENA = [\"]([^\"\n]|(\\\"))*[\"]
ID=[A-Za-z]+["_"0-9A-za-z]*

%%

"definirglobales"                      {return new Symbol(sym.definirglobales, yyline, yychar, yytext());}
"generarreporteestadistico"            {return new Symbol(sym.genreport, yyline, yychar, yytext());}
"{"                                    {return new Symbol(sym.obracket, yyline, yychar, yytext());}
"}"                                    {return new Symbol(sym.cbracket, yyline, yychar, yytext());}
"##"                                   {return new Symbol(sym.comment, yyline, yychar, yytext());}
"#*"                                   {return new Symbol(sym.ocomment, yyline, yychar, yytext());}
"*#"                                   {return new Symbol(sym.ccomment, yyline, yychar, yytext());}
";"                                    {return new Symbol(sym.semicolon, yyline, yychar, yytext());}
":"                                    {return new Symbol(sym.colon, yyline, yychar, yytext());}
"("                                    {return new Symbol(sym.oparent, yyline, yychar, yytext());}
")"                                    {return new Symbol(sym.cparent, yyline, yychar, yytext());}
"compare"                              {return new Symbol(sym.compare, yyline, yychar, yytext());}
","                                    {return new Symbol(sym.comma, yyline, yychar, yytext());}
"graficabarras"                        {return new Symbol(sym.graficabarras, yyline, yychar, yytext());}
"["                                    {return new Symbol(sym.osbracket, yyline, yychar, yytext());}
"]"                                    {return new Symbol(sym.csbracket, yyline, yychar, yytext());}
"titulo"                               {return new Symbol(sym.titulo, yyline, yychar, yytext());}
"ejex"                                 {return new Symbol(sym.ejex, yyline, yychar, yytext());}
"valores"                              {return new Symbol(sym.valores, yyline, yychar, yytext());}
"$"                                    {return new Symbol(sym.dollar, yyline, yychar, yytext());}
"puntajeespecifico"                    {return new Symbol(sym.puntajeespecifico, yyline, yychar, yytext());}
"titulox"                              {return new Symbol(sym.titulox, yyline, yychar, yytext());}
"tituloy"                              {return new Symbol(sym.tituloy, yyline, yychar, yytext());}
"graficapie"                           {return new Symbol(sym.graficapie, yyline, yychar, yytext());}
"graficalineas"                        {return new Symbol(sym.graficalineas, yyline, yychar, yytext());}
"="                                    {return new Symbol(sym.equal, yyline, yychar, yytext());}
"string"                               {return new Symbol(sym.idstring, yyline, yychar, yytext());}
"double"                               {return new Symbol(sym.iddouble, yyline, yychar, yytext());}

\n                                     {yychar = 1;}

{BLANCOS}                              {}
{D}                                    {return new Symbol(sym.integerr, yyline, yychar, yytext());}
{DD}                                   {return new Symbol(sym.doublee, yyline, yychar, yytext());}
{CADENA}                               {return new Symbol(sym.stringg, yyline, yychar, yytext());}
{ID}                                   {return new Symbol(sym.id, yyline, yychar, yytext());}



. {
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
}