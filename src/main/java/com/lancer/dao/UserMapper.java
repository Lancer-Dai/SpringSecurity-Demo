package com.lancer.dao;

import com.lancer.beans.UserInfo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface  UserMapper {



    UserInfo getUserByAccount(String account);

}
