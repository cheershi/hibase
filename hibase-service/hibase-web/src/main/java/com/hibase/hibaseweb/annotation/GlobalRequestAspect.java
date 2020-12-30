package com.hibase.hibaseweb.annotation;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.hibase.common.core.entity.vo.Result;
import com.hibase.common.core.exception.HibaseException;
import com.hibase.hibaseweb.util.ValidationUtil;
import com.hibase.hibaseweb.valid.HibaseValid;
import com.hibase.hibaseweb.valid.ValidationResult;
import com.hibase.hibaseweb.web.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2019-03-27 21:39
 * @desc
 * @since 1.8
 */
@Component
@Aspect
@Slf4j
public class GlobalRequestAspect extends BaseController {

    @Value("${dc.log.bad.value:3000}")
    private int performanceBadValue;

    @Pointcut("@annotation(com.hibase.hibaseweb.annotation.web.HibasePostRequestMapping) || " +
            "@annotation(com.hibase.hibaseweb.annotation.web.HibaseGetRequestMapping) || " +
            "@annotation(com.hibase.hibaseweb.annotation.web.HibasePatchRequestMapping) || " +
            "@annotation(com.hibase.hibaseweb.annotation.web.HibaseDeleteRequestMapping) || " +
            "@annotation(com.hibase.hibaseweb.annotation.web.HibasePutRequestMapping) || " +
            "@annotation(com.hibase.hibaseweb.annotation.web.HibaseRequestMapping)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Object response;
        try {
            log.info("执行Controller开始: " + pjp.getSignature() + " 参数：" + Lists.newArrayList(pjp.getArgs()).toString());

            // 校验参数是否合法
            this.checkParam(pjp);

            // 执行业务操作
            response = pjp.proceed(pjp.getArgs());
            try {
                log.info("执行Controller结束: " + pjp.getSignature() + "， 返回值：" + JSONUtil.toJsonStr(response));
            } catch (Exception ex) {
                log.error(pjp.getSignature() + " 接口记录返回结果失败！，原因为：{}", ex.getMessage());
            }
            Long consumeTime = stopwatch.stop().elapsed(TimeUnit.MILLISECONDS);
            log.info("耗时：" + consumeTime + "(毫秒).");
            //当接口请求时间大于3秒时，标记为异常调用时间，并记录入库
            if (consumeTime > performanceBadValue) {
//                DcPerformanceEntity dcPerformanceEntity = new DcPerformanceEntity();
//                dcPerformanceEntity.setInterfaceName(pjp.getSignature().toString());
//                dcPerformanceEntity.setRequestParam(Lists.newArrayList(pjp.getArgs()).toString());
//                dcPerformanceEntity.setConsumeTime(consumeTime + "毫秒");
//                RabbitMQMessageTarget mqTarget = RabbitMQMessageTarget.createFanoutTarget(ProjectConstants.DC_KEY_EXCHANGE_PERFORMANCE, new String[]{ProjectConstants.DC_KEY_QUEUE_PERFORMANCE});
//                rabbitMQService.send(mqTarget, JSON.toJSONString(dcPerformanceEntity));
                // 暂时只打日志，不做记录
                log.error(pjp.getSignature().toString() + "请求超出指定时间");
            }
        } catch (Exception throwable) {
            //处理异常
            response = handlerException(pjp, throwable);
        }

        return response;
    }

    /**
     * 校验参数是否合法
     * @param pjp
     */
    private void checkParam(ProceedingJoinPoint pjp) {

        if (pjp != null) {

            Object[] objects = pjp.getArgs();

            if (ArrayUtil.isNotEmpty(objects)) {

                for (Object object : objects) {

                    if (object != null && object.getClass() != null) {
                        HibaseValid hibaseValid = object.getClass().getAnnotation(HibaseValid.class);
                        if (hibaseValid != null) {

                            ValidationResult result = ValidationUtil.validateEntity(object);
                            if (result.hasErrors()) {

                                throw new HibaseException(result.getDefaultMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 处理接口调用异常
     */
    private Result handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result response;
        if (e instanceof HibaseException) {
            HibaseException hibaseException = (HibaseException) e;
            log.error("捕获到EntityValidException异常:", ExceptionUtil.getRootCauseMessage(hibaseException.getCause()));
            response = super.failMsg(hibaseException.getCode(), e.getMessage());
        }
        else if (e instanceof RuntimeException) {
            String errorMsg = e.toString().length() > 500 ? e.toString().substring(0, 500) : e.toString();
            log.error("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + ExceptionUtil.getRootCauseMessage(e.getCause()) + "}", e);
            response = super.failMsg(Result.FAIL_CODE, errorMsg);
        } else {
            log.error("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}", e);
            response = super.failMsg(Result.FAIL_CODE, Result.FAIL_MESG);
        }
        return response;
    }

}
