package com.nice.eem.sparkathon;


import lombok.Data;

@Data
public class LambdaConfig {

    private String accessKey;
    private String secretKey;
    private String region;
    private String isCloudDeployment;

}
