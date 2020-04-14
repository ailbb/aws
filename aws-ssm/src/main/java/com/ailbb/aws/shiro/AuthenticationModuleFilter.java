package com.ailbb.aws.shiro;

import com.ailbb.ajj.$;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Wz on 2017/7/27.
 */
public class AuthenticationModuleFilter implements Filter {
    private static final String a = "";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(doAuth(request, response) && doResponse(request, response)) chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 响应拦截
     * @param request
     * @param response
     * @return
     */
    public boolean doResponse(ServletRequest request, ServletResponse response) throws IOException {
        String actionPath = ((ShiroHttpServletRequest) request).getServletPath(); // servlet请求地址
        if(null != actionPath && actionPath.indexOf(".hml") != -1) {
            PrintWriter pw = response.getWriter();
            $.info("请求响应Response进行拦截");
            pw.print("Ailbb, Hello World!");
            pw.flush();
        }

        return true;
    }

    /**
     * 模块鉴权
     * @param request
     * @param response
     */
    public boolean doAuth(ServletRequest request, ServletResponse response) {
        $.info("请求响应Filter进行鉴权");
        return true;
    }
}
