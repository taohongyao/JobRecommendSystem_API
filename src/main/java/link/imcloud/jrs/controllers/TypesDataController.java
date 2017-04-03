package link.imcloud.jrs.controllers;

import link.imcloud.jrs.beans.BaseOBean;
import link.imcloud.jrs.services.TypesDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 44247 on 2017/4/3 0003.
 */
@Controller
@RequestMapping("/typesdata")
public class TypesDataController {

    @Resource
    protected TypesDataService typesDataService;


    @RequestMapping(value = "/getalltypes.do", method = RequestMethod.POST)
    @ResponseBody
    public BaseOBean getAllTypes() {
        BaseOBean baseOBean =new BaseOBean();
        baseOBean.setContents(typesDataService.getAllAreas());
        baseOBean.setInfo("N01","获取所有类型成功");
        return baseOBean;
    }
}
