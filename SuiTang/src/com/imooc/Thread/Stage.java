package com.imooc.Thread;


public class Stage extends Thread {
	public void run(){
		System.out.println("��ӭ�ۿ���������");
		
		try {
//			�ù��ڰ���Ƭ�̣��ȴ���Ϸ����
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��Ļ��������");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��˵����ĩ�꣬�����ũ�������ɱ�û��찵�ء�����");
		
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"���");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"ũ�����");
		
//		�����̣߳��þ��ӿ�ʼ��ս
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		

		
		//		��̨�߳�����
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("����˫����ս��������·ɱ���˸���ҧ��");
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");
//	����ֹͣ��ս	
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;

		//�����ֹͣ����stop()��ʹ�߳��Ȼ��ֹ����֪�Ѿ�����Щʲô		
//		armyOfSuiDynasty.stop();
//		armyOfRevolt.stop();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * �ó��̣߳���ʷ��Ϸ�����ؼ�����
		 */
		mrCheng.start();
//		������Ŀ�������̵߳ȴ������������ʷʹ��
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ս�����������񰲾���ҵ��������ʵ�����Լ����������룬Ϊ���������˹��ף�");
		
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
