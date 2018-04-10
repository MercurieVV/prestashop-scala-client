/*
 * Copyright (c) 2012 OrderCarrierly Ltd. All rights reserved.
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
case class OrderCarrierList(
                 var order_carriers: OrderCarriers

               ) extends RepresentationWrapper[PrestaShopListXLink] {

  type rtype = PrestaShopListXLink


  def toList: List[PrestaShopListXLink] = this.order_carriers.orderCarrierLinks.toList

  def fromList(orderCarrierLinks: List[PrestaShopListXLink]) {
    val p = new OrderCarriers()
    p.orderCarrierLinks = orderCarrierLinks.toBuffer
    p
  }

  private def this() = this(null)
}


@XmlType(name = "")
@XmlRootElement(name = "order_carriers")
case class OrderCarriers(
                     var orderCarrierLinks: Buffer[PrestaShopListXLink] = ArrayBuffer[PrestaShopListXLink]()
                   ) {
  @xmlElement(name = "order_carrier", required = true)
  def getOrderCarriers: JList[PrestaShopListXLink] = this.orderCarrierLinks

  def setOrderCarriers(orderCarriers: JList[PrestaShopListXLink]) {
    this.orderCarrierLinks = orderCarrierLinks
  }

  private def this() = this(ArrayBuffer[PrestaShopListXLink]())
}








