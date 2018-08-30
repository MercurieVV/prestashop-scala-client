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
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class Order(
                  @xmlElement(required = true)
                  var order: OrderElement,

                ) extends Representation {
  private def this() = this(null)
}

/**
  * The OrderElement holds the core fields for the order.
  */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class OrderElement(
                         // -------------------------------------------------------------------------------------------------------------------
                         // XLinks into other resources
                         // -------------------------------------------------------------------------------------------------------------------

                         // TODO: retrieve the xlink:href as well
                         var idAddressDelivery: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         var idAddressInvoice: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         var idCart: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         var idCurrency: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         var idLang: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         var idCustomer: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         var idCarrier: PrestaShopXLink, // JLong,

                         // -------------------------------------------------------------------------------------------------------------------
                         // Resource-specific fields
                         // -------------------------------------------------------------------------------------------------------------------
                         var module: String,
                         var invoiceNumber: JLong,
                         var deliveryNumber: JLong,

                         @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                         var invoiceDate: JDate,

                         @xmlElement(nillable = true)
                         @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                         var deliveryDate: JDate,
                         var valid: JInteger,

                         // TODO: fix current state (missing the attributes)
                         var currentState: JInteger,
                         var secureKey: String,
                         var payment: String,
                         var recyclable: JInteger,
                         var gift: JInteger,

                         @xmlElement(nillable = true)
                         var giftMessage: String,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalDiscounts: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalPaid: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalPaidTaxIncl: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalPaidReal: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalProducts: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalProductsWt: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalShipping: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalShippingTaxIncl: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var carrierTaxRate: BigDecimal,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var totalWrapping: BigDecimal,

                         @xmlElement(nillable = true)
                         var shippingNumber: JLong,
                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var conversionRate: BigDecimal,

                         @xmlElement(nillable = false)
                         var reference: String,

                         @xmlElement(nillable = true)
                         var return_order_id: String,
                         @xmlElement(nillable = true)
                         var return_imei: String,

                         @xmlElement(nillable = true)
                         var transaction_id: String,

                         @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                         var return_product_price: BigDecimal,


                         // -------------------------------------------------------------------------------------------------------------------
                         // Associations
                         // -------------------------------------------------------------------------------------------------------------------

                         @xmlElement(required = true)
                         var associations: Associations,
                       ) extends PrestaShopTimestampedIdentity with Representation {
  private def this() = this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
}

/**
  * Associations is a wrapper around the order's line items (aka order rows).
  */
@XmlType(name = "")
case class Associations(
                         var orderRows: Buffer[OrderRow] = ArrayBuffer[OrderRow]()
                       ) {


  @xmlElementWrapper(name = "order_rows") // Needed to wrap <order_rows> around each <order_row>
  @xmlElement(name = "order_row", required = true)
  def getOrderRows: JList[OrderRow] = this.orderRows

  def setOrderRows(orderRows: JList[OrderRow]) {
    this.orderRows = orderRows
  }

  private def this() = this(ArrayBuffer[OrderRow]())
}

/**
  * OrderRow contains the information pertaining to an individual line item
  * within an order.
  */
@XmlAccessorType(XmlAccessType.FIELD)
case class OrderRow(
                     var id: JLong,
                     var productId: JLong,
                     var productAttributeId: JLong,
                     var productQuantity: JInteger,
                     var productName: String,
                     @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                     var productPrice: BigDecimal,
                     var idp: JLong,
                     var productReference: String
                   ) {
  private def this() = this(0, 0, 0, 0, "", 0, 0, "")
}
