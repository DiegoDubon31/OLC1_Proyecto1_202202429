package Analyzer;
import java_cup.runtime.Symbol;

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
SPACES = [ \t\r\n\f]+
INTEGER = [0-9]+
FLOAT = {INTEGER}+(\.{INTEGER}+)
ID = [0-9A-Za-z_]+

%% //Here ends the tokens definition 

//-------> Lexical Rules
<YYINITIAL> {MLcomment} {   }
<YYINITIAL> {SLcomment} {   }
<YYINITIAL> {SPACES} {  }
<YYINITIAL> {R_STRAT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD STRATEGY");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_STRAT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_MATCH} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD MATCH");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_MATCH, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_MAIN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD MAIN");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_MAIN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_INITIAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD INITIAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_INITIAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_RULES} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD RULES");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_RULES, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_IF} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD IF");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_IF, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_THEN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD THEN");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_THEN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_ELSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD ELSE");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_ELSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_SCORING} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD SCORING");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_SCORING, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_RUN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD RUN");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_RUN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_WITH} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD WITH");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_WITH, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_SEED} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD SEED");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_SEED, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_PLAYERS} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD PLAYERS");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_PLAYERS, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_STRATS} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD STRATEGIES");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_STRATS, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_ROUNDS} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD ROUNDS");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_ROUNDS, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_MUTUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD MUTUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_MUTUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_COOPERATION} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD COOPERATION");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_COOPERATION, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_DEFECTION} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD DEFECTION");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_DEFECTION, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_BETRAYAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD BETRAYAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_BETRAYAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_REWARD} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD REWARD");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_REWARD, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_PUNISHMENT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD PUNISHMENT");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_PUNISHMENT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_TRUE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD TRUE");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_TRUE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {R_FALSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD FALSE");
    Lists.setTokensList(t);   
    return new Symbol(sym.R_FALSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_AND} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "AND");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_AND, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_OR} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OR");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_OR, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_NOT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "NOT");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_NOT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_EQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "EQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_EQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_INEQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "INEQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_INEQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_GREATER_THAN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "GREATER THAN");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_GREATER_THAN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_LOWER_THAN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "LOWER THAN");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_LOWER_THAN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_GREATER_OR_EQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "GREATER OR EQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_GREATER_OR_EQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {O_LOWER_OR_EQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "LOWER OR EQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.O_LOWER_OR_EQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {S_CURLYOPEN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OPEN CURLY BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.S_CURLYOPEN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {S_CURLYCLOSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "CLOSE CURLY BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.S_CURLYCLOSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {S_SQUAREOPEN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OPEN SQUARE BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.S_SQUAREOPEN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {S_SQUARECLOSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "CLOSE SQUARE BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.S_SQUARECLOSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {S_COLON} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "COLON");
    Lists.setTokensList(t);   
    return new Symbol(sym.S_COLON, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {S_COMMA} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "COMMA");
    Lists.setTokensList(t);   
    return new Symbol(sym.S_COMMA, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {A_COOPERATE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "COOPERATE ACTION");
    Lists.setTokensList(t);   
    return new Symbol(sym.A_COOPERATE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {A_DEFECT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "DEFECT ACTION");
    Lists.setTokensList(t);   
    return new Symbol(sym.A_DEFECT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {INTEGER} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "INTEGER");
    Lists.setTokensList(t);   
    return new Symbol(sym.INTEGER, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {FLOAT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "FLOAT");
    Lists.setTokensList(t);   
    return new Symbol(sym.FLOAT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {ID} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "ID");
    Lists.setTokensList(t);   
    return new Symbol(sym.ID, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> . { 
                error e = new error("El caracter "+yytext()+" no pertenece al lenguaje", "Lexico", String.valueOf(yyline+1), String.valueOf(yycolumn+1));
                Lists.setErrorsList(e);
                String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline + 1)+" y columna: "+(yycolumn + 1);
                System.out.println(errLex); }