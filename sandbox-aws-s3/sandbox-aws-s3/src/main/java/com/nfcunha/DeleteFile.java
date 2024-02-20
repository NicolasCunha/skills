package com.nfcunha;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class DeleteFile {

  public void deleteFile(final String bucket, final String file) {
    final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.SA_EAST_1).build();
    s3.deleteObject(bucket, file);
  }

}
