package lab.io.rush.business;

import lab.io.rush.config.Constant;
import lab.io.rush.dao.DaoManager;
import lab.io.rush.util.UtilMail;
import lab.io.rush.util.UtilSpring;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;
//��Ʊʵ����
public class OperationRob implements I_Operation {

	
	//�����߳�,ʵ���첽�洢����
	@Override
	public void save(String mail, String ticketName) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				DaoManager daoPersonManager = (DaoManager) UtilSpring
						.getApplicationContext().getBean("daoPersonManager");
				boolean isSaved = daoPersonManager.saveOrUpdate(mail,
						ticketName);
				while (!isSaved) {
					isSaved = daoPersonManager.saveOrUpdate(mail, ticketName);
				}
			}
		}).start();
	}

	//��ȡʣ��Ʊ����Ϣ
	@Override
	public String readLeftTicket() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis(Constant.PATH, Constant.PORT);
		StringBuilder ticketMessage = new StringBuilder();
		for (int i = 0; i < Constant.TICKET_ARRAY.length; i++) {
			String ticket = jedis.get(Constant.TICKET_ARRAY[i]);
			ticketMessage.append("(" + Constant.TICKET_ARRAY[i] + ")" + "Ϊ:"
					+ ticket + "��   ");
		}
		jedis.close();

		return ticketMessage.toString();
	}
	
	//�����̣߳��첽�����ʼ���
	@Override
	public void sendMail(String mail, String ticketName) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					UtilMail.sendMail(mail, ticketName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	//��Ʊ����ʵ��
	@Override
	public boolean robTicket(String ticketName) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis(Constant.PATH, Constant.PORT);
		String ticket = jedis.get(ticketName);
		int ticketInt = Integer.parseInt(ticket);
		if (ticketInt > 0) {
			Transaction tx = jedis.multi();
			Response<Long> result = tx.decr(ticketName);
			tx.exec();
			if (result.get() >= 0) {
				jedis.close();
				return true;
			} else {
				jedis.incr(ticketName);
				jedis.close();
				return false;
			}

		}
		return false;
	}

}
