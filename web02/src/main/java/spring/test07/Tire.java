package spring.test07;

import java.util.Date;

public class Tire {
	String 	maker;
	String		spec;
	Date			createdDate;
	
	public Tire() {}
	
	
	
	@Override
  public String toString() {
	  return "[타이어:" + maker + ", " + spec + ", " + 
	  		((createdDate !=null) ? createdDate.toString() : "") + "]";
  }



	public Tire(String maker, String spec) {
		this.maker = maker;
		this.spec = spec;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
