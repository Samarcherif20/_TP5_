<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Editer MakeUp</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
    <div class="card mt-4">
        <div class="card-header">
              Modifier MakeUp
        </div>
        <div class="card-body">
            <form action="update.do" method="post">
                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" name="id" class="form-control"
                    value="${makeUp.idMaquillage}" readonly />
                </div>

                <div class="form-group">
                    <label class="control-label">Nom MakeUp :</label>
                    <input type="text" name="nom" class="form-control"
                    value="${makeUp.nom}" />
                </div>

                <div class="form-group">
                    <label class="control-label">Marque :</label>
                    <input type="text" name="marque" class="form-control"
                    value="${makeUp.marque}" />
                </div>

                <div class="form-group">
                    <label class="control-label">Type :</label>
                    <input type="text" name="type" class="form-control"
                    value="${makeUp.type}" />
                </div>

                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="number" name="prix" class="form-control"
                    value="${makeUp.prix}" />
                </div>

                <button type="submit" class="btn btn-success mt-3">Confirmer</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
