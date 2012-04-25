CC=javac

DOC=javadoc
DOCOPTION=-d doc

FICHIERPRINCIPAL = test/TestMenu.java

all: doc stik

stik: $(FICHIERPRINCIPAL)
	@find . -name "*.class" -exec rm \{\} \;
	$(CC) $(FICHIERPRINCIPAL)
	java "test.TestMenu"
	@find . -name "*.class" -exec rm \{\} \;

doc: $(FICHIERPRINCIPAL)
	$(DOC) $(DOCOPTION) $(FICHIERPRINCIPAL)
