package analizadoresjs;
import java_cup.runtime.Symbol;

%%

%class lexicojs
%public
%line
%char
%cup
%unicode

%init{
    yyline = 1;
    yychar = 1;
%init}

BLANCOS=[ \r\t]+
D=[0-9]+
DD=[0-9]+("."[ |0-9]+)?
CADENA = [\"](\s*[^\"\n]|(\\\"))*[\"]
CARACTERES = [\'](\s*[^\"\n]|(\\\"))*[\']
COMENTARIOMULT = (\/\*(\s*|.*)*\*\/)
COMENTARIO = \/\/.*
ID=[A-Za-z]+["_"0-9A-Za-z]*

%%

"class"                                {return new Symbol(sym.classes, yyline, yychar, yytext());}
"{"                                    {return new Symbol(sym.obracket, yyline, yychar, yytext());}
"}"                                    {return new Symbol(sym.cbracket, yyline, yychar, yytext());}
";"                                    {return new Symbol(sym.semicolon, yyline, yychar, yytext());}
":"                                    {return new Symbol(sym.colon, yyline, yychar, yytext());}
"("                                    {return new Symbol(sym.oparent, yyline, yychar, yytext());}
")"                                    {return new Symbol(sym.cparent, yyline, yychar, yytext());}
","                                    {return new Symbol(sym.comma, yyline, yychar, yytext());}
"["                                    {return new Symbol(sym.osbracket, yyline, yychar, yytext());}
"]"                                    {return new Symbol(sym.csbracket, yyline, yychar, yytext());}
"="                                    {return new Symbol(sym.equal, yyline, yychar, yytext());}
"var"                                  {return new Symbol(sym.var, yyline, yychar, yytext());}
"let"                                  {return new Symbol(sym.let, yyline, yychar, yytext());}
"const"                                {return new Symbol(sym.tkconst, yyline, yychar, yytext());}
"if"                                   {return new Symbol(sym.tkif, yyline, yychar, yytext());}
"else"                                 {return new Symbol(sym.tkelse, yyline, yychar, yytext());}
"for"                                  {return new Symbol(sym.tkfor, yyline, yychar, yytext());}
"while"                                {return new Symbol(sym.tkwhile, yyline, yychar, yytext());}
"do"                                   {return new Symbol(sym.tkdo, yyline, yychar, yytext());}
"switch"                               {return new Symbol(sym.tkswitch, yyline, yychar, yytext());}
"case"                                 {return new Symbol(sym.tkcase, yyline, yychar, yytext());}
"break"                                {return new Symbol(sym.tkbreak, yyline, yychar, yytext());}
"default"                              {return new Symbol(sym.tkdefault, yyline, yychar, yytext());}
"=="                                   {return new Symbol(sym.equalsto, yyline, yychar, yytext());}
"!="                                   {return new Symbol(sym.different, yyline, yychar, yytext());}
"<"                                    {return new Symbol(sym.lessthan, yyline, yychar, yytext());}
">"                                    {return new Symbol(sym.greaterthan, yyline, yychar, yytext());}
"<="                                   {return new Symbol(sym.loeto, yyline, yychar, yytext());}
">="                                   {return new Symbol(sym.goeto, yyline, yychar, yytext());}
"&&"                                   {return new Symbol(sym.and, yyline, yychar, yytext());}
"||"                                   {return new Symbol(sym.or, yyline, yychar, yytext());}
"!"                                    {return new Symbol(sym.not, yyline, yychar, yytext());}
"+"                                    {return new Symbol(sym.plus, yyline, yychar, yytext());}
"-"                                    {return new Symbol(sym.minus, yyline, yychar, yytext());}
"*"                                    {return new Symbol(sym.mult, yyline, yychar, yytext());}
"/"                                    {return new Symbol(sym.slash, yyline, yychar, yytext());}
"**"                                   {return new Symbol(sym.pot, yyline, yychar, yytext());}
"%"                                    {return new Symbol(sym.modulus, yyline, yychar, yytext());}
"console.log"                          {return new Symbol(sym.console, yyline, yychar, yytext());}
"require"                              {return new Symbol(sym.require, yyline, yychar, yytext());}



\n                                     {yychar = 1;}

{BLANCOS}                              {}
{D}                                    {return new Symbol(sym.integerr, yyline, yychar, yytext());}
{DD}                                   {return new Symbol(sym.doublee, yyline, yychar, yytext());}
{CADENA}                               {return new Symbol(sym.stringg, yyline, yychar, yytext());}
{CARACTERES}                           {return new Symbol(sym.charr, yyline, yychar, yytext());}
{COMENTARIO}                           {return new Symbol(sym.comment, yyline, yychar, yytext());}
{COMENTARIOMULT}                       {return new Symbol(sym.multcomment, yyline, yychar, yytext());}
{ID}                                   {return new Symbol(sym.id, yyline, yychar, yytext());}

