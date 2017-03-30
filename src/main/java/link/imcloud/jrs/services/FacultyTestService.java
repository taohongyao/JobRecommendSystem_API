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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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


    public List<TBFacultyTest>  generateTest(){
        Random random=new Random();
        List<TBFacultyTest> list1=facultyTestMapper.getTestByType(1);
        List<TBFacultyTest> list2=facultyTestMapper.getTestByType(2);
        List<TBFacultyTest> list3=facultyTestMapper.getTestByType(3);
        Collections.shuffle(list1);
        Collections.shuffle(list2);
        Collections.shuffle(list3);

        List<TBFacultyTest> generateTests=new ArrayList<TBFacultyTest>();
        int one=0,two=0,three=0,randomNum;
        while ((one+two+three)!=33){
            randomNum=random.nextInt();
            if(randomNum%3==0&&one!=11){
                generateTests.add(list1.get(one));
                one++;
            }else if(randomNum%3==1&&two!=11){
                generateTests.add(list1.get(two));
                two++;
            }else if(three!=11) {
                generateTests.add(list1.get(three));
                three++;
            }
        }
        return  generateTests;
    }


    public List<Integer> computeScore(List<TBFacultyTest> list,String account){
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
        List<Integer> olist=new ArrayList<Integer>();
        olist.add(oneScore);
        olist.add(twoScore);
        olist.add(threeScore);

        //更新用户模型
        TBModel tbModel=modelMapper.getModelByUser(account);
        tbModel.setModelTwo(oneScore+","+twoScore+","+threeScore);
        modelMapper.updateModelByUser(tbModel);
        return olist;
    }

}
