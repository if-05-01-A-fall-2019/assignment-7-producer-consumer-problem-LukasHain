/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

/**
 *
 * @author lukas
 */
public class ProducerConsumerProblem {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting");
        ProducerConsumerThread problem = new ProducerConsumerThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    problem.produce();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());}
            }
        });
        Thread thread2 = new Thread(new Runnable() {
        @Override
            public void run() {
                try {
                    problem.consume();
                } catch (InterruptedException ex) {
                    System.out.println("Error " + ex.getMessage());
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
    
}
