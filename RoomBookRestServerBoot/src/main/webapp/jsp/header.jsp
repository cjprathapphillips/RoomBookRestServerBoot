<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Provision Management System</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/provisions.png"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/provision.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/provision.js"></script>
<style type="text/css">

</style>

</head>
<body>

 

<div class="container">
  <nav class="navbar navbar-custom navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Provision Management System</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown mega-dropdown">
          <a href="itemManagement" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Item Management </a>
        </li>
        <li class="dropdown mega-dropdown">
          <a href="regularItem" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Regular Item </a>
        </li>
        <li class="dropdown mega-dropdown">
          <a href="foodItem" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Food Item</a>
        </li>
        <li class="dropdown mega-dropdown">
          <a href="vegitable" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Vegitable</a>
        </li>
        <li class="dropdown mega-dropdown">
          <a href="createProvision" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Create Provision List</a>
        </li>
        <li class="dropdown mega-dropdown">
          <a href="viewProvisionDate" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">See Provision</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</div>


