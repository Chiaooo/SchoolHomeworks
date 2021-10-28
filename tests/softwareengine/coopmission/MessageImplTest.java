package softwareengine.coopmission;

import org.junit.Assert;
import org.junit.Test;
import softwareengine.coopmission.dao.Message;
import softwareengine.coopmission.dao.utils.MessageImpl;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;

/**
 * MessageImpl Tester.
 *
 * @author 蒋兴华&焦天
 * @version 1.0
 * @since 09/30/2021
 */
public class MessageImplTest {

	/**
	 * Method: getName(String msg)
	 */
	@Test(expected = StackOverflowError.class)
	public void testGetName() throws Exception {
		//TODO: Test goes here...
		ByteArrayInputStream in = new ByteArrayInputStream("焦天".getBytes());
		Message msg = new MessageImpl(in);
		String a = msg.getName("请输入用户名");
		Assert.assertNotNull(a);

		in = new ByteArrayInputStream("".getBytes());
		msg = new MessageImpl(in);
		a = msg.getName("请输入用户名");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream(null);
		msg = new MessageImpl(in);
		a = msg.getName("请输入用户名");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("\r".getBytes());
		msg = new MessageImpl(in);
		a = msg.getName("请输入用户名");
		Assert.assertNotNull(a);
	}

	/**
	 * Method: getAccount(String msg)
	 */
	@Test(expected = StackOverflowError.class)
	public void testGetAccount() throws Exception {
//TODO: Test goes here...
		ByteArrayInputStream in = new ByteArrayInputStream("20214211".getBytes());
		Message msg = new MessageImpl(in);
		Integer a = msg.getAccount("请输入账号");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("".getBytes());
		msg = new MessageImpl(in);
		a = msg.getAccount("请输入账号");
		Assert.assertNotNull(a);
	}

	/**
	 * Method: getMoney(String msg)
	 */
	@Test(expected = StackOverflowError.class)
	public void testGetMoney() throws Exception {
//TODO: Test goes here...
		ByteArrayInputStream in = new ByteArrayInputStream("1000".getBytes());
		Message msg = new MessageImpl(in);
		BigDecimal a = msg.getMoney("请输入存款金额");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("".getBytes());
		msg = new MessageImpl(in);
		a = msg.getMoney("");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("0".getBytes());
		msg = new MessageImpl(in);
		a = msg.getMoney("");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("a".getBytes());
		msg = new MessageImpl(in);
		a = msg.getMoney("");
		Assert.assertNotNull(a);
	}

	/**
	 * Method: getType(String msg)
	 */
	@Test(expected = StackOverflowError.class)
	public void testGetType() throws Exception {
//TODO: Test goes here...
		ByteArrayInputStream in = new ByteArrayInputStream("活期".getBytes());
		Message msg = new MessageImpl(in);
		String a = msg.getType("请输入存款类型");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("定期".getBytes());
		msg = new MessageImpl(in);
		a = msg.getType("请输入存款类型");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("".getBytes());
		msg = new MessageImpl(in);
		a = msg.getType("");
		Assert.assertNotNull(a);
	}

	/**
	 * Method: getTime(String msg, String type)
	 */
	@Test(expected = StackOverflowError.class)
	public void testGetTime() throws Exception {
		//TODO: Test goes here... 
		ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
		Message msg = new MessageImpl(in);
		Integer a = msg.getTime("请输入存款时间", "定期");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("6".getBytes());
		msg = new MessageImpl(in);
		a = msg.getTime("请输入存款时间", "活期");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("".getBytes());
		msg = new MessageImpl(in);
		a = msg.getTime("请输入存款时间", "活期");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("".getBytes());
		msg = new MessageImpl(in);
		a = msg.getTime("请输入存款时间", "定期");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("6".getBytes());
		msg = new MessageImpl(in);
		a = msg.getTime("请输入存款时间", "");
		Assert.assertNotNull(a);
		in = new ByteArrayInputStream("".getBytes());
		msg = new MessageImpl(in);
		a = msg.getTime("请输入存款时间", "");
		Assert.assertNotNull(a);

	}


} 
