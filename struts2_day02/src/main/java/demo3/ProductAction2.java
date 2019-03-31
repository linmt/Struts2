package demo3;

import java.util.Map;


import com.opensymphony.xwork2.ActionSupport;
import domain.Product;

/**
 * 复杂数据类型的封装：封装到Map集合
 * @author jt
 *
 */
public class ProductAction2 extends ActionSupport {

	private Map<String, Product> map;
	
	public Map<String, Product> getMap() {
		return map;
	}

	public void setMap(Map<String, Product> map) {
		this.map = map;
	}

	/*
	two    Product [name=二, price=2.0]
	one    Product [name=一, price=1.0]
	three    Product [name=三, price=3.0]
	 */
	@Override
	public String execute() throws Exception {
		for (String key : map.keySet()) {
			Product product = map.get(key);
			System.out.println(key+"    "+product);
		}
		return NONE;
	}
}
