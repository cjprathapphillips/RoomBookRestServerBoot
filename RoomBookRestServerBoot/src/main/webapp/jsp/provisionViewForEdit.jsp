<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/header.jsp" />
<br><br><center><h1>Edit Provision Item for ${provisionItem.createdDate}</h1></center><br>


<form class="form-horizontal" method="post" action="updateProvision">

	<div class="form-group">
		<label for="id" class="control-label col-xs-2">Provision Id</label>
	    <div class="col-xs-10"><p class="form-control-static">${provisionItem.provisionId}<input type="hidden" name="provisionId" value="${provisionItem.provisionId}"></p></div> 
	</div>
	<div class="form-group">
		<label for="id" class="control-label col-xs-2">Item Id</label>
	    <div class="col-xs-10"><p class="form-control-static">${provisionItem.itemId}<input type="hidden" name="id" value="${provisionItem.itemId}"> 
	    <input type="hidden" name="createdDate" value="${provisionItem.createdDate}"></p></div> 
	</div>

	<div class="form-group">
		<label for="itemName" class="control-label col-xs-2">Name</label> 
		<div class="col-xs-10"><p class="form-control-static">${provisionItem.itemName}</p></div> 
	</div>

	<div class="form-group">
        <label for="rate" class="control-label col-xs-2">Amount</label>
        <div class="col-xs-10"><input type="number" class="form-control" id="rate" name="rate" placeholder="Rate" value="${provisionItem.rate}"></div>
        
    </div>
	
	<div class="form-group">
        <label for="unit" class="control-label col-xs-2">Unit</label>
        <div class="col-xs-10">
        <select id="unit" name="unit">
        	<option value="">Select</option>
        	<c:forEach items="${unitList}" var="unit">
        		<c:if test="${provisionItem.unit==unit}">
        			<option value="${unit}" selected="selected">${unit}</option>
        		</c:if>
        		<c:if test="${provisionItem.unit!=unit}">
        			<option value="${unit}">${unit}</option>
        		</c:if>
        	</c:forEach>
        </select></div>
    </div>

	<div class="form-group">
        <label for="avgQty" class="control-label col-xs-2">Avg Qty</label>
        <div class="col-xs-10"><input type="number" class="form-control" id="avgQty" name="avgQty" placeholder="Avg Qty" value="${provisionItem.avgQty}"></div>
    </div>

    <div class="form-group">
        <div class="col-xs-offset-2 col-xs-10">
            <button type="submit" class="btn btn-primary" name="save" value="save">Save</button>
            <button type="submit" class="btn btn-primary" name="cancel" value="cancel">Cancel</button>
        </div>
    </div>

	
	

</form>



<jsp:include page="/jsp/footer.jsp" />
