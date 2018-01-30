# Name: Daniel Xu
# NetId: dxu23
JC = javac
JFLAGS = -g

all: 
	$(JC) $(JFLAGS) *.java

test: ExamTester.class
	java ExamTester

ExamTester.class: ExamTester.java
	$(JC) $(JFLAGS) ExamTester.java

Exam.class: Exam.java
	$(JC) $(JFLAGS)Exam.java

Question.class: Question.java
	$(JC) $(JFLAGS)Question.java

Answer.class: Answer.java
	$(JC) $(JFLAGS) Answer.java

clean:
	rm *.class

