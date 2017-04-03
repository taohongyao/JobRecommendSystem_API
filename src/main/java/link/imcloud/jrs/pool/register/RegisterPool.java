package link.imcloud.jrs.pool.register;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by 44247 on 2016/8/4 0004.
 */
@Component
public class RegisterPool extends HashMap<String,RegisterPoolBean>{

    public void add(String phone,RegisterPoolBean registerPoolBean){
        synchronized (this){
            put(phone,registerPoolBean);
        }
    }

    public void remove(String phone){
        synchronized (this){
            super.remove(phone);
        }
    }

}
