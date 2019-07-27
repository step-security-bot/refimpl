// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2017 Jad El-khoury.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Jad El-khoury        - initial implementation of ResourceShape HTML presentation
 *     
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.rm.gen.services;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.ResourceShape;
import org.eclipse.lyo.oslc4j.core.model.ResourceShapeFactory;

import co.oslc.refimpl.rm.gen.servlet.Application;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

@Path(OslcConstants.PATH_RESOURCE_SHAPES)
public class ResourceShapeService
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;
    @Context private javax.ws.rs.core.Application jaxrsApplication; 

    private static final Logger log = LoggerFactory.getLogger(ResourceShapeService.class.getName());

    public ResourceShapeService() throws OslcCoreApplicationException, URISyntaxException {
        super();
    }

    @GET
    @Path("{resourceShapePath}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.TEXT_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public ResourceShape getResourceShape(@Context                        final HttpServletRequest httpServletRequest,
                                          @PathParam("resourceShapePath") final String             resourceShapePath)
           throws OslcCoreApplicationException,
                  URISyntaxException
    {
        final Class<?> resourceClass = Application.getResourceShapePathToResourceClassMap().get(resourceShapePath);
        if (resourceClass != null) {
            final String servletUri = OSLC4JUtils.resolveServletUri(httpServletRequest);
            return ResourceShapeFactory.createResourceShape(servletUri, OslcConstants.PATH_RESOURCE_SHAPES,
                    resourceShapePath, resourceClass);
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    @GET
    @Path("{resourceShapePath}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getResourceShapeAsHtml(
            @PathParam("resourceShapePath") final String resourceShapePath
        ) throws ServletException, IOException, URISyntaxException, OslcCoreApplicationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
        final Class<?> resourceClass = Application.getResourceShapePathToResourceClassMap().get(resourceShapePath);
        ResourceShape aResourceShape = null;
        
        if (resourceClass != null)
        {
            aResourceShape = (ResourceShape) resourceClass.getMethod("createResourceShape").invoke(null);
            httpServletRequest.setAttribute("aResourceShape", aResourceShape);
            
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/resourceshape.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }
}
