import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    private Pay_1 p;

    public void setUp() {
        p = new Pay_1();
    }  

    @Test
    public voidtest2_1(){
        setUp();
        assertTrue(p.readAndWriterCsvFile.readTwoDataFromCSV("4000500060007000", "111"));
    }

    @Test
    public voidtest2_2(){
        setUp();
        assertFalse(p.readAndWriterCsvFile.readTwoDataFromCSV("4123523463457456", "111"));
    }

    @Test
    public voidtest2_3(){
        setUp();
        assertFalse(p.readAndWriterCsvFile.readTwoDataFromCSV("400050006000700011", "111"));
    }

    @Test
    public voidtest2_4(){
        setUp();
        assertFalse(p.readAndWriterCsvFile.readTwoDataFromCSV("4000500060007000", "222"));
    }

    @Test
    public voidtest2_5(){
        setUp();
        assertFalse(p.readAndWriterCsvFile.readTwoDataFromCSV("400050006000700$", "111"));
    }
}
