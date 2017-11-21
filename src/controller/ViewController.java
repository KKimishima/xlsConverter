package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.OutModel;
import model.ReadData;
import model.ReadModel;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ViewController {
  @FXML
  private TextField fileName;

  ReadModel readModel = new ReadModel();
  FileChooser fileChooser = new FileChooser();
  ArrayList<ReadData> list = new ArrayList<>();
  OutModel outModel = new OutModel();
  LocalDateTime now = LocalDateTime.now();

  public void onRead(){
    fileChooser.setTitle("読み込むファイルを選択してください");
    File selectFile = fileChooser.showOpenDialog(null);
    if (!readModel.read(selectFile,list)){
      list.clear();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("取り込みエラー");
      alert.setContentText("ファイルが違います!!!!\nまたは、選択ファイルを閉じてください");
      alert.show();
      return;
    }
    fileName.setText(selectFile.getName());
  }

  public void onOut(){
    // 配列がからなら落とす
    if (this.list.isEmpty()){
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("出力エラー");
      alert.setContentText("入力ファイルを選択してください");
      alert.show();
      return;
    }

    fileChooser.setTitle("ファイル保存");
    fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    fileChooser.setInitialFileName("outData"+now.toString() +".xls");
    File outFile = fileChooser.showSaveDialog(null);

    if(outModel.OutDate(list,outFile)){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("結果");
      alert.setContentText("出力成功");
      alert.show();
    }else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("結果");
      alert.setContentText("出力失敗");
      alert.show();
    }
  }
}
