import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

//We first create a class for all our tests
public class TestP1{

    P1 p1example = new P1();

    @Test
    public void mainMethodCompiles(){
        P1.main(null);
    }
    @Test
    public void divideByZero(){
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setOut(System.out);

        //p1example.divide(5.0,0.0);
        
        assertEquals("UNDEFINED", outContent);

    }

    @Test
    public void calculateAverages(){
        //double[] numbers = {1.0,2.0,3.0};
        //double result = p1example.calculateAverages(numbers);
        //assertEquals(result, 2.0);
    }
}