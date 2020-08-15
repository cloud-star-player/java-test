package com.systop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.systop.pojo.UserLogin;


//�ֱ�Ϊ����ǰִ��preHandle��������postHandle��ҳ����Ⱦ��afterCompletion��
//postHandler�������������������������ɹ�����
//afterCompletionֻ��preHandle����true�ŵ���
public class MyInterceptor implements HandlerInterceptor {
	//afterCompletion��������������ɺ󣬽�������ͼҲ������֮��ȥִ�С�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}

	//postHandle�ڵ��ÿ���������֮�󣬲���������ͼ֮ǰִ�С�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}

	//preHandle�ڿ���������ǰִ�С�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("/index") >= 0) {
			return true;
		}
		//��ȡsession����
		HttpSession session = request.getSession();
		UserLogin user = (UserLogin)session.getAttribute("user_session");
		if(user != null) {
			return true;
		}
		request.setAttribute("msg", "�����ڻ�û�е�¼�����ȵ�¼��");
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		return false;
	}
	
}