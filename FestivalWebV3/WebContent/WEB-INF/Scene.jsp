<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des Scenes</title>
</head>
<body><form><div>
<h2><p>Dernier enregistrement créé</p></h2></br>
<table border="1">
<%

String id = (String) request.getAttribute("id");
String groupe = (String) request.getAttribute("groupe");
String datec = (String) request.getAttribute("datec");
String heure = (String) request.getAttribute("heure");
String duree = (String) request.getAttribute("duree");

ArrayList<String> liste =  (ArrayList<String>) request.getAttribute("listScene"); 

%>

<tr>
<td><h4><p>Id</p></h4></td><td><h4><p>Groupe</h4></td><td><h4><p>Date</h4></td><td><h4><p>Heure</h4></td><td><h4><p>Duree</h4></td></TR>
<tr><td><%=id %></td><td><%=groupe %></td><td><%=datec %></td><td><%=heure %></td><td><%=duree %></td></TR>
</table></br>
</div>
</br>
<div>
<h2><p>Liste des Scenes</p></h2></br>
<%-- Affichage des Scènes existantes --%>
<table border='1'>
<%
for (int i=0; i<liste.size();i++)
{
	String ligne = (String) liste.get(i);

%>
<tr><td><%=ligne %></td></tr>
<%

    }
%>
</div>
</form>
</body>
</html>