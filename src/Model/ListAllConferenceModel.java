package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import View.ListAllConferenceView;

public class ListAllConferenceModel {
	
	ArrayList<SeriContract> allValCon = new ArrayList<SeriContract>();
	
	private DefaultTableModel conTabMain = new DefaultTableModel(0,7);
	private JTable jTabConTable = new JTable(conTabMain);
	private JScrollPane jSConPane = new JScrollPane(jTabConTable);
	
	private DefaultTableModel conBrrMain = new DefaultTableModel(0,7);
	private JTable jTabConBrrTable = new JTable(conBrrMain);
	private JScrollPane jSConBrrPane = new JScrollPane(jTabConBrrTable);
	
	private String entContNme;

	private ListAllConferenceView vLConV;
	
	public String getEntContNme() {
		return entContNme;
	}

	public void setEntContNme(String entContNme) {
		this.entContNme = entContNme;
	}

	public ListAllConferenceModel(String entContNme) {
		this.entContNme = entContNme;
	}
	
	public ListAllConferenceModel() {
		viewConferenceTab();
	}
	
	public ListAllConferenceModel(ListAllConferenceView vLConV) {
		this.vLConV = vLConV;
	}

	//borrowed conference table
	public void conBrrTab() {
		
		if(conBrr()!=null) {
			allValCon = conBrr();
			SeriContract conBrSe = new SeriContract();
			
			for(int bc=0; bc<allValCon.size();bc++) {
				conBrSe = allValCon.get(bc);
				Object[] valBrC = {conBrSe.getConId(),conBrSe.getConTitle(),conBrSe.getConAuthor(),conBrSe.getConPubYear(),conBrSe.getConEditor(),conBrSe.getConLoct(),conBrSe.getConPageNo()};
				conBrrMain.addRow(valBrC);
			}
		}
		
		Object confBrrCols[] = {"id","Title","Author","Published year","Editors","Location","Page No"};
		conBrrMain.setColumnIdentifiers(confBrrCols);
		jTabConBrrTable.setRowHeight(25);
		
		//set the width of columns in table
		TableColumnModel conModel = jTabConBrrTable.getColumnModel();
		conModel.getColumn(0).setPreferredWidth(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<SeriContract> confValInArr(){
		ArrayList<SeriContract> conf = null;
		
		try {
			FileInputStream confInp = new FileInputStream("binaryFiles/contractFile.dat");
			ObjectInputStream objInpConf = new ObjectInputStream(confInp);
			Object objConf = objInpConf.readObject();
			
			conf = (ArrayList<SeriContract>)objConf;
			objInpConf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conf;
		
	}
	//for borrowed
	//CHANGE VARIABLE
	public ArrayList<SeriContract> conBrr(){
		ArrayList<SeriContract> brrIn = null;
		try {
			FileInputStream brrInp = new FileInputStream("binaryFiles/borrConference.dat");
			ObjectInputStream brrJourOut = new ObjectInputStream(brrInp);
			Object objJour = brrJourOut.readObject();
			
			brrIn = (ArrayList<SeriContract>)objJour;
			brrJourOut.close();
		}catch (Exception e) {
			
		}
		return brrIn;
	}
	
	private void viewConferenceTab() {
		
		if(confValInArr()!=null) {
			allValCon = confValInArr();
			SeriContract conferSerVal = new SeriContract();
			
			for(int confInfo=0; confInfo<allValCon.size(); confInfo++) {
				conferSerVal = allValCon.get(confInfo);
				Object[] coluConVals = {conferSerVal.getConId(),conferSerVal.getConTitle(),conferSerVal.getConAuthor(),conferSerVal.getConPubYear(),conferSerVal.getConEditor(),conferSerVal.getConLoct(),conferSerVal.getConPageNo()};
				conTabMain.addRow(coluConVals);
			}
		}
		
		Object conferenceCols[] = {"id","Title","Author","Published year","Editors","Location","Page No"};
		conTabMain.setColumnIdentifiers(conferenceCols);
		jTabConTable.setRowHeight(25);
		
		//set the width of columns in table
		TableColumnModel conModel = jTabConTable.getColumnModel();
		conModel.getColumn(0).setPreferredWidth(10);
		
	}
	
	//borrowed
	public boolean chkCoUsN(String entContNme) {
		String cntN = getEntContNme();
		if(cntN.equals(entContNme)) {
			return true;
		}
		else {
			return false;
		}
	}

	//BORROWED 
	@SuppressWarnings("unchecked")
	public boolean getEnNameC(ListAllConferenceView laCv) {
		boolean matchFnd = false;
		
		ArrayList<SeriResearch> fndRsh = null;
		try {
			FileInputStream brrCr = new FileInputStream("binaryFiles/Researcher.dat");
			ObjectInputStream obBrrCr = new ObjectInputStream(brrCr);
			Object reBrrC = obBrrCr.readObject();
			
			fndRsh = (ArrayList<SeriResearch>)reBrrC;
			
			for(int mat =0; mat<fndRsh.size();mat++) {
				setEntContNme(fndRsh.get(mat).getResUsername());
				if(matchFnd=chkCoUsN(laCv.getjTEntName())){
					break;
				}
				obBrrCr.close();
			}
			
		} catch (Exception e) {
			
		}
		return matchFnd;
	}
	
	
	public JTable getjTabConTable() {
		return jTabConTable;
	}

	public void setjTabConTable(JTable jTabConTable) {
		this.jTabConTable = jTabConTable;
	}

	public JScrollPane getjSConPane() {
		return jSConPane;
	}

	public void setjSConPane(JScrollPane jSConPane) {
		this.jSConPane = jSConPane;
	}

	public JTable getjTabConBrrTable() {
		return jTabConBrrTable;
	}

	public void setjTabConBrrTable(JTable jTabConBrrTable) {
		this.jTabConBrrTable = jTabConBrrTable;
	}

	public JScrollPane getjSConBrrPane() {
		return jSConBrrPane;
	}

	public void setjSConBrrPane(JScrollPane jSConBrrPane) {
		this.jSConBrrPane = jSConBrrPane;
	}
	

}
