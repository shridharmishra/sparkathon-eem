package com.nice.eem.sparkathon;

import lombok.Data;

@Data
public class S3Config {

    private String accessKey;
    private String secretKey;
    private String region;
    private String isCloudDeployment;
}
