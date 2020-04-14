package com.ailbb.aws.init;

import com.ailbb.ajj.$;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 在项目启动时，如果要执行操作，可以在applicationContext.xml里面配置bean。 <bean class="com.broadtech.manage.InitManage"></bean>
 * 若要使用系统连接bean需要实现ApplicationListener<ContextRefreshedEvent> 接口
 * Created by Wz on 2016/12/26.
 */
@Component("DataSourceInitListener")
public class AilbbInit implements ApplicationListener<ContextRefreshedEvent> {
    private Logger logger = Logger.getLogger(AilbbInit.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent ev) {
        //防止重复执行。
        if(ev.getApplicationContext().getParent() == null) init(ev);
    }

    public void init(ContextRefreshedEvent ev){
        logger.info("info：初始化资源加载...");
    }
}
