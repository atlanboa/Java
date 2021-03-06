package broker.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import broker.domain.CustomerRec;
import broker.domain.SharesRec;
import broker.domain.StockRec;
import broker.exception.DuplicateSSNException;
import broker.exception.InvalidTransactionException;
import broker.exception.RecordNotFoundException;

/*
 * 비즈니스 로직의 템플릿을 정의할꺼임
 * 이걸 갖다가 고민을 신중하게 해서 특정 한명이 만들어서 배포하면 됨
 * 
 */
public interface Database {

	void addCustomer(CustomerRec cust)throws SQLException, DuplicateSSNException;
	void deleteCustomer(String ssn)throws SQLException,RecordNotFoundException;
	void updateCustomer(CustomerRec cust)throws SQLException, RecordNotFoundException;
	ArrayList<SharesRec> getPortfolio(String ssn)throws SQLException;
	CustomerRec getCustomer(String ssn)throws SQLException;
	ArrayList<CustomerRec> getAllCustomers()throws SQLException;
	ArrayList<StockRec> getAllStocks()throws SQLException;
	//float getStockPrice(String symbol)throws SQLException,RecordNotFoundException;
	void buyShares(String ssn, String symbol, int quantity) throws SQLException;
	void sellShares(String ssn, String symbol, int quantity) throws SQLException,RecordNotFoundException, InvalidTransactionException;
	//void updateStockPrice(String symbol, float price) throws SQLException;

	
}
