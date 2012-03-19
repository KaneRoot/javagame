## Compilation ##
OPT = "*.java"

all:
	cd ./test/
	find . -name $(OPT) -exec javac \{\} \;