package lab.io.rush.action;

import java.io.UnsupportedEncodingException;

import lab.io.rush.business.OperationManager;
import lab.io.rush.util.UtilSpring;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionRob extends ActionSupport {
	//ticketName由struts2注入抢票种类
	private String ticketName;
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	//调用抢票功能，存储到数据库，并发送邮件;
	public String robTicket() throws UnsupportedEncodingException {
		System.out.println("抢票种类为:" + ticketName);
		ActionContext ctx = ActionContext.getContext();
		OperationManager operation = (OperationManager) UtilSpring.getApplicationContext().getBean("operaManager");
		boolean flag = operation.robTicket(ticketName);
		if (flag) {
			String ticketRemain = operation.readLeftTicket();
			ctx.getApplication().put("ticketRemain", ticketRemain);
			ctx.put("tip", "恭喜您,成功抢到一张" + ticketName + "电影票,已发送邮件!");
			String email = (String) ctx.getSession().get("email");
			operation.save(email,ticketName);
			operation.sendMail(email,ticketName);
			return SUCCESS;
		}
		else {
			ctx.put("tip", "抢票失败!!");
			return "fail";
		}
	}
}
