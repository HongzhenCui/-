import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//�������е���ϵͳ������࣬�������߳�
//������ͨ������Ŀ�����ٴ�����Ŀ��VIP������Ŀ = 4 �� 1:1��1-4��Ϊ��ͨ���ڣ�5��Ϊ���ٴ��ڣ�6��ΪVIP����
public class MainClass {
	public static void main(String[] args) {
		for(int i = 1; i < 5; i++){
			ServiceWindow ordinaryWindow = new ServiceWindow();//����ͨ�����񴰿ڶ���
			ordinaryWindow.setWindowId(i);//���÷��񴰿ڶ����id
			ordinaryWindow.start();//�����߳�
		}
		
		ServiceWindow quickWindow = new ServiceWindow();//"����"���񴰿ڶ���
		quickWindow.setType(CustomerType.quick);;//���á����١����ڷ������
		quickWindow.start();//�����߳�
		
		ServiceWindow vipWindow = new ServiceWindow();//"vip"���񴰿ڶ���
		vipWindow.setType(CustomerType.vip);//���á�VIP�����ڷ�������idΪ6
		vipWindow.start();
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					public void run(){
						Integer number = NumberMachine.getInstance().getOrdinaryManager().generateNewNumber();
						System.out.println("  ��*" + number + "*����ͨ�ͻ��ȴ��к�");
					}
					
				},
				0,
				Constants.ordinaryInternalServiceTime,TimeUnit.SECONDS
		);
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){
					public void run() {
						Integer number = NumberMachine.getInstance().getQuickManager().generateNewNumber();
						System.out.println("  ��*" + number + "*�ſ��ٿͻ��ȴ��к�");						
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
						System.out.println("  ��*" + number + "*��vip�ͻ��ȴ��к�");						
					}					
				}, 
				0, 
				Constants.ordinaryInternalServiceTime*6,
				TimeUnit.SECONDS
		);
		
		
	}
	
}
