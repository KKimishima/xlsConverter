package model;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class OutModel {
  private Workbook workbook;
  File file = new File("xls/templeTest.xls");

  public OutModel(){
    try {
      workbook = WorkbookFactory.create(file);
    }catch (Exception e){
      Platform.exit();
    }
  }

  public boolean OutDate(ArrayList<ReadData> list,File outFile){
    FileOutputStream fos = null;
    try{
      Sheet sheet = workbook.getSheet("Sheet1");
      Row row = sheet.getRow(0);
      Cell cell = row.getCell(1);
      cell.setCellValue(list.get(0).getValue());
      fos = new FileOutputStream(outFile);
      workbook.write(fos);
    }catch (Exception e){
      e.printStackTrace();
      return false;
    }finally {
      try{
       if (workbook != null){
         fos.close();
         workbook.close();
       }
      }catch (Exception e){}
    }
    return true;
  }
}
