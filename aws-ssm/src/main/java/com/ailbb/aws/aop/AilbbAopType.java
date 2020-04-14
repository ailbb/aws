package com.ailbb.aws.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD})   
@Retention(RetentionPolicy.RUNTIME)   
@Documented
public @interface AilbbAopType {
	TypeHandler aopType();

	enum TypeHandler {
		QUERY("查询"),
		TEST("测试");

		private String desc;

		private TypeHandler(String desc) {
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

	}
}  

