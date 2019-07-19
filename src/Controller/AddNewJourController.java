package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AddNewJournalModel;
import Model.ResearcherLoginModel;
import View.AddNewJournalView;
import View.ListAllJournalView;
import View.ResearchLoginView;

public class AddNewJourController {
	//required attributes
	private AddNewJournalView addJourView;
	private AddNewJournalModel jourAddMod = new AddNewJournalModel();
	
	//relevant constructor
	public AddNewJourController(AddNewJournalView addJourView) {

		this.addJourView = addJourView;
	}
	
	//method that makes buttons work
	public void addJourCont() {
		addJourView.getjBJourBack().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addJourView.dispose();
				ListAllJournalView listJour = new ListAllJournalView();
				
			}
		});
		//for logout button
		addJourView.getjBJourLogout().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addJourView.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
				
			}
		});
		//action listener for reset button
		addJourView.getjBJourClear().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addJourView.getjTJourArticle().setText(null);
				addJourView.getjTJourAuthor().setText(null);
		//		addJourView.getjTJourId().setText(null);
				addJourView.getjTJourIssueNo().setText(null);
				addJourView.getjTJourPubYear().setText(null);
				addJourView.getjTJourTitle().setText(null);
				addJourView.getjTJourVolumeNo().setText(null);
				addJourView.getjTPageNo().setText(null);
				
			}
		});
		//action listener for add button i.e. this part supports to add values to journal
		addJourView.getjBJourAdd().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				//form validation
				if(addJourView.getjTJourId().getText().isEmpty()||
				   addJourView.getjTJourArticle().getText().isEmpty()||
				   addJourView.getjTJourAuthor().getText().isEmpty()||
				   addJourView.getjTJourTitle().getText().isEmpty()||
				   addJourView.getjTJourPubYear().getText().isEmpty()||
				   addJourView.getjTJourVolumeNo().getText().isEmpty()||
				   addJourView.getjTJourIssueNo().getText().isEmpty()||
				   addJourView.getjTPageNo().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all form");
				}
				else {
					if(jourAddMod.valJouDate(addJourView.getjTJourPubYear().getText())) {
						jourAddMod.modJourAdd(addJourView);
						JOptionPane.showMessageDialog(null, "Data added");
						addJourView.dispose();
						ListAllJournalView vj = new ListAllJournalView();
					}
					else {
						addJourView.getjLDteErMsg().setText("Enter date in YYYY-MM-DD format");
						addJourView.getjTJourPubYear().setText(null);
						JOptionPane.showMessageDialog(null, "Please enter valid informations");
					}
				}
			}
		});
		addJourView.jo();
	}

}
