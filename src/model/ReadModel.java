package model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReadModel {

  public boolean read(File selectFile, ArrayList<ReadData> list) {
    Workbook workbook = null;
    list.clear();
    boolean sw = false;
    try {
      // ワークブックを開く
      //InputStream ins = new FileInputStream(filePath);
      workbook = WorkbookFactory.create(selectFile);

      // シートの取得
      Sheet sheet = workbook.getSheetAt(0);

      // 文字列として取得

      for (int i = 8;i <40;i++){
      //for (int i = 0;i <sheet.getLastRowNum();i++){
        // 列の取得
        Row row = sheet.getRow(i);
        // セルの取得
        Cell cell = row.getCell(2);
        // 配列に収納
        list.add(new ReadData(cell.getStringCellValue()));
      }
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
