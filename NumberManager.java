import java.util.List;
import java.util.ArrayList;

/**
 * 号码管理器，用来管理三种类型的号码。利用同步锁的形式控制号码，当号码大于0，存在需要处理的客户时，才能获取号码
 * 将生成的号码添加到一个队列中。每次都是从队头获取要处理的客户号码
 * */
public class NumberManager {
	private Integer lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	
	public synchronized Integer generateNewNumber(){
		queueNumber.add(lastNumber);
		return lastNumber++;
	}
	
	public synchronized Integer getServiceNumber(){//获取服务号
		Integer number = null;
		
		if(queueNumber.size() > 0){
			return (Integer)queueNumber.remove(0);//返回队头元素
		}
		
		return number;
	}
}
