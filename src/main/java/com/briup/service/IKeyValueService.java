package com.briup.service;

import com.briup.bean.KeyValue;

public interface IKeyValueService {
     KeyValue getKeyValueById(int id) throws Exception;
     KeyValue selectBykvKey(String key)throws Exception;
     int updateByPrimaryKey(KeyValue kv)throws Exception;
}
