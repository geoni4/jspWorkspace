package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	Connection conn = null;
	
	PreparedStatement pstmt = null;
	
	final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(JDBC_URL, "java", "oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getAll(){
		open();
		List<Student> students = new ArrayList<>();
		try {
			String sql = "SELECT * FROM student";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
			
			
		}  catch( Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return students;
	}
	public Student getInfo(int id){
		open();
		Student s = null;
		try {
			String sql = "SELECT * FROM student";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
			}
		} catch( Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return s;
	}

	public Object insert(Student s) {
		open();
		try {
			String sql = "INSERT INTO student"
						+" VALUES(student_seq.nextval, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			int rows = pstmt.executeUpdate();
			
			
		} catch( Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return s;
	}
	
}
