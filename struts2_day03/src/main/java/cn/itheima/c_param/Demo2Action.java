package cn.itheima.c_param;

import cn.itheima.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class Demo2Action extends ActionSupport implements ModelDriven<User> {
	
	private User u = new User();
	
//	@Override
//	public String execute() throws Exception {
//		System.out.println(u);
//		return SUCCESS;
//	}

	//http://localhost:8080/Demo2Action
	//@Override
	public String execute() throws Exception {
		//压入栈顶
		//1获得值栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		//2将u压入栈顶
		vs.push(u);
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return u;
	}
}
