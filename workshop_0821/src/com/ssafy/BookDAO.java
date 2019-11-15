package com.ssafy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;


public class BookDAO {

	//싱글톤 패턴 적용
	private static BookDAO dao = new BookDAO();
	private BookDAO() {}
	public static BookDAO getInstance() {
		return dao;
	}

	public Connection getConnection() throws SQLException{

		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("2. DB Server Connection Success...");
		return conn;
	}

	public void close(Connection conn) throws SQLException{
		if(conn!=null) conn.close();
	}
	public void close(PreparedStatement ps) throws SQLException{
		if(ps!=null) ps.close();
	}
	public void close(ResultSet rs) throws SQLException{
		if(rs!=null) rs.close();
	}
	
	//unit test complete
	public void insertBook(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
		conn = getConnection();
		String query = "INSERT INTO book(isbn, title, author, publisher, price, description) VALUES(?, ?, ?, ?, ?, ?)";
		ps = conn.prepareStatement(query);
		System.out.println("3. PrepareStatement Creating...");
		
		ps.setString(1, book.getIsbn());
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getAuthor());
		ps.setString(4, book.getPublisher());
		ps.setInt(5, book.getPrice());
		ps.setString(6, book.getDescription());
		
		System.out.println(ps.executeUpdate() + "row insert ok");
		}finally {
			close(ps);
			close(conn);
		}
	}
	
	public void updateBook(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement ps= null;
		
		try {
			conn = getConnection();
			
			String query = "Update book set title=? , author=? , publisher=? , price=? , description=? WHERE isbn=? ";
			ps = conn.prepareStatement(query);
			
			//물음표는 순서대로 가야함 첫번째 물음표는 name임 두번째는 주소 3번째는  id
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getIsbn());
			
			System.out.println(ps.executeUpdate() + "row update ok");
			
		}finally {
			close(ps);
			close(conn);
		}
		
	}
	
	public void deleteBook(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps= null;
		
		try {
			conn = getConnection();
			//업데이트에서 가장 많은 에러남
			//수정안되는 컬럼하나 뭐지? id지 set뒤에는 pk를 제외한 나머지 컬럼 전부 다 와야지
			String query = "delete from book WHERE isbn=?";
			ps = conn.prepareStatement(query);
		
			//물음표는 순서대로 가야함 첫번째 물음표는 name임 두번째는 주소 3번째는  id
			ps.setString(1, isbn);
			
			System.out.println(ps.executeUpdate() + "row delete ok");
		}finally {
			close(ps);
			close(conn);
		}
	}
	
	public Book findBook(String isbn) throws SQLException {
		Book book = null;
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	    	conn = getConnection();
	    	
	    	String query = "SELECT * FROM book where isbn=?";
	    	ps = conn.prepareStatement(query);
	    	ps.setString(1, isbn);
	    	
	    	rs = ps.executeQuery();
	    	if(rs.next()) {
	    		book = new Book(rs.getString("isbn"), 
	    						rs.getString("title"), 
	    						rs.getString("author"), 
	    						rs.getString("publisher"), 
	    						rs.getInt("price"),
	    						rs.getString("description"));
	    	} 
	    		
	    }finally {
	    	close(rs);
	    	close(ps);
	    	close(conn);
	    }

		return book;
	}
	
	//unit test complete
	public ArrayList<Book> listBooks() throws SQLException{
		ArrayList<Book> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String query = "SELECT isbn, title, author, publisher, price, description FROM book";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("isbn"),
								  rs.getString("title"),
								  rs.getString("author"),
								  rs.getString("publisher"),
								  rs.getInt("price"),
								  rs.getString("description")));
			}
			
		}finally {
			close(rs);
			close(ps);
			close(conn);
		}

		return list;
	}
	
	public ArrayList<Book> listBooksOfJoin() throws SQLException{
		ArrayList<Book> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String query = "select book.title, book.price, author.name from book,author where author.authorno = book.authorno";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("isbn"),
								  rs.getString("title"),
								  rs.getString("author"),
								  rs.getString("publisher"),
								  rs.getInt("price"),
								  rs.getString("description")));
			}
			
		}finally {
			close(rs);
			close(ps);
			close(conn);
		}

		return list;
	}
	
	
	
	
	public int count() {
		int cnt = 0;
		return cnt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
