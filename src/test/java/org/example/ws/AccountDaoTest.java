package org.example.ws;

import static org.junit.Assert.assertNotNull;

import org.example.ws.dao.AccountDao;
import org.example.ws.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class AccountDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private AccountDao accountDao;

//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		ApplicationContext ctx = new FileSystemXmlApplicationContext(
//				"src/main/resource/applicationContext.xml");
//		accountDao = (AccountDao) ctx.getBean("accountDao");
//		Account account;
//		for (int i = 0; i < 5; i++) {
//			account = new Account();
//			account.setActId(i);
//			account.setName("Test" + i);
//			accountDao.save(account);
//		}
//	}
	@Test
	public void testFirst(){
		Account entity = new Account();
		entity.setActId(100);
		entity.setName("Test");
		Account account = accountDao.save(entity);
		assertNotNull(account.getActId());
		System.out.println(account.getActId());
	}
	
//	@Override
//	protected void tearDown() throws Exception {
//		super.tearDown();
//		Account account;
//		for (int i = 0; i < 5; i++) {
//			account = new Account();
//			account.setActId(i);
//			accountDao.delete(account);
//		}
//	}

//	public void testSave() {
//		Account entity = new Account();
//		entity.setActId(100);
//		entity.setName("Test");
//		Account account = accountDao.save(entity);
//		assertNotNull(account.getActId());
//	}
//
//	public void testSaveOrUpdate() {
//		Account entity = new Account();
//		entity.setActId(100);
//		entity.setName("XXXX");
//		Account account = accountDao.saveOrUpdate(entity);
//		assertNotNull(account.getActId());
//		assertEquals("XXXX", account.getName());
//	}
//
//	public void testUpdate() {
//		Account entity = new Account();
//		entity.setActId(100);
//		entity.setName("YYYY");
//		Account account = accountDao.update(entity);
//		assertNotNull(account.getActId());
//		assertEquals("YYYY", account.getName());
//	}
//
//	public void testGetObjectById() {
//		Account account = accountDao.getObjectById(100);
//		assertNotNull(account.getActId());
//		assertEquals("YYYY", account.getName());
//	}
//
//	// public void testLoadObjectById() {
//	// Account account = accountDao.loadObjectById(100);
//	// assertNotNull(account.getActId());
//	// assertEquals("YYYY", account.getName());
//	// }
//
//	public void testExecuteDelOrUpdateCmd() {
//		String sql = "update account set name='test' where act_id = 100";
//		accountDao.executeDelOrUpdateCmd(sql, false);
//
//		String hql = "update Account set name='test' where actId = 100";
//		accountDao.executeDelOrUpdateCmd(hql, true);
//	}
//
//	public void testExecuteDelOrUpdateCmdAndParams() {
//		String sql = "update account set name='test' where act_id = ?";
//		accountDao.executeDelOrUpdateCmdAndParams(sql, new Object[] { 100 },
//				false);
//
//		String hql = "update Account set name='test' where actId = ?";
//		accountDao.executeDelOrUpdateCmdAndParams(hql, new Object[] { 100 },
//				true);
//	}
//
//	public void testDelete() {
//		Account entity = new Account();
//		entity.setActId(100);
//		accountDao.delete(entity);
//	}
//
//	public void testFindAll() {
//		List<Account> accounts = accountDao.findAll();
//		assertNotNull(accounts);
//		assertSame(5, accounts.size());
//	}
//
//	public void testFindListByParams() {
//		String hql = "from Account where name like ?";
//		List<Account> accounts = accountDao.findListByParams(hql,
//				new Object[] { "%Test%" });
//		assertNotNull(accounts);
//		assertSame(5, accounts.size());
//	}
//
//	public void testFindListByLength() {
//		String hql = "from Account";
//		List<Account> accounts = accountDao.findListByLength(hql, 1, 2);
//		assertNotNull(accounts);
//		assertSame(2, accounts.size());
//		assertEquals("Test2", accounts.get(1).getName());
//	}
//
//	public void testFindListByLengthAndParams() {
//		String hql = "from Account where name like ?";
//		List<Account> accounts = accountDao.findListByLengthAndParams(hql,
//				new Object[] { "%Test%" }, 1, 2);
//		assertNotNull(accounts);
//		assertSame(2, accounts.size());
//		assertEquals("Test2", accounts.get(1).getName());
//	}
//
//	public void testFindListByPage() {
//		String hql = "from Account";
//		List<Account> accounts1 = accountDao.findListByPage(hql, 1, 3);
//		// 一共5条数据，每页显示两条，显示第二页
//		List<Account> accounts2 = accountDao.findListByPage(hql, 2, 3);
//		assertSame(3, accounts1.size());
//		assertSame(2, accounts2.size());
//	}
//
//	public void testFindListByPageAndParams() {
//		String hql = "from Account  where name like ?";
//		List<Account> accounts1 = accountDao.findListByPageAndParams(hql,
//				new Object[] { "%Test%" }, 1, 3);
//		// 一共5条数据，每页显示两条，显示第二页
//		List<Account> accounts2 = accountDao.findListByPageAndParams(hql,
//				new Object[] { "%Test%" }, 2, 3);
//		assertSame(3, accounts1.size());
//		assertSame(2, accounts2.size());
//	}
//
//	public void testQueryByHql() {
//		String hql = "from Account where actId = 0";
//		Account obj = accountDao.queryByHql(hql);
//		assertNotNull(obj);
//		assertEquals("Test0", obj.getName());
//
//		String hql1 = "from Account where actId = 1000";
//		Account obj1 = accountDao.queryByHql(hql1);
//		assertNull(obj1);
//	}
//
//	public void testQueryByHqlAndParams() {
//		String hql = "from Account where actId = ?";
//		Account obj = accountDao.queryByHqlAndParams(hql, new Object[] { 0 });
//		assertNotNull(obj);
//		assertEquals("Test0", obj.getName());
//
//		String hql1 = "from Account where actId = ?";
//		Account obj1 = accountDao.queryByHqlAndParams(hql1,
//				new Object[] { 101 });
//		assertNull(obj1);
//	}

}
