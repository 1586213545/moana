package init;

import lab.io.rush.config.Constant;
import redis.clients.jedis.Jedis;

//此程序可初始化抢票信息,ticketLeft为剩余票数;
public class InitRedis {
	public static void main(String[] args) {
		String ticketLeft = "300";
		Jedis jedis = new Jedis(Constant.PATH, Constant.PORT);
		for(int i = 0;i < Constant.TICKET_ARRAY.length; i++){
			jedis.set(Constant.TICKET_ARRAY[i], ticketLeft);
		}		
		System.out.println("初始化成功");
		jedis.close();
	}
}
