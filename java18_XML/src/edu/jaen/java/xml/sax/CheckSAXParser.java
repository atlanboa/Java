
package edu.jaen.java.xml.sax;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CheckSAXParser {

	List<Check> list;
	
	public List<Check> getContent(String url){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			
			MyHandler handler = new MyHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

		return list;
	}
	
	//class 닫기전에 만들면 필드처럼? 쓸수있대
	//마치 필드처럼 위에 선언한 list를 쓸 수 있음
	class MyHandler extends DefaultHandler{
		private Check check;
		private StringBuffer sb;
		
		
		@Override
		public void startDocument() throws SAXException {//얘는 단 한번만 호출됨 여기다 check클래스 넣으면 안됨
			//시작과 동시에 만들면 좋은거? 리스트 오케이
			list = new ArrayList<Check>();
			sb = new StringBuffer(); //연결되서 붙어나감
			
		}
		
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes)
				throws SAXException {
			
			//여기서 만들어야되는거 뭐게? check xml에 있는거
			if(name.equalsIgnoreCase("Check")) { //대소문자 무시하면서 check만 나오면 됨
				check = new Check();
				check.setCode(attributes.getValue(0));
				check.setDate(attributes.getValue(1));
				
			}
		}
		
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
		 */
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(ch, start, length);
			
		}
	
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			if(name.equalsIgnoreCase("Clean")) {
				check.setClean(sb.toString().trim());
			}else if(name.equalsIgnoreCase("Ready")) {
				check.setReady(sb.toString().trim());
			}else if(name.equalsIgnoreCase("Response")) {
				check.setResponse(sb.toString().trim());
			}else if(name.equalsIgnoreCase("Request")) {
				sb.trimToSize();//데이터 양사이드의 공백을 제거한 다음에 사이즈를 재는거
				if(sb.length()>0) check.setRequest(sb.toString().trim());
			}else if(name.equalsIgnoreCase("Check")) { //</Check>끝나는 부분이있자낭 여기서 리스트에 넣어주면 됨
				list.add(check);
			}
			
			//스트링버퍼를 초기화해줘야함
			sb.setLength(0); //버퍼초기화
			
			
			
		}
		
	}
	
	
}//class
