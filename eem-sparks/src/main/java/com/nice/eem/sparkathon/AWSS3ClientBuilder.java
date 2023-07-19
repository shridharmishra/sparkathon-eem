package com.nice.eem.sparkathon;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


public class AWSS3ClientBuilder {


    public static void main(String[] args) {
        buildS3Client();
    }


    /**
     * build aws s3 client
     *
     * @return
     */
    public static AmazonS3 buildS3Client() {
        AmazonS3 s3Client;
        String awsRegion = "us-east-1";
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("XXXXXXXXXXXXXXXXXXXX", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        s3Client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(awsRegion)
                .build();

        return s3Client;
    }


}
