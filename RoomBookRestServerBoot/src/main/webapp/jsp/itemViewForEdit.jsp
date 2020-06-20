<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/jsp/header.jsp" />
<br><br><center><h1>Edit Item</h1></center><br>


<form class="form-horizontal" method="post" action="updateItem">

	<div class="form-group">
		<label for="id" class="control-label col-xs-2">Item Id</label>
	    <div class="col-xs-10"><p class="form-control-static">${item.itemId}<input type="hidden" name="itemId" value="${item.itemId}"> </p></div> 
	</div>

	<div class="form-group">
		<label for="itemName" class="control-label col-xs-2">Name</label> 
		<div class="col-xs-10"><p class="form-control-static">${item.itemName}</p></div> 
	</div>

	<div class="form-group">
        <label for="rate" class="control-label col-xs-2">Amount</label>
        <div class="col-xs-10"><input type="text" class="form-control" id="rate" name="rate" placeholder="Rate" value="${item.rate}"></div>
        
    </div>
	
	<div class="form-group">
        <label for="unit" class="control-label col-xs-2">Unit</label>
        <div class="col-xs-10">
        <select id="unit" name="unit">
        	<option value="">Select</option>
        	<c:forEach items="${unitList}" var="unit">
        		<c:if test="${item.unit==unit}">
        			<option value="${unit}" selected="selected">${unit}</option>
        		</c:if>
        		<c:if test="${item.unit!=unit}">
        			<option value="${unit}">${unit}</option>
        		</c:if>
        	</c:forEach>
        </select></div>
    </div>

	<div class="form-group">
        <label for="isRegular" class="control-label col-xs-2">Is Regular</label>
        <div class="col-xs-10">
        	<select id="isRegular" name="isRegular">
        		<option value="">Select</option>
        		<c:if test="${item.isRegular=='Yes'}">
        			<option value="Y" selected="selected">Yes</option>
        			<option value="N">No</option>
        		</c:if>
        		<c:if test="${item.isRegular=='No'}">
        			<option value="Y">Yes</option>
        			<option value="N" selected="selected">No</option>
        		</c:if>
        	</select></div>
    </div>

	<div class="form-group">
        <label for="avgQty" class="control-label col-xs-2">Avg Qty</label>
        <div class="col-xs-10"><input type="text" class="form-control" id="avgQty" name="avgQty" placeholder="Avg Qty" value="${item.avgQty}"></div>
    </div>

	<div class="form-group">
        <label for="isFood" class="control-label col-xs-2">Is Food</label>
        <div class="col-xs-10">
        <select id="isFood" name="isFood">
        	<option value="">Select</option>
        	<c:if test="${item.isFood=='Yes'}">
        		<option value="Y" selected="selected">Yes</option>
        		<option value="N">No</option>
        	</c:if>
        	<c:if test="${item.isFood=='No'}">
        		<option value="Y">Yes</option>
        		<option value="N" selected="selected">No</option>
        	</c:if>
        </select></div>
    </div>
    <div class="form-group">
        <label for="isVeg" class="control-label col-xs-2">Is Vegitable</label>
        <div class="col-xs-10">
        <select id="isVeg" name="isVeg">
        	<option value="">Select</option>
        			<c:if test="${item.isVeg=='Yes'}">
        		<option value="Y" selected="selected">Yes</option>
        		<option value="N">No</option>
        	</c:if>
        	<c:if test="${item.isVeg=='No'}">
        		<option value="Y">Yes</option>
        		<option value="N" selected="selected">No</option>
        	</c:if>
        </select></div>
    </div>


    <div class="form-group">
        <div class="col-xs-offset-2 col-xs-10">
            <button type="submit" class="btn btn-primary" name="save" value="save">Save</button>
            <button type="submit" class="btn btn-primary" name="cancel" value="cancel">Cancel</button>
        </div>
    </div>

	
	

</form>



<jsp:include page="/jsp/footer.jsp" />
