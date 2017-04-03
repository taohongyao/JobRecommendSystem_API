package link.imcloud.jrs.services;

import link.imcloud.jrs.beans.typseData.TypesDataOBean;
import link.imcloud.jrs.db.entities.*;
import link.imcloud.jrs.db.mapper.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 44247 on 2017/4/3 0003.
 */
@Service
public class TypesDataService {
    @Resource
    protected AreaMapper areaMapper;
    @Resource
    protected FunTypeMapper funTypeMapper;
    @Resource
    protected CompanyTypeMapper companyTypeMapper;
    @Resource
    protected MajorTypeMapper majorTypeMapper;
    @Resource
    protected EducationTypeMapper educationTypeMapper;
    @Resource
    protected SalaryTypeMapper salaryTypeMapper;
    @Resource
    protected MarriedTypeMapper marriedTypeMapper;

    public List<TBArea> getAllAreas(){
        return  areaMapper.getAllArea();
    }
    public List<TBMarriedType> getAllMarriedTypes(){return  marriedTypeMapper.getAllMarriedTypes();}
    public List<TBMajorType> getAllMajorTypes(){return  majorTypeMapper.getAllMajorTypes();}
    public List<TBEducationType> getAllEducationTypes(){return  educationTypeMapper.getAllEducationTypes();}
    public List<TBFuntype> getAllFuntypes(){return  funTypeMapper.getAllFunTypes();}
    public List<TBCompanyType> getAllCompanyTypes(){return  companyTypeMapper.getAllCompanyTypes();}
    public List<TBSalaryType> getAllSalaryTypes(){return  salaryTypeMapper.getAllSalaryTypes();}

    public TypesDataOBean getAllTypesData(){
        TypesDataOBean typesDataOBean=new TypesDataOBean();
        typesDataOBean.setAreas(areaMapper.getAllArea());
        typesDataOBean.setCompanyTypes(companyTypeMapper.getAllCompanyTypes());
        typesDataOBean.setEducationTypes(educationTypeMapper.getAllEducationTypes());
        typesDataOBean.setFuntypes(funTypeMapper.getAllFunTypes());
        typesDataOBean.setMajorTypes(majorTypeMapper.getAllMajorTypes());
        typesDataOBean.setMarriedTypes(marriedTypeMapper.getAllMarriedTypes());
        typesDataOBean.setSalaryTypes(salaryTypeMapper.getAllSalaryTypes());
        return typesDataOBean;
    }

}
