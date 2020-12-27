package com.briup.interceptor;

import com.briup.bean.SystemManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        String string = (String) httpServletRequest.getSession().getAttribute("employeeId");
        SystemManager systemManager = (SystemManager) httpServletRequest.getSession().getAttribute("admin");
        if (string != null) {
            return true;
        } else if (string == null){
            httpServletResponse.sendRedirect("/");
            return false;
        } else if (systemManager != null) {
            return true;
        } else {
            httpServletResponse.sendRedirect("/admin");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
