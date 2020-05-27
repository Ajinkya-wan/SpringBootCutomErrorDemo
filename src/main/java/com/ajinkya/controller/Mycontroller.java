package com.ajinkya.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.ajinkya.app.model.ErrorJson;


@RestController
public class Mycontroller implements ErrorController {
	
	private static final String Path ="/error" ;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String Hello() {
		return "Hello Aj";
	}
	
	@Autowired
	ErrorAttributes errorAttributes;
	
//	@RequestMapping(value = Path, method = RequestMethod.GET)
//	public String defaultErrorMessage() {
//		return "No Such Path Exists !!!!";
//	}
	

    @Value("${debug}")
    private boolean debug;
	
    @RequestMapping(value = Path)
	ErrorJson error(HttpServletRequest request , HttpServletResponse response) {
		return new ErrorJson(response.getStatus() , getErrorAtrributes(request , debug));
		
	}
	
	 private Map<String, Object> getErrorAtrributes(HttpServletRequest request, boolean includeStackTrace) {
	        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
	        return errorAttributes.getErrorAttributes( (WebRequest) requestAttributes, includeStackTrace);
	    }

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stu
		return Path;
	}

}
