package com.example.elasticsearchstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.config.EnableReactiveElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author liwenzhu
 */
@SpringBootApplication
@EnableElasticsearchRepositories
public class ElasticsearchStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchStudyApplication.class, args);
    }

}
