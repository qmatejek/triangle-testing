import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {


    @Test
    public void mainTestSides() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        InputStream stdin = System.in;

        ByteArrayInputStream in = new ByteArrayInputStream("3 4 5".getBytes());
        System.setIn(in);

        try {
            Main.main(new String[]{"1"});
        }
        catch(Exception E){}

        String expected = "You have chosen to enter side lengths";
        String actual = outContent.toString();

        System.setIn(stdin);

        assertTrue(actual.contains(expected));

    }

    @Test
    public void mainTestPoints() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        InputStream stdin = System.in;

        ByteArrayInputStream in = new ByteArrayInputStream("(0,0)\n(0,1)\n(1,1)".getBytes());
        System.setIn(in);

        try {
            Main.main(new String[]{"2"});
        }
        catch(Exception E){}

        String expected = "You have chosen to enter ordered pairs";
        String actual = outContent.toString();

        System.setIn(stdin);

        assertTrue(actual.contains(expected));

    }

    @Test
    public void mainTestNeither() throws Exception
    {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        try {
            Main.main(new String[]{"3"});
        }
        catch(Exception E){}

        String expected = "Invalid choice. Please restart program and choose either 1 or 2";
        String actual = outContent.toString();

        assertTrue(actual.contains(expected));

    }
}