CC=javac

DOC=javadoc
DOCOPTION=-d doc

FICHIERPRINCIPAL = test/TestMenu.java
MOD = $(wildcard */*/*.java */*.java )

all: doc jeu

jeu: clean stik

stik: $(FICHIERPRINCIPAL)
	$(CC) $(FICHIERPRINCIPAL)
	java "test.TestMenu"

doc: $(MOD)
	$(DOC) $(DOCOPTION) $(MOD)

clean:
	@find . -name "*.class" -exec rm \{\} \;
