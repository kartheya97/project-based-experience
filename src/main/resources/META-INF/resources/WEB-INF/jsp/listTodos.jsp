<%@include file="commons/header.jspf" %>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@include file="commons/navigation.jspf" %>
	<div class="container">
		<h1>Your Todos</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Completed</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.isCompleted}</td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-success">UPDATE</a></td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>
<%@include file="commons/footer.jspf" %>
</body>
</html>
