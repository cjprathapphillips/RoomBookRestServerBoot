<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/jsp/header.jsp" />
<script type="text/javascript">



</script>
<br><br><center><h2>Item Management</h2></center><br>
<center><a href="addItemView.spring" ><img src="${pageContext.request.contextPath}/images/add.png" width="20"  height="20" /></a></center>
${message}

<table class="table table-hover">
	<thead><tr><th>Item ID</th> <th>ITEM_NAME</th><th>EDIT</th><th>DELETE</th> <th>AMOUNT</th>
	<th>UNIT</th> <th>Regular</th> <th>AVG QTY</th> <th>FOOD</th><th>VEGITABLE</th>
	<th>RATE</th>
	</tr></thead>
	<tbody>
		<c:forEach items="${itemList}" var="item">
			<tr><td>${item.itemId}</td><td>${item.itemName}<img src="${pageContext.request.contextPath}/images/item/${item.description}.png" width="30"  height="30" alt="${item.description}"  /></td>
			<td><a href="editItemView.spring?itemCode=${item.itemId}" ><img src="${pageContext.request.contextPath}/images/edit.png" width="20"  height="20"/></a></td>
			<td><a href="deleteItem.spring?itemCode=${item.itemId}" ><img src="${pageContext.request.contextPath}/images/delete.png" width="20"  height="20" /></a></td>
			<td>${item.rate}</td>
			<td>${item.unit}</td><td>${item.isRegular}</td><td>${item.avgQty}</td><td>${item.isFood}</td>
			<td>${item.isVeg}</td>
			<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.rate/item.avgQty}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/jsp/footer.jsp" />
