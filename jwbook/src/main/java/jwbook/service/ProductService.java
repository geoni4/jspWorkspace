package jwbook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwbook.model.Product;

public class ProductService {
	Map<String, Product> products = new HashMap<String, Product>();
	
	public ProductService() {
		Product p = new Product("101", "애플 사과폰 12", "애플전자", 1200000, "2020.12.12");
		products.put("101", p);
		p = new Product("102", "삼전우주폰 12", "삼전전자", 1300000, "2021.2.2");
		products.put("102", p);
		
		p = new Product("103", "엘스듀얼폰", "엘스전자", 1500000, "2020.3.2");
		products.put("103", p);
		
	}
	
	//상품 리스트 출력
	public List<Product> findAll(){
		return new ArrayList<Product>(products.values());
	}
	
	//id에 해당하는 상품 객체 출력
	public Product find(String id) {
		return products.get(id);
	}
	
}
