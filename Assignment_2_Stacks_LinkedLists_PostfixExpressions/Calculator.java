/**
 * Calculator.java
 * @version 1.0
 * @author Michael Levy (?1997)
 * @version 2.0 
 * @author Bette Bultena (2016)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The CalculatorPanel is the GUI that allows a user
 * to simulate use of a real calculator (with simple arithmetic).
 * Input to the calculator can be by clicking buttons or by input from the keyboard.
 */
public class Calculator extends JPanel implements ActionListener, KeyListener {
	private static final int BUTTON_SIZE = 30;
	private static final int WIDTH = 240;
	private static final int HEIGHT = 390;

	private GridBagLayout layout;
	private GridBagConstraints gbc;

	private JButton[] numbers;
	private JButton[] ops;
	private JButton[] extras;

	private JTextField textField = new JTextField(30);
	private Memory memory;

	/**
	 * Initializes and lays out the Calculator panel.
	 */
	public Calculator() {
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		layout = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;

		JPanel keys = new JPanel();
		keys.setLayout(layout);
		numbers = new JButton[10];
		for (int i=0; i<10; i++) {
			numbers[i] = new JButton(""+i);
			numbers[i].addActionListener(this);
			numbers[i].addKeyListener(this);
		}
		String[] names = {"^","/","*","-","+","="};
		ops = new JButton[names.length];
		for (int i=0; i<ops.length; i++) {
			ops[i] = new JButton(names[i]);
			ops[i].addActionListener(this);
			ops[i].addKeyListener(this);
		}
		String[] exNames = {"clear","(",")","back","."};
		extras = new JButton[exNames.length];
		for (int i=0; i<exNames.length; i++) {
			extras[i] = new JButton(exNames[i]);
			extras[i].addActionListener(this);
			extras[i].addKeyListener(this);
		}
		gbc.weightx = 0.5;
		gbc.weighty = 0.2;
		gbc.ipady = BUTTON_SIZE;
		gbc.ipadx = BUTTON_SIZE;
		int start = 0;
		for (gbc.gridy=4; gbc.gridy>1; gbc.gridy--) {
			for (gbc.gridx=0;gbc.gridx<3;gbc.gridx++) {
				keys.add(numbers[++start],gbc);
			}
		}
		gbc.gridy=0;
		for (gbc.gridx=0; gbc.gridx<3; gbc.gridx++) {
			keys.add(extras[gbc.gridx],gbc);
		}
		gbc.gridy++;
		gbc.gridx = 0;
		keys.add(extras[3],gbc);
		for (gbc.gridx=1; gbc.gridx<4; gbc.gridx++) {
			keys.add(ops[gbc.gridx-1],gbc);
		}
		gbc.gridy++;
		gbc.gridx = 3;
		keys.add(ops[3],gbc);
		gbc.gridy++;
		keys.add(ops[4],gbc);

		gbc.gridx = 2;
		gbc.gridy = 5;
		keys.add(extras[4],gbc);

		gbc.gridx = 0;
		gbc.gridwidth = 2;
		keys.add(numbers[0],gbc);
		gbc.gridwidth = 1;

		gbc.gridy--;
		gbc.gridx = 3;
		gbc.gridheight = 2;
		keys.add(ops[5],gbc);
		gbc.gridheight = 1;
		
		textField = new JTextField(30);
		textField.addKeyListener( this );
		textField.setFont(new Font("Courier",Font.PLAIN,24));
		textField.setFocusable(false);
		setLayout(new BorderLayout());
		add(textField,BorderLayout.NORTH);
		add(keys,BorderLayout.SOUTH);
		memory = new Memory();
		repaint();
	}

	/**
	 * Creates a frame to house the Calculator and renders it.
	 */
	public void showFrame() {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Displays the parameter in the calculator's text field.
	 * @param result the text to display
	 */
	public void showResult(String result) {
		textField.setText(result);
	}

	/**
	 * Processes the current character from the user input.
	 * @param key The key pressed or button clicked.
	 */
	public void process(char key) {
		switch (key) {
			case KeyEvent.VK_ENTER:
				try{
					double result = 0;
					try {
						result = Evaluator.evaluate(memory.getDisplay());
						memory.setDisplay(result);
					} catch (IllegalExpressionException e) {
						memory.setErrorMessage("INPUT ERROR");
					}
				} catch(Exception z){
                                	memory.setErrorMessage(z.toString());
                                }
				break;
			case KeyEvent.VK_BACK_SPACE:
				memory.removeChar();
				break;
			case KeyEvent.VK_ESCAPE:
				memory.clear();
				break;
			default:
				memory.addChar(key);
			break;
		}
		showResult(memory.getDisplay());
	}

	/**
	 * Call the click() method with the appropriate parameter.
	 * @param c the character of the button clicked resp. key pressed
	*/
	private void doClick(char c) {
		if(Character.isDigit(c)) {
			process(c);
			return;
		}
		switch(c) {
			case '^':
			case '.':
			case '+':
			case '-':
			case '*':
			case '/':
			case KeyEvent.VK_ENTER:
			case KeyEvent.VK_BACK_SPACE:
			case KeyEvent.VK_ESCAPE:
			case '(':
			case ')':
				process(c);
				break;
			case '=':
				process((char) KeyEvent.VK_ENTER);
				break;
			case 'b':
				process((char) KeyEvent.VK_BACK_SPACE);
				break;
			case 'c':
				process((char) KeyEvent.VK_ESCAPE);
				break;
		}
	}

	/**
	 * Process action events (clicks on buttons) generated for calculator's keys.
	 */
	public void actionPerformed(ActionEvent e) {
		String s = ((JButton)e.getSource()).getText();
		doClick(s.charAt(0));
/*
		if (s.equals("backspace")) {
			doClick('b');
		} else {
			doClick(s.charAt(0));
		}
*/
	}
	/**
	 * Nothing happens when a key is pressed.
	 * @param theEvent a non-event.
	 */
	public void keyPressed(KeyEvent theEvent) {
	}

	/**
	 * Nothing happens when a key is released.
	 * @param theEvent a non-event.
	 */
	public void keyReleased(KeyEvent theEvent) {
	}

	/**
 	 * Handles a keyboard input.
	 * The input will show up in the text area of the Calculator.
	 * No checking is done for bad input at this point.
	 * @param theEvent The key that is typed.
	 */
	public void keyTyped(KeyEvent theEvent) {
		char c = theEvent.getKeyChar();
		doClick(c);
	}

	/**
	 * Paints the calculator panel and all the components.
	 * @param g The graphics object for the panel
	 */
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
	}

	/**
	 *Launches the Calculator.
	 * @param args Not used.
	 */
	public static void main( String[] args ) {
		Calculator calc = new Calculator();
		calc.showFrame();
        }
}

