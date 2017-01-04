package lab.io.rush.dao;
//ORM管理类，由Spring注入
public class DaoManager {
	private I_DaoPerson daoPerson;

	public DaoManager(I_DaoPerson daoPerson) {
		this.daoPerson = daoPerson;
	}

	public boolean saveOrUpdate(String mail, String ticketName) {
		return daoPerson.saveOrUpdate(mail, ticketName);
	}
}
