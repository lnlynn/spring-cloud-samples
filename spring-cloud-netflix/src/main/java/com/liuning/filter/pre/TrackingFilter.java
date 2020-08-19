package com.liuning.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author liuning
 * @since 2020-08-18 23:20
 */
@Component
public class TrackingFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 4;
    private static final boolean SHOULD_FILTER = true;
    private static final String API_NAME = "api_name";
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    public String filterType() {
        return PRE_TYPE;
    }

    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("Processing incoming request for : {}.",ctx.getRequest().getRequestURI());
        if (request.getHeader(API_NAME) != null) {
            logger.info("api_name is {}.", request.getHeader(API_NAME));
            ctx.put(API_NAME, request.getHeader(API_NAME));
        }
        return null;
    }
}
