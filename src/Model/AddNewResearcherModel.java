package Model;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import View.AddNewResearcherView;
import View.ListAllJournalView;
import View.ListAllResearcherView;

public class AddNewResearcherModel {
	
	//using arraylist
	ArrayList<SeriResearch> storeResArr = new ArrayList<SeriResearch>();
	//declaring feilds of other classes
	AddNewResearcherView vResech;
	SeriResearch resSeri;
	
	ListAllResearcherModel modResList = new ListAllResearcherModel();
	
	//for validating email
	public static boolean validEmail1(String in) {
		String regix = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern patEm = Pattern.compile(regix,Pattern.CASE_INSENSITIVE);
		Matcher match = patEm.matcher(in);
		
		return match.find();
	}	
	
	//modify researcher
	public void reserChnge(ListAllResearcherView vRes, int nRes) {
		storeResArr = modResList.allResearchInfo();
		resSeri = new SeriResearch(vRes.getRsrchId(),vRes.getRsrchNme(),vRes.getRsrchAddrss(),vRes.getRsrchPhne(),vRes.getRsrchEml(),vRes.getRsrchUsrnme(),vRes.getRsrchPsswrd().toCharArray());
		storeResArr.set(nRes, resSeri);
		resWriteInDat();
	
	}

	//method to write in file for researcher
	public void resWriteInDat() {
		File datRes = new File("binaryFiles/Researcher.dat");
		//check if file exists or not
		if(datRes.exists()) {
			try {
				FileOutputStream resOutInp = new FileOutputStream(datRes);
				ObjectOutputStream objResInp = new ObjectOutputStream(resOutInp);
				objResInp.writeObject(storeResArr);
				objResInp.close();
				
			} catch (Exception e) {
				
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No such file");
		}
	}
	
	//method to add new data and information to the researcher table
	public void addResMod(AddNewResearcherView vResech) {
		resSeri = new SeriResearch(vResech.getjTIdField().getText(),vResech.getjTResName().getText(),vResech.getjTResAddress().getText(),vResech.getjTResPhone().getText(),vResech.getjTResEmail().getText(),vResech.getjTResTUsername().getText(),vResech.getjPRePass().getText().toCharArray());
		if(modResList.allResearchInfo()!=null) {
			storeResArr = modResList.allResearchInfo();
			storeResArr.add(resSeri);
			resWriteInDat();
		}
		else {
			storeResArr.add(resSeri);
			resWriteInDat();
		}
	
	}
	//method to delete the researcher
	public void reserDelt(ListAllResearcherView vRes, int nRes) {
		int confrmRes = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		//check if yes option is pressed....if pressed then delete the researcher
		if(confrmRes == JOptionPane.YES_OPTION) {
			storeResArr = modResList.allResearchInfo();
			storeResArr.remove(nRes);  
			resWriteInDat();
			JOptionPane.showMessageDialog(null, "Selected row gpt deleted successfully.");
		}
		//check if no option is pressed..if pressed then dont delete researcher
		if(confrmRes == JOptionPane.NO_OPTION) {
			storeResArr = modResList.allResearchInfo();
			JOptionPane.showMessageDialog(null, "Then, it's ok.");
		}
	}
}
