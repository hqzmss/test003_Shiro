package com.hqzmss;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.testng.annotations.Test;

public class LoginLogoutTest {
    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2、获取SecurityManager实例，关绑定到SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、获取subject并得到用户身份证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        //4、登录或退出
        try {
            subject.login(token);
            System.out.print("登录成功！");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.print("登录失败！");
        }
        subject.logout();
    }
}
