package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.readModel;

import java.io.File;

public class viewController {
  @FXML
  private TextField fileName;

  readModel readModel = new readModel();
  FileChooser fileChooser = new FileChooser();

  //@FXML
  public void onRead(){
    fileChooser.setTitle("読み込むファイルを選択してください");
    File selectFile = fileChooser.showOpenDialog(null);
    readModel.read(selectFile);
    fileName.setText(selectFile.getName());
  }
}
