package com.zhc.commonjava.quartz;

import java.util.Date;
 
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 需要执行的任务
 * @author zhangchi02
 *
 */
public class MyJob implements Job {
 
	@Override
	//把要执行的操作，写在execute方法中
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("测试Quartz"+new Date());
	}
}
