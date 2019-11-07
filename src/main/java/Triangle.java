import java.util.*;

public class Triangle
{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(){}

    public Triangle(double s1, double s2, double s3)
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    
    public void setSide1(double s1)
    {
        side1 = s1;
    }
    
    public void setSide2(double s2)
    {
        side2 = s2;
    }
    
    public void setSide3(double s3)
    {
        side3 = s3;
    }
    
    public double getSide1()
    {
        return side1;
    }
    
    public double getSide2()
    {
        return side2;
    }
    
    public double getSide3()
    {
        return side3;
    }
    
    //Checks to make sure the current triangle object is actually a valid triangle.
    public void Verifier() throws Exception {
    	//Test to see if all the sides are positive real numbers.
		if(side1 < 0 || side2 < 0 || side3 < 0)
		{
		    System.out.println("\nInvalid side lengths: side lengths must be a positive real number.");
		    //System.exit(0);
            throw new Exception("\nInvalid side lengths: side lengths must be a positive real number.");
		}
		
		//Test to see if triangle is valid using the Triangle Inequality Theorem: a+b>c, a+c>b, b+c>a  
//		else if( ((side1 + side2) <= side3) || ((side1 + side3) <= side2) || ((side2 + side3) <= side1) )
        else if(((side2 + side3) <= side1) || ((side1 + side2) <= side3) || ((side1 + side3) <= side2) )
		{
		    System.out.println("\nInvalid side lengths according to Triangle Inequality Theorem: a+b>c, a+c>b, b+c>a");
		    //System.exit(0);
            throw new Exception("\nInvalid side lengths according to Triangle Inequality Theorem: a+b>c, a+c>b, b+c>a");
		}
    }
    
    //Method to identify what type of triangle was passed into this class.
    public void Identifier()
    {
        boolean equilateral = false, isosceles = false, scalene = false, right = false;
        
        //Equilateral test
        if(side1 == side2 && side2 == side3)
            equilateral = true;
        
        //Isosceles test
        if(equilateral == false)
        {
            if(side1 == side2 || side2 == side3 || side1 == side3)
                isosceles = true;
        }
        
        //Scalene test
        if(equilateral == false && isosceles == false)
            scalene = true;
        
        //Right test
        //Note: I used the arraylist just in case the sides were entered in a weird order, since c is supposed to be the largest side.
        //If the sides are entered as instructed, then the list is unnecessary.
        if(equilateral == false)
        {
            ArrayList<Double> list = new ArrayList<>();
            list.add(side1);
            list.add(side2);
            list.add(side3);
            
            Collections.sort(list);

            double a = list.get(0);
            double b = list.get(1);
            double c = list.get(2);
            
            //a2, b2, and c2 are all rounded to the tenth's place.
            double a2 = Math.round((float)Math.pow(a,2) * 10) / 10.0; //a^2
            double b2 = Math.round((float)Math.pow(b,2) * 10) / 10.0; //b^2
            
            double a2b2 = a2 + b2; // a^2 + b^2
            double c2 = Math.round((float)Math.pow(c,2) * 10) / 10.0; //c^2
                        
            if(a2b2 == c2)//a^2 + b^2 = c^2
                right = true;

        }
        
        System.out.println("===============================");
//        System.out.println("Equilateral: " + equilateral);
//        System.out.println("Isosceles: " + isoceles);
//        System.out.println("Scalene: " + scalene);
//        System.out.println("Right: " + right);
        
        if(equilateral == true)
        	System.out.println("This triangle is equilateral");
        
        if(equilateral == false && isosceles == true && right == false)
        	System.out.println("This triangle is isoceles");
        
        if(equilateral == false && scalene == true && right == false)
        	System.out.println("This triangle is scalene");

        //A right triangle must also be either isosceles or scalene. It cannot be equilateral because all angles are 60
        //degrees in an equilateral. That leaves the options of either no sides equal or two sides equal (scalene and Isosceles).
//        if(equilateral == false && isosceles == false && scalene == false && right == true)
//        	System.out.println("This triangle is right");
        
        if(equilateral == false && isosceles == true && right == true)
        	System.out.println("This triangle is right isoceles");
        
        if(equilateral == false && scalene == true && right == true)
        	System.out.println("This triangle is right scalene");
        
    }
    
    //Finds the area of the current triangle object
    public void getArea()
    {
    	double sPerim = (side1 + side2 + side3) / 2;
    	
    	double temp = sPerim * (sPerim - side1)* (sPerim - side2)* (sPerim - side3);
    	
    	double area = Math.sqrt(temp);
    	
    	System.out.println("The area of the triangle is: " + area);
    }
    
    //Calculates the side lengths of a triangle given the vertices in the form of ordered pairs.
    public void calcLengths(Point a, Point b, Point c) throws Exception {
    	
    	side1 = Math.sqrt( Math.pow( (b.getX() - a.getX()), 2) + Math.pow( (b.getY() - a.getY()), 2) );
    	side2 = Math.sqrt( Math.pow( (c.getX() - a.getX()), 2) + Math.pow( (c.getY() - a.getY()), 2) );
    	side3 = Math.sqrt( Math.pow( (c.getX() - b.getX()), 2) + Math.pow( (c.getY() - b.getY()), 2) );
    	
    	//I chose to assume that we round the side lengths kinda like we did in Assignment 1.
    	//If not, just comment out the next 3 lines.
    	side1 = Math.round((float)side1 * 10) / 10.0;
    	side2 = Math.round((float)side2 * 10) / 10.0;
    	side3 = Math.round((float)side3 * 10) / 10.0;
    	
    	Verifier();
    	Identifier();
    	getArea();
    }
}