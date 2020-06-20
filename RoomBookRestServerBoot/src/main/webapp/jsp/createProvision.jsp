<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/header.jsp" />
<br><br><center><h1>Create Provision</h1></center><br>
<script type="text/javascript">
function toggleAll(){
	var inputall=document.getElementsByTagName('input');
	for(var i=1;i<inputall.length;i++){
		if(inputall[i].type=="checkbox"){
			if(inputall[0].checked==true && inputall[i].checked==false){
				inputall[i].checked=true;
			}
			if(inputall[0].checked==false && inputall[i].checked==true){
				inputall[i].checked=false;
			}
		}
		
	}
}
</script>



<form class="form-horizontal" method="post" action="createProvision">

<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary" name="save" value="save">Save</button>
        <button type="submit" class="btn btn-primary" name="cancel" value="cancel">Cancel</button>
    </div>
</div>


<table class="table table-hover" >
	<thead><tr><th>SNo</th><th>ID</th> <th>FOOD ITEM NAME</th><th>ORDER<input type="checkbox" name="orderAll" onclick="toggleAll()"></th><th>RATE</th>
	<th>UNIT</th> <th>Regular</th> <th>AVG QTY</th> <!-- <th>FOOD</th> --></tr></thead>
	<tbody>
	   <!-- Food List -->
		<c:forEach items="${fooditemList}" var="item" varStatus="provisionIndex">
			<tr>
			<td>${provisionIndex.count}</td>
			<td>${item.itemId}  <input type="hidden" name="id" class="form-control" value="${item.itemId}">  </td>
			<td>${item.itemName}<img src="${pageContext.request.contextPath}/images/item/${item.itemName}.png" width="20"  height="20"/></td>
			<c:if test="${item.isRegular=='Yes'}">
				<td><input type="checkbox" name="order" class="form-control" value="${item.itemId}" checked="checked" > </td>
			</c:if>
			<c:if test="${item.isRegular=='No'}">
				<td><input type="checkbox" name="order" class="form-control" value="${item.itemId}"> </td>
			</c:if>
			
			
			<td><input type="number" class="form-control" id="rate" readonly="readonly" class="form-control" name="rate" placeholder="Rate" value="${item.rate}"></td>
			<td>
			<select id="unit" name="unit" class="form-control">
	        	<option value="">Select</option>
	        	<c:forEach items="${unitList}" var="unit">
	        		<c:if test="${item.unit==unit}">
	        			<option value="${unit}" selected="selected">${unit}</option>
	        		</c:if>
	        		<c:if test="${item.unit!=unit}">
	        			<option value="${unit}">${unit}</option>
	        		</c:if>
	        	</c:forEach>
        	</select>
			
			</td>
			<td>${item.isRegular}</td>
			<td><input type="number" class="form-control" id="avgQty" name="avgQty" placeholder="Avg Qty" value="${item.avgQty}"></td>
			<%-- <td>${item.isFood}</td> --%></tr>
		</c:forEach>
	</tbody>
</table>

<table class="table table-hover">

<!-- Toiletary List -->
		<thead><tr><th>SNo</th><th>Item ID</th> <th>TOILETARY ITEM NAME</th><th>ORDER</th><th>RATE</th>
			<th>UNIT</th> <th>Regular</th> <th>AVG QTY</th> <!-- <th>FOOD</th> --></tr></thead>
		<tbody>
		<c:forEach items="${toiletitemList}" var="item" varStatus="provisionIndex">
			<tr>
			<td>${provisionIndex.count}</td>
			<td>${item.itemId}  <input type="hidden" name="id" class="form-control" value="${item.itemId}">  </td>
			<td>${item.itemName}<img src="${pageContext.request.contextPath}/images/item/${item.itemName}.png" width="20"  height="20"/></td>
			<c:if test="${item.isRegular=='Yes'}">
				<td><input type="checkbox" name="order" class="form-control" value="${item.itemId}" checked="checked" > </td>
			</c:if>
			<c:if test="${item.isRegular=='No'}">
				<td><input type="checkbox" name="order" class="form-control" value="${item.itemId}"> </td>
			</c:if>
			
			
			<td><input type="number" class="form-control" id="rate" readonly="readonly" class="form-control" name="rate" placeholder="Rate" value="${item.rate}"></td>
			<td>
			<select id="unit" name="unit" class="form-control">
	        	<option value="">Select</option>
	        	<c:forEach items="${unitList}" var="unit">
	        		<c:if test="${item.unit==unit}">
	        			<option value="${unit}" selected="selected">${unit}</option>
	        		</c:if>
	        		<c:if test="${item.unit!=unit}">
	        			<option value="${unit}">${unit}</option>
	        		</c:if>
	        	</c:forEach>
        	</select>
			
			</td>
			<td>${item.isRegular}</td>
			<td><input type="number" class="form-control" id="avgQty" name="avgQty" placeholder="Avg Qty" value="${item.avgQty}"></td>
			<%-- <td>${item.isFood}</td> --%></tr>
		</c:forEach>

</table>



<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary" name="save" value="save">Save</button>
        <button type="submit" class="btn btn-primary" name="cancel" value="cancel">Cancel</button>
    </div>
</div>


</form>

<jsp:include page="/jsp/footer.jsp" />
