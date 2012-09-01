<#include "header.ftl">
<script>
$(document).ready(function() {
	$('#usersDetails').dataTable();
} );
</script>
<div class="container">
<div class ="content">
<table class="table table-striped table-bordered table-condensed">
    <thead>
        <tr>
           <th>UserId</th>
           <th>Civilite</th>
           <th>Prenom</th>
           <th>Nom</th>
           <th>Email</th>
           <th>Mobile</th>
           <th>Compagnie</th>
           <th>Ville</th>
           <th>Niveau</th>
           <th>Referrent</th>
           <th>Login</th>
           <th>Role</th>
        </tr>
    </thead>
    <tbody>
	<#list users as user>
        <tr>
            <td align="center">${user.userId}</td>
            <td align="center">${user.civilite}</td>
            <td align="center">${user.prenom}</td>
            <td align="center">${user.nom}</td>
            <td align="center">${user.email}</td>
            <td align="center">${user.mobile}</td>
            <td align="center">${user.compagnie}</td>
            <td align="center">${user.ville}</td>
            <td align="center">${user.niveau}</td>
            <td align="center">${user.referrant}</td>
            <td align="center">${user.login}</td>
            <td align="center">${user.role}</td>
        </tr>
	</#list>
    </tbody>
</table>
</div>
</div>

<#include "footer.ftl">