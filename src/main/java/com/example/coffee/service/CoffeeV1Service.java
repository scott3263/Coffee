package com.example.coffee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.coffee.dao.CoffeeV1Dao;

@Service
public class CoffeeV1Service {
	
	@Autowired
	CoffeeV1Dao v1Dao ;
	
	public List<Map<String, String>> doCoffeeList() {
		System.out.println("doCoffeeList1");
		List<Map<String, String>> list = v1Dao.doCoffeeList();
		return list;
	}
	
	public List<Map<String, String>> doCoffeeList(String strStart_date, String strEnd_date, String strName,	String strKind) {
		System.out.println("doCoffeeList2");
		System.out.println("strStart_date [" + strStart_date + "]");
		System.out.println("strEnd_date [" + strEnd_date + "]");
		System.out.println("strName [" + strName + "]");
		System.out.println("strKind [" + strKind + "]");
		
		List<Map<String, String>> list = v1Dao.doCoffeeList(strStart_date, strEnd_date, strName, strKind);

		return list;
	}

	public int doInsert(String name, String kind, String price) {
		// TODO Auto-generated method stub
		int i = v1Dao.doInsert(name, kind, price);
		return i;
	}

	public Map<String, String> doListOne(String strCoffee_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int doUpdate(String coffee_id, String name, String kind, String price) {
		// TODO Auto-generated method stub
		return 0;
	}

}
