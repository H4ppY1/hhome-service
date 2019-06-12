package com.happy.hhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.happy.hhome.mapper")
public class HhomeApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(HhomeApplication.class, args);
    }
}
