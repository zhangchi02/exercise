package com.zhc.mythread.chapter2.sync.block.dirtyread;

import java.util.ArrayList;
import java.util.List;

public class MyOneList extends Thread {
	private List<String> list = new ArrayList<String>();

	synchronized public void add(String data) {
		list.add(data);
	}

	synchronized public int getSize() {
		return list.size();
	}
}
