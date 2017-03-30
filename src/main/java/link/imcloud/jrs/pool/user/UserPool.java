package link.imcloud.jrs.pool.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by 44247 on 2016/6/9 0009.
 */
@Component
public  class UserPool extends HashMap<String,UserPoolBean> {
    public   void addUser(UserPoolBean user){
        synchronized (this){
            put(user.getAccount(),user);
        }
    }
    public   void removeUserBean(String account){
        synchronized (this) {
            remove(account);
        }
    }
}