package abcDigital.manage;

import java.util.ArrayList;

import abcDigital.domain.Product;

public interface IProductMgr {

	public void addProduct(Product p) throws DuplicateException;
	public Product searchProductBySerial(String serial) throws CodeNotFoundException;
	public ArrayList<Product> searchRefrigerator400L() throws ProductNotFoundException;
	public ArrayList<Product> searchTV50inch() throws ProductNotFoundException;
	public void save();
	public void load();
}
