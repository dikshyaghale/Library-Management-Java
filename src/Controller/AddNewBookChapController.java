package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AddBookChapModel;
import Model.AddNewJournalModel;
import Model.ResearcherLoginModel;
import View.AddNewBookChapView;
import View.ListAllBookChapterView;
import View.ResearchLoginView;

public class AddNewBookChapController {
	AddNewBookChapView addNewBookHome;
	AddNewJournalModel jrAd;

	AddBookChapModel modBookAdd = new AddBookChapModel();
	//setting constructor
	public AddNewBookChapController(AddNewBookChapView addNewBookHome) {
		this.addNewBookHome = addNewBookHome;
	}
	
	//method for controlling button
	public void addBookController() {
		//actionlistener fo back button
		addNewBookHome.getjBBookBackBtn().addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				addNewBookHome.dispose();
				ListAllBookChapterView listBook = new ListAllBookChapterView();
				
			}
		});
		//action listener for logout button
		addNewBookHome.getjBBookLogout().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addNewBookHome.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
				
			}
		});
		//actionListener for reset button
		addNewBookHome.getjBBookClear().addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				addNewBookHome.getjTBookAuthor().setText(null);
				addNewBookHome.getjTBookEditor().setText(null);
			//	addNewBookHome.getjTBookId().setText(null);
				addNewBookHome.getjTBookPageNo().setText(null);
				addNewBookHome.getjTBookPlace().setText(null);
				addNewBookHome.getjTBookPublished().setText(null);
				addNewBookHome.getjTBookPublisher().setText(null);
				addNewBookHome.getjTBookTitle().setText(null);
				
				
			}
		});
		//increase the id automatically
		addNewBookHome.chpIncId();
		
		//action of button to add new book chapter
		addNewBookHome.getjBBookAddBtn().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				if(addNewBookHome.getjTBookId().getText().isEmpty()||addNewBookHome.getjTBookTitle().getText().isEmpty()||addNewBookHome.getjTBookAuthor().getText().isEmpty()||addNewBookHome.getjTBookPublished().getText().isEmpty()||addNewBookHome.getjTBookEditor().getText().isEmpty()||addNewBookHome.getjTBookPlace().getText().isEmpty()||addNewBookHome.getjTBookPlace().getText().isEmpty()||addNewBookHome.getjTBookPublisher().getText().isEmpty()||addNewBookHome.getjTBookPageNo().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "All fields must be filled");
				}
				else {
					if(jrAd.valJouDate(addNewBookHome.getjTBookPublished().getText())) {
						modBookAdd.chapBookAdd(addNewBookHome);
						JOptionPane.showMessageDialog(null, "Values Added");
						addNewBookHome.dispose();
						ListAllBookChapterView allBookV = new ListAllBookChapterView();
					}
					else {
						addNewBookHome.getjLBPEr().setText("Date should be in YYYY-MM-DD format");
						JOptionPane.showMessageDialog(null, "Enter correct information");
					}
			//	ListAllBookChapterView allBookV = new ListAllBookChapterView();			
				}
			}
		});
	}
}
