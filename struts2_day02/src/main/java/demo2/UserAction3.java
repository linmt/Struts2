package demo2;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;

/**
 * 数据封装的方式三：模型驱动-采用模型驱动的方式
 * @author jt
 *
 */
public class UserAction3 extends ActionSupport implements ModelDriven<User>{
	// 模型驱动使用的对象：前提必须手动提供对象的实例
	private User user = new User(); // 手动实例化User.
	@Override
	// 模型驱动需要使用的方法:
	public User getModel() {
		return user;
	}

	//User [username=demo, password=1234, age=20, birthday=Tue Mar 12 00:00:00 CST 1991, salary=8100.0]
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return NONE;
	}
}
