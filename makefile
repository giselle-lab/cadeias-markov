JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java\
	Jogador.java\
	Ponto.java\
	Game.java\
	Set.java\
	Partida.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java Main
