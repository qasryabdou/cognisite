package com.cognicap.site.web.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cognicap.site.util.LogContext;
import com.cognicap.site.web.util.UserContextUtil;

/**
 * Expose the 'userContext' bean to the view and bind contextual info for logs.
 */
@Service
public class UserContextInterceptor implements HandlerInterceptor {

    @Autowired
    private UserContextUtil userContext;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException {
        request.setAttribute("userContext", userContext);
        LogContext.setLogin(userContext.getUsername() != null ? userContext.getUsername() : "no username");
        LogContext.setSessionId(request.getSession().getId());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        LogContext.resetLogContext();
    }
}