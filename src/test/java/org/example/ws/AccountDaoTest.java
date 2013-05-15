package org.example.ws;

import org.example.ws.bean.Account;
import org.example.ws.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.TestCase;

public class AccountDaoTest extends TestCase {

	AccountDao accountDao;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/java/applicationContext.xml");
		accountDao = (AccountDao) ctx.getBean("AccountDao");
	}

	public void testDelete() {
		Account a = new Account();
		a.setActId(1);
		a.setName("JACK");
		Account b = accountDao.save(a);
	}
}
