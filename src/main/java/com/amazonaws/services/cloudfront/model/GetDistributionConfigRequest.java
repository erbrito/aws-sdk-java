/*
 * Copyright 2010-2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.cloudfront.model;
import com.amazonaws.AmazonWebServiceRequest;

/**
 * Container for the parameters to the {@link com.amazonaws.services.cloudfront.AmazonCloudFront#getDistributionConfig(GetDistributionConfigRequest) GetDistributionConfig operation}.
 * <p>
 * Get the configuration information about a distribution.
 * </p>
 *
 * @see com.amazonaws.services.cloudfront.AmazonCloudFront#getDistributionConfig(GetDistributionConfigRequest)
 */
public class GetDistributionConfigRequest extends AmazonWebServiceRequest {

    /**
     * The distribution's id.
     */
    private String id;

    /**
     * Default constructor for a new GetDistributionConfigRequest object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public GetDistributionConfigRequest() {}
    
    /**
     * Constructs a new GetDistributionConfigRequest object.
     * Callers should use the setter or fluent setter (with...) methods to
     * initialize any additional object members.
     * 
     * @param id The distribution's id.
     */
    public GetDistributionConfigRequest(String id) {
        this.id = id;
    }
    
    /**
     * The distribution's id.
     *
     * @return The distribution's id.
     */
    public String getId() {
        return id;
    }
    
    /**
     * The distribution's id.
     *
     * @param id The distribution's id.
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * The distribution's id.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param id The distribution's id.
     *
     * @return A reference to this updated object so that method calls can be chained 
     *         together. 
     */
    public GetDistributionConfigRequest withId(String id) {
        this.id = id;
        return this;
    }
    
    
    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("Id: " + id + ", ");
        sb.append("}");
        return sb.toString();
    }
    
}
    