package com.zhc.mythread.sync.lockextend;

public class ChildI extends ParentI {
synchronized public void operateIChildMethod(){
	try{
		while(i > 0){
			i--;
			System.out.println("child print i= " + i);
			Thread.sleep(100);
			this.operateIParentMethod();
		}
	}catch(InterruptedException e){
		e.printStackTrace();
	}
}
}
