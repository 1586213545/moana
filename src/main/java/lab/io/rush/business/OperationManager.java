package lab.io.rush.business;

//抢票管理类,调用时由Spring注入
public class OperationManager {
	private I_Operation operation;

	public OperationManager(I_Operation operation) {
		this.operation = operation;
	}

	public String readLeftTicket() {
		return operation.readLeftTicket();
	}

	public void sendMail(String mail, String ticketName) {
		operation.sendMail(mail, ticketName);
	}

	public boolean robTicket(String ticketName) {
		return operation.robTicket(ticketName);
	}

	public void save(String mail, String ticketName) {
		operation.save(mail, ticketName);
	}

}
