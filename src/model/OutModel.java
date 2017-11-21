package model;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import model.ReadData;

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
      //Sheet sheet = workbook.getSheet("Sheet1");
      Sheet sheet = workbook.getSheetAt(0);
      for (int i = 0;i< list.size();i++){

        Row row = sheet.getRow(i);
        Cell cell = row.createCell(1);
        cell.setCellValue(list.get(i).getValue());
      }
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
