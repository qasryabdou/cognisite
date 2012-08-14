<!-- Le footer
    ================================================== -->
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">		
				<hr/>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span3">&nbsp;</div>
			<div class="span3">
				<a href="http://www.cognicap.com/"><h2>Cognicap.com</h2></a>
				<ul>
					<li><a href="formations.ftl" title="Cognicap Features">Toutes
							les Formations Cognicap</a></li>
					<li><a
						href="mailto:reservation@cognicap.com?subject:R&eacute;servation de formation"
						title="Cognicap Pricing">R&eacute;servez votre formation par
							email!</a></li>
					<li><a href="about.ftl" title="&Agrave;propos de Cognicap">&Agrave;
							propos de nous</a></li>
				</ul>
			</div>
			<div class="span3">				
				<a href="http://www.facebook.com/formations"><h2>Suivez-nous!</h2></a>
				<ul>
					<li><a href="http://www.facebook.com/cognicap"
						title="Join us on Facebook" target="_blank">Rejoignez-nous
							sur Facebook</a></li>
					<li><a href="http://twitter.com/cognicap"
						title="Join us on Twitter" target="_blank">Suivez-nous sur
							Twitter</a></li>
					<li><a href="contact.ftl" title="Contactez-nous!">Contactez-nous</a></li>
				</ul>
			</div>
			<div class="span3">&nbsp;</div>
		</div>
		<div class="row-fluid">
			<div class="span12">		
				<hr/>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">		
				<p align="center">44 rue Aguelmane Sidi Ali Apt 14, Agdal, Rabat<br>&copy; Copyright 2010 Cognicap. Tous droits reserv&eacute;s.
				</p>
				<p align="center">
					<a target="_blank" href="http://validator.w3.org/check/referer"
						title="Validate XHTML"><img class="centeredImage"
						alt="Valid XHTML" src="${contextPath}/static/img/valid-xhtml.gif" /></a>&nbsp;
					<a target="_blank" href="http://jigsaw.w3.org/css-validator/"
						title="Validate CSS"><img class="centeredImage" alt="Valid CSS"
						src="${contextPath}/static/img/valid-css.gif" /></a>&nbsp; <a
						target="_blank" href="http://jquery.com" title="jQuery"><img
						class="centeredImage" alt="jQuery"
						src="${contextPath}/static/img/jquery.png" /></a>
				</p>
				<p align="center">
					<a target="_blank" href="http://freemarker.org"><img
						class="centeredImage"
						src="${contextPath}/static/img/poweredby_big_ffffff.png"
						alt="Powered by FreeMarker" border="0"></a>&nbsp;
				</p>
			</div>
		</div>
	</div>
	<!--/.fluid-container-->

	<!-- Le javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${contextPath}/static/3rdparty/jquery-1.7.2.min.js"></script>
	<script	src="${contextPath}/static/3rdparty/jquery-ui-1.8.22.custom.min.js"></script>
	<script src="${contextPath}/static/3rdparty/bootstrap.min.js"></script>
	<script src="${contextPath}/static/3rdparty/application.js"></script>
	<script src="${contextPath}/static/js/codemy.js"></script>
	<script type="text/javascript" language="javascript"  src="${contextPath}/static/js/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript"  src="${contextPath}/static/media/js/ZeroClipboard.js"></script>
	<script type="text/javascript" language="javascript"  src="${contextPath}/static/media/js/TableTools.js"></script>
	<script type="text/javascript" language="javascript"  src="${contextPath}/static/js/CoursesTable.js"></script>
	<script type="text/javascript" charset="utf-8">
		$('#global-search-input').autocomplete({
			source : '${contextPath}/globalSearchAutoComplete',
			dataType : 'json',
			highlight : false,
			autoFocus : true,
			parse : function(data) {
				if (!data || data.length == 0) {
					console.log('No Matches');
					$('#global-search-input').val('No Matches');
				}
			},
			minLength : 1,
			scroll : true,
			select : function(event, ui) {
				$("#global-search-input").val(ui.item ? ui.item.Id : "");
			},
			change : function(event, ui) {
				$("#global-search-input").val(ui.item ? ui.item.Id : "");
			}
		});
	</script>
</body>
</html>