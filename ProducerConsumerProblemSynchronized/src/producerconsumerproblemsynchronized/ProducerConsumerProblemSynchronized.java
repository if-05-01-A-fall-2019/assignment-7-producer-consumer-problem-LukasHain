/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblemsynchronized;

/**
 *
 * @author lukas
 */
public class ProducerConsumerProblemSynchronized {

    public static void main(String args[]) throws InterruptedException 
    { 
        System.out.print("Starting");
        ProducerConsumer problem = new ProducerConsumer();
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
                    System.out.println("Error " + ex.getMessage());}
           }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
    
}
