package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.ResearcherLoginModel;
import View.AddNewResearcherView;
import View.AdminResearcherHome;
import View.ListAllBookChapterView;
import View.ListAllConferenceView;
import View.ListAllJournalView;
import View.ListAllResearcherView;
import View.ResearchLoginView;

public class AdminResearchController {
	//creating field
	AdminResearcherHome admnHome;
	
	//constructor
	public AdminResearchController(AdminResearcherHome admnHome) {
		this.admnHome = admnHome;
	}
	
	//method to make buttons work for admin home
	public void admnController() {
		//for logout button
		admnHome.getjBSignOutBtn().addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
				admnHome.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
			}
		});
		//for adding new researcher
		admnHome.getjBAddNewResearcher().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				admnHome.dispose();
				AddNewResearcherView newResearcher = new AddNewResearcherView();
				
			}
		});
		//for viewing the list of all researcher
		admnHome.getjBViewResearcher().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				admnHome.dispose();
				@SuppressWarnings("unused")
				ListAllResearcherView listResearch = new ListAllResearcherView();
				
			}
		});
		//for managing journal article
		admnHome.getjBMngJournal().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				admnHome.dispose();
				ListAllJournalView listJour = new ListAllJournalView();
				
			}
		});
		//for managing conference article
		admnHome.getjBMngConference().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				admnHome.dispose();
				ListAllConferenceView listConf = new ListAllConferenceView();
				
			}
		});
		//for managing book chapter
		admnHome.getjBMngBookChapter().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				admnHome.dispose();
				ListAllBookChapterView listBook = new ListAllBookChapterView();			
			}
		});
	}

}
