package softwareengine.coopmission.main;


/**
 * （1）以记录形式保存存单信息，存单信息可参考建行、工行等各大银行的情况自行确定，
 * 建议包括：账号、户名、存款类型（活期或定期）、金额（大小写）、存期、利率、存入日期、到期日期、起息日期、到期利息。
 * （2）储户可以随时查看自己的存款情况，可以查看账户余额，也可以查看账户的具体存款情况。
 * （3）储户可以取出自己账户中的存款，取款时计算应得的利息，形成利息清单。
 * （4）前提条件：存款人已在该行完成开户，账户已存在。
 * （5）限制条件：使用JAVA语言进行开发。
 * （6）数据输入输出在控制台上进行，无需图形化界面。
 * ====================双人组代码规范=====================
 * 1.缩进的Tab空格数为4个
 * 2.功能程序块之间，变量等说明后必须加空行
 * 3.不可以把多个短语句写在同一行中
 * 4.两个或两个以上的变量、常量、关键字等进行操作时，之间的操作符前后需要加空格
 * 5.复杂度较高的函数，需要添加注释，注释位置在函数头部
 * 6.若语句或函数等进行修改，需要指出修改时间、修改内容、修改原因
 * 7.全局变量、常量 需要添加注释说明其意义
 * 8.注释与所描述的内容进行同样缩进，位置在其上方，并且用空格分开
 * 9.对于变量名、类名、函数名等，需要做到见名知意
 * 10.明确变量、函数的关系，避免造成权限错误
 *
 * @author 焦天&蒋兴华
 * 2021-09-30 15:07  ver1.0
 */


import softwareengine.coopmission.dao.Message;
import softwareengine.coopmission.dao.utils.MessageImpl;
import softwareengine.coopmission.entity.Information;

import java.math.BigDecimal;


public class Main {

	public static void main(String[] args) {
		System.out.println("欢迎使用个人储蓄系统！");
		Message msg = new MessageImpl(System.in);
		String user = msg.getName("请输入您的账户名称：");
		Integer account = msg.getAccount("请输入您的账号：");
		String type = msg.getType("请输入您的存款类型(活期、定期)：");
		BigDecimal money = msg.getMoney("请输入您的存款金额：");
		Integer time = msg.getTime("请输入您的存款期限：", type);
		Information info = new Information(user, account, type, money, time);
		System.out.println(info.toString());

	}
}
