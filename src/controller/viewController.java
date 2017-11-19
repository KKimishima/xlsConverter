package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.ReadData;
import model.ReadModel;

import java.io.File;
import java.util.ArrayList;

public class viewController {
  ArrayList<ReadData> list = new ArrayList<>();
  @FXML
  private TextField fileName;

  ReadModel readModel = new ReadModel();
  FileChooser fileChooser = new FileChooser();

  //@FXML
  public void onRead(){
    fileChooser.setTitle("読み込むファイルを選択してください");
    File selectFile = fileChooser.showOpenDialog(null);
    if (!readModel.read(selectFile,list)){
      list.clear();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("取り込みエラー");
      alert.setContentText("ファイルが違います!!!!");
      alert.show();
      return;
    }
    fileName.setText(selectFile.getName());
    //for (ReadData str: list){
    //  System.out.println(str.getValue());
    //}
  }
}
