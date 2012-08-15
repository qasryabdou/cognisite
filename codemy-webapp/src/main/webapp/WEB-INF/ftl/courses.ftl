<#include "header.ftl">
<!-- START BODY -->
<div
  id="bd"
  class="body-page">
  <div class="page-title">Liste des cours</div>
  <div class="content-wrapper rounded">
    <div class="landing-page-menu rounded">
      <h2>Rabat</h2>
      <p>Maroc</p>
    </div>
   <div class="content"><br />
  <!--  <div id="list" style="display:none">-->
   <table cellpadding="0" cellspacing="0" border="0" class="display" id="example" width="100%">
   <thead>
   		 <tr>
   		 	<th>ID</th>
	        <th>Programme 2011 - Inscription continue!</th>
	        <th>Format</th>
	        <th>Dur&eacute;e</th>
	        <th>Niveau</th>
	        <th>GO!</th>
	        <th>objectif</th>
	        <th>prereq</th>
	        <th>description</th>
   		 </tr>
   		 
   	</thead>
   	<tbody>
	
   	
    <#list courses as course>
	    <tr>
	    	<td>${course.id}</td>
	        <td><img class="icon-cours"  src="${contextPath}/${course.icon}" alt="${course.icon}"
	        	/> ${course.title} </td>
	        <td>${course.format}</td>
	        <td>${course.duration}</td>
	        <td>${course.level}</td>
	        <td><a href="inscription.ftl">Je m'inscris!</a></td>
	        <td>${course.objectif}</td>
	        <td>${course.prerequisite}</td>
	        <td>${course.description}</td>
	    </tr>
    </#list>    
    </tbody>    
      </table>   
     <!--  </div>-->
      <br />
    </div>
  </div>
</div>
<!-- END BODY --> <!-- END headerWrap --></div>
<!-- END siteContainer --></div>
<!-- START FOOTER -->
<#include "footer.ftl">