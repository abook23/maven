package com.demo.index;

import com.demo.interceptor.BaseInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * IndexController
 */
@Before({BaseInterceptor.class})
public class IndexController extends Controller {
	
	public void index() {
		render("/index.html");
	}
}





