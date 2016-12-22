
/**
 * 这是一个客户类型的枚举类，把客户的种类放列举出来。
 * */
public enum CustomerType {
	ordinary,
	quick,
	vip;
	
	//重写toString()方法
	public String toString(){
		String name = null;
		switch(this){
			case ordinary:
				return "普通";
			case quick:
				return "快速";
			case vip:
				return "VIP";
		}
		
		return name;
		
	}
}
