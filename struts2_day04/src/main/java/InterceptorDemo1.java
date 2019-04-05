import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 编写简单的拦截器
 */
public class InterceptorDemo1 extends AbstractInterceptor{

	private static final long serialVersionUID = 4360482836123790624L;

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Interceptor1执行...");
		// 执行下一个拦截器
		String result = invocation.invoke();
		System.out.println("Interceptor1执行结束...");
		return result;
	}
}
