<#include "header.ftl">
<#list courses as course>

<script type="text/javascript" language="javascript">
$(document).ready(function() {
	$('.span4 .showhide').click(function() {
		var showHideButton = $(this), description = showHideButton.parent(), showHideText = showHideButton.children('span');
		description.toggleClass('expanded');
		showHideText.text(showHideText.text() == 'Show more' ? 'Show less' : 'Show more');			
	});
});
</script>
<#if course_index %3 == 0>
<div class="row-fluid">
	<div class="span4">
			<div class="description-text">
				<h2>${course.title}</h2>
				<p><img ALIGN=LEFT src=${course.icon} />${course.description}</p>
				<p><a href="inscription.ftl">Je m'inscris!</a></p>
				<br/>
			</div> <!-- description-text -->
			<div class="description-fadeout"></div>
	   	 	<button class="showhide" type="button" onClick="return false;" role="button"><span class="showhide-text">Show more</span></button>
	</div>
</#if>
<!--/span-->
<#if course_index %3 == 1>
	<div class="span4">
			<div class="description-text">
				<h2>${course.title}</h2>
				<p><img ALIGN=LEFT src=${course.icon} />${course.description}</p>
				<p><a href="inscription.ftl">Je m'inscris!</a></p>
				<br/>
			</div> <!-- description-text -->
			<div class="description-fadeout"></div>
	   	 	<button class="showhide" type="button" onClick="return false;" role="button"><span class="showhide-text">Show more</span></button>
	</div>
</#if>
<!--/span-->
<#if course_index %3 == 2>
	<div class="span4">
			<div class="description-text">
				<h2>${course.title}</h2>
				<p><img ALIGN=LEFT src=${course.icon} />${course.description}</p>
				<p><a href="inscription.ftl">Je m'inscris!</a></p>
				<br/>
			</div> <!-- description-text -->
			<div class="description-fadeout"></div>
	   	 	<button class="showhide" type="button" onClick="return false;" role="button"><span class="showhide-text">Show more</span></button>
		</div>
</div>
</#if>
</#list>
<input type="hidden" id="showMoreHash" value="${page!}">
<#include "footer.ftl">