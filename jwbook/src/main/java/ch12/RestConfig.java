package ch12;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// ch12 package 안의 경로는 모두 /api로 온다.
@ApplicationPath("/api")
public class RestConfig extends Application {
	
	public Map<String, Object> getProperties(){
		Map<String, Object> properties = new HashMap<>();
		properties.put("jersey.config.server.provider.packages",
						"ch12");
		
		return properties;
	}
}
