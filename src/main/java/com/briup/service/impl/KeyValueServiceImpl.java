package com.briup.service.impl;

import com.briup.dao.KeyValueMapper;
import com.briup.bean.KeyValue;
import com.briup.service.IKeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyValueServiceImpl implements IKeyValueService {
    @Autowired
    private KeyValueMapper keyValueMapper = null;

    public KeyValue getKeyValueById(int id) throws Exception{
        return keyValueMapper.selectByPrimaryKey(id);
    }

    @Override
    public KeyValue selectBykvKey(String key) throws Exception {
        return keyValueMapper.selectBykvKey(key);
    }

    @Override
    public int updateByPrimaryKey(KeyValue kv) throws Exception {
        return keyValueMapper.updateByPrimaryKey(kv);
    }
}
