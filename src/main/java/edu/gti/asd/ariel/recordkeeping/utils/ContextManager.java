/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.gti.asd.ariel.recordkeeping.utils;

import org.springframework.context.ApplicationContext;

/**
 *
 * @author ariel
 */
public class ContextManager {
    private ApplicationContext context;

    public ContextManager(ApplicationContext context) {
        this.context = context;
    }
    
    public <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
    
    public <T> T getBean(String beanName, Class<T> beanClass, String pepe) {
        return (T) context.getBean(beanName);
    }
}
