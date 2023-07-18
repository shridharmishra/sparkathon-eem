package com.nice.eem.sparkathon;

import com.amazonaws.services.s3.AmazonS3;

public class UploadFileToS3 {


    //uploading file to the given s3 bucket using client created by the builder
    public static void uploadFileToS3(AmazonS3 s3Client, String bucketName, String fileName, String filePath) {
        s3Client.putObject(bucketName, fileName, filePath);
        System.out.println("File uploaded successfully");
    }

}
