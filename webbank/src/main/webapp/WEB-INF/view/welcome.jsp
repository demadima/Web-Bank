<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css"
	href="/theme/css/bootstrap.min.css">

</head>

<body>
	
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="card"
					style="margin-top: 45px; margin-left: 200px; margin-right: 200px">
					<div class="card-header">Mail: ${product.mail}</div>
					<div class="card-body">
						Balans: ${product.price}
						<p class="card-text">
							<a href='<c:url value="/deposit?id=${product.id}" />'>Deposit</a>
							| <a href='<c:url value="/withdraw?id=${product.id}" />'>Withdraw</a>
							| <a href="<c:url value="/" />" role="button">Logout</a>
						</p>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>