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
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Jim Amsden          - Support for UI Preview (494303)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.rm.gen.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import co.oslc.refimpl.rm.gen.RMManager;
import co.oslc.refimpl.rm.gen.RMConstants;
import org.eclipse.lyo.oslc.domains.rm.Oslc_rmDomainConstants;
import org.eclipse.lyo.oslc.domains.rm.Oslc_rmDomainConstants;
import co.oslc.refimpl.rm.gen.servlet.ServiceProviderCatalogSingleton;
import org.eclipse.lyo.oslc.domains.Person;
import org.eclipse.lyo.oslc.domains.rm.RequirementCollection;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_SHAPES_DOMAIN)
@Path("serviceProviders/{serviceProviderId}/service2/requirementCollections")
public class Requirement_collectionsService
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public Requirement_collectionsService()
    {
        super();
    }

    private void addCORSHeaders (final HttpServletResponse httpServletResponse) {
        //UI preview can be blocked by CORS policy.
        //add select CORS headers to every response that is embedded in an iframe.
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }

    @OslcQueryCapability
    (
        title = "RequirementCollectionQC",
        label = "Requirement Collections Query Capability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENTCOLLECTION_PATH,
        resourceTypes = {Oslc_rmDomainConstants.REQUIREMENTCOLLECTION_TYPE},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public RequirementCollection[] queryRequirementCollections(
                                                    @PathParam("serviceProviderId") final String serviceProviderId ,
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("page") final String pageString,
                                                    @QueryParam("limit") final String limitString) throws IOException, ServletException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryRequirementCollections
        // Here additional logic can be implemented that complements main action taken in RMManager
        // End of user code

        final List<RequirementCollection> resources = RMManager.queryRequirementCollections(httpServletRequest, serviceProviderId, where, page, limit);
        return resources.toArray(new RequirementCollection [resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    public Response queryRequirementCollectionsAsHtml(
                                    @PathParam("serviceProviderId") final String serviceProviderId ,
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("page") final String pageString,
                                    @QueryParam("limit") final String limitString) throws ServletException, IOException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryRequirementCollectionsAsHtml
        // End of user code

        final List<RequirementCollection> resources = RMManager.queryRequirementCollections(httpServletRequest, serviceProviderId, where, page, limit);

        if (resources!= null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code queryRequirementCollectionsAsHtml_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri",
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > limit) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute("nextPageUri",
                        uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementcollectionscollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcDialog
    (
         title = "RequirementCollectionSD",
         label = "Requirement Collections Selection Dialog",
         uri = "serviceProviders/{serviceProviderId}/service2/requirementCollections/selector",
         hintWidth = "0px",
         hintHeight = "0px",
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENTCOLLECTION_TYPE},
         usages = {}
    )
    @GET
    @Path("selector")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public void RequirementCollectionSelector(
        @QueryParam("terms") final String terms
        , @PathParam("serviceProviderId") final String serviceProviderId
        ) throws ServletException, IOException
    {
        try {
            // Start of user code RequirementCollectionSelector_init
            // End of user code

            httpServletRequest.setAttribute("selectionUri",UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());
            // Start of user code RequirementCollectionSelector_setAttributes
            // End of user code

            if (terms != null ) {
                httpServletRequest.setAttribute("terms", terms);
                final List<RequirementCollection> resources = RMManager.RequirementCollectionSelector(httpServletRequest, serviceProviderId, terms);
                if (resources!= null) {
                            httpServletRequest.setAttribute("resources", resources);
                            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementcollectionselectorresults.jsp");
                            rd.forward(httpServletRequest, httpServletResponse);
                }
                //a empty search should return an empty list and not NULL!
                throw new WebApplicationException(Status.NOT_FOUND);

            } else {
                try {
                    RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementcollectionselector.jsp");
                    rd.forward(httpServletRequest, httpServletResponse);
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }

    /**
     * Create a single RequirementCollection via RDF/XML, XML or JSON POST
     *
     * @throws IOException
     * @throws ServletException
     */
    @OslcCreationFactory
    (
         title = "RequirementCollectionCF",
         label = "Requirement Collections Creation Factory",
         resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENTCOLLECTION_PATH},
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENTCOLLECTION_TYPE},
         usages = {}
    )
    @POST
    @Path("create")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Response createRequirementCollection(
            @PathParam("serviceProviderId") final String serviceProviderId ,
            final RequirementCollection aResource
        ) throws IOException, ServletException
    {
        try {
            RequirementCollection newResource = RMManager.createRequirementCollection(httpServletRequest, aResource, serviceProviderId);
            httpServletResponse.setHeader("ETag", RMManager.getETagFromRequirementCollection(newResource));
            return Response.created(newResource.getAbout()).entity(newResource).header(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }

    @GET
    @Path("{requirementCollectionId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public RequirementCollection getRequirementCollection(
                @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementCollectionId") final String requirementCollectionId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final RequirementCollection aRequirementCollection = RMManager.getRequirementCollection(httpServletRequest, serviceProviderId, requirementCollectionId);

        if (aRequirementCollection != null) {
            // Start of user code getRequirementCollection
            // End of user code
            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            return aRequirementCollection;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementCollectionId}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getRequirementCollectionAsHtml(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementCollectionId") final String requirementCollectionId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementCollectionAsHtml_init
        // End of user code

        final RequirementCollection aRequirementCollection = RMManager.getRequirementCollection(httpServletRequest, serviceProviderId, requirementCollectionId);

        if (aRequirementCollection != null) {
            httpServletRequest.setAttribute("aRequirementCollection", aRequirementCollection);
            // Start of user code getRequirementCollectionAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementcollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementCollectionId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    public Compact getRequirementCollectionCompact(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementCollectionId") final String requirementCollectionId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getRequirementCollectionCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final RequirementCollection aRequirementCollection = RMManager.getRequirementCollection(httpServletRequest, serviceProviderId, requirementCollectionId);

        if (aRequirementCollection != null) {
            final Compact compact = new Compact();

            compact.setAbout(aRequirementCollection.getAbout());
            compact.setTitle(aRequirementCollection.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aRequirementCollection.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(UriBuilder.fromUri(aRequirementCollection.getAbout()).path("largePreview").build());
            compact.setLargePreview(largePreview);

            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementCollectionId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getRequirementCollectionAsHtmlSmallPreview(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementCollectionId") final String requirementCollectionId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementCollectionAsHtmlSmallPreview_init
        // End of user code

        final RequirementCollection aRequirementCollection = RMManager.getRequirementCollection(httpServletRequest, serviceProviderId, requirementCollectionId);

        if (aRequirementCollection != null) {
            httpServletRequest.setAttribute("aRequirementCollection", aRequirementCollection);
            // Start of user code getRequirementCollectionAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementcollectionsmallpreview.jsp");
            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementCollectionId}/largePreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getRequirementCollectionAsHtmlLargePreview(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementCollectionId") final String requirementCollectionId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementCollectionAsHtmlLargePreview_init
        // End of user code

        final RequirementCollection aRequirementCollection = RMManager.getRequirementCollection(httpServletRequest, serviceProviderId, requirementCollectionId);

        if (aRequirementCollection != null) {
            httpServletRequest.setAttribute("aRequirementCollection", aRequirementCollection);
            // Start of user code getRequirementCollectionAsHtmlLargePreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementcollectionlargepreview.jsp");
            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
}