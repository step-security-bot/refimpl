<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
<%--
 Copyright (c) 2011, 2012, 2017 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.

 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.

 Contributors:

  Sam Padgett     - initial API and implementation
  Michael Fiedler - adapted for OSLC4J
  Jad El-khoury   - initial implementation of code generator (422448)
  Frédéric Loiret - Switch the template to Bootstrap (519699)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="org.eclipse.lyo.oslc4j.core.model.Link" %>
<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="org.eclipse.lyo.oslc4j.core.model.OslcConstants"%>
<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcName"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.net.URI"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>

<%@page import="org.eclipse.lyo.oslc.domains.cm.ReviewTask"%>
<%@page import="org.eclipse.lyo.oslc.domains.cm.Oslc_cmDomainConstants"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  ReviewTask aReviewTask = (ReviewTask) request.getAttribute("aReviewTask");
%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title><%= aReviewTask.toString() %></title>

  <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

  <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
  <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
  <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
</head>

<body>

<!-- Begin page content -->
<div>
    <% Method method = null; %>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getShortTitle"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getShortTitle() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getShortTitle().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getDescription"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getDescription() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getDescription().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getTitle"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getTitle() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getTitle().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getIdentifier"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getIdentifier() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getIdentifier().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getSubject"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        Iterator<String> subjectItr = aReviewTask.getSubject().iterator();
        while(subjectItr.hasNext()) {
            out.write("<li>" + subjectItr.next().toString() + "</li>");
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getCreator"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getCreator()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/persontohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getContributor"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getContributor()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/persontohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getCreated"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getCreated() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getCreated().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getModified"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getModified() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getModified().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getServiceProvider"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getServiceProvider()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getInstanceShape"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getInstanceShape()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getDiscussedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aReviewTask.getDiscussedBy() == null) || (aReviewTask.getDiscussedBy().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/co/oslc/refimpl/cm/gen/discussiontohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aReviewTask.getDiscussedBy().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getCloseDate"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getCloseDate() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getCloseDate().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getStatus"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.getStatus() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.getStatus().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("isClosed"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.isClosed() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.isClosed().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("isInProgress"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.isInProgress() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.isInProgress().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("isFixed"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.isFixed() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.isFixed().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("isApproved"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.isApproved() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.isApproved().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("isReviewed"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.isReviewed() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.isReviewed().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("isVerified"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aReviewTask.isVerified() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aReviewTask.isVerified().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getRelatedChangeRequest"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getRelatedChangeRequest()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getAffectsPlanItem"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getAffectsPlanItem()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getAffectedByDefect"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getAffectedByDefect()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/defecttohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getTracksRequirement"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getTracksRequirement()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/requirementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getImplementsRequirement"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getImplementsRequirement()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/requirementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getAffectsRequirement"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getAffectsRequirement()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/requirementtohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getTracksChangeSet"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getTracksChangeSet()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/changesettohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getParent"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getParent()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/changerequesttohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getPriority"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getPriority()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/prioritytohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getState"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if ((aReviewTask.getState() == null) || (aReviewTask.getState().getValue() == null)) {
            out.write("<em>null</em>");
        }
        else {
            %>
            <jsp:include page="/co/oslc/refimpl/cm/gen/statetohtml.jsp">
                <jsp:param name="resourceUri" value="<%=aReviewTask.getState().getValue()%>"/> 
                </jsp:include>
            <%
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = ReviewTask.class.getMethod("getAuthorizer"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aReviewTask.getAuthorizer()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/cm/gen/agenttohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
</div>
<%
Map<QName, Object> extendedProperties = aReviewTask.getExtendedProperties();
if (!extendedProperties.isEmpty()) {
%>
    <div>
    <%
    for (Map.Entry<QName, Object> entry : extendedProperties.entrySet()) 
    {
        QName key = entry.getKey();
        Object value = entry.getValue();
    %>
    <dl class="row">
        <dt  class="col-sm-2 text-right"><a href="<%=key.getNamespaceURI() + key.getLocalPart() %>"><%=key.getLocalPart()%></a></dt>
        <dd class="col-sm-9"><%= value.toString()%></dd>
    </dl>
    <%
    }
    %>
    </div>
<%
}
%>
</body>
</html>
