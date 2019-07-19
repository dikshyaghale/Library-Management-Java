package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Model.AddNewConferenceArtModel;
import Model.AddNewJournalModel;
import Model.ListAllConferenceModel;
import Model.ResearcherLoginModel;
import View.AddNewConferenceArtcView;
import View.AdminResearcherHome;
import View.AvailableArtcVw;
import View.BorrConfrDesign;
import View.ListAllConferenceView;
import View.ResearchLoginView;

public class ListAllConferenceController {
	//creating the instance of different classes
	ListAllConferenceView listConf;
	ListAllConferenceModel listConfModel;
	AddNewJournalModel anjm;
	private AvailableArtcVw avLViw;
//	private VwAftrResearcher brrCon;
	private BorrConfrDesign borrConfr;
	//constructor
	public ListAllConferenceController(ListAllConferenceView listConf) {
		this.listConf = listConf;
	}
	
	public ListAllConferenceController(AvailableArtcVw avLViw) {
		this.avLViw = avLViw;
	}
	
	public ListAllConferenceController(BorrConfrDesign borrConfr) {
		this.borrConfr = borrConfr;
	}

	//main method to make the buttons work
	public void listConfContrl() {
		//for back button
		listConf.getjBListConBack().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				listConf.dispose();
				AdminResearcherHome admnHome = new AdminResearcherHome();
				
			}
		});
		//this is how logout button works
		listConf.getjBListConLogout().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listConf.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
				
			}
		});
		//this is how add new button works
		listConf.getjBListConAddNew().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listConf.dispose();
				AddNewConferenceArtcView addConferenceArt = new AddNewConferenceArtcView();
				
			}
		});
		//for modifying data
		listConf.getjBListConEdit().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewConferenceArtModel confrModl = new AddNewConferenceArtModel();
				if(listConf.getConfTitle().isEmpty()||listConf.getConfAuthor().isEmpty()||listConf.getConfYear().isEmpty()||listConf.getConfEditor().isEmpty()||listConf.getConfLoct().isEmpty()||listConf.getConfNoPage().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select row to modify data.");
				}
				else {
					if(anjm.valJouDate(listConf.getConfYear())) {
						try {
							confrModl.changeConArtc(listConf, listConf.getSetConfNum());
							listConf.dispose();
							listConf = new ListAllConferenceView();
						} catch (Exception e2) {
							
						}
					}
					else {
						listConf.getjLDtEr().setText("Date format should be YYYY-MM-DD");
					}

				}
				
			}
		});
		
		//for deleting informations
		listConf.getjBListConDelt().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				AddNewConferenceArtModel confrModl = new AddNewConferenceArtModel();

				if(listConf.getConfId().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select row to delete");
				}
				else {
					try {
						confrModl.throwConArt(listConf, listConf.getSetConfNum());
						listConf.dispose();
						listConf = new ListAllConferenceView();
					} catch (Exception e2) {
						
					}
				}
			}
		});
		
		//LOAN OUT
		listConf.getjBCBLoan().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(listConf.getConfTitle().isEmpty()||listConf.getConfAuthor().isEmpty()||listConf.getConfYear().isEmpty()||listConf.getConfEditor().isEmpty()||listConf.getConfLoct().isEmpty()||listConf.getConfNoPage().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select row to loan out article.");
				}
				else {
					try {
						AddNewConferenceArtModel afm = new AddNewConferenceArtModel();

						if(listConfModel.getEnNameC(listConf)) {
							afm.CtBrrA(listConf);
							JOptionPane.showMessageDialog(null, "Article loaned out");
							listConf.getjTConAuthor().setText("");
							listConf.getjTConEditors().setText("");
							listConf.getjTConId().setText("");
							listConf.getjTConLocation().setText(null);
							listConf.getjTConPageNo().setText(null);
							listConf.getjTConPublishedYear().setText("");
							listConf.getjTConTitle().setText(null);
							listConf.getjTRshEntName().setText(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "Researcher not found");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			}
		});
		
		
		//for creating table in the view
		listConfModel = new ListAllConferenceModel();
		JScrollPane conScroll = listConfModel.getjSConPane();
		listConf.setjTabConference(listConfModel.getjTabConTable());
		listConf.setjSConference(conScroll);
		
	}
	//available conference articles table
	public void avlView() {
		listConfModel = new ListAllConferenceModel();
		JScrollPane conScroll = listConfModel.getjSConPane();
		avLViw.setjTabCon(listConfModel.getjTabConTable());
		avLViw.setjSConScrl(conScroll);
	}

	//show borrowed books in the table
	public void brrCon() {
		ListAllConferenceModel conM = new ListAllConferenceModel();
		conM.conBrrTab();
		JScrollPane jBrCon = conM.getjSConBrrPane();
		borrConfr.setjTabConference(conM.getjTabConBrrTable());
		borrConfr.setjSConference(jBrCon);
	}
}
