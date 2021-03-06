/*
 * Copyright (c) 2012 Orderly Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package co.orderly.prestasac.representations

// Java
import java.lang.{Integer => JInteger}
import java.lang.{Integer => JLong}
import java.util.{Date => JDate}

// Scala
import scala.beans.BeanProperty

// JAXB
import javax.xml.bind.annotation._
import adapters.XmlJavaTypeAdapter

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import marshallers.jaxb.moxy.CamelCase2Underscore
import marshallers.jaxb.types.DateSpaceTimeAdapter

// Prestasac
import shared._

/**
 * The Customer representation holds the information pertaining to a
 * customer in PrestaShop.
 *
 * A typical representation looks something like this:
 *
 * <?xml version="1.0" encoding="UTF-8"?>
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <customer>
 *     <id><![CDATA[30]]></id>
 *     <id_default_group xlink:href="http://www.psychicbazaar.com/api/groups/1"><![CDATA[1]]></id_default_group>
 *     <newsletter_date_add></newsletter_date_add>
 *     <ip_registration_newsletter></ip_registration_newsletter>
 *     <last_passwd_gen><![CDATA[2012-10-03 11:41:50]]></last_passwd_gen>
 *     <secure_key><![CDATA[267558046eb890312511804d2ca0668e]]></secure_key>
 *     <deleted><![CDATA[0]]></deleted>
 *     <passwd><![CDATA[2d62ca3847bd8c046b4bf6a677dee403]]></passwd>
 *     <lastname><![CDATA[Dean]]></lastname>
 *     <firstname><![CDATA[Alexander]]></firstname>
 *     <email><![CDATA[keptest3@keplarllp.com]]></email>
 *     <note></note>
 *     <id_gender><![CDATA[9]]></id_gender>
 *     <birthday></birthday>
 *     <newsletter><![CDATA[0]]></newsletter>
 *     <optin><![CDATA[0]]></optin>
 *     <active><![CDATA[1]]></active>
 *     <is_guest><![CDATA[0]]></is_guest>
 *     <date_add><![CDATA[2012-10-03 17:41:50]]></date_add>
 *     <date_upd><![CDATA[2012-10-03 17:41:50]]></date_upd>
 *   </customer>
 * </prestashop>
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class Customer(
                     @xmlElement(required = true)
                     var customer: CustomerElement,
                   ) extends Representation {

  private def this() = this(null)
}

/**
 * The CustomerElement holds the core fields for the address.
 */
@XmlAccessorType(XmlAccessType.FIELD)
case class CustomerElement(
                     

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: retrieve the xlink:href as well
  var idDefaultGroup: PrestaShopXLink, // JLong,

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @xmlElement(nillable = true)
  @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
  var newsletterDateAdd: JDate,

  @xmlElement(nillable = true)
  var ipRegistrationNewsletter: String,

  @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
  var lastPasswdGen: JDate,
  var secureKey: String,
  var deleted: JInteger,
  var passwd: String,

  @xmlElement(name = "lastname")
  var lastName: String,

  @xmlElement(name = "firstname")
  var firstName: String,
  var email: String,

  @xmlElement(nillable = true)
  var note: String,
  var idGender: JInteger,

  // TODO: add in birthday field (left out as not sure of type). It's nillable though
  var newsletter: JInteger,
  var optin: JInteger,
  var active: JInteger,
  var isGuest: JInteger,

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  // None
  ) extends PrestaShopTimestampedIdentity with Representation {
  private def this() = this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
}
