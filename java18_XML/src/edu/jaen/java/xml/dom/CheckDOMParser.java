
package edu.jaen.java.xml.dom;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CheckDOMParser {

	public List<Check> getContent(String url){
		List<Check> list = new ArrayList<>();
		
		//1.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = doc.getDocumentElement(); //Checklist 나옴
			NodeList items = root.getElementsByTagName("Check");
			
			for(int i=0; i<items.getLength(); i++) { //그럼 6번 돌음
				Check check = new Check();
				//items.item(i); //이거 하나하나가 체크임
				Node item = items.item(i);
				check.setCode(item.getAttributes().getNamedItem("code").getNodeValue());
				check.setDate(item.getAttributes().getNamedItem("date").getNodeValue());
				//여기까지가 check 레벨이었고 이제 자식으로 드가야지
				
				NodeList properties = item.getChildNodes(); //여기에 클린 레디 리스판스 리퀘스트 들어와서
				for(int j=0; j<properties.getLength(); j++) {
					Node property = properties.item(j);//여기 들어옴
					String name = property.getNodeName();
					
					if(name.equalsIgnoreCase("Clean")) {
						check.setClean(property.getFirstChild().getNodeValue());
						
					}else if(name.equalsIgnoreCase("Ready")) {
						check.setReady(property.getFirstChild().getNodeValue());
						
					}else if(name.equalsIgnoreCase("Response")) {
						check.setResponse(property.getFirstChild().getNodeValue());
						
					}else if(name.equalsIgnoreCase("Request")) {
						if(property.getFirstChild()!=null)
						check.setRequest(property.getFirstChild().getNodeValue());
					}//else if
				}//for
				list.add(check);
			}
			
			
			
			
		}catch(Exception e) {
			//언제 캐치로 떨어지냐? 코드를 잘못작성하면 떨어짐
			throw new RuntimeException(e);
			//이러면 에러가 더 잘 떨어진대.. 그게 뭔말?
		}
		
		
		
		
		
		
		
		return list;
	}
}//class
