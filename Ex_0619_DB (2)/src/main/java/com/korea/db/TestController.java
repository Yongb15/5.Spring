package com.korea.db;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import util.MyPath.HomeClass;
import util.MyPath.TestClass;

@Controller
public class TestController {
	
	
	@RequestMapping("/test")
	public  String test(Model model){
		
		String[] msg = {"사과","바나나","복숭아","수박","딸기"};
		
		model.addAttribute("msg",msg);
		
		
		return TestClass.VIEW_PATH+"test.jsp";
	}
	
	//@RequestParam
	//- 요청의 파라미터를 연결할 매개변수에 붙히는 어노테이션
	//@RequestParam("가져올 데이터의 이름")변수
	
	@RequestMapping("/requestParam")
	//required = false : null값이 들어와도 오류를 내지 않겠다.
	//public String main(@RequestParam(name="year", required=false) String year) {
	public String main(String year) {
		//request.getParameter("year);
		
		//http://localhost/db/requestParam  -> year = null
		//http://localhost/db/requestParam?year=  -> year = ""
		
		System.out.printf("[%s]year=[%s]%n",new Date(), year);
		return HomeClass.VIEW_PATH+"yoil.jsp";
	}
	
	@RequestMapping("/requestParam2")
	public String main2(@RequestParam(required=false, defaultValue="1")String year) {
		//http://localhost/db/requestParam  -> year = 1
		//http://localhost/db/requestParam?year=  -> year = 1
		System.out.printf("[%s]year=[%s]%n",new Date(), year);
		return HomeClass.VIEW_PATH+"yoil.jsp";
	}
	
	@RequestMapping("/requestParam3")
	//public String main3(@RequestParam(name="year", required=true) String year) {
	public String main3(@RequestParam String year) {
		//http://localhost/db/requestParam  -> year = null 400 Bad Request
		//http://localhost/db/requestParam?year=  -> year = ""
		System.out.printf("[%s]year=[%s]%n",new Date(), year);
		return HomeClass.VIEW_PATH+"yoil.jsp";
	}
	
	@RequestMapping("/requestParam4")
	public String main4(@RequestParam int year) {
		//http://localhost/db/requestParam  ->  400 Bad Request
		//http://localhost/db/requestParam?year=  ->  400 Bad Request
		System.out.printf("[%s]year=[%s]%n",new Date(), year);
		return HomeClass.VIEW_PATH+"yoil.jsp";
	}
	
	@RequestMapping("/requestParam5")
	public String main5(@RequestParam(required=false) int year) {
		//http://localhost/db/requestParam  -> 500
		//http://localhost/db/requestParam?year=  ->  400 Bad Request
		System.out.printf("[%s]year=[%s]%n",new Date(), year);
		return HomeClass.VIEW_PATH+"yoil.jsp";
	}
	
	@RequestMapping("/requestParam6")
	public String main6(@RequestParam(defaultValue="1")int year) {
		//http://localhost/db/requestParam  ->  1
		//http://localhost/db/requestParam?year=  ->  1
		System.out.printf("[%s]year=[%s]%n",new Date(), year);
		return HomeClass.VIEW_PATH+"yoil.jsp";
	}
}





