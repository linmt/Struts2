package demo2;


import com.opensymphony.xwork2.ActionSupport;
import domain.User;

/**
 * 数据封装的方式二：属性驱动-在页面中提供表达式的方式
 * @author jt
 *
 */
public class UserAction2 extends ActionSupport {
	
	// 提供一个User对象:
	private User user;
	// 提供user的set和get方法：一定要提供get方法。
	// 因为拦截器完成数据封装，需要创建User对象。通过get方法可以获得同一个对象，将数据封装到同一个对象中。
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	//User [username=demo, password=1234, age=19, birthday=Tue Mar 12 00:00:00 CST 1991, salary=8100.0]
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}

}
