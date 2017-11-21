package model;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;

public class ReadModel {

  public boolean read(File selectFile, ArrayList<ReadData> list) {
    // 開始の行
    int i = 8;
    Workbook workbook = null;
    list.clear();
    boolean sw = false;
    try {
      // ワークブックを開く
      //InputStream ins = new FileInputStream(filePath);
      workbook = WorkbookFactory.create(selectFile);

      // シートの取得
      Sheet sheet = workbook.getSheetAt(0);
      // 空文字が来るまで文字列として取得
      while (true) {
        Row row = sheet.getRow(i);

        Cell cell = row.getCell(2);
        Cell cell2 = row.getCell(0);
        if (cell.getStringCellValue() == ""){
          break;
        }
        i++;

        ReadData readData = new ReadData(
            cell.getStringCellValue(),
            cell2.getStringCellValue()
        );

        list.add(readData);
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
