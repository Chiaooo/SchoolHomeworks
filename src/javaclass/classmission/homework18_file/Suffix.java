package javaclass.classmission.homework18_file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Chiao
 */
public class Suffix implements FilenameFilter {
	String str = null;

	public Suffix(String s) {
		str = "." + s;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(str);
	}
}
