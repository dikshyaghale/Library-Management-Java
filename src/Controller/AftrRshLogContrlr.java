package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AddBookChapModel;
import Model.AddNewConferenceArtModel;
import Model.AddNewJournalModel;
import Model.ResearcherLoginModel;
import View.AvailableArtcVw;
import View.BorrConfrDesign;
import View.BorrJrnlDesign;
import View.BrrBookDesign;
import View.ResearchLoginView;

public class AftrRshLogContrlr {
	
	private BorrJrnlDesign jrDs;
	private BorrConfrDesign CrDs;
	private BrrBookDesign brrDs;
	private AvailableArtcVw avlV;
	
	public AftrRshLogContrlr(AvailableArtcVw avlV) {
		this.avlV = avlV;
	}
	
	public AftrRshLogContrlr(BorrJrnlDesign jrDs) {
		this.jrDs = jrDs;
	}
	
	public AftrRshLogContrlr(BorrConfrDesign CrDs) {
		this.CrDs = CrDs;
	}
	
	public AftrRshLogContrlr(BrrBookDesign brrDs) {
		this.brrDs = brrDs;
	}
	
	//buttons for researcher main view
	public void mainRshCon() {
		avlV.getjBAfrExit().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		avlV.getjBAfrlgOut().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				avlV.dispose();
				ResearchLoginView vw = new ResearchLoginView();
				ResearcherLoginModel logMod = new ResearcherLoginModel(null, null);
				ResearcherLoginController reColler = new ResearcherLoginController(vw, logMod);
				reColler.researchController();
				vw.setVisible(true);
				
			}
		});
		avlV.getjBJoBrr().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				avlV.dispose();
				@SuppressWarnings("unused")
				BorrJrnlDesign bj = new BorrJrnlDesign();
				
			}
		});
		avlV.getjBConBrr().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				avlV.dispose();
				@SuppressWarnings("unused")
				BorrConfrDesign cb = new BorrConfrDesign();
				
			}
		});
		avlV.getjBBokBrr().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				avlV.dispose();
				@SuppressWarnings("unused")
				BrrBookDesign bd = new BrrBookDesign();
				
			}
		});
	}
	
	//for journal
	public void rtnJournal() {
		jrDs.getjBListJourReturn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				AddNewJournalModel jrnlRtn = new AddNewJournalModel();
				if(jrDs.getJourId().isEmpty()||jrDs.getJourArtTitle().isEmpty()||jrDs.getJourAuthor().isEmpty()||jrDs.getJourTitle().isEmpty()||jrDs.getJourYear().isEmpty()||jrDs.getJourVolume().isEmpty()||jrDs.getJourIssue().isEmpty()||jrDs.getJourPage().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select article to return");
				}
				else {
					jrnlRtn.rtnBrrJrnl(jrDs, jrDs.getPrimaryId());
					JOptionPane.showMessageDialog(null, "Article returned");
					jrDs.dispose();
					@SuppressWarnings("unused")
					BorrJrnlDesign bjr = new BorrJrnlDesign();
				}	
			}
		});
		
		jrDs.getjBListJourBack().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jrDs.dispose();
				@SuppressWarnings("unused")
				AvailableArtcVw avV = new AvailableArtcVw();
				
			}
		});
		
		jrDs.getjBListJourLogout().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jrDs.dispose();
				ResearchLoginView vw = new ResearchLoginView();
				ResearcherLoginModel logMod = new ResearcherLoginModel(null, null);
				ResearcherLoginController reColler = new ResearcherLoginController(vw, logMod);
				reColler.researchController();
				vw.setVisible(true);
				
			}
		});
	}
	
	//for returning book articles
	public void brrBokRtn() {
		brrDs.getjBListBookReturn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddBookChapModel bkNw = new AddBookChapModel();
				if(brrDs.getCBokId().isEmpty()||brrDs.getCBokTitl().isEmpty()||brrDs.getCBokAuthr().isEmpty()||brrDs.getCBokPubYar().isEmpty()||brrDs.getCBokEdtr().isEmpty()||brrDs.getCBokplce().isEmpty()||brrDs.getCBokPublsher().isEmpty()||brrDs.getCBokPgeNo().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select article to return");
				}
				else {
					bkNw.brrBokRtn(brrDs, brrDs.getChapBokNum());
					JOptionPane.showMessageDialog(null, "Article returned");
					brrDs.dispose();
					@SuppressWarnings("unused")
					BrrBookDesign bjDsgn = new BrrBookDesign();
				}
			}
		});
		
		brrDs.getjBListBookBack().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				brrDs.dispose();
				@SuppressWarnings("unused")
				AvailableArtcVw avlB = new AvailableArtcVw();
				
			}
		});
		brrDs.getjBListBookLogout().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				brrDs.dispose();
				ResearchLoginView vLog = new ResearchLoginView();
				ResearcherLoginModel rMod = new ResearcherLoginModel(null, null);
				ResearcherLoginController rCont = new ResearcherLoginController(vLog, rMod);
				rCont.researchController();
				vLog.setVisible(true);
				
			}
		});
	}
	
	//FOR RETURNING CONFERENCE ARTICLE
	public void retrnCont() {
		CrDs.getjBListConReturn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(CrDs.getConfId().isEmpty()||CrDs.getConfTitle().isEmpty()||CrDs.getConfAuthor().isEmpty()||CrDs.getConfYear().isEmpty()||CrDs.getConfEditor().isEmpty()||CrDs.getConfLoct().isEmpty()||CrDs.getConfNoPage().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select article to return");
				}
				else {
					AddNewConferenceArtModel acM = new AddNewConferenceArtModel();
					acM.retuConf(CrDs,CrDs.getSetConfNum());
					JOptionPane.showMessageDialog(null, "Article returned");
					CrDs.dispose();
					@SuppressWarnings("unused")
					BorrConfrDesign cd = new BorrConfrDesign();
				}
				
			}
		});
	}

	

}
