package cn.itheima.c_param;

import cn.itheima.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class Demo2Action extends ActionSupport implements ModelDriven<User> {
	
	private User u = new User("dad",111);
	
//	@Override
//	public String execute() throws Exception {
//		System.out.println(u);
//		return SUCCESS;
//	}

	//http://localhost:8080/Demo2Action
	//@Override
	public String execute() throws Exception {
//		//压入栈顶
//		//1获得值栈
//		ValueStack vs = ActionContext.getContext().getValueStack();
//		//2将u压入栈顶
//		vs.push(u);
//		return SUCCESS;

		// 使用获取值栈对象
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");
		System.out.println(vs);

		// 获取到值栈对象，先获取到ActionContext对象
		ValueStack vs2 = ActionContext.getContext().getValueStack();

		//一个action只能获取一个ValueStack对象
		System.out.println(vs==vs2);

		//2将u压入栈顶
		vs.push(u);
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return u;
	}
}
