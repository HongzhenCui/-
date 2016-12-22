/**
 * 这是一个号码生成器，每一个客户到达银行后，都会在号码生成器上生成自己对应角色的号码，普通号码(ordinary)，快速号码(quick)，VIP号码(vip)
 * 每一种号码都是从1开始计数，号码生成器每次只能生成一个号码，故用单例模式来控制生成变量。
 * */
public class NumberMachine {
	private NumberMachine(){}
	
	//通过单例模式来控制号码实例
	private static NumberMachine instance = new NumberMachine();
	public static NumberMachine getInstance(){
		return instance;
	}
	
	//声明对应的角色对象
	private NumberManager ordinaryManager = new NumberManager();//普通
	private NumberManager quickManager = new NumberManager();//快速
	private NumberManager vipManager = new NumberManager();//VIP
	
	public NumberManager getOrdinaryManager() {
		return ordinaryManager;
	}
	public NumberManager getQuickManager() {
		return quickManager;
	}
	public NumberManager getVipManager() {
		return vipManager;
	}
	
	
}
