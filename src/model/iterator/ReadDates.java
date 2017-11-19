package model.iterator;

import java.util.ArrayList;

public class ReadDates implements aggregate{
  private ArrayList<ReadData> datas;
  public ReadDates(){
    this.datas = new ArrayList<>();
  }

  public ReadData getData(int index) {
    return datas.get(index);
  }
  public void appendData(ReadData readData){
    this.datas.add(readData);
  }
  public int getLenth(){
     return datas.size();
  }

  @Override
  public Iterator iterator() {
    return new ReadDates(this);

  }
}
