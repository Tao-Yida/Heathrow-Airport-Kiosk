import com.csvreader.CsvReader;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

/**
 * ReadAndWriterCsvFile.java
 * <p>
 * This is our csv file reader.
 * It reads Passenger.csv and flightInfo.csv.
 *
 * @author Group76
 * @version 5.0
 */
public class ReadAndWriterCsvFile
{
    public static final String PASSENGER_CSV = "resource/Passenger.csv";
    public static final String FLIGHTINFO_CSV = "resource/flightInfo.csv";
    public static String str = "";
    public String[] logString = new String[3];
    InfoDisplay infoDisplay = new InfoDisplay();
    private String flightNum;

    public void setFlightNum(String flightNum)
    {
        this.flightNum = flightNum;
    }

    /**
     * This method reads one data from csv.
     */
    public boolean readOneDataFromCSV(String testString)
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
            for (String[] strings : csvFileList)
            {
                if ((Objects.equals(strings[0], testString)))
                {
                    setFlightNum(strings[1]);
                    infoDisplay.classType = strings[8].toCharArray();
                    return true;
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method reads two data from csv.
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
                if ((Objects.equals(csvFileList.get(row)[2], testString1) && (Objects.equals(csvFileList.get(row)[5],
                        testString2))))
                {
                    setFlightNum(csvFileList.get(row)[1]);
                    infoDisplay.classType = csvFileList.get(row)[8].toCharArray();
                    return true;
                }
                else if (row == csvFileList.size() - 1)
                {
                    System.out.println("No such account.");
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * This method reads data from flight csv.
     */
    public void readDataFromFlightCSV()
    {
        try
        {
            ArrayList<String[]> csvFileList = new ArrayList<>();
            CsvReader reader2 = new CsvReader(FLIGHTINFO_CSV, ',', Charset.forName("GBK"));
            reader2.readHeaders();
            while (reader2.readRecord())
            {
                csvFileList.add(reader2.getValues());
            }
            for (int row = 0; row < csvFileList.size(); row++)
            {
                if (Objects.equals(flightNum, csvFileList.get(row)[0]))
                {
                    //System.out.println(csvFileList.get(row)[2]);
                    infoDisplay.flightString[0] = csvFileList.get(row)[0];
                    infoDisplay.flightString[1] = csvFileList.get(row)[1];
                    infoDisplay.flightString[2] = csvFileList.get(row)[2];
                    infoDisplay.flightString[3] = csvFileList.get(row)[3];
                    infoDisplay.flightString[4] = csvFileList.get(row)[4];
                    infoDisplay.flightString[5] = csvFileList.get(row)[5];
                    infoDisplay.flightString[6] = csvFileList.get(row)[6];
                    str = csvFileList.get(row)[0];
                    break;
                }
                else if (row > csvFileList.size() - 1)
                {
                    System.out.println("No information.");
                }
            }
            reader2.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        setAttribute();
        infoDisplay.initial();
    }

    /**
     * This method sets attributes.
     */
    public void setAttribute()
    {
        Flight flight = new Flight();
        flight.setFlightNo(infoDisplay.flightString[0]);
        flight.setDeparture(infoDisplay.flightString[1]);
        flight.setDestination(infoDisplay.flightString[2]);
        flight.setGate(infoDisplay.flightString[3]);
        flight.setDepartureTime(infoDisplay.flightString[4]);
        flight.setBoardingTime(infoDisplay.flightString[5]);
    }

}