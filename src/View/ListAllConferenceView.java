package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.ListAllConferenceController;
import Model.ListAllConferenceModel;

public class ListAllConferenceView extends JFrame {
	//attributes
	private JPanel jPListConMain, jPListConHeader,jPListConControl, jPListConEdit, jPListConDelete;
	private JLabel jLListConHeader,jLCnRshNme,jLSrchCon, jLDtEr,jLCPgE, jLListConControl, jLListConEdit, jLListConDelt, jLListConId, jLListConTitle, jLListConAuthor, jLListConPublishedYear, jLListConEditors, jLListConLocation, jLListConpageNo;
	private JTextField jTConId,jTRshEntName,jTSerchFld, jTConTitle, jTConAuthor, jTConPublishedYear, jTConEditors, jTConLocation, jTConPageNo;
	private JButton jBListConAddNew,jBCBLoan, jBListConLogout, jBListConBack, jBListConEdit, jBListConDelt;
	private ImageIcon uniImage = new ImageIcon("images/uni.jpg");
	private int setConfNum;
	
	public JButton getjBCBLoan() {
		return jBCBLoan;
	}

	public void setjBCBLoan(JButton jBCBLoan) {
		this.jBCBLoan = jBCBLoan;
	}

	//attributes to generate table
	private JTable jTabConference = new JTable();
	private JScrollPane jSConference;

	//default constructor to create the GUI of conference articles
	public ListAllConferenceView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,900,720);
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setIconImage(uniImage.getImage());
		setTitle("Northampton Article Management System ");
		setResizable(false);
		Container content = getContentPane();
		content.setLayout(null);
		ListConferenceGUi();
		confChangeVal();
		setVisible(true);
	}
	
	//constructor
	public void confartVals(String listConfId, String listConfTitle, String listConfAuthor,String listConfYear,String listConfEditor, String listConfLoct,String listConfPage ) {
		this.jTConId.setText(listConfId);
		this.jTConTitle.setText(listConfTitle);
		this.jTConAuthor.setText(listConfAuthor);
		this.jTConPublishedYear.setText(listConfYear);
		this.jTConEditors.setText(listConfEditor);
		this.jTConLocation.setText(listConfLoct);
		this.jTConPageNo.setText(listConfPage);

	}

	//method to create the design of listing all values of conference article
	@SuppressWarnings("unused")
	private void ListConferenceGUi() {
		jPListConMain = new JPanel();
		jPListConMain.setLayout(null);
		jPListConMain.setBackground(new Color(245,245,245));
		jPListConMain.setBounds(140,140,900,720);
		setContentPane(jPListConMain);
		
		jPListConHeader = new JPanel();
		jPListConHeader.setLayout(null);
		jPListConHeader.setBounds(0,0,900,70);
		jPListConHeader.setBackground(new Color(0,128,128));
		jPListConMain.add(jPListConHeader);
		
		jLListConHeader = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: VIEW CONFERENCE ARTICLE");
		jLListConHeader.setForeground(new Color(240,255,255));
		jLListConHeader.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLListConHeader.setBounds(50,15,750,45);
		jPListConHeader.add(jLListConHeader);
		
		jPListConControl = new JPanel();
		jPListConControl.setLayout(null);
		jPListConControl.setBackground(new Color(244,164,96));
		jPListConControl.setBounds(0,70,180,700);
		jPListConMain.add(jPListConControl);
		
		jLListConControl = new JLabel("Controls here");
		jLListConControl.setBounds(5,140,180,30);
		jLListConControl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLListConControl.setForeground(new Color(240,255,255));
		jPListConControl.add(jLListConControl);
		
		jPListConEdit = new JPanel();
		jPListConEdit.setBackground(Color.WHITE);
		jPListConEdit.setLayout(null);
		jPListConEdit.setBounds(180,290,720,250);
		jPListConMain.add(jPListConEdit);
		
		jLListConEdit = new JLabel("EDIT CONFERENCE DETAILS");
		jLListConEdit.setBounds(180,0,450,30);
		jLListConEdit.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListConEdit.add(jLListConEdit);
		
		jLListConTitle = new JLabel("Title of article");
		jLListConTitle.setBounds(20,40,300,30);
		jLListConTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jLListConTitle);
		
		jTConTitle = new JTextField();
		jTConTitle.setBounds(160,40,150,30);
		jTConTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jTConTitle);
		
		jLListConAuthor = new JLabel("Author");
		jLListConAuthor.setBounds(20,90,300,30);
		jLListConAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jLListConAuthor);
		
		jTConAuthor = new JTextField();
		jTConAuthor.setBounds(160,90,150,30);
		jTConAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jTConAuthor);
		
		jLDtEr = new JLabel();
		jLDtEr.setBounds(157,180,260,10);
		jLDtEr.setForeground(Color.RED);
		jLDtEr.setFont(new Font("Verdana",Font.PLAIN,10));
		jPListConEdit.add(jLDtEr);
		
		jLListConPublishedYear = new JLabel("Published Year");
		jLListConPublishedYear.setBounds(20,140,300,30);
		jLListConPublishedYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jLListConPublishedYear);
		
		jTConPublishedYear = new JTextField();
		jTConPublishedYear.setBounds(160,140,150,30);
		jTConPublishedYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jTConPublishedYear);
		
		jLListConEditors = new JLabel("Editors");
		jLListConEditors.setBounds(375,40,300,30);
		jLListConEditors.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jLListConEditors);
		
		jTConEditors = new JTextField();
		jTConEditors.setBounds(530,40,150,30);
		jTConEditors.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jTConEditors);
		
		jLListConLocation = new JLabel("Location");
		jLListConLocation.setBounds(375,90,300,30);
		jLListConLocation.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jLListConLocation);
		
		jTConLocation = new JTextField();
		jTConLocation.setBounds(530,90,150,30);
		jTConLocation.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jTConLocation);
		
		jLListConpageNo = new JLabel("Page Number");
		jLListConpageNo.setBounds(375,140,300,30);
		jLListConpageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jLListConpageNo);
		
		jLCPgE = new JLabel();
		jLCPgE.setBounds(535,170,260,10);
		jLCPgE.setForeground(Color.RED);
		jLCPgE.setFont(new Font("Verdana",Font.PLAIN,10));
		jPListConEdit.add(jLCPgE);
		
		jTConPageNo = new JTextField();
		jTConPageNo.setBounds(530,140,150,30);
		//make sure fields accepts numbers only
		jTConPageNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent event) {
				char caPge = event.getKeyChar();

				if(!(Character.isDigit(caPge)) ||(caPge==KeyEvent.VK_BACK_SPACE) || (caPge==KeyEvent.VK_DELETE)){
					jLCPgE.setText("Numbers only");
					event.consume();
					}
				else {
					jLCPgE.setText("");
					}
				}
		});
		jTConPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConEdit.add(jTConPageNo);
		
		jBListConEdit = new JButton("MODIFY");
		jBListConEdit.setBounds(290,200,150,30);
		jBListConEdit.setBorderPainted(false);
		jBListConEdit.setBackground(new Color(245,245,245));
		jBListConEdit.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListConEdit.setForeground(new Color(0,128,128));
		jPListConEdit.add(jBListConEdit);
		
		jPListConDelete = new JPanel();
		jPListConDelete.setBounds(180,540,720,140);
		jPListConDelete.setLayout(null);
		jPListConDelete.setBackground(Color.WHITE);
		jPListConMain.add(jPListConDelete);
		
		jLListConDelt = new JLabel("DELETE OR LOAN OUT CONFERENCE ARTICLE");
		jLListConDelt.setBounds(120,0,550,30);
		jLListConDelt.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListConDelete.add(jLListConDelt);
		
		jLListConId = new JLabel("CONFERENCE ID");
		jLListConId.setBounds(10,40,300,30);
		jLListConId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConDelete.add(jLListConId);
		
		jTConId = new JTextField();
		jTConId.setBounds(180,40,130,30);
		jTConId.setEditable(false);
		jTConId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConDelete.add(jTConId);
		
		jBListConDelt = new JButton("DELETE");
		jBListConDelt.setBounds(190,85,120,30);
		jBListConDelt.setBorderPainted(false);
		jBListConDelt.setBackground(new Color(245,245,245));
		jBListConDelt.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListConDelt.setForeground(new Color(0,128,128));
		jPListConDelete.add(jBListConDelt);
		
		jLCnRshNme = new JLabel("Researcher's Name");
		jLCnRshNme.setBounds(340,40,300,30);
		jLCnRshNme.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConDelete.add(jLCnRshNme);
		
		jTRshEntName = new JTextField();
		jTRshEntName.setBounds(510,40,150,30);
		jTRshEntName.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListConDelete.add(jTRshEntName);
		
		jBCBLoan = new JButton("LOAN OUT");
		jBCBLoan.setBounds(510,85,150,30);
		jBCBLoan.setBorderPainted(false);
		jBCBLoan.setBackground(new Color(245,245,245));
		jBCBLoan.setFont(new Font("Verdana",Font.PLAIN,17));
		jBCBLoan.setForeground(new Color(0,128,128));
		jPListConDelete.add(jBCBLoan);
		
		jLSrchCon = new JLabel("Search here");
		jLSrchCon.setBounds(15,24,180,30);
		jLSrchCon.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLSrchCon.setForeground(new Color(240,255,255));
		jPListConControl.add(jLSrchCon);
		
		jTSerchFld = new JTextField();
		jTSerchFld.setBounds(23,80,140,30);
		jTSerchFld.setFont(new Font("Verdana",Font.PLAIN,17));
		//to make fields accept number only
		jTSerchFld.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				DefaultTableModel mdlDeTb = (DefaultTableModel)jTabConference.getModel();
				String search = jTSerchFld.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> roSrtTb = new TableRowSorter<DefaultTableModel>(mdlDeTb);
				jTabConference.setRowSorter(roSrtTb);
				roSrtTb.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		jPListConControl.add(jTSerchFld);
		
		jBListConAddNew = new JButton("ADD NEW");
		jBListConAddNew.setBounds(23,200,140,30);
		jBListConAddNew.setBorderPainted(false);
		jBListConAddNew.setBackground(new Color(245,245,245));
		jBListConAddNew.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListConAddNew.setForeground(new Color(0,128,128));
		jPListConControl.add(jBListConAddNew);
		
		jBListConBack = new JButton("BACK");
		jBListConBack.setBounds(23,260,140,30);
		jBListConBack.setBorderPainted(false);
		jBListConBack.setBackground(new Color(245,245,245));
		jBListConBack.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListConBack.setForeground(new Color(0,128,128));
		jPListConControl.add(jBListConBack);
		
		jBListConLogout = new JButton("SIGN OUT");
		jBListConLogout.setBounds(23,320,140,30);
		jBListConLogout.setBorderPainted(false);
		jBListConLogout.setBackground(new Color(245,245,245));
		jBListConLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListConLogout.setForeground(new Color(0,128,128));
		jPListConControl.add(jBListConLogout);
		
		ListAllConferenceModel listConferenceM = new ListAllConferenceModel();
		
		ListAllConferenceController listConference = new ListAllConferenceController(this);
		listConference.listConfContrl();
		
		jSConference = new JScrollPane(jTabConference);
		jSConference.setBounds(180,80,720,200);
		jPListConMain.add(jSConference);
		
	}
	//edit the values which is set in each andy every column of row in the table
	
	public JLabel getjLDtEr() {
		return jLDtEr;
	}
	
	public String getjTEntName() {
		return jTRshEntName.getText();
	}

	public JTextField getjTRshEntName() {
		return jTRshEntName;
	}

	public void setjTRshEntName(JTextField jTRshEntName) {
		this.jTRshEntName = jTRshEntName;
	}

	public void setjLDtEr(JLabel jLDtEr) {
		this.jLDtEr = jLDtEr;
	}

	public void confChangeVal() {
		jTabConference.addMouseListener(new java.awt.event.MouseAdapter() {
			
			public void mouseClicked(java.awt.event.MouseEvent ms) {
				String sConfId, sConfTitle, sConfAuthor, sConfPubY, sConfEditors, sConfPlace, sConfNoPag;
				int confTbleVals;
				DefaultTableModel confrTble = (DefaultTableModel)jTabConference.getModel();
			
				confTbleVals = jTabConference.getSelectedRow();
				sConfId = confrTble.getValueAt(confTbleVals, 0).toString();
				sConfTitle = confrTble.getValueAt(confTbleVals, 1).toString();
				sConfAuthor = confrTble.getValueAt(confTbleVals, 2).toString();
				sConfPubY = confrTble.getValueAt(confTbleVals, 3).toString();
				sConfEditors = confrTble.getValueAt(confTbleVals, 4).toString();
				sConfPlace = confrTble.getValueAt(confTbleVals, 5).toString();
				sConfNoPag = confrTble.getValueAt(confTbleVals, 6).toString();

				confartVals(sConfId, sConfTitle, sConfAuthor, sConfPubY, sConfEditors, sConfPlace, sConfNoPag);
				setSetConfNum(jTabConference.getSelectedRow());
			}
		});
	}

	//the needed getters and setters
	
	public int getSetConfNum() {
		return setConfNum;
	}

	public JTextField getjTConId() {
		return jTConId;
	}

	public void setjTConId(JTextField jTConId) {
		this.jTConId = jTConId;
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

	public void setSetConfNum(int ConfNum) {
		setConfNum = ConfNum;
	}
	
	public JTable getjTabConference() {
		return jTabConference;
	}

	public void setjTabConference(JTable jTabConference) {
		this.jTabConference = jTabConference;
	}

	public JScrollPane getjSConference() {
		return jSConference;
	}

	public void setjSConference(JScrollPane jSConference) {
		this.jSConference = jSConference;
	}

	public String getConfId() {
		return jTConId.getText();
	}
	public String getConfTitle() {
		return jTConTitle.getText();
	}
	
	public String getConfAuthor() {
		return jTConAuthor.getText();
	}
	
	public String getConfYear() {
		return jTConPublishedYear.getText();
	}
	
	public String getConfEditor() {
		return jTConEditors.getText();
	}
	
	public String getConfLoct() {
		return jTConLocation.getText();
	}
	
	public String getConfNoPage() {
		return jTConPageNo.getText();
	}

	public JButton getjBListConAddNew() {
		return jBListConAddNew;
	}

	public void setjBListConAddNew(JButton jBListConAddNew) {
		this.jBListConAddNew = jBListConAddNew;
	}

	public JButton getjBListConLogout() {
		return jBListConLogout;
	}

	public void setjBListConLogout(JButton jBListConLogout) {
		this.jBListConLogout = jBListConLogout;
	}

	public JButton getjBListConBack() {
		return jBListConBack;
	}

	public void setjBListConBack(JButton jBListConBack) {
		this.jBListConBack = jBListConBack;
	}

	public JButton getjBListConEdit() {
		return jBListConEdit;
	}

	public void setjBListConEdit(JButton jBListConEdit) {
		this.jBListConEdit = jBListConEdit;
	}

	public JButton getjBListConDelt() {
		return jBListConDelt;
	}

	public void setjBListConDelt(JButton jBListConDelt) {
		this.jBListConDelt = jBListConDelt;
	}
	
}
