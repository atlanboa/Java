/**
 * 
 */
package com.ssafy.weather;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author student
 *
 */
public class WeatherDAO {

	List<Weather> list = new ArrayList<>();
	
	//싱글톤
	private static WeatherDAO wd = new WeatherDAO();
	private WeatherDAO() {}

	public static WeatherDAO getInstance() {
		return wd;
	}
	
	public List<Weather> getNewsList(String url){
		//리스트에 뿌릴꺼임 값을 줄꺼임
		//기존의 리스트는 다 지워야함
		list.clear();

		connectXML(url); //GUI리스트에 출력하도록 만들어놨음

		return list;
	}
	
	private void connectXML(String url){
		
		SAXParser parser = null;
		//1.파서 리턴
		SAXParserFactory ssf = SAXParserFactory.newInstance();
		try {
			parser = ssf.newSAXParser();
			
			//2.파싱할때 url 넣어주고 handler 객체 넣어주고
			MySAXHandler handler = new MySAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private List<Weather> getWeatherList(){
		return list;
	}
	
	class MySAXHandler extends DefaultHandler{
		private Weather weather;
		private StringBuffer sb;
		
		@Override
		public void startDocument() throws SAXException {
			
			list = new ArrayList<>();
			sb = new StringBuffer();
		}

		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes)
				throws SAXException {
			if(name.equalsIgnoreCase("data")) {
				weather = new Weather();
			}
		}
		
	
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(ch, start, length);
		}
		

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			if(name.equalsIgnoreCase("hour")) {
				weather.setHour(sb.toString().trim());
			}else if(name.equalsIgnoreCase("temp")) {
				weather.setTemp(sb.toString().trim());
			}else if(name.equalsIgnoreCase("wfKor")) {
				weather.setWfKor(sb.toString().trim());
			}else if(name.equalsIgnoreCase("reh")) {
				weather.setReh(sb.toString().trim());
			}else if(name.equalsIgnoreCase("data")) {
				list.add(weather);
			}
			//버퍼초기화
			sb.setLength(0);
		}
		
	}
}//class 


