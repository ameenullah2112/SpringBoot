package com.ameen.sb.data;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements BeanNameAware, InitializingBean {
    private int id;
    private String name;
    private String address;


    @Override
    public void setBeanName(String name) {
        System.err.println("1. Aware :: Setting bean name  " + name);
    }

    @PostConstruct
    public  void pc(){
        System.err.println("2. This is post construct method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("3. InitializingBean's init method");
    }

}
