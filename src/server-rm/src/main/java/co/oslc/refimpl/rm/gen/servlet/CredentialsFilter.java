// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.rm.gen.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.AbstractMap.SimpleEntry;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.server.OAuthServlet;

import org.eclipse.lyo.server.oauth.consumerstore.FileSystemConsumerStore;
import org.eclipse.lyo.server.oauth.core.OAuthConfiguration;
import org.eclipse.lyo.server.oauth.core.OAuthRequest;
import org.eclipse.lyo.server.oauth.core.token.SimpleTokenStrategy;
import org.eclipse.lyo.server.oauth.core.AuthenticationException;
import co.oslc.refimpl.rm.gen.auth.AuthenticationApplication;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class CredentialsFilter implements Filter {
    private final static Logger log = LoggerFactory.getLogger(CredentialsFilter.class);

    //For debugging, it might be convenient sometimes to deactivate oauth authentication. By enabling this flag, all http requests are no longer protected.
    private static Boolean ignoreResourceProtection = false;
    // Start of user code override_ignoreResourceProtection
    // End of user code

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    /**
     * Check if the resource is protected
     * 
     * @return true - the resource is protected, otherwise false
     */
    private boolean isProtectedResource(HttpServletRequest httpRequest) {
        if (ignoreResourceProtection) {
            return false;
        }
        String pathInfo = httpRequest.getPathInfo();

        //'protectedResource' defines the basic set of requests that needs to be protected. 
        //You can override this defintion in the user protected code block below.
        boolean protectedResource = !pathInfo.startsWith("/rootservices") && !pathInfo.startsWith("/oauth");
        // Start of user code isProtectedResource
        // End of user code
        return protectedResource;
    }

    @Override
    public void destroy() {
    }

    /**
     * Check for OAuth or BasicAuth credentials and challenge if not found.
     * 
     * Store the application connection in the HttpSession for retrieval in the REST services.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            if (isProtectedResource(request)) {
                AuthenticationApplication authenticationApplication = AuthenticationApplication.getApplication();
                // Start of user code doFilter_protectedResource_init
                // End of user code
                
                //Check if this is an OAuth1 request.
                //String clientRequestURL = UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(request.getPathInfo()).build().toString();
                OAuthMessage message = OAuthServlet.getMessage(request, null);
                // Start of user code checkOauth1_Init
                // End of user code
                log.trace(request.getPathInfo() + " - checking for oauth1 authentication");
                if (message.getToken() != null) {
                    log.trace(request.getPathInfo() + " - Found an oauth1 token. Validating it.");
                    try {
                        OAuthRequest oAuthRequest = new OAuthRequest(request);
                        oAuthRequest.validate();
                        String applicationConnector = authenticationApplication.getApplicationConnector(message.getToken());
                        if (applicationConnector == null) {
                            // Start of user code checkOauth1_applicationConnectorNull
                            // End of user code
                            log.trace(request.getPathInfo() + " - oauth1 authentication not valid. Raising an exception TOKEN_REJECTED");
                            throw new OAuthProblemException(OAuth.Problems.TOKEN_REJECTED);
                        }
                        log.trace(request.getPathInfo() + " - oauth1 authentication is valid. Done.");
                        authenticationApplication.bindApplicationConnectorToSession(request, applicationConnector);
                    } catch (OAuthException e) {
                        // Start of user code checkOauth1_exception
                        // End of user code
                        OAuthServlet.handleException(response, e, authenticationApplication.getRealm(request));
                        return;
                    }
                } 
                else {
                    // This is not an OAuth request, so check for authentication in the session
                    // Start of user code checkSession_Init
                    // End of user code
                    log.trace(request.getPathInfo() + " - checking for authentication in the session");
                    String applicationConnector = authenticationApplication.getApplicationConnectorFromSession(request);
                    if (null != applicationConnector) {
                        log.trace(request.getPathInfo() + " - session authentication done");
                        // Start of user code checkSession_Final
                        // End of user code
                    } else {
                        // Start of user code basicAuth_Init
                    // End of user code
                        log.trace(request.getPathInfo() + " - checking for basic authentication");
                        // Start of user code basicAuth_nullConnector
                        // End of user code
                        try {
                            //Check for basic authentication
                            Optional<SimpleEntry> basicAuthenticationFromRequest = authenticationApplication.getBasicAuthenticationFromRequest(request);
                            if (basicAuthenticationFromRequest.isEmpty()) {
                                log.trace(request.getPathInfo() + " - no authentication identified. Throwing an exception");
                                throw new AuthenticationException("No or invalid basic authentication header identified in request.");
                            } else {
                                log.trace(request.getPathInfo() + " - basic authentication done");
                                // Start of user code basicAuth_Final
                                // End of user code
                            }
                        } catch (AuthenticationException e) {
                            // Start of user code basicAuth_authenticationException
                            // End of user code
                            authenticationApplication.sendUnauthorizedResponse(request, response, e);
                            return;
                        } 
                    }
                    // Start of user code basicAuth_final
                    // End of user code
                }
            // Start of user code doFilter_protectedResource_final
            // End of user code
            } else {
                // Start of user code doFilter_notProtectedResource
                // End of user code
            }
        }
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        OAuthConfiguration config = OAuthConfiguration.getInstance();
        AuthenticationApplication authenticationApplication = AuthenticationApplication.getApplication();
        
        // Validates a user's ID and password.
        config.setApplication(authenticationApplication);

        // Start of user code init
        // End of user code

        /*
         * Override some SimpleTokenStrategy methods so that we can keep the
         * BugzillaConnection associated with the OAuth tokens.
         */
        config.setTokenStrategy(new SimpleTokenStrategy() {
            @Override
            public void markRequestTokenAuthorized(HttpServletRequest httpRequest, String requestToken)
                    throws OAuthProblemException {
                // Start of user code markRequestTokenAuthorized_init
                // End of user code
                authenticationApplication.putApplicationConnector(requestToken, authenticationApplication.getApplicationConnectorFromSession(httpRequest));
                // Start of user code markRequestTokenAuthorized_mid
                // End of user code
                super.markRequestTokenAuthorized(httpRequest, requestToken);
                // Start of user code markRequestTokenAuthorized_final
                // End of user code
            }

            @Override
            public void generateAccessToken(OAuthRequest oAuthRequest) throws OAuthProblemException, IOException {
                // Start of user code generateAccessToken_init
                // End of user code
                String requestToken = oAuthRequest.getMessage().getToken();
                // Start of user code generateAccessToken_mid
                // End of user code
                super.generateAccessToken(oAuthRequest);
                authenticationApplication.moveApplicationConnector(requestToken, oAuthRequest.getAccessor().accessToken);
                // Start of user code generateAccessToken_final
                // End of user code
            }
        });

        try {
            // For now, hard-code the consumers.
            config.setConsumerStore(new FileSystemConsumerStore(authenticationApplication.getOslcConsumerStoreFilename()));
        } catch (Throwable t) {
            log.error("Error initializing the OAuth consumer store: " + t.getMessage());
        }
    }
}
