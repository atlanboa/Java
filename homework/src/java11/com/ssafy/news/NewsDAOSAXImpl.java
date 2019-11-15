package java11.com.ssafy.news;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {

	//List<News> list;만 하면 껍데기고 뭐고 아무것도 없음
	//근데 그걸 밑에서 clear하라고 하니까 오류나지
	List<News> list = new ArrayList<>();
	
	@Override
	public List<News> getNewsList(String url) {
		list.clear();
		connectXML(url);
		return list;
	}

	private void connectXML(String url) {
		SAXParser parser = null;
		//1.파서 리턴
		SAXParserFactory ssf = SAXParserFactory.newInstance();
		try {
			parser = ssf.newSAXParser();
			
		//2.파싱할때 url 넣어주고 handler 객체 넣어주고
			MySAXHandler mh = new MySAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), mh);
			
			
		}catch(Exception e){
			
		}
		
		
		
	}

	@Override
	public News search(int index) {
		return list.get(index);
	}



	class MySAXHandler extends DefaultHandler{
		private News news;
		private StringBuffer sb;
		
		
		//시작할 때 만들면 좋은거? 리스트!!
		@Override
		public void startDocument() throws SAXException {
			list = new ArrayList<>();
			sb = new StringBuffer(); //연결되서 계속 붙여나가는놈
		}
		
		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes)
				throws SAXException {
			if(name.equalsIgnoreCase("item")) {
				news = new News();
				sb.setLength(0);
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(ch, start, length);
		}
		
		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			//?
			if(news != null) {
			if(name.equalsIgnoreCase("title")) {
				news.setTitle(sb.toString().trim());
			}else if(name.equalsIgnoreCase("description")) {
				news.setDesc(sb.toString().trim());
			}else if(name.equalsIgnoreCase("link")) {
				news.setLink(sb.toString().trim());
			}else if(name.equalsIgnoreCase("item")) {
				list.add(news);
			}
			//만약 타이틀 태그에 걸렸다면 하나 넣고나서 다시 초기화
			sb.setLength(0);
		}}
	}
	
}
