/*
 * Copyright (c) 2018 McAfee, Inc.  All rights reserved.
 */

package com.esencia.esencia.rest;



/*
import java.util.Optional;


import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
*/


/**
 * Factory for {@link org.springframework.web.client.RestTemplate}
 */
//@Configuration
public class RestTemplateFactory {

//    private static final String HTTP = "http";
//    private static final String HTTPS = "https";
//
//
//    private boolean ignoreCertificateValidation;
//
//
//    private int connectionTimeOut;
//
//
//    private int readTimeOut;
//
//
//    private boolean proxyAvailable;
//
//
//    private String proxyHost;
//
//
//    private int proxyPort;
//
//
//    /**
//     * Returns a {@link RestTemplate} instance
//     *
//     * @return the {@link RestTemplate}
//     */
//    //@Bean
//    public RestTemplate getRestTemplate() {
//        final ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(buildHttpClient());
//        final RestTemplate restTemplate = new RestTemplate(requestFactory);
//        return restTemplate;
//    }
//
//    private CloseableHttpClient buildHttpClient() {
//
//        // Build the connection manager
//        final PoolingHttpClientConnectionManager connectionManager;
//        final Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
//            .register(HTTP, PlainConnectionSocketFactory.INSTANCE).build();
//        connectionManager = new PoolingHttpClientConnectionManager(registry);
//
//        try {
//            // Build the request configuration
//            final RequestConfig requestConfig =
//                RequestConfig.custom()
//                    .setConnectionRequestTimeout(connectionTimeOut)
//                    .setConnectTimeout(readTimeOut)
//                    .setSocketTimeout(readTimeOut)
//                    .build();
//
//            // Build the route planner
//            final Optional<HttpRoutePlanner> routePlanner = setUpProxyIfAvailable();
//
//            // Build the client
//            final HttpClientBuilder builder = HttpClients
//                .custom()
//                .setConnectionManager(connectionManager)
//                .setDefaultRequestConfig(requestConfig);
//
//            routePlanner.ifPresent(rp -> builder.setRoutePlanner(rp));
//
//            return builder.build();
//
//        } catch (final Exception e) {
//            connectionManager.close();
//            throw e;
//        }
//    }
//
//    private Optional<HttpRoutePlanner> setUpProxyIfAvailable() {
//        HttpRoutePlanner routePlanner = null;
//        if (proxyAvailable) {
//            routePlanner = new DefaultProxyRoutePlanner(new HttpHost(proxyHost, proxyPort));
//        }
//
//        return Optional.ofNullable(routePlanner);
//    }


}
