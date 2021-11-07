<%@page import="java.text.DecimalFormat"%>
<%@page import="common.vo.MemberProductVO"%>
<%@page import="common.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	List<MemberProductVO> memberProductList = (List)request.getAttribute("memberProductList");
	DecimalFormat df = new DecimalFormat("###,###"); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 간식</title>
	<style type="text/css">
		#wrap_product {
			display: flex;
			margin: 80px auto;
			width: 1280px;
			flex-flow: row nowrap;
		}
		.product_title {
			display: flex;
			flex-flow: row wrap;
		}
		#wrap_product .title {
			font-size: 4rem;
			width: 90%;
		}
		#wrap_product .cart {
			font-size: 2.5rem;
			width: 10%;
			align-self: flex-end;
		}
		#wrap_product .cart:hover {
			text-decoration: underline;
			cursor: pointer;
		}
		hr.black {
			border: 1px solid black;
		}
		#wrap_product .subtitle {
			font-size: 3rem;
			margin-left: 30px;
			margin-top: 60px;
		}
		#wrap_product .lightgray {
			border: 1px solid #ebebeb;
		}
		.product_list {
			display: flex;
			flex-flow: row wrap;
		}
		.product_list div {
			width: calc(25% - 40px);
			margin: 20px;
			border: 1px solid #ededed;
			border-radius: 10px;
			height: 400px;
		}
		.product_list div:hover {
			border-color: #ff1212;
			cursor: pointer;
		}
		.product_list div > div {
			margin: 0;
			width: 100%;
			height: 200px;
			border: none;
			text-align: center;
		}
		.product_list .product_img img {
			border-radius: 10px 10px 0 0;
			max-height: 100%;
			width: auto;
		}
		.product_list .product_info {
			border-radius: 0 0 10px 10px;
		}
		.product_info p {
			margin-top: 18px;
		}
		.product_name {
			font-size: 2.5rem;
			font-weight: bold;
		}
		.product_desc {
			font-size: 1.5rem;
		}
		.product_price {
			font-size: 2rem;
		}
	</style>
	<script type="text/javascript">
// 		function cartPage() {
// 		}
		
		function sendProductInfo(obj){
			$("#selectProdCd").val($(obj).next().children("[name=prodCd]").val());
			
			var fm = document.getElementById("fm");
			fm.action = "/TicketingProject/member/product/memberProductDetail.do"
			fm.method = "post"
			fm.submit();
		}
		
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_product">
		<div class="container">
			<div class="product_title">
				<h2 class="title">상품</h2>
			</div>
			<hr class="black">
			<h2 class="subtitle">콤보</h2>
			<hr class="lightgray">
			
			<div class="product_list">
			<% for(int i=0; i<memberProductList.size(); i++){
				if(memberProductList.get(i).getProdTypeCd().equalsIgnoreCase("P04")){
					String imgSrc = "/TicketingProject/images/admin/" + memberProductList.get(i).getFileStoreName();
					int prodPrice = Integer.parseInt(memberProductList.get(i).getProdPrice());
			%>

					<div>
						<div onclick="sendProductInfo(this)" class="product_img">
							<img id="combo" alt="콤보" src=<%=imgSrc %>>
						</div>
						
							<div class="product_info">
								<input type="hidden" name="prodCd" value="<%=memberProductList.get(i).getProdCd()%>">
								<p class="product_name"><%=memberProductList.get(i).getProdName() %></p>
								<p class="product_desc"><%=memberProductList.get(i).getProdDesc() %></p>
								<p class="product_price"><%=df.format(prodPrice) %>원</p>
							
							</div>
					</div>
			
			<%		
				}
			%>
			<%	
			} 
			%>
			</div>
			<hr>
			
			<h2 class="subtitle">팝콘</h2>
			<hr class="lightgray">
			<div class="product_list">
							<% for(int i=0; i<memberProductList.size(); i++){
				if(memberProductList.get(i).getProdTypeCd().equalsIgnoreCase("P01")){
					String imgSrc = "/TicketingProject/images/admin/" + memberProductList.get(i).getFileStoreName();
					int prodPrice = Integer.parseInt(memberProductList.get(i).getProdPrice());
			%>

					<div>
						<div onclick="sendProductInfo(this)" class="product_img">
							<img id="popcon" alt="팝콘" src=<%=imgSrc %>>
						</div>
						
							<div class="product_info">
								<input type="hidden" name="prodCd" value="<%=memberProductList.get(i).getProdCd()%>">
								<p class="product_name"><%=memberProductList.get(i).getProdName() %></p>
								<p class="product_desc"><%=memberProductList.get(i).getProdDesc() %></p>
								<p class="product_price"><%=df.format(prodPrice) %>원</p>
							
							</div>
					</div>
			
			<%		
				}
			%>
			<%	
			} 
			%>
			</div>
			
			<hr>
			
			<h2 class="subtitle">스낵</h2>
			<hr class="lightgray">
			<div class="product_list">
							<% for(int i=0; i<memberProductList.size(); i++){
				if(memberProductList.get(i).getProdTypeCd().equalsIgnoreCase("P03")){
					String imgSrc = "/TicketingProject/images/admin/" + memberProductList.get(i).getFileStoreName();
					int prodPrice = Integer.parseInt(memberProductList.get(i).getProdPrice());
			%>

					<div>
						<div onclick="sendProductInfo(this)" class="product_img">
							<img id="snack" alt="스낵" src=<%=imgSrc %> style="width: 250px;">
						</div>
						
							<div class="product_info">
								<input type="hidden" name="prodCd" value="<%=memberProductList.get(i).getProdCd()%>">
								<p class="product_name"><%=memberProductList.get(i).getProdName() %></p>
								<p class="product_desc"><%=memberProductList.get(i).getProdDesc() %></p>
								<p class="product_price"><%=df.format(prodPrice) %>원</p>
							
							</div>
					</div>
			
			<%		
				}
			%>
			<%	
			} 
			%>
			</div>
			
			<hr>
			<h2 class="subtitle">음료</h2>
			<hr class="lightgray">
			<div class="product_list">
							<% for(int i=0; i<memberProductList.size(); i++){
				if(memberProductList.get(i).getProdTypeCd().equalsIgnoreCase("P02")){
					String imgSrc = "/TicketingProject/images/admin/" + memberProductList.get(i).getFileStoreName();
					int prodPrice = Integer.parseInt(memberProductList.get(i).getProdPrice());
			%>

					<div>
						<div onclick="sendProductInfo(this)" class="product_img">
							<img id="drink" alt="음료" src=<%=imgSrc %>>
						</div>
						
							<div class="product_info">
								<input type="hidden" name="prodCd" value="<%=memberProductList.get(i).getProdCd()%>">
								<p class="product_name"><%=memberProductList.get(i).getProdName() %></p>
								<p class="product_desc"><%=memberProductList.get(i).getProdDesc() %></p>
								<p class="product_price"><%=df.format(prodPrice) %>원</p>
							
							</div>
					</div>
			
			<%		
				}
			%>
			<%	
			} 
			%>
			</div>
			<form id="fm">
				<input type="hidden" id="selectProdCd" name="prodCd">
			</form>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>