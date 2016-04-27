package com.imooc.Thread;

public class KeyPersonThread extends Thread{
	public void run(){
		System.out.println(Thread.currentThread().getName() + "开始战斗！");
		for(int i = 0;i < 10; i++){
			System.out.println(Thread.currentThread().getName() +"左突右击，攻击随军！");
		}
		System.out.println(Thread.currentThread().getName() + "结合了战斗！");
	}
}
