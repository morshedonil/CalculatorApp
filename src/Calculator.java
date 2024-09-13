import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Calculator extends Application 
{
	// the calculator dimensions
	public static int CALC_WIDTH = 400;
	public static int CALC_HEIGHT = 300;
	public static int BN_WIDTH = (CALC_WIDTH - 30)/ 5;
	public static int BN_HEIGHT = (CALC_HEIGHT - 30)/ 4;

	// the calculator screen
	private TextField screen; 

	// the calculator buttons
	private Button[] buttons;

	private String numbers = "";

	private Stack<Double> operand;
	private Stack<Operator> operator;

	@Override
	public void start(Stage primaryStage) 
	{
		// create the calculator screen
		screen = new TextField(); 

		// attach a handler to process button clicks 
		ButtonHandler handler = new ButtonHandler();       

		// setup a grid panel for the keypad
		GridPane keypad = new GridPane();  
		keypad.setMinSize(CALC_WIDTH, CALC_HEIGHT); 

		keypad.setVgap(5); 
		keypad.setHgap(5);       
		keypad.setAlignment(Pos.CENTER);

		operand = new Stack<Double>();
		operator = new Stack<Operator>();

		String[] btnLabels = {"1", "2", "3", "+", "-", 
				"4", "5", "6", "*", "/", 
				"7", "8", "9", "(", ")",
				"0",".", "=", "^", "C"};

		buttons = new Button[btnLabels.length];

		int r = 0; int c = 0;

		for(int i = 0; i < btnLabels.length; i++) {

			buttons[i] = new Button(btnLabels[i]);
			buttons[i].setPrefHeight(BN_HEIGHT);
			buttons[i].setPrefWidth(BN_WIDTH);
			buttons[i].setOnAction(handler);
			keypad.add(buttons[i], c, r);
			c++;

			if(c > 4) {
				c = 0;
				r++;
			}
		}

		// put screen and keypad together
		BorderPane gui = new BorderPane();
		gui.setTop(screen);
		gui.setCenter(keypad);

		// set up the scene
		Scene scene = new Scene(gui); 
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void pushOperator(Operator curOperator) {

		int curPrecedence = curOperator.getPrecedence();

		while(operator.isEmpty() == false && operator.peek().getPrecedence() >= curPrecedence) {
			Operator topOperator = operator.pop();
			Double firstOperand = operand.pop();
			Double secondOperand = operand.pop();

			//if(topOperator instanceof AddOperator || topOperator instanceof SubOperator || topOperator instanceof MulOperator ||
			//          topOperator instanceof DivOperator || topOperator instanceof ExpOperator) {
			Double result = topOperator.evaluate(secondOperand, firstOperand);
			operand.push(result);
			//}
		}
		operator.push(curOperator);

	}

	// Handler for processing the button clicks 
	private class ButtonHandler implements EventHandler<ActionEvent>
	{ 
		@Override 
		public void handle(ActionEvent e) 
		{
			// Button 1
			if (e.getSource() == buttons[0]) {
				System.out.println("Button 1 Pressed");
				screen.appendText(buttons[0].getText());
				numbers += buttons[0].getText();
			}
			// Button 2
			else if (e.getSource() == buttons[1]) {
				System.out.println("Button 2 Pressed");
				screen.appendText(buttons[1].getText());
				numbers += buttons[1].getText();
			}
			// Button 3
			else if (e.getSource() == buttons[2]) {
				System.out.println("Button 3 Pressed");
				screen.appendText(buttons[2].getText());
				numbers += buttons[2].getText();
			}
			// Button +
			else if (e.getSource() == buttons[3]) {
				System.out.println("Button + Pressed");
				screen.appendText(buttons[3].getText());

				if( numbers != "") {
					operand.push(Double.parseDouble(numbers));
					numbers = "";
				}

				AddOperator plusOperator = new AddOperator(); 
				pushOperator(plusOperator);               
			}
			// Button -
			else if(e.getSource() == buttons[4]) {
				System.out.println("Button - Pressed");
				screen.appendText(buttons[4].getText());

				if( numbers != "") {
					operand.push(Double.parseDouble(numbers));
					numbers = "";
				}

				SubOperator subOperator = new SubOperator(); 
				pushOperator(subOperator);
			}
			// Button 4
			else if(e.getSource() == buttons[5]) {
				System.out.println("Button 4 Pressed");
				screen.appendText(buttons[5].getText());
				numbers += buttons[5].getText();
			}
			// Button 5
			else if(e.getSource() == buttons[6]) {
				System.out.println("Button 5 Pressed");
				screen.appendText(buttons[6].getText());
				numbers += buttons[6].getText();
			}
			// Button 6
			else if(e.getSource() == buttons[7]) {
				System.out.println("Button 6 Pressed");
				screen.appendText(buttons[7].getText());
				numbers += buttons[7].getText();
			}
			// Button *
			else if(e.getSource() == buttons[8]) {
				System.out.println("Button * Pressed");
				screen.appendText(buttons[8].getText());

				if( numbers != "") {
					operand.push(Double.parseDouble(numbers));
					numbers = "";
				}

				MulOperator MulOperator = new MulOperator(); 
				pushOperator(MulOperator);
			}
			// Button /
			else if(e.getSource() == buttons[9]) {
				System.out.println("Button / Pressed");
				screen.appendText(buttons[9].getText());

				if( numbers != "") {
					operand.push(Double.parseDouble(numbers));
					numbers = "";
				}

				DivOperator DivOperator = new DivOperator(); 
				pushOperator(DivOperator);
			}
			// Button 7
			else if(e.getSource() == buttons[10]) {
				System.out.println("Button 7 Pressed");
				screen.appendText(buttons[10].getText());
				numbers += buttons[10].getText();
			}
			// Button 8
			else if(e.getSource() == buttons[11]) {
				System.out.println("Button 8 Pressed");
				screen.appendText(buttons[11].getText());
				numbers += buttons[11].getText();
			}
			// Button 9
			else if(e.getSource() == buttons[12]) {
				System.out.println("Button 9 Pressed");
				screen.appendText(buttons[12].getText());
				numbers += buttons[12].getText();
			}
			// Button (
			else if(e.getSource() == buttons[13]) {
				System.out.println("Button ( is pressed");
				screen.appendText(buttons[13].getText());
				LeftParenOperator leftParenthesis = new LeftParenOperator();
				operator.push(leftParenthesis);
			}
			// Button )
			else if(e.getSource() == buttons[14]) {
				System.out.println("Button ) is pressed");
				screen.appendText(buttons[14].getText());

				if( numbers != "") {
					operand.push(Double.parseDouble(numbers));
					numbers = "";
				}

				RightParenOperator rightParenthesis = new RightParenOperator();
				pushOperator(rightParenthesis);

				operator.pop();
				operator.pop();
			}
			// Button 0
			else if(e.getSource() == buttons[15]) {
				System.out.println("Button 0 Pressed");
				screen.appendText(buttons[15].getText());
				numbers += buttons[15].getText();
			}
			// Button.
			else if(e.getSource() == buttons[16]) {
				System.out.println("Button . Pressed");
				screen.appendText(buttons[16].getText());
				numbers += buttons[16].getText();
			}
			// Button =
			else if(e.getSource() == buttons[17]) {
				System.out.println("= is pressed");
				screen.appendText(buttons[17].getText());

				if( numbers != "") {
					operand.push(Double.parseDouble(numbers));
					numbers = "";
				}

				EqualOperator equalOperator = new EqualOperator();
				pushOperator(equalOperator);
				String result = operand.pop().toString();
				screen.appendText(result);
				operator.pop();
			}
			// Button ^
			else if(e.getSource() == buttons[18]) {
				System.out.println("Button ^ Pressed");
				screen.appendText(buttons[18].getText());

				if( numbers != "") {
					operand.push(Double.parseDouble(numbers));
					numbers = "";
				}

				ExpOperator ExpOperator = new ExpOperator(); 
				pushOperator(ExpOperator);
			}
			// Button C
			else if(e.getSource() == buttons[19]) {
				System.out.println("Button C Pressed");
				operator.clear();
				operand.clear();
				screen.clear();
			}
		} 
	}  

	public static void main(String[] args) 
	{
		launch(args);
	}
}
