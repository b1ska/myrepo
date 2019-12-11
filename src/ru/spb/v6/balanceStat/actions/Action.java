/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spb.v6.balanceStat.actions;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public interface Action extends Runnable, AutoCloseable {
    /**
     * Запускает потоковый объект на исполнение в отдельном
     * потоке исполнения.
     */
    
    ExecutorService myExecutor = Executors.newCachedThreadPool();
   
    
    
    default void start() {
        /*
         * TODO №1 Реализуйте метод start интерфейса Action.
         */
         myExecutor.execute(this); 
        
    }

    @Override
    public default void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
