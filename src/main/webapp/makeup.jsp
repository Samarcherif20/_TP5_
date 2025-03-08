<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste MakeUp</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="card">
        <div class="card-header">Recherche des Produits Make_up</div>
        <div class="card-body">
            <form action="chercher.do" method="get">
                <label>Mot Clé</label>
                <input type="text" name="motCle" value="${model.motCle}" />
                <button type="submit" class="btn btn-success">Chercher</button>
            </form>
            <table class="table table-striped">
                <tr><th>ID</th><th>Nom</th><th>Marque</th><th>Type</th><th>Prix</th><th>Supprimer</th><th>Editer</th></tr>
                <c:forEach items="${model.makeUpList}" var="m">
						<tr>
							<td>${m.idMaquillage}</td>
							<td>${m.nom}</td>
							<td>${m.marque}</td>
							<td>${m.type}</td>
							<td>${m.prix}</td>
							<td><a onclick="return confirm('Etes-vous sûr ?')"
								href="supprimer.do?id=${m.idMaquillage }">Supprimer</a></td>
							<td><a href="editer.do?id=${m.idMaquillage }">Editer</a></td>
						</tr>
					</c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
