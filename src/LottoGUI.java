
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class LottoGUI extends JFrame implements ActionListener
{
	public static final int WIDTH = 700;
	public static final int HEIGHT = 600;
	public static final int NUMBER_OF_CHARACTERS = 100;
	
	private Dimension BUTTON_SIZE = new Dimension(300,100);
	private Font BUTTON_FONT = new Font("Ariel", Font.PLAIN, 40);
	
	private JPanel westPanel;
	private JPanel eastPanel;
	
	// JButtons of choice a, b, c
	private JButton aButton;
	private JButton bButton;
	private JButton cButton;
	private JButton goBackButton;
	
	// Text Field of choices and results
	private JTextArea outputTextArea;
	
	LottoModel model;
	Dimension textSize = new Dimension(300, 400);
	
	// Default constructor
	public LottoGUI()
	{	
		super("----Lotto System----");		
		model = new LottoModel();	
		
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		setBackground(Color.GRAY);
		
		//---------West Panel---------------------------------------
		westPanel = new JPanel();
		westPanel.setBackground(Color.PINK);
		//westPanel.setLayout(new BoxLayout(westPanel, 3));
		westPanel.setLayout(new FlowLayout());
		
		// JButton aButton - westPanel
		aButton = new JButton("A");
		//aButton.setMinimumSize(new Dimension(200,100));
		//aButton.setSize(new Dimension(100,100));
		//aButton.setBounds(100,100,100,100);
		aButton.setPreferredSize(BUTTON_SIZE);
		aButton.setFont(BUTTON_FONT);
		westPanel.add(aButton);
		aButton.addActionListener(this);
		
		// JButton bButton - westPanel
		bButton = new JButton("B");
		bButton.setPreferredSize(BUTTON_SIZE);
		bButton.setFont(BUTTON_FONT);
		
		//bButton.setPreferredSize(new Dimension(100,100));
		westPanel.add(bButton);
		bButton.addActionListener(this);
		
		// JButton cButton - westPanel
		cButton = new JButton("C");
		westPanel.add(cButton);
		cButton.setPreferredSize(BUTTON_SIZE);
		cButton.setFont(BUTTON_FONT);
		cButton.addActionListener(this);
		
		//---------East Panel------------------------------------------
		eastPanel = new JPanel();
		eastPanel.setBackground(Color.WHITE);
		eastPanel.setLayout(new FlowLayout());
		
		// Output textField
		//outputTextArea = new JTextArea("---TextField---", 15, 15);
		outputTextArea = new JTextArea(model.setUp());
		outputTextArea.setEditable(false);		
		outputTextArea.setPreferredSize(textSize);		
		eastPanel.add(outputTextArea);
		
		// JButton goBackButton
		goBackButton = new JButton("HOME");
		goBackButton.setPreferredSize(BUTTON_SIZE);
		goBackButton.setFont(BUTTON_FONT);
		eastPanel.add(goBackButton);
		goBackButton.addActionListener(this);
		
		add(westPanel);
		add(eastPanel);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String selection = model.process(e.getActionCommand());
		outputTextArea.setText(selection);
		
/*		if (e.getActionCommand().equals("A"))
		{
			//outputTextArea.setText("A button is selected");
			selection = "A";
		}
		if (e.getActionCommand().equals("B"))
		{
			outputTextArea.setText("B button is selected");
		}
		if (e.getActionCommand().equals("C"))
		{
			outputTextArea.setText("C button is selected");
		}
		if (e.getActionCommand().equals("Go Back"))
		{
			outputTextArea.setText("");
		}
		*/
		
		
	}
	
}