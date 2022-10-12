import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * OptionReader.java
 *
 * This is the Option reader which reads option information.
 *
 * @author Group 76
 * @version 5.0
 */
public class OptionReader
{

    public static String[] seatStatus = new String[5];

    /**
     * This method is to the data of a whole row .
     */
    public void ReadStatusData(int vRow)
    {
        Workbook wb = null;
        try
        {
            FileInputStream fis = new FileInputStream("resource/option.xlsx");
            wb = new XSSFWorkbook(fis);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        assert wb != null;
        Sheet sheet = wb.getSheetAt(0);
        for (int i = 0; i < 5; i++)
        {
            Row row = sheet.getRow(vRow);
            Cell cell = row.getCell(i);
            cell.setCellType(CellType.STRING);
            seatStatus[i] = cell.getStringCellValue();
        }
        //System.out.println(Arrays.toString(seatStatus));
    }
}
