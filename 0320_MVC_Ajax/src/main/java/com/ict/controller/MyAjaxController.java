package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// 자바 1.8 이상
// 일반 컨트롤러 와 달리 ModelAndView를 반환하지 않음
// 단순문자열(String), json, xml이 반환

@RestController
public class MyAjaxController {
	// 단순 문자인 경우 문서의 타입인contentType="text/html"타입으로 알아서 처리
	// http://localhost:8090/text.do
	@RequestMapping("text.do")
	@ResponseBody
	public String Hello() {
		return "<h2>Hello World ICT CAMP</h2>";
	}

	@RequestMapping(value = "xmltest.do", produces = "text/xml; charset=utf-8")
	@ResponseBody
	public String XML_Test() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product>");
		sb.append("<name>딸기우유</name><price>1800</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>탄산음료</name><price>1500</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>아메리카노</name><price>2500</price>");
		sb.append("</product>");
		sb.append("<product>");
		sb.append("<name>작은 물</name><price>500</price>");
		sb.append("</product>");
		sb.append("</products>");
		return sb.toString();
	}

	@RequestMapping(value = "xmltest2.do", produces = "text/xml; charset=utf-8")
	@ResponseBody
	public String XML_Test2() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product name='바나나우유' price='1900' />");
		sb.append("<product name='음료수' price='1500' />");
		sb.append("<product name='카페모카' price='2500' />");
		sb.append("<product name='카페라떼' price='3000' />");
		sb.append("</products>");
		return sb.toString();
	}

	@RequestMapping(value = "xmltest3.do", produces = "text/xml; charset=utf-8")
	@ResponseBody
	public String XML_Test3() {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<products>");
		sb.append("<product price='1900'>이온음료</product>");
		sb.append("<product price='1500'>아이시스</product>");
		sb.append("<product price='2500'>헛개음료</product>");
		sb.append("<product price='600'>바카스</product>");
		sb.append("</products>");
		return sb.toString();
	}

	// 외부로 부터 xml 파일을 읽어서 파싱하기
	// DOM 방식
	@RequestMapping(value = "htmltest.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String HTML_Test() {
		StringBuffer sb = new StringBuffer();
		/*
		 * sb.append("<style type=\"text/css\">" + "table{width: 80%}" +
		 * "table, th, td { border: 1px solid red; text-align: center;}" + "</style>");
		 */
		sb.append("<table><thead><tr><th>지역</th>" + "<th>온도</th><th>상태</th><th>아이콘</th></thead><tbody>");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			InputStream is = url.openStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			Document document = builder.parse(bis);

			NodeList local = document.getElementsByTagName("local");
			for (int i = 0; i < local.getLength(); i++) {
				sb.append("<tr>");
				sb.append("<td>" + local.item(i).getFirstChild().getNodeValue() + "</td>");
				sb.append("<td>" + ((Element) (local.item(i))).getAttribute("ta") + "</td>");
				sb.append("<td>" + ((Element) (local.item(i))).getAttribute("desc") + "</td>");

				sb.append("<td> <img src='http://www.kma.go.kr/images/icon/NW/NB"
						+ ((Element) (local.item(i))).getAttribute("icon") + ".png'></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody></table>");
		} catch (Exception e) {
		}

		return sb.toString();
	}

	// 외부로 부터 xml 파일을 읽어서 파싱하기
	// Stream 방식
	@RequestMapping(value = "xmltest4.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String XML_Test4() {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				sb.append(msg);
			}
		} catch (Exception e) {
		}
		return sb.toString();
	}
	
	@RequestMapping(value = "jsontest1.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String JSON_Test1() {
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("[");
			sb.append("{\"name\":\"호두우유\", \"price\":\"1650\"},");
			sb.append("{\"name\":\"딸기우유\", \"price\":\"1600\"},");
			sb.append("{\"name\":\"메론우유\", \"price\":\"1750\"},");
			sb.append("{\"name\":\"바나나우유\", \"price\":\"1850\"}");
			sb.append("]");
		} catch (Exception e) {
		}
		return sb.toString();
	}
	
	@RequestMapping(value = "jsontest2.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String JSON_Test2() {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("http://openapi.seoul.go.kr:8088/sample/json/SeoulLibraryTime/1/5/");
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				sb.append(msg);
			}
		} catch (Exception e) {
		}
		return sb.toString();
	}
	// 공공포털사이트
	@RequestMapping(value = "jsontest3.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String JSON_Test3() {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=1");
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				sb.append(msg);
			}
		} catch (Exception e) {
		}
		return sb.toString();
	}
}
















