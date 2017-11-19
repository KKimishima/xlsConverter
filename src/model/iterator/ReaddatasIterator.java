package model.iterator;

public class ReaddatasIterator implements Iterator{
  private ReadDates readDates;
  private int index;

  public ReaddatasIterator(ReadDates readDates) {
    this.readDates = readDates;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object next() {
    return null;
  }
}
