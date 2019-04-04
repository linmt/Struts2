package cn.itheima;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ValueStack1Action extends ActionSupport {

    private static final long serialVersionUID = 1079080388172927594L;

    private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

    public String execute() throws Exception {
		// 使用获取值栈对象
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");
		System.out.println(vs);

        // 获取到值栈对象，先获取到ActionContext对象
        ValueStack vs2 = ActionContext.getContext().getValueStack();

        //一个action只能获取一个ValueStack对象
        System.out.println(vs==vs2);
        return NONE;
    }

    /*
        向值栈中存值，方式一：利用action在值栈中特性
        http://localhost:8080/showvs/test
     */
    public String test() throws Exception {
        //如果是User user = new User("小苍",888);则在值栈中看到user为null
        user = new User("小苍",888);
        return SUCCESS;
    }

    /*
    向值栈中存值，方式二：调用值栈的方法
    http://localhost:8080/showvs/test2
 */
    public String test2() throws Exception {
        // 获取值栈
        ValueStack vs = ActionContext.getContext().getValueStack();
        // 压栈  push(Object obj);   集合使用set(String key,Object obj);
        user = new User("小苍",888);
        vs.push(user);
        //创建了一个map，把map压入栈顶
        //此时msg没有get方法，所以在栈中看不到
        vs.set("msg", "小凤");
        return SUCCESS;
    }

    /**
     * 演示从值栈中获取值
     * http://localhost:8080/showvs/save
     */
    public String save() throws Exception {
        ValueStack vs = ActionContext.getContext().getValueStack();

        vs.push("美美");
        vs.set("msg", "小凤");

        User user = new User("小苍",111);
        vs.push(user);
        vs.set("user", user);

        List<User> ulist = new ArrayList<User>();
        ulist.add(new User("熊大",123));
        ulist.add(new User("熊二",456));
        ulist.add(new User("熊三",789));
         //把ulist集合压栈
         vs.push(ulist);

        // set方法进行压栈
        vs.set("ulist", ulist);


		// 从context栈中获取值，底层已经封装到request session对象，操作就是map集合
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("msg", "花花");
		request.getSession().setAttribute("msg", "小草");
        ServletActionContext.getServletContext().setAttribute("msg","权志龙");

        return SUCCESS;
    }
}
