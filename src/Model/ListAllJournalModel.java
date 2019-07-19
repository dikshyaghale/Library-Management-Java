package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import View.AddNewJournalView;
import View.AvailableArtcVw;
import View.ListAllJournalView;
import View.ResearchLoginView;

public class ListAllJournalModel {
	//creating new object of Arraylist
	ArrayList<JournalSerialize> jouInfoArry = new ArrayList<JournalSerialize>();
	//fields of other classes
	ResearchLoginView vrs;
	AddNewJournalModel brrRshV;
	ListAllJournalView jlV;
	//some attributes that supports in creating table
	private DefaultTableModel journalTable = new DefaultTableModel(0,8);
	private JTable jTabJournalDetails = new JTable(journalTable);
	private JScrollPane jSJournalScroll = new JScrollPane(jTabJournalDetails);

	//table for borrowed journal articles
	private DefaultTableModel jourBrrTable = new DefaultTableModel(0,8);
	private JTable jTabJourBrrDetail = new JTable(jourBrrTable);
	private JScrollPane jSJouBrrScroll = new JScrollPane(jTabJourBrrDetail);

	private String entRsName;

	private ListAllJournalView vLJour;
	
	//constructor for borrowed articles
	public ListAllJournalModel(ListAllJournalView vLJour) {
		
		this.vLJour = vLJour;
		
	}
	
	//constructor
	public ListAllJournalModel(){
		
		viewJournalTable();
	}	
	
	//method creating table
	public void viewJournalTable(){
		
		//checks if the table is empty or not
		if(arrJourAllInfo()!=null) {
			jouInfoArry = arrJourAllInfo();
			JournalSerialize allValJour = new JournalSerialize();
			
			//adding new rows to the table
			for(int info=0;info<jouInfoArry.size();info++) {
				allValJour = jouInfoArry.get(info);
				Object[]  jourVals = {allValJour.getJourId(),allValJour.getJourTitleArticle(),allValJour.getJourAuthor(),allValJour.getJourTitle(),allValJour.getJourPublished(),allValJour.getJourVolume(),allValJour.getJourIssue(),allValJour.getJourPage()};
				journalTable.addRow(jourVals);
			}
		}	
		//table header
			Object noColumn[] = {"Id","Title of article","Author","Title of journal","Published date","Volume No","Issue No","Page No"};
			journalTable.setColumnIdentifiers(noColumn);
			jTabJournalDetails.setRowHeight(30);
			
			//setting width of column in table
			TableColumnModel colJournal = jTabJournalDetails.getColumnModel();
			colJournal.getColumn(0).setPreferredWidth(10);
	}
	//for searching information
	
	
	//borrowed journal articles table
		public void BorrJour() {
			if(arrJourBrr()!=null) {
				jouInfoArry = arrJourBrr();
				JournalSerialize alBrour = new JournalSerialize();
				
				for(int brr=0;brr<jouInfoArry.size();brr++) {
					alBrour = jouInfoArry.get(brr);
					Object[]  BrrJVals = {alBrour.getJourId(),alBrour.getJourTitleArticle(),alBrour.getJourAuthor(),alBrour.getJourTitle(),alBrour.getJourPublished(),alBrour.getJourVolume(),alBrour.getJourIssue(),alBrour.getJourPage()};
					jourBrrTable.addRow(BrrJVals);
				}
			}
			//table headers for journal articles
			Object noCo[] = {"Id","Title of article","Author","Title of journal","Published date","Volume No","Issue No","Page No"};
			jourBrrTable.setColumnIdentifiers(noCo);
			jTabJourBrrDetail.setRowHeight(30);
			//column model
			TableColumnModel colJournal = jTabJourBrrDetail.getColumnModel();
		}
		
	
	
	//method to read the file stored in file
	@SuppressWarnings("unchecked")
	public ArrayList<JournalSerialize> arrJourAllInfo(){
		ArrayList<JournalSerialize> allJour = null;
		
		try {
			FileInputStream jourInp = new FileInputStream("binaryFiles/Journal.dat");
			ObjectInputStream objJourOut = new ObjectInputStream(jourInp);
			Object objJour = objJourOut.readObject();
			
			allJour = (ArrayList<JournalSerialize>)objJour;
			objJourOut.close();
		}catch (Exception e) {
			
		}
		return allJour;
	}
	
	//arrayList for borrowed journal Articles
	@SuppressWarnings("unchecked")
	public ArrayList<JournalSerialize> arrJourBrr(){
		ArrayList<JournalSerialize> allJour = null;
		
		try {
			FileInputStream brrInp = new FileInputStream("binaryFiles/borrJournal.dat");
			ObjectInputStream brrJourOut = new ObjectInputStream(brrInp);
			Object objJour = brrJourOut.readObject();
			
			allJour = (ArrayList<JournalSerialize>)objJour;
			brrJourOut.close();
		}catch (Exception e) {
			
		}
		return allJour;
	}
	
	//borrowed
	public boolean chekEntUN(String entRsName) {
		String entN = getEntRsName();
		if(entN.equals(entRsName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//BORROWED...READ THE USERNAME STORED IN RESEARCHER
	@SuppressWarnings("unchecked")
	public boolean uNmeOfRshr(ListAllJournalView Lrsh) {
		boolean matchFnd = false;
		
		ArrayList<SeriResearch> fndRsh = null;
		//read the values present in the file named researcher.dat
		try {
			FileInputStream inpStr = new FileInputStream("binaryFiles/Researcher.dat");
			ObjectInputStream inObjRsh = new ObjectInputStream(inpStr);
			Object shJl = inObjRsh.readObject();
			
			fndRsh = (ArrayList<SeriResearch>)shJl;
			
			//read the file until entered value matches with the value of that file
			for(int mat =0; mat<fndRsh.size();mat++) { 
				setEntRsName(fndRsh.get(mat).getResUsername());
				if(matchFnd=chekEntUN(Lrsh.getjTRshEntName())){
					break;
				}
				//closing file
				inObjRsh.close();
			}
			
		} catch (Exception e) {
			
		}
		return matchFnd;
	}
	//all needed getters and setters
	public String getEntRsName() {
		return entRsName;
	}

	public void setEntRsName(String entRsName) {
		this.entRsName = entRsName;
	}
	
	public ListAllJournalModel(String entRsName) {
		this.entRsName = entRsName;
	}

	public JTable getjTabJourBrrDetail() {
		return jTabJourBrrDetail;
	}


	public void setjTabJourBrrDetail(JTable jTabJourBrrDetail) {
		this.jTabJourBrrDetail = jTabJourBrrDetail;
	}


	public JScrollPane getjSJouBrrScroll() {
		return jSJouBrrScroll;
	}


	public void setjSJouBrrScroll(JScrollPane jSJouBrrScroll) {
		this.jSJouBrrScroll = jSJouBrrScroll;
	}


	//relevant getters and setters
	public JTable getjTabJournalDetails() {
		return jTabJournalDetails;
	}

	public void setjTabJournalDetails(JTable jTabJournalDetails) {
		this.jTabJournalDetails = jTabJournalDetails;
	}

	public JScrollPane getjSJournalScroll() {
		return jSJournalScroll;
	}

	public void setjSJournalScroll(JScrollPane jSJournalScroll) {
		this.jSJournalScroll = jSJournalScroll;
	}

}
