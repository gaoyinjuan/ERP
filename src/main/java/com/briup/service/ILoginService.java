package com.briup.service;

import com.briup.exception.CustomException;
import com.briup.bean.Employee;
import com.briup.bean.SystemManager;


public interface ILoginService {
     Employee findEmployeeByIdAndPassword(String account, String password) throws CustomException;
     SystemManager findSystemManagerByIdAndPassword(String account, String password) throws CustomException;
     Employee findEmployeeById(int id);
     SystemManager findSystemManagerById(int id);
}
