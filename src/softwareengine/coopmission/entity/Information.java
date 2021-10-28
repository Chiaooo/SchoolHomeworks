package softwareengine.coopmission.entity;

import softwareengine.coopmission.dao.CalculateInterest;
import softwareengine.coopmission.dao.utils.CalculateInterestImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 焦天&蒋兴华
 * 2021-09-30 15:07  ver1.0
 */

//信息类
public class Information {
	/**
	 * 账号、户名、存款类型（活期或定期）、金额（大小写）、存期、利率、存入日期、到期日期、起息日期、到期利息。
	 */
	private String user;
	private Integer account;
	private String type;
	private BigDecimal money;
	private Integer time;
	private BigDecimal interest;
	private LocalDateTime saveDate;
	private LocalDateTime getDate;
	private LocalDateTime interestDate;
	private BigDecimal dateInterest;
	CalculateInterest cal = new CalculateInterestImpl();

	public Information(String user, Integer account, String type,
					   BigDecimal money, Integer time) {
		this.user = user;
		this.account = account;
		this.type = type;
		this.money = money;
		this.time = time;
		this.saveDate = LocalDateTime.now();
		this.getDate = saveDate.plusMonths(time);
		this.interest = cal.getInterest(time, type);
		this.interestDate = LocalDateTime.now();
		this.dateInterest = cal.calculateInterest(time, type, money);
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public LocalDateTime getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(LocalDateTime saveDate) {
		this.saveDate = saveDate;
	}

	public LocalDateTime getGetDate() {
		return getDate;
	}

	public void setGetDate(LocalDateTime getDate) {
		this.getDate = getDate;
	}

	public LocalDateTime getInterestDate() {
		return interestDate;
	}

	public void setInterestDate(LocalDateTime interestDate) {
		this.interestDate = interestDate;
	}

	public BigDecimal getDateInterest() {
		return dateInterest;
	}

	public void setDateInterest(BigDecimal dateInterest) {
		this.dateInterest = dateInterest;
	}

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "您本次存款信息如下：" + "\n" +
				"存款人：" + user + "\n" +
				"账户：" + account + "\n" +
				"存款类型：" + type + "\n" +
				"存款金额：" + money + "\n" +
				"存期：" + time + "\n" +
				"利率：" + interest + "\n" +
				"存款时间：" + df.format(saveDate) + "\n" +
				"到期时间：" + df.format(getDate) + "\n" +
				"起息日：" + df.format(interestDate) + "\n" +
				"到期利息：" + dateInterest;
	}
}
