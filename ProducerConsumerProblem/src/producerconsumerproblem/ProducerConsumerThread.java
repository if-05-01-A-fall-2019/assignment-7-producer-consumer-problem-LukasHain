/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

import java.util.Random;
import java.util.Stack;
/**
 *
 * @author lukas
 */
public class ProducerConsumerThread{
    Random random = new Random();
    Stack buffer = new Stack<Integer>();
    final int MAX_ITEMS = 5;
    int currentItems = 0;
    
    public void produce() throws InterruptedException {
        while(true) {
            Integer item = currentItems + 1;
            if(currentItems == MAX_ITEMS) {
                wait();
            }
            System.out.println("Produced " + item);
            buffer.push(item);
            currentItems++;
            if(currentItems == 1) {
                notify();
            }   
        }
    }
    
    public void consume() throws InterruptedException {
        int item;
        while(true) {
            if(currentItems == 0) {
                wait();
            }
            item = (int) buffer.pop();
            System.out.println("Consumed " + item);
            currentItems--;
            if(currentItems == MAX_ITEMS - 1) {
                notify();
            }
        }  
    }
}
