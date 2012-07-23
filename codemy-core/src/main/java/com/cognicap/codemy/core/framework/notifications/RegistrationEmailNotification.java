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
package com.cognicap.codemy.core.framework.notifications;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognicap.codemy.core.framework.Document;
import com.cognicap.codemy.core.framework.DocumentFactory;
import com.cognicap.codemy.core.framework.MailingConfiguration;
import com.cognicap.codemy.core.framework.Registration;
import com.cognicap.codemy.core.framework.RegistrationImplContactAdapter;
import com.cognicap.codemy.core.framework.DocumentFactory.DocumentType;

/**
 * @version $Id$
 * @since 0.9
 */
public class RegistrationEmailNotification implements RegistrationNotification {

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

	public void notifyRegistration(Registration registration) throws Exception {

		Document contactCard = DocumentFactory.getFactory(DocumentType.VCARD)
				.createDocument(
						new RegistrationImplContactAdapter(registration));

		LOGGER.debug(contactCard.toString());

		// StringBuilder vcf = new StringBuilder();
		StringBuilder emailBody = new StringBuilder();
		
		emailBody.append(registration);
		LOGGER.debug(emailBody.toString());

		Properties props = new Properties();
		props.put("mail.transport.protocol", mailingConfiguration.getProtocol());
		props.put("mail.smtps.auth", mailingConfiguration.getAuth());
		props.put("mail.smtps.port", mailingConfiguration.getPort());
		Session session = Session.getDefaultInstance(props, null);
		Transport t = null;

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailingConfiguration.getFrom()));
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(mailingConfiguration.getTo(), false));
			if (emailBody.indexOf("inscription") != -1)
				message.setSubject("Registration+1");
			else
				message.setSubject("Demande+1");

			// create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(emailBody.toString());

			MimeBodyPart attachementBodyPart = new MimeBodyPart();
			attachementBodyPart.setDataHandler(new DataHandler(
				    new ByteArrayDataSource(contactCard.toString().getBytes(), 
					"text/x-vcard; charset=utf-8'")));
			
			attachementBodyPart.setFileName(registration.getNom() + " "
					+ registration.getPrenom() + ".vcf");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachementBodyPart);

			// Put parts in message
			message.setContent(multipart);
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