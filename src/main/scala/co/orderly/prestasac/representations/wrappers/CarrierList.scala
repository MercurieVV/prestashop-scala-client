/*
 * Copyright (c) 2012 Carrierly Ltd. All rights reserved.
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
package co.orderly.prestasac.representations.wrappers

// Java
import java.util.{List => JList}

import co.orderly.prestasac.representations._

// Scala
import scala.collection.mutable.{Buffer, ArrayBuffer}
import scala.collection.JavaConversions._
import scala.beans.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import co.orderly.narcolepsy._

// Prestasac
import co.orderly.prestasac.representations.shared.PrestaShopListXLink
import java.lang.{Long => JLong}



@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
case class CarrierList(
                 var carriers: Carriers

               ) extends RepresentationWrapper[CarrierListXLink] {

  type rtype = CarrierListXLink


  def toList: List[CarrierListXLink] = this.carriers.carrierLinks.toList

  def fromList(carrierLinks: List[CarrierListXLink]) {
    val p = new Carriers()
    p.carrierLinks = carrierLinks.toBuffer
    p
  }

  private def this() = this(null)
}

@XmlType(name = "")
@XmlRootElement(name = "carriers")
case class Carriers(
                   var carrierLinks: Buffer[CarrierListXLink] = ArrayBuffer[CarrierListXLink]()
                 ) {
  @xmlElement(name = "carrier", required = true)
  def getCarriers: JList[CarrierListXLink] = this.carrierLinks

  def setCarriers(carriers: JList[CarrierListXLink]) {
    this.carrierLinks = carrierLinks
  }

  private def this() = this(ArrayBuffer[CarrierListXLink]())
}

@xmlElement(name = "carrier", required = true)
@XmlAccessorType(XmlAccessType.FIELD)
case class CarrierListXLink(
                           @xmlAttribute // ID is a custom attribute
                           override val id: JLong,

                           @xmlAttribute(namespace = "http://www.w3.org/1999/xlink") // Href is an xlink: attribute
                           override val href: String,
                         ) extends PrestaShopListXLink(id, href) {
  private def this() = this(null, null)

}



