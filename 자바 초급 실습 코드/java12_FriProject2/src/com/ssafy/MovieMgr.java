package com.ssafy;

public class MovieMgr {
	public static final int MAX_SIZE = 10;

	private Movie[] movies = new Movie[MAX_SIZE];
	private int index;
	private int size;

	private static MovieMgr moivemgr = new MovieMgr();

	private MovieMgr() {}

	public static MovieMgr getInstance() {
		return moivemgr;
	}

	public void add(Movie m) {
		movies[index++] = m;
	}

	public Movie[] search() {
		return movies;
	}

	public Movie[] search(String title) {
		Movie[] temp = new Movie[MAX_SIZE];
		for(int i=0; i<movies.length; i++) {
			if(movies[i]!=null&&movies[i].getTitle().contains(title)) {
				temp[i] = movies[i];
			}
		}
		return temp;
	}

	public Movie[] searchDirector(String name) {
		Movie[] temp = new Movie[MAX_SIZE];
		for(int i=0; i<movies.length; i++) {
			//Q.얘는 왜 널이 아니다라는 조건이 없어도 되는거져??
			if(movies[i].getDirector().equals(name)) {
				temp[i] = movies[i];
			}
		}
		return temp;
	}


	public Movie[] searchGenre(String genre) {
		Movie[] temp = new Movie[MAX_SIZE];
		for(int i=0; i<movies.length; i++) {
			if(movies[i]!=null&&movies[i].getGenre().contains(genre)) {
				temp[i] = movies[i];
			}
		}
		return temp;
	}

	public void delete(String title) {
		boolean success = false;

		//여기는 향상된 for문 쓰면 안됨 Car c는 임시값이기 때문
		for(int i = 0; i<movies.length; i++) {
			if(movies[i]!=null && movies[i].getTitle().equals(title)) {
				movies[i] = null;
				success = true;
				System.out.println(title+" 을 삭제했습니다.");
			}
		}

		if(success) {
			for(int i=0; i<movies.length-1; i++) {
				if(movies[i]==null) {
					movies[i] = movies[i+1];
					movies[i+1] = null;
				}
			}
		}
	}

	public int getSize() {
		for(Movie m : movies) {
			if(m!=null) {
				size++;
			}
		}
		return size;
	}
}
