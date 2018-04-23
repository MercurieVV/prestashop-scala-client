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
import adapters.XmlJavaTypeAdapter

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import marshallers.jaxb.moxy.CamelCase2Underscore

// Prestasac
import shared._

/**
  * The Carrier representation holds the information pertaining to a
  * carrier (i.e. company that delivers orders) in PrestaShop.
  *
  * A typical representation looks like this:
  *
  * <?xml version="1.0" encoding="UTF-8"?>
  * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
  * <carrier>
  * <id><![CDATA[3]]></id>
  * <id_tax_rules_group><![CDATA[1]]></id_tax_rules_group>
  * <deleted><![CDATA[0]]></deleted>
  * <is_module><![CDATA[0]]></is_module>
  * <name><![CDATA[Free carrier]]></name>
  * <active><![CDATA[1]]></active>
  * <is_free><![CDATA[1]]></is_free>
  * <url></url>
  * <shipping_handling><![CDATA[1]]></shipping_handling>
  * <range_behavior><![CDATA[0]]></range_behavior>
  * <shipping_method><![CDATA[0]]></shipping_method>
  * <delay><language id="1" xlink:href="http://www.psychicbazaar.com/api/languages/1"><![CDATA[Delivery next day!]]></language></delay>
  * </carrier>
  * </prestashop>
  */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class Carrier(
                    @xmlElement(required = true)
                    var carrier: CarrierElement
                  ) extends Representation {

  private def this() = this(null)
}

/**
  * The CarrierElement holds the core fields for the carrier.
  */
@XmlAccessorType(XmlAccessType.FIELD)
case class CarrierElement(
                           // -------------------------------------------------------------------------------------------------------------------
                           // XLinks into other resources
                           // -------------------------------------------------------------------------------------------------------------------

                           // None
                           override val id: JLong,
                           // -------------------------------------------------------------------------------------------------------------------
                           // Resource-specific fields
                           // -------------------------------------------------------------------------------------------------------------------
                           var idTaxRulesGroup: JInteger,

                           var deleted: JInteger,
                           var isModule: JInteger,
                           var name: String,
                           var active: JInteger,
                           var isFree: JInteger,

                           @xmlElement(nillable = true)
                           var url: String,
                           var shippingHandling: JInteger,
                           var rangeBehaviour: JInteger,
                           var shippingMethod: JInteger

                           // TODO: add in delay. It's wrapped inside a <language> element
                           // @BeanProperty
                           // var delay: String

                         ) extends PrestaShopIdentity {

  private def this() = this(null,null, null, null, null, null, null, null, null, null, null)
}