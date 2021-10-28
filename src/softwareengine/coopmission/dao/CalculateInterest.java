package softwareengine.coopmission.dao;

import java.math.BigDecimal;

/**
 * @author 焦天&蒋兴华
 * 2021-09-30 15:07  ver1.0
 */

public interface CalculateInterest {
	int THREE_MONTH = 3;
	int SIX_MONTH = 6;
	int ONE_YEAR = 12;
	int TWO_YEAR = 24;
	int THREE_YEAR = 36;
	int FIVE_YEAR = 60;

	/**
	 * 活期类型及利率
	 */
	String DEPOSIT_TYPE_1 = "活期";
	BigDecimal DEPOSIT_TYPE_1_INTEREST = BigDecimal.valueOf(0.003);

	/**
	 * 定期类型及利率
	 */
	String DEPOSIT_TYPE_2 = "定期";
	BigDecimal DEPOSIT_TYPE_2_3M = BigDecimal.valueOf(0.0135);
	BigDecimal DEPOSIT_TYPE_2_6M = BigDecimal.valueOf(0.0155);
	BigDecimal DEPOSIT_TYPE_2_1Y = BigDecimal.valueOf(0.0175);
	BigDecimal DEPOSIT_TYPE_2_2Y = BigDecimal.valueOf(0.0225);
	BigDecimal DEPOSIT_TYPE_2_3Y = BigDecimal.valueOf(0.0275);
	BigDecimal DEPOSIT_TYPE_2_5Y = BigDecimal.valueOf(0.0275);


	/**
	 * 判断存款类型
	 *
	 * @param type -> 存款类型
	 * @return -> 是否写入正确类型
	 */
	boolean isType(String type);

	/**
	 * 判断存款时间
	 *
	 * @param time -> 存款时间
	 * @param type -> 存款类型
	 * @return -> 是否写入正确时间
	 */
	boolean isTime(int time, String type);

	/**
	 * 判断存款时间
	 *
	 * @param num -> 存款账号
	 * @return -> 是否写入正确账号
	 */
	boolean isAccount(String num);

	/**
	 * 计算利息
	 *
	 * @param time  -> 存款时间
	 * @param type  -> 存款类型
	 * @param money -> 存款金额
	 * @return -> 使用setScale方法，返回小数点后两位并且向上四舍五入
	 */
	BigDecimal calculateInterest(int time, String type, BigDecimal money);

	/**
	 * 计算利率
	 *
	 * @param time —> 存款时间
	 * @param type -> 存款类型
	 * @return -> 返回利率
	 */
	BigDecimal getInterest(int time, String type);

	/**
	 * 计算活期利率
	 *
	 * @return -> 返回活期利率
	 */
	BigDecimal getType1Interest();

	/**
	 * 计算定期利率
	 *
	 * @return -> 返回定期利率
	 */
	BigDecimal getType2Interest(int time);

}
