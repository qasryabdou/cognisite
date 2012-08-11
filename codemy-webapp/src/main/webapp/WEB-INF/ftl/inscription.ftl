<#include "header.ftl">
<!-- START BODY -->
<script type="text/javascript">
	window.onload = (function() {
		try {
			$.validator
					.addMethod(
							"username",
							function(value, element) {
								return this.optional(element)
										|| /^[a-z0-9\_]+$/i.test(value);
							},
							"Le nom de l'utilisateur ne doit contenir que des lettres, nombres, ou soulign&eacute;.");
			$.validator.addMethod("NumbersOnly", function(value, element) {
				return this.optional(element)
						|| /^([0-9\(\)\/\+ \-]*)$/i.test(value);
			}, "Le num&eacute;ro ne doit compoter que des nombres, + and -.");
			$(document).ready(function() {
				$("#inscription").validate();
			});
		} catch (e) {
			console.log(e)
		}
	});
</script>
<form id="inscription" method="POST" accept-charset="UTF-8">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span1"></div>
			<div class="span10">
				<div class="page-title">R&eacute;serve ton cours!</div>
				<div class="content-wrapper rounded">
					<div class="landing-page-menu rounded">
						<h2>L'&eacute;quipe Cognicap s'engage &agrave; confirmer ta
							r&eacute;servation dans les plus bref d&eacute;lais</h2>
					</div>
					<br />
					<div class="content">
						<h3>&nbsp;&nbsp;Information personnelle</h3>
						<div class="row-fluid">
							<div class="span6">
								<div class="fields">
									<input id="civilite1" checked="on" name="civilite"
										style="vertical-align: middle" type="radio" value="Mr." />Mr.&nbsp;<input
										id="civilite2" name="civilite" style="vertical-align: middle"
										type="radio" value="Mme." /> Mme.&nbsp;<input id="civilite4"
										name="civilite" style="vertical-align: middle" type="radio"
										value="Mlle" />Mlle&nbsp;
								</div>
								<div class="fields">
									<label for="inscription.nom">Nom<sup
										class="requiredstar">*</sup>:
									</label> <input class="required" id="inscription.nom"
										name="inscription.nom" value="" type="text" value="" size="30" />
								</div>
								<div class="fields">
									<label for="prenom">Pr&eacute;nom<sup
										class="requiredstar">*</sup>:
									</label> <input class="required" id="prenom" name="prenom" type="text"
										value="" size="30" />
								</div>
								<div class="fields">
									<label for="email">Email<sup class="requiredstar">*</sup>:
									</label> <input class="required email" id="email" name="email"
										type="text" value="" size="30" />
								</div>
								<div class="entetechamp">
									<label for="referrant">Comment as-tu entendu parler de
										nous?<sup class="requiredstar">*</sup>:
									</label>
								</div>
								<div class="fields">
									<select class="required" id="referrant" name="referrant">
										<option value="">--Veuillez choisir--</option>
										<option value="Google">Google</option>
										<option value="Journal0537">Journal 0537</option>
										<option value="JournalIntermediaire">Journal
											L'Interm&eacute;diaire</option>
										<option value="Facebook">Facebook</option>
										<option value="Twitter">Twitter</option>
										<option value="AutreSite">Un autre site (blog, forum,
											etc.)</option>
										<option value="BoucheOreil">Bouche &agrave; oreil</option>
										<option value="SokoMaroc">Soko Maroc</option>
										<option value="Autre">Autre</option>
									</select>
								</div>
							</div>
							<div class="span6">
								<div class="entreeformulaire">
									<div class="entetechamp">
										<label for="mobile">T&eacute;l&eacute;phone portable<sup
											class="requiredstar">*</sup>:
										</label>
									</div>
									<div class="fields">
										<input class="required NumbersOnly" id="mobile" name="mobile"
											type="text" value="" size="30" />
									</div>
								</div>
								<div class="entreeformulaire">
									<div class="entetechamp">
										<label for="ville">Ville<sup class="requiredstar">*</sup>:
										</label>
									</div>
									<div class="fields">
										<input class="required" id="ville" name="ville" type="text"
											value="" size="30" />
									</div>
								</div>
								<div class="entreeformulaire">
									<div class="entetechamp">
										<label for="compagnie">Compagnie ou &eacute;cole<sup
											class="requiredstar">*:</label>
									</div>
									<div class="fields">
										<input class="required" id="organization" name="compagnie"
											class="middle" type="text" value="" size="30" />
									</div>
								</div>
								<div class="entreeformulaire">
									<div class="entetechamp">
										<label for="niveau">Quel est ton niveau?<sup
											class="requiredstar">*</sup>:
										</label>
									</div>
									<div class="fields">
										<select class="required" id="niveau" name="niveau">
											<option value="">--Veuillez choisir--</option>
											<option value="As des notions">As des notions</option>
											<option value="D&eacute;butant">D&eacute;butant</option>
											<option value="Confortable">Confortable</option>
											<option value="Interm&eacute;daire">Interm&eacute;daire</option>
											<option value="Experiment&eacute;">Experiment&eacute;</option>
										</select>
									</div>
								</div>
								<div class="entreeformulaire">
									<div class="entetechamp">
										<label for="cours">Choisis ton cours?<sup
											class="requiredstar">*</sup>:
										</label>
									</div>
									<div class="fields">
										<select class="required" id="cours" name="cours">
											<option value="">--Choisis ton cours--</option>
											<option value="SL-110">Formation Java - Niveau
												Associ&eacute; - SL-110 (Code Examen 1Z0-850)</option>
											<option value="1Z0-850">Certified Java Associate
												(Code Examen 1Z0-850) - 5 jours intensif</option>
											<option value="SL-275">Formation Java - Niveau
												Experiment&eacute; - SL-275 (Code Examen 1Z0-851)</option>
											<option value="1Z0-851">Certified Java Programmer
												(1Z0-851) - 5 jours intensif</option>
											<option value="UML">UML - Formation avanc&eacute;e
												en conception orient&eacute; objet.</option>
											<option value="HIBERNATE">Maitriser Hibernate 3.0</option>
											<option value="ANDROID">Formation intensive Android
												2.1</option>
											<option value="ASTERISK">Asterisk (logiciel)</option>
											<option value="1Z0-858">Certified Java EE 5 Web
												Component Developer (Code Examen 1Z0-858)</option>
											<option value="Industrialisation">Industrialisation
												par l'Int&eacute;gration Continue - Hudson, Sonar, PMD,
												CheckStyle</option>
										</select>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12">
							<div class="sectionEnvoyerReservation">
								<input value="Je r&eacute;serve!" type="submit" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="span1"></div>
		</div>
	</div>
</form>
<#include "footer.ftl">
