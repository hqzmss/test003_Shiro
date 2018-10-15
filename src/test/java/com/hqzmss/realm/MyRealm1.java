package com.hqzmss.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        if(!"zhang".equals(userName)) {
            throw new UnknownAccountException("用户不存在！");
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException("密码错误！");
        }
        return new SimpleAuthenticationInfo(userName, password, getName());
    }
}
