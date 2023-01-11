package com.cts.microservice.MS4_Resilience4j_CloudCircuitBreaker;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4jBulkheadConfigurationBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4jBulkheadProvider;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
//import io.github.resilience4j.bulkhead.BulkheadConfig;

@SpringBootApplication
public class Ms4Resilience4jCloudCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms4Resilience4jCloudCircuitBreakerApplication.class, args);
	}

@Bean
Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
    return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
            .build());
}

@Bean
 Customizer<Resilience4JCircuitBreakerFactory> slowCustomizer() {
    return factory -> factory.configure(builder -> builder.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(2)).build()), "slow");
}
//@Bean
//public Customizer<Resilience4JCircuitBreakerFactory> slowCustomizer() {
//    return factory -> factory.addCircuitBreakerCustomizer(circuitBreaker -> circuitBreaker.getEventPublisher()
//    .onError(normalFluxErrorConsumer).onSuccess(normalFluxSuccessConsumer), "normalflux");
//}

@Bean
 Customizer<Resilience4jBulkheadProvider> defaultBulkheadCustomizer() {
    return provider -> provider.configureDefault(id -> new Resilience4jBulkheadConfigurationBuilder()
        .bulkheadConfig(BulkheadConfig.custom().maxConcurrentCalls(4).build())
        .threadPoolBulkheadConfig(ThreadPoolBulkheadConfig.custom().coreThreadPoolSize(1).maxThreadPoolSize(1).build())
        .build());
}

@Bean
 Customizer<Resilience4jBulkheadProvider> slowBulkheadProviderCustomizer() {
    return provider -> provider.configure(builder -> builder
        .bulkheadConfig(BulkheadConfig.custom().maxConcurrentCalls(1).build())
        .threadPoolBulkheadConfig(ThreadPoolBulkheadConfig.ofDefaults()), "slowBulkhead");
}

@Bean
 Customizer<Resilience4jBulkheadProvider> customizer() {
    return provider -> provider.addBulkheadCustomizer(bulkhead -> bulkhead.getEventPublisher()
        .onCallRejected(slowRejectedConsumer)
        .onCallFinished(slowFinishedConsumer), "slowBulkhead");
}


@Bean Customizer<Resilience4jBulkheadProvider> customizer() {
    return provider -> provider.addBulkheadCustomizer(bulkhead -> bulkhead.getEventPublisher()
        .onCallRejected(slowRejectedConsumer)
        .onCallFinished(slowFinishedConsumer), "slowBulkhead");
}


@ Customizer<Resilience4jBulkheadProvider> slowThreadPoolBulkheadCustomizer() {
    return provider -> provider.addThreadPoolBulkheadCustomizer(threadPoolBulkhead -> threadPoolBulkhead.getEventPublisher()
        .onCallRejected(slowThreadPoolRejectedConsumer)
        .onCallFinished(slowThreadPoolFinishedConsumer), "slowThreadPoolBulkhead");
}

@Bean
public Customizer<SpringRetryCircuitBreakerFactory> defaultCustomizer() {
    return factory -> factory.configureDefault(id -> new SpringRetryConfigBuilder(id)
        .retryPolicy(new TimeoutRetryPolicy()).build());
}

@Bean
public Customizer<SpringRetryCircuitBreakerFactory> slowCustomizer() {
    return factory -> factory.addRetryTemplateCustomizers(retryTemplate -> retryTemplate.registerListener(new RetryListener() {

        @Override
        public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
            return false;
        }

        @Override
        public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {

        }

        @Override
        public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {

        }
    }));
}
}
