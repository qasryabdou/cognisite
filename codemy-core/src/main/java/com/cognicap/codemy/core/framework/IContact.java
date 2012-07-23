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
package com.cognicap.codemy.core.framework;

/**
 * @version $Id$
 * @since 0.2
 */
public interface IContact {
	public String getNom();
	public void setNom(String nom);
	public String getPrenom();
	public void setPrenom(String prenom);
	public String getEmail();
	public void setEmail(String email);
	public String getMobile();
	public void setMobile(String mobile);
	public String getCompagnie();
	public void setCompagnie(String compagnie);
	public String getVille();
	public void setVille(String ville);
}
