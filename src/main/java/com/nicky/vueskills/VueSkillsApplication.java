package com.nicky.vueskills;

import com.nicky.vueskills.websocketserver.setup.ServiceBean;
import com.nicky.vueskills.websocketserver.setup.WebsocketServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class VueSkillsApplication
{
    @Bean
    public ServletRegistrationBean socketServlet()
    {
        return new ServletRegistrationBean(new WebsocketServlet(), "/ws/");
    }

    @Bean
    public ServiceBean randomNameBeanUtil()
    {
        return new ServiceBean();
    }
    
    public static void main(String[] args)
    {
        SpringApplication.run(VueSkillsApplication.class, args);
    }
}
