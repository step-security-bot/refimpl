<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<%--
 Copyright (c) 2020 Contributors to the Eclipse Foundation
 
 See the NOTICE file(s) distributed with this work for additional
 information regarding copyright ownership.
 
 This program and the accompanying materials are made available under the
 terms of the Eclipse Distribution License 1.0 which is available at
 http://www.eclipse.org/org/documents/edl-v10.php.
 
 SPDX-License-Identifier: BSD-3-Simple

 This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
--%>

<%@page import="org.eclipse.lyo.oslc.domains.qm.TestCase"%>
<%@page import="java.net.URI"%>
<%
String asLocalResource = request.getParameter("asLocalResource");
TestCase aResource = null;
if (request.getParameter("resourceUri") != null) {
    aResource = new TestCase (new URI(request.getParameter("resourceUri")));
}
else {
    if (request.getAttribute("aTestCase") != null) {
        aResource = (TestCase) request.getAttribute("aTestCase");
    }
}

if (asLocalResource != null && asLocalResource.equalsIgnoreCase("true")) {
    out.write("{a Local TestCase Resource} - update TestCase.toString() to present resource as desired.");
}
else {
    if (aResource == null) {
        out.write("<em>null</em>");
    }
    else {    
        out.write("<a href=\"" + aResource.getAbout() + "\" class=\"oslc-resource-link\">" + aResource.getAbout() + "</a>");
    }
}
%>
