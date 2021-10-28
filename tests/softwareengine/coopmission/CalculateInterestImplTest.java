package softwareengine.coopmission;

import org.junit.Assert;
import org.junit.Test;
import softwareengine.coopmission.dao.CalculateInterest;
import softwareengine.coopmission.dao.utils.CalculateInterestImpl;

import java.math.BigDecimal;

/**
 * CalculateInterestImpl Tester.
 *
 * @author 焦天&蒋兴华
 * @version 1.0
 * @since 09/30/2021
 */
public class CalculateInterestImplTest {

	CalculateInterest cal = new CalculateInterestImpl();

	/**
	 * Method: isType(String type)
	 */
	@Test
	public void testIsType() throws Exception {
		//TODO: Test goes here...
		boolean result = cal.isType("定期");
		Assert.assertTrue(result);
	}

	/**
	 * Method: isTime(int time, String type)
	 */
	@Test
	public void testIsTime() throws Exception {
		//TODO: Test goes here...
		boolean result = cal.isTime(3, "定期");
		Assert.assertTrue(result);
		result = cal.isTime(3, "活期");
		Assert.assertTrue(result);
	}

	/**
	 * Method: isAccount(String num)
	 */
	@Test
	public void testIsAccount() throws Exception {
		//TODO: Test goes here...
		boolean result = cal.isAccount("21");
		Assert.assertTrue(result);
		result = cal.isAccount("a");
		Assert.assertFalse(result);
	}

	/**
	 * Method: calculateInterest(int time, String type, BigDecimal money)
	 */
	@Test
	public void testCalculateInterest() throws Exception {
		//TODO: Test goes here...
		BigDecimal result = cal.calculateInterest(3, "定期", BigDecimal.valueOf(1000));
		Assert.assertEquals(3.38, result.doubleValue(), 0.0);
		result = cal.calculateInterest(3, "活期", BigDecimal.valueOf(1000));
		Assert.assertEquals(0.75, result.doubleValue(), 0.0);
		result = cal.calculateInterest(6, "定期", BigDecimal.valueOf(1000));
		Assert.assertEquals(7.75, result.doubleValue(), 0.0);
		result = cal.calculateInterest(12, "定期", BigDecimal.valueOf(1000));
		Assert.assertEquals(17.50, result.doubleValue(), 0.0);
		result = cal.calculateInterest(24, "定期", BigDecimal.valueOf(1000));
		Assert.assertEquals(45.00, result.doubleValue(), 0.0);
		result = cal.calculateInterest(36, "定期", BigDecimal.valueOf(1000));
		Assert.assertEquals(82.50, result.doubleValue(), 0.0);
		result = cal.calculateInterest(60, "定期", BigDecimal.valueOf(1000));
		Assert.assertEquals(137.50, result.doubleValue(), 0.0);
	}

} 
