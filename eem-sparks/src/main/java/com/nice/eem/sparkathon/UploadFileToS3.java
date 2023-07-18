package com.nice.eem.sparkathon;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class UploadFileToS3 {


    //uploading file to the given s3 bucket using client created by the builder
    public static void uploadFileToS3(AmazonS3 s3Client, String bucketName, String fileName, String filePath) {
        s3Client.putObject(bucketName, fileName, filePath);
        System.out.println("File uploaded successfully");
    }

    //downloading file from s3 bucket using client created by the builder
    public static void downloadFileFromS3(AmazonS3 s3Client, String bucketName, String fileName, String filePath) {
        s3Client.getObject(bucketName, fileName);
        System.out.println("File downloaded successfully");
    }

    /**
     *
     * @param iscloudDeployment
     * @return
     */
    public AmazonS3 buildS3Client(boolean iscloudDeployment) {
        AWSCredentials awsCredentials;
        AmazonS3 s3Client;
        String awsRegion = "us-east-1";
        if (iscloudDeployment) {

            String accessKey = "xxxxxxxxxxxxxxxxxx";
            String secretKey = "xxxxxxxxxxxxxxxxxx";
            awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
            s3Client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(awsRegion)
                    .build();
        } else {

            s3Client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new InstanceProfileCredentialsProvider(true))
                    .withRegion(awsRegion)
                    .build();
        }
        return s3Client;
    }

}
