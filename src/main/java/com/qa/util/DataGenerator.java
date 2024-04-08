package com.qa.util;

import com.github.javafaker.Faker;

import enums.Values;

public class DataGenerator {

	Faker faker=new Faker();
	
	
	public String getMarketValue() {
	 Long val=	faker.number().numberBetween(Values.MIN, Values.MAX);
		return  val.toString();
	}
	public String getCarpetValue() {
		Long l=Values.carpetValue;
		return (l.toString());
	}
	
	public String getPincode() {
		
		Long pcode=faker.number().numberBetween(99999l, 999999l);
		return pcode.toString();
	}
	
	
	

	
}
