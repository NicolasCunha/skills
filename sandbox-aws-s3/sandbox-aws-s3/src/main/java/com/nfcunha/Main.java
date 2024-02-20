package com.nfcunha;

public class Main {

  public static void main(String[] args) {
    // All operations require env args: "AWS_ACCESS_KEY_ID" and "AWS_SECRET_ACCESS_KEY"
    new CreateFile().createFile("aws-s3-dev-1", "hello_world.txt", "Hello, world!");
    new DeleteFile().deleteFile("aws-s3-dev-1", "hello_world.txt");
  }



}