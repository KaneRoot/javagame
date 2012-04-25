CC=javac

DOC=javadoc
DOCOPTION=-d doc

FICHIERPRINCIPAL = test/TestMenu.java

all: doc jeu

jeu: clean stik

stik: $(FICHIERPRINCIPAL)
	$(CC) $(FICHIERPRINCIPAL)
	java "test.TestMenu"

doc: $(FICHIERPRINCIPAL)
	$(DOC) $(DOCOPTION) $(FICHIERPRINCIPAL)

clean:
	@find . -name "*.class" -exec rm \{\} \;
