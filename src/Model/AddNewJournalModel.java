package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import View.AddNewJournalView;
import View.BorrJrnlDesign;
import View.ListAllJournalView;

public class AddNewJournalModel {
	//declaring arraylist
	ArrayList<JournalSerialize> infoJourArr = new ArrayList<JournalSerialize>();
	
	//creating fields of different other classes
	ListAllJournalView lJV;
	AddNewJournalView jourV;
	JournalSerialize seriJour;
	ListAllJournalModel listJourM = new ListAllJournalModel();
	
	//for validating date
	public static boolean valJouDate(String dIn) {
		
		SimpleDateFormat dfor = new SimpleDateFormat("Yyyy-MM-dd");
		dfor.setLenient(false);
		try {
			
			dfor.parse(dIn.trim());
			
		} catch (java.text.ParseException e) {
			
			return false;
		}
		return true;
	
	}
	
	//method to write data in binary files
	public void writeInJourDat() {
		File jurDat = new File("binaryFiles/Journal.dat");
		//check if the mentioned file exists or not
		if(jurDat.exists()) {

			try {
				FileOutputStream outJour = new FileOutputStream(jurDat);
				ObjectOutputStream objJour = new ObjectOutputStream(outJour);
				objJour.writeObject(infoJourArr);
				objJour.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No such file");
		}
	}
	
	//METHOD TO WRITE IN BORROWED FILES
	public void wrteInBrrJour() {
		File jurBrr = new File("binaryFiles/borrJournal.dat");
		//check if the mentioned file exists or not
		if(jurBrr.exists()) {

			try {
				FileOutputStream outJour = new FileOutputStream(jurBrr);
				ObjectOutputStream objJour = new ObjectOutputStream(outJour);
				objJour.writeObject(infoJourArr);
				objJour.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No such file");
		}
	}

	
	//method to add new values to the table
	public void modJourAdd(AddNewJournalView jourV) {
		//get all fields
		seriJour = new JournalSerialize(jourV.getjTJourId().getText(),jourV.getjTJourArticle().getText(),jourV.getjTJourAuthor().getText(),jourV.getjTJourTitle().getText(),jourV.getjTJourPubYear().getText(),jourV.getjTJourVolumeNo().getText(),jourV.getjTJourIssueNo().getText(),jourV.getjTPageNo().getText());
		if(listJourM.arrJourAllInfo()!=null) {
			infoJourArr = listJourM.arrJourAllInfo();
			infoJourArr.add(seriJour);
			writeInJourDat();
		}
		else {
			infoJourArr.add(seriJour);
			writeInJourDat();
		}
	}

	//RETURN journal article
	public void rtnBrrJrnl(BorrJrnlDesign bjd, int numRow) {
		seriJour = new JournalSerialize(bjd.getjTJourId().getText(),bjd.getjTJourArticle().getText(),bjd.getjTJourAuthor().getText(),bjd.getjTJourTitle().getText(),bjd.getjTJourPubYear().getText(),bjd.getjTJourVolumeNo().getText(),bjd.getjTJourIssueNo().getText(),bjd.getjTPageNo().getText());
		infoJourArr = listJourM.arrJourBrr();
		infoJourArr.remove(numRow);
		wrteInBrrJour();
		
		if(listJourM.arrJourAllInfo()!=null) {
			infoJourArr = listJourM.arrJourAllInfo();
			infoJourArr.add(seriJour);
			writeInJourDat();
		}
		else {
			infoJourArr.add(seriJour);
			writeInJourDat();
		}
	
	}
	
	//ADD BORROWED JOURNAL FILES
	public void brrAdd(ListAllJournalView lv) {
		seriJour = new JournalSerialize(lv.getjTJourId().getText(),lv.getjTJourArticle().getText(),lv.getjTJourAuthor().getText(),lv.getjTJourTitle().getText(),lv.getjTJourPubYear().getText(),lv.getjTJourVolumeNo().getText(),lv.getjTJourIssueNo().getText(),lv.getjTPageNo().getText());
		if(listJourM.arrJourBrr()!=null) {
			infoJourArr = listJourM.arrJourBrr();
			infoJourArr.add(seriJour);
			wrteInBrrJour();
		}
		else {
			infoJourArr.add(seriJour);
			wrteInBrrJour();
		}
		
	
	}
	
	
	//method to edit stored values
	public void jrnalEdit(ListAllJournalView jrnlView, int num) {
		infoJourArr = listJourM.arrJourAllInfo();
		seriJour = new JournalSerialize(jrnlView.getJourId(),jrnlView.getJourArtTitle(),jrnlView.getJourAuthor(),jrnlView.getJourTitle(),jrnlView.getJourYear(),jrnlView.getJourVolume(),jrnlView.getJourIssue(),jrnlView.getJourPage());
		infoJourArr.set(num, seriJour);
		writeInJourDat();
	}
	
	//method to delete the values from table
	
	public void jrnlDelt(ListAllJournalView jrnlView, int num) {
		int sure = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	//delete if yes button is clicked
		if(sure == JOptionPane.YES_OPTION) {
			infoJourArr = listJourM.arrJourAllInfo();
			infoJourArr.remove(num);  
			writeInJourDat();
			JOptionPane.showMessageDialog(null, "Selected row got deleted successfully.");
		}
		//don't delete the data if no button is clicked
		if(sure == JOptionPane.NO_OPTION) {
			infoJourArr = listJourM.arrJourAllInfo();
			JOptionPane.showMessageDialog(null, "Then, it's ok.");
		}
	
	}	
}
