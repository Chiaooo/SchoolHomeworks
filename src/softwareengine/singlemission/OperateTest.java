package softwareengine.singlemission;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class OperateTest {

	Operate op = new Operate();

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: getBalance()
	 */
	@Test
	public void testGetBalance() throws Exception {
//TODO: Test goes here...
		Assert.assertEquals(0.0, op.getBalance(), 0.0);
	}

	/**
	 * Method: setBalance(double balance)
	 */
	@Test
	public void testSetBalance() throws Exception {
//TODO: Test goes here...
		op.setBalance(1000);
		Assert.assertEquals(1000.0, op.getBalance(), 1000.0);
	}

	/**
	 * Method: getDeadline()
	 */
	@Test
	public void testGetDeadline() throws Exception {
//TODO: Test goes here...
		op.setTime(3);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(new Date().getTime());
		c.add(Calendar.MONTH, 3);
		Date date = new Date(c.getTimeInMillis());
		String deadline = format.format(date);
		Assert.assertEquals(deadline, op.getDeadline());

	}

	/**
	 * Method: getInterest()
	 */
	@Test
	public void testGetInterest() throws Exception {
//TODO: Test goes here...
		op.deposit(1, 3, 1000);
		Assert.assertEquals(3.375, op.getInterest(), 0.0);
	}

	/**
	 * Method: setInterest(double interest)
	 */
	@Test
	public void testSetInterest() throws Exception {
//TODO: Test goes here...
		Assert.assertEquals(1.0, op.setInterest(1.0), 0.0);
	}

	/**
	 * Method: deposit(int kind, int time, int money)
	 */
	@Test
	public void testDeposit() throws Exception {
//TODO: Test goes here...
		op.deposit(1, 3, 1000);
		Assert.assertEquals(1000.0, op.getBalance(), 0.0);
		Assert.assertEquals("2022/01/05", op.getDeadline());
		Assert.assertEquals(3.375, op.getInterest(), 0.0);
		op.deposit(2, 1, 10000);
		Assert.assertEquals(10000.0, op.getBalance(), 0.0);
		Assert.assertEquals("2021/11/05", op.getDeadline());
		Assert.assertEquals(2.5, op.getInterest(), 0.0);
	}

	/**
	 * Method: showDetails()
	 */
	@Test
	public void testShowDetails() throws Exception {
//TODO: Test goes here...
		Assert.assertEquals(0.0, op.getBalance(), 0.0);
		Assert.assertEquals(0.0, op.getInterest(), 0.0);
	}


} 
