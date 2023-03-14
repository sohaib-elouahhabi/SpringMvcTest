<%@ include file="Header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container mt-5">
  <div class="card">
    <div class="card-header">Modifier Produit</div>
    <div class="card-body">
      <center>
        <form:form method="post" action="../edit/{id}">
          <td><form:input class="form-control" hidden="true"  path="id" /></td>

          <table class="mt-5">
            <tr>
              <td class="form-label lead">Code</td>
              <td><form:input class="form-control" disabled="true" path="id" /></td>
            </tr>
            <tr>
              <td class="form-label lead">Designation : </td>
              <td ><form:input path="designation" class="form-control" /></td>
            </tr>
            <tr>
              <td class="form-label lead">Prix :</td>
              <td ><form:input path="prix" class="form-control"/></td>
            </tr>
            <tr>
              <td class="form-label lead">quantite :</td>
              <td ><form:input path="quantite" class="form-control" /></td>
            </tr>
            <tr>
              <td><center><button  type="reset" class="btn btn-danger mt-3">Annuler</button></center></td>
              <td ><center><input class="btn btn-info mt-3" type="submit" value="Save" /></center></td>
            </tr>
          </table>
        </form:form>
      </center>
    </div>
  </div>
</div>

<%@ include file="Footer.jsp" %>
