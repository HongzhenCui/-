/**
 * ����һ��������������ÿһ���ͻ��������к󣬶����ں����������������Լ���Ӧ��ɫ�ĺ��룬��ͨ����(ordinary)�����ٺ���(quick)��VIP����(vip)
 * ÿһ�ֺ��붼�Ǵ�1��ʼ����������������ÿ��ֻ������һ�����룬���õ���ģʽ���������ɱ�����
 * */
public class NumberMachine {
	private NumberMachine(){}
	
	//ͨ������ģʽ�����ƺ���ʵ��
	private static NumberMachine instance = new NumberMachine();
	public static NumberMachine getInstance(){
		return instance;
	}
	
	//������Ӧ�Ľ�ɫ����
	private NumberManager ordinaryManager = new NumberManager();//��ͨ
	private NumberManager quickManager = new NumberManager();//����
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
