<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="js/btsr/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
    <link href="/cognicap.com/static/bootstrap/css/btsr/bootstrap.min.css" rel="stylesheet">
    <link href="/cognicap.com/static/bootstrap/css/btsr/bootstrap-responsive.css" rel="stylesheet">
    <link href="/cognicap.com/static/bootstrap/css/btsr/docs.css" rel="stylesheet">
    <script type="text/javascript">

	alert('${autocomplete}');
	
</script>
  </head>
<body class="preview" data-offset="50" data-target=".subnav" data-spy="scroll">
<div class="container">

<div class="container-fluid">
<section id="global">
  <div class="row-fluid">
    <div class="span12">
      <div class="hero-unit">
		<!-- Forms
		================================================== -->
		<section id="forms">
		  <div class="row">
		    <div class="span7 offset1">
		        <form class="well form-search">
		          <input type="text" class="input-small" placeholder="Username"><br/>		          
		          <input type="text" class="input-small" placeholder="Email">
		        </form>
		
			    <form class="well form-search">
			      <input type="text" class="span3" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source='${autocomplete}'>
			      <button type="submit" class="btn">Search</button>
			    </form>
		</section>
	      <div class="row-fluid">
	        <div class="span4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn" href="#">View details &raquo;</a></p>
	        </div><!--/span-->
	        <div class="span4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn" href="#">View details &raquo;</a></p>
	        </div><!--/span-->
	        <div class="span4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn" href="#">View details &raquo;</a></p>
	        </div><!--/span-->
	      </div><!--/row-->
	      <div class="row-fluid">
	        <div class="span4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn" href="#">View details &raquo;</a></p>
	        </div><!--/span-->
	        <div class="span4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn" href="#">View details &raquo;</a></p>
	        </div><!--/span-->
	        <div class="span4">
	          <h2>Heading</h2>
	          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
	          <p><a class="btn" href="#">View details &raquo;</a></p>
	        </div><!--/span-->
	      </div><!--/row-->
		  <p align="center"><a class="btn btn-primary btn-large">Show more</a></p>
	    </div><!--/span-->
	  </div><!--/row-->
     </div>
</section>
</div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/cognicap.com/static/bootstrap/js/btsr/jquery1.7.2.min.js"></script>
    <script src="/cognicap.com/static/js/bootstrap.js"></script>
    <script src="/cognicap.com/static/bootstrap/js/btsr/application.js"></script>
    <script src="/cognicap.com/static/bootstrap/js/btsr/bootswatch.js"></script>

  </body>
</html>
