import java.util.Random;
import java.util.concurrent.Executors;

/**
 * ���Ƿ��񴰿���
 * �ò�������ʵ�ָ������ڵķ����ܡ�
 * ˵���� 1����ͨ�ͻ������˵�Ƚ϶࣬Ĭ��������Ϊ����ͨ���ͻ�����type
 * 	    2�����÷��񴰿ںű��� windowId
 * 		3��ͨ���߳������������������ͷ���
 * */
public class ServiceWindow {
	//���÷������ͱ���
	private CustomerType type = CustomerType.ordinary;//Ĭ�����Ϊ����ͨ���ͻ�����
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
	
	//"��ͨ"���Ϳͻ�����
	public void ordinaryService(){
		String windowName = "\"" + type + "��\"" +"��" + windowId + "��";
		Integer number = NumberMachine.getInstance().getOrdinaryManager().getServiceNumber();
		System.out.println(windowName + "���ڻ�ȡ����");
		if(number != null){
			System.out.println(windowName + "��ʼΪ��" + number + "����ͨ�ͻ�����");
			int randTime = Constants.maxServiceTime-Constants.minServiceTime;
			long time = new Random().nextInt(randTime) + 1 + Constants.minServiceTime;
			try{
				Thread.sleep(time);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(windowName + "Ϊ��" + number + "��" + "��ͨ" + "�ͻ���ɷ��񣬺�ʱ" + time/1000 + "�롣");
		}else{
			System.out.println(windowName + "û��ȡ������ţ��ȴ���");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	//"����"���Ϳͻ�����
	public void quickService(){
		String windowName = "\"" + type + "��\"" +"��" + windowId + "��";
		Integer number = NumberMachine.getInstance().getQuickManager().getServiceNumber();
		System.out.println(windowName + "���ڻ�ȡ��������");
		if(number != null){
			System.out.println(windowName + "��ʼΪ��" + number + "�ſ��ٿͻ�����");
			int time = Constants.minServiceTime;
			try{
				Thread.sleep(Constants.minServiceTime);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(windowName + "Ϊ��" + number + "��" + "����" + "�ͻ���ɷ��񣬺�ʱ" + time/1000 + "�롣");
		}else{
			System.out.println(windowName + "û��ȡ�����ٷ�������");
			ordinaryService();
		}
	}
	
	//"vip"���Ϳͻ�����
	public void vipService(){
		String windowName = "\"" + type + "��\"" +"��" + windowId + "��";
		Integer number = NumberMachine.getInstance().getVipManager().getServiceNumber();
		System.out.println(windowName + "���ڻ�ȡVIP����");
		if(number != null){
			System.out.println(windowName + "��ʼΪ" + number + "��VIP�ͻ�����");
			int randTime = Constants.maxServiceTime - Constants.minServiceTime;
			long time = new Random().nextInt(randTime) + 1 + Constants.minServiceTime;
			try{
				Thread.sleep(time);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(windowName + "Ϊ��" + number + "��" + "vip" + "�ͻ���ɷ��񣬺�ʱ" + time/1000 + "�롣");
		}else{
			System.out.println(windowName + "û��ȡ��vip��������");
			ordinaryService();
		}
	}
}
