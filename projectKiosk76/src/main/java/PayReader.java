
import com.csvreader.CsvReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

/**
 * PayReader.java
 *
 * This is the PayReader class which reads payment information.
 *
 * @author Group76
 * @version 5.0
 */
public class PayReader
{
    public String[] logString = new String[3];
    private String flightNum;
    public void setFlightNum(String flightNum)
    {
        this.flightNum = flightNum;
    }
    public static final String PASSENGER_CSV = "resource/Payment.csv";
    /**
     *  This method is to match the card number and CVV.
     */
    public boolean readTwoDataFromCSV(String testString1, String testString2)
    {
        try
        {
            ArrayList<String[]> csvFileList = new ArrayList<>();
            CsvReader reader = new CsvReader(PASSENGER_CSV, ',', Charset.forName("GBK"));
            reader.readHeaders();
            while (reader.readRecord())
            {
                csvFileList.add(reader.getValues());
            }
            reader.close();
            for (int row = 0; row < csvFileList.size(); row++)
            {
                if ((Objects.equals(csvFileList.get(row)[2], testString1) && (Objects.equals(csvFileList.get(row)[4],
                        testString2))))
                {
                    setFlightNum(csvFileList.get(row)[1]);
                    return true;
                }
                else if (row == csvFileList.size() - 1)
                {
                    System.out.println("No such account.");
                    System.out.println(logString[1]);
                    System.out.println(logString[2]);
                    System.out.println(testString1);
                    System.out.println(testString2);

                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }



}