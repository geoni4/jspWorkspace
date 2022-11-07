package jwbook.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwbook.model.Member;

public class MemberService {
	Map<String, Member> members = new HashMap<String, Member>();
	
	public MemberService() {
		Member m = new Member("hong", "hong@naver.com");
		
		members.put("hong", m);
		
		members.put("kim", new Member("kim", "kim@naver.com"));
		members.put("wang", new Member("wang", "wang@naver.com"));
		members.put("zang", new Member("zang", "zang@naver.com"));
		members.put("lee", new Member("lee", "lee@google.com"));
		
	}
	
	
	public List<Member> findAll(){
		return new ArrayList<Member>(members.values());
	}
	
	public Member find(String id) {
		return members.get(id);
	}
	
}
