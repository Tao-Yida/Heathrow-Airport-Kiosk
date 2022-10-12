import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AuthenticationTest {
    private BasicPanels b;

    public void setUp() {
        b = new BasicPanels();
    }  

    @Test
    public voidtest1_1(){
        setUp();
        assertTrue(b.readAndWriterCsvFile.readTwoDataFromCSV("Wilson", "33080220011"));
    }

    @Test
    public voidtest1_2(){
        setUp();
        assertFalse(b.readAndWriterCsvFile.readTwoDataFromCSV("Rossi", "33080220011"));
    }

    @Test
    public voidtest1_3(){
        setUp();
        assertFalse(b.readAndWriterCsvFile.readTwoDataFromCSV("Wilson", "33080220012"));
    }

    @Test
    public voidtest1_4(){
        setUp();
        assertFalse(b.readAndWriterCsvFile.readTwoDataFromCSV("Wilson", "3308022001&"));
    }
}
