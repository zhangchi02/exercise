package com.zhc.commonjava.quartz;

//import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
//import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 调用任务的类
 * 
 * @author zhangchi02
 *
 */
public class SchedulerTest {

	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

	private static Scheduler scheduler = null;

	public static void main(String[] args) throws InterruptedException {
		new SchedulerTest().createScheduler();
		Thread.sleep(4000);
		shutdownJobs();
	}

	public void createScheduler() {
		// 通过schedulerFactory获取一个调度器
		try {
			// 通过schedulerFactory获取一个调度器
			scheduler = schedulerFactory.getScheduler();

			// 创建jobDetail实例，绑定Job实现类
			// 指明job的名称，所在组的名称，以及绑定job类
			JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "jgroup1").build();

			// 定义调度触发规则

			// 使用simpleTrigger规则
			// Trigger trigger =
			// TriggerBuilder.newTrigger().withIdentity("simpleTrigger",
			// "triggerGroup")
			// .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8)).startNow().build();
			// 使用cornTrigger规则 每天10点42分
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
					.withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?")).startNow().build();

			// 把作业和触发器注册到任务调度中
			scheduler.scheduleJob(job, trigger);

			// 启动调度
			scheduler.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Description:关闭所有定时任务
	 */
	public static void shutdownJobs() {
		try {
			// Scheduler sched = schedulerFactory.getScheduler();
			if (null != scheduler) {
				if (!scheduler.isShutdown()) {
					scheduler.shutdown();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
