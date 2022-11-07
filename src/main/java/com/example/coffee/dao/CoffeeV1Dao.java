package com.example.coffee.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoffeeV1Dao {

	/* 전체 리스트 조회 */
	List<Map<String, String>> doCoffeeList() ;
	
	/* 전체 리스트 조회 - overloading*/
	List<Map<String, String>> doCoffeeList(String strStart_date, String strEnd_date, String strName, String strKind);

	int doInsert(String name, String kind, String price);

}
