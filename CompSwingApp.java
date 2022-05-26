package CompLab;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import java.util.*;

public class CompSwingApp extends JFrame implements ActionListener{
	//Buttons
	JButton btnPlus = new JButton("+");
	JButton btnExit = new JButton("ExitApp");
	JButton btnView = new JButton("Show Computers");
	JButton btnClear = new JButton("Clear");
	//Labels
	JLabel lblValue = new JLabel("Value");
	JLabel lblIPAdress = new JLabel("IP Adress");
	JLabel lblComputerLab = new JLabel("Computer Lab");
	JLabel lblBlank = new JLabel(" ");
	//Text fields
	JTextField txtIPAddress = new JTextField(10);
	JTextField txtValue = new JTextField(10);
	JTextField txtResults = new JTextField(10);
	
	//Arraylist
	private ArrayList<Computer> computers = new ArrayList();
	
	public CompSwingApp()
	{
		super("Lab App");
		setLayout(new GridLayout(5,2,2,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		//Arranging Swing
		add(lblComputerLab);
		add(lblBlank);
		
		add(lblIPAdress);
		add(txtIPAddress);
		
		add(lblValue);
		add(txtValue);
		
		add(btnPlus);
		add(btnView);
		
		add(btnClear);
		add(btnExit);
	
		//add(lblResult);
		//add(txtResults);
		btnPlus.addActionListener(this);
		
		btnExit.addActionListener(this);
		
		btnClear.addActionListener(this);
		
		btnView.addActionListener(this);
		
		pack();
	}
	// Functions to display the contents of the arrayList
	public void showComputers() {
		Computer displayComputers =  new Computer();
		String value, IPAddress = null;
		String output = "";
		
		for(int index = 0; index <computers.size(); index++) {
			displayComputers = computers.get(index);
			IPAddress = displayComputers.getIP();
			value = displayComputers.getValue();
			output += IPAddress + " " + value + "\n";
		}
		JOptionPane.showMessageDialog(this, output);
		
	}
	//Clear text fields
	public void Clear()
	{
	txtIPAddress.setText(null);
	txtValue.setText(null);
	}
	@Override //annotation
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source==btnPlus)
		{
		Computer xx = new Computer();
		//String IPAdress = txtIPAddress.getText();
		//String Value = txtValue.getText();
		xx.setIP(txtIPAddress.getText());
		xx.setValue(txtValue.getText());
		computers.add(xx);
		
		//txtResult.setText(results.toString())
		JOptionPane.showMessageDialog(null,"Computer inserted ");
		//Clear();
		}
		if(source==btnView)
		{	
			//JOptionPane.showMessageDialog(this,computers);
			showComputers();
		}
		if(source==btnExit)
		{
		 System.exit(0);
		}
		if(source==btnClear)
		{	
		 Clear();
		}
	 
	}
	public static void main(String[] args) {
		new CompSwingApp();
	}
}

class Computer{
	private String IP_Adress;
	private String Value;
	Computer(){
		IP_Adress = null;
		Value = null;
	}
	
	public void setIP(String IP_Address) {
		this.IP_Adress = IP_Address;
	}
	
	public void setValue(String Value) {
		this.Value = Value;
	}
	
	public String getIP(){
		return IP_Adress;
	}
	
	public String getValue(){
		return Value;
	}
	
}
