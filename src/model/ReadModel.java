package model;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;

public class ReadModel {

  public boolean read(File selectFile, ArrayList<ReadData> list) {
    // 開始の行
    int i = 7;
    Workbook workbook = null;
    list.clear();
    boolean sw = false;
    try {
      // ワークブックを開く
      workbook = WorkbookFactory.create(selectFile);

      // シートの取得
      Sheet sheet = workbook.getSheetAt(0);
      // 空文字が来るまで文字列として取得
      while (true) {
        Row row = sheet.getRow(i);

        // セルの値取得
        Cell dataStrCell = row.getCell(0);
        Cell hogeCodeCell = row.getCell(1);
        Cell hogeNameCell = row.getCell(2);
        Cell bar2Code2Cell = row.getCell(3);
        Cell checkCell = row.getCell(4);
        Cell kingaku = row.getCell(5);
        i++;

        if (dataStrCell.getStringCellValue() == ""){
          break;
        }
        // オブジェクにセット
        ReadData readData = new ReadData(
            dataStrCell.getStringCellValue(),
            (int)hogeCodeCell.getNumericCellValue(),
            hogeNameCell.getStringCellValue(),
            (int)bar2Code2Cell.getNumericCellValue(),
            checkCell.getStringCellValue(),
            (int)kingaku.getNumericCellValue()
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
          return true;
        }
      }catch (Exception e){
        e.printStackTrace();
        return sw;
      }
    }
    return sw = true;
  }
}
