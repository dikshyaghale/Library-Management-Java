package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import View.ListAllBookChapterView;

public class ListAllBookModel{
	
	private static final long serialVersionUID = -2774631802379890179L;
	//table model to store the cell value objects
	private DefaultTableModel allBookModel = new DefaultTableModel(0,8);
	private JTable jTabBookTab = new JTable(allBookModel);
	private JScrollPane jSBookPane = new JScrollPane(jTabBookTab);

	//for borrowed table
	private DefaultTableModel allBoBrrMdl = new DefaultTableModel(0,8);
	private JTable jTabBokBrrTab = new JTable(allBoBrrMdl);
	private JScrollPane jSBokBrrPne = new JScrollPane(jTabBokBrrTab);
	
	//creating fields
	private String RsBokNme;
	private ListAllBookChapterView BCV;
	
	public ListAllBookModel(ListAllBookChapterView BCV) {
		this.BCV = BCV;
	}

	ArrayList<ChapterSerialize> chapBookArr = new ArrayList<ChapterSerialize>();
	//constructor
	public ListAllBookModel() {
		listBookTab();
	}
	
	//borrowed articles in the table
	public void brrowBoTb() {
		if(chpBrr()!=null) {
			chapBookArr = chpBrr();
			
			ChapterSerialize seCh = new ChapterSerialize();
			
			for(int cR=0; cR<chapBookArr.size();cR++) {
				seCh = chapBookArr.get(cR);
				Object[] brVal = {seCh.getChapBookId(),seCh.getChapBookTitle(),seCh.getChapBookAuthor(),seCh.getChapBookPubYear(),seCh.getChapBookEditor(),seCh.getChapBookPlace(),seCh.getChapBookPublisher(),seCh.getChapBookPageNo()};
				allBoBrrMdl.addRow(brVal);
			}
		}
		
		//table headers for borrowed book chapters
		Object ComBrr[] = {"Id","Title","Author","Published year","Editor","Published place","Publisher","Page No"};
		allBoBrrMdl.setColumnIdentifiers(ComBrr);
		jTabBokBrrTab.setRowHeight(20);
		TableColumnModel listBookModel = jTabBokBrrTab.getColumnModel();
		
		listBookModel.getColumn(0).setPreferredWidth(10);
	}

	//method to read the values stored in file
	@SuppressWarnings("unchecked")
	public ArrayList<ChapterSerialize> readBookArr(){
		ArrayList<ChapterSerialize> chapBook = null;
		
		try {
			FileInputStream bookchapInp = new FileInputStream("binaryFiles/BookChapter.dat");
			ObjectInputStream objChap = new ObjectInputStream(bookchapInp);
			Object objBook = objChap.readObject();
			
			chapBook = (ArrayList<ChapterSerialize>)objBook;
			objChap.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chapBook;
		
	}
	
	//method to create table for book chapters
	private void listBookTab() {

		//check if the arraylist is null or not
		if(readBookArr()!=null) {
			chapBookArr = readBookArr();
			//creating new object
			ChapterSerialize readChapVals = new ChapterSerialize();
			
			for(int book=0;book<chapBookArr.size();book++) {
				readChapVals = chapBookArr.get(book);
				//get values
				Object[] getVals = {readChapVals.getChapBookId(),
						readChapVals.getChapBookTitle(),
						readChapVals.getChapBookAuthor(),readChapVals.getChapBookPubYear(),
						readChapVals.getChapBookEditor(),readChapVals.getChapBookPlace(),
						readChapVals.getChapBookPublisher(),readChapVals.getChapBookPageNo()};
				//adds row in table
				allBookModel.addRow(getVals);
			}
		}
		
		Object bookColumn[] = {"Id","Title","Author","Published year","Editor","Published place","Publisher","Page No"};
		allBookModel.setColumnIdentifiers(bookColumn);
		jTabBookTab.setRowHeight(20);
		TableColumnModel listBookModel = jTabBookTab.getColumnModel();
		
		listBookModel.getColumn(0).setPreferredWidth(10);
		
	}
	
	//FOR borrowed
	@SuppressWarnings("unchecked")
	public ArrayList<ChapterSerialize> chpBrr(){
		ArrayList<ChapterSerialize> infCh = null;
		
		try {
			FileInputStream brCInp = new FileInputStream("binaryFiles/borrBook.dat");
			ObjectInputStream brrCut = new ObjectInputStream(brCInp);
			Object objJour = brrCut.readObject();
			
			infCh = (ArrayList<ChapterSerialize>)objJour;
			brrCut.close();
		} catch (Exception e) {
			
		}
		return infCh;
	}
	
	//check the entered researchers name for loaning out article
	public boolean maEnRsN(String RsBokNme) {
		String mrsN = getRsBokNme();
		if(mrsN.contentEquals(RsBokNme)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//check the name entered and name of researcher in the file...if the name matches then then loan out article
	@SuppressWarnings("unchecked")
	public boolean maBokRes(ListAllBookChapterView bChV) {
		boolean smRsN = false;
		
		ArrayList<SeriResearch> mtNAr = null;
		try {
			FileInputStream bInBr = new FileInputStream("binaryFiles/Researcher.dat");
			ObjectInputStream bObBe = new ObjectInputStream(bInBr);
			Object shJl = bObBe.readObject();
			
			mtNAr = (ArrayList<SeriResearch>)shJl;
			
			for(int mat =0; mat<mtNAr.size();mat++) {
				setRsBokNme(mtNAr.get(mat).getResUsername());
				if(smRsN=maEnRsN(bChV.getjTBokRshNme())){
					break;
				}
				bObBe.close();
			}
			
		} catch (Exception e) {
			
		}
		return smRsN;
	}

	//relevant getters and setters
	public String getRsBokNme() {
		return RsBokNme;
	}

	public void setRsBokNme(String rsBokNme) {
		RsBokNme = rsBokNme;
	}
	
	public ListAllBookModel(String rsBokNme) {
		this.RsBokNme = rsBokNme;
	}
	
	
	public JTable getjTabBookTab() {
		return jTabBookTab;
	}

	public void setjTabBookTab(JTable jTabBookTab) {
		this.jTabBookTab = jTabBookTab;
	}

	public JScrollPane getjSBookPane() {
		return jSBookPane;
	}

	public void setjSBookPane(JScrollPane jSBookPane) {
		this.jSBookPane = jSBookPane;
	}

	public JTable getjTabBokBrrTab() {
		return jTabBokBrrTab;
	}

	public void setjTabBokBrrTab(JTable jTabBokBrrTab) {
		this.jTabBokBrrTab = jTabBokBrrTab;
	}

	public JScrollPane getjSBokBrrPne() {
		return jSBokBrrPne;
	}

	public void setjSBokBrrPne(JScrollPane jSBokBrrPne) {
		this.jSBokBrrPne = jSBokBrrPne;
	}
}
