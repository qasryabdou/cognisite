<#include "header.ftl">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span4">
				<img src="${contextPath}/static/img/logo.png" alt="Cognicap" />
			</div>
			<div class="span8">
				<header class="jumbotron subhead" id="overview">
					<h2><@spring.message "layout.headline"/></h2>
					<p class="lead"><@spring.message "layout.shortline"/></p>
				</header>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12"></div>
		</div>
		<div class="row-fluid">
			<div class="span9">
				<div id="navWrap">
					<div id="slider" class="hero-unit">
						<div class="slides">
							<!-- Début premier slide -->
							<div class="features">
								<div class="mainCopy">
									<h3>Des formations et pr&eacute;paration &agrave; la
										certification JAVA par des Experts pour booster ta
										carri&egrave;re!</h3>
									<p>
										Cognicap rends l'apprentissage du JAVA facile et accessible
										&agrave; tous. Nous sommes des experts en JAVA et Technologies
										Web, tu es gagnant sur toute la ligne. <br /> <br />Nous te
										pr&eacute;parons pour passer la certification JAVA 5!
									</p>
									<p>Click sur les boutons 2 et 3 pour Booster ta
										carri&egrave;re!</p>
								</div>
								<div class="clientPics">
									<img src="${contextPath}/static/img/lemondeestavous.jpg"
										alt="Le monde est &agrave; vous" />
								</div>
							</div>
							<!-- Début slide 2 -->
							<div class="features">
								<div class="mainCopy">
									<h3>Chez Cognicap les formations sont donn&eacute;es par
										des Experts JAVA certifi&eacute;!</h3>
									<p>
										Choisis ta formation parmis la <a href="formations.ftl">liste
											des formations</a> disponibles et booste ta carri&egrave;re! <br />
									</p>
									<div class="trialButton">
										<a href="inscription.ftl" title="Inscrit toi gratuitement">
											<img src="${contextPath}/static/img/jeMinscrit.png"
											alt="Inscrit toi gratuitement" />
										</a>
									</div>
								</div>
								<div class="clientPics">
									<img
										src="${contextPath}/static/img/booste-ta-carriere-final.jpg"
										alt="Booster!" />
								</div>
							</div>
							<!-- Début slide 3 -->
							<div class="features">
								<div class="mainCopy">
									<h3>Les horaires des formations sont flexibles. Consulte
										le calendrier et choisis l'horaire qui te convient!</h3>
									<p>Les formateurs Cognicap vous booste pour que chaque
										formation soit une bonne pr&eacute;paration &agrave; la
										certification.</p>
									<div class="trialButton">
										<a href="inscription.ftl" title="Inscrit toi gratuitement"><img
											src="${contextPath}/static/img/jeMinscrit.png"
											alt="Inscrit toi gratuitement" /></a>
									</div>
								</div>
								<div class="clientPics">
									<img src="${contextPath}/static/img/apprenezviteetbien2.jpg"
										alt="S'inscrire" />
								</div>
							</div>
						</div>
					</div>
					<div id="sliderNav">
						<span class="slide1"><a href="javascript:"
							title="D&eacute;couvrez le JAVA" class="slide1 active" rel="1"></a></span>
						<span class="slide2"><a href="javascript:"
							title="Expert Formation JAVA The Cognicap Way" class="slide2"
							rel="2"></a></span> <span class="slide3"><a href="javascript:"
							title="Formation donnant des r&eacute;sultats!" class="slide3"
							rel="3"></a></span> <span class="slide4"></span> <span class="slide5"></span>
						<span class="slide6"></span>
					</div>
				</div>
			</div>
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Latest training!</li>
						<li class="active"><a href="#">Java Preparation
								certification, Rabat</a></li>
						<li><a href="#">JEE, Web component developer, Rabat</a></li>
						<li><a href="#">Android, Rabat</a></li>
						<li><a href="#">HTML5, Tanger</a></li>
						<li><a href="#">More active training...</a></li>
						<li class="nav-header">Pending groups!</li>
						<li><a href="#">Link</a>Weblogic, Casablanca</li>
						<li><a href="#">Link</a>UML, Rabat</li>
						<li><a href="#">Link</a>Scala, Casablanca</li>
						<li><a href="#">More pending groups...</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<#include "footer.ftl">