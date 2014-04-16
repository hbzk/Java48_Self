package episode.ex2;

// 원래 객체의 역할을 대행해 주는 역할
// - 원래 객체가 일을하기 전에 삭전 작업을 수행하거나
// - 원래 개체 일을 한 후에 사후 작업을 수행한다.
// - 원래 할 일은 원래의 객체에 넘김

// = Aspect-Oriented Programing (AOP): 관점지향 프로그래밍
// 	=> 메서드 앞 뒤로 기능
public class MyFilter extends MyClass implements Filter {
	
	@Override
  public void preDo() {
	  System.out.println("원래 메서드가 호출되기 전에 해야할 작업이 있다면 한다!");
  }
	
	@Override
	public void m() {
		preDo();
		super.m();
		postDo();
	};
	
	@Override
  public void postDo() {
	  System.out.println("원래 메서드가 호출된 후에 해야할 일이 있다면 한다.");
  }
	
	
}
