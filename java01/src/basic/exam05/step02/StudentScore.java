package basic.exam05.step02;

/* 
 */
public class StudentScore {
	String name;
	int kor;
	int eng;
	int math;
	
	public StudentScore(String name) {
		this.name = name;
	}
	
	/* 클래스 메서드
	 * - 특정 인스턴스를 위해 작업하지 않는다.
	 * - 모든 인스턴스를 대상으로 공통 작업을 수행한다.
	 */
	public static StudentScore fromCSV(String value) {
	  String[] data = value.split(",");
	  
	  StudentScore obj = new StudentScore(data[0]);
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
