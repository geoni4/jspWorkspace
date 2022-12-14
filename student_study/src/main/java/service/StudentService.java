package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Student;
import model.StudentDAO;


//객체 가져와서 제공하는 부분
public class StudentService {
	StudentDAO dao = new StudentDAO();
	
	/*
	 * public StudentService(){ map.put(1, new Student(1, "김길동", "AA대학교",
	 * "1999-10-21", "kim@aa.com")); map.put(2, new Student(2, "박사랑", "BB대학교",
	 * "2000-01-21", "park@bb.com")); map.put(3, new Student(3, "나최고", "CC대학교",
	 * "1998-07-11", "na@cc.com")); map.put(4, new Student(4, "김길동", "BB대학교",
	 * "1999-03-10", "kim@bb.com")); map.put(5, new Student(5, "홍길동", "AA 대학교",
	 * "1999-12-10", "hong@aa.com")); }
	 */
	
	
	public List<Student> findAll(){
		return dao.getAll();
	}
	
	public Student find(int id) {
		return dao.getInfo(id);
	}
	
	public void insertStudent(Student s) {
		dao.insert(s);
	}
	
}
