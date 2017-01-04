package lab.io.rush.business;
//ÇÀÆ±½Ó¿Ú
public interface I_Operation {
	String readLeftTicket();
	void sendMail(String mail,String ticketName);
	boolean robTicket(String ticketName);
	void save(String mail,String ticketName);
}
