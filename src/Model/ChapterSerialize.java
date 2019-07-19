package Model;

import java.io.Serializable;

public class ChapterSerialize implements Serializable {

	private static final long serialVersionUID = 1L;
	String chapBookId, chapBookTitle, chapBookAuthor, chapBookPubYear, chapBookEditor, chapBookPlace, chapBookPublisher, chapBookPageNo;

	public ChapterSerialize(String chapBookId,String chapBookTitle,String chapBookAuthor,String chapBookPubYear,String chapBookEditor,String chapBookPlace,String chapBookPublisher,String chapBookPageNo) {
		this.chapBookId = chapBookId;
		this.chapBookTitle = chapBookTitle;
		this.chapBookAuthor = chapBookAuthor;
		this.chapBookPubYear = chapBookPubYear;
		this.chapBookEditor = chapBookEditor;
		this.chapBookPlace = chapBookPlace;
		this.chapBookPublisher = chapBookPublisher;
		this.chapBookPageNo = chapBookPageNo;
	}
	

	public ChapterSerialize() {

	}

	public String getChapBookId() {
		return chapBookId;
	}

	public void setChapBookId(String chapBookId) {
		this.chapBookId = chapBookId;
	}

	public String getChapBookTitle() {
		return chapBookTitle;
	}

	public void setChapBookTitle(String chapBookTitle) {
		this.chapBookTitle = chapBookTitle;
	}

	public String getChapBookAuthor() {
		return chapBookAuthor;
	}

	public void setChapBookAuthor(String chapBookAuthor) {
		this.chapBookAuthor = chapBookAuthor;
	}

	public String getChapBookPubYear() {
		return chapBookPubYear;
	}

	public void setChapBookPubYear(String chapBookPubYear) {
		this.chapBookPubYear = chapBookPubYear;
	}

	public String getChapBookEditor() {
		return chapBookEditor;
	}

	public void setChapBookEditor(String chapBookEditor) {
		this.chapBookEditor = chapBookEditor;
	}

	public String getChapBookPlace() {
		return chapBookPlace;
	}

	public void setChapBookPlace(String chapBookPlace) {
		this.chapBookPlace = chapBookPlace;
	}

	public String getChapBookPublisher() {
		return chapBookPublisher;
	}

	public void setChapBookPublisher(String chapBookPublisher) {
		this.chapBookPublisher = chapBookPublisher;
	}

	public String getChapBookPageNo() {
		return chapBookPageNo;
	}

	public void setChapBookPageNo(String chapBookPageNo) {
		this.chapBookPageNo = chapBookPageNo;
	}
}
