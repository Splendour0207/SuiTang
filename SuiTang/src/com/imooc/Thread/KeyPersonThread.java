package com.imooc.Thread;

public class KeyPersonThread extends Thread{
	public void run(){
		System.out.println(Thread.currentThread().getName() + "��ʼս����");
		for(int i = 0;i < 10; i++){
			System.out.println(Thread.currentThread().getName() +"��ͻ�һ������������");
		}
		System.out.println(Thread.currentThread().getName() + "�����ս����");
	}
}
