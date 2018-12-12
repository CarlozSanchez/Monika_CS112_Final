
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Color;

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
	
	private JPanel westPanel;
	private JPanel eastPanel;
	
	// JButtons of choice a, b, c
	private JButton aButton;
	private JButton bButton;
	private JButton cButton;
	private JButton goBackButton;
	
	// Text Field of choices and results
	private JTextField outputTextField;
	
	
	// Default constructor
	public LottoGUI()
	{
		super("----Lotto System----");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		setBackground(Color.GRAY);
		
		//---------West Panel---------------------------------------
		westPanel = new JPanel();
		westPanel.setBackground(Color.PINK);
		westPanel.setLayout(new BoxLayout(westPanel, 3));
		//westPanel.setLayout(new FlowLayout());
		
		// JButton aButton - westPanel
		aButton = new JButton("A");
		westPanel.add(aButton);
		//aButton.addActionListener(new AactionButtonInnerClass());
		
		// JButton bButton - westPanel
		bButton = new JButton("B");
		westPanel.add(bButton);
		//bButton.addActionListener(new BactionButtonInnerClass());
		
		// JButton cButton - westPanel
		cButton = new JButton("C");
		westPanel.add(cButton);
		//cButton.addActionListener(new CactionButtonInnerClass());
		
		//---------East Panel------------------------------------------
		eastPanel = new JPanel();
		eastPanel.setBackground(Color.WHITE);
		eastPanel.setLayout(new FlowLayout());
		
		// Output textField
		outputTextField = new JTextField(NUMBER_OF_CHARACTERS);
		outputTextField.setEditable(false);
		eastPanel.add(outputTextField);
		
		// JButton goBackButton
		goBackButton = new JButton("Go Back");
		eastPanel.add(goBackButton);
		
		add(westPanel);
		add(eastPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
