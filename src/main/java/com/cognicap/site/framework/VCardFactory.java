package com.cognicap.site.framework;

import a_vcard.android.provider.Contacts;
import a_vcard.android.syncml.pim.vcard.ContactStruct;
import a_vcard.android.syncml.pim.vcard.VCardComposer;
import a_vcard.android.syncml.pim.vcard.VCardException;

/**
 * @version $Id$
 * @since 0.9
 */
public class VCardFactory extends DocumentFactory {

	@Override
	public VCard createDocument(IContact c) {
		VCard vcard = new VCard();
		VCardComposer composer = new VCardComposer();

		ContactStruct contact = new ContactStruct();
		contact.name = c.getNom() + " " + c.getPrenom();
		contact.addPhone(Contacts.Phones.TYPE_MOBILE, c.getMobile(), null, true);
		contact.addOrganization(0, c.getCompagnie(), null, true);

		// create vCard representation
		try {
			vcard.setCard(composer.createVCard(contact,
					VCardComposer.VERSION_VCARD30_INT));
		} catch (VCardException vce) {
			LOGGER.error("Exception while generating VCard for contact.", vce);
		}
		return vcard;
	}
}
