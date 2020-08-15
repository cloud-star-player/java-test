package com.systop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.systop.pojo.UserLogin;


//分别为方法前执行preHandle，方法后postHandle，页面渲染后afterCompletion。
//postHandler在拦截器链内所有拦截器返成功调用
//afterCompletion只有preHandle返回true才调用
public class MyInterceptor implements HandlerInterceptor {
	//afterCompletion当这个请求结束完成后，解析器试图也结束了之后去执行。
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}

	//postHandle在调用控制器方法之后，并解析器试图之前执行。
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}

	//preHandle在控制器方法前执行。
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("/index") >= 0) {
			return true;
		}
		//获取session对象
		HttpSession session = request.getSession();
		UserLogin user = (UserLogin)session.getAttribute("user_session");
		if(user != null) {
			return true;
		}
		request.setAttribute("msg", "您现在还没有登录，请先登录！");
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		return false;
	}
	
}