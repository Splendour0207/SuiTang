package com.imooc.Thread;


public class Stage extends Thread {
	public void run(){
		System.out.println("欢迎观看隋唐演义");
		
		try {
//			让观众安静片刻，等待大戏上演
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("大幕徐徐拉开");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("话说隋唐末年，随军与农民起义军杀得昏天暗地。。。");
		
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"随军");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民军队");
		
//		启动线程，让军队开始作战
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		

		
		//		舞台线程休眠
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("正当双方激战正酣，半路杀出了个程咬金！");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		System.out.println("陈咬金的理想就是结束战争，使百姓安居乐业！");
//	军队停止作战	
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;

		//错误的停止方法stop()，使线程戛然而止，不知已经干了些什么		
//		armyOfSuiDynasty.stop();
//		armyOfRevolt.stop();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * 让出线程，历史大戏留给关键人物
		 */
		mrCheng.start();
//		万众瞩目，所有线程等待程先生完成历史使命
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("战争结束，人民安居乐业，程先生实现了自己的人生梦想，为人民做出了贡献！");
		
//		
//		try {
//			armyOfRevolt.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
	public static void main(String[] args){
		Stage stage = new Stage();
		stage.start();
	} 
}
