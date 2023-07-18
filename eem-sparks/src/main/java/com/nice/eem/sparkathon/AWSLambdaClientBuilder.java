package com.nice.eem.sparkathon;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.lambda.AWSLambda;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@UtilityClass
public class AWSLambdaClientBuilder {

    private static final Logger logger = LogManager.getLogger(AWSLambdaClientBuilder.class);


    /**
     * this method builds aws lambda client based on whether the deployment is onprem or oncloud based on data available in lambdaconfig
     *
     * @param lambdaConfig
     * @return
     */
    public static AWSLambda buildLambdaClient(LambdaConfig lambdaConfig) {
        AWSCredentials awsCredentials;
        AWSLambda awsLambda;
        String isCloudDeployment = lambdaConfig.getIsCloudDeployment();
        String awsRegion = lambdaConfig.getRegion();
        if (isCloudDeployment.equalsIgnoreCase("false")) {
            logger.info("Building aws lambda client for cloud deployment = {} and aws region = {} ", isCloudDeployment, awsRegion);
            String accessKey = lambdaConfig.getAccessKey();
            String secretKey = lambdaConfig.getSecretKey();
            awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
            awsLambda = com.amazonaws.services.lambda.AWSLambdaClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(awsRegion)
                    .build();
        } else {
            logger.info("Building aws lambda client for cloud deployment = {}", isCloudDeployment);
            awsLambda = com.amazonaws.services.lambda.AWSLambdaClientBuilder
                    .standard()
                    .withCredentials(new InstanceProfileCredentialsProvider(true))
                    .build();
        }
        logger.info(" Building aws lambda client SUCCESSFUL!!!");
        return awsLambda;
    }

}
