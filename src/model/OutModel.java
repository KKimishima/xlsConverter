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
  private final int hoge1 = 11;
  private final int hoge3 = 22;
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
      Sheet sheet = workbook.getSheetAt(0);
      for (int i = 0;i< list.size();i++){

        Row row = sheet.getRow(i +3);
        Cell hoge1Cell = row.createCell(0);
        Cell hoge2Cell = row.createCell(1);
        Cell hoge3Cell = row.createCell(2);
        Cell hoge4Cell = row.createCell(3);

        Cell foo1Cell = row.createCell(4);
        Cell foo2Cell = row.createCell(5);
        Cell checkCell = row.createCell(6);
        Cell foo3Cell = row.createCell(7);

        Cell barCell = row.createCell(8);

        hoge1Cell.setCellValue(hoge1);
        hoge2Cell.setCellValue(list.get(i).getDataStr());
        hoge3Cell.setCellValue(hoge3);
        hoge4Cell.setCellValue(list.get(i).getBar2Code());

        foo1Cell.setCellValue(list.get(i).getHogeName());
        foo2Cell.setCellValue(list.get(i).getHogeCode());
        checkCell.setCellValue(list.get(i).getCheck());
        foo3Cell.setCellValue(list.get(i).getKingaku());

        barCell.setCellValue(list.get(i).getConcatenate());

        //cell.setCellValue(list.get(i).getHogeName());
        //cell1.setCellValue(list.get(i).getDataStr());
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
