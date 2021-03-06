package broker.dao.impl;
/*
 * Exception ::
 * DuplicateSSNException,
 * RecordNotFoundException,
 * InvalidTransactionException
 * : 팔려는 주식의 숫자가 가지고 있는것 보다 더 많을떄
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.dao.Database;
import broker.domain.CustomerRec;
import broker.domain.SharesRec;
import broker.domain.StockRec;
import broker.exception.DuplicateSSNException;
import broker.exception.InvalidTransactionException;
import broker.exception.RecordNotFoundException;
import config.ServerInfo;



public class DatabaseImpl implements Database {

	private static DatabaseImpl db = new DatabaseImpl("127.0.0.1");

	private DatabaseImpl(String server){

		//throws 지우고 try catch 처리
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");

		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("드라이버 로딩 실패...");
		}
	}

	public static DatabaseImpl getInstance() {
		return db;
	}

	//////// 공통적인 로직 /////////////////////
	//얘네는 비지니스 로직 아님
	public Connection getConnect() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("디비 연결 성공...");
		return conn;
	}

	public void closeAll(PreparedStatement ps, Connection conn)throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn)throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}


	//////////////// 비지니스 로직 ////////////////////////////////////
	//unit ok
	public boolean isExist(String ssn, Connection conn) throws SQLException{ //private은 다른 클래스에서 못쓰자나 그래서 안됬던거

		//특정한 ssn을 가지고 오는 쿼리
		//한국인은 int씀 있으면 1 없으면 0 이거보단 boolean이 나음
		String query = "select ssn from customer where ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn); //ssn 받았자나 멍청아
		ResultSet rs = ps.executeQuery();

		//while말고 if씀
		//if(rs.next()) 이거 할필요도 없음 걍 리턴할때 next가 true false 반환하니까 걍 리턴해줌
		return rs.next();

		//conn은 넘겨받았다치고 ps, rs는 안닫아줘도 되나? 엉 뭐 크으게 문제는 없음
	}

	//unit ok
	public void addCustomer(CustomerRec cust)throws SQLException, DuplicateSSNException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnect();
			if(!isExist(cust.getSsn(), conn)) { //고객이 없다면으로 해서 핵심 로직 넣어주고 예외처리는 뒤에 해주려함
				String query = "INSERT INTO customer (ssn, cust_name, address) VALUES(?, ?, ?)";
				ps = conn.prepareStatement(query);

				//바인딩이래 이걸
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());

				System.out.println(ps.executeUpdate() + "row insert ok");
			}else {
				throw new DuplicateSSNException(cust.getName()+"님은 이미 회원입니다.");
			}
		}finally{
			closeAll(ps, conn);
		}				 
	}
	
	//unit
	public void deleteCustomer(String ssn)throws SQLException,RecordNotFoundException{
		Connection conn = null;
		PreparedStatement ps = null;		 
		try{
			conn = getConnect();

			if(isExist(ssn, conn)) {
				String query = "delete from customer WHERE ssn=?";
				ps = conn.prepareStatement(query);

				//물음표는 순서대로 가야함 첫번째 물음표는 name임 두번째는 주소 3번째는  id
				ps.setString(1, ssn);

				System.out.println(ps.executeUpdate() + "row delete ok");
			}else {
				throw new RecordNotFoundException("해당하는 회원이 없습니다.");
			}
		}finally{
			closeAll(ps, conn);			 
		}
	}
	
	//unit
	public void updateCustomer(CustomerRec cust)throws SQLException, RecordNotFoundException{
		Connection conn = null;
		PreparedStatement ps = null;		
		try{
			conn = getConnect();
			String query = "Update customer set cust_name=? , address=? WHERE ssn=? ";
			ps = conn.prepareStatement(query);

			//물음표는 순서대로 가야함 첫번째 물음표는 name임 두번째는 주소 3번째는  id
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getSsn());

			System.out.println(ps.executeUpdate() + "row update ok");
		}finally{
			closeAll(ps, conn);
		}
	}

	//unit
	public ArrayList<SharesRec> getPortfolio(String ssn)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		ArrayList<SharesRec> v = new ArrayList<SharesRec>();
		try{
			conn = getConnect();
			String query = "select * from shares where ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1,  ssn);
			rs = ps.executeQuery();
			while(rs.next()) { //왜 while임? 주식 여러개
				v.add(new SharesRec(ssn,
						rs.getString("symbol"),
						rs.getInt("quantity")));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return v; 
	}

	//unit
	public CustomerRec getCustomer(String ssn)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		CustomerRec cust = null;
		try{

			conn = getConnect();
			String query = "select * from customer where ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1,  ssn);
			rs = ps.executeQuery();
			if(rs.next()) {
				cust = new CustomerRec(ssn, 
						rs.getString("cust_name"), 
						rs.getString("address")); //생성자에도 낑가넣을수있대
			}
			//if 조건 있으나 마나임 걍 출력안하면 됨
			cust.setPortfolio(getPortfolio(ssn)); //여기서 고객이 보유하고 있는 주식 넣으면 되지? 
			
			//그래서 getportfolio만든거임
		}finally{
			closeAll(rs, ps, conn);
		}
		return cust;
	}
	
	
	public ArrayList<CustomerRec> getAllCustomers()throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();
		try{

			conn = getConnect();

			String query = "SELECT * FROM customer";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CustomerRec(rs.getString("ssn"),
						rs.getString("cust_name"),
						rs.getString("address"),
						getPortfolio(rs.getString("ssn"))));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}

	public ArrayList<StockRec> getAllStocks()throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		ArrayList<StockRec> list = new ArrayList<StockRec>();
		try{

			conn = getConnect();

			String query = "SELECT * FROM stock";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new StockRec(rs.getString("symbol"),
						rs.getInt("price")));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return list;
	}

	public float getStockPrice(String symbol)throws SQLException,RecordNotFoundException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		float price = 0.0f;

		try{

			conn = getConnect();

			String query = "SELECT price FROM stock where symbol=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, symbol);

			rs = ps.executeQuery();
			if(rs.next()) {
				price = rs.getInt("price");
				}
		}finally{
			closeAll(rs, ps, conn);
		}
		return price;
	}

	//살땐 두가지 있는거 사는건 update 없는거 사는건 insert
	public void buyShares(String ssn, String symbol, int quantity)
			throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		boolean flag = false;
		
		try{

			conn = getConnect();
			String query = null;
			
			
			for(SharesRec sr : getPortfolio(ssn)) {
				if(sr.getSymbol().equals(symbol)) {
					flag = true;
				}
			}
			
			if(flag) {
				query = "Update shares set quantity = quantity + ? where ssn=?, symbol=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, quantity);
				ps.setString(2, ssn);
				ps.setString(3, symbol);
				
				System.out.println(ps.executeUpdate() + "row insert ok");
				
				
			}else {
				query = "insert into shares (ssn, symbol, quantity) values(?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, quantity);
				ps.setString(2, ssn);
				ps.setString(3, symbol);
				
				System.out.println(ps.executeUpdate() + "row insert ok");
			}
			
			
			
			
		}finally{
			closeAll(rs, ps, conn);
		}

	}

	//팔땐 다팔면 delete, 조금만 팔면 update, 갖고있는거보다 많이 팔려고하면 인밸리드트랜잭션 에러
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException,RecordNotFoundException, InvalidTransactionException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		int result = 0;
		
		try{
			conn = getConnect();
					
			for(SharesRec sr : getPortfolio(ssn)) {
				if(sr.getSymbol().equals(symbol)) {
					if(sr.getQuantity() == quantity) {
						String query = "delete from shares WHERE ssn=? , symbol=?";
						ps = conn.prepareStatement(query);
					
						ps.setString(1, ssn);
						ps.setString(2, symbol);
						
						System.out.println(ps.executeUpdate() + "row delete ok");
					
					}
					else if(sr.getQuantity() > quantity) {
						String query = "Update shares set quantity = quantity - ? WHERE ssn=?, symbol=? ";
						ps = conn.prepareStatement(query);

						//물음표는 순서대로 가야함 첫번째 물음표는 name임 두번째는 주소 3번째는  id
						ps.setInt(1, quantity);
						ps.setString(2, ssn);
						ps.setString(3, symbol);

						System.out.println(ps.executeUpdate() + "row update ok");
					}
					else {}
				}else {
					throw new RecordNotFoundException("해당 주식을 보유하고 있지 않습니다.");
				}
			}

		}finally{
			closeAll(ps, conn);			 
		}
	}

//	public void updateStockPrice(String symbol, float price) throws SQLException{
//		Connection conn=  null;
//		PreparedStatement ps = null;
//		try{
//
//		}finally{
//			closeAll(ps, conn);
//		}		 
//	}
}//class


















