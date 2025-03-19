package com.valtech.training.springsecurity.controllers;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.services.UserManagerService;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;
import com.valtech.training.springsecurity.vos.UserVO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {
	
	@Autowired
	private UserManagerService userService;
	
	@GetMapping("/changePassword")
	public String showChangePasswordForm() {
		System.out.println("Change Password");
		return "changepassword";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@AuthenticationPrincipal User user,@ModelAttribute ChangePasswordVO changePassword)	{
		System.out.println("User = "+user);
		userService.changePassword(user.getUsername(),changePassword);
		return "redirect:logout";
	}
	
	@GetMapping("/register")
	public String showRegisterForm()	{
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserVO user)	{
		userService.registerUser(user.to());
		return "login";
	}
	
	@GetMapping("/login")
	public String login()	{
		System.out.println("Login...");
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello(HttpServletRequest req,HttpServletResponse resp)	{
		List.of(req.getCookies())
			.forEach(c -> System.out.println(c.getName()+" "+c.getValue()+" "+c.getMaxAge()));
		Cookie c = new Cookie("msgq","iamlookingintowhatyoudo");
		c.setMaxAge(120);
		resp.addCookie(c);
		return "hello";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user()	{
		return "User";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin()	{
		return "Admin";
	}

}
