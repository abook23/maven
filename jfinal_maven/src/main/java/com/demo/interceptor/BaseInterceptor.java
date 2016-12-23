package com.demo.interceptor;

import com.demo.Key;
import com.demo.common.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class BaseInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		Controller controller = inv.getController();
		User user = controller.getSessionAttr(Key.KEY_SESSION_USER);
		if (user != null){
		    inv.invoke();
		}else {
			controller.redirect("/login.html");
		}
	}

}
