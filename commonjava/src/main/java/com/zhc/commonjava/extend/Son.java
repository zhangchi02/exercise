package com.zhc.commonjava.extend;

public class Son extends Father {
	private int sonInt;
	private String sonStr;
	
	public int getSonInt() {
		return sonInt;
	}
	public void setSonInt(int sonInt) {
		this.sonInt = sonInt;
	}
	public String getSonStr() {
		return sonStr;
	}
	public void setSonStr(String sonStr) {
		this.sonStr = sonStr;
	}
	public Son() {
		sonIni(10,"sonStr10");
		System.out.println("Son:Son():sonInt: "+sonInt+" sonStr:"+sonStr);
		System.out.println("Son:this.getFatherInt():"+this.getFatherInt());
		System.out.println("Son:this.getSonStr():"+this.getSonStr());
		
	}
	public Son(int sonInt,String sonStr) {
		super(sonInt,sonStr);
		sonIni(sonInt,sonStr);
		System.out.println("Son:Son(...):sonInt:"+sonInt+" sonStr:"+sonStr);
		System.out.println("Son:this.getFatherInt()"+this.getFatherInt());
		System.out.println("Son:this.getSonStr()"+this.getSonStr());
	}
	public void sonIni(int sonInt,String sonStr) {
		this.sonInt = sonInt;
		this.sonStr = sonStr;
	}
	public static void main(String[] args) {
		Son son1 = new Son();
		Son son2 = new Son(20,"sonStr20");
		
	}

}
