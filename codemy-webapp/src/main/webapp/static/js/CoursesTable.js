
		/* Formating function for row details */
		function fnFormatDetails ( oTable, nTr )
		{
		    var aData = oTable.fnGetData( nTr );
		    var sOut = '<table class="description_cours">';
		    sOut += '<tr class="alt"><td class="detail-cours rounded" colspan=2> Objectif</td></tr>';
		    sOut += '<tr class="alt"><td class="description-cours rounded" colspan=2>'+aData[7]+'</td></tr>';
		    sOut +=  '<tr class="alt"><td class="detail-cours rounded" colspan=2> Pr&eacute;-requis </td></tr>';
		    sOut += '<tr class="alt"><td class="description-cours rounded" colspan=2>'+aData[8]+'</td></tr>';
		    sOut += '<tr class="alt"><td class="detail-cours rounded" colspan=2>D&eacute;scription</td></tr>';
		    sOut += '<tr class="alt"><td class="description-cours rounded" colspan=2>'+aData[9]+'</td></tr>';
		    sOut += '</table>';
		     
		    return sOut;
		}
		 
		$(document).ready(function() {
		    /*
		     * Insert a 'details' column to the table
		     */
		    var nCloneTh = document.createElement( 'th' );
		    var nCloneTd = document.createElement( 'td' );
		    nCloneTd.innerHTML = '<img src="/cognicap.com/static/images/details_open.png"/>';
		    nCloneTd.className = "center";
		     
		    $('#example thead tr').each( function () {
		        this.insertBefore( nCloneTh, this.childNodes[0] );
		    } );
		     
		    $('#example tbody tr').each( function () {
		        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
		    } );
		     
		    /*
		     * Initialse DataTables, with no sorting on the 'details' column
		     */
		    var oTable = $('#example').dataTable( {
							"aoColumnDefs": [
								  { "bVisible": false, "aTargets": [ 1 ] },
								  { "bVisible": false, "aTargets": [ 7 ] },
								  { "bVisible": false, "aTargets": [ 8 ] },
								  { "bVisible": false, "aTargets": [ 9 ] } ],
							"aaSorting": [[2, 'asc']],	
							"sDom": '<"top"fi>rt<"bottom"p<"clear">>',
							"bJQueryUI": true,
							"sPaginationType": "full_numbers",
							"oLanguage": {
								"sInfo": "De _START_ à _END_ sur un total de _TOTAL_ Formations",
								"sInfoFiltered": "(filtrèes de _MAX_ Formations)",
								"sLengthMenu": "Afficher _MENU_ Formations",
								"sSearch": "Recherche:",
								"sZeroRecords": "Aucune Formations ne correspond à cette recherche",
								"oPaginate": {
									"sFirst": "Première page",
									"sLast": "Dernière",
									"sNext": "Suivante",
									"sPrevious": "Précédente"
								}
							}
						
		    });
			$('#example tbody td img').live('click', function () {
							var img1 = "static/images/details_open.png";
							var img2 = "static/images/details_close.png";
							if((this.src.indexOf(img1)>=0)||(this.src.indexOf(img2)>=0)){  //str.indexOf("Yes") >= 0
								var nTr = $(this).parents('tr')[0];
								if ( oTable.fnIsOpen(nTr) )
								{
									/* This row is already open - close it */
									this.src = "/cognicap.com/static/images/details_open.png";
									oTable.fnClose( nTr );
								}
								else
								{
									/* Open this row */
									this.src = "/cognicap.com/static/images/details_close.png";
									oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
								}
							
							}
							
						} );
		
	});