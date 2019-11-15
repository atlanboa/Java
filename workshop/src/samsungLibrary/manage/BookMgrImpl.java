package samsungLibrary.manage;

import java.util.ArrayList;

import samsungLibrary.domain.Book;
import samsungLibrary.domain.Magazine;

public class BookMgrImpl implements IBookMgr {


	private ArrayList<Book> books = new ArrayList<>();
	private int index;

	//싱글턴
	private static BookMgrImpl mgr = new BookMgrImpl();

	private BookMgrImpl() {}

	public static BookMgrImpl getInstance() {
		return mgr;
	}

	//1.데이터 입력 기능
	@Override
	public void addBook(Book b) {

		books.add(b);
	}
	//2.데이터 전체 검색 기능
	@Override
	public ArrayList<Book> getAllBook() {

		return books;
	}
	//3.isbn으로 정보를 검색하는 기능
	@Override
	public Book searchBookByIsbn(String isbn) {
		Book book = new Book();
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				book = b;
			}
		}
		return book;
	}
	//4.Title로 정보를 검색하는 기능(제목 포함)
	@Override
	public ArrayList<Book> searchBooksByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(b.getTitle().contains(title)) {
				temp.add(b);
			}
		}


		return temp;
	}
	//5.Book만 검색하는 기능
	@Override
	public ArrayList<Book> searchBooks() {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(!(b instanceof Magazine)) {
				temp.add(b);
			}
		}


		return temp;
	}
	//6.Magazine만 검색하는 기능
	@Override
	public ArrayList<Book> searchMagazines() {

		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(b instanceof Magazine) {
				temp.add(b);
			}
		}

		return temp;

	}
	//7.Magazine중 올해 잡지만 검색하는 기능
	@Override
	public ArrayList<Book> searchMagazinesByYear(int year) {

		ArrayList<Book> temp = new ArrayList<>();
		for(Book b : books) {
			if(b instanceof Magazine && ((Magazine)b).getYear() == year) {
				temp.add(b);
			}
		}

		return temp;

	}
	//8.출판사로 검색하는 기능
	@Override
	public ArrayList<Book> searchBooksByPublisher(String publisher) {
		ArrayList<Book> temp = new ArrayList<>();

		for(Book b : books) {
			if(b.getPublisher().equals(publisher)) {
				temp.add(b);
			}
		}

		return temp;
	}

	//9.가격으로 검색 기능(주어진 가격보다 낮은 도서 정보 검색)
	@Override
	public ArrayList<Book> searchBooksByPrice(int price) {

		ArrayList<Book> temp = new ArrayList<>();

		for(Book b : books) {
			if(b.getPrice() < price) {
				temp.add(b);
			}
		}

		return temp;

	}
	//10.저장된 모든 도서의 금액 합계
	@Override
	public int sumAllBooks() {

		int sum = 0;

		for(Book b : books) {
			sum += b.getPrice();
		}

		return sum;


	}
	//11.저장된 모든 도서의 금액 평균
	@Override
	public int avgAllBooks() {

		return sumAllBooks() / books.size();
	}


}
