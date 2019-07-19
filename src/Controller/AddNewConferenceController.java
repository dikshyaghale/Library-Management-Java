package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AddNewConferenceArtModel;
import Model.AddNewJournalModel;
import Model.ResearcherLoginModel;
import View.AddNewConferenceArtcView;
import View.ListAllConferenceView;
import View.ResearchLoginView;

public class AddNewConferenceController {
	AddNewConferenceArtcView addNewConHome;
	AddNewJournalModel modJrAd;
	AddNewConferenceArtModel conNewMod = new AddNewConferenceArtModel();
	
	public AddNewConferenceController(AddNewConferenceArtcView addNewConHome) {
	
		this.addNewConHome = addNewConHome;
	}
	
	public void AddContractCont() {
		addNewConHome.getjBConBack().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addNewConHome.dispose();
				ListAllConferenceView listConference = new ListAllConferenceView();
				
			}
		});
		addNewConHome.getjBConLogout().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addNewConHome.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
				
			}
		});
		
		addNewConHome.getjBConClear().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addNewConHome.getjTConAuthor().setText(null);
				addNewConHome.getjTConEditors().setText(null);
			//	addNewConHome.getjTConId().setText(null);
				addNewConHome.getjTConLocation().setText(null);
				addNewConHome.getjTConPageNo().setText(null);
				addNewConHome.getjTConPublishedYear().setText(null);
				addNewConHome.getjTConTitle().setText(null);
				
				
			}
		});
		//for adding new conference article
		addNewConHome.getjBConAddBtn().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				if(addNewConHome.getjTConId().getText().isEmpty()||
						addNewConHome.getjTConTitle().getText().isEmpty()||
						addNewConHome.getjTConAuthor().getText().isEmpty()||
						addNewConHome.getjTConPublishedYear().getText().isEmpty()||
						addNewConHome.getjTConEditors().getText().isEmpty()||
						addNewConHome.getjTConLocation().getText().isEmpty()||
						addNewConHome.getjTConPageNo().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the form");
					
				}
				//check if valid date is entered or not
				if(modJrAd.valJouDate(addNewConHome.getjTConPublishedYear().getText())) {
					conNewMod.conModAdd(addNewConHome);
					addNewConHome.dispose();
					ListAllConferenceView cv = new ListAllConferenceView();
				}
				else {
					addNewConHome.getjLConYEr().setText("follow format");
					JOptionPane.showMessageDialog(null, "Enter valid info");
				}
				
			}
		});
		//increase id
				addNewConHome.cArcId();
	}

}
