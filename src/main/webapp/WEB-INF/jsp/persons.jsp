<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1">
</HEAD>
<BODY>
	<div
		style="position: absolute; overflow: hidden; left: 48px; top: -1px; width: 688px; height: 154px; z-index: 3">
	</DIV>
	<div
		style="position: absolute; overflow: hidden; left: 48px; top: -3px; width: 689px; height: 21px; z-index: 4">
	</DIV>
	<div
		style="position: absolute; overflow: hidden; left: 48px; top: 151px; width: 688px; height: 10px; z-index: 5">
	</DIV>
	<div
		style="position: absolute; overflow: hidden; left: 51px; top: 750px; width: 689px; height: 32px; z-index: 6">
	</DIV>
	<div
		style="position: absolute; overflow: hidden; left: 51px; top: 771px; width: 689px; height: 58px; z-index: 0; background-color: #BC211C">
	</DIV>
	<div
		style="position: absolute; overflow: hidden; left: 118px; top: 48px; width: 207px; height: 63px; z-index: 8">
		<FONT style="font-size: 13px" color="#000000" face="Tahoma">
			<DIV align=center></DIV>
			<DIV align=center></DIV>
		</FONT>
	</DIV>
	<div
		style="position: absolute; overflow: hidden; left: 240px; top: 186px; width: 491px; height: 551px; z-index: 9">
		<FONT style="font-size: 13px" color="#000000" face="Tahoma">
			<DIV>
				<TABLE bgcolor="#AAA" border=1 cellpadding=0
					bordercolor="#FFFFFF" cellspacing=0>
					<TR valign=top>
						<TD width=100><FONT style="font-size: 13px" color="#000000"
							face="Tahoma">

								<DIV align=center>
									<FONT color="#FFFF00"><B>Name</B></FONT>
								</DIV>
						</FONT></TD>
						<TD width=100><FONT style="font-size: 13px" color="#000000"
							face="Tahoma">
								<DIV align=center>
									<FONT color="#FFFF00"><B>HomeTown</B></FONT>
								</DIV>
						</FONT></TD>
						<TD width=100><FONT style="font-size: 13px" color="#000000"
							face="Tahoma">
								<DIV align=center>
									<FONT color="#FFFF00"><B>Age</B></FONT>
								</DIV>
						</FONT></TD>
					</TR>
					<c:forEach var="person" items="${persons}">
						<TR valign=top>
							<TD width=100><FONT style="font-size: 13px" color="#AAA"
								face="Tahoma">
									<DIV align=center>
										<FONT color="#FFF"><B>${person.name}</B></FONT>
									</DIV>
							</FONT></TD>
							<TD width=100><FONT style="font-size: 13px" color="#000"
								face="Tahoma">
									<DIV align=center>
										<FONT color="#FFF"><B>${person.homeTown}</B></FONT>
									</DIV>
							</FONT></TD>
							<TD width=100><FONT style="font-size: 13px" color="#000"
								face="Tahoma">
									<DIV align=center>
										<FONT color="#FFF"><B>${person.age}</B></FONT>
									</DIV>
							</FONT></TD>
						</TR>

					</c:forEach>
				</TABLE>

			</DIV>
		</FONT>
	</DIV>
</BODY>
</HTML>
