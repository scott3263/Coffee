package com.example.coffee.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.engine.AttributeName;

import com.example.coffee.service.CoffeeV1Service;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("v1")

public class CoffeeV1 {
	
	@Autowired
	CoffeeV1Service v1Service;
	
	@GetMapping("/coffee")
	public String doCoffee(Model model) {
		
		
		System.out.println("doCoffee()");
		/*전체 목록 조회 */
		List<Map<String, String>> list = v1Service.doCoffeeList();
		model.addAttribute("list", list);
		System.out.println(list);
		
		return "/v1/coffee";
	}
	
	@PostMapping("/coffee")
	public String doCoffeePost(HttpServletRequest request, Model model) {

		System.out.println("doCoffeePost");
		String strStart_date=request.getParameter("start_date");
		String strEnd_date=request.getParameter("end_date");
		String strName=request.getParameter("name");
		String strKind=request.getParameter("kind");
		
		System.out.println("strStart_date [" + strStart_date + "]");
		System.out.println("strEnd_date [" + strEnd_date + "]");
		System.out.println("strName [" + strName + "]");
		System.out.println("strKind [" + strKind + "]");
		
	
		/*전체 목록 조회 overloading*/
		List<Map<String, String>> list = v1Service.doCoffeeList(strStart_date, strEnd_date, strName, strKind);
		model.addAttribute("list", list);
		System.out.println(list);
		return "/v1/coffee";
	}
	
	/* 등록 */
	@GetMapping("/insert")
	public String doInsert() {
		return "/v1/coffee_Ins";
	}
		
	/* 등록 post */
	@PostMapping("/insert")
	public String doInsertPost(@RequestParam(value="name") String name,
	                           @RequestParam(value="kind") String kind,
	                           @RequestParam(value="price") String price,
	                           Model model) {
		
		System.out.println("doInsertPost");
		System.out.println("name [" + name + "]");
		System.out.println("kind [" + kind + "]");
		System.out.println("price [" + price + "]");
				
		int i = v1Service.doInsert(name, kind, price);
		return "redirect:/v1/coffee";
	}
	
	/* 수정 */
	@GetMapping("/update")
	public String doUpdate(@RequestParam(value="coffee_id") String strCoffee_id, Model model) {
		Map<String, String> map = v1Service.doListOne(strCoffee_id);
		model.addAttribute("map",map);
		return "/v1/coffee_Up";
	}
		
	/* 수정 post */
	@PostMapping("/update")
	public String doUpdatePost(@RequestParam(value="coffee_id") String coffee_id,
							   @RequestParam(value="name") String name,
	                           @RequestParam(value="kind") String kind,
	                           @RequestParam(value="price") String price,
	                           Model model) {
		
		System.out.println("doUpdatePost");
		System.out.println("coffee_id [" + coffee_id + "]");
		System.out.println("name [" + name + "]");
		System.out.println("kind [" + kind + "]");
		System.out.println("price [" + price + "]");
				
		int i = v1Service.doUpdate(coffee_id, name, kind, price);
		return "redirect:/v1/coffee";
	}
	
	
	/* 삭제 */
	@GetMapping("/delete")
	public String doDelete() {
		
		return "redirect:/v1/coffee";
		
	}

}
