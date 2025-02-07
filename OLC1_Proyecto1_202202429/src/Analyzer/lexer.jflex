package Analyzer;
import  java_cup.runtime.Symbol;

%%
//-------> (Do not touch)
%public
%class Lexer
%cup
%char
%column
%line
%unicode
//%debug

%{

%}

//-------> Reserved words
R_STRAT = "strategy"
R_MATCH = "match"
R_MAIN = "main"
R_INITIAL = "initial"
R_RULES = "rules"
R_IF = "if"
R_THEN = "then"
R_ELSE = "else"
R_SCORING = "scoring"
R_RUN = "run"
R_WITH = "with"
R_SEED = "seed"
R_PLAYERS = "players"
R_STRATS = "strategies"
R_ROUNDS = "rounds"
R_MUTUAL = "mutual"
R_COOPERATION = "cooperation"
R_DEFECTION = "defection"
R_BETRAYAL = "betrayal"
R_REWARD = "reward"
R_PUNISHMENT = "punishment"
R_TRUE = "true"
R_FALSE = "false"


//-------> Operators
O_AND = "&&"
O_OR = "||"
O_NOT = "!"
O_EQUAL = "=="
O_INEQUAL = "!="
O_GREATER_THAN = ">"
O_LOWER_THAN = "<"
O_GREATER_OR_EQUAL = ">="
O_LOWER_OR_EQUAL = "<="

//-------> Symbols
S_CURLYOPEN = "{"
S_CURLYCLOSE = "}"
S_SQUAREOPEN = "["
S_SQUARECLOSE = "]"
S_COLON = ":"
S_COMMA = ","

//-------> Regex and Literals
A_COOPERATE = "C"
A_DEFECT = "D"
SLcomment = #[^\n]*
MLcomment = "<!"~"!>"
INTEGER = [0-9]+
FLOAT = {INTEGER}+(\.{INTEGER}+)
SPACES = [ \t\r\n\f]+
ID = [0-9A-Za-z_]+

%% //Here ends the tokens definition 

//-------> Lexical Rules
<YYINITIAL> {MLcomment} {   }
<YYINITIAL> {SLcomment} {   }
<YYINITIAL> {SPACES} {  }
<YYINITIAL> {R_STRAT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD STRATEGY");
    Listas.setListaTokens(t);   
    return new Symbol(sym.R_STRAT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_MATCH} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD MATCH");
    Listas.setListaTokens(t);   
    return new Symbol(sym.R_MATCH, yyline + 1, yycolumn + 1, yytext()); }
