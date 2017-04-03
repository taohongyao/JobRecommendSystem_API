package link.imcloud.jrs.controllers;


import link.imcloud.jrs.beans.BaseOBean;
import link.imcloud.jrs.beans.IBeanOperation;
import link.imcloud.jrs.beans.user.UserIBean;
import link.imcloud.jrs.beans.user.UserOBean;
import link.imcloud.jrs.db.entities.TBArea;
import link.imcloud.jrs.services.UserService;
import link.imcloud.jrs.utills.StringUtil;
import link.imcloud.jrs.utills.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 44247 on 2016/8/4 0004.
 */
@Controller
@RequestMapping("/u")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping(value = "/sentsms.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean sentSMS(@RequestBody UserIBean userIBean) throws IOException, SQLException {
        BaseOBean baseOBean =new BaseOBean();
        String phone= userIBean.getPhone();
        if(!userService.isRegister(phone)){
            String stateCode=userService.sentSMS(phone);
            baseOBean.setInfo("N01",stateCode);
        }else {
            baseOBean.setInfo("E01","已注册，无需再次验证");
        }
        return baseOBean;
    }

    @RequestMapping(value = "/getinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean getUserInfo(@RequestBody IBeanOperation iBeanOperation) {
        BaseOBean baseOBean =new BaseOBean();
        if(userService.checkUserToken(iBeanOperation)){
            UserOBean userOBean=userService.getUserInfo(iBeanOperation.getAccount());
            if(userOBean!=null){
                baseOBean.setInfo("N01","获取信息成功");
                baseOBean.setContents(userOBean);
            }else {
                baseOBean.setInfo("E01","用户不存在");
            }
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }
        return baseOBean;
    }

    @RequestMapping(value = "/getgeneralinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean getGeneralInfo(@RequestBody IBeanOperation iBeanOperation) {
        BaseOBean baseOBean =new BaseOBean();
        if(userService.checkUserToken(iBeanOperation)){
            UserOBean userOBean=userService.getGeneralInfo(iBeanOperation.getAccount());
            if(userOBean!=null){
                baseOBean.setInfo("N01","获取总览信息成功");
                baseOBean.setContents(userOBean);
            }else {
                baseOBean.setInfo("E01","用户不存在");
            }
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }
        return baseOBean;
    }

    @RequestMapping(value = "/alterinfo.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean alterUserInfo(@RequestBody UserIBean userIBean) {
        BaseOBean baseOBean =new BaseOBean();
        if(userService.checkUserToken(userIBean)){
            userService.updateUserInfo(userIBean);
            baseOBean.setInfo("N01","修改用户信息成功");
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }
        return baseOBean;
    }

    @RequestMapping(value = "/alterpwd.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean alterUserPassword(@RequestBody UserIBean userIBean) {
        BaseOBean baseOBean =new BaseOBean();
        if(userService.checkUserToken(userIBean)){
            if(userService.alterPassword(userIBean)){
                baseOBean.setInfo("N01","修改密码成功");
            }else {
                baseOBean.setInfo("E02","原密码不匹配");
            }
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }
        return baseOBean;
    }



    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean register(@RequestBody UserIBean userIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();
        String account= userIBean.getPhone();
        if(!userService.isRegister(account)){
            int smsCode=userService.register(userIBean);
            if(smsCode==userService.REGISTER_SECCESS){
                baseOBean.setInfo("N01","注册成功");
            }else {
                baseOBean.setInfo("E02","注册失败，验证码错误");
            }
        }else {
            baseOBean.setInfo("E01","注册失败，用户已存在");
        }
        return baseOBean;
    }


    @RequestMapping(value = "/isregister.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean isRegister(@RequestBody UserIBean userIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();
        String phone= userIBean.getPhone();
        if(userService.isRegister(phone)){
            baseOBean.setInfo("E01","已注册");
        }else {
            baseOBean.setInfo("N01","允许注册");
        }
        return baseOBean;
    }


    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean login(@RequestBody UserIBean userIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();
        String account=userIBean.getAccount();
        String pwd=userIBean.getPassword();
        if(userService.checkUserAccountAPassword(account,pwd)){
            String token=userService.login(account);
            baseOBean.setInfo("N01","登录成功");
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("token",token);
            baseOBean.setContents(map);
        }else {
            baseOBean.setInfo("E01","账号密码错误");
        }
        return baseOBean;
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean logout(@RequestBody IBeanOperation iBeanOperation)  {
        BaseOBean baseOBean =new BaseOBean();
        if(userService.checkUserToken(iBeanOperation)){
            userService.logout(iBeanOperation.getAccount());
            baseOBean.setInfo("N01","注销成功");
        }else {
            baseOBean.setInfo("N01","已注销");
        }
        return baseOBean;
    }


    @RequestMapping(value = "/uploadphoto.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean uploadPhotoFile(@RequestParam(value = "file", required = true) MultipartFile file,
                                       HttpServletRequest request) {
        BaseOBean carrier = new BaseOBean();
        String account = request.getParameter("account");
        String token = request.getParameter("token");
        IBeanOperation iBeanOperation=new IBeanOperation();
        iBeanOperation.setAccount(account);
        iBeanOperation.setToken(token);
        if (userService.checkUserToken(iBeanOperation)) {
            if (UploadUtil.isPhotoFileByName(file.getOriginalFilename())) {
                String path = request.getSession().getServletContext().getRealPath("/RESOURCES/USER");
                String newfileName = StringUtil.getRandomString(16)+".jpg"; //保存后的文件名
                File targetFile = new File(path, newfileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    String oldFileName = userService.getUserInfo(account).getPhoto();
                    if (oldFileName != null && !oldFileName.equals(newfileName)) {
                        File oldFile = new File(path, oldFileName);
                        oldFile.delete();
                    }
                    file.transferTo(targetFile);
                    userService.uploadPhoto(account,newfileName);
                    carrier.setInfo("N01", "上传成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    carrier.setInfo("E03", "上传失败，请注意文件不超过10M");
                }
            } else {
                carrier.setInfo("E01", "不是jpg格式文件");
            }
        } else {
            carrier.setInfo("E02", "用户验证错误，请重新登陆");
        }
        return carrier;
    }
}
