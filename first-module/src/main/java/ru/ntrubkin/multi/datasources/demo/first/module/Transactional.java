package ru.ntrubkin.multi.datasources.demo.first.module;

import org.springframework.core.annotation.AliasFor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.transaction.annotation.Transactional()
public @interface Transactional {

    @AliasFor(annotation = org.springframework.transaction.annotation.Transactional.class, attribute = "value")
    String value() default "firstTransactionManager";

    @AliasFor(annotation = org.springframework.transaction.annotation.Transactional.class, attribute = "transactionManager")
    String transactionManager() default "firstTransactionManager";

    String[] label() default {};

    Propagation propagation() default Propagation.REQUIRED;

    Isolation isolation() default Isolation.DEFAULT;

    int timeout() default -1;

    String timeoutString() default "";

    boolean readOnly() default false;

    Class<? extends Throwable>[] rollbackFor() default {};

    String[] rollbackForClassName() default {};

    Class<? extends Throwable>[] noRollbackFor() default {};

    String[] noRollbackForClassName() default {};
}
