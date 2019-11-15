import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BookMgrImpl implements IBookMgr {
	private static BookMgrImpl bm = new BookMgrImpl();
	private ArrayList<Book> list = new ArrayList<>(20);;
	private int booksCount = 0;
	private BookMgrImpl(){
		open();
		}
	public static BookMgrImpl getInstance() {return bm;}
	
	
	//서버로 도서정보를 전송  Thread인 Bookclient를 start()/실행하여 서버로 도서정보 전송
	public void send() {
		BookClient bc = new BookClient(list);
		bc.start();
	}
	
	public void intro() {
		System.out.println("========================================================");
		System.out.println("isbn \t제목 \t 가격 \t수량 \t출판월");
		System.out.println("========================================================");
	}
	

	@Override
	//1. 도서 최초 등록
	public void add(Book b) {
		list.add(b);
	}

	@Override
	//2. 전체 도서 정보 출력
	public List<Book> searchAll() {
		for(Book b : list) {
			System.out.println(b);
		}
		return list;
	}

	@Override
	//도서 판매 후 재고 수량 뺴기
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book searchBook = null;
		int searchBookQuantity = 0;
		for(Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				searchBook = b;
				searchBookQuantity = searchBook.getQuantity();
				if((searchBookQuantity-quantity)<0) {
					throw new QuantityException();
				}			
			}
		}
		if(searchBook == null) {
			throw new ISBNNotFoundException();
		}
		searchBook.setQuantity(searchBookQuantity-quantity);
	}

	
	@Override
	//도서 구매 후 재고 수량 더하기
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book searchBook = null;
		for(Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				searchBook = b;		
			}
		}
		if(searchBook == null) {
			throw new ISBNNotFoundException();
		}
		searchBook.setQuantity(searchBook.getQuantity()+quantity);
	}

	
	@Override
	//총 재고 도서의 수량*금액 반환
	public int getTotalAmount() {
		int total = 0;
		for(Book b : list) {
			if(b!=null) {
				total += b.getPrice()*b.getQuantity();
			}	
		}
		return total;
	}

	
	@Override
	//클래스 생성시 호출 book.dat에 저장돤 파일을 읽어서 ArrayList에 저장
	public void open() {
		String dir = "src";
		File file = new File(dir, "book.dat"); //앞은 디렉토리 정보, 뒤는 실제 파일
		try {
			if(file.createNewFile()) {
				System.out.println("최초 파일 생성됨");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/book.dat"));
			String line = null;
			String[] infoArr = new String[5];
			while((line = br.readLine())!=null) {
				infoArr = line.split(" ");
				if(infoArr.length==4) {
					list.add(new Book(infoArr[0],infoArr[1],Integer.parseInt(infoArr[2]),Integer.parseInt(infoArr[3])));
				}else
					list.add(new Magazine(infoArr[0],infoArr[1],Integer.parseInt(infoArr[2]),Integer.parseInt(infoArr[3]), Integer.parseInt(infoArr[4])));
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	//종료시 호출 ArrayList에 있는 도서 정보를 파일로 저장
	public void close() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("src/book.dat"), true);
			for(Book b : list) {
				if(b instanceof Magazine) {
					Magazine m = (Magazine)b;
					pw.println(m.getIsbn()+" "+m.getTitle()+" "+m.getPrice()+" "+m.getQuantity()+" "+m.getMonth());
				}else
					pw.println(b.getIsbn()+" "+b.getTitle()+" "+b.getPrice()+" "+b.getQuantity());
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}












