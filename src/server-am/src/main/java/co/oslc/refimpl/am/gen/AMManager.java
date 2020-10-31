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
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.am.gen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContextEvent;
import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import co.oslc.refimpl.am.gen.servlet.ServiceProviderCatalogSingleton;
import co.oslc.refimpl.am.gen.ServiceProviderInfo;
import org.eclipse.lyo.oslc.domains.am.LinkType;
import org.eclipse.lyo.oslc.domains.Person;
import org.eclipse.lyo.oslc.domains.am.Resource;



// Start of user code imports
import java.net.URI;
import java.util.Date;
import java.util.UUID;

import co.oslc.refimpl.lib.MemResourceRepository;
import co.oslc.refimpl.lib.ResourceRepository;
// End of user code

// Start of user code pre_class_code
// End of user code

public class AMManager {

    private static final Logger log = LoggerFactory.getLogger(AMManager.class);

    
    // Start of user code class_attributes
    public static final String SP_DEFAULT = "SP";

    private static final ResourceRepository<Resource> resourceRepository = new MemResourceRepository<>();
    private static final ResourceRepository<LinkType> linkRepository = new MemResourceRepository<>();
    // End of user code
    
    
    // Start of user code class_methods
    // End of user code

    public static void contextInitializeServletListener(final ServletContextEvent servletContextEvent)
    {
        
        // Start of user code contextInitializeServletListener
        // TODO Implement code to establish connection to data backbone etc ...
        // End of user code
        
    }

    public static void contextDestroyServletListener(ServletContextEvent servletContextEvent) 
    {
        
        // Start of user code contextDestroyed
        // TODO Implement code to shutdown connections to data backbone etc...
        // End of user code
    }

    public static ServiceProviderInfo[] getServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
        ServiceProviderInfo[] serviceProviderInfos = {};
        
        // Start of user code "ServiceProviderInfo[] getServiceProviderInfos(...)"
        ServiceProviderInfo spInfo = new ServiceProviderInfo();
        spInfo.serviceProviderId = "SP";
        spInfo.name = "Default ServiceProvider";
        serviceProviderInfos = new ServiceProviderInfo[] {spInfo};
        // End of user code
        return serviceProviderInfos;
    }

    public static List<Resource> queryResources(HttpServletRequest httpServletRequest, String where, String prefix, int page, int limit)
    {
        List<Resource> resources = null;
        
        
        // Start of user code queryResources
        // TODO Implement code to return a set of resources
        // End of user code
        return resources;
    }
    public static List<Resource> ResourceSelector(HttpServletRequest httpServletRequest, String terms)   
    {
        List<Resource> resources = null;
        
        
        // Start of user code ResourceSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // End of user code
        return resources;
    }
    public static Resource createResource(HttpServletRequest httpServletRequest, final Resource aResource)
    {
        Resource newResource = null;
        
        
        // Start of user code createResource
        String id = aResource.getIdentifier();
        if(id == null) {
            id = UUID.randomUUID().toString();
            aResource.setIdentifier(id);
        }
        URI uri = AMResourcesFactory.constructURIForResource(id);
        aResource.setAbout(uri);
        aResource.setCreated(new Date());
        resourceRepository.addResource(SP_DEFAULT, id, aResource);
        newResource = aResource;
        // End of user code
        return newResource;
    }



    public static List<LinkType> queryLinkTypes(HttpServletRequest httpServletRequest, String where, String prefix, int page, int limit)
    {
        List<LinkType> resources = null;
        
        
        // Start of user code queryLinkTypes
        // TODO Implement code to return a set of resources
        // End of user code
        return resources;
    }
    public static List<LinkType> LinkTypeSelector(HttpServletRequest httpServletRequest, String terms)   
    {
        List<LinkType> resources = null;
        
        
        // Start of user code LinkTypeSelector
        // TODO Implement code to return a set of resources, based on search criteria 
        // End of user code
        return resources;
    }
    public static LinkType createLinkType(HttpServletRequest httpServletRequest, final LinkType aResource)
    {
        LinkType newResource = null;
        
        
        // Start of user code createLinkType
        String id = aResource.getIdentifier();
        if(id == null) {
            id = UUID.randomUUID().toString();
            aResource.setIdentifier(id);
        }
        URI uri = AMResourcesFactory.constructURIForLinkType(id);
        aResource.setAbout(uri);
        aResource.setCreated(new Date());
        linkRepository.addResource(SP_DEFAULT, id, aResource);
        newResource = aResource;
        // End of user code
        return newResource;
    }




    public static Resource getResource(HttpServletRequest httpServletRequest, final String id)
    {
        Resource aResource = null;
        
        
        // Start of user code getResource
        if(resourceRepository.hasResource(SP_DEFAULT, id)) {
            aResource = resourceRepository.getResource(SP_DEFAULT, id);
        }
        // End of user code
        return aResource;
    }

    public static Boolean deleteResource(HttpServletRequest httpServletRequest, final String id)
    {
        Boolean deleted = false;
        
        // Start of user code deleteResource
        // TODO Implement code to delete a resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return deleted;
    }

    public static Resource updateResource(HttpServletRequest httpServletRequest, final Resource aResource, final String id) {
        Resource updatedResource = null;
        
        // Start of user code updateResource
        // TODO Implement code to update and return a resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return updatedResource;
    }
    public static LinkType getLinkType(HttpServletRequest httpServletRequest, final String id)
    {
        LinkType aResource = null;
        
        
        // Start of user code getLinkType
        if(linkRepository.hasResource(SP_DEFAULT, id)) {
            aResource = linkRepository.getResource(SP_DEFAULT, id);
        }        // End of user code
        return aResource;
    }

    public static Boolean deleteLinkType(HttpServletRequest httpServletRequest, final String id)
    {
        Boolean deleted = false;
        
        // Start of user code deleteLinkType
        // TODO Implement code to delete a resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return deleted;
    }

    public static LinkType updateLinkType(HttpServletRequest httpServletRequest, final LinkType aResource, final String id) {
        LinkType updatedResource = null;
        
        // Start of user code updateLinkType
        // TODO Implement code to update and return a resource
        // If you encounter problems, consider throwing the runtime exception WebApplicationException(message, cause, final httpStatus)
        // End of user code
        return updatedResource;
    }

    public static String getETagFromLinkType(final LinkType aResource)
    {
        String eTag = null;
        // Start of user code getETagFromLinkType
        // TODO Implement code to return an ETag for a particular resource
        // End of user code
        return eTag;
    }
    public static String getETagFromResource(final Resource aResource)
    {
        String eTag = null;
        // Start of user code getETagFromResource
        // TODO Implement code to return an ETag for a particular resource
        // End of user code
        return eTag;
    }

}
