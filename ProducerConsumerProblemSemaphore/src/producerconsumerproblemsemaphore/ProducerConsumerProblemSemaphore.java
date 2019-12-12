/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblemsemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *
 * @author lukas
 */
public class ProducerConsumerProblemSemaphore {

    public static void main(String[] args) {
        ExecutorService executerService = Executors.newFixedThreadPool(2);
        ProducerConsumer p = new ProducerConsumer();
        executerService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException ex) {
                    System.out.println("Error");
                }
            }
        });
        
        executerService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException ex) {
                    System.out.println("Error");
                }
            }
        });
        
        executerService.shutdown();
    }
    
}
