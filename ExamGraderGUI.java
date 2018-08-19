// package components;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class ExamGraderGUI extends JPanel implements ActionListener {
    JButton loadExamButton, saveButton, loadStudentAnswersButton, evaluateAnswersButton;
	Scanner scExam = null; 
	Scanner scExamAnswers = null;
	int examFileReturnVal = -1;
	int answerFileReturnVal = -1;
	int scoreCSVReturnVal = -1;
	File examFile = null;
	File answerFile = null;
	File CSVFile = null;
	PrintWriter pwCSV = null;
	boolean gradable = false;
    JTextArea log;
	// JTextArea examLog;
	
    JFileChooser examFC;

    public ExamGraderGUI() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

		// examLog = new JTextArea(();

        //Create a file chooser
        examFC = new JFileChooser();

        //Create a load exam button.        
		loadExamButton = new JButton("Load an Exam file");
        loadExamButton.addActionListener(this);

		loadStudentAnswersButton = new JButton("Load an Answer File");
        loadStudentAnswersButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        saveButton = new JButton("Save Score");
        saveButton.addActionListener(this);
		saveButton.setEnabled(false);

        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(loadExamButton);
		buttonPanel.add(loadStudentAnswersButton);
        buttonPanel.add(saveButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent Event) {

        //Handle open button action.
        if (Event.getSource() == loadExamButton) {
            examFileReturnVal = examFC.showOpenDialog(ExamGraderGUI.this);

            if (examFileReturnVal == JFileChooser.APPROVE_OPTION) {
                examFile = examFC.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Loading Exam file: " + examFile.getName() + "." + "\n");
				log.append("examFileReturnVal:" + examFileReturnVal + "\n");
            } else {
                log.append("Loading Exam file canceled by user." + "\n");
            }
			gradable = (examFileReturnVal == 0) && (answerFileReturnVal == 0);
            log.setCaretPosition(log.getDocument().getLength());
		} else if (Event.getSource() == loadStudentAnswersButton) {
            answerFileReturnVal = examFC.showOpenDialog(ExamGraderGUI.this);

            if (answerFileReturnVal == JFileChooser.APPROVE_OPTION) {
                answerFile = examFC.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Loading Answer file: " + answerFile.getName() + "." + "\n");
				log.append("answerFileReturnVal:" + answerFileReturnVal + "\n");
            } else {
                log.append("Loading Answer file canceled by user." + "\n");
            }
			gradable = (examFileReturnVal == 0) && (answerFileReturnVal == 0);
            log.setCaretPosition(log.getDocument().getLength());

        //Handle save button action.
        } else if ((Event.getSource() == saveButton) && gradable) {
            scoreCSVReturnVal = examFC.showOpenDialog(ExamGraderGUI.this);

            if (scoreCSVReturnVal == JFileChooser.APPROVE_OPTION) {
                CSVFile = examFC.getSelectedFile();
                log.append("Getting CSV file: " + CSVFile.getName() + "." + "\n");
				log.append("scoreCSVReturnVal:" + scoreCSVReturnVal + "\n");
            } else {
                log.append("Saving score canceled by user." + "\n");
            }
			try {
				pwCSV = new PrintWriter(CSVFile);
			} catch (FileNotFoundException e) {
				System.out.println("Could not create PrintWriter object from CSV file...");
				e.printStackTrace();
			}
			pwCSV.printf("%s\n", studentName);
			studentExam.saveScore(pwCSV);
			pwCSV.close();
            log.setCaretPosition(log.getDocument().getLength());
        }

		if (gradable) {
			log.append("Creating Scanner objects..." + "\n");
			try {
				scExam = new Scanner(examFile);
				log.append("Scanner object for Exam file successfuly created.\n");
			} catch (FileNotFoundException Error) {
				log.append("Could not create Scanner object from file for some reason..." + "\n");
				Error.printStackTrace();
			}

			String examNameInExamFile = "";
			while ((examNameInExamFile == "") && scExam.hasNextLine()) {
				examNameInExamFile = scExam.nextLine();
			}

			try {
				scExamAnswers = new Scanner(answerFile);
				log.append("Scanner object for Answer file successfuly created.\n");
			} catch (FileNotFoundException Error) {
				log.append("Could not create Scanner for some reason!");
				Error.printStackTrace();
			}

			String studentName = scExamAnswers.nextLine();
			log.append("studentName:" + studentName + "\n");
			String examNameInAnsFile = "";
			while (examNameInAnsFile == "") {
				examNameInAnsFile = scExamAnswers.nextLine();
			}

			if (!examNameInExamFile.equals(examNameInAnsFile)) {
				log.append("Exam file and answer file are not matching set!" + "\n");
				log.append("Exam name in Exam file:" +  examNameInExamFile + "\n");
				log.append("Exam name in Ansswer file:" +  examNameInAnsFile + "\n");
			} else {
				log.append("Exam file and answer file match." + "\n");
				saveButton.setEnabled(true);
			}
			Exam studentExam = new Exam(scExam);
			studentExam.restoreStudentAnswers(scExamAnswers);
            log.setCaretPosition(log.getDocument().getLength());
		}
    }


    /**
     * Create the GUI and show it. 
	 */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ExamGraderGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new ExamGraderGUI());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
    }
}
