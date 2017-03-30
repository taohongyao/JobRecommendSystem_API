package link.imcloud.jrs.services;


import com.mysql.jdbc.log.LogUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import link.imcloud.jrs.beans.IBeanOperation;
import link.imcloud.jrs.beans.user.UserIBean;
import link.imcloud.jrs.beans.user.UserOBean;
import link.imcloud.jrs.db.entities.TBArea;
import link.imcloud.jrs.db.entities.TBModel;
import link.imcloud.jrs.db.entities.TBUser;
import link.imcloud.jrs.db.mapper.AreaMapper;
import link.imcloud.jrs.db.mapper.ModelMapper;
import link.imcloud.jrs.db.mapper.UserMapper;
import link.imcloud.jrs.pool.register.RegisterPool;
import link.imcloud.jrs.pool.register.RegisterPoolBean;
import link.imcloud.jrs.pool.user.UserPool;
import link.imcloud.jrs.pool.user.UserPoolBean;
import link.imcloud.jrs.utills.DataEncoder;
import link.imcloud.jrs.utills.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by 44247 on 2016/6/9 0009.
 */
@Service
public class UserService {
    @Resource
    protected SMSService smsService;
    @Resource
    protected ModelMapper modelMapper;
    @Resource
    protected UserMapper userMapper;
    @Resource
    protected AreaMapper areaMapper;
    @Resource
    protected RegisterPool registerPool;
    @Resource
    protected UserPool userPool;

    protected Logger logger=Logger.getLogger(LogUtils.class);

    public final static int REGISTER_SECCESS=0;
    public final static int SMSCODE_ERROR=1;

    public boolean checkUserAccountAPassword(String account,String pwd) throws SQLException {
        TBUser tbUser=userMapper.getUserByAccount(account);
        logger.debug(">>>>>>>>>> user: "+account +" pwd: "+pwd+" tbUser: "+tbUser);
        if(tbUser==null) return false;
        if(tbUser.getPassword().equals(pwd)) return true;
        return false;
    }

    public String login(String account) {
            String token=addIntoUserPool(account);
            return token;
    }

    public  Boolean checkUserToken(IBeanOperation iBeanOperation) {
        return checkToken(iBeanOperation.getAccount(),iBeanOperation.getToken());
    }

    public void logout(String account){
        registerPool.remove(account);
    }
    public boolean isRegister(String account)throws SQLException {
        TBUser tbUser=userMapper.getUserByAccount(account);
        if(tbUser==null) return false;
        return true;
    }

    public String sentSMS(String phone) throws IOException {
        String smsCode= StringUtil.getRandomNumber(6);
        String msg=java.net.URLDecoder.decode("您注册的手机验证码为："+smsCode+"。温馨提示：为了保护您的账号安全，请勿将验证码外泄","utf-8");
        String stateCode=smsService.sentSMS(phone,msg);
        logger.debug(">>>>>>>>> sms response code:"+stateCode);
        addIntoRegisterPool(phone,smsCode);
        return stateCode;
    }

    public boolean alterPassword(UserIBean userIBean){
        TBUser tbUser=userMapper.getUserByAccount(userIBean.getAccount());
        if(tbUser.getPassword().equals(userIBean.getOldPassword())){
            tbUser.setPassword(userIBean.getNewPassword());
            userMapper.alterUser(tbUser);
            return true;
        }else {
            return false;
        }

    }

    public void uploadPhoto(String account,String newFile){
        TBUser tbUser=userMapper.getUserByAccount(account);
        logger.debug(">>>>>>>>>>>>>> photo file: "+newFile);
        tbUser.setPhoto(newFile);
        userMapper.alterUser(tbUser);
    }

    public void updateUserInfo(UserIBean userIBean){
        TBUser tbUser=userMapper.getUserByAccount(userIBean.getAccount());
        tbUser.setEmail(userIBean.getEmail());
        tbUser.setNickname(userIBean.getNickname());
        tbUser.setSex(userIBean.getSex());
        tbUser.setArea(userIBean.getArea());
        tbUser.setAge( userIBean.getAge());
        tbUser.setPhoto(userIBean.getPhoto());
        userMapper.alterUser(tbUser);
    }

    public UserOBean getUserInfo(String account){
        TBUser tbUser=userMapper.getUserByAccount(account);
        UserOBean userOBean=null;
        if (tbUser != null) {
            userOBean=new UserOBean();
            userOBean.setAccount(tbUser.getAccount());
            userOBean.setEmail(tbUser.getEmail());
            userOBean.setNickname(tbUser.getNickname());
            userOBean.setPhone(tbUser.getPhone());
            userOBean.setSex(tbUser.getSex());
            userOBean.setPhoto(tbUser.getPhoto());

        }
        return userOBean;
    }
    public int register(UserIBean userIBean){
        String phone= userIBean.getPhone();
        String sms= userIBean.getSmsCode();
        if(checkSmsCode(phone,sms)){
            TBUser user=new TBUser();
            user.setAccount(phone);
            user.setPassword(userIBean.getPassword());
            user.setEmail(userIBean.getEmail());
            user.setNickname(userIBean.getNickname());
            user.setPhone(userIBean.getPhone());
            user.setAge(userIBean.getAge());
            user.setArea(userIBean.getArea());
            user.setSex(userIBean.getSex());
            userMapper.addUser(user);
            TBModel tbModel=new TBModel();
            tbModel.setUserAccount(user.getAccount());
            modelMapper.insertModel(tbModel);
            return REGISTER_SECCESS;
        }else {
            return SMSCODE_ERROR;
        }
    }



    private String addIntoRegisterPool(String phone,String smsCode){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,3);
        long time=calendar.getTimeInMillis(); // 计算超时时间

        RegisterPoolBean registerPoolBean=new RegisterPoolBean();
        registerPoolBean.setSmsCode(smsCode);
        registerPoolBean.setVaild(time);
        registerPool.add(phone,registerPoolBean);
        return smsCode;
    }
    private String addIntoUserPool(String account){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,7);
        long time=calendar.getTimeInMillis(); // 计算超时时间
        String md5= DataEncoder.getMD5("PRS"+account+time); //md5加密得到sessionID
        UserPoolBean user =new UserPoolBean();
        user.setAccount(account);
        user.setVaild(time);
        user.setSessionID(md5);
        userPool.addUser(user);
        return  md5;
    }
    private boolean checkToken(String account,String sessionID){
        UserPoolBean user=userPool.get(account);
        Calendar calendar = Calendar.getInstance();
        long time=calendar.getTimeInMillis(); // 计算超时时间
        if (user!=null){
            if(user.getSessionID().equals(sessionID)&&time<=user.getVaild()){
                calendar.add(Calendar.DAY_OF_MONTH,7);
                long newtime=calendar.getTimeInMillis(); // 计算超时时间
                user.setVaild(newtime);
                return true;
            }else if(time>user.getVaild()){
                userPool.removeUserBean(account);
            }
        }
        return false;
    }

    private boolean checkSmsCode(String phone,String smsCode){
        RegisterPoolBean registerPoolBean=registerPool.get(phone);
        if(registerPoolBean!=null&& registerPoolBean.getSmsCode().equals(smsCode)){
            Calendar calendar = Calendar.getInstance();
            long time=calendar.getTimeInMillis();
            if(time<=registerPoolBean.getVaild()){
                return true;
            }
        }
        return false;
    }

    public List<TBArea> getAllAreas(){
        return  areaMapper.getAllArea();
    }
}
