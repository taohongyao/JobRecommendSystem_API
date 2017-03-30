package link.imcloud.jrs.db.mapper;


import link.imcloud.jrs.db.entities.TBUser;

/**
 * Created by 44247 on 2016/8/4 0004.
 */
public interface UserMapper {
    int addUser(TBUser tbUser);
    int alterUser(TBUser tbUser);
    TBUser getUserByAccount(String account);
}

