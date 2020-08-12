package org.studyeasy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.studyeasy.cars.Corolla;
import org.studyeasy.cars.Swift;
import org.studyeasy.specs.V6;
import org.studyeasy.specs.V8;

@Configuration
@ComponentScan("org.studyeasy")
public class AppConfig {

    @Bean
    public Corolla corolla() {
        return new Corolla();
    }

    @Bean
    public Swift swift() {
        return new Swift();
    }

    @Bean
    public V6 v6() {
        return new V6();
    }

    @Bean
    public V8 v8() {
        return new V8();
    }
}
