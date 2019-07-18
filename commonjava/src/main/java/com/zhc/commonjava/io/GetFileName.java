package com.zhc.commonjava.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author zhangchi02
 * @date 2019年3月7日
 */
public class GetFileName {

	private static ArrayList<String> al = new ArrayList<String>();

	public static void main(String[] args) {
		String srcFolder = "D:\\learning\\传智播客_2015年Java基础视频-深入浅出精华版";
		String destFolder = "D:\\learning\\catelog.txt";
		getFileName(srcFolder);
		recordFileName(destFolder, al);
	}

	/**
	 * @param srcFolder
	 * @param destFolder
	 */
	public static void recordFileName(String destFolder, ArrayList<String> array) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(destFolder));
			for (String fileName : array) {
				System.out.println(fileName);
				bos.write((fileName+"\r\n").getBytes());
			}
			bos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static ArrayList<String> getFileName(String srcFolder) {
		File[] files = new File(srcFolder).listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFileName(file.getAbsolutePath());
			} else {
				String fileName = file.getName();
				if (fileName.endsWith(".avi")) {
					al.add(fileName);
				}
			}
		}
		return al;
	}
}
