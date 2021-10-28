package softwareengine.singlemission;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 刘宝荣 何才壮
 * 2021-10-02 16:01
 */

public class Operate {

	public String name = "刘宝荣"; //存款人姓名
	public int account = 2021; //存款人账户
	public double balance; //存款数目
	public int time; //存款期限
	public double interest; //存款利息
	public String deadline; //到期时间
	public String type; //存款类型
	public LocalDateTime saveDate;//存款时间
	/**
	 * 活期类型及利率
	 */
	String DEPOSIT_TYPE_1 = "活期存款";
	double DEPOSIT_TYPE_1_INTEREST = 0.003;

	/**
	 * 定期类型及利率
	 */
	String DEPOSIT_TYPE_2 = "定期存款";
	double DEPOSIT_TYPE_2_3M = 0.0135;
	double DEPOSIT_TYPE_2_6M = 0.0155;
	double DEPOSIT_TYPE_2_1Y = 0.0175;
	double DEPOSIT_TYPE_2_2Y = 0.0225;
	double DEPOSIT_TYPE_2_3Y = 0.0275;
	double DEPOSIT_TYPE_2_5Y = 0.0275;

	int THREE_MONTH = 3;
	int SIX_MONTH = 6;
	int ONE_YEAR = 12;
	int TWO_YEAR = 24;
	int THREE_YEAR = 36;
	int FIVE_YEAR = 60;

	public String getSaveDate() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return df.format(saveDate);
	}

	public void setSaveDate() {
		this.saveDate = LocalDateTime.now();
	}

	public double getInterest(int time, String type) {
		if (DEPOSIT_TYPE_1.equals(type)) {
			return getType1Interest();
		} else {
			return getType2Interest(time);
		}
	}

	public double getType1Interest() {
		return DEPOSIT_TYPE_1_INTEREST;
	}

	public double getType2Interest(int time) {
		if (time >= THREE_MONTH && time < SIX_MONTH) {
			return DEPOSIT_TYPE_2_3M;
		} else if (time >= SIX_MONTH && time < ONE_YEAR) {
			return DEPOSIT_TYPE_2_6M;
		} else if (time >= ONE_YEAR && time < TWO_YEAR) {
			return DEPOSIT_TYPE_2_1Y;
		} else if (time >= TWO_YEAR && time < THREE_YEAR) {
			return DEPOSIT_TYPE_2_2Y;
		} else if (time >= THREE_YEAR && time < FIVE_YEAR) {
			return DEPOSIT_TYPE_2_3Y;
		} else {
			return DEPOSIT_TYPE_2_5Y;
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setTime(int time) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(new Date().getTime());
		c.add(Calendar.MONTH, time);
		Date date = new Date(c.getTimeInMillis());
		deadline = format.format(date);
		this.deadline = deadline;
		this.time = time;
	}

	public double getInterest() {
		return interest;
	}

	public double setInterest(double interest) {
		this.interest = interest;
		return this.interest;
	}

	public void deposit(int kind, int time, int money) {
		switch (kind) {
			case 1:
				if (time > 0) {
					if (time == 3) {
						setInterest(money * 0.0135 / 12 * time);
						setBalance(money);
						setTime(time);
						setSaveDate();
						setType("定期存款");
						showDetails();
						break;
					}
					if (time == 6) {
						setInterest(money * 0.0155 / 12 * time);
						setBalance(money);
						setTime(time);
						setSaveDate();
						setType("定期存款");
						showDetails();
						break;
					}
					if (time == 12) {
						setInterest(money * 0.0175 / 12 * time);
						setBalance(money);
						setTime(time);
						setSaveDate();
						setType("定期存款");
						showDetails();
						break;
					}
					if (time == 24) {
						setInterest(money * 0.0225 / 12 * time);
						setBalance(money);
						setTime(time);
						setSaveDate();
						setType("定期存款");
						showDetails();
						break;
					}
					if (time == 36) {
						setInterest(money * 0.0275 / 12 * time);
						setBalance(money);
						setTime(time);
						setSaveDate();
						setType("定期存款");
						showDetails();
						break;
					}
					if (time == 60) {
						setInterest(money * 0.0275 / 12 * time);
						setBalance(money);
						setTime(time);
						setType("定期存款");
						setSaveDate();
						showDetails();
						break;
					}
				}
				if (time > 0 && time < 3) {
					System.out.println("存款期限只能选择:3个月,6个月,一、二、三、五年的期限");
					break;
				} else {
					System.out.println("存款期限输入有误！");
					break;
				}
			case 2:
				setInterest(money * 0.003 / 360 * (time * 30));
				setBalance(money);
				setTime(time);
				setSaveDate();
				setType("活期存款");
				showDetails();
				break;
			default:
				System.out.println("输入有误,请重新输入！");
				break;

		}

	}

	public void showDetails() {
		System.out.println("——————个人银行存储信息——————");
		System.out.println("存款人姓名：" + name);
		System.out.println("存款人账号：" + account);
		System.out.println("存款金额：" + getBalance() + "元");
		System.out.println("存款时间：" + getSaveDate());
		System.out.println("到期时间：" + getDeadline());
		System.out.println("到期利息：" + getInterest() + "元");
		System.out.println("存款类型：" + getType());
		System.out.println("利率:" + getInterest(time, type));
	}

}
