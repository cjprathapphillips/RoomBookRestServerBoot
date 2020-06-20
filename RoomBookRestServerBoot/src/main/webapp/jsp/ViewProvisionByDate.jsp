<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/jsp/header.jsp" />
<br><br><center><h1>See Created Provision</h1></center><br>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    
    
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
        ["Wheat", 8.94, "#b87333"],
        ["Rice", 10.49, "silver"],
        ["AGENEMOTO", 19.30, "gold"],
        ["ANNASI POO", 21.45, "color: #e5e4e2"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Density of Precious Metals, in g/cm^3",
        width: 1000,
        height: 300,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>
<form class="form-horizontal" method="post" action="deleteProvision">
<table class="table table-hover">
	<thead><tr><th>Created Date</th> <th>Record Count</th></tr></thead>
	<tbody>
		<c:forEach items="${viewProvisionDateList}" var="viewProvisionDate">
			<tr><td>${viewProvisionDate.proDate}</td>
			<td><a href="viewProvisionForDate?date=${viewProvisionDate.proDate}"><button type="button" class="btn btn-primary" >${viewProvisionDate.count}</button></a></td>
			<td><button type="submit" class="btn btn-primary" name="save" value="${viewProvisionDate.proDate}">Delete</button></td></tr>
		</c:forEach>
	</tbody>
</table>
</form>
  
<div id="columnchart_values" style="width: 900px; height: 300px;"></div>

<jsp:include page="/jsp/footer.jsp" />
