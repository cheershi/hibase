package com.hibase.hibaseweb.util;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法类用来拷贝转化对象
 */
public class EntityUtil {

	/**
	 * 实体转换
	 * @param source 源对象
	 * @param targetClass 目标对象的Class类型
	 * @return
	 */
	public static <S, T> T transform(S source, Class<? extends T> targetClass) {
		if (!ObjectUtil.isNull(source)) {
			T target = null;
			try {
				target = targetClass.newInstance();
				BeanUtils.copyProperties(source, target);
			} catch (Exception e) {
				return null;
			}
			return target;
		} else {
			return null;
		}
	}

	/**
	 * 实体列表转换
	 * @param sourceList
	 * @param targetClass
	 * @return
	 */
	public static <S,T> List<T> transform(List<S> sourceList, Class<? extends T> targetClass) {
		List<T> result = new ArrayList<T>();
		if (!ObjectUtil.isNull(sourceList)) {
			for (S source : sourceList) {
				result.add(transform(source, targetClass));
			}
		}
		return result;
	}


}
