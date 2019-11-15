package edu.jaen.java.xml.sax;
/*
 * result.xml에서 반복되는 내용이 들어있는 엘러먼트를 찾아라
 * CheckList > Check 엘러먼트...
 * 하나의 도메일 --- 엔터티가 된다.
 * :
 * 그러니깐
 * 서버상에 올라와있는 xml문서를 읽어들여서
 * DomParser...
 * 읽어들인 데이타를 VO 객체인 Check에 저장
 * 저장된 내용을 main에서 확인하는 로직이다.
 */
public class Check {
		private String code;
		private String date;
		private String clean;
		private String ready;
		private String response;
		private String request="";
		
		
		public Check() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Check(String code, String date, String clean, String ready,
				String response) {
			super();
			this.code = code;
			this.date = date;
			this.clean = clean;
			this.ready = ready;
			this.response = response;
		}
		public Check(String code, String date, String clean, String ready,
				String response, String request) {
			super();
			this.code = code;
			this.date = date;
			this.clean = clean;
			this.ready = ready;
			this.response = response;
			this.request = request;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getClean() {
			return clean;
		}
		public void setClean(String clean) {
			this.clean = clean;
		}
		public String getReady() {
			return ready;
		}
		public void setReady(String ready) {
			this.ready = ready;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public String getRequest() {
			return request;
		}
		public void setRequest(String request) {
			this.request = request;
		}
		public String toString(){
			return code+"\t: "+date+"\t: "
			+clean+"\t: "+ready+"\t: "+response+"\t: "+request;
		}

}
