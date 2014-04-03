
public class Self {
	String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		Self cat = new Self();
		cat.setName("body");
		System.out.println(cat.name);
	}

}

// 객체가 넘어오면 객체의 속성 값을 변경 할 수 있게 된다는 사실만 기억하도록 하자.
