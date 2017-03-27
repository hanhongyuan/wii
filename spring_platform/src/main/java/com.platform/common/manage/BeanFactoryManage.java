package com.platform.common.manage;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * Created by tanghong on 2017/2/21.
 */
@Service
public class BeanFactoryManage implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    private BeanFactory getBeanFactory(){
        return beanFactory;
    }

    public <T> T getBean(String name){
        Object obj = getBeanFactory().getBean(name);
        return (T)obj;
    }

}
