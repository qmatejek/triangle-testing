import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {



    @Test
    public void getSide1Test()
    {
        Triangle t = new Triangle(3,4,5);

        double expected = t.getSide1();

        assertEquals(expected, 3.0);
    }

    @Test
    public void getSide2Test()
    {
        Triangle t = new Triangle(3,4,5);

        double expected = t.getSide2();

        assertEquals(expected, 4.0);
    }

    @Test
    public void getSide3Test()
    {
        Triangle t = new Triangle(3,4,5);

        double expected = t.getSide3();

        assertEquals(expected, 5.0);
    }

    @Test
    public void testVerifierAllGood()
    {
        Triangle t = new Triangle(3,4,5);

        try
        {
            t.Verifier();
        }
        catch(Exception e){}
    }

    @Test
    public void testVerifierIf1a() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle();
        t.setSide1(-1);
        t.setSide2(-2);
        t.setSide3(-3);

        try
        {
            t.Verifier();
        }
        catch(Exception e){}


        String expectedOutput = "Invalid side lengths: side lengths must be a positive real number.";
        String actual = outContent.toString();

        assertTrue(actual.contains(expectedOutput));
    }

    @Test
    public void testVerifierIf1b() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle();
        t.setSide1(1);
        t.setSide2(-2);
        t.setSide3(-3);

        try
        {
            t.Verifier();
        }
        catch(Exception e){}


        String expectedOutput = "Invalid side lengths: side lengths must be a positive real number.";
        String actual = outContent.toString();

        assertTrue(actual.contains(expectedOutput));
    }

    @Test
    public void testVerifierIf1c() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle();
        t.setSide1(1);
        t.setSide2(2);
        t.setSide3(-3);

        try
        {
            t.Verifier();
        }
        catch(Exception e){}


        String expectedOutput = "Invalid side lengths: side lengths must be a positive real number.";
        String actual = outContent.toString();

        assertTrue(actual.contains(expectedOutput));
    }



    @Test
    public void testVerifierIf2a() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle();
        t.setSide1(1);
        t.setSide2(2);
        t.setSide3(3);

        try
        {
            t.Verifier();
        }
        catch(Exception e){}

        String actual = outContent.toString();
        String expectedOutput = "\nInvalid side lengths according to Triangle Inequality Theorem: a+b>c, a+c>b, b+c>a";

        assertTrue(actual.contains(expectedOutput));
    }

    @Test
    public void testVerifierIf2b() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle();
        t.setSide1(1);
        t.setSide2(6);
        t.setSide3(3);

        try
        {
            t.Verifier();
        }
        catch(Exception e){}

        String actual = outContent.toString();
        String expectedOutput = "\nInvalid side lengths according to Triangle Inequality Theorem: a+b>c, a+c>b, b+c>a";

        assertTrue(actual.contains(expectedOutput));
    }

    @Test
    public void testVerifierIf2c() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle();
        t.setSide1(0);
        t.setSide2(0);
        t.setSide3(0);

        try
        {
            t.Verifier();
        }
        catch(Exception e){}

        String actual = outContent.toString();
        String expectedOutput = "\nInvalid side lengths according to Triangle Inequality Theorem: a+b>c, a+c>b, b+c>a";

        assertTrue(actual.contains(expectedOutput));
    }

    @Test
    public void identifierEquilateral()
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle(3,3,3);

        t.Identifier();

        String expected = "This triangle is equilateral";

        String actual = outContent.toString();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void identifierIsoscelesA()
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle(5,5,4);

        t.Identifier();

        String expected = "This triangle is isoceles";

        String actual = outContent.toString();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void identifierIsoscelesB()
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle(4,5,5);

        t.Identifier();

        String expected = "This triangle is isoceles";

        String actual = outContent.toString();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void identifierScalene()
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle(6,4,5);

        t.Identifier();

        String expected = "This triangle is scalene";

        String actual = outContent.toString();

        assertTrue(actual.contains(expected));
    }


    @Test
    public void identifierRightIsosceles()
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle(5,5,7.071067812);

        t.Identifier();

        String expected = "This triangle is right isoceles";

        String actual = outContent.toString();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void identifierRightScalene()
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Triangle t = new Triangle(3,4,5);

        t.Identifier();

        String expected = "This triangle is right scalene";

        String actual = outContent.toString();

        assertTrue(actual.contains(expected));
    }

    @Test
    public void calcLengthsTest() throws Exception
    {
        Triangle t = new Triangle();
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(1,1);

        t.calcLengths(p1,p2,p3);
    }
}