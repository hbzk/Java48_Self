package basic.training;

public class Score {
	String name;
	int kor;
	int eng;
	int math;
	
	Score(String name) {
		this.name = name;
	}
	
	public static Score fromCSV(String values){
		String[] data = values.split(",");
		
		Score obj = new Score(data[0]);
		obj.kor = Integer.parseInt(data[1]);
		obj.eng = Integer.parseInt(data[2]);
		obj.math = Integer.parseInt(data[3]);
		
		return obj;
	}

	@Override
  public String toString() {
	  return name + "," + kor + "," + eng + "," + math;
  }
	
	
}
