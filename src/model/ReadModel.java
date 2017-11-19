package model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReadModel {
  //private String filepath;

  public boolean read(File selectFile, ArrayList<ReadData> list) {
    Workbook workbook = null;
    list.clear();
    boolean sw = false;
    try {
      // ワークブックを開く
      //InputStream ins = new FileInputStream(filePath);
      workbook = WorkbookFactory.create(selectFile);

      // シートの取得
      Sheet sheet = workbook.getSheet("sheet1");

      // 列の取得
      Row row = sheet.getRow(0);
      // セルの取得
      Cell cell = row.getCell(0);

      // 文字列として取得

      list.add(new ReadData(cell.getStringCellValue()));
      //String strValue = cell.getStringCellValue();

      //System.out.println(strValue);
    } catch (Exception e) {
      e.printStackTrace();
      return sw;
    }finally {
      try {
        if (workbook != null){
          workbook.close();
        }
      }catch (Exception e){
        e.printStackTrace();
        return sw;
      }
    }
    return sw = true;
  }
}
