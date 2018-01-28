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
import java.lang.{Float => JFloat}
import java.lang.{Integer => JInteger}

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
 * The Currency representation holds the information pertaining to a
 * currency in PrestaShop.
 *
 * A typical representation looks like this:
 *
 * <?xml version="1.0" encoding="UTF-8"?>
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <currency>
 *	   <id><![CDATA[13]]></id>
 *	   <name><![CDATA[Pound]]></name>
 *	   <iso_code><![CDATA[GBP]]></iso_code>
 *	   <iso_code_num><![CDATA[826]]></iso_code_num>
 *	   <sign><![CDATA[£]]></sign>
 *	   <blank><![CDATA[0]]></blank>
 *	   <format><![CDATA[1]]></format>
 *	   <decimals><![CDATA[1]]></decimals>
 *	   <conversion_rate><![CDATA[1.000000]]></conversion_rate>
 *	   <deleted><![CDATA[0]]></deleted>
 *	   <active><![CDATA[1]]></active>
 *   </currency>
 * </prestashop>
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class Currency(

                     @xmlElement(required = true)
                     var currency: CurrencyElement,

                   ) extends Representation {

  private def this() = this(null)
}

/**
 * The CurrencyElement holds the core fields for the currency.
 */
@XmlAccessorType(XmlAccessType.FIELD)
case class CurrencyElement(


  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // None

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------
  var name: String,
  var isoCode: String,
  var isoCodeNum: String,
  var sign: String,
  var blank: JInteger,
  var format: JInteger,
  var decimals: JInteger,
  var conversionRate: JFloat,
  var deleted: JInteger,
  var active: JInteger,
  ) extends PrestaShopIdentity {
  private def this() = this(null, null, null, null, null, null, null, null, null, null)
}