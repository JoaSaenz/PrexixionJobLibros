package com.prexixion.job.libros.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prexixion.job.libros.batch.job.PersonalProcessor;
import com.prexixion.job.libros.batch.job.PersonalReader;
import com.prexixion.job.libros.batch.job.PersonalWriter;
import com.prexixion.job.libros.model.Personal;

@Configuration
@EnableBatchProcessing
public class JobLibrosConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    
    @Autowired
    private PersonalReader itemReader;

    @Autowired
    private PersonalProcessor itemProcessor;

    @Autowired
    private PersonalWriter itemWriter;

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("personalFechasNacimientos")
                .flow(masterStep())
                .end()
                .build();
    }

    @Bean
    public Step masterStep() {
        return stepBuilderFactory.get("masterStep")
                .<Personal, Personal>chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }
}
