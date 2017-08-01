package com.qfedu;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Servlet 3开始可以用代码取代web.xml的配置
public class WebConfig 
	extends AbstractAnnotationConfigDispatcherServletInitializer{

	// Spring IoC容器的配置类
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	// Spring MVC的配置类
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfig.class };
	}

	// 前端控制器DispatcherServlet的映射
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// 配置过滤器
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("utf-8", true);
		HiddenHttpMethodFilter restFilter = new HiddenHttpMethodFilter();
		return new Filter[] { encodingFilter, restFilter  };
	}

}
