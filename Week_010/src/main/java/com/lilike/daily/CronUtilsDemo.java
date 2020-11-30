package com.lilike.daily;

import com.cronutils.model.Cron;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import com.lilike.util.DateUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;

import static com.cronutils.model.CronType.QUARTZ;

/**
 * @Author llk
 * @Date 2020/11/30 14:21
 * @Version 1.0
 */
public class CronUtilsDemo {

    public static void main(String[] args) {
        howToGetExecutionTimes();
    }

    private static void howToGetExecutionTimes() {

        String quartzCronExpression = "0 30 2,9,12,15,21 * * ?";
        CronParser quartzCronParser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(QUARTZ));
        Cron parsedQuartzCronExpression = quartzCronParser.parse(quartzCronExpression);

        ZonedDateTime now = ZonedDateTime.now();
        ExecutionTime executionTime = ExecutionTime.forCron(parsedQuartzCronExpression);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String last = simpleDateFormat.format(Date.from(executionTime.lastExecution(now).get().toInstant()));
        System.out.println("上一次的执行时间是: " + last);


        String next = simpleDateFormat.format(Date.from(executionTime.nextExecution(now).get().toInstant()));
        System.out.println("下一次的执行时间是: " + next);

    }
}
