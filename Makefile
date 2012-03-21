## Compilation ##
OPT = "*.java"

all:
	find test -name $(OPT) -exec javac \{\} \;
