/**
 *
 */
package org.thingsboard.server.transport.coap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;

@Configuration
@ComponentScan({ "org.thingsboard.server.transport.coap" })
@PropertySource("classpath:coap-transport-test.properties")
public class CoapServerTestConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
