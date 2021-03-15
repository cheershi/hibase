package com.hibase.hibaseweb.web;


import com.hibase.common.core.entity.vo.Result;

public abstract class BaseController<T> {

//    public static final String GENERATE_CURD_ENTITY = "curd_entity";
//
//    public String getEntityClass(HttpServletRequest request) {
//
//        return request.getHeader(GENERATE_CURD_ENTITY);
//    }
//
//    public static BaseService getEntityMapper(String entityClass) {
//
//        String iserviceName = entityClass.replaceAll("entity", "service.impl").replaceAll("dataobject\\.", "") + "Mapper";
//
//        try {
//
//            Class serviceClass = Class.forName(iserviceName);
//            BaseService iService = (BaseService) SpringContextUtil.getBean(serviceClass);
//
//            return iService;
//        } catch (Exception e) {
//
//            return null;
//        }
//    }

    /**
     * 返回成功
     * @return
     */
    public Result<T> successMsg() {
        return new Result<T>();
    }

    /**
     * 返回成功，自定义状态码
     * @return
     */
    public Result<T> successMsg(String msg, T data) {
        return new Result<T>(Result.SUCCESSFUL_CODE,msg,data);
    }

    /**
     * 返回成功，自定义状态码
     * @return
     */
    public Result<T> successMsg(T data) {
        return new Result<T>(data);
    }

    /**
     * 返回成功，自定义状态码
     * @return
     */
    public Result<T> failMsg(String code, String msg) {

        return new Result<T>(code, msg);
    }

    /**
     * 返回成功，自定义状态码
     * @return
     */
    public Result<T> failMsg(String code, String msg, T data) {

        return new Result<T>(code, msg,data);
    }
}
