import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by 热带雨林 on 2019/4/5.
 */
public class InterceptorDemo2 extends AbstractInterceptor {

    private static final long serialVersionUID = 4360482836123790624L;

    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("Interceptor2执行...");
        // 执行下一个拦截器
        String result = invocation.invoke();
        System.out.println("Interceptor2执行结束...");
        return result;
    }
}
