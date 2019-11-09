import java.util.Scanner;
import java.awt.*;
import java.awt.geom.Point2D;


public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scnr = new Scanner(System.in);
		
//		System.out.print("Please enter 1 to input side legths or 2 to input ordered pairs: ");
//		int choice = scnr.nextInt();

		int choice = Integer.parseInt(args[0]);
		System.out.println("This is choice: " + choice);
		
		
		//Input of side lengths
		if(choice == 1)
		{
			System.out.println("\n" + "You have chosen to enter side lengths");
			System.out.println("Please enter side lengths in the order they would go into a^2 + b^2 = c^2");
			System.out.println("Square roots and fractions must be entered in decimal form. \n"
					+ "Ex: sqrt(2) = 1.41421356237 and 3/4 = 0.75" + "\n");
					
			//Scanner scnr2 = new Scanner(System.in);
			
//			//Reading in the lengths of the sides.
//			System.out.print("Enter length of side 1 (a): ");
//			double side1 = Double.parseDouble(scnr.next());
//
//			System.out.print("Enter length of side 2 (b): ");
//			double side2 = Double.parseDouble(scnr.next());
//
//			System.out.print("Enter length of side 3 (c): ");
//			double side3 = Double.parseDouble(scnr.next());

			System.out.print("Enter the side lengths (ex: x y z): ");
			String line = scnr.nextLine();

			String[] arr = line.split(" ");
			double[] arr2 = new double[arr.length];

			for(int i = 0; i < arr.length; i++)
				arr2[i] = Double.parseDouble(arr[i]);
			
			//scnr2.close();
			
			Triangle shape = new Triangle(); //Initiating new triangle object.
			
//			shape.setSide1(side1);
//			shape.setSide2(side2);
//			shape.setSide3(side3);

			shape.setSide1(arr2[0]);
			shape.setSide2(arr2[1]);
			shape.setSide3(arr2[2]);
			
			shape.Verifier();
			shape.Identifier();
			shape.getArea();
		}
		else if(choice == 2) //Input of ordered pairs
		{
			System.out.println("\n" + "You have chosen to enter ordered pairs");
			System.out.println("Please enter the ordered pairs without spaces in them. Example: (0,1)" + "\n");
			
			Scanner scnr3 = new Scanner(System.in);
			Scanner scnr4 = new Scanner(System.in);
			Scanner scnr5 = new Scanner(System.in);
			scnr3.useDelimiter("[^\\d.-]");
			scnr4.useDelimiter("[^\\d.-]");
			scnr5.useDelimiter("[^\\d.-]");
			
			double x, y;
			
			Point pt1 = new Point();
			Point pt2 = new Point();
			Point pt3 = new Point();
			
			System.out.print("Enter the first ordered pair: ");
			x = Double.parseDouble(scnr3.next());
			y = Double.parseDouble(scnr3.next());
			pt1.setX(x);
			pt1.setY(y);
			
			System.out.print("Enter the second ordered pair: ");
			x = Double.parseDouble(scnr4.next());
			y = Double.parseDouble(scnr4.next());
			pt2.setX(x);
			pt2.setY(y);
			
			System.out.print("Enter the third ordered pair: ");
			x = Double.parseDouble(scnr5.next());
			y = Double.parseDouble(scnr5.next());
			pt3.setX(x);
			pt3.setY(y);
			
			Triangle shape = new Triangle(); //Initiating new triangle object.
			
			shape.calcLengths(pt1, pt2, pt3);
			
			scnr3.close();
			scnr4.close();
			scnr5.close();
			
		}
		else
			System.out.println("Invalid choice. Please restart program and choose either 1 or 2");
		
		scnr.close();
		
	
	}

}
