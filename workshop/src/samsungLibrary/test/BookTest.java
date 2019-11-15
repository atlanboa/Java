//package samsungLibrary.test;
//
//import samsungLibrary.domain.Book;
//import samsungLibrary.manage.BookManager;
//
//public class BookTest {
//
//	public static void main(String[] args) {
//		BookManager manager = new BookManager();
//		
//		//나중에 Scanner로 해보기
//		manager.addBook(new Book("A", null, null, null, 0, null));
//	}
//
//}

package samsungLibrary.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import samsungLibrary.domain.Book;
import samsungLibrary.domain.Magazine;
import samsungLibrary.manage.BookManager;
import samsungLibrary.manage.BookMgrImpl;

public class BookTest {

	public static final int MAX = 5;
	public static void main(String[] args) {
//		BookManager manager = new BookManager();
		ArrayList<Book> books = new ArrayList<>(); 
//		//나중에 Scanner로 해보기
//		//manager.addBook(b);
		BookMgrImpl manager = BookMgrImpl.getInstance();
		
		
		System.out.println("1");
		//1.데이터 입력 기능
		manager.addBook(new Book("1111", "아프니까 청춘이다", "김난도", "한빛미디어", 18000, "자기계발"));
		manager.addBook(new Book("1112", "도깨비", "김은숙", "한빛", 34000, "소설"));
		manager.addBook(new Magazine("21", "엘르11월", "엘르편집장", "엘르", 5000, "잡지", 2019, 8));
		manager.addBook(new Magazine("31", "도보그", "보그편집장", "보그", 4000, "잡지", 2019, 7));
		manager.addBook(new Book("1113", "미움받을 용기", "일본인", "채움", 20000, "자기계발"));
		System.out.println("2");
		
		//2.데이터 전체 검색 기능
		books = manager.getAllBook();
		Collections.sort(books);
		for(Book b : books) {
			System.out.println(b);
		}
		System.out.println("3");
		//3.isbn으로 정보를 검색하는 기능
		System.out.println(manager.searchBookByIsbn("1111"));
		//4.title로 정보를 검색하는 기능(파라메터로 주어진 제목을 포함하는 모든 정보)
		
		System.out.println("4");
		books = manager.searchBooksByTitle("도");
		for(Book b : books) {
			if(b!=null) System.out.println(b);
		}
		System.out.println("5");
		//5.Book만 찾는거 6.함께해도 될듯
		books = manager.searchBooks();
		for(Book b : books) {
			if(b!=null) System.out.println(b);
		}
		System.out.println("6");
		//6.Magazine만 찾는거
		books = manager.searchMagazines();
		for(Book b : books) {
			if(b!=null) System.out.println(b);
		}
		
		System.out.println("한빛");
		//8.출판사로 검색하는 기능
		books = manager.searchBooksByPublisher("한빛");
		for(Book b : books) {
			if(b!=null) System.out.println(b);
		}
		System.out.println("가격");
		//9.가격으로 검색 기능(파라메터로 주어진 가격보다 낮은 도서 정보 검색)
		books = manager.searchBooksByPrice(10000);
		for(Book b : books) {
			if(b!=null) System.out.println(b);
		}
		//10.저장된 모든 도서의 금액 합계를 구하는 기능
		System.out.println(manager.sumAllBooks());
		//11.저장된 모든 도서의 금액 평균을 구하는 기능
		System.out.println(manager.avgAllBooks());
		
		
		
		
		
		
	}

}
