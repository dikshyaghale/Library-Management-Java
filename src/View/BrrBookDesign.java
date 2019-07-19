package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.AftrRshLogContrlr;
import Controller.ListAllBookController;
import Controller.ResearcherLoginController;
import Model.ListAllBookModel;
import Model.ResearcherLoginModel;

public class BrrBookDesign extends JFrame {
	//the components required to make GUI
	
	//panel components
	private JPanel jPListBookMain, jPListBookHeader, jPListBookControl,jPListBookEdit;
	//button components
	private JButton jBListBookBack,jBBrBLo,jBListBookReturn, jBListBookLogout;
	//label components
	private JLabel jLPYEr,jLLBoEr, jLBokName,jLLIstBookHeader, jLListBookControl, jLListBookEdit, jLListBookDelt, jLListBookId, jLListBookTitle, jLListBookAuthor, jLListBookPublished, jLListBookEditor, jLListBookPlace, jLListBookPublisher, jLListBookPageNo;
	//textfields components
	private JTextField jTBookId,jTBokRshNme, jTBookTitle, jTBookAuthor, jTBookPublished, jTBookEditor, jTBookPlace, jTBookPublisher, jTBookPageNo;
	//making new instance of image
	private ImageIcon univerImage = new ImageIcon("images/uni.jpg");

	private int chapBokNum;

	//constructor
	public BrrBookDesign() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,900,670);
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setIconImage(univerImage.getImage());
		setTitle("Northampton Article Management System ");
		setResizable(false);
		Container content = getContentPane();
		content.setLayout(null);
		makeListBookGUi();
		fillEditPanl();
		setVisible(true);
	}

	//method to set the values
	public void chapArtclsSet(String bChapId,String bChapTitle,String bChapAuthor,String bChapYear,String bChapEditor,String bChapPlace,String bChapPublisher,String bChapNoPage) {
		this.jTBookId.setText(bChapId);
		this.jTBookTitle.setText(bChapTitle);
		this.jTBookAuthor.setText(bChapAuthor);
		this.jTBookPublished.setText(bChapYear);
		this.jTBookEditor.setText(bChapEditor);
		this.jTBookPlace.setText(bChapPlace);
		this.jTBookPublisher.setText(bChapPublisher);
		this.jTBookPageNo.setText(bChapNoPage);
	}
	
	//sets the selected values in the edit panel of book chapter
	public void fillEditPanl() {
		jTabBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
		
			public void mouseClicked(java.awt.event.MouseEvent m) {
				String cBokId,cBokTtle, cBokAthor, cBokYar, cBokEdit, cBokPlce, cBokPublshr, cBokNoPge;
				int cBols;
				DefaultTableModel  bokChapTab = (DefaultTableModel)jTabBookTable.getModel();
				
				cBols = jTabBookTable.getSelectedRow();
				cBokId = bokChapTab.getValueAt(cBols, 0).toString();
				cBokTtle = bokChapTab.getValueAt(cBols, 1).toString();
				cBokAthor = bokChapTab.getValueAt(cBols, 2).toString();
				cBokYar = bokChapTab.getValueAt(cBols, 3).toString();
				cBokEdit = bokChapTab.getValueAt(cBols, 4).toString();
				cBokPlce = bokChapTab.getValueAt(cBols, 5).toString();
				cBokPublshr = bokChapTab.getValueAt(cBols, 6).toString();
				cBokNoPge = bokChapTab.getValueAt(cBols, 7).toString();
				chapArtclsSet(cBokId,cBokTtle, cBokAthor, cBokYar, cBokEdit, cBokPlce, cBokPublshr, cBokNoPge);
				setChapBokNum(jTabBookTable.getSelectedRow());
			}
			
		});
	}
	
	//make the design of listing book chapter view
	private void makeListBookGUi() {
		jPListBookMain = new JPanel();
		jPListBookMain.setLayout(null);
		jPListBookMain.setBackground(new Color(245,245,245));
		jPListBookMain.setBounds(140,140,900,720);
		setContentPane(jPListBookMain);
		
		jPListBookHeader = new JPanel();
		jPListBookHeader.setLayout(null);
		jPListBookHeader.setBounds(0,0,900,70);
		jPListBookHeader.setBackground(new Color(0,128,128));
		jPListBookMain.add(jPListBookHeader);
		
		jLLIstBookHeader = new JLabel("NORTHAMPTON ARTILCE MANAGEMENT: VIEW BORROWED BOOK CHAPTER");
		jLLIstBookHeader.setForeground(new Color(240,255,255));
		jLLIstBookHeader.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLLIstBookHeader.setBounds(10,15,820,45);
		jPListBookHeader.add(jLLIstBookHeader);
		
		jPListBookControl = new JPanel();
		jPListBookControl.setLayout(null);
		jPListBookControl.setBackground(new Color(244,164,96));
		jPListBookControl.setBounds(0,70,180,700);
		jPListBookMain.add(jPListBookControl);
		
		jLListBookControl = new JLabel("Control here");
		jLListBookControl.setBounds(5,18,180,30);
		jLListBookControl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLListBookControl.setForeground(new Color(240,255,255));
		jPListBookControl.add(jLListBookControl);
		
		jPListBookEdit = new JPanel();
		jPListBookEdit.setBackground(Color.WHITE);
		jPListBookEdit.setLayout(null);
		jPListBookEdit.setBounds(180,290,720,300);
		jPListBookMain.add(jPListBookEdit);
		
		jLListBookEdit = new JLabel("RETURN BOOK ARTICLE");
		jLListBookEdit.setBounds(180,0,450,30);
		jLListBookEdit.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListBookEdit.add(jLListBookEdit);
		
		jLListBookTitle = new JLabel("Title of Book");
		jLListBookTitle.setBounds(20,40,300,30);
		jLListBookTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookTitle);
		
		jTBookTitle = new JTextField();
		jTBookTitle.setEditable(false);
		jTBookTitle.setBounds(160,40,150,30);
		jTBookTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookTitle);
		
		jLListBookAuthor = new JLabel("Author");
		jLListBookAuthor.setBounds(20,90,300,30);
		jLListBookAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookAuthor);
		
		jTBookAuthor = new JTextField();
		jTBookAuthor.setBounds(160,90,150,30);
		jTBookAuthor.setEditable(false);
		jTBookAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookAuthor);
		
		jLListBookPublished = new JLabel("Published Year");
		jLListBookPublished.setBounds(20,140,300,30);
		jLListBookPublished.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookPublished);
		
		jLPYEr = new JLabel();
		jLPYEr.setBounds(160,170,250,12);
		jLPYEr.setForeground(Color.RED);
		jLPYEr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPListBookEdit.add(jLPYEr);
		
		jTBookPublished = new JTextField();
		jTBookPublished.setBounds(160,140,150,30);
		jTBookPublished.setEditable(false);
		jTBookPublished.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookPublished);
		
		jLListBookEditor = new JLabel("Editor");
		jLListBookEditor.setBounds(20,190,300,30);
		jLListBookEditor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookEditor);
		
		jTBookEditor = new JTextField();
		jTBookEditor.setBounds(160,190,150,30);
		jTBookEditor.setEditable(false);
		jTBookEditor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookEditor);
		
		jLListBookPlace = new JLabel("Place of publication");
		jLListBookPlace.setBounds(370,40,300,30);
		jLListBookPlace.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookPlace);
		
		jTBookPlace = new JTextField();
		jTBookPlace.setEditable(false);
		jTBookPlace.setBounds(545,40,150,30);
		jTBookPlace.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookPlace);
		
		jLListBookPublisher = new JLabel("Publisher");
		jLListBookPublisher.setBounds(370,90,300,30);
		jLListBookPublisher.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookPublisher);
		
		jTBookPublisher = new JTextField();
		jTBookPublisher.setBounds(545,90,150,30);
		jTBookPublisher.setEditable(false);
		jTBookPublisher.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookPublisher);
		
		jLListBookPageNo = new JLabel("Page Number");
		jLListBookPageNo.setBounds(370,140,300,30);
		jLListBookPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookPageNo);
		
		jLListBookId = new JLabel("BOOK ID");
		jLListBookId.setBounds(370,190,300,30);
		jLListBookId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookId);
		
		jTBookId = new JTextField();
		jTBookId.setEditable(false);
		jTBookId.setBounds(545,190,150,30);
		jTBookId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookId);
		
		jLLBoEr = new JLabel();
		jLLBoEr.setBounds(550,170,140,12);
		jLLBoEr.setForeground(Color.RED);
		jLLBoEr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPListBookEdit.add(jLLBoEr);
		
		jTBookPageNo = new JTextField();
		jTBookPageNo.setEditable(false);
		jTBookPageNo.setBounds(545,140,150,30);
		jTBookPageNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char cpLB = e.getKeyChar();

				if(!(Character.isDigit(cpLB)) ||(cpLB==KeyEvent.VK_BACK_SPACE) || (cpLB==KeyEvent.VK_DELETE)){
					jLLBoEr.setText("Numbers only");
					e.consume();
					}
				else {
					jLLBoEr.setText("");
					}
				}
		});
		jTBookPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookPageNo);
		
		jBListBookReturn = new JButton("RETURN");
		jBListBookReturn.setBounds(540,230,150,30);
		jBListBookReturn.setBorderPainted(false);
		jBListBookReturn.setBackground(new Color(245,245,245));
		jBListBookReturn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookReturn.setForeground(new Color(0,128,128));
		jPListBookEdit.add(jBListBookReturn);
			
		jBListBookBack = new JButton("BACK");
		jBListBookBack.setBounds(23,60,140,30);
		jBListBookBack.setBorderPainted(false);
		jBListBookBack.setBackground(new Color(245,245,245));
		jBListBookBack.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookBack.setForeground(new Color(0,128,128));
		jPListBookControl.add(jBListBookBack);
		
		jBListBookLogout = new JButton("SIGN OUT");
		jBListBookLogout.setBounds(23,120,140,30);
		jBListBookLogout.setBorderPainted(false);
		jBListBookLogout.setBackground(new Color(245,245,245));
		jBListBookLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookLogout.setForeground(new Color(0,128,128));
		jPListBookControl.add(jBListBookLogout);
		
		AftrRshLogContrlr btn = new AftrRshLogContrlr(this);
		btn.brrBokRtn();
		
		ListAllBookModel BookModel = new ListAllBookModel();
		
		ListAllBookController listBook = new ListAllBookController(this);
		listBook.bokBrowed();
		
		jSBookPane = new JScrollPane(jTabBookTable);
		jSBookPane.setBounds(180,80,720,200);
		jPListBookMain.add(jSBookPane);
		
	}

	//getters and setters
	//required components to make table
	private JTable jTabBookTable = new JTable();
	
	private JScrollPane jSBookPane;
	
	public String getjTBokRshNme() {
		return jTBokRshNme.getText();
	}

	public void setjTBokRshNme(JTextField jTBokRshNme) {
		this.jTBokRshNme = jTBokRshNme;
	}
	
	public JLabel getjLPYEr() {
		return jLPYEr;
	}

	public void setjLPYEr(JLabel jLPYEr) {
		this.jLPYEr = jLPYEr;
	}

	public JButton getjBBrBLo() {
		return jBBrBLo;
	}

	public void setjBBrBLo(JButton jBBrBLo) {
		this.jBBrBLo = jBBrBLo;
	}

	
	public JButton getjBListBookReturn() {
		return jBListBookReturn;
	}

	public void setjBListBookReturn(JButton jBListBookReturn) {
		this.jBListBookReturn = jBListBookReturn;
	}

	public int getChapBokNum() {
		return chapBokNum;
	}

	public JTextField getjTBookId() {
		return jTBookId;
	}

	public void setjTBookId(JTextField jTBookId) {
		this.jTBookId = jTBookId;
	}

	public JTextField getjTBookTitle() {
		return jTBookTitle;
	}

	public void setjTBookTitle(JTextField jTBookTitle) {
		this.jTBookTitle = jTBookTitle;
	}

	public JTextField getjTBookAuthor() {
		return jTBookAuthor;
	}

	public void setjTBookAuthor(JTextField jTBookAuthor) {
		this.jTBookAuthor = jTBookAuthor;
	}

	public JTextField getjTBookEditor() {
		return jTBookEditor;
	}

	public void setjTBookEditor(JTextField jTBookEditor) {
		this.jTBookEditor = jTBookEditor;
	}

	public JTextField getjTBookPlace() {
		return jTBookPlace;
	}

	public void setjTBookPlace(JTextField jTBookPlace) {
		this.jTBookPlace = jTBookPlace;
	}

	public JTextField getjTBookPublisher() {
		return jTBookPublisher;
	}

	public void setjTBookPublisher(JTextField jTBookPublisher) {
		this.jTBookPublisher = jTBookPublisher;
	}

	public JTextField getjTBookPageNo() {
		return jTBookPageNo;
	}

	public void setjTBookPageNo(JTextField jTBookPageNo) {
		this.jTBookPageNo = jTBookPageNo;
	}

	public void setChapBokNum(int BokNum) {
		chapBokNum = BokNum;
	}
	
	public JTable getjTabBookTable() {
		return jTabBookTable;
	}

	public void setjTabBookTable(JTable jTabBookTable) {
		this.jTabBookTable = jTabBookTable;
	}

	public JScrollPane getjSBookPane() {
		return jSBookPane;
	}

	public void setjSBookPane(JScrollPane jSBookPane) {
		this.jSBookPane = jSBookPane;
	}

	public JButton getjBListBookBack() {
		return jBListBookBack;
	}

	public void setjBListBookBack(JButton jBListBookBack) {
		this.jBListBookBack = jBListBookBack;
	}

	public JButton getjBListBookLogout() {
		return jBListBookLogout;
	}

	public void setjBListBookLogout(JButton jBListBookLogout) {
		this.jBListBookLogout = jBListBookLogout;
	}

	public String getCBokId() {
		return jTBookId.getText();
	}
	
	public String getCBokTitl() {
		return jTBookTitle.getText();
	}
	
	public String getCBokAuthr() {
		return jTBookAuthor.getText();
	}
	
	public String getCBokPubYar() {
		return jTBookPublished.getText();
	}
	
	public String getCBokEdtr() {
		return jTBookEditor.getText();
	}
	
	public String getCBokplce() {
		return jTBookPlace.getText();
	}
	
	public String getCBokPublsher() {
		return jTBookPublisher.getText();
	}
	
	public String getCBokPgeNo() {
		return jTBookPageNo.getText();
	}

	public JTextField getjTBookPublished() {
		return jTBookPublished;
	}

	public void setjTBookPublished(JTextField jTBookPublished) {
		this.jTBookPublished = jTBookPublished;
	}

	
}
