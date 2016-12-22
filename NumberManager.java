import java.util.List;
import java.util.ArrayList;

/**
 * ��������������������������͵ĺ��롣����ͬ��������ʽ���ƺ��룬���������0��������Ҫ����Ŀͻ�ʱ�����ܻ�ȡ����
 * �����ɵĺ�����ӵ�һ�������С�ÿ�ζ��ǴӶ�ͷ��ȡҪ����Ŀͻ�����
 * */
public class NumberManager {
	private Integer lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	
	public synchronized Integer generateNewNumber(){
		queueNumber.add(lastNumber);
		return lastNumber++;
	}
	
	public synchronized Integer getServiceNumber(){//��ȡ�����
		Integer number = null;
		
		if(queueNumber.size() > 0){
			return (Integer)queueNumber.remove(0);//���ض�ͷԪ��
		}
		
		return number;
	}
}
