package lab.io.rush.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import lab.io.rush.entity.Person;
import lab.io.rush.entity.Ticket;
import lab.io.rush.util.UtilJdo;
//Dao实现类,存储抢票信息.
public class DaoMariaDb implements I_DaoPerson {

	@Override
	public boolean saveOrUpdate(String email, String ticketName) {
		// TODO Auto-generated method stub
		PersistenceManager pm = UtilJdo.pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query query = pm.newQuery("SELECT FROM " + Person.class.getName()
					+ " where email == '" + email + "'");
			List<Person> persons = query.executeList();
			if (persons.isEmpty()) {
				Person person = new Person();
				person.setEmail(email);
				Ticket ticket = new Ticket();
				ticket.setName(ticketName);
				person.getTickets().add(ticket);
				pm.makePersistent(person);
			} else {
				Person person = persons.get(0);
				Ticket ticket = new Ticket();
				ticket.setName(ticketName);
				person.getTickets().add(ticket);
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
			return false;
		} finally {
			pm.close();
		}
		return true;
	}

}
