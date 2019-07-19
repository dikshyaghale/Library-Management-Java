package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.AddNewBookChapController;

public class AddNewBookChapView extends JFrame {
	private static final long serialVersionUID = 562217130017166320L;
	
	static int bChId = 1000;
	private JPanel jPBookMainPanel, jPBookHeader, jPBookControls, jPBookAddPanel;
	private JButton jBBookAddBtn, jBBookBackBtn, jBBookLogout, jBBookClear;
	private JLabel jLBookHeaderLbl,jLBPEr,jLBErMsg, jLBookControlLbl, jLBookAddLbl, jLBookId, jLBookTitle, jLBookAuthor, jLBookPublishedYear, jLBookEditor, jLBookPlace, jLBookPublisher, jLBookPageNo;
	private JTextField jTBookId, jTBookTitle, jTBookAuthor, jTBookPublished, jTBookEditor, jTBookPlace, jTBookPublisher, jTBookPageNo;
	private ImageIcon uonIcon = new ImageIcon("images/uni.jpg");

	public AddNewBookChapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,750,600);
		setResizable(false);
		setTitle("Northampton Article Management System ");
		setIconImage(uonIcon.getImage());
		setBackground(Color.white);
		setLocationRelativeTo(null);
		Container cont = getContentPane();
		cont.setLayout(null);
		createBookAddGUi();
		setVisible(true);
	}

	private void createBookAddGUi() {
		jPBookMainPanel = new JPanel();
		jPBookMainPanel.setBorder(new EmptyBorder(4,4,4,4));
		jPBookMainPanel.setLayout(null);
		jPBookMainPanel.setBounds(140,140,750,600);
		jPBookMainPanel.setBackground(new Color(245,245,245));
		setContentPane(jPBookMainPanel);
		
		jPBookHeader = new JPanel();
		jPBookHeader.setBorder(new EmptyBorder(4,4,4,4));
		jPBookHeader.setLayout(null);
		jPBookHeader.setBounds(0,0,750,70);
		jPBookHeader.setBackground(new Color(0,128,128));
		jPBookMainPanel.add(jPBookHeader);
		
		jLBookHeaderLbl = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: ADD BOOK CHAPTER");
		jLBookHeaderLbl.setBounds(20,15,750,45);
		jLBookHeaderLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLBookHeaderLbl.setForeground(new Color(240,255,255));
		jPBookHeader.add(jLBookHeaderLbl);
		
		jPBookControls = new JPanel();
		jPBookControls.setBounds(0,70,220,700);
		jPBookControls.setLayout(null);
		jPBookControls.setBackground(new Color(244,164,96));
		jPBookMainPanel.add(jPBookControls);
		
		jLBookControlLbl = new JLabel("Control here");
		jLBookControlLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLBookControlLbl.setBounds(10,18,200,30);
		jLBookControlLbl.setForeground(new Color(240,255,255));
		jPBookControls.add(jLBookControlLbl);
		
		jPBookAddPanel = new JPanel();
		jPBookAddPanel.setBounds(220,70,530,700);
		jPBookAddPanel.setLayout(null);
		jPBookAddPanel.setBackground(Color.WHITE);
		jPBookMainPanel.add(jPBookAddPanel);
		
		jLBookAddLbl = new JLabel("ADD NEW BOOK CHAPTER");
		jLBookAddLbl.setBounds(50,18,430,30);
		jLBookAddLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
		jPBookAddPanel.add(jLBookAddLbl);
		
		jLBookId = new JLabel("ID");
		jLBookId.setBounds(40,65,300,30);
		jLBookId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookId);
		
		jTBookId = new JTextField();
		jTBookId.setBounds(230,65,150,30);
		jTBookId.setEditable(false);
		jTBookId.setText(Integer.toString(bChId));
		jTBookId.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookId);
		
		jLBookTitle = new JLabel("Title of book");
		jLBookTitle.setBounds(40,110,300,30);
		jLBookTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookTitle);
		
		jTBookTitle = new JTextField();
		jTBookTitle.setBounds(230,110,150,30);
		jTBookTitle.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookTitle);
		
		jLBookAuthor = new JLabel("Author");
		jLBookAuthor.setBounds(40,155,300,30);
		jLBookAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookAuthor);
		
		jTBookAuthor = new JTextField();
		jTBookAuthor.setBounds(230,155,150,30);
		jTBookAuthor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookAuthor);
		
		jLBookPublishedYear = new JLabel("Published Year");
		jLBookPublishedYear.setBounds(40,195,300,30);
		jLBookPublishedYear.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookPublishedYear);
		
		jLBPEr = new JLabel();
		jLBPEr.setBounds(235,225,280,10);
		jLBPEr.setForeground(Color.RED);
		jLBPEr.setFont(new Font("Verdana",Font.PLAIN,10));
		jPBookAddPanel.add(jLBPEr);
		
		jTBookPublished = new JTextField();
		jTBookPublished.setBounds(230,195,150,30);
		jTBookPublished.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookPublished);
		
		jLBookEditor = new JLabel("Editor");
		jLBookEditor.setBounds(40,240,300,30);
		jLBookEditor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookEditor);
		
		jTBookEditor = new JTextField();
		jTBookEditor.setBounds(230,240,150,30);
		jTBookEditor.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookEditor);
		
		jLBookPlace = new JLabel("Place of publication");
		jLBookPlace.setBounds(40,285,300,30);
		jLBookPlace.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookPlace);
		
		jTBookPlace = new JTextField();
		jTBookPlace.setBounds(230,285,150,30);
		jTBookPlace.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookPlace);
		
		jLBookPublisher = new JLabel("Publisher");
		jLBookPublisher.setBounds(40,330,300,30);
		jLBookPublisher.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookPublisher);
		
		jTBookPublisher = new JTextField();
		jTBookPublisher.setBounds(230,330,150,30);
		jTBookPublisher.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookPublisher);
		
		jLBErMsg = new JLabel();
		jLBErMsg.setBounds(390,388,140,12);
		jLBErMsg.setForeground(Color.RED);
		jLBErMsg.setFont(new Font("Verdana",Font.PLAIN,12));
		jPBookAddPanel.add(jLBErMsg);
		
		jLBookPageNo = new JLabel("Page Number");
		jLBookPageNo.setBounds(40,375,300,30);
		jLBookPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jLBookPageNo);
		
		jTBookPageNo = new JTextField();
		jTBookPageNo.setBounds(230,375,150,30);
		jTBookPageNo.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent event) {
				char bEr = event.getKeyChar();

				if(!(Character.isDigit(bEr)) ||(bEr==KeyEvent.VK_BACK_SPACE) || (bEr==KeyEvent.VK_DELETE)){
					jLBErMsg.setText("Numbers only");
					event.consume();
					}
				else {
					jLBErMsg.setText("");
					}
				}
		});
		jTBookPageNo.setFont(new Font("Verdana",Font.PLAIN,17));
		jPBookAddPanel.add(jTBookPageNo);
		
		jBBookAddBtn = new JButton("ADD");
		jBBookAddBtn.setBackground(new Color(245,245,245));
		jBBookAddBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBBookAddBtn.setBounds(250,420,80,30);
		jBBookAddBtn.setBorderPainted(false);
		jBBookAddBtn.setForeground(new Color(0,128,128));
		jPBookAddPanel.add(jBBookAddBtn);
		
		jBBookBackBtn = new JButton("BACK");
		jBBookBackBtn.setBounds(23,70,140,30);
		jBBookBackBtn.setBorderPainted(false);
		jBBookBackBtn.setBackground(new Color(245,245,245));
		jBBookBackBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBBookBackBtn.setForeground(new Color(0,128,128));
		jPBookControls.add(jBBookBackBtn);
		
		jBBookClear = new JButton("RESET");
		jBBookClear.setBounds(23,130,140,30);
		jBBookClear.setBorderPainted(false);
		jBBookClear.setBackground(new Color(245,245,245));
		jBBookClear.setFont(new Font("Verdana",Font.PLAIN,17));
		jBBookClear.setForeground(new Color(0,128,128));
		jPBookControls.add(jBBookClear);
		
		jBBookLogout = new JButton("SIGN OUT");
		jBBookLogout.setBounds(23,190,140,30);
		jBBookLogout.setBorderPainted(false);
		jBBookLogout.setBackground(new Color(245,245,245));
		jBBookLogout.setFont(new Font("Verdana",Font.PLAIN,17));
		jBBookLogout.setForeground(new Color(0,128,128));
		jPBookControls.add(jBBookLogout);
		
		AddNewBookChapController addBookCon = new AddNewBookChapController(this);
		addBookCon.addBookController();
		
	}
	
	public void chpIncId() {
		String idFld = getjTBookId().getText();
		setjTBookId(Integer.valueOf(idFld));
		idFld = Integer.toString(++bChId);
		getjTBookId().setText(idFld);
	}
	
	public JLabel getjLBErMsg() {
		return jLBErMsg;
	}

	public void setjLBErMsg(JLabel jLBErMsg) {
		this.jLBErMsg = jLBErMsg;
	}
	
	public JLabel getjLBPEr() {
		return jLBPEr;
	}

	public void setjLBPEr(JLabel jLBPEr) {
		this.jLBPEr = jLBPEr;
	}

	public JButton getjBBookAddBtn() {
		return jBBookAddBtn;
	}

	public void setjBBookAddBtn(JButton jBBookAddBtn) {
		this.jBBookAddBtn = jBBookAddBtn;
	}

	public JButton getjBBookClear() {
		return jBBookClear;
	}

	public void setjBBookClear(JButton jBBookClear) {
		this.jBBookClear = jBBookClear;
	}

	public JButton getjBBookBackBtn() {
		return jBBookBackBtn;
	}

	public void setjBBookBackBtn(JButton jBBookBackBtn) {
		this.jBBookBackBtn = jBBookBackBtn;
	}

	public JButton getjBBookLogout() {
		return jBBookLogout;
	}

	public void setjBBookLogout(JButton jBBookLogout) {
		this.jBBookLogout = jBBookLogout;
	}

	public JTextField getjTBookId() {
		return jTBookId;
	}

	public void setjTBookId(int bChId) {
		this.bChId = bChId;
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

	public JTextField getjTBookPublished() {
		return jTBookPublished;
	}

	public void setjTBookPublished(JTextField jTBookPublished) {
		this.jTBookPublished = jTBookPublished;
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
	
}
