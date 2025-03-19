package com.valtech.training.springsecurity.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//    	System.out.println("Bean name = "+beanName);
        if (bean instanceof AuthorizationFilter authorizationFilter) {
        	System.out.println("Authorization Filter Found..");
            authorizationFilter.setFilterErrorDispatch(false);
        }
        return bean;
    }

}
