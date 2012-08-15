<#include "header.ftl">
<!-- START BODY -->
<script type="text/javascript">
    window.onload = (function(){
        try{
            $(document).ready(function(){
                $("#contact_formulaire").validate();
            });
        }catch(e){}});
</script>
<form id="contact_formulaire" method="post" action="Reservation.ccap">
    <div id="bd" class="body-page">
        <div class="page-title">Posez-nous vos questions!</div>
        <div class="content-wrapper rounded">
            <div class="landing-page-menu rounded">
                <h2>L'&eacute;quipe Cognicap s'engage &agrave; vous r&eacute;pondre dans les 48H</h2>
            </div>
            <div class="content">
                <br/>
                <h3>&nbsp;&nbsp;Information personnel</h3>
                <div class="forumlaire-bloc-g">
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                        </div>
                        <div class="fields">
                            <span><input id="contact.civilite1" checked="on" name="contact.civilite" style="vertical-align: middle" type="radio" value="22"/>
                                <label for="contact.civilite1">Mr.</label></span>
                            <span>&nbsp;&nbsp;&nbsp;<input id="contact.civilite2" name="contact.civilite" style="vertical-align: middle" type="radio" value="23"/>
                                <label for="contact.civilite2">Mme.</label></span>
                            <span>&nbsp;&nbsp;&nbsp;<input id="contact.civilite4" name="contact.civilite" style="vertical-align: middle" type="radio" value="25"/>
                                <label for="contact.civilite4">Mlle</label></span>
                            <span>&nbsp;&nbsp;&nbsp;<input id="contact.civilite5" name="contact.civilite" style="vertical-align: middle" type="radio" value="26"/>
                                <label for="contact.civilite5">Dr.</label></span>
                            <span>&nbsp;&nbsp;&nbsp;<input id="contact.civilite6" name="contact.civilite" style="vertical-align: middle" type="radio" value="27"/>
                                <label for="contact.civilite6">Prof.</label></span>
                        </div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.prenom">Nom<sup class="requiredstar">*</sup>:
                            </label></div>
                        <div class="fields">
                            <input class="required" id="contact.nom" name="contact.nom" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.prenom">Pr&eacute;nom<sup class="requiredstar">*</sup>:
                            </label></div>
                        <div class="fields">
                            <input class="required" id="contact.prenom" name="contact.prenom" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.email">Email<sup class="requiredstar">*</sup>:
                            </label>
                        </div>
                        <div class="fields">
                            <input class="required email" id="contact.email" name="contact.email" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.compagnie">Compagnie:</label></div>
                        <div class="fields">
                            <input id="contact.organization" name="contact.compagnie" class="middle" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.referrant">Comment avez-vous entendu parler de nous?<sup class="requiredstar">*</sup>:
                            </label></div>
                        <div class="fields">
                            <select class="required" id="contact.referrant" name="contact.referrant">
                                <option value="">--Veuillez choisir--</option>
                                <option value="Google">Google</option>
                                <option value="Journal0537">Journal 0537</option>
                                <option value="JournalIntermediaire">Journal L'Interm&eacute;diaire</option>
                                <option value="Facebook">Facebook</option>
                                <option value="Twitter">Twitter</option>
                                <option value="AutreSite">Un autre site (blog, forum, etc.)</option>
                                <option value="BoucheOreil">Bouche &agrave; oreil</option>
                                <option value="SokoMaroc">Soko Maroc</option>
                                <option value="Autre">Autre</option></select></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.commentaire">Commentaires<sup class="requiredstar">*</sup>:
                            </label>
                        </div>
                        <div class="fields">
                            <textarea class="required" id="contact.commentaire" name="contact.commentaire" rows="4" cols="68"></textarea>
                        </div>
                    </div>
                </div>
                <div class="forumlaire-bloc-d">
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.telbureau">T&eacute;l&eacute;phone travail:
                            </label></div>
                        <div class="fields">
                            <input id="contact.telbureau" name="contact.telbureau" class="middle" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.mobile">T&eacute;l&eacute;phone portable<sup class="requiredstar">*</sup>:
                            </label></div>
                        <div class="fields">
                            <input class="required"  id="contact.mobile" name="contact.mobile" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.ville">Ville<sup class="requiredstar">*</sup>:
                            </label></div>
                        <div class="fields">
                            <input class="required" id="contact.entetechamp.ville" name="contact.entetechamp.ville" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.role">R&ocirc;le dans la compagnie:
                            </label></div>
                        <div class="fields">
                            <input id="contact.role" name="contact.role" class="middle" type="text" value="" size="30"/></div>
                    </div>
                    <div class="entreeformulaire">
                        <div class="entetechamp">
                            <label for="contact.profil">Quel est votre profil?<sup class="requiredstar">*</sup>:
                            </label></div>
                        <div class="fields">
                            <select class="required" id="contact.referrant" name="contact.profil">
                                <option value="">--Veuillez choisir--</option>
                                <option value="&Eacute;tudiant">&Eacute;tudiant</option>
                                <option value="Employ&eacute;">Employ&eacute;</option>
                                <option value="Formateur">Formateur</option>
                                <option value="Consultant">Consultant</option>
                                <option value="Partenaire potentiel">Partenaire potentiel</option>
                                <option value="Autre">Autre</option></select></div>
                    </div>
                </div>
                <div class="sectionEnvoyer">
                    <input value="Envoyez!" type="submit" />
                </div>
            </div>
        </div>
    </div>
</form>
<!-- END BODY -->
<!-- END headerWrap --></div>
<!-- END siteContainer --></div>
<!-- START FOOTER -->
<#include "footer.ftl">