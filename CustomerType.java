
/**
 * ����һ���ͻ����͵�ö���࣬�ѿͻ���������оٳ�����
 * */
public enum CustomerType {
	ordinary,
	quick,
	vip;
	
	//��дtoString()����
	public String toString(){
		String name = null;
		switch(this){
			case ordinary:
				return "��ͨ";
			case quick:
				return "����";
			case vip:
				return "VIP";
		}
		
		return name;
		
	}
}
