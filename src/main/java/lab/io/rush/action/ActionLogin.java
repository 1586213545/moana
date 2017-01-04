package lab.io.rush.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import lab.io.rush.business.OperationManager;
import lab.io.rush.util.UtilSpring;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionLogin extends ActionSupport {
	//email��struts2ע���½��Ϣ
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//��emil�洢��session,����ȡʣ��Ʊ���浽application.ticketRemain;
	public String login() {
		ActionContext ctx = ActionContext.getContext();
		if (email != null && !email.equals("")) {
			ctx.getSession().put("email", email);
			OperationManager operation = (OperationManager) UtilSpring
					.getApplicationContext().getBean("operaManager");
			String ticketRemain = operation.readLeftTicket();
			ctx.getApplication().put("ticketRemain", ticketRemain);

		} else {
			return "login";
		}

		return SUCCESS;
	}
}
