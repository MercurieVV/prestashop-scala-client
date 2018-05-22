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
import java.lang.{Float => JFloat, Integer => JInteger, Long => JLong}
import java.util.{Collection => JCollection, Date => JDate, List => JList}
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters

import co.orderly.prestasac.BigDecimalAdapter

// Scala
import scala.beans.BeanProperty
import scala.collection.JavaConversions._
import scala.collection.mutable.{ArrayBuffer, Buffer}

// JAXB
import javax.xml.bind.annotation._
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import co.orderly.narcolepsy.marshallers.jaxb.moxy.CamelCase2Underscore
import co.orderly.narcolepsy.marshallers.jaxb.types.DateSpaceTimeAdapter

// Prestasac
import co.orderly.prestasac.representations.shared._


/**
  * The Order representation holds the information pertaining to an
  * order in PrestaShop.
  */

@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
case class OrderCarrier(
                         @xmlElement(required = true)
                         var order_carrier: OrderCarrierElement,

                       ) extends Representation {
  private def this() = this(null)
}


@XmlAccessorType(XmlAccessType.FIELD)
case class OrderCarrierElement(
                                override val id: JLong,

                                var id_order: PrestaShopXLink,

                                var id_carrier: PrestaShopXLink,

                                var id_order_invoice: JLong,

                                @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                                var weight: BigDecimal,

                                @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                                var shipping_cost_tax_excl: BigDecimal,

                                @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                                var shipping_cost_tax_incl: BigDecimal,

                                var tracking_number: String,

                                @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                                var date_add: JDate,

                              ) extends PrestaShopIdentity with Representation {
  private def this() = this(null, null, null, null, null, null, null, null, null)
}
