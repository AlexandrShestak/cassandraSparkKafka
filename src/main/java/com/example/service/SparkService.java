package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Service
@Slf4j
public class SparkService {

    private final SparkSession sparkSession;


    public SparkService(SparkSession sparkSession) {
        this.sparkSession = sparkSession;
    }

    public void sparkShowEmployees() {
        try {
            Dataset<Row> data = sparkSession.read()
                    .csv(ResourceUtils.getFile("classpath:employees.csv").getAbsolutePath());
            data.show();
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException", e);
        }
    }
}