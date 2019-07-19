package Model;

import java.io.Serializable;

public class SeriContract implements Serializable{

	String conId, conTitle, conAuthor, conPubYear, conEditor, conLoct, conPageNo;
	
	public SeriContract(String conId, String conTitle, String conAuthor, String conPubYear, String conEditor, String conLoct,
			String conPageNo) {
		this.conId = conId;
		this.conTitle = conTitle;
		this.conAuthor = conAuthor;
		this.conPubYear = conPubYear;
		this.conEditor = conEditor;
		this.conLoct = conLoct;
		this.conPageNo = conPageNo;
		
	}

	//default constructor
	public SeriContract() {

	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
	}

	public String getConAuthor() {
		return conAuthor;
	}

	public void setConAuthor(String conAuthor) {
		this.conAuthor = conAuthor;
	}

	public String getConPubYear() {
		return conPubYear;
	}

	public void setConPubYear(String conPubYear) {
		this.conPubYear = conPubYear;
	}

	public String getConEditor() {
		return conEditor;
	}

	public void setConEditor(String conEditor) {
		this.conEditor = conEditor;
	}

	public String getConLoct() {
		return conLoct;
	}

	public void setConLoct(String conLoct) {
		this.conLoct = conLoct;
	}

	public String getConPageNo() {
		return conPageNo;
	}

	public void setConPageNo(String conPageNo) {
		this.conPageNo = conPageNo;
	}

}
