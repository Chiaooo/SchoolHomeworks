package softwareengine.coopmission.dao.utils;

import softwareengine.coopmission.dao.CalculateInterest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 焦天&蒋兴华
 * 2021-09-30 15:07  ver1.0
 */

public class CalculateInterestImpl implements CalculateInterest {

	@Override
	public boolean isType(String type) {
		return DEPOSIT_TYPE_1.equals(type) || DEPOSIT_TYPE_2.equals(type);
	}

	@Override
	public boolean isTime(int time, String type) {
		if (DEPOSIT_TYPE_1.equals(type) && time > 0) {
			return true;
		} else {
			return time >= 3;
		}
	}

	@Override
	public boolean isAccount(String num) {
		for (int i = 0; i < num.length(); i++) {
			if (Character.isDigit(num.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public BigDecimal calculateInterest(int time, String type, BigDecimal money) {
		CalculateInterest cal = new CalculateInterestImpl();
		BigDecimal interest = cal.getInterest(time, type);
		return money.multiply(interest).multiply(BigDecimal.valueOf(time)).divide(BigDecimal.valueOf(12)).setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal getInterest(int time, String type) {
		if (DEPOSIT_TYPE_1.equals(type)) {
			return getType1Interest();
		} else {
			return getType2Interest(time);
		}
	}

	@Override
	public BigDecimal getType1Interest() {
		return DEPOSIT_TYPE_1_INTEREST;
	}

	@Override
	public BigDecimal getType2Interest(int time) {
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
}
