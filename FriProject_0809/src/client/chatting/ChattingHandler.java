package client.chatting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChattingHandler implements ActionListener {
	ChattingService service;
	
	public ChattingHandler(ChattingService service){
		this.service = service;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=service.tf.getText();
		
		service.tf.requestFocus();
		service.pw.println("["+service.nickName+"] "+msg);
		service.tf.setText("");
		
		try {
			service.threadGo();
		}catch(Exception e1) {
			System.out.println(e1.getMessage());
		}

	}
}








