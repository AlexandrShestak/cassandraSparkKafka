package com.example.configuration;

import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Bean
    public SparkSession sparkSession() {
        return SparkSession.builder()
                .appName("SpringBootSparkApp")
                .master("local[*]")  // For local development
                .config("spark.driver.bindAddress", "127.0.0.1")
                //.config("spark.driver.extraJavaOptions", "--add-exports java.base/sun.nio.ch=ALL-UNNAMED")
                //.config("spark.executor.extraJavaOptions", "--add-exports java.base/sun.nio.ch=ALL-UNNAMED")
                //.config("spark.sql.warehouse.dir", "file:/tmp/spark-warehouse") // Optional: set Spark warehouse directory
                .getOrCreate();
    }
}