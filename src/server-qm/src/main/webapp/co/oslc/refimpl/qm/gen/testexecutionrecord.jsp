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
  Frédéric Loiret - Support for UI Preview (494303)
  Andrii Berezovskyi - Support for UI Preview (494303)

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

<%@page import="org.eclipse.lyo.oslc.domains.qm.TestExecutionRecord"%>
<%@page import="org.eclipse.lyo.oslc.domains.qm.Oslc_qmDomainConstants"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  TestExecutionRecord aTestExecutionRecord = (TestExecutionRecord) request.getAttribute("aTestExecutionRecord");
%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title><%= aTestExecutionRecord.toString() %></title>

  <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

  <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
  <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
  <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
  <script src="<c:url value="/static/js/ui-preview-helper.js"/>"></script>
  <script type="text/javascript">
    $(function () {setupUiPreviewOnPopover($("a.oslc-resource-link"));});
  </script>
</head>

<body>

<nav class="navbar sticky-top navbar-light bg-light">
  <div class="container">
  <a class="navbar-brand" href="<c:url value="/services/catalog/singleton"/>">QM</a>
  </div>
</nav>

<!-- Begin page content -->
<div class="container">
    <div class="page-header">
        <h1>TestExecutionRecord: <%= aTestExecutionRecord.toString() %></h1>
        <%
        URI shapeUri = UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(OslcConstants.PATH_RESOURCE_SHAPES).path(Oslc_qmDomainConstants.TESTEXECUTIONRECORD_PATH).build();
        Collection<URI> types = aTestExecutionRecord.getTypes();   
        %>
        <p class="lead">Resource URI:&nbsp;
        <jsp:include page="/co/oslc/refimpl/qm/gen/testexecutionrecordtohtml.jsp"></jsp:include>
        </p>
        <p class="lead">Shape:&nbsp;
        <a href="<%=shapeUri%>"><%=shapeUri%></a>
        </p>
        <p class="lead">rdf:type(s):</p>
        <ul>
        <%for (URI type : aTestExecutionRecord.getTypes()) {%>
        <li><a href="<%=type%>"><%=type%></a></li>
        <%}%>
        </ul>
    </div>
        <h2>Properties</h2>
        <div>
          <% Method method = null; %>
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getContributor"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <ul>
            <%
            for(Link next : aTestExecutionRecord.getContributor()) {
                if (next.getValue() == null) {
                    out.write("<li>" + "<em>null</em>" + "</li>");
                }
                else {
                    %>
                    <li>
                    <jsp:include page="/co/oslc/refimpl/qm/gen/persontohtml.jsp">
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
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getCreated"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if (aTestExecutionRecord.getCreated() == null) {
                out.write("<em>null</em>");
            }
            else {
                out.write(aTestExecutionRecord.getCreated().toString());
            }
            %>
            
            </dd>
          </dl>
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getCreator"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <ul>
            <%
            for(Link next : aTestExecutionRecord.getCreator()) {
                if (next.getValue() == null) {
                    out.write("<li>" + "<em>null</em>" + "</li>");
                }
                else {
                    %>
                    <li>
                    <jsp:include page="/co/oslc/refimpl/qm/gen/persontohtml.jsp">
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
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getIdentifier"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if (aTestExecutionRecord.getIdentifier() == null) {
                out.write("<em>null</em>");
            }
            else {
                out.write(aTestExecutionRecord.getIdentifier().toString());
            }
            %>
            
            </dd>
          </dl>
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getModified"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if (aTestExecutionRecord.getModified() == null) {
                out.write("<em>null</em>");
            }
            else {
                out.write(aTestExecutionRecord.getModified().toString());
            }
            %>
            
            </dd>
          </dl>
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getType"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <ul>
            <%
            for(Link next : aTestExecutionRecord.getType()) {
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
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getInstanceShape"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <ul>
            <%
            for(Link next : aTestExecutionRecord.getInstanceShape()) {
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
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getServiceProvider"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <ul>
            <%
            for(Link next : aTestExecutionRecord.getServiceProvider()) {
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
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getTitle"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if (aTestExecutionRecord.getTitle() == null) {
                out.write("<em>null</em>");
            }
            else {
                out.write(aTestExecutionRecord.getTitle().toString());
            }
            %>
            
            </dd>
          </dl>
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getBlockedByChangeRequest"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <ul>
            <%
            for(Link next : aTestExecutionRecord.getBlockedByChangeRequest()) {
                if (next.getValue() == null) {
                    out.write("<li>" + "<em>null</em>" + "</li>");
                }
                else {
                    %>
                    <li>
                    <jsp:include page="/co/oslc/refimpl/qm/gen/changerequesttohtml.jsp">
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
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getRelatedChangeRequest"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <ul>
            <%
            for(Link next : aTestExecutionRecord.getRelatedChangeRequest()) {
                if (next.getValue() == null) {
                    out.write("<li>" + "<em>null</em>" + "</li>");
                }
                else {
                    %>
                    <li>
                    <jsp:include page="/co/oslc/refimpl/qm/gen/changerequesttohtml.jsp">
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
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getReportsOnTestPlan"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if ((aTestExecutionRecord.getReportsOnTestPlan() == null) || (aTestExecutionRecord.getReportsOnTestPlan().getValue() == null)) {
                out.write("<em>null</em>");
            }
            else {
                %>
                <jsp:include page="/co/oslc/refimpl/qm/gen/testplantohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=aTestExecutionRecord.getReportsOnTestPlan().getValue()%>"/> 
                    </jsp:include>
                <%
            }
            %>
            
            </dd>
          </dl>
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getRunsOnTestEnvironment"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if ((aTestExecutionRecord.getRunsOnTestEnvironment() == null) || (aTestExecutionRecord.getRunsOnTestEnvironment().getValue() == null)) {
                out.write("<em>null</em>");
            }
            else {
                out.write("<a href=\"" + aTestExecutionRecord.getRunsOnTestEnvironment().getValue().toString() + "\" class=\"oslc-resource-link\">" + aTestExecutionRecord.getRunsOnTestEnvironment().getValue().toString() + "</a>");
            }
            %>
            
            </dd>
          </dl>
          <dl class="row">
            <% method = TestExecutionRecord.class.getMethod("getRunsTestCase"); %>
            <dt  class="col-sm-2 text-right"><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
            <dd class="col-sm-9">
            <%
            if ((aTestExecutionRecord.getRunsTestCase() == null) || (aTestExecutionRecord.getRunsTestCase().getValue() == null)) {
                out.write("<em>null</em>");
            }
            else {
                %>
                <jsp:include page="/co/oslc/refimpl/qm/gen/testcasetohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=aTestExecutionRecord.getRunsTestCase().getValue()%>"/> 
                    </jsp:include>
                <%
            }
            %>
            
            </dd>
          </dl>
        </div>
        <%
        Map<QName, Object> extendedProperties = aTestExecutionRecord.getExtendedProperties();
        if (!extendedProperties.isEmpty()) {
        %>
            <h3>Extended Properties</h3>
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
</div>
  <footer class="footer">
    <div class="container">
      <p class="text-muted">
        OSLC Adaptor was generated using <a href="http://eclipse.org/lyo">Eclipse Lyo</a>.
      </p>
    </div>
  </footer>
</body>
</html>
