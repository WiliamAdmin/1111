package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Client {
    /**
     * 获取Ico容器，获取对象
     * @param args
     */
    public static void main(String[] args) {
        //拿核心容器 1 ApplicationContext 读取完配置文件立即加载
        //             BeanFactory  延迟加载
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //拿核心容器 2  放全路径
        //FileSystemXmlApplicationContext acc = new FileSystemXmlApplicationContext("");

        //根据id获取bean 对象 <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl" />
        IAccountService as = (IAccountService) ac.getBean("accountService");

        //<bean id="accountDao" class="com.itheima.dao.impl.AccountDaoImpl" />
        IAccountDao ad = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
        System.out.println(ad);
    }
}
