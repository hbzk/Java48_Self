package basic.exam06.jdbc.up7;

class Patient03 {
	private String name;
	private 	int age;
	private int weight;
	private 	int height;
	String bloodType;

	public Patient03 setName(String name) {
		this.name = name;
		return this;
	}
	
	// 필드의 값을 꺼내는 메서드: getter
	public String getName() {
	  return this.name;
  }
	
	public Patient03 setAge(int age) {
		// setter를 사용하면 중간에서 유효 값을 필터링 할 수 있다.
		// 나중에 필터링의 기준이 바뀌더라도 이 메서드만 변경하면 된다.
		if (age > 0 && age < 120) {
			this.age = age;
		}	else {
			this.age = 30;
		}
		return this;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Patient03 setWeight(int weight) {
		if (weight > 0 && weight < 300) {
			this.weight = weight;
		}	else {
			this.weight = 100;
		}
		return this;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public Patient03 setHeight(int height) {
		if (height > 0 && height < 300) {
			this.height = height;
		}	else {
			this.height = 180;
		}
		return this;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Patient03 setBloodType(String bloodType) {
		this.bloodType = bloodType;
		
		return this;
	}
	
	public String getBloodType() {
		return this.bloodType;
	}

	@Override
  public String toString() {
	  return "Patient02 [name=" + name + ", age=" + age + ", weight=" + weight
	      + ", height=" + height + ", bloodType=" + bloodType + "]";
  }
	
	
}



public class Episode03 {
	
	public static void main(String[] args) {
		
		System.out.println(new Patient03()
				.setName("홍길동")
				.setAge(-200)
				.setWeight(-90)
				.setHeight(280)
				.setBloodType("O"));
		
		
	}
}
