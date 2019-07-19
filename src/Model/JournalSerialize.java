package Model;

import java.io.Serializable;

public class JournalSerialize implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String jourId, jourTitleArticle, jourAuthor,jourTitle, jourPublished, jourVolume, jourIssue, jourPage;

	//contructor
	public JournalSerialize(String jourId, String jourTitleArticle,String jourAuthor,String jourTitle,String jourPublished,String jourVolume,String jourIssue,String jourPage) {
		this.jourId = jourId;
		this.jourTitleArticle = jourTitleArticle;
		this.jourAuthor = jourAuthor;
		this.jourTitle = jourTitle;
		this.jourPublished = jourPublished;
		this.jourVolume = jourVolume;
		this.jourIssue = jourIssue;
		this.jourPage = jourPage;
	}

	//default empty constructor
	public JournalSerialize() {
		
	}

	//relevant getters and setters
	public String getJourId() {
		return jourId;
	}

	public void setJourId(String jourId) {
		this.jourId = jourId;
	}

	public String getJourTitleArticle() {
		return jourTitleArticle;
	}

	public void setJourTitleArticle(String jourTitleArticle) {
		this.jourTitleArticle = jourTitleArticle;
	}

	public String getJourAuthor() {
		return jourAuthor;
	}

	public void setJourAuthor(String jourAuthor) {
		this.jourAuthor = jourAuthor;
	}

	public String getJourTitle() {
		return jourTitle;
	}

	public void setJourTitle(String jourTitle) {
		this.jourTitle = jourTitle;
	}

	public String getJourPublished() {
		return jourPublished;
	}

	public void setJourPublished(String jourPublished) {
		this.jourPublished = jourPublished;
	}

	public String getJourVolume() {
		return jourVolume;
	}

	public void setJourVolume(String jourVolume) {
		this.jourVolume = jourVolume;
	}

	public String getJourIssue() {
		return jourIssue;
	}

	public void setJourIssue(String jourIssue) {
		this.jourIssue = jourIssue;
	}

	public String getJourPage() {
		return jourPage;
	}

	public void setJourPage(String jourPage) {
		this.jourPage = jourPage;
	}
}
