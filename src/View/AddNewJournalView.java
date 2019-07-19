package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.AddNewJourController;
import Model.JournalSerialize;
import Model.ListAllJournalModel;

public class AddNewJournalView extends JFrame {

	private static final long serialVersionUID = 3551430782550163190L;

	//required componnents to design the view of journal form
	private JPanel jPJournalMainPanel, jPJournalHeaderPanel,jPJournalControlPanel,jPAddJournalPanel;
	private JLabel jLJourHeaderLbl,jLJrPgEr,jLError,jLErrIss,jLErrPge,jLDteErMsg, jLJourControl, jLJourAddLbl, jLJourId, jLJourArticTitle, jLJourAuthor, jLjourTitle, jLJourPublishedYear, jLJourVolumeNo, jLIssueNo, jLJourPageNo;
	private JTextField jTJourId, jTJourArticle, jTJourAuthor, jTJourTitle, jTJourPubYear, jTJourVolumeNo, jTJourIssueNo, jTPageNo;
	private JButton jBJourBack, jBJourLogout, jBJourAdd, jBJourClear;
	//for image icons
	private ImageIcon uniIcon = new ImageIcon("images/uni.jpg");
	static int jourId = 100;
	JournalSerialize seriJour = new JournalSerialize();
	ListAllJournalModel ljm;
	
	ArrayList<JournalSerialize> arI = new ArrayList<JournalSerialize>();

	//constructor
	public AddNewJournalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,750,600);
		setTitle("Northampton Article Management System");
		setBackground(Color.white);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(uniIcon.getImage());
		Container cont = getContentPane();
		cont.setLayout(null);
		addJourGUi();
		setVisible(true);
	}

	//method to increase the id by 1
	public void jo() {

		String val = getjTJourId().getText();
		setjTJourId(Integer.valueOf(val));
		val = Integer.toString(++jourId);
		getjTJourId().setText(val);
		
	}

	//method to make add joural form
	private void addJourGUi() {
		jPJournalMainPanel = new JPanel();
		jPJournalMainPanel.setBorder(new EmptyBorder(4,4,4,4));
		jPJournalMainPanel.setLayout(null);
		jPJournalMainPanel.setBounds(140,140,750,600);
		jPJournalMainPanel.setBackground(new Color(245,245,245));
		setContentPane(jPJournalMainPanel);

		jPJournalHeaderPanel = new JPanel();
		jPJournalHeaderPanel.setBorder(new EmptyBorder(4,4,4,4));
		jPJournalHeaderPanel.setLayout(null);
		jPJournalHeaderPanel.setBounds(0,0,750,70);
		jPJournalHeaderPanel.setBackground(new Color(0,128,128));
		jPJournalMainPanel.add(jPJournalHeaderPanel);

		jLJourHeaderLbl = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: ADD JOURNAL");
		jLJourHeaderLbl.setBounds(60,15,750,45);
		jLJourHeaderLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLJourHeaderLbl.setForeground(new Color(240,255,255));
		jPJournalHeaderPanel.add(jLJourHeaderLbl);

		jPJournalControlPanel = new JPanel();
		jPJournalControlPanel.setBounds(0,70,220,700);
		jPJournalControlPanel.setLayout(null);
		jPJournalControlPanel.setBackground(new Color(244,164,96));
		jPJournalMainPanel.add(jPJournalControlPanel);

		jLJourControl = new JLabel("Control here");
		jLJourControl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLJourControl.setBounds(10,18,200,30);
		jLJourControl.setForeground(new Color(240,255,255));
		jPJournalControlPanel.add(jLJourControl);

		jPAddJournalPanel = new JPanel();
		jPAddJournalPanel.setBounds(220,70,530,700);
		jPAddJournalPanel.setLayout(null);
		jPAddJournalPanel.setBackground(Color.WHITE);
		jPJournalMainPanel.add(jPAddJournalPanel);

		jLJourAddLbl = new JLabel("ADD NEW JOURNAL ARTICLE");
		jLJourAddLbl.setBounds(50,18,390,30);
		jLJourAddLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
		jPAddJournalPanel.add(jLJourAddLbl);

		jLJourId = new JLabel("ID");
		jLJourId.setBounds(40,65,300,30);
		jLJourId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLJourId);

		jTJourId = new JTextField();
		jTJourId.setBounds(230,65,150,30);
		jTJourId.setEditable(false);
		jTJourId.setText(Integer.toString(jourId));
		jTJourId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTJourId);

		jLJourArticTitle = new JLabel("Title of article");
		jLJourArticTitle.setBounds(40,110,300,30);
		jLJourArticTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLJourArticTitle);

		jTJourArticle = new JTextField();
		jTJourArticle.setBounds(230,110,150,30);
		jTJourArticle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTJourArticle);

		jLJourAuthor = new JLabel("Author");
		jLJourAuthor.setBounds(40,155,300,30);
		jLJourAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLJourAuthor);

		jTJourAuthor = new JTextField();
		jTJourAuthor.setBounds(230,155,150,30);
		jTJourAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTJourAuthor);

		jLjourTitle = new JLabel("Title of journal");
		jLjourTitle.setBounds(40,195,300,30);
		jLjourTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLjourTitle);

		jTJourTitle = new JTextField();
		jTJourTitle.setBounds(230,195,150,30);
		jTJourTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTJourTitle);

		jLJourPublishedYear = new JLabel("Published year");
		jLJourPublishedYear.setBounds(40,240,300,30);
		jLJourPublishedYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLJourPublishedYear);

		jLDteErMsg = new JLabel();
		jLDteErMsg.setBounds(230,269,220,10);
		jLDteErMsg.setForeground(Color.RED);
		jLDteErMsg.setFont(new Font("Verdana",Font.PLAIN,10));
		jPAddJournalPanel.add(jLDteErMsg);
		
		jTJourPubYear = new JTextField();
		jTJourPubYear.setBounds(230,240,150,30);
		jTJourPubYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTJourPubYear);

		jLJourVolumeNo = new JLabel("Volume Number");
		jLJourVolumeNo.setBounds(40,285,300,30);
		jLJourVolumeNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLJourVolumeNo);

		jLError = new JLabel();
		jLError.setBounds(390,290,140,12);
		jLError.setForeground(Color.RED);
		jLError.setFont(new Font("Verdana",Font.PLAIN,12));
		jPAddJournalPanel.add(jLError);

		jTJourVolumeNo = new JTextField();
		//make fields accept numbres only
		jTJourVolumeNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char c = e.getKeyChar();

				if(!(Character.isDigit(c)) ||(c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
					jLError.setText("Numbers only");
					e.consume();
					}
				else {
					jLError.setText("");
				}
				}
		});

		jTJourVolumeNo.setBounds(230,285,150,30);
		jTJourVolumeNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTJourVolumeNo);

		jLIssueNo = new JLabel("Issue Number");
		jLIssueNo.setBounds(40,330,300,30);
		jLIssueNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLIssueNo);
		
		jLErrIss = new JLabel();
		jLErrIss.setBounds(390,340,140,12);
		jLErrIss.setForeground(Color.RED);
		jLErrIss.setFont(new Font("Verdana",Font.PLAIN,12));
		jPAddJournalPanel.add(jLErrIss);

		jTJourIssueNo = new JTextField();
		jTJourIssueNo.setBounds(230,330,150,30);
		jTJourIssueNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char cchar = e.getKeyChar();

				if(!(Character.isDigit(cchar)) ||(cchar==KeyEvent.VK_BACK_SPACE) || (cchar==KeyEvent.VK_DELETE)){
					jLErrIss.setText("Numbers only");
					e.consume();
					}
				else {
					jLErrIss.setText("");
				}
				}
		});
		jTJourIssueNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTJourIssueNo);

		jLJourPageNo = new JLabel("Page Nmber");
		jLJourPageNo.setBounds(40,375,300,30);
		jLJourPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jLJourPageNo);
		
		jLJrPgEr = new JLabel();
		jLJrPgEr.setBounds(390,388,140,12);
		jLJrPgEr.setForeground(Color.RED);
		jLJrPgEr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPAddJournalPanel.add(jLJrPgEr);

		jTPageNo = new JTextField();
		jTPageNo.setBounds(230,375,150,30);
		//accepting numbers olny
		jTPageNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent event) {
				char caPge = event.getKeyChar();

				if(!(Character.isDigit(caPge)) ||(caPge==KeyEvent.VK_BACK_SPACE) || (caPge==KeyEvent.VK_DELETE)){
					jLJrPgEr.setText("Numbers only");
					event.consume();
					}
				else {
					jLJrPgEr.setText("");
					}
				}
		});
		jTPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAddJournalPanel.add(jTPageNo);

		jBJourBack = new JButton("Back");
		jBJourBack.setBounds(23,70,120,30);
		jBJourBack.setBorderPainted(false);
		jBJourBack.setBackground(new Color(245,245,245));
		jBJourBack.setFont(new Font("Verdana",Font.PLAIN,17));
		jBJourBack.setForeground(new Color(0,128,128));
		jPJournalControlPanel.add(jBJourBack);

		jBJourClear = new JButton("RESET");
		jBJourClear.setBounds(23,130,120,30);
		jBJourClear.setBorderPainted(false);
		jBJourClear.setBackground(new Color(245,245,245));
		jBJourClear.setFont(new Font("Verdana",Font.PLAIN,17));
		jBJourClear.setForeground(new Color(0,128,128));
		jPJournalControlPanel.add(jBJourClear);

		jBJourLogout = new JButton("Sign out");
		jBJourLogout.setBounds(23,190,120,30);
		jBJourLogout.setBorderPainted(false);
		jBJourLogout.setBackground(new Color(245,245,245));
		jBJourLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBJourLogout.setForeground(new Color(0,128,128));
		jPJournalControlPanel.add(jBJourLogout);

		jBJourAdd = new JButton("ADD");
		jBJourAdd.setBounds(250,420,80,30);
		jBJourAdd.setBorderPainted(false);
		jBJourAdd.setBackground(new Color(245,245,245));
		jBJourAdd.setFont(new Font("Verdana",Font.PLAIN,17));
		jBJourAdd.setForeground(new Color(0,128,128));
		jPAddJournalPanel.add(jBJourAdd);
		
		AddNewJourController journalCont = new AddNewJourController(this);
		journalCont.addJourCont();
	}

	//getters and setters

	public JLabel getjLErrIss() {
		return jLErrIss;
	}

	public void setjLErrIss(JLabel jLErrIss) {
		this.jLErrIss = jLErrIss;
	}

	public JLabel getjLErrPge() {
		return jLErrPge;
	}

	public void setjLErrPge(JLabel jLErrPge) {
		this.jLErrPge = jLErrPge;
	}

	public JLabel getjLDteErMsg() {
		return jLDteErMsg;
	}

	public void setjLDteErMsg(JLabel jLDteErMsg) {
		this.jLDteErMsg = jLDteErMsg;
	}

	public JTextField getjTJourId() {
		return jTJourId;
	}

	@SuppressWarnings("static-access")
	public void setjTJourId(int jourId) {
		this.jourId = jourId;
	}

	public JTextField getjTJourArticle() {
		return jTJourArticle;
	}

	public void setjTJourArticle(JTextField jTJourArticle) {
		this.jTJourArticle = jTJourArticle;
	}

	public JTextField getjTJourAuthor() {
		return jTJourAuthor;
	}

	public void setjTJourAuthor(JTextField jTJourAuthor) {
		this.jTJourAuthor = jTJourAuthor;
	}

	public JTextField getjTJourTitle() {
		return jTJourTitle;
	}

	public void setjTJourTitle(JTextField jTJourTitle) {
		this.jTJourTitle = jTJourTitle;
	}

	public JTextField getjTJourPubYear() {
		return jTJourPubYear;
	}

	public void setjTJourPubYear(JTextField jTJourPubYear) {
		this.jTJourPubYear = jTJourPubYear;
	}

	public JTextField getjTJourVolumeNo() {
		return jTJourVolumeNo;
	}

	public void setjTJourVolumeNo(JTextField jTJourVolumeNo) {
		this.jTJourVolumeNo = jTJourVolumeNo;
	}

	public JButton getjBJourClear() {
		return jBJourClear;
	}

	public void setjBJourClear(JButton jBJourClear) {
		this.jBJourClear = jBJourClear;
	}

	public JTextField getjTJourIssueNo() {
		return jTJourIssueNo;
	}

	public void setjTJourIssueNo(JTextField jTJourIssueNo) {
		this.jTJourIssueNo = jTJourIssueNo;
	}

	public JTextField getjTPageNo() {
		return jTPageNo;
	}

	public void setjTPageNo(JTextField jTPageNo) {
		this.jTPageNo = jTPageNo;
	}

	public JButton getjBJourBack() {
		return jBJourBack;
	}

	public void setjBJourBack(JButton jBJourBack) {
		this.jBJourBack = jBJourBack;
	}

	public JButton getjBJourLogout() {
		return jBJourLogout;
	}

	public void setjBJourLogout(JButton jBJourLogout) {
		this.jBJourLogout = jBJourLogout;
	}

	public JButton getjBJourAdd() {
		return jBJourAdd;
	}

	public void setjBJourAdd(JButton jBJourAdd) {
		this.jBJourAdd = jBJourAdd;
	}

}
