<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
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
					<div class="card-header">Balans: ${product.price}</div>

					<div class="card-body">
						<form method="post">
							<input type="hidden" value="${product.id}" name="id" />
							
							<div class="form-group">
								<label>Deposit</label>
								<div class="input-group input-group-sm mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="inputGroup-sizing-sm">></span>
									</div>

									<input type="hidden" name="priceOld" value="${product.price}">
									<input type="text" name="priceNew" value="${product.price}"
										class="form-control" aria-label="Small"
										aria-describedby="inputGroup-sizing-sm">
								</div>
								<input style="margin-top: 10px;" class="btn btn-primary"
									type="submit" value="Submit">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>