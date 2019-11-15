package com.ssafy;

import java.util.Scanner;

public class MovieTest {

	public static final int MAX = 10;
	public static void main(String[] args) {
		
		MovieMgr mgr = MovieMgr.getInstance();
		
		int menu = -1;
		int su = -1;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("<<< 영화 관리 프로그램 >>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 정보 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택하세요._");
		menu = sc.nextInt();
		
		switch(menu) {
		case 0:
			System.out.println("프로그램이 종료되었습니다");
			System.exit(0);
			break;
		case 1:
			System.out.println("몇 가지 영화를 입력하시겠습니까?");
			su = sc.nextInt();
			
			for(int i=0; i<su; i++) {
			System.out.println((i+1) + "번째 영화 입력");
			
			System.out.print("영화 제목 :");
			String title = sc.next();
			
			System.out.print("영화 감독 :");
			String director = sc.next();
			
			System.out.print("영화 평점 :");
			int grade = sc.nextInt();
			
			System.out.print("영화 장르 :");
			String genre = sc.next();
			
			System.out.print("영화 줄거리 :");
			String summary = sc.next();
			
			mgr.add(new Movie(title, director, grade, genre, summary));
			
			}
			System.out.println("성공적으로 입력되었습니다.");
			
			break;
			
		case 2:
			System.out.println("전체 영화 정보입니다.");
			for(Movie m : mgr.search()) {
				if(m==null) break;
				System.out.println(m);
			}
			break;
			
		case 3:
			System.out.println("영화 제목 검색 :");
			String title = sc.next();
			for(Movie m : mgr.search(title)) {
				if(m==null) break;
				System.out.println(m);
			}
			break;
		case 4:
			System.out.println("영화 장르별 검색 :");
			String genre = sc.next();
			for(Movie m : mgr.searchGenre(genre)) {
				if(m==null) break;
				System.out.println(m);
			}
			break;
			
		case 5:
			System.out.println("삭제할 영화제목을 정확히 기입하세요 :");
			String titleForDel = sc.next();
			System.out.println("정말 삭제하시겠습니까? 1:예 / 2:아니오");
			int real = sc.nextInt();
			
			if(real==1) {
				mgr.delete(titleForDel);
			}
			break;
		}
		
		
	}
	
	}
}
