package model;

public class ReadData {
  private String value;
  private String dataStr;
  public ReadData(String value,String dataStr){
    this.value = value;
    this.dataStr = dataStr;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDataStr() {
    return dataStr;
  }

  public String getValue() {
    return value;
  }
}
