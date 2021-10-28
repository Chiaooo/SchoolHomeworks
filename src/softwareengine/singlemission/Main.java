package softwareengine.singlemission;

import java.util.Scanner;

/**
 * （1）以记录形式保存存单信息，存单信息可参考建行、工行等各大银行的情况自行确定，
 * 建议包括：账号、户名、存款类型（活期或定期）、金额（大小写）、存期、利率、存入日期、到期日期、起息日期、到期利息。
 * （2）储户可以随时查看自己的存款情况，可以查看账户余额，也可以查看账户的具体存款情况。
 * （3）储户可以取出自己账户中的存款，取款时计算应得的利息，形成利息清单。
 * （4）前提条件：存款人已在该行完成开户，账户已存在。
 * （5）限制条件：使用JAVA语言进行开发。
 * （6）数据输入输出在控制台上进行，无需图形化界面。
 *
 * @author 刘宝荣 何才壮
 * 2021-10-02 16:01
 */
public class Main {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		Operate op = new Operate();
		while (true) {
			System.out.print("欢迎使用银行存蓄系统！请输入您的账户名称(如要退出请输入exit):");
			String user_name = in.next();
			if (user_name.equals("exit"))
				System.exit(-1);
			if (user_name.equals(op.name)) {

				System.out.print("请输入您的账户：");
				int user_account = in.nextInt();

				if (user_account == op.account) {
					System.out.print("欢迎您！" + user_name + "，请选择您的存款方式(定期存款 & 活期存款)：");
					String deposit_way = in.next();

					switch (deposit_way) {

						case "定期存款":

							System.out.print("请输入您的定期存款时间！(月数：3、6、12、24、36、60）：");
							int deposit_time = in.nextInt();

							if (deposit_time < 0 || deposit_time >= 0 && deposit_time < 3 || deposit_time > 3 && deposit_time < 6 || deposit_time > 6 && deposit_time < 12 || deposit_time > 12 && deposit_time < 24 || deposit_time > 24 && deposit_time < 36 || deposit_time > 36 && deposit_time < 60 || deposit_time > 60) {
								System.out.println("输入有误！请重新操作");
								break;
							}
							op.setTime(deposit_time);

							System.out.print("请输入您的定期存款金额！(请输入整数)：");
							int deposit_balance = in.nextInt();

							op.deposit(1, deposit_time, deposit_balance);
							op.getInterest(deposit_time, deposit_way);
							break;

						case "活期存款":
							System.out.print("请输入您的活期存款时间(月):");
							int demand_time = in.nextInt();

							if (demand_time <= 0) {
								System.out.println("输入有误！请重新操作");
								break;
							}
							op.setTime(demand_time);

							System.out.print("请输入您的活期存款金额！(请输入整数)：");
							int demand_balance = in.nextInt();

							op.deposit(2, demand_time, demand_balance);
							op.getInterest(demand_time, deposit_way);
							break;
						default:
							System.out.println("输入有误,请重新输入！");
							break;
					}
				} else {
					System.out.println("账户错误！请重新输入");
					continue;
				}
			} else
				System.out.println("该用户未在系统中，请重新输入");
		}
	}
}
