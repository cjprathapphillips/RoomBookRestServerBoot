<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/header.jsp" />
<br><br><center><h1>View Provision for ${date}</h1>
<a href="viewProvisionDate"><button type="button" class="btn btn-primary" name="back" value="back">Back</button></a>
</center><br>
<script type="text/javascript">
</script>


<form class="form-horizontal" method="post" action="viewProvision">

<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary" name="pdf" value="pdf">PDF</button>
        <button type="submit" class="btn btn-primary" name="xlsx" value="xlsx">XLSX</button>
        <button type="submit" class="btn btn-primary" name="jpg" value="jpg">JPG</button>
        Export with rate <input type="checkbox" name="noRate" value="noRate">
    </div>
</div>
<input type="hidden" value="${date}" name="date">

<table class="table table-hover">
	<thead><tr><th>SNo</th><th>Provision ID</th><th>Item ID</th> <th>FOOD ITEM NAME</th><th>Edit</th><th>Amount</th><th>Quantity</th><th>UNIT</th> </tr></thead>
	<tbody>
		<c:forEach items="${viewProvisionForDateListFood}" var="viewProvisionForDate" varStatus="provisionIndex">
			<tr>
			<td>${provisionIndex.count}</td>
			<td>${viewProvisionForDate.provisionId}</td>
			<td>${viewProvisionForDate.itemId}</td>
			<td>${viewProvisionForDate.itemName} <img src="${pageContext.request.contextPath}/images/item/${viewProvisionForDate.description}.png" width="30"  height="30" alt="${viewProvisionForDate.description}"  /></td>
			<td><a href="editProvisionView.spring?provisionId=${viewProvisionForDate.provisionId}" ><img src="${pageContext.request.contextPath}/images/edit.png" width="20"  height="20"/></a></td>
			<td>${viewProvisionForDate.rate}</td>
			<td>${viewProvisionForDate.avgQty}</td>
			<td>${viewProvisionForDate.unit}</td>
		</c:forEach>
	</tbody>
</table>


<table class="table table-hover">
<thead><tr><th>SNo</th><th>Provision ID</th><th>Item ID</th> <th>TOILET ITEM NAME</th><th>Edit</th><th>RATE</th><th>Quantity</th><th>UNIT</th> </tr></thead>
	<tbody>
		<c:forEach items="${viewProvisionForDateListToilet}" var="viewProvisionForDate" varStatus="provisionIndex">
			<tr>
			<td>${provisionIndex.count}</td>
			<td>${viewProvisionForDate.provisionId}</td>
			<td>${viewProvisionForDate.itemId}</td>
			<td>${viewProvisionForDate.itemName}</td>
			<td><a href="editProvisionView.spring?provisionId=${viewProvisionForDate.provisionId}" ><img src="${pageContext.request.contextPath}/images/edit.png" width="20"  height="20"/></a></td>
			<td>${viewProvisionForDate.rate}</td>
			<td>${viewProvisionForDate.avgQty}</td>
			<td>${viewProvisionForDate.unit}</td>
		</c:forEach>
	</tbody>
</table>

</form>	
<jsp:include page="/jsp/footer.jsp" />
