package com.nice.eem.sparkathon;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;



@Component
@Slf4j
public class AWSS3ClientBuilder {




    /**
     * build aws s3 client
     *
     * @return
     */
    public AmazonS3 buildS3Client(S3Config s3Config) {
        AWSCredentials awsCredentials;
        AmazonS3 s3Client;
        String cloudDeployment = s3Config.getIsCloudDeployment();
        String awsRegion = s3Config.getRegion();
        if (cloudDeployment.equalsIgnoreCase("false")) {
            log.info("Building aws s3 client for non-cloud deployment, isCloudDeployment = {}, aws region = {}", cloudDeployment, awsRegion);
            String accessKey = s3Config.getAccessKey();
            String secretKey = s3Config.getSecretKey();
            awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
            s3Client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(awsRegion)
                    .build();
        } else {
            log.info("Building aws s3 client for clould deployment, isCloudDeployment = {}, aws region = {}", cloudDeployment, awsRegion);
            s3Client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new InstanceProfileCredentialsProvider(true))
                    .withRegion(awsRegion)
                    .build();
        }
        return s3Client;
    }


}
