package basic.exam06.jdbc;

class KimGaNeKimBab implements KimBab {
  public void taste() {
  	System.out.println("맛있다.");
  }
}

class KimGaNeStore implements KimBabStore {
  public KimBab create() { 	// > KimBab은 인터페이스지만, KimBab 을 구현한 클래스 주소를 담을 수 있다
	  return new KimGaNeKimBab();
  }
	
}

class KimGaNeBuilder implements KimBabStoreBuilder {
  public KimBabStore build() {
	  return new KimGaNeStore();
  }
}