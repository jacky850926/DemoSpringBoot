<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 載入標簽 jstl-core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Query List</title>
<link rel="stylesheet" href="/css/ordersystem.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   var indexPage = 1;
   
   $(function(){
	   loadPage(indexPage);
   });
   
   function loadPage(indexPage){
	   $.ajax({
		   type:'post',
		   url:'/product/querybypage/'+indexPage,
		   dataType:'JSON',
		   contentType:'application/json',
		   success: function(data){
			   $("#showproduct").empty("");
			   
			   if(data==null){
				   $('table').prepend('<tr><td colspan="2">No data</td></tr>');
			   }else{
				   var table = $("#showproduct");
				   table.append("<tr id='ptitle'><th>ID</th><th>Product Name</th><th>Product Price</th><th>Quantity</th><th>Date</th><th>Note</th></tr>");
				   
				   $.each(data, function(i,n){
					   var tr = "<tr align='center'>" + "<td>" + n.pid + "</td>" +
					            "<td>" + n.pname + "</td>" + "<td>" + n.price + "</td>" + "<td>" + n.quantity + "</td>" +
					            "<td>" + n.pdate + "</td>" + "<td>" + n.note + "</td>" +
					            "</tr>";
					   table.append(tr);
				   });
			   }
		   }
	   });
   }
   
   function change(index){
	   indexPage = index;
	   loadPage(indexPage);
   }
   
</script>
</head>
<body>
<div id="productListTitle">Product Query</div>
<table id="showproduct" border="1"></table>
<table id="showpage">
   <tr>
      <td>Total Pages: ${totalPages} Total Records: ${totalElements}</td>
      <td colspan="3" align="right">Previous
      <!-- 跑for each , i表示變數 ， 範圍從 1~ total page的數量 (total page是由 model傳進來的， step 1 一次count 1個 -->
          <c:forEach var="i" begin="1" end="${totalPages}" step="1">
              <button id="myPage" value="${i}" onclick="change(${i})">${i}</button>
          </c:forEach>Next
      </td>
   </tr>
</table>
</body>
</html>