<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/header.jsp" />
<br><br><center><h1>Food Item Management</h1></center><br>
${message}
<table class="table table-hover">
	<thead><tr><th>Item ID</th> <th>ITEM_NAME</th><th>Is Food</th></tr></thead>
	<tbody>
		<c:forEach items="${itemList}" var="item">
			<tr><td>${item.itemId}</td><td>${item.itemName}<img src="${pageContext.request.contextPath}/images/item/${item.description}.png" width="30"  height="30" alt="${item.description}"  /></td>
			<td><a href="updateFoodItem.spring?itemCode=${item.itemId}&isFood=${item.isFood}" >
			<c:if test="${item.isFood=='Y' }">
				<font color="red">Yes</font>
			</c:if>
			<c:if test="${item.isFood=='N' }">
				No
			</c:if>
			</a></td>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/jsp/footer.jsp" />
