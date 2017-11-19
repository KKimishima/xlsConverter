package model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class readModel {
  //private String filepath;

  public void read(File selectFile) {
    Workbook workbook = null;
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
      String strValue = cell.getStringCellValue();

      System.out.println(strValue);
    } catch (InvalidFormatException e) {
      e.printStackTrace();
      System.out.println("xls読み込み失敗");
      System.exit(0);
    }catch (IOException e){
      e.printStackTrace();
      System.out.println("ファイルパス指定失敗");
      System.exit(1);
    }finally {
      try {
        if (workbook != null){
          workbook.close();
        }
      }catch (IOException e){
        e.printStackTrace();
        System.out.println("閉じる失敗");
      }
    }
  }
}
