package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.AftrRshLogContrlr;
import Controller.ListAllJournalController;
import Controller.ResearcherLoginController;
import Model.ListAllJournalModel;
import Model.ResearcherLoginModel;

public class BorrJrnlDesign extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//required attributes
	
	//panel components
	private JPanel jPListJournalMain, jPListJournalHeader, jPListJourControl, jPListJourEdit, jPListJourDelt;
	//label components
	private JLabel jLListJourHeader,jLRshNme,jLPgeE,jLErIss,jLError,jLDtEr, jLListJourControl, jLListJourEdit, jLListJourDelt, jLJourId, jLJourArticTitle, jLJourAuthor, jLjourTitle, jLJourPublishedYear, jLJourVolumeNo, jLIssueNo, jLJourPageNo;
	//attributes of required textfield components
	private JTextField jTJourId, jTRshEntName, jTJourArticle, jTJourAuthor, jTJourTitle, jTJourPubYear, jTJourVolumeNo, jTJourIssueNo, jTPageNo;
	//component of jbutton
	private JButton jBListJourBack,jBListJourReturn,jBListJourLogout,jBListJourDelt, jBListJourAddNew;
	private ImageIcon univerImage = new ImageIcon("images/uni.jpg");
	
	//components for jtable
	private JTable jTabJourTable;
	private JScrollPane jSJournalPane;
	
	private int primaryId;
	
	//constructor
	public BorrJrnlDesign() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,900,600);
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setIconImage(univerImage.getImage());
		setTitle("Northampton Article Management System ");
		setResizable(false);
		Container content = getContentPane();
		content.setLayout(null);
		ListJournalGUi();
		showInEditPanel();
		setVisible(true);
	}
	public void fixJourVals(String idJour,String titleArticleJour,String authorJour,String titleJour,String yearPubJour,String volumeJour,String issueJour, String pageJour ) {
		this.jTJourId.setText(idJour);
		this.jTJourArticle.setText(titleArticleJour);
		this.jTJourAuthor.setText(authorJour);
		this.jTJourTitle.setText(titleJour);
		this.jTJourPubYear.setText(yearPubJour);
		this.jTJourVolumeNo.setText(volumeJour);
		this.jTJourIssueNo.setText(issueJour);
		this.jTPageNo.setText(pageJour);
	}
	
	//method to set the selected rows in the textfield of edit panel
	public void showInEditPanel() {
		
		jTabJourTable.addMouseListener(new java.awt.event.MouseAdapter() {
			
			@SuppressWarnings("unused")
			public void mouseClicked(java.awt.event.MouseEvent eve) {
				int cols;
				String sIdJour, sArtTitleJour, sAuthorJour,sTitleJour, sYearJour, sVolJour, sIssueJour, sPagejour;
				DefaultTableModel tabJrnl = (DefaultTableModel)jTabJourTable. getModel();
				
				cols = jTabJourTable.getSelectedRow();
				sIdJour = tabJrnl.getValueAt(cols, 0).toString();
				sArtTitleJour = tabJrnl.getValueAt(cols, 1).toString();
				sAuthorJour = tabJrnl.getValueAt(cols, 2).toString();
				sTitleJour = tabJrnl.getValueAt(cols, 3).toString();
				sYearJour = tabJrnl.getValueAt(cols, 4).toString();
				sVolJour = tabJrnl.getValueAt(cols, 5).toString();
				sIssueJour = tabJrnl.getValueAt(cols, 6).toString();
				sPagejour = tabJrnl.getValueAt(cols, 7).toString();
				fixJourVals(sIdJour,sArtTitleJour, sAuthorJour,sTitleJour, sYearJour, sVolJour, sIssueJour, sPagejour);
				idSet(jTabJourTable.getSelectedRow());
			}
		});
		
	}

	//making GUI
	private void ListJournalGUi() {
		jPListJournalMain = new JPanel();
		jPListJournalMain.setLayout(null);
		jPListJournalMain.setBackground(new Color(245,245,245));
		jPListJournalMain.setBounds(140,140,900,720);
		setContentPane(jPListJournalMain);
		
		jPListJournalHeader = new JPanel();
		jPListJournalHeader.setLayout(null);
		jPListJournalHeader.setBounds(0,0,900,70);
		jPListJournalHeader.setBackground(new Color(0,128,128));
		jPListJournalMain.add(jPListJournalHeader);
		
		jLListJourHeader = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: VIEW BORROWED JOURNAL");
		jLListJourHeader.setForeground(new Color(240,255,255));
		jLListJourHeader.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLListJourHeader.setBounds(80,15,750,45);
		jPListJournalHeader.add(jLListJourHeader);	
		
		jPListJourControl = new JPanel();
		jPListJourControl.setLayout(null);
		jPListJourControl.setBackground(new Color(244,164,96));
		jPListJourControl.setBounds(0,70,180,700);
		jPListJournalMain.add(jPListJourControl);
		
		jLListJourControl = new JLabel("Controls here");
		jLListJourControl.setBounds(5,18,180,30);
		jLListJourControl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLListJourControl.setForeground(new Color(240,255,255));
		jPListJourControl.add(jLListJourControl);
		
		jPListJourEdit = new JPanel();
		jPListJourEdit.setBackground(Color.WHITE);
		jPListJourEdit.setLayout(null);
		jPListJourEdit.setBounds(180,290,720,270);
		jPListJournalMain.add(jPListJourEdit);
		
		jLListJourEdit = new JLabel("RETURN JOURNAL ARTICLE");
		jLListJourEdit.setBounds(180,0,450,30);
		jLListJourEdit.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListJourEdit.add(jLListJourEdit);
		
		jLJourArticTitle = new JLabel("Title of article");
		jLJourArticTitle.setBounds(20,40,300,30);
		jLJourArticTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourArticTitle);
		
		jTJourArticle = new JTextField();
		jTJourArticle.setBounds(160,40,150,30);
		jTJourArticle.setEditable(false);
		jTJourArticle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourArticle);
		
		jLJourAuthor = new JLabel("Author");
		jLJourAuthor.setBounds(20,90,300,30);
		jLJourAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourAuthor);
		
		jTJourAuthor = new JTextField();
		jTJourAuthor.setBounds(160,90,150,30);
		jTJourAuthor.setEditable(false);
		jTJourAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourAuthor);
		
		jLjourTitle = new JLabel("Title of journal");
		jLjourTitle.setBounds(20,140,300,30);
		jLjourTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLjourTitle);
		
		jTJourTitle = new JTextField();
		jTJourTitle.setBounds(160,140,150,30);
		jTJourTitle.setEditable(false);
		jTJourTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourTitle);
		
		jLJourPublishedYear = new JLabel("Published year");
		jLJourPublishedYear.setBounds(20,190,300,30);
		jLJourPublishedYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourPublishedYear);
		
		jLDtEr = new JLabel();
		jLDtEr.setBounds(165,220,200,10);
		jLDtEr.setForeground(Color.RED);
		jLDtEr.setFont(new Font("Verdana",Font.PLAIN,10));
		jPListJourEdit.add(jLDtEr);
		
		jLJourId = new JLabel("Journal ID");
		jLJourId.setBounds(375,190,300,30);
		jLJourId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourId);
		
		jTJourId = new JTextField();
		jTJourId.setBounds(535,190,150,30);
		jTJourId.setEditable(false);
		jTJourId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourId);
		
		jTJourPubYear = new JTextField();
		jTJourPubYear.setBounds(160,190,150,30);
		jTJourPubYear.setEditable(false);
		jTJourPubYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourPubYear);
		
		jLJourVolumeNo = new JLabel("Volume Number");
		jLJourVolumeNo.setBounds(375,40,300,30);
		jLJourVolumeNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourVolumeNo);
		
		jLError = new JLabel();
		jLError.setBounds(535,68,140,10);
		jLError.setForeground(Color.RED);
		jLError.setFont(new Font("Verdana",Font.PLAIN,10));
		jPListJourEdit.add(jLError);
		
		jTJourVolumeNo = new JTextField();
		jTJourVolumeNo.setBounds(530,40,150,30);
		jTJourVolumeNo.setEditable(false);
		jTJourVolumeNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jTJourVolumeNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char c = e.getKeyChar();

				if(!(Character.isDigit(c)) ||(c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)){
					jLError.setText("Number only");
					e.consume();
					}
				else {
					jLError.setText("");
					}
				}
		});
		jPListJourEdit.add(jTJourVolumeNo);
		
		jLIssueNo = new JLabel("Issue Number");
		jLIssueNo.setBounds(375,90,300,30);
		jLIssueNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLIssueNo);
		
		jLErIss = new JLabel();
		jLErIss.setBounds(535,120,150,10);
		jLErIss.setForeground(Color.RED);
		jLErIss.setFont(new Font("Verdana",Font.PLAIN,10));
		jPListJourEdit.add(jLErIss);
		
		jTJourIssueNo = new JTextField();
		jTJourIssueNo.setBounds(530,90,150,30);
		jTJourIssueNo.setEditable(false);
		jTJourIssueNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char chIss = e.getKeyChar();

				if(!(Character.isDigit(chIss)) ||(chIss==KeyEvent.VK_BACK_SPACE) || (chIss==KeyEvent.VK_DELETE)){
					jLErIss.setText("Number only");
					e.consume();
					}
				else {
					jLErIss.setText("");
					}
				}
		});
		jTJourIssueNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourIssueNo);
		
		jLJourPageNo = new JLabel("Page Nmber");
		jLJourPageNo.setBounds(375,140,300,30);
		jLJourPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourPageNo);
		
		jLPgeE = new JLabel();
		jLPgeE.setBounds(535,170,150,10);
		jLPgeE.setForeground(Color.RED);
		jLPgeE.setFont(new Font("Verdana",Font.PLAIN,10));
		jPListJourEdit.add(jLPgeE);
		
		jTPageNo = new JTextField();
		jTPageNo.setBounds(530,140,150,30);
		jTPageNo.setEditable(false);
		jTPageNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char chIss = e.getKeyChar();

				if(!(Character.isDigit(chIss)) ||(chIss==KeyEvent.VK_BACK_SPACE) || (chIss==KeyEvent.VK_DELETE)){
					jLPgeE.setText("Number only");
					e.consume();
					}
				else {
					jLPgeE.setText("");
					}
				}
		});
		jTPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTPageNo);
		
		jBListJourReturn = new JButton("RETURN");
		jBListJourReturn.setBounds(535,235,150,30);
		jBListJourReturn.setBorderPainted(false);
		jBListJourReturn.setBackground(new Color(245,245,245));
		jBListJourReturn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourReturn.setForeground(new Color(0,128,128));
		jPListJourEdit.add(jBListJourReturn);
		
		jBListJourBack = new JButton("BACK");
		jBListJourBack.setBounds(23,70,140,30);
		jBListJourBack.setBorderPainted(false);
		jBListJourBack.setBackground(new Color(245,245,245));
		jBListJourBack.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourBack.setForeground(new Color(0,128,128));
		jPListJourControl.add(jBListJourBack);
		
		jBListJourLogout = new JButton("SIGN OUT");
		jBListJourLogout.setBounds(23,130,140,30);
		jBListJourLogout.setBorderPainted(false);
		jBListJourLogout.setBackground(new Color(245,245,245));
		jBListJourLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourLogout.setForeground(new Color(0,128,128));
		jPListJourControl.add(jBListJourLogout);

		//making new object of model and controller
		ListAllJournalModel jourModel = new ListAllJournalModel();
		
		//calling the method which is in controller
		ListAllJournalController listJourCont = new ListAllJournalController(this);
		
		listJourCont.brrTb();
		
		AftrRshLogContrlr ccAf = new AftrRshLogContrlr(this);
		ccAf.rtnJournal();
		
		jSJournalPane = new JScrollPane(jTabJourTable);
		jSJournalPane.setBounds(180,70,720,210);
		jSJournalPane.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJournalMain.add(jSJournalPane);
		
	}

	//necessary getters and setters
	
	
	public JLabel getjLDtEr() {
		return jLDtEr;
	}
	public String getjTRshEntName() {
		return jTRshEntName.getText();
	}
	
	public JTextField getReshNme() {
		return jTRshEntName;
	}
	
	public void setjTRshEntName(JTextField jTRshEntName) {
		this.jTRshEntName = jTRshEntName;
	}
	public void setjLDtEr(JLabel jLDtEr) {
		this.jLDtEr = jLDtEr;
	}
	public JTable getjTabJourTable() {
		return jTabJourTable;
	}

	public JTextField getjTJourPubYear() {
		return jTJourPubYear;
	}
	public void setjTJourPubYear(JTextField jTJourPubYear) {
		this.jTJourPubYear = jTJourPubYear;
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
	
	public int getPrimaryId() {
		return primaryId;
	}

	public void idSet(int num) {
		primaryId = num;
	}

	public String getJourId() {
		return jTJourId.getText();
	}
	
	public String getJourArtTitle() {
		return jTJourArticle.getText();
	}
	
	public String getJourAuthor() {
		return jTJourAuthor.getText();
	}
	
	public String getJourTitle() {
		return jTJourTitle.getText();
	}
	
	public String getJourYear() {
		return jTJourPubYear.getText();
	}
	public String getJourVolume() {
		return jTJourVolumeNo.getText();
	}
	
	public String getJourIssue() {
		return jTJourIssueNo.getText();
	}
	
	public String getJourPage() {
		return jTPageNo.getText();
	}
	
	public JButton getjBListJourBack() {
		return jBListJourBack;
	}

	public JButton getjBListJourLogout() {
		return jBListJourLogout;
	}
	
	public JButton getjBListJourAddNew() {
		return jBListJourAddNew;
	}
	public JButton getjBListJourReturn() {
		return jBListJourReturn;
	}
	public void setjBListJourReturn(JButton jBListJourReturn) {
		this.jBListJourReturn = jBListJourReturn;
	}
	public JTextField getjTJourId() {
		return jTJourId;
	}
	public void setjTJourId(JTextField jTJourId) {
		this.jTJourId = jTJourId;
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
	public JTextField getjTJourVolumeNo() {
		return jTJourVolumeNo;
	}
	public void setjTJourVolumeNo(JTextField jTJourVolumeNo) {
		this.jTJourVolumeNo = jTJourVolumeNo;
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
	
}
