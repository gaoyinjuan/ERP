package com.briup.dao;

import com.briup.bean.SystemManager;

public interface SystemManagerMapper {
    int deleteByPrimaryKey(Integer smId);

    int insert(SystemManager record);

    int insertSelective(SystemManager record);

    SystemManager selectByPrimaryKey(Integer smId);

    int updateByPrimaryKeySelective(SystemManager record);

    int updateByPrimaryKey(SystemManager record);

    SystemManager selectByAccountAndPassword(SystemManager systemManager);
}