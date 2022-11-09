package jwbook.service;

import java.util.ArrayList;
import java.util.List;

import jwbook.model.Product;
import jwbook.model.ProductDAO;
import mybatis.MyBatisConnectionFactory;

public class ProductServiceMybatis {
	//DAO 생성 시 MyBatisConnectionFactory로부터 sqlSession얻기
	ProductDAO productDAO = new ProductDAO(MyBatisConnectionFactory.getSqlSessionFactory());
	Product product = new Product();

	public List<Product> findAll(){
		List<Product> list = new ArrayList<>(productDAO.selectAll());
		return list;
	}

	public Product find(String id) {
		return productDAO.selectById(id);
	}

	public void insert(Product product) {
		productDAO.insert(product);
	}

	public void update(Product product) {
		productDAO.update(product);
	}

	public void delete(String id) {
		productDAO.delete(id);
	}
}
