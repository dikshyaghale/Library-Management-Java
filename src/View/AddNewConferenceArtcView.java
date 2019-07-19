package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.AddNewConferenceController;

public class AddNewConferenceArtcView extends JFrame {
	
	private static final long serialVersionUID = -5764317442075246752L;
	private JPanel jPConferenceMainPanel, jPConferenceHeader, jPConferenceControl, jPConferenceAddPanel;
	private JLabel jLConHeaderLbl,jLConPEr,jLConYEr, jLConControlLbl, jLConAddLbl, jLConIdLbl, jLConTitle, jLConAuthor, jLConPublishedYear, jLConEditors, jLConLocation, jLConPageNo;
	private JTextField jTConId, jTConTitle, jTConAuthor, jTConPublishedYear, jTConEditors, jTConLocation, jTConPageNo;
	private JButton jBConBack, jBConLogout, jBConAddBtn, jBConClear;
	private ImageIcon uonIcon = new ImageIcon("images/uni.jpg");
	static int cArId = 0;
	
	
	public AddNewConferenceArtcView()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,750,600);
		setResizable(false);
		setTitle("Northampton Article Management System ");
		setIconImage(uonIcon.getImage());
		setBackground(Color.white);
		setLocationRelativeTo(null);
		Container cont = getContentPane();
		cont.setLayout(null);
		makeConAddGUi();
		setVisible(true);
	}

	private void makeConAddGUi() {
		jPConferenceMainPanel = new JPanel();
		jPConferenceMainPanel.setBorder(new EmptyBorder(4,4,4,4));
		jPConferenceMainPanel.setLayout(null);
		jPConferenceMainPanel.setBounds(140,140,750,600);
		jPConferenceMainPanel.setBackground(new Color(245,245,245));
		setContentPane(jPConferenceMainPanel);
		
		jPConferenceHeader = new JPanel();
		jPConferenceHeader.setBorder(new EmptyBorder(4,4,4,4));
		jPConferenceHeader.setLayout(null);
		jPConferenceHeader.setBounds(0,0,750,70);
		jPConferenceHeader.setBackground(new Color(0,128,128));
		jPConferenceMainPanel.add(jPConferenceHeader);
		
		jLConHeaderLbl = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: ADD CONFERENCE ARTICLE");
		jLConHeaderLbl.setBounds(0,15,750,45);
		jLConHeaderLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLConHeaderLbl.setForeground(new Color(240,255,255));
		jPConferenceHeader.add(jLConHeaderLbl);
		
		jPConferenceControl = new JPanel();
		jPConferenceControl.setBounds(0,70,220,700);
		jPConferenceControl.setLayout(null);
		jPConferenceControl.setBackground(new Color(244,164,96));
		jPConferenceMainPanel.add(jPConferenceControl);
		
		jLConControlLbl = new JLabel("Control here");
		jLConControlLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLConControlLbl.setBounds(10,18,200,30);
		jLConControlLbl.setForeground(new Color(240,255,255));
		jPConferenceControl.add(jLConControlLbl);
		
		jPConferenceAddPanel = new JPanel();
		jPConferenceAddPanel.setBounds(220,70,530,700);
		jPConferenceAddPanel.setLayout(null);
		jPConferenceAddPanel.setBackground(Color.WHITE);
		jPConferenceMainPanel.add(jPConferenceAddPanel);
		
		jLConAddLbl = new JLabel("ADD NEW CONFERENCE ARTICLE");
		jLConAddLbl.setBounds(50,18,430,30);
		jLConAddLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
		jPConferenceAddPanel.add(jLConAddLbl);
		
		jLConIdLbl = new JLabel("ID");
		jLConIdLbl.setBounds(40,65,300,30);
		jLConIdLbl.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jLConIdLbl);
		
		jTConId = new JTextField();
		jTConId.setBounds(230,65,150,30);
		jTConId.setText(Integer.toString(cArId));
		jTConId.setEditable(false);
		jTConId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jTConId);
		
		jLConTitle = new JLabel("Title of Article");
		jLConTitle.setBounds(40,110,300,30);
		jLConTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jLConTitle);
		 
		jTConTitle = new JTextField();
		jTConTitle.setBounds(230,110,150,30);
		jTConTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jTConTitle);
		
		jLConAuthor = new JLabel("Author");
		jLConAuthor.setBounds(40,155,300,30);
		jLConAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jLConAuthor);
		
		jTConAuthor = new JTextField();
		jTConAuthor.setBounds(230,155,150,30);
		jTConAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jTConAuthor);
		
		jLConPublishedYear = new JLabel("Published Year");
		jLConPublishedYear.setBounds(40,195,300,30);
		jLConPublishedYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jLConPublishedYear);
		
		jLConYEr = new JLabel();
		jLConYEr.setBounds(230,230,140,12);
		jLConYEr.setForeground(Color.RED);
		jLConYEr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPConferenceAddPanel.add(jLConYEr);
		
		jTConPublishedYear = new JTextField();
		jTConPublishedYear.setBounds(230,195,150,30);
		jTConPublishedYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jTConPublishedYear);
		 
		jLConEditors = new JLabel("Editors");
		jLConEditors.setBounds(40,240,300,30);
		jLConEditors.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jLConEditors);
		
		jTConEditors = new JTextField();
		jTConEditors.setBounds(230,240,150,30);
		jTConEditors.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jTConEditors);
		
		jLConLocation = new JLabel("Location");
		jLConLocation.setBounds(40,285,300,30);
		jLConLocation.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jLConLocation);
		
		jTConLocation = new JTextField();
		jTConLocation.setBounds(230,285,150,30);
		jTConLocation.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jTConLocation);
		
		jLConPageNo = new JLabel("Page Number");
		jLConPageNo.setBounds(40,330,300,30);
		jLConPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jLConPageNo);
		
		jLConPEr = new JLabel();
		jLConPEr.setBounds(230,359,140,12);
		jLConPEr.setForeground(Color.RED);
		jLConPEr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPConferenceAddPanel.add(jLConPEr);
		
		jTConPageNo = new JTextField();
		jTConPageNo.setBounds(230,330,150,30);
		jTConPageNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char c = e.getKeyChar();

				if(!(Character.isDigit(c)) ||(c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
					jLConPEr.setText("Numbers only");
					e.consume();
					}
				else {
					jLConPEr.setText("");
				}
				}
		});
		jTConPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPConferenceAddPanel.add(jTConPageNo);
		
		jBConAddBtn = new JButton("ADD");
		jBConAddBtn.setBackground(new Color(245,245,245));
		jBConAddBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBConAddBtn.setBounds(250,420,80,30);
		jBConAddBtn.setBorderPainted(false);
		jBConAddBtn.setForeground(new Color(0,128,128));
		jPConferenceAddPanel.add(jBConAddBtn);
		
		jBConBack = new JButton("BACK");
		jBConBack.setBounds(23,70,140,30);
		jBConBack.setBorderPainted(false);
		jBConBack.setBackground(new Color(245,245,245));
		jBConBack.setFont(new Font("Verdana",Font.PLAIN,17));
		jBConBack.setForeground(new Color(0,128,128));
		jPConferenceControl.add(jBConBack);
		
		jBConClear = new JButton("RESET");
		jBConClear.setBounds(23,130,140,30);
		jBConClear.setBorderPainted(false);
		jBConClear.setBackground(new Color(245,245,245));
		jBConClear.setFont(new Font("Verdana",Font.PLAIN,17));
		jBConClear.setForeground(new Color(0,128,128));
		jPConferenceControl.add(jBConClear);
		
		jBConLogout = new JButton("SIGN OUT");
		jBConLogout.setBounds(23,190,140,30);
		jBConLogout.setBorderPainted(false);
		jBConLogout.setBackground(new Color(245,245,245));
		jBConLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBConLogout.setForeground(new Color(0,128,128));
		jPConferenceControl.add(jBConLogout);
		
		AddNewConferenceController addNewCon = new AddNewConferenceController(this);
		addNewCon.AddContractCont();
	}
	
	public void cArcId() {
		String tfCI = getjTConId().getText();
		setjTConId(Integer.valueOf(tfCI));
		tfCI = Integer.toString(++cArId);
		getjTConId().setText(tfCI);
	}

	public JLabel getjLConYEr() {
		return jLConYEr;
	}

	public void setjLConYEr(JLabel jLConYEr) {
		this.jLConYEr = jLConYEr;
	}

	public JTextField getjTConId() {
		return jTConId;
	}

	public void setjTConId(int cArId) {
		this.cArId = cArId;
	}

	public JButton getjBConClear() {
		return jBConClear;
	}

	public void setjBConClear(JButton jBConClear) {
		this.jBConClear = jBConClear;
	}

	public JTextField getjTConTitle() {
		return jTConTitle;
	}

	public void setjTConTitle(JTextField jTConTitle) {
		this.jTConTitle = jTConTitle;
	}

	public JTextField getjTConAuthor() {
		return jTConAuthor;
	}

	public void setjTConAuthor(JTextField jTConAuthor) {
		this.jTConAuthor = jTConAuthor;
	}

	public JTextField getjTConPublishedYear() {
		return jTConPublishedYear;
	}

	public void setjTConPublishedYear(JTextField jTConPublishedYear) {
		this.jTConPublishedYear = jTConPublishedYear;
	}

	public JTextField getjTConEditors() {
		return jTConEditors;
	}

	public void setjTConEditors(JTextField jTConEditors) {
		this.jTConEditors = jTConEditors;
	}

	public JTextField getjTConLocation() {
		return jTConLocation;
	}

	public void setjTConLocation(JTextField jTConLocation) {
		this.jTConLocation = jTConLocation;
	}

	public JTextField getjTConPageNo() {
		return jTConPageNo;
	}

	public void setjTConPageNo(JTextField jTConPageNo) {
		this.jTConPageNo = jTConPageNo;
	}

	public JButton getjBConBack() {
		return jBConBack;
	}

	public void setjBConBack(JButton jBConBack) {
		this.jBConBack = jBConBack;
	}

	public JButton getjBConLogout() {
		return jBConLogout;
	}

	public void setjBConLogout(JButton jBConLogout) {
		this.jBConLogout = jBConLogout;
	}

	public JButton getjBConAddBtn() {
		return jBConAddBtn;
	}
}
