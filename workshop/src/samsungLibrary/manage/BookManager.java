package samsungLibrary.manage;

import samsungLibrary.domain.Book;
import samsungLibrary.domain.Magazine;

public class BookManager {

	public static final int MAX_BOOK = 10;
	private Book[] books = new Book[MAX_BOOK];
	private int numberOfBooks;
	private int sum;

	//1.데이터 입력 기능
	public void addBook(Book b) {
		books[numberOfBooks++] = b;
	}

	//2.데이터 전체 검색 기능
	//사실 이건 검색이 아니지
	public Book[] getAllBook() {
		return books;
	} 

	//3.isbn으로 정보를 검색하는 기능
	//리턴타입이있으면 반드시 만들어주고 가야함
	public Book[] searchBookByIsbn(String isbn) {
		Book[] temp = new Book[MAX_BOOK];
		for(int i=0; i<books.length; i++) {
			if(books[i].equals(isbn)) {
				temp[i] = books[i];
			}
		}

		return temp;
	}

	//4.title로 정보를 검색하는 기능(파라메터로 주어진 제목을 포함하는 모든 정보)
	public Book[] searchBookByTitle(String title) {
		Book[] temp = new Book[MAX_BOOK];
		for(int i=0; i<books.length; i++) {
			//포함하는 거는 contain써야함 근데 얘는 스트링 받음 그래서 게터필요함
			if(books[i].getTitle().contains(title)) {
				temp[i] = books[i];
			}
		}

		return temp;
	}

//	public Book[] searchBookByType(String type) {
//		
//		for(Book b : books) {
//			
//			
//		}
//	}

	//8.출판사로 검색하는 기능
	public Book[] searchBookByPublisher(String publisher) {
		Book[] temp = new Book[MAX_BOOK];
		for(int i=0; i<books.length; i++) {
			if(books[i].equals(publisher)) {
				temp[i] = books[i];
			}
		}

		return temp;
	}

	//9.가격으로 검색 기능(파라메터로 주어진 가격보다 낮은 도서 정보 검색)
	public Book[] searchBookByPrice(int price) {
		return books;

	}

	//10.저장된 모든 도서의 금액 합계를 구하는 기능
	public int sumAllBook() {

		for(Book b : books) {
			sum += b.getPrice();
		}

		return sum;
	}

	//11.저장된 모든 도서의 금액 평균을 구하는 기능
	public int avgAllBook() {
		int result = 0;

		result = sum / numberOfBooks;

		return result;
	}
}


