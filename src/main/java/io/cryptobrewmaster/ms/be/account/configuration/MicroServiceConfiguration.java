package io.cryptobrewmaster.ms.be.account.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class MicroServiceConfiguration {

    @Bean
    public Clock utcClock() {
        return Clock.systemUTC();
    }

}
