package jwbook.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProductDAO {
	//sqlsession 얻기
	//1.SqlSessionFactory 객체 선언
	private SqlSessionFactory sqlSessionFactory = null;

	//2. 생성 시 sqlSessionFactory를 초기화
	public ProductDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<Product> selectAll(){
		
		List<Product> list = null;
		//3. getConnection처럼 연결객체 얻기
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("product.selectAll");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();			
		}
		return list;
	}

	public Product selectById(String id) {
		Product product = null;
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		product = session.selectOne("product.selectById",id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return product;
	}

	public void insert(Product product) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("product.insert", product);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
	}

	public void update(Product product) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("product.update", product);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
		
	}

	public void delete(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("product.delete", id);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		
	}
	
	
	
}
