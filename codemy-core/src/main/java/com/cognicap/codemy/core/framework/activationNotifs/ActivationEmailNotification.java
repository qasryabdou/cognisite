/*
 *  Cognicap Website
 *  Copyright (C) 2010 Cognicap SARL
 *  www.cognicap.com
 *
 *  Licensed under the GPL, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://gplv3.fsf.org/
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.cognicap.codemy.core.framework.activationNotifs;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognicap.codemy.core.framework.MailingConfiguration;
import com.cognicap.codemy.core.framework.notifications.RegistrationEmailNotification;
import com.cognicap.codemy.core.persistence.domain.UserAccount;

/**
 * @version $Id$
 * @since 0.9
 */
public class ActivationEmailNotification implements ActivationNotification {
	/**
	 * Log4j logger that records events for this class
	 */
	private final Logger LOGGER = LoggerFactory
			.getLogger(RegistrationEmailNotification.class);

	MailingConfiguration mailingConfiguration;

	public MailingConfiguration getMailingConfiguration() {
		return mailingConfiguration;
	}

	public void setMailingConfiguration(
			MailingConfiguration mailingConfiguration) {
		this.mailingConfiguration = mailingConfiguration;
	}

	public void notifyActivation(UserAccount ua) throws Exception {

		Properties props = new Properties();
		props.put("mail.transport.protocol", mailingConfiguration.getProtocol());
		props.put("mail.smtps.auth", mailingConfiguration.getAuth());
		props.put("mail.smtps.port", mailingConfiguration.getPort());
		Session session = Session.getDefaultInstance(props, null);
		Transport t = null;

		String activationLink = "<a href='http://localhost:8080/cognicap.com/AccountActivation?key="
				+ ua.getActivationKey()
				+ "'>localhost:8080/cognicap.com/AccountActivation?key="
				+ ua.getActivationKey() + "</a>";
		String loginLink = "<a href='http://localhost:8080/cognicap.com/login/'>login</a>";

		StringBuilder messageBody = new StringBuilder();

		messageBody.append("<h3>Bonjour " + ua.getPrenom() + " !</h3>");
		messageBody
				.append("<p>Thanks for you registration at Cognicap.Please click the link above to confirm your email and activate your account :</p> ");
		messageBody.append("<strong>" + activationLink + "</strong>");
		messageBody
				.append("<p>If a click does not work, please copy the link to your web browser.</p>");
		messageBody.append("<p>After confirmation you can login at <strong>"
				+ loginLink + "</strong> with your user data.</p>");
		messageBody.append("<h4>Have a great day,</h4>");
		messageBody.append("<a href='www.cognicap.com'>cognicap.com</a>");

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailingConfiguration.getFrom()));
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(ua.getEmail(), false));
			message.setSubject("Cognicap - Account activation");
			message.setContent(messageBody.toString(), "text/html");
			t = session.getTransport();
			t.connect(mailingConfiguration.getHost(),
					mailingConfiguration.getUsername(),
					mailingConfiguration.getPassword());
			t.sendMessage(message, message.getAllRecipients());
		} catch (NoSuchProviderException nspe) {
			LOGGER.error("No such Transport Exception.", nspe);
		} catch (MessagingException me) {
			LOGGER.error("Exception of type MessageException.", me);
		} catch (Exception e) {
			LOGGER.error("Exception while sending email the registration.", e);
		} finally {
			if (t != null)
				t.close();
		}
	}

}