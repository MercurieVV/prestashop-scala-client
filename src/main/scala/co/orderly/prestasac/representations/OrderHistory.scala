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
import java.lang.{Long => JLong}
import java.lang.{Integer => JInteger}
import java.util.{Date => JDate}

import co.orderly.narcolepsy.marshallers.jaxb.types.DateSpaceTimeAdapter
import co.orderly.prestasac.representations.shared.xmlElement

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

@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class OrderHistory(
                         @xmlElement(required = true)
                  var orderHistory: OrderHistoryElement,

                ) extends Representation {

  private def this() = this(null)
}


@XmlAccessorType(XmlAccessType.FIELD)
case class OrderHistoryElement(
                         var id_employee: PrestaShopXLink, // JLong,
                         var id_order_state: PrestaShopXLink, // JLong,
                         var id_order: PrestaShopXLink, // JLong,
                         @xmlElement(required = true)
                         @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                         var dateAdd: JDate
                       ) extends PrestaShopIdentity {
  private def this() = this(null, null, null, null)
}