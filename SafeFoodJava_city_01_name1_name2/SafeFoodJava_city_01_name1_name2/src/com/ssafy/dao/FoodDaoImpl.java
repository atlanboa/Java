package com.ssafy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.ssafy.util.FoodNutritionSAXHandler;
import com.ssafy.util.FoodSAXHandler;
import com.ssafy.util.FoodSaxParser;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;
import com.ssafy.vo.SafeFoodException;


import config.ServerInfo;


public class FoodDaoImpl implements FoodDao{

	public FoodDaoImpl() {
		loadData();
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");

		} catch (ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("드라이버 로딩 실패...");
		}
	}
	
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

	public boolean isExist(int code, Connection conn) throws SQLException{ //private은 다른 클래스에서 못쓰자나 그래서 안됬던거

		String query = "select code from food where code=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, code); 
		ResultSet rs = ps.executeQuery();

		//while말고 if씀
		//if(rs.next()) 이거 할필요도 없음 걍 리턴할때 next가 true false 반환하니까 걍 리턴해줌
		return rs.next();

		//conn은 넘겨받았다치고 ps, rs는 안닫아줘도 되나? 엉 뭐 크으게 문제는 없음
	}
	/**
	 * 식품 영양학 정보와 식품 정보를  xml 파일에서 읽어온다.
	 */
	public void loadData() {
		
	  //  FoodNutritionSaxPaser를 이용하여 Food 데이터들을 가져온다
		FoodSaxParser fsp = new FoodSaxParser();
		List<Food> foods = fsp.getFoods();
		
	  //  가져온 Food 리스트 데이터를 DB에 저장한다.	
		for(Food f : foods) {
			try {
				addFood(f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addFood(Food food)throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnect();
			if(!isExist(food.getCode(), conn)) { //고객이 없다면으로 해서 핵심 로직 넣어주고 예외처리는 뒤에 해주려함
				String query = "INSERT INTO food (code, name, maker, material, image, SERVING_WT, NUTR_CONT1, NUTR_CONT2, NUTR_CONT3, NUTR_CONT4, NUTR_CONT5, NUTR_CONT6, NUTR_CONT7, NUTR_CONT8, NUTR_CONT9) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				ps = conn.prepareStatement(query);

				ps.setInt(1, food.getCode());
				ps.setString(2, food.getName());
				ps.setString(3, food.getMaker());
				ps.setString(4, food.getMaterial());
				ps.setString(5, food.getImg());
				ps.setDouble(6, food.getSupportpereat());
				ps.setDouble(7, food.getCalory());
				ps.setDouble(8, food.getCarbo());
				ps.setDouble(9, food.getProtein());
				ps.setDouble(10, food.getFat());
				ps.setDouble(11, food.getSugar());
				ps.setDouble(12, food.getNatrium());
				ps.setDouble(13, food.getChole());
				ps.setDouble(14, food.getTransfat());
				ps.setDouble(15, food.getTransfat());
		
				System.out.println(ps.executeUpdate() + "row insert ok");
			}else {
				
			}
		}finally{
			closeAll(ps, conn);
		}				 
	}
	
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. 
	 * web에서 구현할 내용. 
	 * web에서 페이징 처리시 필요 
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한  식품 개수
	 */
	public int foodCount(FoodPageBean  bean){
		List<Food> finds = searchAll(bean);
		return finds.size();
	}
	
	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를  검색해서 반환.  
	 * @param bean  검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<Food> searchAll(FoodPageBean  bean){
		List<Food> finds = new LinkedList<Food>();
		try {
			Connection conn = DriverManager.getConnection("127.0.0.1", "root", "1234");
			if(bean !=null) {
				String key = bean.getKey();
				String word = bean.getWord();
				String query = "SELECT * FROM food WHERE word LIKE %word%";
				if(!key.equals("all") && word!=null && !word.trim().equals("")) {
					PreparedStatement ps = conn.prepareStatement(query);
					ps.executeUpdate();
					// 구현 하세요.
				}
			}
			else {
				String query = "SELECT * FROM food";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return finds;
	}

	
	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환. 
	 * @param code	검색할 식품 코드
	 * @return	식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	public Food search(int code) {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		Food food = null;
//		try{
//
//			conn = getConnect();
//			String query = "select * from food where code=?";
//			ps = conn.prepareStatement(query);
//			ps.setInt(1,  code);
//			rs = ps.executeQuery();
//			if(rs.next()) {
////				food = new Food(code, 
////				rs.getString("name"),
////				rs.getString("maker"),
////				rs.getString("material"),
////				rs.getString("image"),
////				rs.getDouble("SERVING_WT"),
////				rs.getDouble("NUTR_CONT1"),
////				rs.getDouble("NUTR_CONT2"),
////				rs.getDouble("NUTR_CONT3"),
////				rs.getDouble("NUTR_CONT4"),
////				rs.getDouble("NUTR_CONT5"),
////				rs.getDouble("NUTR_CONT6"),
////				rs.getDouble("NUTR_CONT7"),
////				rs.getDouble("NUTR_CONT8"),
////				rs.getDouble("NUTR_CONT9"));
//			
//			}
//			
//		}finally{
//			closeAll(rs, ps, conn);
//		}
//		return food;
//		
		
		return null;
	}

	/**
	 * 가장 많이 검색한 Food  정보 리턴하기 
	 * web에서 구현할 내용.  
	 * @return
	 */
	public List<Food> searchBest() {
		return null;
	}
	
	public List<Food> searchBestIndex() {
		return null;
	}
	
	public static void main(String[] args) {
		FoodDaoImpl dao = new FoodDaoImpl();
		dao.loadData();
		System.out.println(dao.search(1));
		System.out.println("===========================material로 검색=================================");
		print(dao.searchAll(new FoodPageBean("material", "감자전분", null, 0)));
		System.out.println("===========================maker로 검색=================================");
		print(dao.searchAll(new FoodPageBean("maker", "빙그레", null, 0)));
		System.out.println("===========================name으로 검색=================================");
		print(dao.searchAll(new FoodPageBean("name", "라면", null, 0)));
		System.out.println("============================================================");
		print(dao.searchAll(null));
		System.out.println("============================================================");
	}
	
	public static void print(List<Food> foods) {
		for (Food food : foods) {
			System.out.println(food);
		}
	}
}