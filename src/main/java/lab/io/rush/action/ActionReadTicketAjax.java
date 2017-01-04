package lab.io.rush.action;

import java.io.UnsupportedEncodingException;

import lab.io.rush.business.OperationManager;
import lab.io.rush.util.UtilSpring;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionReadTicketAjax extends ActionSupport {
	//info存储的是返回的json数据;
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	//ajax接口,读取票数，更新application.ticketRemain,注入info,返回json数据到客户端
	public String readTicket() throws UnsupportedEncodingException {
		ActionContext ctx = ActionContext.getContext();

		OperationManager operation = (OperationManager) UtilSpring.getApplicationContext()
				.getBean("operaManager");
		String ticketRemain = operation.readLeftTicket();
		System.out.println("Ajax异步读取数据,当前票数:" + ticketRemain);

		ctx.getApplication().put("ticketRemain", ticketRemain);
		this.info = "" + ticketRemain;
		return SUCCESS;
	}
}
