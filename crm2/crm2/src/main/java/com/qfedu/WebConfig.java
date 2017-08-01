package com.qfedu;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Servlet 3��ʼ�����ô���ȡ��web.xml������
public class WebConfig 
	extends AbstractAnnotationConfigDispatcherServletInitializer{

	// Spring IoC������������
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	// Spring MVC��������
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfig.class };
	}

	// ǰ�˿�����DispatcherServlet��ӳ��
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// ���ù�����
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("utf-8", true);
		HiddenHttpMethodFilter restFilter = new HiddenHttpMethodFilter();
		return new Filter[] { encodingFilter, restFilter  };
	}

}
