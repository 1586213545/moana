package init;

import lab.io.rush.config.Constant;
import redis.clients.jedis.Jedis;

//�˳���ɳ�ʼ����Ʊ��Ϣ,ticketLeftΪʣ��Ʊ��;
public class InitRedis {
	public static void main(String[] args) {
		String ticketLeft = "300";
		Jedis jedis = new Jedis(Constant.PATH, Constant.PORT);
		for(int i = 0;i < Constant.TICKET_ARRAY.length; i++){
			jedis.set(Constant.TICKET_ARRAY[i], ticketLeft);
		}		
		System.out.println("��ʼ���ɹ�");
		jedis.close();
	}
}
