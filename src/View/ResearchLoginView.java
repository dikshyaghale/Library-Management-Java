package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.ResearcherLoginController;

public class ResearchLoginView extends JFrame {
	//components fro jpanel
	private JPanel jPMainLogPanel,jPLogHeaderPanel,jPLogImagePanel,jPLoginPanel,jPFinal;
	//components for jButton
	private JButton jBLogBtn, jBExitBtn, jBResetBtn;
	private JLabel jLHeaderLbl, jLUsernameLbl, jLPassLbl,jLImageLbl,jLTitleLbl,jLSignIn,jLMember;
	private JTextField jTUserField;
	private JPasswordField jPPassField;
	//for image icon
	private ImageIcon uniIcon = new ImageIcon("images/uni.jpg");
	private ImageIcon logImage = new ImageIcon("images/man.jpeg");
	private ImageIcon img = new ImageIcon("images/black.png");
//	private String logMembers[] = {"admin","reearcher"};
//	private JComboBox comBox;
	private JRadioButton logForAdmin, logForResearcher;
	private final ButtonGroup btnGp = new ButtonGroup();
	
	//constructor
	public ResearchLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(145,145,750,500);
		setBackground(Color.white);
		setResizable(false);
		setIconImage(uniIcon.getImage());
		setLocationRelativeTo(null);
		Container contain = getContentPane();
		contain.setLayout(null);
		makeLoginGUI();
	}

	//method to make design of login
	private void makeLoginGUI() {
		
		jPMainLogPanel = new JPanel();
		jPMainLogPanel.setLayout(null);
		jPMainLogPanel.setBackground(new Color(119,136,153));
		jPMainLogPanel.setBounds(145,145,750,600);
		jPMainLogPanel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(jPMainLogPanel);
		
		jPLogHeaderPanel = new JPanel();
		jPLogHeaderPanel.setBounds(0,0,750,70);
		jPLogHeaderPanel.setLayout(null);
		jPLogHeaderPanel.setBorder(new EmptyBorder(5,5,5,5));
		jPLogHeaderPanel.setBackground(new Color(0,128,128));
		jPMainLogPanel.add(jPLogHeaderPanel);
		
		jLTitleLbl = new JLabel("NORTHAMPTON RESEARCH ARTICLE MANAGEMENT SYSTEM");
		jLTitleLbl.setBounds(50,15,650,45);
		jLTitleLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLTitleLbl.setForeground(new Color(240,255,255));
		jPLogHeaderPanel.add(jLTitleLbl);
		
		jPLogImagePanel = new JPanel();
		jPLogImagePanel.setBounds(0,70,390,460);
		jPLogImagePanel.setLayout(null);
		jPMainLogPanel.add(jPLogImagePanel);
		
		jLImageLbl = new JLabel(logImage);
		jLImageLbl.setBounds(0,0,390,460);
		jPLogImagePanel.add(jLImageLbl);
		
		jPLoginPanel = new JPanel();
		jPLoginPanel.setBounds(300,70,455,460);
		jPLoginPanel.setLayout(null);
		jPLoginPanel.setBackground(new Color(244,164,96));
		jPMainLogPanel.add(jPLoginPanel);
		
		jLSignIn = new JLabel("Login to your account");
		jLSignIn.setBounds(120,15,455,30);
		jLSignIn.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
		jLSignIn.setForeground(new Color(240,255,255));
		jPLoginPanel.add(jLSignIn);
		
		jPFinal = new JPanel();
		jPFinal.setBounds(120,60,300,310);
		jPFinal.setBackground(new Color(245,245,245));
		jPFinal.setLayout(null);
		jPLoginPanel.add(jPFinal);
		
		jLUsernameLbl = new JLabel("Your Username");
		jLUsernameLbl.setBounds(80,20,200,20);
		jLUsernameLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,17));
		jPFinal.add(jLUsernameLbl);
		
		jTUserField = new JTextField();
		jTUserField.setBounds(80,50,140,25);
		jPFinal.add(jTUserField);
		
		jLPassLbl = new JLabel("Your Password");
		jLPassLbl.setBounds(80,100,200,20);
		jLPassLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,17));
		jPFinal.add(jLPassLbl);
		
		jPPassField = new JPasswordField();
		jPPassField.setBounds(80,120,140,25);
		jPPassField.setFont(new Font("Lucida Handwriting",Font.PLAIN,17));
		jPFinal.add(jPPassField);
	
		
		logForAdmin = new JRadioButton("Admin");
		logForAdmin.setFont(new Font("Lucida Handwriting",Font.PLAIN,17));
		logForAdmin.setActionCommand("admin");
		logForAdmin.setBounds(30,180,110,25);
		btnGp.add(logForAdmin);
		jPFinal.add(logForAdmin);
		
		logForResearcher = new JRadioButton("Researcher");
		logForResearcher.setFont(new Font("Lucida Handwriting",Font.PLAIN,17));
		logForResearcher.setActionCommand("researcher");
		logForResearcher.setBounds(150,180,130,25);
		btnGp.add(logForResearcher);
		jPFinal.add(logForResearcher);
		
		jBResetBtn = new JButton("Reset");
		jBResetBtn.setBounds(10,250,90,25);
		jBResetBtn.setBackground(Color.WHITE);
		jBResetBtn.setFont(new Font("Tahoma",Font.PLAIN,15));
		jPFinal.add(jBResetBtn);
		
		jBLogBtn = new JButton("Login");
		jBLogBtn.setBounds(120,250,80,25);
		jBLogBtn.setBackground(Color.WHITE);
		jBLogBtn.setFont(new Font("Tahoma",Font.PLAIN,15));
		jPFinal.add(jBLogBtn);
		
		jBExitBtn = new JButton("Exit");
		jBExitBtn.setBounds(218,250,80,25);
		jBExitBtn.setBackground(Color.WHITE);
		jBExitBtn.setFont(new Font("Tahoma",Font.PLAIN,15));
		jBExitBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		jPFinal.add(jBExitBtn);	
		
	}

	//required getters and setters
	public JButton getjBLogBtn() {
		return jBLogBtn;
	}

	public void setjBLogBtn(JButton jBLogBtn) {
		this.jBLogBtn = jBLogBtn;
	}

	public JButton getjBResetBtn() {
		return jBResetBtn;
	}

	public void setjBResetBtn(JButton jBResetBtn) {
		this.jBResetBtn = jBResetBtn;
	}

	public JTextField getjTUserField() {
		return jTUserField;
	}
	
	public String getResUsrField() {
		return jTUserField.getText();
	}

	public void setjTUserField(JTextField jTUserField) {
		this.jTUserField = jTUserField;
	}

	public JPasswordField getjPPassField() {
		return jPPassField;
	}
	
	public char[] getResPssFld() {
		return jPPassField.getPassword();
	}

	public void setjPPassField(JPasswordField jPPassField) {
		this.jPPassField = jPPassField;
	}

	public JRadioButton getLogForAdmin() {
		return logForAdmin;
	}

	public void setLogForAdmin(JRadioButton logForAdmin) {
		this.logForAdmin = logForAdmin;
	}

	public JRadioButton getLogForResearcher() {
		return logForResearcher;
	}

	public void setLogForResearcher(JRadioButton logForResearcher) {
		this.logForResearcher = logForResearcher;
	}

	public ButtonGroup getBtnGp() {
		return btnGp;
	}

}
