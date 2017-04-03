package link.imcloud.jrs.controllers;

import link.imcloud.jrs.beans.BaseOBean;
import link.imcloud.jrs.beans.job.JobIBean;
import link.imcloud.jrs.beans.job.Pager;
import link.imcloud.jrs.db.dao.Condition;
import link.imcloud.jrs.db.dao.JobDao;
import link.imcloud.jrs.services.UserService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 44247 on 2016/11/20 0020.
 */
@Controller
@RequestMapping("/j")
public class JobController {

    @Resource
    JobDao jobDao;
    @Resource
    private UserService userService;



    /**
     * 多条件查询（id>funtype=job_name）
     * !(不包括area,recuitment)
     * @param jobIBean
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/search.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean getById(@RequestBody JobIBean jobIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();

        if(jobIBean.getJobId()!=null){
            baseOBean.setContents(jobDao.selectPage(jobIBean.getJobId()));

        }else {


            // TODO: 2017/4/1 多条件查询 
            Pager pager=new Pager();
            pager.setPageNum(jobIBean.getPageNum());
            pager.setPageSize(jobIBean.getPageSize());

            List<Condition> list=new ArrayList<Condition>();

            if(jobIBean.getFuntype()!=null){
                list.add(new Condition("funtype",jobIBean.getFuntype(),0));

            }else if(jobIBean.getJobName()!=null){
                list.add(new Condition("job_name",jobIBean.getJobName(),1));
            }

            baseOBean.setContents(jobDao.selectByConditions(list,pager));
        }


        baseOBean.setInfo("N01","查询职位成功");
        return baseOBean;
    }

    /**
     * 对每一个职位进行推荐
     * @param jobIBean
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/recommendbyone.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean recommendByJob(@RequestBody JobIBean jobIBean) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();
        Pager p=new Pager();
        p.setPageSize(10);
        p.setPageNum(1);
        baseOBean.setContents(jobDao.selectGroupByJobId(jobIBean.getJobId()));
        baseOBean.setInfo("N01","推荐职位组成功");
        return baseOBean;
    }

    /**
     * 需要改成 登陆后的接口（个性化分析）
     * @param pager
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/recommend.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean recommendByUser(@RequestBody Pager pager) throws SQLException {
        BaseOBean baseOBean =new BaseOBean();
            // TODO: 2017/4/1 实现分页推荐  
            baseOBean.setContents(jobDao.selectByFuntype("0100",pager));
            baseOBean.setInfo("N01","推荐组成功");

        return baseOBean;


    }
}
