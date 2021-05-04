<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Statistics</title>
  		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!--Chart js  -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
		
		
		<link rel="stylesheet" href="resources/table.css">
	</head>
	
	<body>
	    <img class="immBack" id="search" src="resources/img/search-background.jpg"/>
		<jsp:include page="navBar.jsp"></jsp:include>
		
		<div class="container">
  <div class="row">
  
  <div class="table-wrapper-scroll-y my-custom-scrollbar" style="height: 80%">
			<div class="d-flex justify-content-center text-center" >
				<div class="bg-light shadow p-3 mb-5 bg-body rounded" style="width:20%;">
					<table id="table"  style="width:100%;">
						<tr>
							<th>Algorithm</th>
							<th>#Success</th>
						</tr>
						<c:forEach items="${list}" var="item">
							<tr>
								<td>${item.algoritmo}</td>
								<td>${item.num}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
  
  <div class="container col-md-4 justify-content-center" style="margin-top: 5%;">
		<canvas id="pie-chart"></canvas>
		</div>
   
    </div>
  </div>
  
	
		<script type="text/javascript">
		
		/*
		
		new Chart(document.getElementById("pie-chart"), {
		    type: 'pie',
		    data: {
		      labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
		      datasets: [{
		        label: "Population (millions)",
		        backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
		        data: [2478,5267,734,784,433]
		      }]
		    },
		    options: {
		      title: {
		        display: true,
		        text: 'Predicted world population (millions) in 2050'
		      }
		    }
		});
		
		*/
		
		
		
		  $(document).ready(function() {
			  
			  if(jQuery){
				  console.log('yes');
				  }
		      $.ajax({
		        url: "/WebApplication/chart",
		        success: function(list) {

		          var algoList = [];
		          var statData = [];
		          for (var i = 0; i < list.length; i++) {

		            algoList.push(list[i].algoritmo);
		            statData.push(list[i].num);
		          }
		          
		          console.log(algoList);
		          console.log(statData);

		  		new Chart(document.getElementById("pie-chart"), {
		  		    type: 'pie',
		  		    data: {
		  		      labels: algoList,
		  		      datasets: [{
		  		      
		  		    	backgroundColor:["#50514f","#b4adea","#fdfff7","#59ffa0","#ff0841","#e77728","#3d2c00","#ff5714","#ff6b6c","#d58936"],
		  		        data: statData
		  		        
		  		      }]
		  		    },
		  		    options: {
		  		    	 legend: {
		  	                labels: {
		  	                    fontColor: "#FFFFFF",
		  	                    fontSize: 14
		  	                }
		  	            }
		  		    
		  		    }
		  		});

		        
		        }
		      })

		    });

		
		</script>
		
		
		
	</body>
</html>