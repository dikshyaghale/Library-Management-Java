package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.ListAllBookController;
import Model.ListAllBookModel;

public class ListAllBookChapterView extends JFrame {
	//the components required to make GUI
	
	//panel components
	private JPanel jPListBookMain, jPListBookHeader, jPListBookControl,jPListBookEdit, jPListBookDelt;
	//button components
	private JButton jBListBookBack,jBBrBLo, jBListBookAddNew, jBListBookLogout, jBListBookEdit,jBListBookDelt;
	//label components
	private JLabel jLPYEr,jLLBoEr,jLSrcBok, jLBokName,jLLIstBookHeader, jLListBookControl, jLListBookEdit, jLListBookDelt, jLListBookId, jLListBookTitle, jLListBookAuthor, jLListBookPublished, jLListBookEditor, jLListBookPlace, jLListBookPublisher, jLListBookPageNo;
	
	//textfields components
	private JTextField jTBookId,jTBokRshNme,jTBSrch, jTBookTitle, jTBookAuthor, jTBookPublished, jTBookEditor, jTBookPlace, jTBookPublisher, jTBookPageNo;
	//making new instance of image
	private ImageIcon univerImage = new ImageIcon("images/uni.jpg");

	private int chapBokNum;
	//required components to make table
	private JTable jTabBookTable = new JTable();
	private JScrollPane jSBookPane;
	
	public String getjTBokRshNme() {
		return jTBokRshNme.getText();
	}

	public JTextField getBrRshName() {
		return jTBokRshNme;
		
	}
	
	public void setjTBokRshNme(JTextField jTBokRshNme) {
		this.jTBokRshNme = jTBokRshNme;
	}

	//constructor
	public ListAllBookChapterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,900,720);
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
				String cBokId, cBokTtle, cBokAthor, cBokYar, cBokEdit, cBokPlce, cBokPublshr, cBokNoPge;
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
				chapArtclsSet( cBokId, cBokTtle, cBokAthor, cBokYar, cBokEdit, cBokPlce, cBokPublshr, cBokNoPge);
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
		
		jLLIstBookHeader = new JLabel("NORTHAMPTON ARTILCE MANAGEMENT: VIEW BOOK CHAPTER");
		jLLIstBookHeader.setForeground(new Color(240,255,255));
		jLLIstBookHeader.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLLIstBookHeader.setBounds(80,15,750,45);
		jPListBookHeader.add(jLLIstBookHeader);
		
		jPListBookControl = new JPanel();
		jPListBookControl.setLayout(null);
		jPListBookControl.setBackground(new Color(244,164,96));
		jPListBookControl.setBounds(0,70,180,700);
		jPListBookMain.add(jPListBookControl);
		
		jLListBookControl = new JLabel("Control here");
		jLListBookControl.setBounds(5,140,180,30);
		jLListBookControl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLListBookControl.setForeground(new Color(240,255,255));
		jPListBookControl.add(jLListBookControl);
		
		jLSrcBok = new JLabel("Search here");
		jLSrcBok.setBounds(5,24,180,30);
		jLSrcBok.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLSrcBok.setForeground(new Color(240,255,255));
		jPListBookControl.add(jLSrcBok);
		
		jPListBookEdit = new JPanel();
		jPListBookEdit.setBackground(Color.WHITE);
		jPListBookEdit.setLayout(null);
		jPListBookEdit.setBounds(180,290,720,250);
		jPListBookMain.add(jPListBookEdit);
		
		jLListBookEdit = new JLabel("EDIT BOOK CHAPTER'S DETAILS");
		jLListBookEdit.setBounds(180,0,450,30);
		jLListBookEdit.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListBookEdit.add(jLListBookEdit);
		
		jLListBookTitle = new JLabel("Title of Book");
		jLListBookTitle.setBounds(20,40,300,30);
		jLListBookTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookTitle);
		
		jTBookTitle = new JTextField();
		jTBookTitle.setBounds(160,40,150,30);
		jTBookTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookTitle);
		
		jLListBookAuthor = new JLabel("Author");
		jLListBookAuthor.setBounds(20,90,300,30);
		jLListBookAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookAuthor);
		
		jTBookAuthor = new JTextField();
		jTBookAuthor.setBounds(160,90,150,30);
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
		jTBookPublished.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookPublished);
		
		jLListBookEditor = new JLabel("Editor");
		jLListBookEditor.setBounds(20,190,300,30);
		jLListBookEditor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookEditor);
		
		jTBookEditor = new JTextField();
		jTBookEditor.setBounds(160,190,150,30);
		jTBookEditor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookEditor);
		
		jLListBookPlace = new JLabel("Place of publication");
		jLListBookPlace.setBounds(370,40,300,30);
		jLListBookPlace.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookPlace);
		
		jTBookPlace = new JTextField();
		jTBookPlace.setBounds(545,40,150,30);
		jTBookPlace.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookPlace);
		
		jLListBookPublisher = new JLabel("Publisher");
		jLListBookPublisher.setBounds(370,90,300,30);
		jLListBookPublisher.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookPublisher);
		
		jTBookPublisher = new JTextField();
		jTBookPublisher.setBounds(545,90,150,30);
		jTBookPublisher.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jTBookPublisher);
		
		jLListBookPageNo = new JLabel("Page Number");
		jLListBookPageNo.setBounds(370,140,300,30);
		jLListBookPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookEdit.add(jLListBookPageNo);
		
		jLLBoEr = new JLabel();
		jLLBoEr.setBounds(550,170,140,12);
		jLLBoEr.setForeground(Color.RED);
		jLLBoEr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPListBookEdit.add(jLLBoEr);
		
		jTBookPageNo = new JTextField();
		jTBookPageNo.setBounds(545,140,150,30);
		//to make field to accept numbrs only
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
		
		jBListBookEdit = new JButton("MODIFY");
		jBListBookEdit.setBounds(535,190,150,30);
		jBListBookEdit.setBorderPainted(false);
		jBListBookEdit.setBackground(new Color(245,245,245));
		jBListBookEdit.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookEdit.setForeground(new Color(0,128,128));
		jPListBookEdit.add(jBListBookEdit);
		
		jPListBookDelt = new JPanel();
		jPListBookDelt.setBounds(180,560,720,140);
		jPListBookDelt.setLayout(null);
		jPListBookDelt.setBackground(Color.WHITE);
		jPListBookMain.add(jPListBookDelt);
		
		jLListBookDelt = new JLabel("DELETE OR LOAN OUT BOOK CHAPTER");
		jLListBookDelt.setBounds(130,0,450,30);
		jLListBookDelt.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPListBookDelt.add(jLListBookDelt);
		
		jLListBookId = new JLabel("BOOK ID");
		jLListBookId.setBounds(20,40,300,30);
		jLListBookId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookDelt.add(jLListBookId);
		
		jTBookId = new JTextField();
		jTBookId.setBounds(200,40,150,30);
		jTBookId.setEditable(false);
		jTBookId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookDelt.add(jTBookId);
		
		jBListBookDelt = new JButton("DELETE");
		jBListBookDelt.setBounds(270,85,120,30);
		jBListBookDelt.setBorderPainted(false);
		jBListBookDelt.setBackground(new Color(245,245,245));
		jBListBookDelt.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookDelt.setForeground(new Color(0,128,128));
		jPListBookDelt.add(jBListBookDelt);
		
		jLBokName = new JLabel("Researcher's Name");
		jLBokName.setBounds(360,40,300,30);
		jLBokName.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookDelt.add(jLBokName);
		
		jTBokRshNme = new JTextField();
		jTBokRshNme.setBounds(540,40,150,30);
		jTBokRshNme.setFont(new Font("Verdana",Font.PLAIN,17));
		jPListBookDelt.add(jTBokRshNme);
		
		jBBrBLo = new JButton("LOAN OUT");
		jBBrBLo.setBounds(540,85,150,30);
		jBBrBLo.setBorderPainted(false);
		jBBrBLo.setBackground(new Color(245,245,245));
		jBBrBLo.setFont(new Font("Verdana",Font.PLAIN,17));
		jBBrBLo.setForeground(new Color(0,128,128));
		jPListBookDelt.add(jBBrBLo);
		
		jTBSrch = new JTextField();
		jTBSrch.setBounds(23,80,150,30);
		jTBSrch.setFont(new Font("Verdana",Font.PLAIN,17));
		//for searching information
		jTBSrch.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				DefaultTableModel tbModB = (DefaultTableModel)jTabBookTable.getModel();
				String bkSrch = jTBSrch.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> srtBkSrh = new TableRowSorter<DefaultTableModel>(tbModB);
				jTabBookTable.setRowSorter(srtBkSrh);
				srtBkSrh.setRowFilter(RowFilter.regexFilter(bkSrch));
			}
		});
		jPListBookControl.add(jTBSrch);
		
		
		jBListBookAddNew = new JButton("ADD NEW");
		jBListBookAddNew.setBounds(23,200,140,30);
		jBListBookAddNew.setBorderPainted(false);
		jBListBookAddNew.setBackground(new Color(245,245,245));
		jBListBookAddNew.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookAddNew.setForeground(new Color(0,128,128));
		jPListBookControl.add(jBListBookAddNew);
		
		jBListBookBack = new JButton("BACK");
		jBListBookBack.setBounds(23,260,140,30);
		jBListBookBack.setBorderPainted(false);
		jBListBookBack.setBackground(new Color(245,245,245));
		jBListBookBack.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookBack.setForeground(new Color(0,128,128));
		jPListBookControl.add(jBListBookBack);
		
		jBListBookLogout = new JButton("SIGN OUT");
		jBListBookLogout.setBounds(23,320,140,30);
		jBListBookLogout.setBorderPainted(false);
		jBListBookLogout.setBackground(new Color(245,245,245));
		jBListBookLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBListBookLogout.setForeground(new Color(0,128,128));
		jPListBookControl.add(jBListBookLogout);
		
		ListAllBookModel BookModel = new ListAllBookModel();
		
		//calling method
		ListAllBookController listBook = new ListAllBookController(this);
		listBook.listAllBook();
		
		jSBookPane = new JScrollPane(jTabBookTable);
		jSBookPane.setBounds(180,80,720,200);
		jPListBookMain.add(jSBookPane);
		
	}

	//getters and setters
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

	public JButton getjBListBookAddNew() {
		return jBListBookAddNew;
	}

	public void setjBListBookAddNew(JButton jBListBookAddNew) {
		this.jBListBookAddNew = jBListBookAddNew;
	}

	public JButton getjBListBookLogout() {
		return jBListBookLogout;
	}

	public void setjBListBookLogout(JButton jBListBookLogout) {
		this.jBListBookLogout = jBListBookLogout;
	}

	public JButton getjBListBookEdit() {
		return jBListBookEdit;
	}

	public void setjBListBookEdit(JButton jBListBookEdit) {
		this.jBListBookEdit = jBListBookEdit;
	}

	public JButton getjBListBookDelt() {
		return jBListBookDelt;
	}

	public void setjBListBookDelt(JButton jBListBookDelt) {
		this.jBListBookDelt = jBListBookDelt;
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
