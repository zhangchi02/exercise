package com.zhc.commonjava.extend;

public class Father {
	private int fatherInt;
	private String fatherStr;
	
	public int getFatherInt() {
		return fatherInt;
	}

	public void setFatherInt(int fatherInt) {
		this.fatherInt = fatherInt;
	}

	public String getFatherStr() {
		return fatherStr;
	}

	public void setFatherStr(String fatherStr) {
		this.fatherStr = fatherStr;
	}

	public Father() {
		fatherInit(1,"fatherStr1");
		System.out.println("Father:Fatcher():"+fatherInt);
	}

	public Father(int fatherInt,String fatherStr) {
		fatherInit(fatherInt,fatherStr);
		System.out.println("Father:Fatcher(...):fatherInt:"+fatherInt+" fatherStr:"+fatherStr);
	}
	
	public void fatherInit(int fatherInt,String fatherStr) {
		this.fatherInt = fatherInt;
		this.fatherStr = fatherStr;
	}
}
