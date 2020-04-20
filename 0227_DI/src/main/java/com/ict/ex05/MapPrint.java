package com.ict.ex05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapPrint {
	Map<String, String> map1 = new HashMap<String, String>();
	Map<Integer, String> map2 = new HashMap<Integer, String>();
	
	public void input() {
	   map1.put("id", "aaaa");
	   map1.put("pw", "1111");
	   map1.put("name", "마이콜");
	   map1.put("age", "26");
	   map1.put("addr", "제주도");
	   
	   map2.put(1, "gggg");
	   map2.put(2, "5555");
	   map2.put(3, "희동이");
	   map2.put(4, "3");
	   map2.put(5, "강원도");
	}
	
	
	public Map<String, String> getMap1() {
		return map1;
	}


	public void setMap1(Map<String, String> map1) {
		this.map1 = map1;
	}


	public Map<Integer, String> getMap2() {
		return map2;
	}


	public void setMap2(Map<Integer, String> map2) {
		this.map2 = map2;
	}


	public void s_prn() {
		Iterator<String> it = map1.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(map1.get(key));
		}
	}
	public void i_prn() {
		Iterator<Integer> it = map2.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			System.out.println(map2.get(key));
		}
	}
}









