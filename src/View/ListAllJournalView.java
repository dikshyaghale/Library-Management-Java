package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.ListAllJournalController;
import Model.ListAllJournalModel;

@SuppressWarnings("unused")
public class ListAllJournalView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//required attributes
	
	//panel components
	private JPanel jPListJournalMain, jPListJournalHeader, jPListJourControl, jPListJourEdit, jPListJourDelt;
	//label components
	private JLabel jLListJourHeader,jLRshNme,jLSechJou,jLPgeE,jLErIss,jLError,jLDtEr, jLListJourControl, jLListJourEdit, jLListJourDelt, jLJourId, jLJourArticTitle, jLJourAuthor, jLjourTitle, jLJourPublishedYear, jLJourVolumeNo, jLIssueNo, jLJourPageNo;
	//attributes of required textfield components
	private JTextField jTJourId,jTSerchJour, jTRshEntName, jTJourArticle, jTJourAuthor, jTJourTitle, jTJourPubYear, jTJourVolumeNo, jTJourIssueNo, jTPageNo;
	//component of jbutton
	private JButton jBListJourBack,jBLoanOut, jBListJourLogout, jBListJourEdit, jBListJourDelt, jBListJourAddNew;
	private ImageIcon univerImage = new ImageIcon("images/uni.jpg");
	
	//components for jtable
	private JTable jTabJourTable;
	private JScrollPane jSJournalPane;
	
	private int primaryId;
	
	//constructor
	public ListAllJournalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,900,720);
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
				fixJourVals(sIdJour, sArtTitleJour, sAuthorJour,sTitleJour, sYearJour, sVolJour, sIssueJour, sPagejour);
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
		
		jLListJourHeader = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: VIEW JOURNAL");
		jLListJourHeader.setForeground(new Color(240,255,255));
		jLListJourHeader.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLListJourHeader.setBounds(80,15,750,45);
		jPListJournalHeader.add(jLListJourHeader);	
		
		jPListJourControl = new JPanel();
		jPListJourControl.setLayout(null);
		jPListJourControl.setBackground(new Color(244,164,96));
		jPListJourControl.setBounds(0,70,180,700);
		jPListJournalMain.add(jPListJourControl);
		
		jLSechJou = new JLabel("Search here");
		jLSechJou.setBounds(15,24,180,30);
		jLSechJou.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLSechJou.setForeground(new Color(240,255,255));
		jPListJourControl.add(jLSechJou);
		
		jLListJourControl = new JLabel("Controls here");
		jLListJourControl.setBounds(5,140,180,30);
		jLListJourControl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLListJourControl.setForeground(new Color(240,255,255));
		jPListJourControl.add(jLListJourControl);
		
		jPListJourEdit = new JPanel();
		jPListJourEdit.setBackground(Color.WHITE);
		jPListJourEdit.setLayout(null);
		jPListJourEdit.setBounds(180,290,720,250);
		jPListJournalMain.add(jPListJourEdit);
		
		jLListJourEdit = new JLabel("EDIT JOURNAL'S INFORMATION");
		jLListJourEdit.setBounds(180,0,450,30);
		jLListJourEdit.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListJourEdit.add(jLListJourEdit);
		
		jLJourArticTitle = new JLabel("Title of article");
		jLJourArticTitle.setBounds(20,40,300,30);
		jLJourArticTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourArticTitle);
		
		jTJourArticle = new JTextField();
		jTJourArticle.setBounds(160,40,150,30);
		jTJourArticle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourArticle);
		
		jLJourAuthor = new JLabel("Author");
		jLJourAuthor.setBounds(20,90,300,30);
		jLJourAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLJourAuthor);
		
		jTJourAuthor = new JTextField();
		jTJourAuthor.setBounds(160,90,150,30);
		jTJourAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jTJourAuthor);
		
		jLjourTitle = new JLabel("Title of journal");
		jLjourTitle.setBounds(20,140,300,30);
		jLjourTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourEdit.add(jLjourTitle);
		
		jTJourTitle = new JTextField();
		jTJourTitle.setBounds(160,140,150,30);
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
		
		jTJourPubYear = new JTextField();
		jTJourPubYear.setBounds(160,190,150,30);
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
		
		jPListJourDelt = new JPanel();
		jPListJourDelt.setBounds(180,560,720,140);
		jPListJourDelt.setLayout(null);
		jPListJourDelt.setBackground(Color.WHITE);
		jPListJournalMain.add(jPListJourDelt);
		
		jLListJourDelt = new JLabel("DELETE OR LOAN OUT JOURNAL ARTICLE");
		jLListJourDelt.setBounds(130,0,650,30);
		jLListJourDelt.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListJourDelt.add(jLListJourDelt);
		
		jLJourId = new JLabel("Journal ID");
		jLJourId.setBounds(20,40,300,30);
		jLJourId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourDelt.add(jLJourId);
		
		jTJourId = new JTextField();
		jTJourId.setBounds(170,40,150,30);
		jTJourId.setEditable(false);
		jTJourId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourDelt.add(jTJourId);
		
		jBListJourDelt = new JButton("DELETE");
		jBListJourDelt.setBounds(180,85,120,30);
		jBListJourDelt.setBorderPainted(false);
		jBListJourDelt.setBackground(new Color(245,245,245));
		jBListJourDelt.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourDelt.setForeground(new Color(0,128,128));
		jPListJourDelt.add(jBListJourDelt);
		
		jLRshNme = new JLabel("Researcher's Name");
		jLRshNme.setBounds(330,40,300,30);
		jLRshNme.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourDelt.add(jLRshNme);
		
		jTRshEntName = new JTextField();
		jTRshEntName.setBounds(510,40,150,30);
		jTRshEntName.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJourDelt.add(jTRshEntName);
		
		jBLoanOut = new JButton("LOAN OUT");
		jBLoanOut.setBounds(510,85,150,30);
		jBLoanOut.setBorderPainted(false);
		jBLoanOut.setBackground(new Color(245,245,245));
		jBLoanOut.setFont(new Font("Verdana",Font.PLAIN,17));
		jBLoanOut.setForeground(new Color(0,128,128));
		jPListJourDelt.add(jBLoanOut);
		
		jBListJourEdit = new JButton("MODIFY");
		jBListJourEdit.setBounds(535,200,150,30);
		jBListJourEdit.setBorderPainted(false);
		jBListJourEdit.setBackground(new Color(245,245,245));
		jBListJourEdit.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourEdit.setForeground(new Color(0,128,128));
		jPListJourEdit.add(jBListJourEdit);
		
		jBListJourAddNew = new JButton("ADD NEW");
		jBListJourAddNew.setBounds(23,200,140,30);
		jBListJourAddNew.setBorderPainted(false);
		jBListJourAddNew.setBackground(new Color(245,245,245));
		jBListJourAddNew.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourAddNew.setForeground(new Color(0,128,128));
		jPListJourControl.add(jBListJourAddNew);
		
		jBListJourBack = new JButton("BACK");
		jBListJourBack.setBounds(23,260,140,30);
		jBListJourBack.setBorderPainted(false);
		jBListJourBack.setBackground(new Color(245,245,245));
		jBListJourBack.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourBack.setForeground(new Color(0,128,128));
		jPListJourControl.add(jBListJourBack);
		
		jBListJourLogout = new JButton("SIGN OUT");
		jBListJourLogout.setBounds(23,320,140,30);
		jBListJourLogout.setBorderPainted(false);
		jBListJourLogout.setBackground(new Color(245,245,245));
		jBListJourLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListJourLogout.setForeground(new Color(0,128,128));
		jPListJourControl.add(jBListJourLogout);
		
		
		jTSerchJour = new JTextField();
		jTSerchJour.setBounds(23,80,140,30);
		jTSerchJour.setFont(new Font("Verdana",Font.PLAIN,17));
		jTSerchJour.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				DefaultTableModel tbm = (DefaultTableModel)jTabJourTable.getModel();
				String search = jTSerchJour.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tt = new TableRowSorter<DefaultTableModel>(tbm);
				jTabJourTable.setRowSorter(tt);
				tt.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		jPListJourControl.add(jTSerchJour);

		//making new object of model and tbmcontroller
		@SuppressWarnings("unused")
		ListAllJournalModel jourModel = new ListAllJournalModel();
		
		//calling the method which is in controller
		ListAllJournalController listJourCont = new ListAllJournalController(this);
		listJourCont.listJourButtons();
		listJourCont.listJourTable();
		
		jSJournalPane = new JScrollPane(jTabJourTable);
		jSJournalPane.setBounds(180,70,720,210);
		jSJournalPane.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListJournalMain.add(jSJournalPane);
		
	}

	//necessary getters and setters
	
	
	public JLabel getjLDtEr() {
		return jLDtEr;
	}
	public JTextField getjTSerchJour() {
		return jTSerchJour;
	}
	public void setjTSerchJour(JTextField jTSerchJour) {
		this.jTSerchJour = jTSerchJour;
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

	public JButton getjBListJourEdit() {
		return jBListJourEdit;
	}

	public JButton getjBListJourDelt() {
		return jBListJourDelt;
	}

	public JButton getjBLoanOut() {
		return jBLoanOut;
	}
	public void setjBLoanOut(JButton jBLoanOut) {
		this.jBLoanOut = jBLoanOut;
	}
	public JButton getjBListJourAddNew() {
		return jBListJourAddNew;
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
