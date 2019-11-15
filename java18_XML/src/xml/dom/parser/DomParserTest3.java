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
public class DomParserTest3 {


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
		//element_node 알라는데 모르겠음
		//돔방식은 계층구조 그래서 트리구조인게 핵심 대신에 옆에 수평형제도 있으니 넥스트 시블링으로 옆도 훑어야함

	}

	/**
	 * @param root
	 */
//	private static void getNode(Element root) {
//
//	}
	private static void getNode(Node root) { //인자값을 node로 입력해야 다 받아올수 있음 이게 폴리몰피즘이자ㅏ나
		for(Node ch = root.getFirstChild(); ch!=null;/*있을때까지 계속 돌음*/ch = ch.getNextSibling()) {
			//요소를 먼저 처리한다 
			if(ch.getNodeType() == 1) { //밸류값아니까 1로함
				System.out.println(ch.getNodeName());
				getNode(ch);//재귀호출해야함 한번더 해야 계층이 정보에서 정보의 자식으로 내려가지...
			}else if(ch.getNodeType()==3 && ch.getNodeValue().trim().length()!=0) {
				//공백도 3이자나 난 공백사이 데이터만 받고싶은데...ㅜㅜ
				System.out.println(ch.getNodeValue());//근데 지금 정보만 볼 수 있음 한번 더 내려가야지...
			}
		}
	}

}
