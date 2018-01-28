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
case class OrderElement(
                         // -------------------------------------------------------------------------------------------------------------------
                         // XLinks into other resources
                         // -------------------------------------------------------------------------------------------------------------------

                         // TODO: retrieve the xlink:href as well
                         @BeanProperty
                         var idAddressDelivery: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         @BeanProperty
                         var idAddressInvoice: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         @BeanProperty
                         var idCart: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         @BeanProperty
                         var idCurrency: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         @BeanProperty
                         var idLang: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         @BeanProperty
                         var idCustomer: PrestaShopXLink, // JLong,

                         // TODO: retrieve the xlink:href as well
                         @BeanProperty
                         var idCarrier: PrestaShopXLink, // JLong,

                         // -------------------------------------------------------------------------------------------------------------------
                         // Resource-specific fields
                         // -------------------------------------------------------------------------------------------------------------------

                         @BeanProperty
                         var module: String,

                         @BeanProperty
                         var invoiceNumber: JLong,

                         @BeanProperty
                         var deliveryNumber: JLong,

                         @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                         @BeanProperty
                         var invoiceDate: JDate,

                         @xmlElement(nillable = true)
                         @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                         @BeanProperty
                         var deliveryDate: JDate,

                         @BeanProperty
                         var valid: JInteger,

                         // TODO: fix current state (missing the attributes)
                         @BeanProperty
                         var currentState: JInteger,

                         @BeanProperty
                         var secureKey: String,

                         @BeanProperty
                         var payment: String,

                         @BeanProperty
                         var recyclable: JInteger,

                         @BeanProperty
                         var gift: JInteger,

                         @xmlElement(nillable = true)
                         @BeanProperty
                         var giftMessage: String,

                         @BeanProperty
                         var totalDiscounts: JFloat,

                         @BeanProperty
                         var totalPaid: JFloat,

                         @BeanProperty
                         var totalPaidReal: JFloat,

                         @BeanProperty
                         var totalProducts: JFloat,

                         @BeanProperty
                         var totalProductsWt: JFloat,

                         @BeanProperty
                         var totalShipping: JFloat,

                         @BeanProperty
                         var carrierTaxRate: JFloat,

                         @BeanProperty
                         var totalWrapping: JFloat,

                         @xmlElement(nillable = true)
                         @BeanProperty
                         var shippingNumber: JLong,

                         @BeanProperty
                         var conversionRate: JFloat,

                         // -------------------------------------------------------------------------------------------------------------------
                         // Associations
                         // -------------------------------------------------------------------------------------------------------------------

                         @xmlElement(required = true)
                         @BeanProperty
                         var associations: Associations,
                       ) extends PrestaShopTimestampedIdentity {
  private def this() = this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
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

                     @BeanProperty
                     var id: JLong,

                     @BeanProperty
                     var productId: JLong,

                     @BeanProperty
                     var productAttributeId: JLong,

                     @BeanProperty
                     var productQuantity: JInteger,

                     @BeanProperty
                     var productName: String,

                     @BeanProperty
                     var productPrice: JFloat
                   ) {
  private def this() = this(0, 0, 0, 0, "", 0)
}
