package car_sales_fInal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Random;

public class Vehicle  extends JFrame {
	private JPanel account, car, options, addOns, printOut, grandTotal, payment, submit, exit;
	private JLabel accountnum, name, address, phone,tradeIn;
	private JLabel tradeInLabel, packageLabel,metallicPaintLabel,CashDiscountLabel,basePriceLabel, finaceInterestLabel;
	private JLabel subTotalLabel, taxLabel, grandTotalLabel, title_n_TagsLabel;
	private JButton packageA, packageB,submitB, exitB; 
	private JTextField accountbox, namebox, addressbox, phonebox; 
	private JTextField tradeValue, packages, metalicPaint, cashPaymentDiscount,basePriceText; 
	private JTextField TradeInValueBox, taxBox, subTotalBox, finaceInterestbox, grandTotalBox, title_n_TagsBox;
	private JRadioButton S40,S60, S70, S80;
	private JCheckBox paint, cashPayment, financing;
	private ButtonGroup model, typeOfPay;
	final public float TAX = 0.06f, FINANCE = 0.07f, TITLETAG = 325.0f, CASHDISCOUNT= 750.f, PAINT = 650.f;
	private float total= 0.0f, s40=0.0f, gradTotalVariable=0.0f;
	private float sub=0.0f;
	// flags to prevent double adding
	public boolean SelectedPackageA = false;
	public boolean SelectedPackageB = false;
	public boolean SelectedPaint = false;
	public boolean SelectedCashPayment = false;
	public boolean SelectedFinance = false;
	
	// store current trade in value
	public float TradeInValue = 0.00f;
	
	
	 public Vehicle () {
		account = new JPanel();
		//account.setBackground(new Color(19,126,217));
		car = new JPanel();
		//car.setBackground(new Color(19,126,217));
		options = new JPanel();
		//options.setBackground(new Color(19,126,217));
		addOns = new JPanel();
		//addOns.setBackground(new Color(19,126,217));
		printOut = new JPanel();
		//printOut.setBackground(new Color(19,126,217));
		grandTotal = new JPanel();
		//grandTotal.setBackground(new Color(19,126,217));
		payment = new JPanel();
		//payment.setBackground(new Color(19,126,217));
		submit = new JPanel();
		exit = new JPanel();
		
		Random rn = new Random();
		int number = rn.nextInt(50000) + 1;
		 
		accountnum = new JLabel("Customer Account Number: ");
		name = new JLabel("Customer Name: ");
		address= new JLabel("Customer Address: ");
		phone = new JLabel("Customer Phone Number: ");
		accountbox = new JTextField( Integer.toString(number));
		accountbox.setEditable(false);
		namebox = new JTextField(15);
		addressbox = new JTextField(25);
		phonebox = new JTextField(10);
		this.setLayout(new FlowLayout());
		account.setLayout(new GridLayout(4,1));
		options.setLayout(new GridLayout(4,2));
		printOut.setLayout(new GridLayout(9,1));
		grandTotal.setLayout(new GridLayout(1,1));
		//submit.setLayout(new GridLayout(1,1));
		//exit.setLayout(new GridLayout(1,1));
		car.setBorder(BorderFactory.createTitledBorder("Car Models"));
		addOns.setBorder(BorderFactory.createTitledBorder("Car Add-Ons"));
		printOut.setBorder(BorderFactory.createTitledBorder("Your Package Includes: "));
		grandTotal.setBorder(BorderFactory.createTitledBorder("Your Package Grand Total Is: "));
		S40 = new JRadioButton("Model S40 Base Price: $ 27700");
		S60 = new JRadioButton("Model S60 Base Price: $ 32500");
		S70 = new JRadioButton("Model S70 Base Price: $ 36000");
		S80 = new JRadioButton("Model S80 Base Price: $ 44000");
		paint = new JCheckBox ("Metallic Paint Cost: $650");
		cashPayment = new JCheckBox ("Cash Payment Discount $750");
		financing = new JCheckBox ("Financing for Car 7% ");
		tradeIn = new JLabel ("       Car Trade in Value:  -");
		tradeValue = new JTextField(10);
		model = new ButtonGroup();
		model.add(S40);
		S40.addActionListener(new CarListener());
		model.add(S60);
		S60.addActionListener(new CarListener());
		model.add(S70);
		S70.addActionListener(new CarListener());
		model.add(S80);
		S80.addActionListener(new CarListener());
		options.setBorder(BorderFactory.createTitledBorder("Packages"));
		addOns.setLayout(new GridLayout(1,3));
		packageA = new JButton("Package A price: $2200");
		packageB = new JButton("Package B price: $3250");
		submitB = new JButton("Submit");
		submitB.addActionListener(new submitListener());
		exitB = new JButton("EXIT");
		exitB.addActionListener(new ExitListener());
		
		
		car.setLayout(new GridLayout(5,0));
		
		
		account.add(accountnum);
		account.add(accountbox);
		account.add(name);
		account.add(namebox);
		namebox.addActionListener(new CarListener());
		account.add(address);
		account.add(addressbox);
		addressbox.addActionListener(new CarListener());
		account.add(phone);
		account.add(phonebox);
		phonebox.addActionListener(new CarListener());
		
		car.add(S40);
		S40.addActionListener(new carButtonListener());
		car.add(S60);
		S60.addActionListener(new carButtonListener());
		car.add(S70);
		S70.addActionListener(new carButtonListener());
		car.add(S80);
		S80.addActionListener(new carButtonListener());
		
		options.add(packageA);
		packageA.addActionListener(new carpackageListener());
		options.add(packageB);
		packageB.addActionListener(new carpackageListener());

		
		addOns.add(paint);
		paint.addActionListener(new carAddOnListener());
		addOns.add(tradeIn);
		addOns.add(tradeValue);
		tradeValue.addActionListener(new carAddOnListener());
		
		typeOfPay = new ButtonGroup();
		typeOfPay.add(cashPayment);
		cashPayment.addActionListener(new typeOfPayListener());
		typeOfPay.add(financing);
		financing.addActionListener(new typeOfPayListener());
		payment.setBorder(BorderFactory.createTitledBorder("Type Of Payment"));
		payment.add(cashPayment);
		payment.add(financing);
		
		
		tradeInLabel = new JLabel("Trade in: -");
		packageLabel = new JLabel("Package chosen: ");
		metallicPaintLabel = new JLabel("Metallic Paint: ");
		title_n_TagsLabel = new JLabel("Tags and Tile Price: ");
		CashDiscountLabel = new JLabel("Discount for Cash Payment: -");
		basePriceLabel = new JLabel("Base Price: ");
		subTotalLabel = new JLabel("Sub Total: ");
		taxLabel = new JLabel("Tax: ");
		finaceInterestLabel = new JLabel("Financing Interst : ");
				
		basePriceText = new JTextField(10);
		basePriceText.setEditable(false);
		packages = new JTextField(15);
		packages.setEditable(false);		
		metalicPaint = new JTextField(5);
		metalicPaint.setEditable(false);	
		title_n_TagsBox = new JTextField("$325");
		title_n_TagsBox.setEditable(false);	
		cashPaymentDiscount = new JTextField(10);
		cashPaymentDiscount.setEditable(false);
		TradeInValueBox = new JTextField(10);
		TradeInValueBox.setEditable(false);
		subTotalBox = new JTextField(10);
		subTotalBox.setEditable(false);
		taxBox = new JTextField(10);
		taxBox.setEditable(false);
		finaceInterestbox = new JTextField(10);
		finaceInterestbox.setEditable(false);
		
			
		printOut.add(basePriceLabel);
		printOut.add(basePriceText);
		printOut.add(packageLabel);
		printOut.add(packages);
		printOut.add(metallicPaintLabel);
		printOut.add(metalicPaint);
		printOut.add(title_n_TagsLabel);
		printOut.add(title_n_TagsBox);
		printOut.add(CashDiscountLabel);
		printOut.add(cashPaymentDiscount);
		printOut.add(tradeInLabel);
		printOut.add(TradeInValueBox);
		printOut.add(subTotalLabel);
		printOut.add(subTotalBox);
		printOut.add(taxLabel);
		printOut.add(taxBox);
		printOut.add(finaceInterestLabel);
		printOut.add(finaceInterestbox);
		
		grandTotalLabel = new JLabel("Total: ");
		
		submit.add(submitB);
		

		
		grandTotalBox = new JTextField(10);
		grandTotalBox.setEditable(false);
		grandTotal.add(grandTotalLabel);
		grandTotal.add(grandTotalBox);
		
		exit.add(exitB);
	
		
		add(account);
		add(car);
		add(options);
		add(addOns);
		add(payment);
		add(printOut);
		add(submit);
		add(grandTotal);
		add(exit);
		
		this.setSize(600,900);
		this.setTitle("Car Sales");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);;
		}
	 
private String String(int number) {
		// TODO Auto-generated method stub
		return null;
	}
private class CarListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(namebox)) {
			String str = namebox.getText();
			namebox.setText(str);
			namebox.setEditable(false);
		}	
		if (e.getSource().equals(addressbox)) {
			String str1 = addressbox.getText();
			addressbox.setText(str1);
			addressbox.setEditable(false);
	}	
		if (e.getSource().equals(phonebox)) {
			String str2 = phonebox.getText();
			phonebox.setText(str2);
			phonebox.setEditable(false);
	}	
	}
}
	private class carButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			if(e.getSource()== S40){
				float baseTT,baseT;
				packageB.setVisible(false);
				total = 27700;
				baseTT = total + TITLETAG;
				baseT= baseTT*TAX;
				//sub= baseTT+baseT;
				sub = total + TITLETAG;
				String subTax = String.format("%.2f",baseT);
				String subTotal = String.format("%.2f",sub);
				subTotalBox.setText(subTotal);
				String stringTotal = String.format("$%.2f",total);
				basePriceText.setText(stringTotal);
				taxBox.setText(subTax);
			
				//JOptionPane.showMessageDialog(null, total);
			}
				else if (e.getSource()== S60){
					float baseTT,baseT;
					packageB.setVisible(false);
					total = 32500;
					baseTT = total + TITLETAG;
					baseT= baseTT*TAX;
					//sub= baseTT+baseT;
					sub = total + TITLETAG;
					String subTax = String.format("%.2f",baseT);
					String subTotal = String.format("%.2f",sub);
					subTotalBox.setText(subTotal);
					String stringTotal = String.format("$%.2f",total);
					basePriceText.setText(stringTotal);
					taxBox.setText(subTax);

				}
				else if (e.getSource()== S70){
					float baseTT,baseT;
					packageB.setVisible(true);
					total = 36000;
					baseTT = total + TITLETAG;
					baseT= baseTT*TAX;
					//sub= baseTT+baseT;
					sub = total + TITLETAG;
					String subTax = String.format("%.2f",baseT);
					String subTotal = String.format("%.2f",sub);
					subTotalBox.setText(subTotal);
					String stringTotal = String.format("$%.2f",total);
					basePriceText.setText(stringTotal);
					taxBox.setText(subTax);
				}
				else if (e.getSource()== S80){
					float baseTT,baseT;
					packageB.setVisible(true);
					total = 44000;
					baseTT = total + TITLETAG;
					baseT= baseTT*TAX;
					//sub= baseTT+baseT;
					sub = total + TITLETAG;
					String subTax = String.format("%.2f",baseT);
					String subTotal = String.format("%.2f",sub);
					subTotalBox.setText(subTotal);
					String stringTotal = String.format("$%.2f",total);
					basePriceText.setText(stringTotal);
					taxBox.setText(subTax);
				}
			
		}
	}
	private class carpackageListener implements ActionListener{
		float packA = 2200;
		float packB = 3250;
		public void actionPerformed (ActionEvent e) {
			if(e.getSource()== packageA) {

				if (!SelectedPackageA) {
					sub+= packA;
					SelectedPackageA = true;					
				
					 if (SelectedPackageB) {
						sub -=packB;
						SelectedPackageB = false;						
					}
					String subTotal = String.format("%.2f",sub);
					subTotalBox.setText(subTotal);
					String stringTotal = String.format("$%.2f",packA);
					packages.setText(stringTotal);
					taxBox.setText(String.format("%.2f",(sub*TAX)));
					//JOptionPane.showMessageDialog(null, total);
				}
			}
			else if (e.getSource()== packageB){
				
				if (!SelectedPackageB) {
					sub+= packB;
					SelectedPackageB = true;					
				
					 if (SelectedPackageA) {
						sub -=packA;
						SelectedPackageA = false;						
					}
					
						sub+=packB;
						String subTotal = String.format("%.2f",sub);
						subTotalBox.setText(subTotal);
						String stringTotal = String.format("$%.2f",packB);
						packages.setText(stringTotal);
						taxBox.setText(String.format("%.2f",(sub*TAX)));
						//JOptionPane.showMessageDialog(null, total);
				}

			}
		}
	}
	private class carAddOnListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			if(e.getSource()== paint ){
				if (!SelectedPaint) {
					sub+= PAINT;
					String subTotal = String.format("%.2f",sub);
					subTotalBox.setText(subTotal);
					String stringTotal = String.format("$%.2f", PAINT);
					metalicPaint.setText(stringTotal);
					taxBox.setText(String.format("%.2f",(sub*TAX)));
					//JOptionPane.showMessageDialog(null, total);
					SelectedPaint = true;
				}

			}
			if(e.getSource()== tradeValue ){
					String str2 = tradeValue.getText();
					String currentSub= subTotalBox.getText();
					//to validate the input on the box is only a number, and clears the field
					try {
						float str3 = Float.parseFloat(str2);	
						TradeInValueBox.setText(str2);
						float sub1= Float.valueOf(currentSub);
						float subT = sub1 - str3 + TradeInValue;
						TradeInValue = str3;
						String subTotal2 = String.format("%.2f",subT);
						taxBox.setText(String.format("%.2f",(subT*TAX)));
						subTotalBox.setText(subTotal2);
					} catch (NumberFormatException ex) { 
						JOptionPane.showMessageDialog(null,"Input must be a number!");
						tradeValue.setText("");
					    
					}

			}
		}
		
			}
			
	private class typeOfPayListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			if(e.getSource()== cashPayment){
				if (!SelectedCashPayment) {
					try {
					String stringTotal = String.format("$%.2f",CASHDISCOUNT);
					cashPaymentDiscount.setText(stringTotal);
					String currentSub= subTotalBox.getText();
					float sub1= Float.valueOf(currentSub);
					sub = sub1 - CASHDISCOUNT;
					String subTotal = String.format("%.2f",sub);
					subTotalBox.setText(subTotal);
					taxBox.setText(String.format("%.2f",(sub*TAX)));
					finaceInterestbox.setText(null);
					SelectedCashPayment = true;
					SelectedFinance = false;
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null,"Must select car before selecting payment option");
						cashPaymentDiscount.setText(null);
						//cashPayment.setSelected(false);
						//Clears the check box after the message that is not allow it
						typeOfPay.clearSelection();
					}
				}
			}
				else if (e.getSource()== financing){
					if (!SelectedFinance) {
						try {
							String currentSub= subTotalBox.getText();
							String currentTax= taxBox.getText();
							float sub3= Float.valueOf(currentSub);
							float tax3= Float.valueOf(currentTax);
							float subPlusTax= sub3 + tax3;
							float financeInt = subPlusTax *FINANCE;
							String stringTotal = String.format("%.2f",financeInt);
							finaceInterestbox.setText(stringTotal);
							cashPaymentDiscount.setText(null);	
							SelectedFinance = true;
							SelectedCashPayment = false;
						}
						catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"Must select car before selecting payment option");
							finaceInterestbox.setText(null);
							//financing.setSelected(false);
							//Clears the check box after the message that is not allow it
							typeOfPay.clearSelection();
						}
					}
				}
		}
		}

	private class submitListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			if(e.getSource()== submitB) {
				//float interest = 0.0f;
				float sub3= 0.0f;
				float tax3= 0.0f;
				float interest= 0.0f;
				
				if (!subTotalBox.getText().isEmpty()) {
					sub3 = Float.valueOf(subTotalBox.getText());
				}

				if (!taxBox.getText().isEmpty()) {
					tax3 = Float.valueOf(taxBox.getText());
				}
				
				if (!finaceInterestbox.getText().isEmpty()) {
					interest = Float.valueOf(finaceInterestbox.getText());
				}
				
				
					float grandTotal = sub3+tax3+interest ;
					String stringTotal = String.format("%.2f",grandTotal);
					grandTotalBox.setText(stringTotal);
					System.out.println(grandTotal);
					
				
			}
		}
	}
		private class ExitListener implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				if(e.getSource()== exitB) {
				System.exit(0);
				}
			}
		}


		
public static void main(String[] args) 
	{
		 new Vehicle();
	}
}