package com.ssafy.java;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int pan_input = 0;
		int pan = 0;
		int userCnt = 0;
		int comCnt = 0;
		//int user = 0;
		int com = (int)(Math.random()*3)+1;

		System.out.println("컴:"+com);
		System.out.println(">> 가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1.5판 3승");
		System.out.println("2.3판 2승");
		System.out.println("3.1판 1승");
		System.out.println("번호를 입력하세요.");

		pan_input = sc.nextInt();
		
		switch(pan_input) {

		case 1:
			pan = 5;
			userCnt = 3;
			comCnt = 3;
			break;

		case 2:
			pan = 3;
			userCnt = 2;
			comCnt = 2;
			break;

		case 3:
			pan = 1;
			userCnt = 1;
			comCnt = 1;
			break;
		}

		while(pan>0) {
			System.out.print("가위바위보 중 하나 입력:");
			
			String what = "";
			what = sc.next();

			System.out.println(what);
			switch(what) {

			case "가위":
				if(com==1) {
					pan--;
					userCnt--;
					comCnt--;
					System.out.println("비겼습니다!!!");
				}
				else if(com==2) {
					pan--;
					comCnt--;
					System.out.println("졌습니다!!!");
				}
				else if(com==3) {
					pan--;
					userCnt--;
					System.out.println("이겼습니다!!!");
				}
				break;
				
			case "바위":
				if(com==1) {
					pan--;
					userCnt--;
					System.out.println("이겼습니다!!!");
				}
				else if(com==2) {
					pan--;
					userCnt--;
					comCnt--;
					System.out.println("비겼습니다!!!");
				}
				else if(com==3) {
					pan--;
					comCnt--;
					System.out.println("졌습니다!!!");
				}
				break;
				
			case "보":
				if(com==1) {
					pan--;
					comCnt--;
					System.out.println("졌습니다!!!");
				}
				else if(com==2) {
					pan--;
					userCnt--;
					System.out.println("이겼습니다!!!");
				}
				else if(com==3) {
					pan--;
					userCnt--;
					comCnt--;
					System.out.println("비겼습니다!!!");
				}
				break;
			

			}

			

		}
		if(pan == 0 || userCnt == 0 || comCnt == 0) {
			if(userCnt < comCnt) System.out.println("당신의 승리");
			else if(userCnt > comCnt) System.out.println("컴퓨터의 승리");
			else if(userCnt == comCnt) System.out.println("둘 다 비김");
			
		}

	}

 

}