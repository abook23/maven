package com.demo.controller;

import com.demo.interceptor.BaseInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before({BaseInterceptor.class})
public class MainController extends Controller {


	public void index() {
		render("/index.html");
	}
}
