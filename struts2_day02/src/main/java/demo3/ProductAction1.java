package demo3;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import domain.Product;

/**
 * 复杂类型的数据封装：封装到List集合
 * @author jt
 *
 */
public class ProductAction1 extends ActionSupport {
	
	private List<Product> products;
	// 提供集合的set方法:
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
	}

	/*
	Product [name=yi, price=1.0]
	Product [name=er, price=2.0]
	Product [name=san, price=3.0]
	 */
	@Override
	public String execute() throws Exception {
		for (Product product : products) {
			System.out.println(product);
		}
		return NONE;
	}

	
}
