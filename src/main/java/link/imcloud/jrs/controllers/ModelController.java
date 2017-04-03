package link.imcloud.jrs.controllers;

import link.imcloud.jrs.beans.BaseOBean;
import link.imcloud.jrs.beans.FacultyTest.FacultyTestIBean;
import link.imcloud.jrs.beans.IBeanOperation;
import link.imcloud.jrs.beans.resume.ResumeIBean;
import link.imcloud.jrs.beans.user.UserIBean;
import link.imcloud.jrs.db.entities.TBResume;
import link.imcloud.jrs.db.mapper.FacultyTestMapper;
import link.imcloud.jrs.db.mapper.ResumeMapper;
import link.imcloud.jrs.pool.user.UserPool;
import link.imcloud.jrs.services.FacultyTestService;
import link.imcloud.jrs.services.ResumeService;
import link.imcloud.jrs.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
@Controller
@RequestMapping("/m")
public class ModelController {
    @Resource
    private FacultyTestService facultyTestService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/putresume.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean putResume(@RequestBody ResumeIBean resumeIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();

        if(userService.checkUserToken(resumeIBean)){
            TBResume tbResume=new TBResume();
            tbResume.setUserAccount(resumeIBean.getAccount());
            tbResume.setResumeContext(resumeIBean.getResumeContext());
            resumeService.insertResume(tbResume);
            baseOBean.setInfo("N01","提交简历成功");
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }

        return baseOBean;
    }

    @RequestMapping(value = "/getresume.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean getResume(@RequestBody IBeanOperation iBeanOperation) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();

        if(userService.checkUserToken(iBeanOperation)){

            baseOBean.setContents(resumeService.getResumeByUser(iBeanOperation.getAccount()));
            baseOBean.setInfo("N01","获取简历成功");
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }

        return baseOBean;
    }

    @RequestMapping(value = "/getmodle.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean getModleScore(@RequestBody IBeanOperation iBeanOperation) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();

        if(userService.checkUserToken(iBeanOperation)){
            baseOBean.setContents(facultyTestService.getModleScore(iBeanOperation.getAccount()));
            baseOBean.setInfo("N01","获取系数成功");
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }

        return baseOBean;
    }

    @RequestMapping(value = "/gettest.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean getTest(@RequestBody FacultyTestIBean facultyTestIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();

        if(userService.checkUserToken(facultyTestIBean)){
            // TODO: 2017/4/1 测试类型编号
            if(facultyTestIBean.getTestType()==1){
                baseOBean.setContents(facultyTestService.generateTest(1));
            }else {
                baseOBean.setContents(facultyTestService.generateTest(2));
            }
            baseOBean.setInfo("N01","获取能力测试题成功");
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }

        return baseOBean;
    }

    @RequestMapping(value = "/puttest.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean putTest(@RequestBody FacultyTestIBean facultyTestIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();
        if(userService.checkUserToken(facultyTestIBean)){
            facultyTestService.computeScore(facultyTestIBean.getList(),facultyTestIBean.getAccount(),facultyTestIBean.getTestType());
            baseOBean.setInfo("N01","题目提交成功");
        }else {
            baseOBean.setInfo("E01","请重新登陆");
        }
        return baseOBean;
    }
}
