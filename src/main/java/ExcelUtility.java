import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtility {
    static FileInputStream fis;
    static List<String> datalist;
    static List<String> excelUtil() throws IOException {
        fis=new FileInputStream("C:/Users/Arp/Desktop/selenium_data.xls");
        HSSFWorkbook hw=new HSSFWorkbook(fis);
        HSSFSheet hs=hw.getSheetAt(0);
        int rows=hs.getLastRowNum();
        for(int i=0; i<=rows; i++){
            datalist=new LinkedList<>();
            HSSFRow hr=hs.getRow(i);
            int cols=hr.getLastCellNum();
            for(int j=0; j<=cols; j++){
                HSSFCell hc=hr.getCell(j);
                DataFormatter df=new DataFormatter();
                String data=df.formatCellValue(hc);
                datalist.add(data);
            }
        }
        fis.close();
        return datalist;
    }
}
