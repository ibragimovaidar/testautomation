grammar TestAutomationPlatform;


// Parser rules

prog: features;


// Feature
features: feature*;
feature: FEATURE ' ' featureName '{' command* '}';
featureName: StringLiteral;


// Variable

variable: variableName '=' command;
variableName: LetterCharacters;

// Command

command: http_command | db_command;
http_command: HTTP ' ' httpMethod ' ' httpUrl httpHeaders* httpBody* ';';
db_command: DB ' ' db_query ';';


// HTTP client command

httpMethod : ('GET' | 'POST' | 'PUT' | 'DELETE' | 'PATCH' | 'OPTIONS');
httpUrl : StringLiteral;
httpBody: 'body:' (json | StringLiteral);
httpHeaders: 'headers:' json;

// DB client command

db_query: StringLiteral;

// JSON

json
    : value
    ;

obj
    : '{' pair (',' pair)* '}'
    | '{' '}'
    ;

pair
    : StringLiteral ':' value
    ;

arr
    : '[' value (',' value)* ']'
    | '[' ']'
    ;

value
    : StringLiteral
    | NUMBER
    | obj
    | arr
    | 'true'
    | 'false'
    | 'null'
    ;

// Lexer rules

HTTP : 'http';
DB : 'db';
ASSERT: 'assert';
FEATURE: 'feature';



// §3.10.5 String Literal

LetterCharacters: Letter+;
StringLiteral: '"' StringCharacters? '"';

fragment StringCharacters: StringCharacter+;

fragment StringCharacter: ~["\\\r\n] | EscapeSequence;

// §3.10.6 Escape Sequences for Character and String Literals

fragment EscapeSequence:
    '\\' 'u005c'? [btnfr"'\\]
    | OctalEscape
    | UnicodeEscape // This is not in the spec but prevents having to preprocess the input
;
fragment OctalEscape:
    '\\' 'u005c'? OctalDigit
    | '\\' 'u005c'? OctalDigit OctalDigit
    | '\\' 'u005c'? ZeroToThree OctalDigit OctalDigit
;

fragment ZeroToThree: [0-3];

// This is not in the spec but prevents having to preprocess the input
fragment UnicodeEscape: '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit;
fragment OctalDigit: [0-7];
fragment HexDigit: [0-9a-fA-F];
fragment Letter: [a-zA-Z];



fragment ESC
    : '\\' (["\\/bfnrt] | UNICODE)
    ;

fragment UNICODE
    : 'u' HEX HEX HEX HEX
    ;

fragment HEX
    : [0-9a-fA-F]
    ;

fragment SAFECODEPOINT
    : ~ ["\\\u0000-\u001F]
    ;

NUMBER
    : '-'? INT ('.' [0-9]+)? EXP?
    ;

fragment INT
    // integer part forbis leading 0s (e.g. `01`)
    : '0'
    | [1-9] [0-9]*
    ;

// no leading zeros

fragment EXP
    // exponent number permits leading 0s (e.g. `1e01`)
    : [Ee] [+\-]? [0-9]+
    ;

// \- since - means "range" inside [...]


COMMENT: '/*' .*? '*/' -> skip;

LINE_COMMENT: '//' ~[\r\n]* -> skip;

WS: [ \t\r\n\u000C]+ -> skip;
