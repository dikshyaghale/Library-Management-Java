package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import View.AddNewConferenceArtcView;
import View.BorrConfrDesign;
import View.ListAllConferenceView;

public class AddNewConferenceArtModel {
	//required attributes
	AddNewConferenceArtcView conArtcV;
	SeriContract seri_con;
	
	//making an instance of arraylist
	ArrayList<SeriContract> calConArrs = new ArrayList<SeriContract>();
	
	//instance of conference article model
	ListAllConferenceModel modCon = new ListAllConferenceModel();
	
	//method to write data in binary files
	public void conWrite() {
		
		File conDatFile = new File("binaryFiles/ContractFile.dat");
		if(conDatFile.exists()) {
			try {
				FileOutputStream conInpFile = new FileOutputStream(conDatFile);
				ObjectOutputStream objCon = new ObjectOutputStream(conInpFile);
				objCon.writeObject(calConArrs);
				objCon.close();
			
			
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "No such file");
		}
		
	}
	
	//method to add data in table
	public void conModAdd(AddNewConferenceArtcView conArtcV) {
		seri_con = new SeriContract(conArtcV.getjTConId().getText(),conArtcV.getjTConTitle().getText(),conArtcV.getjTConAuthor().getText(),conArtcV.getjTConPublishedYear().getText(),conArtcV.getjTConEditors().getText(),conArtcV.getjTConLocation().getText(),conArtcV.getjTConPageNo().getText());
		if(modCon.confValInArr()!=null) {
			calConArrs = modCon.confValInArr();
			calConArrs.add(seri_con);
			conWrite();
		}
		else {
			calConArrs.add(seri_con);
			conWrite();
		}
	
	}
	
	//WRITE IN BORROWED
	public void wrteBrrC() {
		File jurBrr = new File("binaryFiles/borrConference.dat");
		//check if the mentioned file exists or not
		if(jurBrr.exists()) {

			try {
				FileOutputStream outJour = new FileOutputStream(jurBrr);
				ObjectOutputStream objJour = new ObjectOutputStream(outJour);
				objJour.writeObject(calConArrs);
				objJour.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No such file");
		}
	}
	
	//RETURN CONFERENCE ARTICLE
	public void retuConf(BorrConfrDesign conBrr,int conRN) {
		seri_con = new SeriContract(conBrr.getjTConId().getText(),conBrr.getjTConTitle().getText(),conBrr.getjTConAuthor().getText(),conBrr.getjTConPublishedYear().getText(),conBrr.getjTConEditors().getText(),conBrr.getjTConLocation().getText(),conBrr.getjTConPageNo().getText());
		calConArrs = modCon.conBrr();
		calConArrs.remove(conRN);
		wrteBrrC();
		
		if(modCon.confValInArr()!=null) {
			calConArrs = modCon.confValInArr();
			calConArrs.add(seri_con);
			conWrite();
		}
		else {
			calConArrs.add(seri_con);
			conWrite();
		}
	}
	
	
	
	//ADD IN BORROWED
	public void CtBrrA(ListAllConferenceView cV) {
		seri_con = new SeriContract(cV.getjTConId().getText(),cV.getjTConTitle().getText(),cV.getjTConAuthor().getText(),cV.getjTConPublishedYear().getText(),cV.getjTConEditors().getText(),cV.getjTConLocation().getText(),cV.getjTConPageNo().getText());
		if(modCon.conBrr()!=null) {
			calConArrs = modCon.conBrr();
			calConArrs.add(seri_con);
			wrteBrrC();
		}
		else {
			calConArrs.add(seri_con);
			wrteBrrC();
		}
		
	}
	
	//method to modify the values stored in table
	public void changeConArtc(ListAllConferenceView vConfArt, int confCols) {
		calConArrs = modCon.confValInArr();
		seri_con = new SeriContract(vConfArt.getConfId(),vConfArt.getConfTitle(),vConfArt.getConfAuthor(),vConfArt.getConfYear(),vConfArt.getConfEditor(),vConfArt.getConfLoct(),vConfArt.getConfNoPage());
		calConArrs.set(confCols, seri_con);
		conWrite();
	
	}
	
	//method to remove the data or informations which is stored in table
	public void throwConArt(ListAllConferenceView vConfArt, int confCols) {
		int conSure = JOptionPane.showConfirmDialog(null, "Do you really want to delete it?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if(conSure == JOptionPane.YES_OPTION) {
			calConArrs = modCon.confValInArr();
			calConArrs.remove(confCols);
			conWrite();
			JOptionPane.showMessageDialog(null, "Data deleted successfully.");
		}
		if(conSure == JOptionPane.NO_OPTION) {
			calConArrs = modCon.confValInArr();
			JOptionPane.showMessageDialog(null, "No problem");
		}
	}
}
