/*
 * Copyright 2011-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.s3;

import com.amazonaws.annotation.NotThreadSafe;
import com.amazonaws.annotation.SdkTestInternalApi;
import com.amazonaws.client.builder.AwsSyncClientBuilder;
import com.amazonaws.internal.SdkFunction;


@NotThreadSafe
public abstract class AmazonS3Builder<Subclass extends AmazonS3Builder, TypeToBuild extends AmazonS3> extends AwsSyncClientBuilder<Subclass, TypeToBuild> {

    private static final AmazonS3ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new AmazonS3ClientConfigurationFactory();

    private static final SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3> DEFAULT_CLIENT_FACTORY = new SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3>() {
        @Override
        public AmazonS3 apply(AmazonS3ClientParamsWrapper params) {
            return new AmazonS3Client(params);
        }
    };

    protected final SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3> clientFactory;

    private Boolean pathStyleAccessEnabled;
    private Boolean chunkedEncodingDisabled;
    private Boolean accelerateModeEnabled;
    private Boolean payloadSigningEnabled;
    private Boolean dualstackEnabled;

    protected AmazonS3Builder() {
        this(DEFAULT_CLIENT_FACTORY);
    }

    @SdkTestInternalApi
    AmazonS3Builder(SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3> clientFactory) {
        super(CLIENT_CONFIG_FACTORY);
        this.clientFactory = clientFactory;
    }

    /**
     * @return The current setting for path style access configured in the builder.
     */
    public Boolean isPathStyleAccessEnabled() {
        return pathStyleAccessEnabled;
    }

    /**
     * <p>Configures the client to use path-style access for all requests.</p>
     *
     * <p>Amazon S3 supports virtual-hosted-style and path-style access in all Regions. The
     * path-style syntax, however, requires that you use the region-specific endpoint when
     * attempting to access a bucket.</p>
     *
     * <p>The default behaviour is to detect which access style to use based on the configured
     * endpoint (an IP will result in path-style access) and the bucket being accessed (some buckets
     * are not valid DNS names). Setting this flag will result in path-style access being used for
     * all requests.</p>
     *
     * @param pathStyleAccessEnabled True to always use path-style access.
     */
    public void setPathStyleAccessEnabled(Boolean pathStyleAccessEnabled) {
        this.pathStyleAccessEnabled = pathStyleAccessEnabled;
    }

    /**
     * <p>Configures the client to use path-style access for all requests.</p>
     *
     * <p>Amazon S3 supports virtual-hosted-style and path-style access in all Regions. The
     * path-style syntax, however, requires that you use the region-specific endpoint when
     * attempting to access a bucket.</p>
     *
     * <p> The default behaviour is to detect which access style to use based on the configured
     * endpoint (an IP will result in path-style access) and the bucket being accessed (some buckets
     * are not valid DNS names). Setting this flag will result in path-style access being used for
     * all requests.</p>
     *
     * @param pathStyleAccessEnabled True to always use path-style access.
     * @return This object for method chaining.
     */
    public Subclass withPathStyleAccessEnabled(Boolean pathStyleAccessEnabled) {
        setPathStyleAccessEnabled(pathStyleAccessEnabled);
        return getSubclass();
    }

    /**
     * <p>Enables path style access for clients built via this builder.</p>
     *
     * <p>Amazon S3 supports virtual-hosted-style and path-style access in all Regions. The
     * path-style syntax, however, requires that you use the region-specific endpoint when
     * attempting to access a bucket.</p>
     *
     * <p>The default behaviour is to detect which access style to use based on the configured
     * endpoint (an IP will result in path-style access) and the bucket being accessed (some buckets
     * are not valid DNS names). Setting this flag will result in path-style access being used for
     * all requests.</p>
     *
     * @return This object for method chaining.
     */
    public Subclass enablePathStyleAccess() {
        setPathStyleAccessEnabled(Boolean.TRUE);
        return getSubclass();
    }

    /**
     * @return The current setting for chunked encoding configured in the builder.
     */
    public Boolean isChunkedEncodingDisabled() {
        return chunkedEncodingDisabled;
    }

    /**
     * <p>Configures the client to disable chunked encoding for all requests.</p>
     *
     * <p>The default behavior is to enable chunked encoding automatically for PutObjectRequest and
     * UploadPartRequest. Setting this flag will result in disabling chunked encoding for all
     * requests.</p>
     *
     * <p><b>Note:</b> Enabling this option has performance implications since the checksum for the
     * payload will have to be pre-calculated before sending the data. If your payload is large this
     * will affect the overall time required to upload an object. Using this option is recommended
     * only if your endpoint does not implement chunked uploading.</p>
     *
     * @param chunkedEncodingDisabled True to disable chunked encoding.
     */
    public void setChunkedEncodingDisabled(Boolean chunkedEncodingDisabled) {
        this.chunkedEncodingDisabled = chunkedEncodingDisabled;
    }

    /**
     * <p>Configures the client to disable chunked encoding for all requests.</p>
     *
     * <p>The default behavior is to enable chunked encoding automatically for PutObjectRequest and
     * UploadPartRequest. Setting this flag will result in disabling chunked encoding for all
     * requests.</p>
     *
     * <p><b>Note:</b> Enabling this option has performance implications since the checksum for the
     * payload will have to be pre-calculated before sending the data. If your payload is large this
     * will affect the overall time required to upload an object. Using this option is recommended
     * only if your endpoint does not implement chunked uploading.</p>
     *
     * @param chunkedEncodingDisabled True to disable chunked encoding.
     * @return this Builder instance that can be used for method chaining
     */
    public Subclass withChunkedEncodingDisabled(Boolean chunkedEncodingDisabled) {
        setChunkedEncodingDisabled(chunkedEncodingDisabled);
        return getSubclass();
    }

    /**
     * <p>Disables chunked encoding on clients built via the builder.</p>
     *
     * <p>The default behavior is to enable chunked encoding automatically for PutObjectRequest and
     * UploadPartRequest. Setting this flag will result in disabling chunked encoding for all
     * requests.</p>
     *
     * <p><b>Note:</b> Enabling this option has performance implications since the checksum for the
     * payload will have to be pre-calculated before sending the data. If your payload is large this
     * will affect the overall time required to upload an object. Using this option is recommended
     * only if your endpoint does not implement chunked uploading.</p>
     *
     * @return this Builder instance that can be used for method chaining
     */
    public Subclass disableChunkedEncoding() {
        setChunkedEncodingDisabled(Boolean.TRUE);
        return getSubclass();
    }

    /**
     * @return The current setting for accelerate mode configured in the builder.
     */
    public Boolean isAccelerateModeEnabled() {
        return accelerateModeEnabled;
    }

    /**
     * <p>Configures the client to use S3 accelerate endpoint for all requests.</p>
     *
     * <p>A bucket by default cannot be accessed in accelerate mode. If you wish to do so, you need
     * to enable the accelerate configuration for the bucket in advance. To enable accelerate mode
     * see {@link com.amazonaws.services.s3.AmazonS3Client#setBucketAccelerateConfiguration(com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest)}.
     * </p>
     *
     * @param accelerateModeEnabled True to enable accelerate mode.
     * @return This object for method chaining.
     */
    public void setAccelerateModeEnabled(Boolean accelerateModeEnabled) {
        this.accelerateModeEnabled = accelerateModeEnabled;
    }

    /**
     * <p>Configures the client to use S3 accelerate endpoint for all requests.</p>
     *
     * <p>A bucket by default cannot be accessed in accelerate mode. If you wish to do so, you need
     * to enable the accelerate configuration for the bucket in advance. To enable accelerate mode
     * see {@link com.amazonaws.services.s3.AmazonS3Client#setBucketAccelerateConfiguration(com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest)}.
     * </p>
     *
     * @param accelerateModeEnabled True to enable accelerate mode.
     * @return This object for method chaining.
     */
    public Subclass withAccelerateModeEnabled(Boolean accelerateModeEnabled) {
        setAccelerateModeEnabled(accelerateModeEnabled);
        return getSubclass();
    }

    /**
     * <p>Enables accelerate mode on clients built with the builder.</p>
     *
     * <p>A bucket by default cannot be accessed in accelerate mode. If you wish to do so, you need
     * to enable the accelerate configuration for the bucket in advance. To enable accelerate mode
     * see {@link com.amazonaws.services.s3.AmazonS3Client#setBucketAccelerateConfiguration(com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest)}.
     * </p>
     *
     * @return This object for method chaining.
     */
    public Subclass enableAccelerateMode() {
        setAccelerateModeEnabled(Boolean.TRUE);
        return getSubclass();
    }

    /**
     * @return The current setting for payload signing configured in the builder.
     */
    public Boolean isPayloadSigningEnabled() {
        return payloadSigningEnabled;
    }

    /**
     * <p>Configures the client to sign payloads in all situations.</p>
     *
     * <p>Payload signing is optional when chunked encoding is not used and requests are made
     * against an HTTPS endpoint.  Under these conditions the client will by default opt to not sign
     * payloads to optimize performance.  If this flag is set to true the client will instead always
     * sign payloads.</p>
     *
     * <p><b>Note:</b> Payload signing can be expensive, particularly if transferring large payloads
     * in a single chunk.  Enabling this option will result in a performance penalty.</p>
     *
     * @param payloadSigningEnabled True to explicitly enable payload signing in all situations
     */
    public void setPayloadSigningEnabled(Boolean payloadSigningEnabled) {
        this.payloadSigningEnabled = payloadSigningEnabled;
    }

    /**
     * <p>Configures the client to sign payloads in all situations.</p>
     *
     * <p>Payload signing is optional when chunked encoding is not used and requests are made
     * against an HTTPS endpoint. Under these conditions the client will by default opt to not sign
     * payloads to optimize performance.  If this flag is set to true the client will instead always
     * sign payloads.</p>
     *
     * <p><b>Note:</b> Payload signing can be expensive, particularly if transferring large payloads
     * in a single chunk. Enabling this option will result in a performance penalty.</p>
     *
     * @param payloadSigningEnabled True to explicitly enable payload signing in all situations
     * @return This object for method chaining.
     */
    public Subclass withPayloadSigningEnabled(Boolean payloadSigningEnabled) {
        setPayloadSigningEnabled(payloadSigningEnabled);
        return getSubclass();
    }

    /**
     * <p>Enables payload signing for all situations on clients built via this builder.</p>
     *
     * <p>Payload signing is optional when chunked encoding is not used and requests are made
     * against an HTTPS endpoint.  Under these conditions the client will by default opt to not sign
     * payloads to optimize performance.  If this flag is set to true the client will instead always
     * sign payloads.</p>
     *
     * <p><b>Note:</b> Payload signing can be expensive, particularly if transferring large payloads
     * in a single chunk.  Enabling this option will result in a performance penalty.</p>
     *
     * @return This object for method chaining.
     */
    public Subclass enablePayloadSigning() {
        setPayloadSigningEnabled(Boolean.TRUE);
        return getSubclass();
    }

    /**
     * @return The current setting for dualstack mode configured in the builder.
     */
    public Boolean isDualstackEnabled() {
        return dualstackEnabled;
    }

    /**
     * <p>Configures the client to use Amazon S3 dualstack mode for all requests.</p>
     *
     * @param dualstackEnabled True to enable dualstack mode.
     * @return This object for method chaining.
     */
    public void setDualstackEnabled(Boolean dualstackEnabled) {
        this.dualstackEnabled = dualstackEnabled;
    }

    /**
     * <p>Configures the client to use Amazon S3 dualstack mode for all requests.</p>
     *
     * @param dualstackEnabled True to enable dualstack mode.
     * @return This object for method chaining.
     */
    public Subclass withDualstackEnabled(Boolean dualstackEnabled) {
        setDualstackEnabled(dualstackEnabled);
        return getSubclass();
    }

    /**
     * <p>Enables dualstack mode on clients built with the builder.</p>

     * @return This object for method chaining.
     */
    public Subclass enableDualstack() {
        setDualstackEnabled(Boolean.TRUE);
        return getSubclass();
    }

    protected S3ClientOptions resolveS3ClientOptions() {
        final S3ClientOptions.Builder builder = S3ClientOptions.builder();
        if (this.chunkedEncodingDisabled != null && this.chunkedEncodingDisabled) {
            builder.disableChunkedEncoding();
        }
        if (this.payloadSigningEnabled != null) {
            builder.setPayloadSigningEnabled(this.payloadSigningEnabled);
        }
        if (this.accelerateModeEnabled != null) {
            builder.setAccelerateModeEnabled(this.accelerateModeEnabled);
        }
        if (this.pathStyleAccessEnabled != null) {
            builder.setPathStyleAccess(this.pathStyleAccessEnabled);
        }
        if(this.dualstackEnabled != null && this.dualstackEnabled) {
            builder.enableDualstack();
        }
        return builder.build();
    }
}
