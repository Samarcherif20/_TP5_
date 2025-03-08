<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajout MakeUp</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="card">
        <div class="card-header">
            Saisie des Produits MakeUp
        </div>
        <div class="card-body">
            <form action="save.do" method="post">
                <div class="form-group">
                    <label class="control-label">Nom Produit :</label>
                    <input type="text" name="nom" class="form-control" required/>
                </div>
                <div class="form-group">
                    <label class="control-label">Marque :</label>
                    <input type="text" name="marque" class="form-control" required/>
                </div>
                <div class="form-group">
                    <label class="control-label">Type :</label>
                    <input type="text" name="type" class="form-control" required/>
                </div>
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="number" name="prix" class="form-control" required step="0.01"/>
                </div>
                <button type="submit" class="btn btn-success">Ajouter</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
