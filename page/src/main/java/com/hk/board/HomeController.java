package com.hk.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/login.do", 
		       method = {RequestMethod.GET,RequestMethod.POST})
	public String login(Locale locale, Model model) {
	logger.info("로그인하기 {}.", locale);
	return "login";
}
	@RequestMapping(value = "/join.do", 
		       method = {RequestMethod.GET,RequestMethod.POST})
	public String join(Locale locale, Model model) {
	logger.info("회원가입하기 {}.", locale);
	return "join";
}
	@RequestMapping(value = "/boardlist.do", 
		       method = {RequestMethod.GET,RequestMethod.POST})
	public String boardlist(Locale locale, Model model) {
	logger.info("게시판으로 이동하기 {}.", locale);
	
	List<HkDto> list=HkService.getAllList();
	model.addAttribute("list", list);
	System.out.println("사이즈:"+list.size());
	return "boardlist";
}
}
