package softwareengine.coopmission.dao;

import java.math.BigDecimal;

/**
 * @author 焦天&蒋兴华
 * 2021-09-30 15:07  ver1.0
 */

public interface Message {


	/**
	 * 获取输入的用户名称
	 *
	 * @param msg 返回信息提示
	 * @return 返回用户
	 */
	String getName(String msg);

	/**
	 * 获取输入的账户
	 *
	 * @param msg 提示消息
	 * @return 返回账号
	 */
	Integer getAccount(String msg);

	/**
	 * 获取输入的金额
	 *
	 * @param msg 返回信息提示
	 * @return 返回存款金额
	 */
	BigDecimal getMoney(String msg);

	/**
	 * 获取输入的存款类型
	 *
	 * @param msg 提示消息
	 * @return 返回存款类型
	 */
	String getType(String msg);

	/**
	 * 获取输入的存款时间
	 *
	 * @param msg  提示消息
	 * @param type 存款类型
	 * @return 返回存款时间
	 */
	Integer getTime(String msg, String type);

}
