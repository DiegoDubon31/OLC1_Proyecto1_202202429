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
STRAT = "strategy"
MATCH = "match"
MAIN = "main"
INITIAL = "initial"
RULES = "rules"
IF = "if"
THEN = "then"
ELSE = "else"
SCORING = "scoring"
RUN = "run"
WITH = "with"
SEED = "seed"
PLAYERS = "players"
STRATS = "strategies"
ROUNDS = "rounds"
MUTUAL = "mutual"
COOPERATION = "cooperation"
DEFECTION = "defection"
BETRAYAL = "betrayal"
REWARD = "reward"
PUNISHMENT = "punishment"
TRUE = "true"
FALSE = "false"


//-------> Operators
AND = "&&"
OR = "||"
NOT = "!"
EQUAL = "=="
INEQUAL = "!="
GREATER_THAN = ">"
LOWER_THAN = "<"
GREATER_OR_EQUAL = ">="
LOWER_OR_EQUAL = "<="

//-------> Symbols
CURLYOPEN = "{"
CURLYCLOSE = "}"
SQUAREOPEN = "["
SQUARECLOSE = "]"
ROUNDOPEN = "("
ROUNDCLOSE = ")"
COLON = ":"
COMMA = ","

//-------> System Functions
GET_MOVE = "get_move"
LAST_MOVE = "last_move"
GET_MOVES_COUNT = "get_moves_count"
GET_LAST_N_MOVES = "get_last_n_moves"

//-------> System states
ROUND_NUMBER = "round_number"
OPPONENT_HISTORY = "opponent_history"
SELF_HISTORY = "self_history"
TOTAL_ROUNDS = "total_rounds"
RANDOM = "random"

//-------> Regex and Literals
COOPERATE = "C"
DEFECT = "D"
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
<YYINITIAL> {STRAT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD STRATEGY");
    Lists.setTokensList(t);   
    return new Symbol(sym.STRAT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {MATCH} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD MATCH");
    Lists.setTokensList(t);   
    return new Symbol(sym.MATCH, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {MAIN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD MAIN");
    Lists.setTokensList(t);   
    return new Symbol(sym.MAIN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {INITIAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD INITIAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.INITIAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {RULES} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD RULES");
    Lists.setTokensList(t);   
    return new Symbol(sym.RULES, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {IF} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD IF");
    Lists.setTokensList(t);   
    return new Symbol(sym.IF, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {THEN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD THEN");
    Lists.setTokensList(t);   
    return new Symbol(sym.THEN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {ELSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD ELSE");
    Lists.setTokensList(t);   
    return new Symbol(sym.ELSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {SCORING} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD SCORING");
    Lists.setTokensList(t);   
    return new Symbol(sym.SCORING, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {RUN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD RUN");
    Lists.setTokensList(t);   
    return new Symbol(sym.RUN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {WITH} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD WITH");
    Lists.setTokensList(t);   
    return new Symbol(sym.WITH, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {SEED} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD SEED");
    Lists.setTokensList(t);   
    return new Symbol(sym.SEED, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {PLAYERS} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD PLAYERS");
    Lists.setTokensList(t);   
    return new Symbol(sym.PLAYERS, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {STRATS} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD STRATEGIES");
    Lists.setTokensList(t);   
    return new Symbol(sym.STRATS, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {ROUNDS} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD ROUNDS");
    Lists.setTokensList(t);   
    return new Symbol(sym.ROUNDS, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {MUTUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD MUTUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.MUTUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {COOPERATION} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD COOPERATION");
    Lists.setTokensList(t);   
    return new Symbol(sym.COOPERATION, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {DEFECTION} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD DEFECTION");
    Lists.setTokensList(t);   
    return new Symbol(sym.DEFECTION, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {BETRAYAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD BETRAYAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.BETRAYAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {REWARD} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD REWARD");
    Lists.setTokensList(t);   
    return new Symbol(sym.REWARD, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {PUNISHMENT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD PUNISHMENT");
    Lists.setTokensList(t);   
    return new Symbol(sym.PUNISHMENT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {TRUE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD TRUE");
    Lists.setTokensList(t);   
    return new Symbol(sym.TRUE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {FALSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RESERVED WORD FALSE");
    Lists.setTokensList(t);   
    return new Symbol(sym.FALSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {GET_MOVE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "GET_MOVE");
    Lists.setTokensList(t);   
    return new Symbol(sym.GET_MOVE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {LAST_MOVE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "LAST_MOVE");
    Lists.setTokensList(t);   
    return new Symbol(sym.LAST_MOVE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {GET_MOVES_COUNT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "GET_MOVES_COUNT");
    Lists.setTokensList(t);   
    return new Symbol(sym.GET_MOVES_COUNT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {GET_LAST_N_MOVES} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "GET_LAST_N_MOVES");
    Lists.setTokensList(t);   
    return new Symbol(sym.GET_LAST_N_MOVES, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {ROUND_NUMBER} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "ROUND_NUMBER");
    Lists.setTokensList(t);   
    return new Symbol(sym.ROUND_NUMBER, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {OPPONENT_HISTORY} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OPPONENT_HISTORY");
    Lists.setTokensList(t);   
    return new Symbol(sym.OPPONENT_HISTORY, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {SELF_HISTORY} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "SELF_HISTORY");
    Lists.setTokensList(t);   
    return new Symbol(sym.SELF_HISTORY, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {TOTAL_ROUNDS} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "TOTAL_ROUNDS");
    Lists.setTokensList(t);   
    return new Symbol(sym.TOTAL_ROUNDS, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {RANDOM} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "RANDOM");
    Lists.setTokensList(t);   
    return new Symbol(sym.RANDOM, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {AND} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "AND");
    Lists.setTokensList(t);   
    return new Symbol(sym.AND, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {OR} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OR");
    Lists.setTokensList(t);   
    return new Symbol(sym.OR, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {NOT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "NOT");
    Lists.setTokensList(t);   
    return new Symbol(sym.NOT, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {EQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "EQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.EQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {INEQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "INEQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.INEQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {GREATER_THAN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "GREATER THAN");
    Lists.setTokensList(t);   
    return new Symbol(sym.GREATER_THAN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {LOWER_THAN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "LOWER THAN");
    Lists.setTokensList(t);   
    return new Symbol(sym.LOWER_THAN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {GREATER_OR_EQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "GREATER OR EQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.GREATER_OR_EQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {LOWER_OR_EQUAL} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "LOWER OR EQUAL");
    Lists.setTokensList(t);   
    return new Symbol(sym.LOWER_OR_EQUAL, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {CURLYOPEN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OPEN CURLY BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.CURLYOPEN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {CURLYCLOSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "CLOSE CURLY BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.CURLYCLOSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {SQUAREOPEN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OPEN SQUARE BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.SQUAREOPEN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {SQUARECLOSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "CLOSE SQUARE BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.SQUARECLOSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {ROUNDOPEN} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "OPEN ROUND BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.ROUNDOPEN, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {ROUNDCLOSE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "CLOSE ROUND BRACE");
    Lists.setTokensList(t);   
    return new Symbol(sym.ROUNDCLOSE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {COLON} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "COLON");
    Lists.setTokensList(t);   
    return new Symbol(sym.COLON, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {COMMA} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "COMMA");
    Lists.setTokensList(t);   
    return new Symbol(sym.COMMA, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {COOPERATE} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "COOPERATE ACTION");
    Lists.setTokensList(t);   
    return new Symbol(sym.COOPERATE, yyline + 1, yycolumn + 1, yytext()); }
<YYINITIAL> {DEFECT} {
    Token t = new Token(yytext(),String.valueOf(yyline+1), String.valueOf(yycolumn+1) , "DEFECT ACTION");
    Lists.setTokensList(t);   
    return new Symbol(sym.DEFECT, yyline + 1, yycolumn + 1, yytext()); }
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