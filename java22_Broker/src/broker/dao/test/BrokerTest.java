package broker.dao.test;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.dao.impl.DatabaseImpl;
import broker.domain.CustomerRec;
import broker.domain.SharesRec;
import config.ServerInfo;

public class BrokerTest{

	public static void main(String[] args) throws Exception {

		DatabaseImpl db = DatabaseImpl.getInstance();
		//메소드 단위테스트 하자 확인하면 주석처리
		//System.out.println(db.isExist("777-777"));
		//db.addCustomer(new CustomerRec("888-889", "Jack", "SD"));
//		ArrayList<SharesRec> list = db.getPortfolio("777-777");
//		for(SharesRec sr : list) {
//			System.out.println(sr);
//		}
		
		//db.deleteCustomer("888-889");
		//db.updateCustomer(new CustomerRec("111-111", "hi", "Daegu"));
		//System.out.println(db.getCustomer("777-777"));
		
	}
}
