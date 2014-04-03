package basic.exam04.step03;

/* 콤마(,)로 구분된 문자열 데이터(comma seperated value; csv)로 부터
 * 인스턴스 생성하기
 * - 클래스 메서드(static method)의 활용 사례 공부
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
	  
	  // 객체를 만든다는것을 강조(확인하기 용이하도록)하기 위해 변수명을 obj 로 변경 
	  StudentScore obj = new StudentScore(data[0]);
	  obj.kor = Integer.parseInt(data[1]);
	  obj.eng = Integer.parseInt(data[2]);
	  obj.math = Integer.parseInt(data[3]);
	  
	  return obj;
	}
}
