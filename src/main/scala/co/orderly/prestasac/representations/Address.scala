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
import java.lang.{Long => JLong}

// Scala
import scala.beans.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import marshallers.jaxb.moxy.CamelCase2Underscore

// Prestasac
import shared._

/**
 * The Address representation holds the information pertaining to an
 * address in PrestaShop.
 * 
 * A typical representation looks a little like this:
 *
 * <?xml version="1.0" encoding="UTF-8"?>
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <address>
 *     <id><![CDATA[13]]></id>
 *     <id_customer xlink:href="http://www.psychicbazaar.com/api/customers/10"><![CDATA[10]]></id_customer>
 *     <id_manufacturer></id_manufacturer>
 *     <id_supplier></id_supplier>
 *     <id_country xlink:href="http://www.psychicbazaar.com/api/countries/1"><![CDATA[1]]></id_country>
 *     <id_state></id_state>
 *     <alias><![CDATA[My address]]></alias>
 *     <company></company>
 *     <lastname><![CDATA[lala]]></lastname>
 *     <firstname><![CDATA[john]]></firstname>
 *     <address1><![CDATA[wqeqwewq]]></address1>
 *     <address2></address2>
 *     <postcode><![CDATA[01999]]></postcode>
 *     <city><![CDATA[Berlin]]></city>
 *     <other></other>
 *     <phone></phone>
 *     <phone_mobile></phone_mobile>
 *     <dni></dni>
 *     <vat_number></vat_number>
 *     <deleted><![CDATA[0]]></deleted>
 *     <date_add><![CDATA[2012-09-07 10:41:26]]></date_add>
 *     <date_upd><![CDATA[2012-09-07 10:41:26]]></date_upd>
 *   </address>
 * </prestashop>
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class Address(
                    @xmlElement(required = true)
                    var address: AddressElement,

                  ) extends Representation {

  private def this() = this(null)
}

/**
 * The AddressElement holds the core fields for the address.
 */
@XmlAccessorType(XmlAccessType.FIELD)
case class AddressElement(
                         

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: retrieve the xlink:href as well
  @xmlElement(nillable = true)
  var idCustomer: PrestaShopXLink, // JLong,

  // TODO: retrieve the xlink:href as well
  @xmlElement(nillable = true)
  var idManufacturer: PrestaShopXLink, // JLong,

  // TODO: retrieve the xlink:href as well
  @xmlElement(nillable = true)
  var idSupplier: PrestaShopXLink, // JLong,

  // TODO: retrieve the xlink:href as well
  var idCountry: PrestaShopXLink, // JLong,

  // TODO: retrieve the xlink:href as well
  @xmlElement(nillable = true)
  var idState: PrestaShopXLink, // JLong,

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------
  var alias: String,

  @xmlElement(nillable = true)
  var company: String,

  @xmlElement(name = "lastname")
  var lastName: String,

  @xmlElement(name = "firstname")
  var firstName: String,
  var address1: String,

  @xmlElement(nillable = true)
  var address2: String,
  var postcode: String,
  var city: String,

  @xmlElement(nillable = true)
  var other: String,

  @xmlElement(nillable = true)
  var phone: String,

  @xmlElement(nillable = true)
  var phoneMobile: String,

  @xmlElement(nillable = true)
  var dni: String,

  @xmlElement(nillable = true)
  var vatNumber: String,
  var deleted: JInteger,

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  // None
  ) extends PrestaShopTimestampedIdentity {
  private def this() = this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
}
