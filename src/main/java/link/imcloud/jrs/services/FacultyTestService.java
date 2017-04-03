package link.imcloud.jrs.services;

import com.mysql.jdbc.log.LogUtils;
import link.imcloud.jrs.db.entities.TBFacultyTest;
import link.imcloud.jrs.db.entities.TBModel;
import link.imcloud.jrs.db.mapper.FacultyTestMapper;
import link.imcloud.jrs.db.mapper.ModelMapper;
import link.imcloud.jrs.db.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by 44247 on 2016/11/19 0019.
 */

@Service
public class FacultyTestService {

    @Resource
    protected FacultyTestMapper facultyTestMapper;
    @Resource
    protected ModelMapper modelMapper;

    protected Logger logger=Logger.getLogger(LogUtils.class);


    public List<TBFacultyTest>  generateTest(int testtype){
        List<TBFacultyTest> generateTests=new ArrayList<TBFacultyTest>();
        if(testtype==1){
            List<TBFacultyTest> list1=facultyTestMapper.getTestByType(1);
            Collections.shuffle(list1);
            int one=0;
            while (one<30){
                generateTests.add(list1.get(one));
                one++;
            }
        }else {
            List<TBFacultyTest> list2=facultyTestMapper.getTestByType(2);
            List<TBFacultyTest> list3=facultyTestMapper.getTestByType(3);
            Collections.shuffle(list2);
            Collections.shuffle(list3);
            int two=0,three=0;
            while (two<15){
                generateTests.add(list2.get(two));
                two++;
            }
            while (three<15){
                generateTests.add(list3.get(three));
                three++;
            }
        }
        return  generateTests;
    }

    // TODO: 2017/4/1 模型转换
    public Map<String,Double> getModleScore(String account){
        TBModel tbModel=modelMapper.getModelByUser(account);
        Map<String,Double> map=new HashMap<String, Double>();
        map.put("modle1",0.0);
        map.put("modle2",0.0);
        map.put("modle3",0.0);

        return map;
    }

    public void computeScore(List<TBFacultyTest> list,String account,Integer testype){
        int oneScore=0;
        int twoScore=0;
        int threeScore=0;

        for(int i=0;i<list.size();i++){
            TBFacultyTest test=list.get(i);
            TBFacultyTest rightTest=facultyTestMapper.getTestById(test.getQuestionId());

            if(rightTest.getAnswer().equals(test.getAnswer())){
                if(test.getQuestionType()==1){
                    oneScore++;
                }else if(test.getQuestionType()==2){
                    twoScore++;
                }else {
                    threeScore++;
                }
            }

        }


        //更新用户模型
        TBModel tbModel=modelMapper.getModelByUser(account);
        if(testype==1)
        tbModel.setModelOne(""+oneScore);
        else
        tbModel.setModelTwo(twoScore+","+threeScore);
        modelMapper.updateModelByUser(tbModel);
    }

}
