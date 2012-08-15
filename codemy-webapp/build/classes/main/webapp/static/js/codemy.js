(function($) {
	/* slider.js Used for homepage */
	$(document).ready(function() {
		$('#rowInscriptionInvite').show('slow');
		$('#sliderNav a').click(function() {
			var integer = $(this).attr('rel');
			$('#slider .slides').animate({
				left : -968 * (parseInt(integer) - 1)
			})
			$('#sliderNav a').each(function() {
				$(this).removeClass('active');
				if ($(this).hasClass('slide' + integer)) {
					$(this).addClass('active')
				}
			});
		});
	});
})(jQuery);

// create function, it expects 2 values.
function insertAfter(newElement, targetElement) {
	// target is what you want it to go after. Look for this elements parent.
	var parent = targetElement.parentNode;

	// if the parents lastchild is the targetElement...
	if (parent.lastchild == targetElement) {
		// add the newElement after the target element.
		parent.appendChild(newElement);
	} else {
		// else the target has siblings, insert the new element between the
		// target and it's next sibling.
		parent.insertBefore(newElement, targetElement.nextSibling);
	}
}

function adjustStyle(width) {
    width = parseInt(width);
    if (width > 801) {
        $("#beta").animate({"left": "+=5px", "top":"-=1px"}, "slow");
    }
}

$(function() {
    adjustStyle($(this).width());
    $(window).resize(function() {
        adjustStyle($(this).width());
    });
});

$('#inscriptionInvite').click(function() {
	$('#rowInscriptionInvite').hide('slow');
	$('[data-spy="scroll"]').each(function () {
		  $('body').scrollspy('refresh');
		});
});