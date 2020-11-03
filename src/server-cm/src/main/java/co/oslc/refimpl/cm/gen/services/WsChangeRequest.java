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

package co.oslc.refimpl.cm.gen.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import co.oslc.refimpl.cm.gen.CMManager;
import co.oslc.refimpl.cm.gen.CMConstants;
import org.eclipse.lyo.oslc.domains.cm.Oslc_cmDomainConstants;
import co.oslc.refimpl.cm.gen.servlet.ServiceProviderCatalogSingleton;
import org.eclipse.lyo.oslc.domains.cm.ChangeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@Path("change_request")
@Api(value = "Web Service for {" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "}")
public class WsChangeRequest
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    private static final Logger log = LoggerFactory.getLogger(WsChangeRequest.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public WsChangeRequest()
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

    @GET
    @Path("{id}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @ApiOperation(
        value = "GET for resources of type {'" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "'}",
        notes = "GET for resources of type {'" + "<a href=\"" + Oslc_cmDomainConstants.CHANGEREQUEST_TYPE + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_cmDomainConstants.CHANGEREQUEST_PATH + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public ChangeRequest getChangeRequest(
                @PathParam("id") final String id
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final ChangeRequest aChangeRequest = CMManager.getChangeRequest(httpServletRequest, id);

        if (aChangeRequest != null) {
            // Start of user code getChangeRequest
            // End of user code
            httpServletResponse.setHeader("ETag", CMManager.getETagFromChangeRequest(aChangeRequest));
            httpServletResponse.addHeader(CMConstants.HDR_OSLC_VERSION, CMConstants.OSLC_VERSION_V2);
            return aChangeRequest;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.TEXT_HTML })
    @ApiOperation(
        value = "GET for resources of type {'" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "'}",
        notes = "GET for resources of type {'" + "<a href=\"" + Oslc_cmDomainConstants.CHANGEREQUEST_TYPE + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_cmDomainConstants.CHANGEREQUEST_PATH + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public void getChangeRequestAsHtml(
        @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getChangeRequestAsHtml_init
        // End of user code

        final ChangeRequest aChangeRequest = CMManager.getChangeRequest(httpServletRequest, id);

        if (aChangeRequest != null) {
            httpServletRequest.setAttribute("aChangeRequest", aChangeRequest);
            // Start of user code getChangeRequestAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/cm/gen/changerequest.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    @ApiOperation(
        value = "GET for resources of type {'" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "'}",
        notes = "GET for resources of type {'" + "<a href=\"" + Oslc_cmDomainConstants.CHANGEREQUEST_TYPE + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_cmDomainConstants.CHANGEREQUEST_PATH + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public Compact getChangeRequestCompact(
        @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getChangeRequestCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final ChangeRequest aChangeRequest = CMManager.getChangeRequest(httpServletRequest, id);

        if (aChangeRequest != null) {
            final Compact compact = new Compact();

            compact.setAbout(aChangeRequest.getAbout());
            compact.setTitle(aChangeRequest.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aChangeRequest.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(UriBuilder.fromUri(aChangeRequest.getAbout()).path("largePreview").build());
            compact.setLargePreview(largePreview);

            httpServletResponse.addHeader(CMConstants.HDR_OSLC_VERSION, CMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getChangeRequestAsHtmlSmallPreview(
        @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getChangeRequestAsHtmlSmallPreview_init
        // End of user code

        final ChangeRequest aChangeRequest = CMManager.getChangeRequest(httpServletRequest, id);

        if (aChangeRequest != null) {
            httpServletRequest.setAttribute("aChangeRequest", aChangeRequest);
            // Start of user code getChangeRequestAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/cm/gen/changerequestsmallpreview.jsp");
            httpServletResponse.addHeader(CMConstants.HDR_OSLC_VERSION, CMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{id}/largePreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getChangeRequestAsHtmlLargePreview(
        @PathParam("id") final String id
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getChangeRequestAsHtmlLargePreview_init
        // End of user code

        final ChangeRequest aChangeRequest = CMManager.getChangeRequest(httpServletRequest, id);

        if (aChangeRequest != null) {
            httpServletRequest.setAttribute("aChangeRequest", aChangeRequest);
            // Start of user code getChangeRequestAsHtmlLargePreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/cm/gen/changerequestlargepreview.jsp");
            httpServletResponse.addHeader(CMConstants.HDR_OSLC_VERSION, CMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
    @DELETE
    @Path("{id}")
    @ApiOperation(
        value = "DELETE for resources of type {'" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "'}",
        notes = "DELETE for resources of type {'" + "<a href=\"" + Oslc_cmDomainConstants.CHANGEREQUEST_TYPE + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_cmDomainConstants.CHANGEREQUEST_PATH + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public Response deleteChangeRequest(
                @PathParam("id") final String id
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code deleteChangeRequest_init
        // End of user code
        final ChangeRequest aResource = CMManager.getChangeRequest(httpServletRequest, id);

        if (aResource != null) {
            // Start of user code deleteChangeRequest
            // End of user code
            boolean deleted = CMManager.deleteChangeRequest(httpServletRequest, id);
            if (deleted)
                return Response.ok().header(CMConstants.HDR_OSLC_VERSION, CMConstants.OSLC_VERSION_V2).build();
            else
                throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @PUT
    @Path("{id}")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @ApiOperation(
        value = "PUT for resources of type {'" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "'}",
        notes = "PUT for resources of type {'" + "<a href=\"" + Oslc_cmDomainConstants.CHANGEREQUEST_TYPE + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}" +
            ", with respective resource shapes {'" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_cmDomainConstants.CHANGEREQUEST_PATH + "\">" + Oslc_cmDomainConstants.CHANGEREQUEST_LOCALNAME + "</a>" + "'}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public Response updateChangeRequest(
            @HeaderParam("If-Match") final String eTagHeader,
            @PathParam("id") final String id ,
            final ChangeRequest aResource
        ) throws IOException, ServletException
    {
        // Start of user code updateChangeRequest_init
        // End of user code
        final ChangeRequest originalResource = CMManager.getChangeRequest(httpServletRequest, id);

        if (originalResource != null) {
            final String originalETag = CMManager.getETagFromChangeRequest(originalResource);

            if ((eTagHeader == null) || (originalETag.equals(eTagHeader))) {
                // Start of user code updateChangeRequest
                // End of user code
                final ChangeRequest updatedResource = CMManager.updateChangeRequest(httpServletRequest, aResource, id);
                httpServletResponse.setHeader("ETag", CMManager.getETagFromChangeRequest(updatedResource));
                return Response.ok().header(CMConstants.HDR_OSLC_VERSION, CMConstants.OSLC_VERSION_V2).build();
            }
            else {
                throw new WebApplicationException(Status.PRECONDITION_FAILED);
            }
        }
        else {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
    }

}
