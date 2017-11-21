package model;


public class ReadData {
  private String dataStr;
  private int hogeCode;
  private String hogeName;
  private int bar2Code;
  private String check;
  private int kingaku;
  private String concatenate;

  public ReadData(String dataStr,int hogeCode, String hogeName, int bar2Code, String check, int kingaku,String concatenate ){
    this.dataStr = dataStr;
    this.hogeName = hogeName;
    this.hogeCode = hogeCode;
    this.bar2Code = bar2Code;
    this.check = check;
    this.kingaku = kingaku;
    this.concatenate = concatenate + ":結合:" +dataStr;
  }

  public int getHogeCode() {
    return hogeCode;
  }

  public int getKingaku() {
    return kingaku;
  }

  public String getHogeName() {
    return hogeName;
  }

  public int getBar2Code() {
    return bar2Code;
  }

  public String getDataStr() {
    return dataStr;
  }

  public String getCheck() {
    return check;
  }

  public String getConcatenate() {
    return concatenate;
  }
}
