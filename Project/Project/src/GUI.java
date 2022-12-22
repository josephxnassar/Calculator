import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Dictionary;
import java.util.function.Function;
import java.math.BigDecimal;

public class GUI implements ActionListener
{
	Operator o;

	// Declaration of members
	JFrame frame; // window
	JPanel panel; // Used for laying out buttons
	JTextField textBox; // Main display window that displays numbers
	JButton[] numberButtons = new JButton[10]; // JButton array for numbers
	JButton[] functionButtons = new JButton[12]; // JButton array for functions
	JButton addButton, subButton, mulButton, divButton, powButton, sqrButton; // Arithmetic functions
	JButton decButton, negButton, equButton, delButton, precUp, precDown; // Additional functions
	
	// Font 
	Font numbersFont = new Font("Helvetica", Font.BOLD, 30);
	Font functFont = new Font("Arial", Font.PLAIN, 30);
	
	// FOR ARITHMETIC
	double num1 = 0.0, num2 = 0.0, result = 0.0;
	int precision = 3;
	
	GUI()
	{
		// Window settings
		frame = new JFrame("422 Electrical Calculator");
		frame.setSize(500, 650);
		frame.setLayout(null); // Going to use a panel for layout of buttons
		frame.setResizable(false); // Can't resize
		frame.getContentPane().setBackground(new Color(210,239,245)); // set background color
		
		// Panel for layout
		panel = new JPanel();
		panel.setBounds(25,100,430,430); // set size
		panel.setLayout(new GridLayout(6,4,10,10)); // set grid layout
		//panel.setBackground(Color.black); // set background color
		panel.setBackground(new Color(210,239,245));
		
		// Textbox
		textBox = new JTextField();
		textBox.setBounds(25,25,430,60);
		textBox.setFont(numbersFont);
		textBox.setEditable(false); //User can't edit text box
		textBox.setHorizontalAlignment(JTextField.RIGHT);
		textBox.setBackground(Color.WHITE);
		
		// Function buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		powButton = new JButton("^");
		sqrButton = new JButton("sqr.");
		decButton = new JButton(".");
		equButton = new JButton("=");
		negButton = new JButton("neg.");
		delButton = new JButton("C");
		precUp = new JButton("+P");
		precDown = new JButton("-P");
	
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = powButton;
		functionButtons[5] = sqrButton;
		functionButtons[6] = decButton;
		functionButtons[7] = equButton;
		functionButtons[8] = negButton;
		functionButtons[9] = delButton;
		functionButtons[10] = precUp;
		functionButtons[11] = precDown;
		
		// Adding  number buttons to array and declaring fields.
		for(int i = 0; i<10;i++)
		{
			numberButtons[i] = new JButton(String.valueOf(i)); // 0-9 
			numberButtons[i].addActionListener(this); // for clicking on number
			numberButtons[i].setFocusable(false); // no highlight when user clicks on button
			numberButtons[i].setFont(numbersFont);
			numberButtons[i].setForeground(Color.BLACK);
			numberButtons[i].setBackground(Color.WHITE);
		}
		
		// Adding function buttons to array and declaring certain fields such as font, action listener etc.
		for(int i = 0; i < 12; i++)
		{
			functionButtons[i].setFont(functFont);
			functionButtons[i].addActionListener(this); // user selects function
			functionButtons[i].setFocusable(false); // no highlight when user clicks on button
			functionButtons[i].setForeground(Color.BLACK);
			functionButtons[i].setBackground(Color.WHITE);
		}
		
		equButton.setBackground(new Color(37, 176, 255));
		
		// add to panel layout
		panel.add(powButton);
		panel.add(sqrButton);
		panel.add(negButton);
		panel.add(delButton);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(equButton);
		panel.add(divButton);
		
		panel.add(precUp);
		panel.add(precDown);
		
		// Add everything to frame(window)
		frame.add(panel); // add buttons
		frame.add(textBox); // add textbox
		frame.setVisible(true); // show window
		
	}

	// For selecting and displaying numbers
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// NUMBERS
		for(int i = 0; i < 10; i++)
		{
			if(e.getSource() == numberButtons[i])
			{
				textBox.setText(textBox.getText().concat(String.valueOf(i)));
			}
		}

		// ADDITION
		if (e.getSource() == addButton)
		{
			if (num1 == 0) {
				num1 = Double.parseDouble(textBox.getText());
			}
			else {
				num1 += Double.parseDouble(textBox.getText());
			}
			o = new Add();
			textBox.setText("");
		}

		// SUBTRACTION
		else if (e.getSource() == subButton)
		{
			if (num1 == 0) {
				num1 = Double.parseDouble(textBox.getText());
			}
			else {
				num1 += Double.parseDouble(textBox.getText());
			}			
			o = new Sub();
			textBox.setText("");
		}

		// MULTIPLICATION
		else if (e.getSource() == mulButton)
		{
			if (num1 == 0) {
				num1 = Double.parseDouble(textBox.getText());
			}
			else {
				num1 += Double.parseDouble(textBox.getText());
			}			
			o = new Mul();
			textBox.setText("");
		}

		// DIVISION
		else if (e.getSource() == divButton)
		{
			if (num1 == 0) {
				num1 = Double.parseDouble(textBox.getText());
			}
			else {
				num1 += Double.parseDouble(textBox.getText());
			}			
			o = new Div();
			textBox.setText("");
		}

		// POWER
		else if (e.getSource() == powButton)
		{
			if (num1 == 0) {
				num1 = Double.parseDouble(textBox.getText());
			}
			else {
				num1 += Double.parseDouble(textBox.getText());
			}			
			o = new Pow();
			textBox.setText("");
		}

		// SQUAREROOT
		else if (e.getSource() == sqrButton)
		{
			if (num1 == 0) {
				num1 = Double.parseDouble(textBox.getText());
			}
			else {
				num1 += Double.parseDouble(textBox.getText());
			}			
			o = new Sqrt();
			textBox.setText("");
		}
		
		//NEGATIVE
		else if(e.getSource() == negButton)
		{
			o = new Neg();
		}
		
		//PRECISION UP BUTTON
		else if(e.getSource() == precUp) {
			precision += 1;
		}
		
		//PRECISION DOWN BUTTON
		else if(e.getSource() == precDown) {
			precision -= 1;
		}
		
		// EQUALS
		if(e.getSource() == equButton) 
		{
			// If op only requires one num, second value is set to 0
			if (textBox.getText().isEmpty()) {
				num2 = 0.0;
			}
			else {
				num2 = Double.parseDouble(textBox.getText());
			}
			
			//Precision is set to 3 automatically the user can change the precision with the up and down button.
			BigDecimal b = (new BigDecimal(o.Evaluate(num1, num2)).setScale(precision, RoundingMode.HALF_UP));
			result = b.doubleValue();
			textBox.setText(b.toString());
			System.out.print(textBox.getText() + "\n");
			num1 = 0;
		}

		if (e.getSource() == delButton)
		{
			num1 = 0; num2 = 0;
			textBox.setText("");
		}
	}

	// FOR INTEGRATION TESTING
	/* 
	Because GUI uses user inputs and prints results to screen
	we have to refactor to automatically test logic.
	*/ 
	// operator = op that is being tested i.e. a = addition, s = subtraction, 
	public static double[] doMain(double number1)
	{
		Add add = new Add();
		Sub sub = new Sub();
		Mul mul = new Mul();
		Div div = new Div();
		Pow pow = new Pow();
		Sqrt sqrt = new Sqrt();
		Neg neg = new Neg();

		double[] result = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};

		result[0] = add.Evaluate(number1-1, 1.0);
		result[1] = sub.Evaluate(number1, 1.0);
		result[2] = mul.Evaluate(number1, 2.0);
		result[3] = div.Evaluate(number1, 2.0);
		result[4] = pow.Evaluate(number1, 2.0);
		result[5] = sqrt.Evaluate(number1, 2.0);
		result[6] = neg.Evaluate(number1, 0.0);

		return result;
	}

	public static double[] doMainIntegration(double number1)
	{
		Add add = new Add();
		Sub sub = new Sub();
		Mul mul = new Mul();
		Div div = new Div();
		Pow pow = new Pow();
		Sqrt sqrt = new Sqrt();
		Neg neg = new Neg();

		double[] result = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};

		result[0] = add.Evaluate(number1, 1.0);
		result[1] = sub.Evaluate(result[0], 1.0);
		result[2] = mul.Evaluate(result[1], 2.0);
		result[3] = div.Evaluate(result[2], 2.0);
		result[4] = pow.Evaluate(result[3], 2.0);
		result[5] = sqrt.Evaluate(result[4], 2.0);
		result[6] = neg.Evaluate(result[5], 0);

		return result;
	}

	public double getResultDouble()
	{
		return result;
	}

	public String getResultString()
	{
		return textBox.getText();
	}
}
