package com.ssafy.util;

//도메인에 안넣고 util에 넣는 이유?
//메인 정보이기 보다는 찌끄래기라서 util에 넣음
public class MyDate {
	int year;
	int month;
	int day;
	
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getDate() {
		return year +","+ month +","+ day; //문자형 + 아무객체 = String
	}
}

