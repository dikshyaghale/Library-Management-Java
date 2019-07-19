package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Model.AddNewJournalModel;
import Model.AddNewResearcherModel;
import Model.JournalSerialize;
import Model.ListAllJournalModel;
import Model.ResearcherLoginModel;
import View.AddNewJournalView;
import View.AdminResearcherHome;
import View.AvailableArtcVw;
import View.BorrJrnlDesign;
import View.ListAllJournalView;
import View.ResearchLoginView;

public class ListAllJournalController {
	//required attributes
	ListAllJournalView listAllJour;
	ListAllJournalModel listAllJourModel;
	AddNewJournalModel jurVw = new AddNewJournalModel();
	private AvailableArtcVw avableArtcVw;
	private BorrJrnlDesign brrJr;
	private ResearchLoginView rsVw;
	private ResearcherLoginController coLV;
	
	ArrayList<JournalSerialize> infoJourArr = new ArrayList<JournalSerialize>();
	//constructor
	public ListAllJournalController(ListAllJournalView listAllJour) {
		this.listAllJour = listAllJour;
	}
	
	public ListAllJournalController(AvailableArtcVw avableArtcVw) {
		this.avableArtcVw = avableArtcVw;
	}

	public ListAllJournalController(BorrJrnlDesign forBrrJrnl) {
		this.brrJr = forBrrJrnl;
	}

	public ListAllJournalController() {
		
	}

	//method to make buttons work
	public void listJourButtons() {
		//listener for back button
		listAllJour.getjBListJourBack().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listAllJour.dispose();
				AdminResearcherHome admnHome = new AdminResearcherHome();
				
			}
		});
		//for logout button
		listAllJour.getjBListJourLogout().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listAllJour.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
				
			}
		});
		//this is for adding new journal to the system
		listAllJour.getjBListJourAddNew().addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				listAllJour.dispose();
				AddNewJournalView addJour = new AddNewJournalView();				
			}
		});

		//this is for edit button
		listAllJour.getjBListJourEdit().addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				AddNewJournalModel modJrnl = new AddNewJournalModel();
				if(listAllJour.getJourArtTitle().isEmpty()|| //check if fields are empty or not
						listAllJour.getJourAuthor().isEmpty()||
						listAllJour.getJourId().isEmpty()||
						listAllJour.getJourIssue().isEmpty()||
						listAllJour.getJourPage().isEmpty()||
						listAllJour.getJourTitle().isEmpty()||
						listAllJour.getJourVolume().isEmpty()||
						listAllJour.getJourYear().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select any row to modify the data");
				}
				else {
					if(jurVw.valJouDate(listAllJour.getJourYear())) {//check if date is valid or not
						try {
							modJrnl.jrnalEdit(listAllJour, listAllJour.getPrimaryId());
							JOptionPane.showMessageDialog(null, "Modified");
							listAllJour.dispose();
						    listAllJour = new ListAllJournalView();
						} catch (Exception e2) {
							
						}
					}
					else {
						listAllJour.getjLDtEr().setText("make sure date is correct");
					}
				}
			}
		});
		//to make the delete button work, following codes are required
		listAllJour.getjBListJourDelt().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AddNewJournalModel jrnlMod = new AddNewJournalModel();
				if(listAllJour.getJourArtTitle().isEmpty()||listAllJour.getJourAuthor().isEmpty()||listAllJour.getJourId().isEmpty()||listAllJour.getJourIssue().isEmpty()||listAllJour.getJourPage().isEmpty()||listAllJour.getJourTitle().isEmpty()||listAllJour.getJourVolume().isEmpty()||listAllJour.getJourYear().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select any row to delete the data");
				}
				else {
					try {
						jrnlMod.jrnlDelt(listAllJour, listAllJour.getPrimaryId());
						listAllJour.dispose();
					    listAllJour = new ListAllJournalView();
					} catch (Exception e2) {
				
					}
				}
			
			}
		});
		//loan out code
		listAllJour.getjBLoanOut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listAllJour.getJourArtTitle().isEmpty()||listAllJour.getJourAuthor().isEmpty()||listAllJour.getJourId().isEmpty()||listAllJour.getJourIssue().isEmpty()||listAllJour.getJourPage().isEmpty()||listAllJour.getJourTitle().isEmpty()||listAllJour.getJourVolume().isEmpty()||listAllJour.getJourYear().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select any article to lo loan out");
				}
				else {
					try {
						AddNewJournalModel brrBrnl = new AddNewJournalModel();
						AddNewResearcherModel brrMod = new AddNewResearcherModel();
						
						if(listAllJourModel.uNmeOfRshr(listAllJour)) {
							brrBrnl.brrAdd(listAllJour);
							JOptionPane.showMessageDialog(null, "Article loaned out");
							listAllJour.getjTJourId().setText(null);
							listAllJour.getjTJourArticle().setText(null);
							listAllJour.getjTJourAuthor().setText(null);
							listAllJour.getjTJourIssueNo().setText(null);
							listAllJour.getjTJourPubYear().setText(null);
							listAllJour.getjTJourTitle().setText(null);
							listAllJour.getjTJourVolumeNo().setText(null);
							listAllJour.getjTPageNo().setText(null);
							listAllJour.getReshNme().setText(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "No such researcher");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}

				
			}
		});
	}
	
	//method to show table
	public void listJourTable() {
		listAllJourModel = new ListAllJournalModel();
		JScrollPane jourPane = listAllJourModel.getjSJournalScroll();
		listAllJour.setjTabJourTable(listAllJourModel.getjTabJournalDetails());
		listAllJour.setjSJournalPane(jourPane);
	}
	
	//table view for available journals
	public void listAvlTble() {
		listAllJourModel = new ListAllJournalModel();
		JScrollPane jourPane = listAllJourModel.getjSJournalScroll();
		avableArtcVw.setjTabJourTable(listAllJourModel.getjTabJournalDetails());
		avableArtcVw.setjSJournalPane(jourPane);
	}
	
	//table view for borrowed journals
	public void brrTb()
	{
		
		ListAllJournalModel jBr = new ListAllJournalModel();
		jBr.BorrJour();
		JScrollPane jPne = jBr.getjSJouBrrScroll();
			
		brrJr.setjTabJourTable(jBr.getjTabJourBrrDetail());
		brrJr.setjSJournalPane(jPne);	
		
	}

}
