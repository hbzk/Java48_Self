package spring.test09;

public class Engine {
	String 	maker;
	int 			cc;
	
	public Engine() {}
	public Engine(String maker) {
		this.maker = maker;
	}
	
	
	@Override
  public String toString() {
	  return "[엔진:" + maker + ", " + cc + "]";
  }
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
}
