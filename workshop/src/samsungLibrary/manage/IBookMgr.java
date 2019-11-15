package samsungLibrary.manage;

import java.util.ArrayList;

import samsungLibrary.domain.Book;

public interface IBookMgr {

	//1.데이터 입력 기능
	void addBook(Book b);
	
	//2.데이터 전체 검색 기능
	//이제 배열 쓰면 안되지 ArrayList써야함
	ArrayList<Book> getAllBook();
	
	//3.isbn으로 정보를 검색하는 기능
	Book searchBookByIsbn(String isbn);
	
	//4.Title로 정보를 검색하는 기능(제목 포함)
	ArrayList<Book> searchBooksByTitle(String title);
	
	//5.Book만 검색하는 기능
	ArrayList<Book> searchBooks();
	
	//6.Magazine만 검색하는 기능
	ArrayList<Book> searchMagazines();
	
	//7.Magazine중 올해 잡지만 검색하는 기능
	ArrayList<Book> searchMagazinesByYear(int year);
	
	//8.출판사로 검색하는 기능
	ArrayList<Book> searchBooksByPublisher(String publisher);
	
	//9.가격으로 검색 기능(주어진 가격보다 낮은 도서 정보 검색)
	ArrayList<Book> searchBooksByPrice(int price);
	
	//10.저장된 모든 도서의 금액 합계
	int sumAllBooks();
	
	//11.저장된 모든 도서의 금액 평균
	int avgAllBooks();
	
}
