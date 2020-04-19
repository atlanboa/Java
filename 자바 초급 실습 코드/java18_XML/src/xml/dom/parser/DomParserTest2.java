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
import org.w3c.dom.Node;
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
public class DomParserTest2 {


	public static void main(String[] args) throws Exception {

		//1.파서 얻어내고

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //싱글톤임
		DocumentBuilder parser = null; 


		parser  = dbf.newDocumentBuilder();
		System.out.println(parser.getClass().getName());

		//2.xml 문서를 파싱 ... document를 리턴받는다
		Document doc = parser.parse("addr.xml"); //리턴타입 도큐먼트로 리턴됨 아까 트리 맨 위에 있던 거 도큐먼트는 트리구조 자체 또는 트리구조 전체, 그니까 다 받아옴

		//3.루트를 얻어낸다
		Element root = doc.getDocumentElement(); //getDocumentElement()얘가 루트를 의미함
		System.out.println(root.getNodeName());
		
		//4.루트의 첫번째 자식을 얻어낸다
		getNode(root);

	}

	/**
	 * @param root
	 */
	private static void getNode(Element root) {
//		String firstChild = root.getFirstChild().getNodeName();
//		System.out.println(firstChild);
//		System.out.println(root.getFirstChild().getNodeType()); //#text라고 왜 인쇄됨??
//		이렇게 안함 정보 여러개인데 이렇게 되면 한개만 뽑힘 그래서 FOR문씀
		/*
		 * 노트타입에 대한 노드 값이 잇음
		 * 	Node Type                     Node Value
		 * 
		 * TEXT_NODE 공백도 텍스트 노드로 잡힘               3	
		 * 태그는 ELEMENT_NODE임 중요해서 1		1
			ATTRIBUTE_NODE					2
			DOCUMENT_NODE					9
			
		 */
																		//형제가 뒤에 더 있니? 있는 만큼 포문 돌음
		for(Node ch = root.getFirstChild(); ch!=null;/*있을때까지 계속 돌음*/ch = ch.getNextSibling()) {//정보여러개라서 for문 돌리는 거니까 수평구조임 이게 시블링임 형제
			if(ch.getNodeType() == Node.ELEMENT_NODE) { //1
				System.out.println(ch.getNodeName());
			}
		}
	}

}
