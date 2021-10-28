package softwareengine.coopmission.dao.utils;

import softwareengine.coopmission.dao.CalculateInterest;
import softwareengine.coopmission.dao.Message;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author 焦天&蒋兴华
 * 2021-09-30 15:07  ver1.0
 */

public class MessageImpl implements Message {
	Scanner in = null;

	public MessageImpl(InputStream input) {
		in = new Scanner(input);
	}


	@Override
	public String getName(String msg) {
		System.out.println(msg);
		if (in.hasNextLine()) {
			String falseUser = in.nextLine();
			if (falseUser == null) {
				return getName("用户名不能为空");
			} else {
				String user = falseUser.trim();
				if ("".equals(user)) {
					return getName("用户名不能为空");
				} else {
					return user;
				}
			}
		} else {
			return getName("用户名不能为空");
		}
	}

	@Override
	public Integer getAccount(String msg) {
		System.out.println(msg);
		CalculateInterest cal = new CalculateInterestImpl();
		if (in.hasNextLine()) {
			String falseAccount = in.nextLine();
			if (falseAccount == null) {
				return getAccount("账号不能为空");
			} else {
				String stringAccount = falseAccount.trim();
				if ("".equals(stringAccount)) {
					return getAccount("账号不能为空");
				} else {
					if (!cal.isAccount(stringAccount)) {
						return getAccount("账号格式错误，请重新输入（整数）：");
					} else {
						int account = Integer.parseInt(stringAccount);
						return account;
					}
				}
			}
		} else {
			return getAccount("账号不能为空");
		}
	}

	@Override
	public BigDecimal getMoney(String msg) {
		System.out.println(msg);
		if (in.hasNextLine()) {
			String falseMoney = in.nextLine();
			if (falseMoney == null) {
				return getMoney("存款不能为空");
			} else {
				String money = falseMoney.trim();
				if ("".equals(money)) {
					return getMoney("存款不能为空");
				} else {
					try {
						BigDecimal count = new BigDecimal(money);
						return (count.compareTo(BigDecimal.ZERO) > 0 ? count : getMoney("金额无效，请重新输入！"));
					} catch (Exception e) {
						return getMoney("金额无效，请重新输入！");
					}
				}
			}
		} else {
			return getMoney("存款不能为空");
		}
	}

	@Override
	public String getType(String msg) {
		System.out.println(msg);
		CalculateInterest cal = new CalculateInterestImpl();
		if (in.hasNextLine()) {
			String falseType = in.nextLine();
			if (falseType == null) {
				return getType("存款类型不能为空");
			} else {
				String type = falseType.trim();
				if (cal.isType(type)) {
					return type;
				} else {
					return getType("请输入有效存款类型（活期、定期）");
				}
			}
		} else {
			return getType("请输入存款类型（活期、定期）：");
		}
	}

	@Override
	public Integer getTime(String msg, String type) {
		System.out.println(msg);
		CalculateInterest cal = new CalculateInterestImpl();
		if (in.hasNextLine()) {
			String falseTime = in.nextLine();
			if (falseTime == null) {
				return getTime("存款期限不能为空", type);
			} else {
				String time = falseTime.trim();
				if ("".equals(time)) {
					return getTime("存款期限不能为空", type);
				} else {
					try {
						int count = Integer.parseInt(time);
						if (cal.isTime(count, type)) {
							return count;
						} else {
							return getTime("存款时间不能小于3个月，请重新输入：", type);
						}
					} catch (Exception e) {
						return getTime("请输入有效存款期限：", type);
					}
				}
			}
		} else {
			return getTime("请输入存款期限(月数)：", type);
		}
	}


}
