package lab.io.rush.action;

import java.io.UnsupportedEncodingException;

import lab.io.rush.business.OperationManager;
import lab.io.rush.util.UtilSpring;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionRob extends ActionSupport {
	//ticketName��struts2ע����Ʊ����
	private String ticketName;
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	//������Ʊ���ܣ��洢�����ݿ⣬�������ʼ�;
	public String robTicket() throws UnsupportedEncodingException {
		System.out.println("��Ʊ����Ϊ:" + ticketName);
		ActionContext ctx = ActionContext.getContext();
		OperationManager operation = (OperationManager) UtilSpring.getApplicationContext().getBean("operaManager");
		boolean flag = operation.robTicket(ticketName);
		if (flag) {
			String ticketRemain = operation.readLeftTicket();
			ctx.getApplication().put("ticketRemain", ticketRemain);
			ctx.put("tip", "��ϲ��,�ɹ�����һ��" + ticketName + "��ӰƱ,�ѷ����ʼ�!");
			String email = (String) ctx.getSession().get("email");
			operation.save(email,ticketName);
			operation.sendMail(email,ticketName);
			return SUCCESS;
		}
		else {
			ctx.put("tip", "��Ʊʧ��!!");
			return "fail";
		}
	}
}
