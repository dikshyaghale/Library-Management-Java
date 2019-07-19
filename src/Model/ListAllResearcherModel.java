package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ListAllResearcherModel {
	
	ArrayList<SeriResearch> resArrList = new ArrayList<SeriResearch>();
	
	//required attributes to create table
	private DefaultTableModel researchTable = new DefaultTableModel(0,7);
	private JTable researchTab = new JTable(researchTable);
	private JScrollPane jSResearch = new JScrollPane(researchTab); 
	
	//constructor
	public ListAllResearcherModel() {
		
		researchTable();
	}
	//method to read all data stored in files
	@SuppressWarnings("unchecked")
	public ArrayList<SeriResearch> allResearchInfo(){
		
		ArrayList<SeriResearch> searcherList = null;
		
		try {
			FileInputStream searchInp = new FileInputStream("binaryFiles/Researcher.dat");
			ObjectInputStream searchObjOut = new ObjectInputStream(searchInp);
			Object searchObj = searchObjOut.readObject();
			
			searcherList = (ArrayList<SeriResearch>)searchObj;
			searchObjOut.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searcherList;
		
	}
	
	
	//method to create table
	private void researchTable() {
		//table header
		Object researchCol[] = {"Id","Name","Address","Phone","email","username","password"};
		researchTable.setColumnIdentifiers(researchCol);
		researchTab.setRowHeight(20);//sets the height of table
		TableColumnModel reModel = researchTab.getColumnModel();

		//checks if the table is empty or not and works as per it
		if(allResearchInfo()!=null) {
			resArrList = allResearchInfo();
			
			//creating new object of class named SeriResearch
			SeriResearch listSearcher = new SeriResearch();
			
			//add new rows including values in the table
			for(int serch=0; serch<resArrList.size();serch++) {
				listSearcher = resArrList.get(serch);
				Object[] searcherCols = {listSearcher.getResId(),listSearcher.getResName(),listSearcher.getResAddress(),listSearcher.getResPhone(),listSearcher.getResEmail(),listSearcher.getResUsername(),listSearcher.getResPassword()};
				researchTable.addRow(searcherCols);
			
			}
		}
		
	}	
		
	//relevant getter and setters
	public JTable getResearchTab() {
		return researchTab;
	}

	public void setResearchTab(JTable researchTab) {
		this.researchTab = researchTab;
	}

	public JScrollPane getjSResearch() {
		return jSResearch;
	}

	public void setjSResearch(JScrollPane jSResearch) {
		this.jSResearch = jSResearch;
	}
}
