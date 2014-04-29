package spring.test08;

import java.util.Date;
import java.util.Map.Entry;
import java.util.Properties;

public class Tire {
	String 	maker;
	Properties		spec;
	Date			createdDate;
	
	public Tire() {}
	
	
	
	@Override
  public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[타이어:" + maker + "\n");
		
		
		for (Entry<Object,Object> entry : spec.entrySet()) {
			buf.append("   >" + entry.getKey() + ":" + entry.getValue() + "\n");
		}
		
	  return "  > [타이어:" + maker + "\n > " + spec + "\n > " + 
	  		((createdDate !=null) ? createdDate.toString() : "") + "]";
  }



	public Tire(String maker) {
		this.maker = maker;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Properties getSpec() {
		return spec;
	}
	
	public void setSpec(Properties spec) {
		this.spec = spec;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
