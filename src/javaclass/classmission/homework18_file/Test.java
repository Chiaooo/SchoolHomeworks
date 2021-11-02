package javaclass.classmission.homework18_file;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Chiao
 * @mission 编写一个应用程序，输入一个目录和一个文件类型，显示该目录下符合该类型的所有文件。之后，将这些文件中的某一个文件剪切到另外一个目录中。
 */
public class Test {
	public static void cut(String fromdir, String name, String todir) throws IOException {
		FileWriter fileWriter = null;
		FileReader fileReader = null;
		BufferedWriter bufferedWriter = null;
		BufferedReader bufferedReader = null;
		File file = new File(fromdir + "\\" + name);

		fileWriter = new FileWriter(todir + "\\" + name);
		bufferedWriter = new BufferedWriter(fileWriter);
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			bufferedWriter.write(str);
			bufferedWriter.newLine();
		}
		bufferedReader.close();
		bufferedWriter.close();
		fileReader.close();
		fileWriter.close();
		file.delete();
		System.out.println("剪切成功！");

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		System.out.println("请输入路径：");
		String path = in.nextLine();
		File file = new File(path);
		String[] filenames = file.list();
		System.out.println(Arrays.toString(filenames));

		System.out.println("请输入后缀：");
		String suffix = in.nextLine();
		Suffix suf = new Suffix(suffix);
		String[] filenamesSuffix = file.list(suf);
		System.out.println(Arrays.toString(filenamesSuffix));

		System.out.println("请输入要剪切文件的路径：");
		String fromDir = in.nextLine();

		System.out.println("请输入文件名:");
		String name = in.nextLine();

		System.out.println("请输入剪切后的路径：");
		String toDir = in.nextLine();

		cut(fromDir, name, toDir);
	}

}
