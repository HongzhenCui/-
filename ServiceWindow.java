import java.util.Random;
import java.util.concurrent.Executors;

/**
 * 这是服务窗口类
 * 该部分用来实现各个窗口的服务功能。
 * 说明： 1、普通客户相对来说比较多，默认类型设为“普通”客户类型type
 * 	    2、设置服务窗口号变量 windowId
 * 		3、通过线程来启动各个窗口类型服务
 * */
public class ServiceWindow {
	//设置服务类型变量
	private CustomerType type = CustomerType.ordinary;//默认情况为“普通”客户类型
	private int windowId = 1;
	
	public CustomerType getType() {
		return type;
	}
	public void setType(CustomerType type) {
		this.type = type;
	}
	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}
	
	public void start(){
		Executors.newSingleThreadExecutor().execute(new Runnable(){

			@Override
			public void run() {
				while(true){
					switch(type){
						case ordinary:
							ordinaryService();
							break;
						case quick:
							quickService();
							break;
						case vip:
							vipService();
							break;
					}
				}				
			}			
		});
	}
	
	//"普通"类型客户服务
	public void ordinaryService(){
		String windowName = "\"" + type + "类\"" +"第" + windowId + "号";
		Integer number = NumberMachine.getInstance().getOrdinaryManager().getServiceNumber();
		System.out.println(windowName + "正在获取任务");
		if(number != null){
			System.out.println(windowName + "开始为第" + number + "号普通客户服务");
			int randTime = Constants.maxServiceTime-Constants.minServiceTime;
			long time = new Random().nextInt(randTime) + 1 + Constants.minServiceTime;
			try{
				Thread.sleep(time);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(windowName + "为第" + number + "个" + "普通" + "客户完成服务，耗时" + time/1000 + "秒。");
		}else{
			System.out.println(windowName + "没有取到服务号，等待秒");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	//"快速"类型客户服务
	public void quickService(){
		String windowName = "\"" + type + "类\"" +"第" + windowId + "号";
		Integer number = NumberMachine.getInstance().getQuickManager().getServiceNumber();
		System.out.println(windowName + "正在获取快速任务");
		if(number != null){
			System.out.println(windowName + "开始为第" + number + "号快速客户服务");
			int time = Constants.minServiceTime;
			try{
				Thread.sleep(Constants.minServiceTime);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(windowName + "为第" + number + "个" + "快速" + "客户完成服务，耗时" + time/1000 + "秒。");
		}else{
			System.out.println(windowName + "没有取到快速服务任务");
			ordinaryService();
		}
	}
	
	//"vip"类型客户服务
	public void vipService(){
		String windowName = "\"" + type + "类\"" +"第" + windowId + "号";
		Integer number = NumberMachine.getInstance().getVipManager().getServiceNumber();
		System.out.println(windowName + "正在获取VIP任务");
		if(number != null){
			System.out.println(windowName + "开始为" + number + "好VIP客户服务");
			int randTime = Constants.maxServiceTime - Constants.minServiceTime;
			long time = new Random().nextInt(randTime) + 1 + Constants.minServiceTime;
			try{
				Thread.sleep(time);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(windowName + "为第" + number + "个" + "vip" + "客户完成服务，耗时" + time/1000 + "秒。");
		}else{
			System.out.println(windowName + "没有取到vip服务任务");
			ordinaryService();
		}
	}
}
