package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import View.AddNewBookChapView;
import View.BrrBookDesign;
import View.ListAllBookChapterView;

public class AddBookChapModel{

	//creating the ew instance of arraylist
	ArrayList<ChapterSerialize> arrAllValBook = new ArrayList<ChapterSerialize>();
	AddNewBookChapView designBook;
	ChapterSerialize serBook;
	
	//creating new instance of listing book model
	ListAllBookModel allBooksMod = new ListAllBookModel();

	//method to write the information if book chapter's article in file
	public void bookInDat() {
		
		//creating new instance of file
		File writeBook = new File("binaryFiles/BookChapter.dat");
		if(writeBook.exists()) {
			
			try {
				FileOutputStream outBook = new FileOutputStream(writeBook);
				ObjectOutputStream objBook = new ObjectOutputStream(outBook);
			
				objBook.writeObject(arrAllValBook);
				objBook.close();
						
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "There is no such file");
		}
		
	}
	
	//he method to add new information of book chapter to the table
	public void chapBookAdd(AddNewBookChapView vBook) {
		serBook = new ChapterSerialize(vBook.getjTBookId().getText(),vBook.getjTBookTitle().getText(),vBook.getjTBookAuthor().getText(),vBook.getjTBookPublished().getText(),vBook.getjTBookEditor().getText(),vBook.getjTBookPlace().getText(),vBook.getjTBookPublisher().getText(),vBook.getjTBookPageNo().getText());
		if(allBooksMod.readBookArr()!=null) {
			arrAllValBook = allBooksMod.readBookArr();
			arrAllValBook.add(serBook);
			//calling method to store file
			bookInDat();
		}
		else {
			arrAllValBook.add(serBook);
			bookInDat();
		}
	}
	//RETURN BOOK TO LIBRARY
	public void brrBokRtn(BrrBookDesign borrowB, int brrRow) {
		serBook = new ChapterSerialize(borrowB.getjTBookId().getText(),borrowB.getjTBookTitle().getText(),borrowB.getjTBookAuthor().getText(),borrowB.getjTBookPublished().getText(),borrowB.getjTBookEditor().getText(),borrowB.getjTBookPlace().getText(),borrowB.getjTBookPublisher().getText(),borrowB.getjTBookPageNo().getText());
		arrAllValBook = allBooksMod.chpBrr();
		arrAllValBook.remove(brrRow);
		BkBrrWr();
				
		if(allBooksMod.readBookArr()!=null) {
			arrAllValBook = allBooksMod.readBookArr();
			arrAllValBook.add(serBook);
			bookInDat();
		}
		else {
			arrAllValBook.add(serBook);
			bookInDat();
		}
		
	}
	
	//WRITE FOR BORROW BOOK CHAPTERS
	public void BkBrrWr() {
		File BookBrr = new File("binaryFiles/borrBook.dat");
		//check if the mentioned file exists or not
		if(BookBrr.exists()) {

			try {
				FileOutputStream otBBr = new FileOutputStream(BookBrr);
				ObjectOutputStream ojcBok = new ObjectOutputStream(otBBr);
				ojcBok.writeObject(arrAllValBook);
				ojcBok.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No such file");
		}
	}
	
	//ADD IN BORROWED BOOK TABLE
	public void BkBrrAdd(ListAllBookChapterView bcV) {
		serBook = new ChapterSerialize(bcV.getjTBookId().getText(),bcV.getjTBookTitle().getText(),bcV.getjTBookAuthor().getText(),bcV.getjTBookPublished().getText(),bcV.getjTBookEditor().getText(),bcV.getjTBookPlace().getText(),bcV.getjTBookPublisher().getText(),bcV.getjTBookPageNo().getText());
		if(allBooksMod.chpBrr()!=null) {
			arrAllValBook = allBooksMod.chpBrr();
			arrAllValBook.add(serBook);
			BkBrrWr();
		}
		else {
			arrAllValBook.add(serBook);
			BkBrrWr();
		}
	}

	//creating method to modify the information of book chapter
	public void chapChange(ListAllBookChapterView bChapV, int chapNum) {
		arrAllValBook = allBooksMod.readBookArr();
		serBook = new ChapterSerialize(bChapV.getCBokId(),bChapV.getCBokTitl(),bChapV.getCBokAuthr(),bChapV.getCBokPubYar(),bChapV.getCBokEdtr(),bChapV.getCBokplce(),bChapV.getCBokPublsher(),bChapV.getCBokPgeNo());
		arrAllValBook.set(chapNum, serBook);
		bookInDat();
	}

	//making method to delete the information of book chapter
	public void chapBokDlt(ListAllBookChapterView bChapV, int chapNum) {
		int chapReady = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		//delete the data if presses yes option
		if(chapReady == JOptionPane.YES_OPTION) {
			arrAllValBook = allBooksMod.readBookArr();
			arrAllValBook.remove(chapNum);  
			bookInDat();
			JOptionPane.showMessageDialog(null, "Selected row gpt deleted successfully.");
		}
		//don't delete the row if presses no option
		if(chapReady == JOptionPane.NO_OPTION) {
			arrAllValBook = allBooksMod.readBookArr();
			JOptionPane.showMessageDialog(null, "Then, it's ok.");
		}
	}
}
