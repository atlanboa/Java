package gui.client;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ButtonHandler implements ActionListener {
	ChattingService service;
	
	public ButtonHandler(ChattingService service){
		this.service = service;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼 클릭하면 FileDilog 창 떠서 , 어떤 경로에 어떤 출력용파일에 저장할지를..
		FileDialog fd = new FileDialog(service.f, "SAVE", FileDialog.SAVE);
		fd.setVisible(true);		
		String fileName=fd.getDirectory()+fd.getFile();
		try {
			fileWriting(fileName);
		}catch(IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
	public void fileWriting(String path)throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));		
		bw.write(service.ta.getText());
		bw.newLine();
		bw.close();
	}
}










