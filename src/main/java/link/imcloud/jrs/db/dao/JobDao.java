package link.imcloud.jrs.db.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mysql.jdbc.log.LogUtils;
import link.imcloud.jrs.beans.job.Pager;
import link.imcloud.jrs.db.entities.MGJobItem;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by 44247 on 2016/11/20 0020.
 */

@Component
public class JobDao {

    @Resource
    private MongoTemplate mongoTemplate;
    protected Logger logger=Logger.getLogger("JobDao");

    /**
     *
     * @param objectId
     * @param size
     * @return
     */
    public List<MGJobItem> selectGroupByFirstObjectId(String objectId,int size){
//        logger.debug("MongoDB Test:"+mongoTemplate.getCollectionNames());
        Query query = new Query(Criteria.where("_id").gt(new ObjectId(objectId)));
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC,"_id")));
        query.limit(size);
        List<MGJobItem> jobs = mongoTemplate.find(query, MGJobItem.class,"jobs");
        return jobs;
    }



    /**
     * 通过jonbId查询详情
     * @param jobId
     * @return
     */
    public MGJobItem selectPage(String jobId){
        logger.debug("MongoDB Test:"+mongoTemplate.getCollectionNames());
        Query query = new Query(Criteria.where("job_id").is(jobId));
        long total = mongoTemplate.count(query, MGJobItem.class,"jobs");
        MGJobItem jobs = mongoTemplate.findOne(query, MGJobItem.class,"jobs");
        return jobs;
    }

    /**
     * 通过 funtype查找10个职业
     * @param jobId
     * @return
     */
    public List<MGJobItem> selectGroupByJobId(String jobId){
        Query Jobquery = new Query(Criteria.where("job_id").is(jobId));
        MGJobItem job = mongoTemplate.findOne(Jobquery, MGJobItem.class,"jobs");

        Query query = new Query(Criteria.where("funtype").is(job.getFuntype()));
        long total = mongoTemplate.count(query, MGJobItem.class,"jobs");
        int num=(int)(Math.random()*Math.ceil((double)total/10));
        query.skip((num-1)*10);
        query.limit(10);
        List<MGJobItem> jobs = mongoTemplate.find(query, MGJobItem.class,"jobs");
        return jobs;
    }

    public long getAllCounte(){
        Query query = new Query();
        long total = mongoTemplate.count(query, MGJobItem.class,"jobs");
        return total;
    }


    /**
     * 通过 funtype 查找职业
     * @param funtype
     * @param pager
     * @return
     */
    public Pager selectByFuntype(String funtype, Pager pager){
        Query query = new Query(Criteria.where("funtype").is(funtype));
        long total = mongoTemplate.count(query, MGJobItem.class,"jobs");
        query.skip((pager.getPageNum()-1)*pager.getPageSize());
        query.limit(pager.getPageSize());
        List<MGJobItem> jobs = mongoTemplate.find(query, MGJobItem.class,"jobs");
        pager.setResult(jobs);
        pager.setTotal(total);
        pager.setPageCount((int)Math.ceil((double)total/pager.getPageSize()));
        return pager;

    }


    /**
     * 通过 Conditions查找职业
     * @param conditions
     * @return
     */
    public Pager selectByConditions(List<Condition> conditions, Pager pager){
        Query query = new Query();
        for(Condition condition:conditions){
            if (condition.getRegex()==1){
                query.addCriteria(Criteria.where(condition.getField()).regex(".*?" + condition.getValue()+ ".*"));
            }else {
                query.addCriteria(Criteria.where(condition.getField()).is(condition.getValue()));
            }
        }
        long total = mongoTemplate.count(query, MGJobItem.class,"jobs");
        query.skip((pager.getPageNum()-1)*pager.getPageSize());
        query.limit(pager.getPageSize());
        List<MGJobItem> jobs = mongoTemplate.find(query, MGJobItem.class,"jobs");
        pager.setResult(jobs);
        pager.setTotal(total);
        pager.setPageCount((int)Math.ceil((double)total/pager.getPageSize()));
        return pager;
    }



}
