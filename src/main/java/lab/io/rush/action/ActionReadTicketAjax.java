package lab.io.rush.action;

import java.io.UnsupportedEncodingException;

import lab.io.rush.business.OperationManager;
import lab.io.rush.util.UtilSpring;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionReadTicketAjax extends ActionSupport {
	//info�洢���Ƿ��ص�json����;
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	//ajax�ӿ�,��ȡƱ��������application.ticketRemain,ע��info,����json���ݵ��ͻ���
	public String readTicket() throws UnsupportedEncodingException {
		ActionContext ctx = ActionContext.getContext();

		OperationManager operation = (OperationManager) UtilSpring.getApplicationContext()
				.getBean("operaManager");
		String ticketRemain = operation.readLeftTicket();
		System.out.println("Ajax�첽��ȡ����,��ǰƱ��:" + ticketRemain);

		ctx.getApplication().put("ticketRemain", ticketRemain);
		this.info = "" + ticketRemain;
		return SUCCESS;
	}
}
