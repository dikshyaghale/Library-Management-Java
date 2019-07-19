package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Controller.AddNewResearcherController;
import Model.AddNewResearcherModel;

public class AddNewResearcherView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -940248282112215032L;
	//required components for making researcher form
	private JPanel jPAddMainPanel, jPAddHeaderPanel,jPControlPanel, jPAddPanel;
	private JButton jBBackBtn, jBSignoutBtn, jBAddBtn, jBResearchClear;
	private JLabel jLHeaderLbl,jLErr,jLPhneErr, jLControlLbl, jLAddLbl, jLIdLbl, jLResName, jLResAddress, jLResPhone, jLResEmail, jLResUsername, jLResPassord;
	private JTextField jTIdField, jTResName, jTResAddress, jTResPhone, jTResEmail, jTResTUsername, jTResPassword;
	private JPasswordField jPRePass;
	private ImageIcon uniIcon = new ImageIcon("images/uni.jpg");
	private JLabel showVal;
	static int rshId = 500;
	String ResEmail = "dikshyagh1@gmail.com";
		
	//constructor
	public AddNewResearcherView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Northampton Article Management System ");
		setBounds(140,140,750,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(uniIcon.getImage());
		setBackground(Color.white);
		Container cont = getContentPane();
		cont.setLayout(null);
		createAddResearcherGUi();
		setVisible(true);
		
	}

	//method to make add researcher form
	private void createAddResearcherGUi() {
		jPAddMainPanel = new JPanel();
		jPAddMainPanel.setBorder(new EmptyBorder(4,4,4,4));
		jPAddMainPanel.setLayout(null);
		jPAddMainPanel.setBounds(140,140,750,600);
		jPAddMainPanel.setBackground(new Color(245,245,245));
		setContentPane(jPAddMainPanel);
		
		jPAddHeaderPanel = new JPanel();
		jPAddHeaderPanel.setBorder(new EmptyBorder(4,4,4,4));
		jPAddHeaderPanel.setLayout(null);
		jPAddHeaderPanel.setBounds(0,0,750,70);
		jPAddHeaderPanel.setBackground(new Color(0,128,128));
		jPAddMainPanel.add(jPAddHeaderPanel);
		
		jLHeaderLbl = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: ADD RESEARCHER");
		jLHeaderLbl.setBounds(60,15,750,45);
		jLHeaderLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLHeaderLbl.setForeground(new Color(240,255,255));
		jPAddHeaderPanel.add(jLHeaderLbl);
		
		jPControlPanel = new JPanel();
		jPControlPanel.setBounds(0,70,220,700);
		jPControlPanel.setLayout(null);
		jPControlPanel.setBackground(new Color(244,164,96));
		jPAddMainPanel.add(jPControlPanel);
		
		jLControlLbl = new JLabel("Control Buttons");
		jLControlLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLControlLbl.setBounds(10,18,200,30);
		jLControlLbl.setForeground(new Color(240,255,255));
		jPControlPanel.add(jLControlLbl);
		
		jBBackBtn = new JButton("Back");
		jBBackBtn.setBounds(23,60,120,30);
		jBBackBtn.setBorderPainted(false);
		jBBackBtn.setBackground(new Color(245,245,245));
		jBBackBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBBackBtn.setForeground(new Color(0,128,128));
		jPControlPanel.add(jBBackBtn);
		
		jBResearchClear = new JButton("RESET");
		jBResearchClear.setBounds(23,120,120,30);
		jBResearchClear.setBorderPainted(false);
		jBResearchClear.setBackground(new Color(245,245,245));
		jBResearchClear.setFont(new Font("Verdana",Font.PLAIN,17));
		jBResearchClear.setForeground(new Color(0,128,128));
		jPControlPanel.add(jBResearchClear);
		
		jBSignoutBtn = new JButton("Sign out");
		jBSignoutBtn.setBounds(23,180,120,30);
		jBSignoutBtn.setBorderPainted(false);
		jBSignoutBtn.setBackground(new Color(245,245,245));
		jBSignoutBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBSignoutBtn.setForeground(new Color(0,128,128));
		jPControlPanel.add(jBSignoutBtn);
		
		jPAddPanel = new JPanel();
		jPAddPanel.setBounds(220,70,530,700);
		jPAddPanel.setLayout(null);
		jPAddPanel.setBackground(Color.WHITE);
		jPAddMainPanel.add(jPAddPanel);
		
		jLAddLbl = new JLabel("ADD NEW RESEARCHER");
		jLAddLbl.setBounds(120,18,300,30);
		jLAddLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
		jPAddPanel.add(jLAddLbl);
		
		jLIdLbl = new JLabel("ID");
		jLIdLbl.setBounds(40,65,300,30);
		jLIdLbl.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jLIdLbl);
		
		jTIdField = new JTextField();
		jTIdField.setBounds(230,65,150,30);
		jTIdField.setEditable(false);
		jTIdField.setText(Integer.toString(rshId));
		jTIdField.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jTIdField);
		
		jLResName = new JLabel("Name");
		jLResName.setBounds(40,110,300,30);
		jLResName.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jLResName);
		
		jTResName = new JTextField();
		jTResName.setBounds(230,110,150,30);
		jTResName.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jTResName);
		
		jLResAddress = new JLabel("Address");
		jLResAddress.setBounds(40,155,300,30);
		jLResAddress.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jLResAddress);
		
		jTResAddress = new JTextField();
		jTResAddress.setBounds(230,155,150,30);
		jTResAddress.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jTResAddress);
		
		jLResPhone = new JLabel("Phone");
		jLResPhone.setBounds(40,195,300,30);
		jLResPhone.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jLResPhone);
		
		showVal = new JLabel();
		showVal.setBounds(230,223,300,15);
		showVal.setForeground(Color.RED);
		showVal.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(showVal);
		
		jLPhneErr = new JLabel();
		jLPhneErr.setBounds(385,195,150,20);
		jLPhneErr.setForeground(Color.RED);
		jLPhneErr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPAddPanel.add(jLPhneErr);
		
		jTResPhone = new JTextField();
		jTResPhone.setBounds(230,195,150,30);
		//phone number validation
		jTResPhone.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				String phnNum = jTResPhone.getText();
				int numLen = phnNum.length();
				
				char c = e.getKeyChar();

				if((e.getKeyChar()>='0' && e.getKeyChar()<='9') || c == KeyEvent.VK_BACK_SPACE) {
					if(numLen<10 || c == KeyEvent.VK_BACK_SPACE) {
						jTResPhone.setEditable(true);
					}
					else {
						jLPhneErr.setText("Not more than 10");
						jTResPhone.setEditable(false);
					}
				}
				else {
					jLPhneErr.setText("Enter numbers only");
					jTResPhone.setEditable(false);
				}

			}
		});
		jTResPhone.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jTResPhone);
		
		jLResEmail = new JLabel("Email");
		jLResEmail.setBounds(40,240,300,30);
		jLResEmail.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jLResEmail);
		
		jLErr = new JLabel();
		jLErr.setBounds(385,242,150,20);
		jLErr.setForeground(Color.RED);
		jLErr.setFont(new Font("Verdana",Font.PLAIN,10));
		jPAddPanel.add(jLErr);	
		
		jTResEmail = new JTextField();
		jTResEmail.setBounds(230,240,150,30);	
		jTResEmail.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jTResEmail);
		
		jLResUsername = new JLabel("Username");
		jLResUsername.setBounds(40,285,300,30);
		jLResUsername.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jLResUsername);
		
		jTResTUsername = new JTextField();
		jTResTUsername.setBounds(230,285,150,30);
		jTResTUsername.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jTResTUsername);
		
		jLResPassord = new JLabel("Password");
		jLResPassord.setBounds(40,330,300,30);
		jLResPassord.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jLResPassord);
		
		jPRePass = new JPasswordField();
		jPRePass.setBounds(230,330,150,30);
		jPRePass.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddPanel.add(jPRePass);
		
		jBAddBtn = new JButton("ADD");
		jBAddBtn.setBounds(250,385,80,30);
		jBAddBtn.setBorderPainted(false);
		jBAddBtn.setBackground(new Color(245,245,245));
		jBAddBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBAddBtn.setForeground(new Color(0,128,128));
		jPAddPanel.add(jBAddBtn);
		
		AddNewResearcherModel am = new AddNewResearcherModel();
		
		AddNewResearcherController researchCont = new AddNewResearcherController(this);
		researchCont.addResearchCont();
		
	}
	
	//method to make id auto increase
	public void rshInc() {
		String incId = getjTIdField().getText();
		incId = Integer.toString(++rshId);
		setjTIdField(Integer.valueOf(incId));
		getjTIdField().setText(incId);
	}


	//needed getters and setters
	public JPasswordField getjPRePass() {
		return jPRePass;
	}

	public void setjPRePass(JPasswordField jPRePass) {
		this.jPRePass = jPRePass;
	}

	public JPanel getjPAddPanel() {
		return jPAddPanel;
	}

	public void setjPAddPanel(JPanel jPAddPanel) {
		this.jPAddPanel = jPAddPanel;
	}

	public JLabel getjLPhneErr() {
		return jLPhneErr;
	}

	public void setjLPhneErr(JLabel jLPhneErr) {
		this.jLPhneErr = jLPhneErr;
	}

	public JLabel getjLErr() {
		return jLErr;
	}

	public void setjLErr(JLabel jLErr) {
		this.jLErr = jLErr;
	}

	public JButton getjBBackBtn() {
		return jBBackBtn;
	}

	public void setjBBackBtn(JButton jBBackBtn) {
		this.jBBackBtn = jBBackBtn;
	}

	public JButton getjBSignoutBtn() {
		return jBSignoutBtn;
	}

	public void setjBSignoutBtn(JButton jBSignoutBtn) {
		this.jBSignoutBtn = jBSignoutBtn;
	}

	public JButton getjBAddBtn() {
		return jBAddBtn;
	}

	public void setjBAddBtn(JButton jBAddBtn) {
		this.jBAddBtn = jBAddBtn;
	}

	public JTextField getjTIdField() {
		return jTIdField;
	}

	public void setjTIdField(int rshId) {
		this.rshId = rshId;
	}

	public JTextField getjTResName() {
		return jTResName;
	}

	public void setjTResName(JTextField jTResName) {
		this.jTResName = jTResName;
	}

	public JTextField getjTResAddress() {
		return jTResAddress;
	}

	public void setjTResAddress(JTextField jTResAddress) {
		this.jTResAddress = jTResAddress;
	}

	public JTextField getjTResPhone() {
		return jTResPhone;
	}

	public void setjTResPhone(JTextField jTResPhone) {
		this.jTResPhone = jTResPhone;
	}

	public JTextField getjTResEmail() {
		return jTResEmail;
	}
	
	public String getjTReEmail() {
		return jTResEmail.getText();
	}

	public void setjTResEmail(JTextField jTResEmail) {
		this.jTResEmail = jTResEmail;
	}

	public JTextField getjTResTUsername() {
		return jTResTUsername;
	}

	public void setjTResTUsername(JTextField jTResTUsername) {
		this.jTResTUsername = jTResTUsername;
	}

	public void setjTResPassword(JTextField jTResPassword) {
		this.jTResPassword = jTResPassword;
	}

	public JButton getjBResearchClear() {
		return jBResearchClear;
	}

	public void setjBResearchClear(JButton jBResearchClear) {
		this.jBResearchClear = jBResearchClear;
	}
}
