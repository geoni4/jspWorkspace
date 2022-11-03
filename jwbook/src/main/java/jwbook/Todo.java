package jwbook;

import java.util.Date;



public class Todo {
	private int tno;
	private String title;
	private String todoContent;
	private Date dueDate;
	private Date endDate;
	
	//Generator
	public Todo() {}
	
	public Todo(int tno, String title, String todoContent, Date dueDate, Date endDate) {
		super();
		this.tno = tno;
		this.title = title;
		this.todoContent = todoContent;
		this.dueDate = dueDate;
		this.endDate = endDate;
	}
	
	//Getter, Setter
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTodoContent() {
		return todoContent;
	}
	public void setTodoContent(String todoContent) {
		this.todoContent = todoContent;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Todo [tno=" + tno + ", title=" + title + ", todoContent=" + todoContent + ", dueDate=" + dueDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
}
