package org.cashempire.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.zaxxer.hikari.HikariDataSource;
import io.lettuce.core.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import javax.sql.DataSource;

@Configuration
@EnableAsync
public class DBConfiguration {
    final static Logger logger = LoggerFactory.getLogger(DBConfiguration.class);

    @Bean
    @ConditionalOnProperty(name = "mysql.url")
    public DataSource mysqlDatasource(
            @Value("${mysql.url}") String url,
            @Value("${mysql.username}") String username,
            @Value("${mysql.password}") String password,
            @Value("${mysql.minimumIdle:3000})") String minimumIdle ,
            @Value("${mysql.maxPoolSize:100})") String maxPoolSize
            ){
        logger.info("Mysql DataSource Creation Successfully Started.");
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setMinimumIdle(Integer.parseInt(minimumIdle));
        hikariDataSource.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
        logger.debug("MysqlDatasource Connection : "+ hikariDataSource);
        logger.info("Mysql DataSource Creation Successfully Ended.");
        return hikariDataSource;
    }

   @Bean
   @ConditionalOnProperty(name = "redis.url")
   public RedisClient redisClient(@Value("${redis.url}") String url) {
       return RedisClient.create(url);
   }

   @Bean
   public RestTemplate restTemplate(){
       RestTemplate restTemplate = new RestTemplate();
       return restTemplate;
   }

   @Bean
   @ConditionalOnProperty(name = "cors.origin")
   public HttpHeaders httpHeaders(@Value("{cors.origin}") String origin){
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
      httpHeaders.set(HttpHeaders.ORIGIN,origin);
      return httpHeaders;
   }

   @Bean
   @ConditionalOnProperty(name = "mongo.url")
   public MongoClient mongoClient(@Value("$mongo.url") String mongoUrl){
        return MongoClients.create(mongoUrl);
   }


}
