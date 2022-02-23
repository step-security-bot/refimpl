// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2011, 2012 IBM Corporation and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 *
 *  Contributors:
 *
 *     Sam Padgett         - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Andrii Berezovskyi  - change URL configuration logic (Bug 509767)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.am.gen.servlet;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import co.oslc.refimpl.am.gen.RestDelegate;

// Start of user code imports
// End of user code

/**
 * During the initialization of this ServletListener, the base URI for the OSLC resources produced by this server is configured through the OSLC4J method setPublicURI().
 * <p>
 * See getConfigurationProperty() for the different alternatives to set this base URI. 
 */
public class ServletListener implements ServletContextListener  {
    private static final Logger logger = LoggerFactory.getLogger(ServletListener.class);

    // Start of user code class_attributes
    // End of user code

    public ServletListener() {
        super();
    }

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent)
    {
        //These are default values. You can modify any of them early in this method.
        String basePathKey = "baseurl";
        String fallbackBase = "http://localhost:8080";
        String servletName = "JAX-RS Servlet";

        // Start of user code contextInitialized_init
        // End of user code

        ServletContext servletContext = servletContextEvent.getServletContext();
        String basePathProperty = getConfigurationProperty(basePathKey, fallbackBase, servletContext, ServletListener.class);
        UriBuilder builder = UriBuilder.fromUri(basePathProperty);
        String baseUrl = builder.path(servletContext.getContextPath()).build().toString();
        String servletUrlPattern = "services/";
        try {
            servletUrlPattern = getServletUrlPattern(servletContextEvent, servletName);
        } catch (Exception e1) {
            logger.error("servletListner encountered problems identifying the servlet URL pattern.", e1);
        }
        try {
            logger.info("Setting public URI: " + baseUrl);
            OSLC4JUtils.setPublicURI(baseUrl);
            logger.info("Setting servlet path: " + servletUrlPattern);
            OSLC4JUtils.setServletPath(servletUrlPattern);
        } catch (MalformedURLException e) {
            logger.error("servletListner encountered MalformedURLException.", e);
        } catch (IllegalArgumentException e) {
            logger.error("servletListner encountered IllegalArgumentException.", e);
        }

        logger.info("servletListner contextInitialized.");

        // Establish connection to data backbone etc ...
        RestDelegate.contextInitializeServletListener(servletContextEvent);
        
        // Start of user code contextInitialized_final
        // End of user code
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        // Start of user code contextDestroyed_init
        // End of user code

        // Shutdown connections to data backbone etc...
        RestDelegate.contextDestroyServletListener(servletContextEvent);

        
        // Start of user code contextDestroyed_final
        // End of user code
    }

    // Start of user code class_methods
    private static Optional<String> getBasePathFromSystemProperties(String basePathContextPropertyKey) {
        String base = System.getProperty(basePathContextPropertyKey);
        if (base == null || base.trim().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(base);
    }
    // End of user code

    /**
     * For a property 'scheme', this is the lookup priority:
     * <p>
     * <ol>
     *     <li>LYO_SCHEME env variable</li>
     *     <li>%pkg_name%.scheme JVM property, e.g. org.eclipse.lyo.oslc4j.core.servlet.scheme</li>
     *     <li>%pkg_name%.scheme Servlet Context parameter, e.g. org.eclipse.lyo.oslc4j.core.servlet.scheme</li>
     * </ol>
     * @param key property key name
     * @param defaultValue default String value
     * @param klass Class of the ServletListener
     * @return value, if found, from ENV, JVM, or Servlet Context (in this order)
     */
    private static String getConfigurationProperty(String key, String defaultValue, final ServletContext servletContext, Class klass) {
        String value = getConfigurationPropertyFromEnvironment(generateEnvironmentKey(key))
            .orElseGet(() -> getConfigurationPropertyFromSystemProperties(generateFullyQualifiedKey(klass, key))
                .orElseGet(() -> getConfigurationPropertyFromContext(servletContext, generateFullyQualifiedKey(klass, key))
                    .orElse(defaultValue)));
        return value;
    }

    /**
     * property name 'scheme' would become "org.eclipse.lyo.oslc4j.core.servlet.scheme"
     */
    private static String generateFullyQualifiedKey(Class klass, String key) {
        return klass.getPackage().getName() + '.' + key;
    }

    /**
     * web.xml property ending in '.scheme' would become "LYO_SCHEME"
     */
    private static String generateEnvironmentKey(String key) {
        return "LYO_" + key.toUpperCase(Locale.ROOT).replace('.', '_');
    }

    private static Optional<String> getConfigurationPropertyFromEnvironment(String basePathEnvKey) {
        final Map<String, String> env = System.getenv();
        if (!env.containsKey(basePathEnvKey)) {
            logger.debug("ENV variable '{}' not defined", basePathEnvKey);
            return Optional.empty();
        }
        logger.info("Found {} env variable", basePathEnvKey);
        return Optional.of(env.get(basePathEnvKey));
    }

    private static Optional<String> getConfigurationPropertyFromSystemProperties(String basePathContextPropertyKey) {
        String value = System.getProperty(basePathContextPropertyKey);
        if (value == null || value.trim().isEmpty()) {
            logger.debug("System (JVM) property '{}' not defined", basePathContextPropertyKey);
            return Optional.empty();
        }
        logger.info("Found {} System (JVM) property", basePathContextPropertyKey);
        return Optional.of(value);
    }

    private static Optional<String> getConfigurationPropertyFromContext(final ServletContext servletContext, String basePathContextPropertyKey) {
        String value = servletContext.getInitParameter(basePathContextPropertyKey);
        if (value == null || value.trim().isEmpty()) {
            logger.debug("Servlet Context parameter '{}' not defined", basePathContextPropertyKey);
            return Optional.empty();
        }
        logger.info("Found {} context parameter", basePathContextPropertyKey);
        return Optional.of(value);
    }

    private static String getServletUrlPattern(final ServletContextEvent servletContextEvent, String servletName) throws Exception {
        final ServletContext servletContext = servletContextEvent.getServletContext();

        ServletRegistration servletRegistration = servletContext.getServletRegistration(servletName);
        if (servletRegistration == null) {
            throw new NoSuchElementException("no servlet with name \"" + servletName + "\" is found.");
        }
        java.util.Collection<java.lang.String> mappings = servletRegistration.getMappings();
        if (mappings.size() != 1) {
            throw new NoSuchElementException("unable to identify servlet mappings for servlet with name \"" + servletName + "\".");
        }
        String mapping = (String) mappings.toArray()[0];

        //url patterns in  most cases end with '\*'. But a url-pattern with just '\' may be found for exact matches.
        if (mapping.endsWith("*"))
            mapping = mapping.substring(0, mapping.length()-1);
        return mapping;
    }
}

