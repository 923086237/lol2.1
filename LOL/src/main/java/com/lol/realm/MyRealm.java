package com.lol.realm;

import com.lol.dao.UserMapper;
import com.lol.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String no = upToken.getUsername();
        User user = userMapper.findUserByNo(no);
        return  new SimpleAuthenticationInfo(no, user.getPwd(), ByteSource.Util.bytes(no), getName());
    }
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        String credentials = "1995811";
        int hashIterations = 1;
        ByteSource credentialsSalt = ByteSource.Util.bytes("qf000002");
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}
