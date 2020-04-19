/**
 * 
 */
package xml.dom.parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * xml 파서
 * 일단 읽어와서(읽어오는 기능) 분류해야함(태그를) 태그를 우리 맘대로 해석해서 속성값을 분리시켜주는게 파서
 * 
 * xml 문서를 읽고 해석해서 
 * 해석) 태그명, 속성이름, 태그안에 값들을 분류해서 우리가 프로그램으로 다를 수 있게 해주는 게 파서
 * 
 * DOM 파서 | SAX 파서
 * 트리구조로 계층방식으로 올림 계층구조라 데이터 수정이나 삽입이 용이
 *
 */
public class DomParserTest1 {

	
	public static void main(String[] args) {

		//1.파서를 얻는 과정 도큐먼트 빌더팩도리로 부터 도큐먼트 빌더를 얻음
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //싱글톤임
		DocumentBuilder parser = null; 
		
		try {
			parser  = dbf.newDocumentBuilder();
			System.out.println(parser.getClass().getName());
			
		//2.xml 문서를 파싱 -> 하고나서 분류를 해야지 .... document를 리턴받는다
			Document doc = parser.parse("addr.xml"); //리턴타입 도큐먼트로 리턴됨 아까 트리 맨 위에 있던 거 도큐먼트는 트리구조 자체 또는 트리구조 전체, 그니까 다 받아옴
			
		//3.도큐먼트 밑에 뭐있디? 루트 있었음 루트를 얻어낸다
			Element root = doc.getDocumentElement(); //getDocumentElement()얘가 루트를 의미함
			System.out.println(root.getNodeName());
			System.out.println(root.getTagName());
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
