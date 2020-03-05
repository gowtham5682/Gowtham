package com.hexaware.util;

import java.io.IOException;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 * Class to add the necessary header to the make sure the necessary requests are
 * accepted
 */
class CORSFilter implements ContainerResponseFilter {

    /**
     * this method adds the necessary headers to allow the cross-origin requests
     * 
     * @param request  - the request object
     * @param response - the response object
     */
    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS,HEAD");
    }
}

/**
 * this class will set up the cors filter and the Rest class scan
 */
@ApplicationPath("/")
public class FTPApplication extends ResourceConfig {
    public FTPApplication() {
        // register the package with the REST classes
        // package-scanning
        packages("com.hexaware.util");
        // register the cors filter
        register(new CORSFilter());

        // enable tracing support
        property(ServerProperties.TRACING, "ALL");
    }
}