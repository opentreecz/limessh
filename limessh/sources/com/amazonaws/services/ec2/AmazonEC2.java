package com.amazonaws.services.ec2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;

/* loaded from: classes.dex */
public interface AmazonEC2 {
    /* renamed from: a */
    DescribeInstancesResult mo287a() throws AmazonServiceException, AmazonClientException;

    /* renamed from: b */
    DescribeRegionsResult mo288b() throws AmazonServiceException, AmazonClientException;

    /* renamed from: c */
    void m289c(String str) throws IllegalArgumentException;
}
