package com.whn.Interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WangHn
 * @Date: 2024/1/12 15:40
 * @Description: 拦截器
 * 登录检查
 * 1、配置好拦截器要拦截哪些请求
 * 2、把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        Map<String, Object> allRequestParams = getAllRequestParams(request);
        JSONObject jsonObject = new JSONObject(allRequestParams);
        log.info("preHandle拦截的请是{},的{}请求,请求参数为：{}", requestURI, method, jsonObject);

        //登录检查逻辑
        String loginUser =(String) request.getHeader("Authorization");

        log.info("loginUser:"+loginUser);
        if (!StringUtils.isEmpty(loginUser)) {
            //放行
            return true;
        }

        //拦截住。未登录。跳转到登录页
        request.setAttribute("msg", "请先登录");
//        re.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    /**
     * 目标方法执行完成以后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}", modelAndView);
    }

    /**
     * 页面渲染以后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}", ex);
    }

    /**
     * 获取请求参数信息
     * @param request
     * @return
     */

    public Map<String, Object> getAllRequestParams(HttpServletRequest request) {
        Map<String, Object> paramsMap = new HashMap<>();
        // 获取所有参数名称
        Enumeration<String> paramNames = request.getParameterNames();
        // 遍历参数名称，并获取对应的所有值（可能有多个）
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            paramsMap.put(paramName, request.getParameterValues(paramName));
        }

        return paramsMap;
    }
}
