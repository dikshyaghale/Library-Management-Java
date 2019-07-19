package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.ListAllResearcherController;
import Model.AddNewResearcherModel;
import Model.ListAllResearcherModel;

public class ListAllResearcherView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPViewMain, jPViewHeadPanel,jPCtrlPnl, jPResEditPanel, jPResDeltPanel;
	private JLabel jLHeaderLbl,jLLPhErr,jLEmErr,jLRshSerEr, jLRsSer, jLControl, jLEditLbl,jLDeltIdLbl, jLDeltLbl, jLResName, jLResAddress, jLResPhone, jLResEmail, jLResUsername, jLResPassord;
	private JTextField jTIdField, jTRshSear, jTResName, jTResAddress, jTResPhone, jTResEmail, jTResTUsername;
	private JPasswordField jTResPassword;
	private JButton jBResEditBtn, jBResDeltBtn, jBResBackBtn, jBLogoutBtn;
	private ImageIcon uniIcon = new ImageIcon("images/uni.jpg");
	private JTable jTabResearchTable = new JTable();
	private JScrollPane jSResearchPane;

	private int reserNum;

	public ListAllResearcherView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(140,140,900,720);
		setIconImage(uniIcon.getImage());
		setTitle("Northampton Article Management System ");
		setBackground(Color.white);
		setResizable(false);
		setLocationRelativeTo(null);
		Container content = getContentPane();
		content.setLayout(null);
		createViewResearcherGUi();
		fillResEditPanl();
		setVisible(true);
	}
	
	public void valsFixReser(String reshId, String reshNme, String reshAddrss, String reshPhne, String reshEml, String reshUsrnme, String reshPasswrd) {
		this.jTIdField.setText(reshId);
		this.jTResName.setText(reshNme);
		this.jTResAddress.setText(reshAddrss);
		this.jTResPhone.setText(reshPhne);
		this.jTResEmail.setText(reshEml);
		this.jTResTUsername.setText(reshUsrnme);
		this.jTResPassword.setText(reshPasswrd);
		
	}
	
	public void fillResEditPanl() {
		jTabResearchTable.addMouseListener(new java.awt.event.MouseAdapter() {
		
			public void mouseClicked(java.awt.event.MouseEvent me) {
				String rIdRes, rNmeRes, rAddrssRes, rPhneRes, rEmlRes, rUsrnmeRes, rPsswrdRes;
				int rschClmns;
				DefaultTableModel rsrchTab = (DefaultTableModel)jTabResearchTable.getModel();
				rschClmns = jTabResearchTable.getSelectedRow();
				
				rIdRes = rsrchTab.getValueAt(rschClmns, 0).toString();
				rNmeRes = rsrchTab.getValueAt(rschClmns, 1).toString();
				rAddrssRes = rsrchTab.getValueAt(rschClmns, 2).toString();
				rPhneRes = rsrchTab.getValueAt(rschClmns, 3).toString();
				rEmlRes = rsrchTab.getValueAt(rschClmns, 4).toString();
				rUsrnmeRes = rsrchTab.getValueAt(rschClmns, 5).toString();
				rPsswrdRes = rsrchTab.getValueAt(rschClmns, 6).toString();
				valsFixReser(rIdRes, rNmeRes, rAddrssRes, rPhneRes, rEmlRes, rUsrnmeRes, rPsswrdRes);
				setReserNum(jTabResearchTable.getSelectedRow());
			}
			
		});
	}

	private void createViewResearcherGUi() {
		jPViewMain = new JPanel();
		jPViewMain.setLayout(null);
		jPViewMain.setBackground(new Color(245,245,245));
		jPViewMain.setBounds(140,140,900,720);
		setContentPane(jPViewMain);	
		
		jPViewHeadPanel = new JPanel();
		jPViewHeadPanel.setLayout(null);
		jPViewHeadPanel.setBounds(0,0,900,70);
		jPViewHeadPanel.setBackground(new Color(0,128,128));
		jPViewMain.add(jPViewHeadPanel);
		
		jLHeaderLbl = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT: VIEW RESEARCHER");
		jLHeaderLbl.setForeground(new Color(240,255,255));
		jLHeaderLbl.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLHeaderLbl.setBounds(80,15,750,45);
		jPViewHeadPanel.add(jLHeaderLbl);
		
		jPCtrlPnl = new JPanel();
		jPCtrlPnl.setLayout(null);
		jPCtrlPnl.setBackground(new Color(244,164,96));
		jPCtrlPnl.setBounds(0,70,180,700);
		jPViewMain.add(jPCtrlPnl);
		
		jLRsSer = new JLabel("Search Here");
		jLRsSer.setBounds(20,24,180,30);
		jLRsSer.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLRsSer.setForeground(new Color(240,255,255));
		jPCtrlPnl.add(jLRsSer);
		
		jLControl = new JLabel("Controls here");
		jLControl.setBounds(5,140,180,30);
		jLControl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jLControl.setForeground(new Color(240,255,255));
		jPCtrlPnl.add(jLControl);
		
		jBResBackBtn = new JButton("BACK");
		jBResBackBtn.setBounds(23,200,140,30);
		jBResBackBtn.setBorderPainted(false);
		jBResBackBtn.setBackground(new Color(245,245,245));
		jBResBackBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBResBackBtn.setForeground(new Color(0,128,128));
		jPCtrlPnl.add(jBResBackBtn);
		
		
		jBLogoutBtn = new JButton("SIGN OUT");
		jBLogoutBtn.setBounds(23,260,140,30);
		jBLogoutBtn.setBorderPainted(false);
		jBLogoutBtn.setBackground(new Color(245,245,245));
		jBLogoutBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBLogoutBtn.setForeground(new Color(0,128,128));
		jPCtrlPnl.add(jBLogoutBtn);
		
		jPResEditPanel = new JPanel();
		jPResEditPanel.setBackground(Color.WHITE);
		jPResEditPanel.setLayout(null);
		jPResEditPanel.setBounds(180,290,720,250);
		jPViewMain.add(jPResEditPanel);
		
		jLEditLbl = new JLabel("Edit Researcher's Details");
		jLEditLbl.setBounds(180,0,450,30);
		jLEditLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPResEditPanel.add(jLEditLbl);
		
		jLResName = new JLabel("Name");
		jLResName.setBounds(20,40,300,30);
		jLResName.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jLResName);
		
		jTResName = new JTextField();
		jTResName.setBounds(150,40,150,30);
		jTResName.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jTResName);
		
		jLResAddress = new JLabel("Address");
		jLResAddress.setBounds(20,90,300,30);
		jLResAddress.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jLResAddress);
		
		jTResAddress = new JTextField();
		jTResAddress.setBounds(150,90,150,30);
		jTResAddress.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jTResAddress);
		
		jLResPhone = new JLabel("Phone");
		jLResPhone.setBounds(20,140,300,30);
		jLResPhone.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jLResPhone);
		
		jLLPhErr = new JLabel();
		jLLPhErr.setBounds(155,168,150,15);
		jLLPhErr.setForeground(Color.RED);
		jLLPhErr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPResEditPanel.add(jLLPhErr);
		
		jTResPhone = new JTextField();
		jTResPhone.setBounds(150,140,150,30);
		jTResPhone.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				String phnNum = jTResPhone.getText();
				int numLen = phnNum.length();
				
				char c = e.getKeyChar();

				if((e.getKeyChar()>='0' && e.getKeyChar()<='9') || c == KeyEvent.VK_BACK_SPACE) {
					
					if(numLen<10 || c == KeyEvent.VK_BACK_SPACE) {
						jLLPhErr.setText("");
						jTResPhone.setEditable(true);
						
					}
					else {
						jLLPhErr.setText("Not more than 10");
						jTResPhone.setEditable(false);
					}
				}
				else {
					jLLPhErr.setText("Enter numbers only");
					jTResPhone.setEditable(false);
				}

			}
		});
		jTResPhone.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jTResPhone);
		
		jLRshSerEr = new JLabel();
		jLRshSerEr.setBounds(30,118,300,12);
		jLRshSerEr.setFont(new Font("Verdana",Font.PLAIN,12));
		jLRshSerEr.setForeground(Color.red);
		jPCtrlPnl.add(jLRshSerEr);
		
		
		jTRshSear = new JTextField();
		jTRshSear.setBounds(23,80,140,30);
		jTRshSear.setFont(new Font("Verdana",Font.PLAIN,17));
		jTRshSear.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) 
			{
				char errRsh = e.getKeyChar();

				if(!(Character.isDigit(errRsh)) ||(errRsh==KeyEvent.VK_BACK_SPACE) || (errRsh==KeyEvent.VK_DELETE)){
					jLRshSerEr.setText("ID only");
					e.consume();
					
				}
				
				else {
					jLRshSerEr.setText("");
					
				}
				
				DefaultTableModel deffTb = (DefaultTableModel)jTabResearchTable.getModel();
				String srchTxt = jTRshSear.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> srtRsh = new TableRowSorter<DefaultTableModel>(deffTb);
				jTabResearchTable.setRowSorter(srtRsh);
				srtRsh.setRowFilter(RowFilter.regexFilter(srchTxt));
			}
		});
		jPCtrlPnl.add(jTRshSear);
		
		jLResEmail = new JLabel("Email");
		jLResEmail.setBounds(430,40,300,30);
		jLResEmail.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jLResEmail);
		
		jLEmErr = new JLabel();
		jLEmErr.setBounds(530,67,150,15);
		jLEmErr.setForeground(Color.RED);
		jLEmErr.setFont(new Font("Verdana",Font.PLAIN,12));
		jPResEditPanel.add(jLEmErr);
		
		jTResEmail = new JTextField();
		jTResEmail.setBounds(530,40,150,30);
		jTResEmail.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jTResEmail);
		
		jLResUsername = new JLabel("Username");
		jLResUsername.setBounds(430,90,300,30);
		jLResUsername.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jLResUsername);
		
		jTResTUsername = new JTextField();
		jTResTUsername.setBounds(530,90,150,30);
		jTResTUsername.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jTResTUsername);
		
		jLResPassord = new JLabel("Password");
		jLResPassord.setBounds(430,140,300,30);
		jLResPassord.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jLResPassord);
		
		jTResPassword = new JPasswordField();
		jTResPassword.setBounds(530,140,150,30);
		jTResPassword.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResEditPanel.add(jTResPassword);
		
		jBResEditBtn = new JButton("MODIFY");
		jBResEditBtn.setBounds(300,200,120,30);
		jBResEditBtn.setBorderPainted(false);
		jBResEditBtn.setBackground(new Color(245,245,245));
		jBResEditBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBResEditBtn.setForeground(new Color(0,128,128));
		jPResEditPanel.add(jBResEditBtn);
		
		jPResDeltPanel = new JPanel();
		jPResDeltPanel.setBounds(180,560,720,140);
		jPResDeltPanel.setLayout(null);
		jPResDeltPanel.setBackground(Color.WHITE);
		jPViewMain.add(jPResDeltPanel);
		
		jLDeltLbl = new JLabel("Delete Researcher");
		jLDeltLbl.setBounds(190,0,450,30);
		jLDeltLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,20));
		jPResDeltPanel.add(jLDeltLbl);
		
		jLDeltIdLbl = new JLabel("Researcher's ID");
		jLDeltIdLbl.setBounds(20,40,300,30);
		jLDeltIdLbl.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResDeltPanel.add(jLDeltIdLbl);
		
		jTIdField = new JTextField();
		jTIdField.setBounds(200,40,150,30);
		jTIdField.setEditable(false);
		jTIdField.setFont(new Font("Verdana",Font.PLAIN,17));
		jPResDeltPanel.add(jTIdField);
		
		jBResDeltBtn = new JButton("DELETE");
		jBResDeltBtn.setBounds(270,85,120,30);
		jBResDeltBtn.setBorderPainted(false);
		jBResDeltBtn.setBackground(new Color(245,245,245));
		jBResDeltBtn.setFont(new Font("Verdana",Font.PLAIN,17));
		jBResDeltBtn.setForeground(new Color(0,128,128));
		jPResDeltPanel.add(jBResDeltBtn);
		
		ListAllResearcherModel researchModel = new ListAllResearcherModel();
		
		ListAllResearcherController listResearcherCon = new ListAllResearcherController(this);
		listResearcherCon.listResearcherCont();	
		
		jSResearchPane = new JScrollPane(jTabResearchTable);
		jSResearchPane.setBounds(180,80,720,200);
		jPViewMain.add(jSResearchPane);	
	}

	
	public JLabel getjLEmErr() {
		return jLEmErr;
	}

	public void setjLEmErr(JLabel jLEmErr) {
		this.jLEmErr = jLEmErr;
	}

	public int getReserNum() {
		return reserNum;
	}

	public void setReserNum(int reser) {
		this.reserNum = reser;
	}
	
	public JTable getjTabResearchTable() {
		return jTabResearchTable;
	}

	public void setjTabResearchTable(JTable jTabResearchTable) {
		this.jTabResearchTable = jTabResearchTable;
	}

	public JScrollPane getjSResearchPane() {
		return jSResearchPane;
	}

	public void setjSResearchPane(JScrollPane jSResearchPane) {
		this.jSResearchPane = jSResearchPane;
	}

	public JButton getjBResEditBtn() {
		return jBResEditBtn;
	}

	public void setjBResEditBtn(JButton jBResEditBtn) {
		this.jBResEditBtn = jBResEditBtn;
	}

	public JButton getjBResDeltBtn() {
		return jBResDeltBtn;
	}

	public void setjBResDeltBtn(JButton jBResDeltBtn) {
		this.jBResDeltBtn = jBResDeltBtn;
	}

	public JButton getjBResBackBtn() {
		return jBResBackBtn;
	}

	public void setjBResBackBtn(JButton jBResBackBtn) {
		this.jBResBackBtn = jBResBackBtn;
	}

	public JButton getjBLogoutBtn() {
		return jBLogoutBtn;
	}

	public void setjBLogoutBtn(JButton jBLogoutBtn) {
		this.jBLogoutBtn = jBLogoutBtn;
	}
	
	public String getRsrchId() {
		return jTIdField.getText();
	}
	
	public String getRsrchNme() {
		return jTResName.getText();
	}
	
	public String getRsrchAddrss() {
		return jTResAddress.getText();
	}
	
	public String getRsrchPhne() {
		return jTResPhone.getText();
	}
	
	public String getRsrchEml() {
		return jTResEmail.getText();
	}
	
	public String getRsrchUsrnme() {
		return jTResTUsername.getText();
	}
	
	public String getRsrchPsswrd() {
		return jTResPassword.getText();
	}


}
