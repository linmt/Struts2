import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 编写简单的拦截器
 * @author Administrator
 */
public class DemoInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 4360482836123790624L;
	
	/**
	 * intercept用来进行拦截的
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Action方法执行之前...");
		// 执行下一个拦截器
		String result = invocation.invoke();
		
		System.out.println("Action方法执行之后...");
		
		return result;
	}

}
