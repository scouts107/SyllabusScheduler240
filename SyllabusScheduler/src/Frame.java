package proxyExample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Frame {

	private JFrame frame;
	private Syllabus s = Syllabus.getInstance();
	private int week = 0;
	private int day = 0;
	private Originator origin = new Originator(); 
	private CareTaker taker = new CareTaker();
	private JTextField className;
	private JTextField weekTopic;
	private JTextField classLabel;
	private JTextField topicLabel;
	private JTextField notesLabel;
	private JTextField weekLabel;
	private JTextField dayLabel;

	/**
	 * Launch the application.
	 */
	public static void myFrame(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 745, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		//create text panes and buttons
		String[] li = new String[17];
		for(int i = 0; i <= 16; i++)
			li[i] = "Week "+ i;
		JList weekList = new JList(li);
		springLayout.putConstraint(SpringLayout.WEST, weekList, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, weekList, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, weekList, -656, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(weekList);
		
		String[] li1 = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		JList dayList = new JList(li1);
		springLayout.putConstraint(SpringLayout.WEST, dayList, 19, SpringLayout.EAST, weekList);
		frame.getContentPane().add(dayList);
		
		JTextPane dailyNotes = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, dayList, -92, SpringLayout.WEST, dailyNotes);
		springLayout.putConstraint(SpringLayout.WEST, dailyNotes, 264, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, dailyNotes, -177, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, dailyNotes, -31, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(dailyNotes);
		dailyNotes.setEditable(false);
		
		JButton dayEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.NORTH, dayEdit, 0, SpringLayout.NORTH, dailyNotes);
		springLayout.putConstraint(SpringLayout.WEST, dayEdit, 575, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(dayEdit);
		
		JButton daySubmit = new JButton("Submit");
		springLayout.putConstraint(SpringLayout.NORTH, daySubmit, 12, SpringLayout.SOUTH, dayEdit);
		springLayout.putConstraint(SpringLayout.EAST, dayEdit, 0, SpringLayout.EAST, daySubmit);
		springLayout.putConstraint(SpringLayout.WEST, daySubmit, 21, SpringLayout.EAST, dailyNotes);
		frame.getContentPane().add(daySubmit);
		daySubmit.setVisible(false);
		
		className = new JTextField();
		className.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, className, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, className, -297, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(className);
		className.setColumns(10);
		className.setText(s.getName());
		className.setEditable(false);
		
		weekTopic = new JTextField();
		weekTopic.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, className, 0, SpringLayout.WEST, weekTopic);
		springLayout.putConstraint(SpringLayout.NORTH, weekTopic, 48, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, weekTopic, 38, SpringLayout.SOUTH, className);
		frame.getContentPane().add(weekTopic);
		weekTopic.setColumns(10);
		weekTopic.setEditable(false);
		
		JButton nameEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.EAST, className, -16, SpringLayout.WEST, nameEdit);
		springLayout.putConstraint(SpringLayout.EAST, nameEdit, 0, SpringLayout.EAST, dailyNotes);
		springLayout.putConstraint(SpringLayout.WEST, nameEdit, 489, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, nameEdit, 10, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(nameEdit);
		
		JButton topicEdit = new JButton("Edit");
		springLayout.putConstraint(SpringLayout.EAST, weekTopic, -16, SpringLayout.WEST, topicEdit);
		springLayout.putConstraint(SpringLayout.NORTH, topicEdit, 22, SpringLayout.SOUTH, nameEdit);
		springLayout.putConstraint(SpringLayout.WEST, topicEdit, 0, SpringLayout.WEST, nameEdit);
		springLayout.putConstraint(SpringLayout.EAST, topicEdit, 0, SpringLayout.EAST, dailyNotes);
		frame.getContentPane().add(topicEdit);
		
		JButton nameSubmit = new JButton("Submit");
		springLayout.putConstraint(SpringLayout.EAST, daySubmit, 0, SpringLayout.EAST, nameSubmit);
		springLayout.putConstraint(SpringLayout.WEST, nameSubmit, 575, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, nameSubmit, -67, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, nameSubmit, 10, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(nameSubmit);
		nameSubmit.setVisible(false);
		
		JButton topicSubmit = new JButton("Submit");
		springLayout.putConstraint(SpringLayout.NORTH, topicSubmit, 22, SpringLayout.SOUTH, nameSubmit);
		springLayout.putConstraint(SpringLayout.WEST, topicSubmit, 21, SpringLayout.EAST, topicEdit);
		springLayout.putConstraint(SpringLayout.EAST, topicSubmit, 0, SpringLayout.EAST, nameSubmit);
		frame.getContentPane().add(topicSubmit);
		topicSubmit.setVisible(false);
		
		classLabel = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, classLabel, 16, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, classLabel, -429, SpringLayout.EAST, frame.getContentPane());
		classLabel.setEditable(false);
		classLabel.setForeground(SystemColor.desktop);
		classLabel.setBackground(SystemColor.menu);
		classLabel.setText("Class Name:");
		frame.getContentPane().add(classLabel);
		classLabel.setColumns(10);
		
		topicLabel = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, topicLabel, 19, SpringLayout.SOUTH, classLabel);
		springLayout.putConstraint(SpringLayout.WEST, weekTopic, 6, SpringLayout.EAST, topicLabel);
		springLayout.putConstraint(SpringLayout.WEST, classLabel, 0, SpringLayout.WEST, topicLabel);
		springLayout.putConstraint(SpringLayout.EAST, topicLabel, -429, SpringLayout.EAST, frame.getContentPane());
		topicLabel.setEditable(false);
		topicLabel.setText("Weekly Topic:");
		topicLabel.setForeground(Color.BLACK);
		topicLabel.setColumns(10);
		topicLabel.setBackground(SystemColor.menu);
		frame.getContentPane().add(topicLabel);
		
		notesLabel = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, notesLabel, 6, SpringLayout.SOUTH, weekTopic);
		springLayout.putConstraint(SpringLayout.WEST, notesLabel, 157, SpringLayout.EAST, dayList);
		springLayout.putConstraint(SpringLayout.EAST, notesLabel, -271, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, dayList, 0, SpringLayout.NORTH, notesLabel);
		springLayout.putConstraint(SpringLayout.NORTH, dailyNotes, 6, SpringLayout.SOUTH, notesLabel);
		notesLabel.setBackground(SystemColor.menu);
		notesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		notesLabel.setText("Daily Notes");
		frame.getContentPane().add(notesLabel);
		notesLabel.setColumns(10);
		notesLabel.setEditable(false);
		
		weekLabel = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, weekLabel, 16, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, weekLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, weekList, 4, SpringLayout.SOUTH, weekLabel);
		weekLabel.setEditable(false);
		weekLabel.setBackground(SystemColor.menu);
		weekLabel.setText("Week Number:");
		frame.getContentPane().add(weekLabel);
		weekLabel.setColumns(10);
		
		dayLabel = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, dayLabel, 19, SpringLayout.EAST, weekList);
		springLayout.putConstraint(SpringLayout.SOUTH, dayLabel, -6, SpringLayout.NORTH, dayList);
		springLayout.putConstraint(SpringLayout.EAST, dayLabel, -588, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, topicLabel, 70, SpringLayout.EAST, dayLabel);
		dayLabel.setEditable(false);
		dayLabel.setBackground(SystemColor.menu);
		dayLabel.setText("Day:");
		frame.getContentPane().add(dayLabel);
		dayLabel.setColumns(10);
		
		JButton resetBtn = new JButton("Reset Weeks");
		springLayout.putConstraint(SpringLayout.WEST, resetBtn, 0, SpringLayout.WEST, dayList);
		springLayout.putConstraint(SpringLayout.SOUTH, resetBtn, -33, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, resetBtn, 114, SpringLayout.WEST, dayList);
		frame.getContentPane().add(resetBtn);
		
		JButton btnSave = new JButton("Save Weeks");
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 0, SpringLayout.WEST, dayList);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSave, -6, SpringLayout.NORTH, resetBtn);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, resetBtn);
		frame.getContentPane().add(btnSave);
		
		//create listeners for actions
		//sets week to week chosen by user and displays notes
		weekList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				week = weekList.getSelectedIndex();
				weekTopic.setText(s.weeks[week].getTopic());
				if (day < 7) {
					dailyNotes.setText(s.getWeek(week).getDay(day));
				}
			}
		});
		//sets day to one chosen by user and displays notes
		dayList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				day = dayList.getSelectedIndex();
				if (week < 20 && day < 7) {
					dailyNotes.setText(s.getWeek(week).getDay(day));
				}
			}
		});
		//allows you to edit text pane
		dayEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dailyNotes.setEditable(true);
				daySubmit.setVisible(true);
			}
		});
		//submits string from text pane into day chosen
		daySubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.weeks[week].setDay(dailyNotes.getText(), day);
				dailyNotes.setEditable(false);
				daySubmit.setVisible(false);
			}
		});
		//allows you to edit Class name text
		nameEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				className.setEditable(true);
				nameSubmit.setVisible(true);
			}
		});
		//submits Class name string to syllabus name
		nameSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.setName(className.getText());
				className.setEditable(false);
				nameSubmit.setVisible(false);
			}
		});
		//allows to edit the weekly topic field
		topicEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				weekTopic.setEditable(true);
				topicSubmit.setVisible(true);
			}
		});
		//submits the edit made to the weekly topic field to selected week
		topicSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.weeks[week].setTopic(weekTopic.getText());
				weekTopic.setEditable(false);
				topicSubmit.setVisible(false);
			}
		});
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				origin.setState(s.weeks);
				taker.addMemento(origin.save());
			}
		});
		resetBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Week[] weeks= taker.getMemento().getState();
				for(int i = 0; i < s.weeks.length; i++) {
					s.weeks[i].setTopic(weeks[i].getTopic());
					for (int j = 0; j < 7; j++)
						s.weeks[i].setDay(weeks[i].getDay(j), j);
				}
			}
		});
	}
}
