package com.maju.k;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AwsS3Config {

    @Value("${spring.cloud.aws.s3.region}")
    private String region;
    
    @Value("${spring.cloud.aws.credentials.access-key}")
    private String accesskey;
    
    @Value("${spring.cloud.aws.credentials.secret-key}")
    private String secretkey;

//    @Value("${s3.dongkeon.spring.cloud.aws.s3.region}")
//    private String dongkeonRegion;
    
//    @Value("${s3.dongkeon.spring.cloud.aws.credentials.access-key}")
//    private String dongkeonAccesskey;
//    
//    @Value("${s3.dongkeon.spring.cloud.aws.credentials.secret-key}")
//    private String dongkeonSecretkey;
    
    
    
    
    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(region))  // 명시적으로 리전 설정
                .credentialsProvider(StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(accesskey, secretkey)
                )).build();
    }
    
//    @Bean
//    public S3Client dongkeonS3Client() {
//        return S3Client.builder()
//                .region(Region.of(dongkeonRegion))  // 명시적으로 리전 설정
//                .credentialsProvider(StaticCredentialsProvider.create(
//                    AwsBasicCredentials.create(dongkeonAccesskey, dongkeonSecretkey)
//                )).build();
//    }
}