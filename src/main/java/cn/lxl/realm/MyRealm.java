package cn.lxl.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sang on 2018/3/17.
 *
 * AuthenticatingRealm 认证使用
 * ,AuthorizingRealm 授权使用
 */
public class MyRealm extends AuthorizingRealm{

    /**
     * 判断当前Realm是否支持当前token，该token指Controller中传来的token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public String getName() {
        return "myRealm";
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录用户名
        String password ="";
        Object principal = authenticationToken.getPrincipal();
        if ("zhangsan".equals(principal)) {
            //根据用户名去数据库中查询用户信息 271dad09d1a71f27b7aeaa27306d5e24用户名加盐密码
            password = "271dad09d1a71f27b7aeaa27306d5e24";//这个表示从数据库中查询出来的密码
            ByteSource zhangsan = ByteSource.Util.bytes("zhangsan");
            //密码加盐策略
            return new SimpleAuthenticationInfo(principal, password, zhangsan,"myRealm");
        }else if ("admin".equals(principal)){
            password= "c41d7c66e1b8404545aa3a0ece2006ac";
            ByteSource admin = ByteSource.Util.bytes("admin");
            return new SimpleAuthenticationInfo(principal, password, admin,"myRealm");
        }else if("lisi".equals(principal)){
            throw new AuthenticationException ("账号被锁定请联系管理员");
        }else{
            System.out.println(1);
            throw new UnknownAccountException("用户不存在");
        }
    }


    public static void main(String[] args) {
        SimpleHash md5 = new SimpleHash("MD5", "123", "zhangsan", 1024);
        System.out.println(md5);
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object username = principals.getPrimaryPrincipal();
        Set<String> roles = new HashSet<String>();
        if(username.equals("admin")){
            roles.add("admin");
        }
        roles.add("user");
        return new SimpleAuthorizationInfo(roles);
    }
}
