package com.qfedu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler(java.lang.Exception.class)
	public String handleRE(Model model, Exception ex) {
		model.addAttribute("hint", ex.getMessage());
		return "error/error";
	}
}
