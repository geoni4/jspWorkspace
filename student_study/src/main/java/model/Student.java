package model;

public class Student {
	private int seq;
	private String name;
	private String school;
	private String birth;
	private String email;
	
	
	public Student(int seq, String name, String school, String birth, String email) {
		this.seq = seq;
		this.name = name;
		this.school = school;
		this.birth = birth;
		this.email = email;
	}
	public Student() {
	}
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [seq=" + seq + ", name=" + name + ", school=" + school + ", birth=" + birth + ", email=" + email
				+ "]";
	}
	
	
	
}
