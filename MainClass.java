import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//这是银行调度系统的入口类，包含多线程
//其中普通窗口数目：快速窗口数目：VIP窗口数目 = 4 ： 1:1且1-4号为普通窗口，5号为快速窗口，6号为VIP窗口
public class MainClass {
	public static void main(String[] args) {
		for(int i = 1; i < 5; i++){
			ServiceWindow ordinaryWindow = new ServiceWindow();//“普通”服务窗口对象
			ordinaryWindow.setWindowId(i);//设置服务窗口对象的id
			ordinaryWindow.start();//启动线程
		}
		
		ServiceWindow quickWindow = new ServiceWindow();//"快速"服务窗口对象
		quickWindow.setType(CustomerType.quick);;//设置“快速”窗口服务对象
		quickWindow.start();//启动线程
		
		ServiceWindow vipWindow = new ServiceWindow();//"vip"服务窗口对象
		vipWindow.setType(CustomerType.vip);//设置“VIP”窗口服务对象的id为6
		vipWindow.start();
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					public void run(){
						Integer number = NumberMachine.getInstance().getOrdinaryManager().generateNewNumber();
						System.out.println("  第*" + number + "*号普通客户等待叫号");
					}
					
				},
				0,
				Constants.ordinaryInternalServiceTime,TimeUnit.SECONDS
		);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					public void run() {
						Integer number = NumberMachine.getInstance().getQuickManager().generateNewNumber();
						System.out.println("  第*" + number + "*号快速客户等待叫号");						
					}					
				},
				0,
				Constants.ordinaryInternalServiceTime*3,
				TimeUnit.SECONDS
		);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					public void run() {
						Integer number = NumberMachine.getInstance().getVipManager().generateNewNumber();
						System.out.println("  第*" + number + "*号vip客户等待叫号");						
					}					
				}, 
				0, 
				Constants.ordinaryInternalServiceTime*6,
				TimeUnit.SECONDS
		);
		
		
	}
	
}
