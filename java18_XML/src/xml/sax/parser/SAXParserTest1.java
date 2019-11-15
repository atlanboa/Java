/**
 * 
 */
package xml.sax.parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX PARSER
 * 문서들을 순차적으로 읽어서 처리하는 이벤트 드리븐 방식의 파서
 * 메모리를 아주 적게 사용하고 그렇기에 속도가 빠르다
 * 문서를 순차적으로 접근하지, 구조적으로 접근하지 않기 때문에
 * 문서를 변경하거나 조작할 때 사용하는 파서는 아니다.
 * 
 * 대용량의 XML문서를 읽어들이는데 가장 적합한 파서라고 볼 수 있음
 * 
 *
 */
public class SAXParserTest1 {

	public static void main(String[] args) {

		SAXParser parser = null;
		try {
			//1.파서 리턴받음
			SAXParserFactory ssf = SAXParserFactory.newInstance();
			parser = ssf.newSAXParser();
			
			//2.xml문서 파싱
			MySAXHandler handler = new MySAXHandler();
			parser.parse("addr.xml", handler);
		} catch (ParserConfigurationException e) {
			//System.out.println(e.getLocalizedMessage());
		} catch (SAXException e) {
			//System.out.println(e.getLocalizedMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

	}

}//class

class MySAXHandler extends DefaultHandler{
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException { //1
		System.out.println("xml document start...");
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException { //젤마지막
		System.out.println("xml document end...");
		
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		
		System.out.println("start element : " + name);
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		
		System.out.println("end element : " + name+"\n");
		

	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		System.out.println("character is : "+String.valueOf(ch, start, length));
	}
	
	//에러 핸들러도 같이 들어있음 에러를 처리한는 메소드도 같이들어잇음
	//*****************Error Handling*******************
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#warning(org.xml.sax.SAXParseException)
	 */
	@Override
	public void warning(SAXParseException e) throws SAXException {
		
		System.out.println("-----warning");
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#error(org.xml.sax.SAXParseException)
	 */
	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("-----error");
	}
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#fatalError(org.xml.sax.SAXParseException)
	 */
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		
		System.out.println("-----fatalError");
	}
}









