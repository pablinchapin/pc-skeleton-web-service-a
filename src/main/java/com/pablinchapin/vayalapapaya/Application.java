package com.pablinchapin.vayalapapaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.pablinchapin.vayalapapaya"})
public class Application {
    public static void main( String[] args ) {
        //System.out.println( "Hello World!" );
        SpringApplication.run(Application.class, args);
    }
}
