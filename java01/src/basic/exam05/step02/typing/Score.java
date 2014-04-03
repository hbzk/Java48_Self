package basic.exam05.step02.typing;

public class Score {
	String name;
	int no, kor, eng, math, sum;
	
	public Score() {
	  no++;
  }

	@Override
  public String toString() {
	  return no + "," + name + "," + kor + "," + eng + "," + math + "," + sum;
  }
	
	
}
