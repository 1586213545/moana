package lab.io.rush.util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
//JDO������
public class UtilJdo {
	public static PersistenceManagerFactory pmf = JDOHelper
			.getPersistenceManagerFactory("Tutorial");

	public static PersistenceManagerFactory getPmf() {
		return pmf;
	}
}
