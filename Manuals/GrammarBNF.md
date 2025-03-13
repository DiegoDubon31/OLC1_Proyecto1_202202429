# **CUP Grammar in BNF(Backus-Naur-form)**
```
<S> ::= <strategy> <matches> <mainStmt>

<strategy> ::= <strategy> <stratStmt> | <stratStmt>
<stratStmt> ::= "strategy" <identifier> "{" 
                    "initial" ":" <decision> 
                    "rules" ":" "[" <conditions> "]" 
                "}"
<conditions> ::= <conditions> <ifStmt> | <ifStmt>
<ifStmt> ::= "if" <booleanExpression> "then" <actions> "," | "else" <actions>
<actions> ::= <decision> | "get_move" "(" <arg1> "," <arg2> ")" | "last_move" "(" <arg1> ")"
<booleanExpression> ::= <booleanExpression> <logical> <booleanExpression> | <booleanCondition>
<logical> ::= "&&" | "||"
<booleanCondition> ::= <side> <comparison> <side>
<side> ::= <func> | <state> | <decision> | "[" <decisionList> "]" | <integer> | <float>
<comparison> ::= "==" | "!=" | "<" | ">" | "<="| ">=" 
<func> ::= "get_move" "(" <arg1> "," <arg2> ")" | "last_move" "(" <arg1> ")" | "get_moves_count" "(" <arg1> "," <arg2> ")" | "get_last_n_moves" "(" <arg1> "," <arg2> ")"
<arg1> ::= <history> | <func> | <state>
<arg2> ::= <integer> | <decision> | <func> | <state>
<history> ::= "self_history" | "opponent_history"
<state> ::= "round_number" | "total_rounds" | "random" 
<decisionList> ::= <decisionList> "," <decision> | <decision>

<matches> ::= <matches> <matchStmt> | <matchStmt>
<matchStmt> ::= "match" <identifier> "{"
                    "player" "strategies" ":" "[" <identifier> "," <identifier> "]"
                    "rounds" ":" <integer>
                    "scoring" ":" "{"
                        "mutual" "cooperation" ":" <integer> ","
                        "mutual" "defection" ":" <integer> ","
                        "betrayal" "reward" ":" <integer> ","
                        "betrayal" "punishment" ":" <integer> 
                    "}"
                "}"

<mainStmt> ::= "main" "{" <runLst> "}"
<runLst> ::= <runLst> <runStmt> | <runStmt>
<runStmt> ::= "run" "[" <matchesIds> "]" "with" "{" "seed" ":" <integer>"}"
<matchesIds> ::= <matchesIds> "," <identifier> | <identifier>

<identifier> ::= [0-9A-Za-z_]+
<decision> ::= "C" | "D"
<integer> ::= [0-9]+
<float> ::= <integer> "." <integer>
```