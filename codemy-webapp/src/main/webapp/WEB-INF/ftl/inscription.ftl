<#include "header.ftl">
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
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
<@form.form id="inscription" method="POST"  commandName="USER">
	<div class="container-fluid">
		<div >
			<div class="span1"></div>
			<div class="span10">
				<div class="page-title">Cr&eacute;e ton profil Cognicap !</div>
				<div class="content-wrapper rounded">
					<div class="landing-page-menu rounded">
						<h2>L'&eacute;quipe Cognicap s'engage &agrave; confirmer ta
							r&eacute;servation dans les plus bref d&eacute;lais</h2>
					</div>
					<br />
					<div class="content">
						
						<div class="row-fluid">
							<div class="span1">
							</div>
							<div class="span5">
							<h4>Informations du compte utilisateur</h4>
								<div class="fields">
									<label for="inscription.login">Login<sup
										class="requiredstar">*</sup>:
									</label> <@form.input class="validate[required,custom[noSpecialCaracters],length[0,20]]" id="login"
										path="login"  type="text" value="" size="30" />
								</div>
								<div class="fields">
									<label for="email">Email<sup class="requiredstar">*</sup>:
									</label>
										<@form.input class="validate[required,custom[email]] text-input" id="email" path="email"
										type="text" value="" size="30"/>
								</div>
								<div class="fields">
									<label for="password">Password<sup
										class="requiredstar">*</sup>:
									</label> <@form.input class="validate[required,length[6,11]] text-input" id="password"
										path="password"  type="password" value="" size="30" />
								</div>
								<div class="fields">
									<label for="passwordconf">Password confirmation<sup
										class="requiredstar">*</sup>:
									</label> <@form.input class="validate[required,confirm[password]] text-input" id="passwordconf"
										name="passwordconf"  type="password" value="" size="30" />
								</div>
							</div>
						
							<div class="span6">
							<h4>Informations personnelles</h4>
								<br/>
								<div class="fields">
									<input id="civilite1" checked="on" name="civilite" style="vertical-align: middle" type="radio" value="Mr." />Mr.&nbsp;
									<input id="civilite2" name="civilite" style="vertical-align: middle" type="radio" value="Mme." /> Mme.&nbsp;
									<input id="civilite4" name="civilite" style="vertical-align: middle" type="radio" value="Mlle" />Mlle&nbsp;
								</div><br/>
								<div class="fields">
									<label for="nom">Nom<sup
										class="requiredstar">*</sup>:
									</label> <@form.input class="validate[required,custom[onlyLetter],length[0,100]] text-input" id="nom"
										path="nom" type="text" value="" size="30" />
								</div>
								<div class="fields">
									<label for="prenom">Pr&eacute;nom<sup
										class="requiredstar">*</sup>:
									</label> <@form.input class="validate[required,custom[onlyLetter],length[0,100]] text-input" id="prenom" path="prenom" type="text"
										value="" size="30" />
								</div>
								
								<div class="fields">
									<label for="mobile">T&eacute;l&eacute;phone portable<sup
										class="requiredstar">*</sup>:
									</label>
									<@form.input class="validate[required,custom[telephone]] text-input" id="mobile" path="mobile"
										type="text" value="" size="30" />
								</div>
								<div class="fields">
									<label for="ville">Ville<sup class="requiredstar">*</sup>:
									</label>
									<@form.input class="validate[required,custom[noSpecialCaracters],length[0,20]]" id="ville" path="ville" type="text"
										value="" size="30" />
								</div>
								<div class="fields">
									<label for="compagnie">Compagnie ou &eacute;cole<sup
										class="requiredstar">*:</label>
									<@form.input class="validate[required,custom[noSpecialCaracters],length[0,20]]" id="organization" path="compagnie"
										class="middle" type="text" value="" size="30" />
								</div>
								<div class="fields">
									<label for="niveau">Quel est ton niveau?<sup
											class="requiredstar">*</sup>:
									</label>
									<@form.select class="required" id="niveau" path="niveau">
										<@form.option value="">--Veuillez choisir--</@form.option>
										<@form.option value="As des notions">As des notions</@form.option>
										<@form.option value="D&eacute;butant">D&eacute;butant</@form.option>
										<@form.option value="Confortable">Confortable</@form.option>
										<@form.option value="Interm&eacute;daire">Interm&eacute;daire</@form.option>
										<@form.option value="Experiment&eacute;">Experiment&eacute;</@form.option>
									</@form.select>
								</div>
								<div class="fields">
								<label for="referrant">Comment as-tu entendu parler de
										nous?<sup class="requiredstar">*</sup>:
									</label>
									<@form.select class="required" id="referrant" path="referrant">
										<@form.option value="">--Veuillez choisir--</@form.option>
										<@form.option value="Google">Google</@form.option>
										<@form.option value="Journal0537">Journal 0537</@form.option>
										<@form.option value="JournalIntermediaire">Journal
											L'Interm&eacute;diaire</@form.option>
										<@form.option value="Facebook">Facebook</@form.option>
										<@form.option value="Twitter">Twitter</@form.option>
										<@form.option value="AutreSite">Un autre site (blog, forum,
											etc.)</@form.option>
										<@form.option value="BoucheOreil">Bouche &agrave; oreil</@form.option>
										<@form.option value="SokoMaroc">Soko Maroc</@form.option>
										<@form.option value="Autre">Autre</@form.option>
									</@form.select>
								</div>		
							</div>
							<br><br>
								<div style="margin-left:400px;">
									<input value="Je r&eacute;serve!" type="submit" class="btn btn-primary" />
								</div>
							<br><br>
						</div>
					</div>
					
				</div>
			</div>
			<div class="span1"></div>
		</div>
	</div>
</@form.form>
<#include "footer.ftl">
