//
// class Book
// 24th March 2017 
// Created by Jaehyung Park
//


public class Book {
// make the Book class
	private String title;
	private String[] authors;
	private int page;
	private int pubYear;

	//make constructor
	public Book(String title, String[] authors, int page, int year) {
		this.title = title;      //initializing  
		this.authors = authors;  //initializing 
		this.page = page;        //initializing 
		this.pubYear = year;     //initializing 
	}
//get the title
	public String getTitle() {
		return title;
	}
//set the title
	public void setTitle(String title) {
		this.title = title;
	}
//get the authors
	public String[] getAuthors() {
		return authors;
	}
//set the authors
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
//get the page
	public int getPage() {
		return page;
	}
//set the page
	public void setPage(int page) {
		this.page = page;
	}
//get published year
	public int getPubYear() {
		return pubYear;
	}
//set published year
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
// return title and authors
	public String toString() {
		StringBuffer a = new StringBuffer();
		a.append(title + " " + "- ");
		for(int i = 0;i<authors.length;i++)
		{
			a.append(authors[i] + ", ");
		}
		return a.toString();
	}
}
