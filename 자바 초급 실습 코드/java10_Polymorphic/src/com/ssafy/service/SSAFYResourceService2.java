package com.ssafy.service;

import com.ssafy.child.Instructor;
import com.ssafy.child.Manager;
import com.ssafy.child.Student;
import com.ssafy.parent.SSAFYResource;

public class SSAFYResourceService2 {

	
	public void ssafyManage(SSAFYResource ssafy) {
		
		if(ssafy instanceof Instructor) { 
			((Instructor)ssafy).changeSubject("자바");
			
			
		}else if(ssafy instanceof Manager) {
			((Manager) ssafy).changeDept("마케팅부");
		}
		
		
		
	    	System.out.println(ssafy);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
