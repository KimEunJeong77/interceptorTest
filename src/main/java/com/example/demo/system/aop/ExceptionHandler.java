package com.example.demo.system.aop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.member.exception.IdNotFoundException;
import com.example.demo.member.exception.PwMissMatchException;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundException.class)
	public ModelAndView idNotFoundExceptionHandler(HttpServletRequest request, IdNotFoundException e) {
		  ModelAndView mv = new ModelAndView("/loginForm");
		  
		  mv.addObject("errorCode", -1);
		  mv.addObject("errorMsg", e.getMessage());
	      
	      return mv;
	  }
	@org.springframework.web.bind.annotation.ExceptionHandler(PwMissMatchException.class)
	public ModelAndView pwMissMatchExceptionHandler(HttpServletRequest request, PwMissMatchException e) {
		  ModelAndView mv = new ModelAndView("/loginForm");
		  
		  mv.addObject("errorCode", -2);
		  mv.addObject("errorMsg", e.getMessage());
	      
	      return mv;
	  }
}
