
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Awt extends Frame implements ActionListener, WindowListener, ItemListener{
	Button button1, button2, button3, button4, button5; 
	Checkbox checkFile, checkImage;
	TextField textField1,textField2;
	Label label1, label2, label3,label4;
	List list;
	Choice choice;
	Container container;
	Panel panelTop,panelLeftup,panelLeftdown,panelLeft,panelRight,panelRightup,panelRightdown,panelCenter, panelBottom;

	public Awt() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		setBounds(300,500,400,300);
		setVisible(true);
		this.addWindowListener(this);
		
		button1 = new Button("EXIT");
		button1.setBounds(20, 20, 200, 300); // setting dimensions of button 
		button1.setBackground(Color.BLUE);
		button1.addActionListener(this);
		button1.setVisible(true); //setting visibility
		
		button2 = new Button("Create textBOX file");
		button2.addActionListener(this);
		button2.setVisible(true); 
		
		button3 = new Button("Create textLINE file");
		button3.addActionListener(this);
		button3.setVisible(true); 

		button4= new Button("zoom ++");
		button4.addActionListener(this);
		button4.setVisible(true); 
		
		button5= new Button("zoom --");
		button5.addActionListener(this);
		button5.setVisible(true); 
		
		checkFile = new Checkbox();
		checkFile.addItemListener(this);
		checkFile.setVisible(true);
		
		checkImage = new Checkbox();
		checkImage.addItemListener(this);
		checkImage.setVisible(true); 
	
		textField1 = new TextField("New name");
		textField1.setForeground(Color.YELLOW);
		textField1.setBounds(20, 20, 100, 100); // setting dimensions of button 
		textField1.setBackground(Color.BLUE);
		textField1.setVisible(true); //setting visibility
		
		textField2 = new TextField("New name");
		textField2.setBounds(20, 20, 100, 100); // setting dimensions of button 
		textField2.setBackground(Color.GREEN);
		textField2.setVisible(true); //setting visibility
		
		label1 = new Label("label");
		label1.setText("MENU");
		label1.setSize(200,300);
		label1.setVisible(true); //setting visibility
		
		label2 = new Label("label");
		label2.setText("New text BOX file");
		label2.setVisible(true); //setting visibility
		
		label3= new Label("label3");
		label3.setText("New texT LINE file");
		label3.setVisible(true); //setting visibility
		
		label4= new Label();
		label4.setVisible(true); //setting visibility
	
		list = new List(3);
		list.add("BLACK");list.add("GREEN"); list.add("YELLOW");
		list.setBounds(20, 20, 200, 200); // setting dimensions of button 
		list.addItemListener(this);
		list.setVisible(true); //setting visibility
		
		choice = new Choice();
		choice.add("Background: WHITE");
		choice.add("Background: RED");
		choice.add("Background: GRAY");
		choice.addItemListener(this);
		choice.setVisible(true);
		 
		panelTop = new Panel();
		panelTop.add(label1);
		panelTop.add(label4);
		panelTop.add(list);
		panelTop.add(choice);
		panelTop.setLayout(new  GridLayout(2,2));
		panelTop.setVisible(true);
		
		panelLeftup = new Panel();
		panelLeftup.add(checkFile);
		panelLeftup.add(label2);
		panelLeftup.setLayout(new FlowLayout());
		panelLeftup.setVisible(true); //setting visibility
		
		panelLeftdown = new Panel();
		panelLeftdown.add(checkImage);
		panelLeftdown.add(label3);//panelLeft.add(button3);
		panelLeftdown.setLayout(new FlowLayout());
		panelLeftdown.setVisible(true); //setting visibility
		
		panelLeft = new Panel();
		panelLeft.add(panelLeftup);
		panelLeft.add(panelLeftdown);
		panelLeft.setLayout(new GridLayout(2,1));
		panelLeft.setVisible(true); //setting visibility
		
		panelRightup = new Panel();
		panelRightup.add(textField1);
		panelRightup.add(button2);
		panelRightup.setLayout(new GridLayout());
		panelRightup.setVisible(false); //setting visibility
	
		panelRightdown = new Panel();
		panelRightdown.add(textField2);
		panelRightdown.add(button3);
		panelRightdown.setLayout(new GridLayout());
		panelRightdown.setVisible(false); //setting visibility
	
		panelRight = new Panel();
		panelRight.add(panelRightup);
		panelRight.add(panelRightdown);
		panelRight.setLayout(new GridLayout(2,1));
		panelRight.setVisible(true);
		
		panelCenter = new Panel();
		panelCenter.setBackground(Color.LIGHT_GRAY);
		panelCenter.add(panelLeft);
		panelCenter.add(panelRight);
		panelCenter.setLayout(new GridLayout(1,2));
		panelCenter.setVisible(true);
		
		panelBottom = new Panel();
		panelBottom.add(button4);
		panelBottom.add(button5);
		panelBottom.add(button1);
		panelBottom.setLayout(new GridLayout(3,1));
		panelBottom.setVisible(true);

		container = new Container();
		container.add(panelTop);
		container.add(panelCenter);
		container.add(panelBottom);
		container.setLayout(new GridLayout(3,1));
		add(container);	
		container.setVisible(true);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Awt window = new Awt();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Object source = event.getSource();
		
		 if (source == button1)
			 System.exit(0);
		 else if (source == button2){
				TextWindow tw = new TextWindow(textField1.getText());
		 }
		 else if (source == button3){
			 TextWindowLine twl = new TextWindowLine(textField2.getText());
		 }
		 else if (source == button2)
			 setBounds(getX(),getY(),getWidth()+100,getHeight()+100);
		 else if (source == button4)
		 setBounds(getX(),getY(),getWidth()+100,getHeight()+100);
		 else if (source == button5)
			 setBounds(getX(),getY(),getWidth()-100,getHeight()-100);
	}
	
	public void itemStateChanged(ItemEvent e) {  
	    Object source = e.getItemSelectable();

	    if (source == checkFile){
	    		panelRightup.setVisible(true);
	    		checkFile.setBackground(Color.BLUE);
	    		}
	    else if (source == checkImage){
	    	panelRightdown.setVisible(true);
	    	checkImage.setBackground(Color.GREEN);
	    		}
	    else if (source == list){
	    	if (list.getSelectedItem()==null)
	    		label4.setText("WYBRANY KOLOR: BRAK");
	    	else
	    	label4.setText("WYBRANY KOLOR: "+list.getSelectedItem());
	    		}
	    
	    else if (choice.getSelectedItem()=="Background: WHITE")
	    		label4.setBackground(Color.WHITE);
	    else if (choice.getSelectedItem()=="Background: GRAY")
				label4.setBackground(Color.GRAY);
	    else if (choice.getSelectedItem()=="Background: RED")
	    		label4.setBackground(Color.RED);
	   
	if (e.getStateChange() == ItemEvent.DESELECTED){
		if (source == checkFile)
    		panelRightup.setVisible(false);
		 else if (source == checkImage)
		    	panelRightdown.setVisible(false);
				}
	}
	

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		 System.exit(0);	

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
