
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextWindow extends Awt {
	
	TextArea text;
	
	public TextWindow(String title) throws HeadlessException {
		
		super();
		setTitle(title);
		text = new  TextArea("Input text...", 5, 40);
		text.setVisible(true); //setting visibility
		
		panelTop = new Panel();
		panelTop.add(text);
		panelTop.setLayout(new GridLayout());
		
		button2 = new Button("SAVE");
		button2.addActionListener(this);
		button2.setVisible(true); 
		
		panelBottom = new Panel();
		panelBottom.add(button2);
		panelBottom.add(button1);
		panelBottom.setLayout(new GridLayout());
		
		container = new Container();
		container.add(panelTop);
		container.add(panelBottom);
		container.setLayout(new GridLayout(2,1));
		add(container);	
		container.setVisible(true);
	}

	@Override
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
			       File fileToSave = fileChooser.getSelectedFile();
			       try {
			    	   fileToSave.createNewFile();
			    	   PrintWriter write =new PrintWriter(fileToSave);
			   			write.println(text.getText());
			   			write.close();
	
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       System.out.println("Save as file: " + fileToSave.getAbsolutePath());
			   }
			}
		}
	
	/*
	
	public void WrtieToFile() throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter write = new PrintWriter(this.getTitle()+".txt");
		write.println(text.getText());
		write.close();			
	}
	*/
	
}
	

