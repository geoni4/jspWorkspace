package ch12.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch12.model.News;
import ch12.model.NewsDAO;

@Path("/news")
public class NewsApiService {
	NewsDAO dao;
	
	public NewsApiService() {
		dao=new NewsDAO();
	}
	
	//뉴스목록
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<News> getNewsList(){
		List<News> newsList = null;
		try {
			newsList = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return newsList;
	}
	
	@GET
	@Path("{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public News getNews(@PathParam("aid") int aid) {
		News news = null;
		try {
			news = dao.getNews(aid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return news;
	}
	
	
	//뉴스 등록
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNews(News news) {
		
		try {
			dao.addNews(news);
		} catch(Exception e) {
			e.printStackTrace();
			return "News API: 뉴스 등록 실패";
		}
		return "News API: 뉴스 등록 성공";
	}
	
	//뉴스 삭제
	@DELETE
	@Path("{aid}")
	public String delNews(@PathParam("aid") int aid) {
		try {
			dao.delNews(aid);
		}catch (Exception e) {
			e.printStackTrace();
			return "News API: 뉴스 삭제 실패 - " + aid;
		}
		return "News API: 뉴스 삭제 성공";
	}
	
}
