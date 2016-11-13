
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextWindowLine extends TextWindow {
	TextField textField;
	
	public TextWindowLine(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	//TextField textField;
		
		setTitle(title);
		textField = new TextField("Input text...", 40);
		textField.setBackground(Color.white);
		panelTop.remove(text);
		panelTop.add(textField);
		textField.setVisible(true); 
	}
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Object source = event.getSource();
		if (source == button1)
			this.dispose();
		else if (source == button2){
		
		   JFileChooser fileChooser = new JFileChooser();
		   FileNameExtensionFilter filter = new FileNameExtensionFilter(
				    "TXT files", "txt");
		   fileChooser.setDialogTitle("Specify a file to save");   
		   fileChooser.setFileFilter(filter);
		   
		   int userSelection = fileChooser.showSaveDialog(container);
		   
		   if (userSelection == JFileChooser.APPROVE_OPTION) {
		       File fileToSave2 = fileChooser.getSelectedFile();
		       try {
		    	   fileToSave2.createNewFile();
		    	   PrintWriter write2 =new PrintWriter(fileToSave2);
					write2.println(textField.getText());
		   			write2.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       System.out.println("Save as file: " + fileToSave2.getAbsolutePath());
		   }
	}
	
	}
}
	
	
	
	
	
	

	
