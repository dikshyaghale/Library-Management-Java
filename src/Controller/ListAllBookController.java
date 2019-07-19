package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Model.AddBookChapModel;
import Model.AddNewJournalModel;
import Model.ListAllBookModel;
import Model.ResearcherLoginModel;
import View.AddNewBookChapView;
import View.AdminResearcherHome;
import View.AvailableArtcVw;
import View.BrrBookDesign;
import View.ListAllBookChapterView;
import View.ResearchLoginView;


public class ListAllBookController {
	//making the variables by importing other model and view
	
	ListAllBookChapterView listBook;
	ListAllBookModel listBookModel;
	AddNewJournalModel blDate;
	private AvailableArtcVw avlBok;
	private BrrBookDesign brrBook;
	
	//constructor for listing all book chapter article
	public ListAllBookController(ListAllBookChapterView listBook) {
		this.listBook = listBook;
	}
	
	//for available books
	public ListAllBookController(AvailableArtcVw avlBok) {
		this.avlBok = avlBok;
	}
	
	public ListAllBookController(BrrBookDesign brrBook) {
		this.brrBook = brrBook;
	}

	//the main method which works to make the button work
	public void listAllBook() {
		//for back button
		listBook.getjBListBookBack().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listBook.dispose();
				AdminResearcherHome admHome = new AdminResearcherHome();
				
			}
		});
		//this is for logout button
		listBook.getjBListBookLogout().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listBook.dispose();
				ResearchLoginView reView = new ResearchLoginView();
				ResearcherLoginModel reModel = new ResearcherLoginModel(null, null);
				ResearcherLoginController reController = new ResearcherLoginController(reView, reModel);
				reController.researchController();
				reView.setVisible(true);
				
			}
		});
		//for adding new book chapter
		listBook.getjBListBookAddNew().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				listBook.dispose();
				AddNewBookChapView addBook = new AddNewBookChapView();
				
			}
		});
		
		//for editing the information of book
		listBook.getjBListBookEdit().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				AddBookChapModel bokChpMdl = new AddBookChapModel();
				
				if(listBook.getCBokTitl().isEmpty()||listBook.getCBokAuthr().isEmpty()||listBook.getCBokPubYar().isEmpty()||listBook.getCBokEdtr().isEmpty()||listBook.getCBokplce().isEmpty()||listBook.getCBokPublsher().isEmpty()||listBook.getCBokPgeNo().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Plase select any row to modify the data");
				}
				else {
					if(blDate.valJouDate(listBook.getjTBookPublished().getText())) {
						try {
							bokChpMdl.chapChange(listBook, listBook.getChapBokNum());
							JOptionPane.showMessageDialog(null, "Required data is changed.");
							listBook.dispose();
							ListAllBookChapterView cbv = new ListAllBookChapterView();
						} catch (Exception e2) {
							
						}
					}
					else {
						
						listBook.getjLPYEr().setText("Date format is not correct");
						JOptionPane.showMessageDialog(null, "Sorry! invalid edit options");
					}
				}
				
			}
		});
		//for loaning out book articles
		listBook.getjBBrBLo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(listBook.getCBokTitl().isEmpty()||listBook.getCBokAuthr().isEmpty()||listBook.getCBokPubYar().isEmpty()||listBook.getCBokEdtr().isEmpty()||listBook.getCBokplce().isEmpty()||listBook.getCBokPublsher().isEmpty()||listBook.getCBokPgeNo().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Plase select any row to loan out the article");
				}
				else {
					try {
						AddBookChapModel bokChpMdl = new AddBookChapModel();

						if(listBookModel.maBokRes(listBook)) {
							bokChpMdl.BkBrrAdd(listBook);
							JOptionPane.showMessageDialog(null, "Book loaned out");
							listBook.getjTBookAuthor().setText("");
							listBook.getjTBookEditor().setText(null);
							listBook.getjTBookId().setText(null);
							listBook.getjTBookPageNo().setText(null);
							listBook.getjTBookPlace().setText(null);
							listBook.getjTBookPublished().setText(null);
							listBook.getjTBookPublisher().setText(null);
							listBook.getjTBookTitle().setText(null);
							listBook.getBrRshName().setText(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "There is no such Researcher");
						}
					} catch (Exception e) {
						
					}
					
				}
			}
		});
		
		//for deleting the books which are not required
		listBook.getjBListBookDelt().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddBookChapModel chptrBokMdl = new AddBookChapModel();
				
				if(listBook.getCBokId().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select any row");
					
				}
				else {
					try {
						chptrBokMdl.chapBokDlt(listBook, listBook.getChapBokNum());
						listBook.dispose();
						listBook = new ListAllBookChapterView();
					} catch (Exception e2) {
						
					}
				}
				
			}
		});
		//to generate the list of book table
		
		listBookModel = new ListAllBookModel();
		JScrollPane bookPane = listBookModel.getjSBookPane();
		listBook.setjTabBookTable(listBookModel.getjTabBookTab());
		listBook.setjSBookPane(bookPane);
				
	}
	//available table in researcher view
	public void listBokTble() {
		listBookModel = new ListAllBookModel();
		JScrollPane bookPane = listBookModel.getjSBookPane();
		avlBok.setjTabBokTble(listBookModel.getjTabBookTab());
		avlBok.setjSBok(bookPane);
	}
	//borrowed book chapters in researcher view
	public void bokBrowed() {
		ListAllBookModel liBrrMl = new ListAllBookModel();
		liBrrMl.brrowBoTb();
		JScrollPane boBrPa = liBrrMl.getjSBookPane();
		brrBook.setjTabBookTable(liBrrMl.getjTabBokBrrTab());
		brrBook.setjSBookPane(boBrPa);
	}

}
