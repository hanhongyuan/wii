package com.platform.actor.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * Created by tanghong on 2017/3/10.
 */
@Service
public class AkkaBeanFactory implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        AkkaBeanFactory.beanFactory = beanFactory;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name){
        return (T)beanFactory.getBean(name);
    }
}
