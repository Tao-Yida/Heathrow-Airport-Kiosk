import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * SeatsReader.java
 * <p>
 * This class could read the PBEClassSeat.xlsx file and save relevant contents in a string array.
 *
 * @author Group 76
 * @version 5.0
 */
public class SeatsReader
{
    public static String[] seatStatusFirst = new String[8];
    public static String[] seatStatusBusiness = new String[21];
    public static String[] seatStatusEconomy = new String[49];
    public static String flight = "";
    Seat seat = new Seat();

    public static void main(String[] args)
    {
        SeatsReader rc = new SeatsReader();
        rc.ReadStatusData();
    }

    /**
     * This method reads a file containing all seat information.
     */
    public void ReadStatusData()
    {
        flight = ReadAndWriterCsvFile.str;
        Workbook wb = null;
        try
        {
            FileInputStream fis = new FileInputStream("resource/FBEClassSeats-" + flight + ".xlsx");
            wb = new XSSFWorkbook(fis);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        //First Class
        Sheet sheet = null;
        if (wb != null)
        {
            sheet = wb.getSheetAt(0);
        }
        for (int i = 0; i < 8; i++)
        {
            assert sheet != null;
            Row row = sheet.getRow(i + 1);
            Cell cell = row.getCell(3);
            seat.setSeatID(i);
            seatStatusFirst[i] = cell.getStringCellValue();
        }

        //Business Class
        sheet = wb.getSheetAt(1);
        for (int i = 0; i < 21; i++)
        {
            Row row = sheet.getRow(i + 1);
            Cell cell = row.getCell(3);
            seatStatusBusiness[i] = cell.getStringCellValue();
        }

        //Economy Class
        sheet = wb.getSheetAt(2);
        for (int i = 0; i < 49; i++)
        {
            Row row = sheet.getRow(i + 1);
            Cell cell = row.getCell(3);
            Cell type = row.getCell(4);
            if (type.getStringCellValue().equals("Pro") && cell.getStringCellValue().equals("A")) seatStatusEconomy[i] = "P";
            else seatStatusEconomy[i] = cell.getStringCellValue();
        }
    }

}
