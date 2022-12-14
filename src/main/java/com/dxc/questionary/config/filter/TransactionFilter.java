//package com.dxc.questionary.config.filter;
//
//import cn.hutool.json.JSONUtil;
//import com.alibaba.excel.util.StringUtils;
//import com.dxc.questionary.config.JSONResult;
//import com.dxc.questionary.config.constant.Constant;
//import com.dxc.questionary.utils.JwtUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * @author huang
// */
//@Slf4j
//@Component
//@Order(1)
//public class TransactionFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        log.info("======== do filter ========");
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        String origin = ((HttpServletRequest) request).getHeader("Origin");
//        if (StringUtils.isBlank(origin)) {
//            resp.setHeader("Access-Control-Allow-Origin", origin);
//        }
//        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        resp.setHeader("Access-Control-Max-Age", "3600");
////        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        String headers = req.getHeader("Access-Control-Request-Headers");
//        if (StringUtils.isNotBlank(headers)) {
//            resp.setHeader("Access-Control-Allow-Headers", headers);
//        }
//        resp.addHeader("Access-Control-Allow-Credentials", "true");
//
//        if (req.getRequestURI().contains(Constant.LOGIN_URL)) {
//            log.info("user login");
//            chain.doFilter(request, response);
//            return;
//        }
//        log.info("verify token");
//        String token = req.getHeader("token");
//        log.info("Token:" + token);
//        if (JwtUtil.isNull(token) || !JwtUtil.tokenVerify(token)) {
//            log.error("token verify failed");
//            resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
//            PrintWriter writer = response.getWriter();
//            writer.print(JSONUtil.parseObj(JSONResult.Failed("token verify error", null)));
//        } else {
//            if (JwtUtil.tokenVerify(token)) {
//                log.info("token verify success");
//                chain.doFilter(request, response);
//            }
//        }
//
//    }
//}