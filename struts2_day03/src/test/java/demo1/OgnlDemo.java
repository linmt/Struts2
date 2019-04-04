package demo1;

import cn.itheima.User;
import org.junit.Test;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * 演示OGNL表达式
 */
public class OgnlDemo {
	
	/**
	 * 获取context中的数据
	 */
	@Test
	public void run1() throws OgnlException{
		// 上下文对象
		OgnlContext context = new OgnlContext();
		// 获取到根对象
		Object root = context.getRoot();
		// 存储数据
		context.put("name", "美美");
		// 获取值，表达式写法
		Object value = Ognl.getValue("#name", context, root);
		System.out.println(value);
	}
	
	/**
	 * OGNL表达式——访问对象的方法
	 */
	@Test
	public void run2() throws OgnlException{
		// 上下文对象
		OgnlContext context = new OgnlContext();
		// 获取到跟对象
		Object root = context.getRoot();
		// 获取值，表达式写法
		Object value = Ognl.getValue("'haha'.length()", context, root);
		System.out.println(value);

		//访问对象的静态方法
		Object value2 = Ognl.getValue("@java.lang.Math@random()", context, root);
		System.out.println(value2);
	}

	/**
	 * OGNL表达式——获取root中的数据
	 */
	@Test
	public void run3() throws OgnlException{
		OgnlContext context = new OgnlContext();
		User user=new User("abc",13);
		context.setRoot(user);
		Object root = context.getRoot();
		String name=(String) Ognl.getValue("name",context,root);
		System.out.println(name);
	}
}