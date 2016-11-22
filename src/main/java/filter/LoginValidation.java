package filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xiangang on 2016/11/22.
 */
public class LoginValidation implements Filter{

    private FilterConfig filterConfig;


    public boolean isContain(String url,String[] regx){
        boolean flag = false;
        for (int i=0;i<regx.length;i++){
            if (url.indexOf(regx[i])!=-1){
                flag = true;
                return flag;
            }
        }
        return flag;
    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        HttpSession session = httpServletRequest.getSession();

        String logonPath = filterConfig.getInitParameter("logonPath");
        String[] logonString = logonPath.split(";");
        String redirectPath = httpServletRequest.getContextPath()+filterConfig.getInitParameter("redirectPath");
        String userName = httpServletRequest.getParameter("userName");
        String password = httpServletRequest.getParameter("password");
        String currentUrl = httpServletRequest.getRequestURI();

        if (isContain(currentUrl,logonString)){
            chain.doFilter(request,response);
            return;
        }else{
            if (session.getAttribute("user")!=null){
                chain.doFilter(request,response);
                return;
            }
            if ("root".equals(userName) && "admin".equals(password)){
                session.setAttribute("user",userName);
                chain.doFilter(request,response);
                return;
            }else {
                httpServletResponse.sendRedirect(redirectPath);
                return;
            }
        }


    }

    @Override
    public void destroy() {
        this.filterConfig=null;
    }
}
