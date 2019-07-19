package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controller.AdminResearchController;

public class AdminResearcherHome extends JFrame {
	  
	private static final long serialVersionUID = 1L;
	// required jPanel for making admin home
	  private JPanel jPAdminMainPanel,jPAdminHeaderPanel,jPResearcherPanel,jPMngResearchPanel,jPArticlesPanel,jPMngArticlesPanel;
	  //jButtons required
	  private JButton jBAddNewResearcher,jBSearBtn, jBViewResearcher,jBMngJournal, jBMngConference, jBMngBookChapter,jBSignOutBtn;
	  //neede jLAbel
	  private JLabel jLAdminHeader, jLResearcherImage, jLImageArticles, jLResearcherLbl, jLArticlesLbl;
	  //needed image icons
	  private ImageIcon uniIcon = new ImageIcon("images/uni.jpg");
	  private ImageIcon IconResearcher = new ImageIcon("images/researcher.jpg");
	  private ImageIcon IconResearchArticle = new ImageIcon("images/manRes.jpg");
	  private ImageIcon signoutIcon = new ImageIcon("images/logout.png");
	  
	  //constructor
	  public AdminResearcherHome() {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(140,140,800,720);
		  setUndecorated(true);
		  setTitle("Article Management System");
		  setBackground(Color.WHITE);
		  setResizable(false);
		  setIconImage(uniIcon.getImage());
		  setLocationRelativeTo(null);
		  Container cont = getContentPane();
		  cont.setLayout(null);
		  createAdminGUI();
		  setVisible(true);
	  }


	  //method to design admin home page
	private void createAdminGUI() {
		jPAdminMainPanel = new JPanel();
		jPAdminMainPanel.setLayout(null);
		jPAdminMainPanel.setBorder(new EmptyBorder(4,4,4,4));
		jPAdminMainPanel.setBounds(140,140,800,720);
//		jPAdminMainPanel.setBackground(new Color(119,136,153));
		setContentPane(jPAdminMainPanel);
		
		jPAdminHeaderPanel = new JPanel();
		jPAdminHeaderPanel.setBounds(0,0,800,70);
		jPAdminHeaderPanel.setBackground(new Color(0,128,128));
		jPAdminHeaderPanel.setLayout(null);
		jPAdminHeaderPanel.setBorder(new EmptyBorder(5,5,5,5));
		jPAdminMainPanel.add(jPAdminHeaderPanel);
	
		jLAdminHeader = new JLabel("NORTHAMPTON ARTICLE MANAGEMENT HOME PAGE");
		jLAdminHeader.setBounds(80,15,730,45);
		jLAdminHeader.setFont(new Font("Lucida Handwriting",Font.PLAIN,20));
		jLAdminHeader.setForeground(new Color(240,255,255));
		jPAdminHeaderPanel.add(jLAdminHeader);
		
		jLResearcherImage = new JLabel(IconResearcher);
		jLResearcherImage.setBounds(0,70,400,310);
		jPAdminMainPanel.add(jLResearcherImage);
		
		jPResearcherPanel = new JPanel();
		jPResearcherPanel.setBounds(400,70,400,310);
		jPResearcherPanel.setBackground(new Color(244,164,96));
		jPResearcherPanel.setLayout(null);
		jPAdminMainPanel.add(jPResearcherPanel);
		
		jLResearcherLbl = new JLabel("Manage Researcher");
		jLResearcherLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
		jLResearcherLbl.setBounds(70,40,430,30);
		jLResearcherLbl.setForeground(new Color(240,255,255));
		jPResearcherPanel.add(jLResearcherLbl);
		
		jPMngResearchPanel = new JPanel();
		jPMngResearchPanel.setBounds(35,90,335,180);
		jPMngResearchPanel.setBackground(new Color(245,245,245));
		jPMngResearchPanel.setLayout(null);
		jPResearcherPanel.add(jPMngResearchPanel);
		
		jBAddNewResearcher = new JButton("Add Researcher");
		jBAddNewResearcher.setBounds(28,35,250,35);
		jBAddNewResearcher.setBorderPainted(false);
		jBAddNewResearcher.setBackground(new Color(245,245,245));
		jBAddNewResearcher.setFont(new Font("Tahoma",Font.PLAIN,20));
		jBAddNewResearcher.setForeground(new Color(0,128,128));
		jPMngResearchPanel.add(jBAddNewResearcher);
		
		jBViewResearcher = new JButton("View Researcher");
		jBViewResearcher.setBounds(30,96,250,35);
		jBViewResearcher.setBorderPainted(false);
		jBViewResearcher.setBackground(new Color(245,245,245));
		jBViewResearcher.setFont(new Font("Tahoma",Font.PLAIN,20));
		jBViewResearcher.setForeground(new Color(0,128,128));
		jPMngResearchPanel.add(jBViewResearcher);
		
		jLImageArticles = new JLabel(IconResearchArticle);
		jLImageArticles.setBounds(0,390,400,315);
		jPAdminMainPanel.add(jLImageArticles);
		
		jPArticlesPanel = new JPanel();
		jPArticlesPanel.setBounds(400,390,400,315);
		jPArticlesPanel.setBackground(new Color(244,164,96));
		jPArticlesPanel.setLayout(null);
		jPAdminMainPanel.add(jPArticlesPanel);
		
		jLArticlesLbl = new JLabel("Manage Articles");
		jLArticlesLbl.setFont(new Font("Lucida Handwriting",Font.BOLD,22));
		jLArticlesLbl.setBounds(75,10,430,30);
		jLArticlesLbl.setForeground(new Color(240,255,255));
		jPArticlesPanel.add(jLArticlesLbl);
		
		jPMngArticlesPanel = new JPanel();
		jPMngArticlesPanel.setBounds(35,50,335,230);
		jPMngArticlesPanel.setBackground(new Color(245,245,245));
		jPMngArticlesPanel.setLayout(null);
		jPArticlesPanel.add(jPMngArticlesPanel);
		
		jBMngJournal = new JButton("Manage Journal Article");
		jBMngJournal.setBounds(7,35,340,35);
		jBMngJournal.setBorderPainted(false);
		jBMngJournal.setBackground(new Color(245,245,245));
		jBMngJournal.setFont(new Font("Tahoma",Font.PLAIN,20));
		jBMngJournal.setForeground(new Color(0,128,128));
		jPMngArticlesPanel.add(jBMngJournal);
		
		jBMngConference = new JButton("Manage Conference Article");
		jBMngConference.setBounds(7,85,340,35);
		jBMngConference.setBorderPainted(false);
		jBMngConference.setBackground(new Color(245,245,245));
		jBMngConference.setFont(new Font("Tahoma",Font.PLAIN,20));
		jBMngConference.setForeground(new Color(0,128,128));
		jPMngArticlesPanel.add(jBMngConference);
		
		jBMngBookChapter = new JButton("Manage Book Chapter");
		jBMngBookChapter.setBounds(7,135,340,35);
		jBMngBookChapter.setBorderPainted(false);
		jBMngBookChapter.setBackground(new Color(245,245,245));
		jBMngBookChapter.setFont(new Font("Tahoma",Font.PLAIN,20));
		jBMngBookChapter.setForeground(new Color(0,128,128));
		jPMngArticlesPanel.add(jBMngBookChapter);
		
		jBSignOutBtn = new JButton(signoutIcon);
		jBSignOutBtn.setBounds(750,15,35,36);
		jPAdminHeaderPanel.add(jBSignOutBtn);
		
		AdminResearchController cont = new AdminResearchController(this);
		cont.admnController();
		
	}


	//needed getters and setters

	public JButton getjBAddNewResearcher() {
		return jBAddNewResearcher;
	}


	public void setjBAddNewResearcher(JButton jBAddNewResearcher) {
		this.jBAddNewResearcher = jBAddNewResearcher;
	}


	public JButton getjBViewResearcher() {
		return jBViewResearcher;
	}


	public void setjBViewResearcher(JButton jBViewResearcher) {
		this.jBViewResearcher = jBViewResearcher;
	}


	public JButton getjBMngJournal() {
		return jBMngJournal;
	}


	public void setjBMngJournal(JButton jBMngJournal) {
		this.jBMngJournal = jBMngJournal;
	}


	public JButton getjBMngConference() {
		return jBMngConference;
	}


	public void setjBMngConference(JButton jBMngConference) {
		this.jBMngConference = jBMngConference;
	}


	public JButton getjBMngBookChapter() {
		return jBMngBookChapter;
	}


	public void setjBMngBookChapter(JButton jBMngBookChapter) {
		this.jBMngBookChapter = jBMngBookChapter;
	}


	public JButton getjBSignOutBtn() {
		return jBSignOutBtn;
	}


	public void setjBSignOutBtn(JButton jBSignOutBtn) {
		this.jBSignOutBtn = jBSignOutBtn;
	}
	  

}
