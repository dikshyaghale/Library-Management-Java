package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controller.AftrRshLogContrlr;
import Controller.ListAllBookController;
import Controller.ListAllConferenceController;
import Controller.ListAllJournalController;
import Controller.ResearcherLoginController;
import Model.ListAllBookModel;
import Model.ListAllConferenceModel;
import Model.ListAllJournalModel;
import Model.ResearcherLoginModel;

public class AvailableArtcVw extends JFrame{
	
	private static final long serialVersionUID = 8812144397407220129L;

	//needed components for making view of available articles
	private JPanel jPAfrManPnl, jPAfrHeadr, jPAfrCtrl;
	private JLabel jLHeadrLbl,jLCtrl, jLarctl,jLAvlJour, jLAvlCon, jLValBook;
	private JButton jBAfrlgOut,jBJoBrr,jBBokBrr, jBConBrr,jBAfrExit;
	
	//for image icon
	private ImageIcon frImg = new ImageIcon("images/uni.jpg");
	private ImageIcon otBtn = new ImageIcon("images/logout.png");
	private JTable jTabJourTable = new JTable();
	private JScrollPane jSJournalPane;
	
	//for table
	private JTable jTabCon = new JTable();
	private JScrollPane jSConScrl;
	
	private JTable jTabBokTble = new JTable();
	private JScrollPane jSBok;

	//making constructor
	public AvailableArtcVw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setIconImage(frImg.getImage());
		setBounds(290,40,900,670);
		Container con = getContentPane();
		con.setLayout(null);
		viewAvailble();
		setVisible(true);
	}


	//method to make design of available articles
	private void viewAvailble() {
		jPAfrManPnl = new JPanel();
		jPAfrManPnl.setBounds(290,0,900,750);
		jPAfrManPnl.setLayout(null);
		jPAfrManPnl.setBackground(new Color(245,245,245));
		setContentPane(jPAfrManPnl);
		
		jPAfrHeadr = new JPanel();
		jPAfrHeadr.setBorder(new EmptyBorder(4,4,4,4));
		jPAfrHeadr.setLayout(null);
		jPAfrHeadr.setBounds(0,0,900,70);
		jPAfrHeadr.setBackground(new Color(0,128,128));
		jPAfrManPnl.add(jPAfrHeadr);
		
		jLHeadrLbl = new JLabel("WELCOME RESEARCHER: VIEW AVAILABLE ARTICLES HERE");
		jLHeadrLbl.setBounds(90,15,850,45);
		jLHeadrLbl.setForeground(new Color(240,255,255));
		jLHeadrLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jPAfrHeadr.add(jLHeadrLbl);
		
		jPAfrCtrl = new JPanel();
		jPAfrCtrl.setLayout(null);
		jPAfrCtrl.setBackground(new Color(244,164,96));
		jPAfrCtrl.setBounds(0,70,180,700);
		jPAfrManPnl.add(jPAfrCtrl);
		
		jLCtrl = new JLabel("Borrowed");
		jLCtrl.setBounds(15,18,200,30);
		jLCtrl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLCtrl.setForeground(new Color(240,255,255));
		jPAfrCtrl.add(jLCtrl);
	
		jLarctl = new JLabel("Articles Here");
		jLarctl.setBounds(5,45,210,30);
		jLarctl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLarctl.setForeground(new Color(240,255,255));
		jPAfrCtrl.add(jLarctl);
		
		jBAfrlgOut = new JButton(otBtn);
		jBAfrlgOut.setBounds(840,15,35,36);
		jPAfrManPnl.add(jBAfrlgOut);
		jBJoBrr = new JButton("Journal");
		jBJoBrr.setBounds(10,90,160,30);
		jBJoBrr.setBorderPainted(false);
		jBJoBrr.setBackground(new Color(245,245,245));
		jBJoBrr.setFont(new Font("Verdana",Font.PLAIN,17));
		jBJoBrr.setForeground(new Color(0,128,128));
		jPAfrCtrl.add(jBJoBrr);
		
		jBConBrr = new JButton("Conference");
		jBConBrr.setBounds(10,140,160,30);
		jBConBrr.setBorderPainted(false);
		jBConBrr.setBackground(new Color(245,245,245));
		jBConBrr.setFont(new Font("Verdana",Font.PLAIN,17));
		jBConBrr.setForeground(new Color(0,128,128));
		jPAfrCtrl.add(jBConBrr);
		
		jBBokBrr = new JButton("Book");
		jBBokBrr.setBounds(10,195,160,30);
		jBBokBrr.setBorderPainted(false);
		jBBokBrr.setBackground(new Color(245,245,245));
		jBBokBrr.setFont(new Font("Verdana",Font.PLAIN,17));
		jBBokBrr.setForeground(new Color(0,128,128));
		jPAfrCtrl.add(jBBokBrr);
		
		jBAfrExit = new JButton("Exit");
		jBAfrExit.setBounds(10,245,160,30);
		jBAfrExit.setBorderPainted(false);
		jBAfrExit.setBackground(new Color(245,245,245));
		jBAfrExit.setFont(new Font("Verdana",Font.PLAIN,17));
		jBAfrExit.setForeground(new Color(0,128,128));
		jPAfrCtrl.add(jBAfrExit);
		
		jLAvlJour = new JLabel("AVAILABLE JOURNAL ARTICLES");
		jLAvlJour.setBounds(350,75,450,20);
		jLAvlJour.setFont(new Font("Lucida Handwriting",Font.BOLD,16));
		jPAfrManPnl.add(jLAvlJour);
		
		jLAvlCon = new JLabel("AVAILABLE CONFERENCE ARTICLES");
		jLAvlCon.setBounds(350,280,450,20);
		jLAvlCon.setFont(new Font("Lucida Handwriting",Font.BOLD,16));
		jPAfrManPnl.add(jLAvlCon);
		
		jLValBook = new JLabel("AVAILABLE BOOK CHAPTERS");
		jLValBook.setBounds(350,470,450,20);
		jLValBook.setFont(new Font("Lucida Handwriting",Font.BOLD,16));
		jPAfrManPnl.add(jLValBook);
		
		AftrRshLogContrlr aftVw = new AftrRshLogContrlr(this);
		aftVw.mainRshCon();
		
		//for making available journal table
		@SuppressWarnings("unused")
		ListAllJournalModel jrM = new ListAllJournalModel();

		ListAllJournalController jc = new ListAllJournalController(this);
		jc.listAvlTble();
		
		jSJournalPane = new JScrollPane(jTabJourTable);
		jSJournalPane.setBounds(180,100,720,150);
		jSJournalPane.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAfrManPnl.add(jSJournalPane);
		
		//for making available conference table
		@SuppressWarnings("unused")
		ListAllConferenceModel lcm = new ListAllConferenceModel();
		
		ListAllConferenceController lACc = new ListAllConferenceController(this);
		lACc.avlView();
		
		jSConScrl = new JScrollPane(jTabCon);
		jSConScrl.setBounds(180,305,720,150);
		jSConScrl.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAfrManPnl.add(jSConScrl);
		
		//for making available book table
		@SuppressWarnings("unused")
		ListAllBookModel lABm = new ListAllBookModel();
		
		ListAllBookController alBoC = new ListAllBookController(this);
		alBoC.listBokTble();
		
		jSBok = new JScrollPane(jTabBokTble);
		jSBok.setBounds(180,500,720,150);
		jSBok.setFont(new Font("Verdana",Font.PLAIN,17));
		jPAfrManPnl.add(jSBok);
		
	}
	
	//needed getters and setters
	public void setjTabBokTble(JTable jTabBokTble) {
		this.jTabBokTble = jTabBokTble;
	}


	public JScrollPane getjSBok() {
		return jSBok;
	}


	public JButton getjBAfrlgOut() {
		return jBAfrlgOut;
	}


	public void setjBAfrlgOut(JButton jBAfrlgOut) {
		this.jBAfrlgOut = jBAfrlgOut;
	}


	public JButton getjBJoBrr() {
		return jBJoBrr;
	}


	public void setjBJoBrr(JButton jBJoBrr) {
		this.jBJoBrr = jBJoBrr;
	}


	public JButton getjBBokBrr() {
		return jBBokBrr;
	}


	public void setjBBokBrr(JButton jBBokBrr) {
		this.jBBokBrr = jBBokBrr;
	}


	public JButton getjBConBrr() {
		return jBConBrr;
	}


	public void setjBConBrr(JButton jBConBrr) {
		this.jBConBrr = jBConBrr;
	}


	public JButton getjBAfrExit() {
		return jBAfrExit;
	}


	public void setjBAfrExit(JButton jBAfrExit) {
		this.jBAfrExit = jBAfrExit;
	}


	public void setjSBok(JScrollPane jSBok) {
		this.jSBok = jSBok;
	}
	
	public JTable getjTabCon() {
		return jTabCon;
	}


	public void setjTabCon(JTable jTabCon) {
		this.jTabCon = jTabCon;
	}


	public JScrollPane getjSConScrl() {
		return jSConScrl;
	}


	public void setjSConScrl(JScrollPane jSConScrl) {
		this.jSConScrl = jSConScrl;
	}


	public JTable getjTabBokTble() {
		return jTabBokTble;
	}

	
	public JTable getjTabJourTable() {
		return jTabJourTable;
	}
	
	public void setjTabJourTable(JTable jTabJourTable) {
		this.jTabJourTable = jTabJourTable;
	}

	public JScrollPane getjSJournalPane() {
		return jSJournalPane;
	}

	public void setjSJournalPane(JScrollPane jSJournalPane) {
		this.jSJournalPane = jSJournalPane;
	}
	
}
