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
	$(JC) $(JFLAGS) Exam.java

MCQuestion.class: MCQuestion.java
	$(JC) $(JFLAGS) MCQuestion.java

MCAnswer.class: MCAnswer.java
	$(JC) $(JFLAGS) MCAnswer.java

SAQuestion.class: SAQuestion.java
	$(JC) $(JFLAGS) SAQuestion.java
					 
SAAnswer.class: SAAnswer.java
	$(JC) $(JFLAGS) SAAnswer.java

Question.class: Question.java
	$(JC) $(JFLAGS)Question.java

Answer.class: Answer.java
	$(JC) $(JFLAGS) Answer.java

clean:
	rm *.class

