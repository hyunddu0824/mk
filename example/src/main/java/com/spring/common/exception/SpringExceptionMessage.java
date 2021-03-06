package com.spring.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class SpringExceptionMessage extends SimpleMappingExceptionResolver {
	private String exceptionAttribute = DEFAULT_EXCEPTION_ATTRIBUTE;
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info("========================"+request.getRequestURI());

		if(this.exceptionAttribute != null){
			if(logger.isDebugEnabled())
				logger.debug("Exception as model attribute : " + this.exceptionAttribute);
		}
		
		ModelAndView mav = super.doResolveException(request, response, handler, ex);
		mav.addObject("uri", request.getRequestURI());
		/*ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:"+request.getRequestURI());*/
		mav.addObject("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500
		return mav;
	}

}
