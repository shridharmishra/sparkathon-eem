package com.nice.eem.sparkathon;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AWSS3Service {

    /**
     * uploading a file to s3 bucket
     */
    public static void uploadFile(String bucketName, String keyName, String filePath) {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
            s3Client.putObject(bucketName, keyName, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * downlnoading a file from s3 bucket
     */
    public static void downloadFile(String bucketName, String keyName, String filePath) {
         try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
            s3Client.getObject(bucketName, keyName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * listing all the files in a bucket
     */

    public static void listFiles(String bucketName) {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
            s3Client.listObjects(bucketName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * create a new bucket in s3
     *
     */
    public static void createBucket(String bucketName) {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
            s3Client.createBucket(bucketName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * delete bucket in s3
     */
    public static void deleteBucket(String bucketName) {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
            s3Client.deleteBucket(bucketName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
