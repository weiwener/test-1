package com.example.demo4.TIJIE;

/**
 * @Description:
 * @Author: wangwei
 * @Date: 2020/12/22 下午5:51
 */
public class ThreadPrintTest1 {
	private static final Object lock=new Object();
	private volatile int index=1;
	private volatile boolean aHasPrint=false;

	class A implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<50;i++){
				synchronized (lock){
					while(aHasPrint){
						try{
							lock.wait();
						}catch (InterruptedException e){
							e.printStackTrace();
						}
					}
					System.out.println("A: "+index++);
					aHasPrint=true;
					lock.notifyAll();
				}
			}
		}
	}
	class B implements Runnable{

		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				synchronized (lock) {
					while (!aHasPrint) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("B: " + index++);
					aHasPrint = false;
					lock.notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreadPrintTest1 threadPrintTest1=new ThreadPrintTest1();
		Thread threadA=new Thread(threadPrintTest1.new A());
		Thread threadB=new Thread(threadPrintTest1.new B());
		threadA.start();
		threadB.start();
	}

}
