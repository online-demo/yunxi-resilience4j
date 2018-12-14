package com.yunxi.resilience4jdemo.test;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

/**
 * @Author 无双
 * @Date 2018/12/14
 * @Description 针对接口异常的断路统计以及断路处理
 */
public class TestCircuitBreaker {
    public static void main(String[] args) {
        // Create a CircuitBreaker (use default configuration)
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig
                .custom()
                .enableAutomaticTransitionFromOpenToHalfOpen()
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker
                .of("backendName",circuitBreakerConfig);

        String result = circuitBreaker.executeSupplier(() -> {
            return run(1);
        });
        System.out.println(result);

    }

    public static String run(int i) {
        if (i % 2 == 0 && i < 10) {
            return "success";
        } else {
            while (true) {

            }
        }
    }
}
