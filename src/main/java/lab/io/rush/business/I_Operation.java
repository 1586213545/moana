package lab.io.rush.business;
//��Ʊ�ӿ�
public interface I_Operation {
	String readLeftTicket();
	void sendMail(String mail,String ticketName);
	boolean robTicket(String ticketName);
	void save(String mail,String ticketName);
}
