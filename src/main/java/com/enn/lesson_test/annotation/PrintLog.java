package com.enn.lesson_test.annotation;

import java.lang.annotation.*;

/**这里是要自创一个标注
 * @author enn*/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface PrintLog {
    //打印日志信息
    String value() default "";
}
