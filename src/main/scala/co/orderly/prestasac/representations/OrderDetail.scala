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
import java.lang.{Float => BigDecimal, Integer => JInteger, Long => JLong}
import java.util.{Collection => JCollection, Date => JDate, List => JList}

import co.orderly.prestasac.BigDecimalAdapter

// Scala

// JAXB
import javax.xml.bind.annotation._

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
case class OrderDetail(
                        @xmlElement(required = true)
                         var order_detail: OrderDetailElement,

                       ) extends Representation {
  private def this() = this(null)
}

/**
  * The OrderElement holds the core fields for the order.
  */
@XmlAccessorType(XmlAccessType.FIELD)
case class OrderDetailElement(
                                // -------------------------------------------------------------------------------------------------------------------
                                // XLinks into other resources
                                // -------------------------------------------------------------------------------------------------------------------

                                // TODO: retrieve the xlink:href as well
                                var idOrder: PrestaShopXLink, // JLong,

                                // TODO: retrieve the xlink:href as well
                                var productId: PrestaShopXLink, // JLong,

                                // TODO: retrieve the xlink:href as well
                                var product_attribute_id: PrestaShopXLink, // JLong,


                                // -------------------------------------------------------------------------------------------------------------------
                                // Resource-specific fields
                                // -------------------------------------------------------------------------------------------------------------------
                                var product_quantity_reinjected: JLong,
                                var group_reduction: BigDecimal,
                                var discount_quantity_applied: JLong,

                                @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                                var download_deadline: JDate,

                                /*
                                                         @xmlElement(nillable = true)
                                                         @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
                                                         var deliveryDate: JDate,
                                */
                                var id_order_invoice: JInteger,

                                var id_warehouse: JInteger,

                                var id_shop: JInteger,
                                var product_name: String,

                                var product_quantity: JInteger,
                                var product_quantity_in_stock: JInteger,

                                var product_quantity_return: JInteger,
                                var product_quantity_refunded: JInteger,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var product_price: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var reduction_percent: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var reduction_amount: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var reduction_amount_tax_incl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var reduction_amount_tax_excl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var product_quantity_discount: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var unit_price_tax_incl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var unit_price_tax_excl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var total_price_tax_incl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var total_price_tax_excl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var total_shipping_price_tax_excl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var total_shipping_price_tax_incl: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var purchase_supplier_price: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var original_product_price: BigDecimal,
                                @xmlJavaTypeAdapter(value=classOf[BigDecimalAdapter])
                                var original_wholesale_price: BigDecimal,

                                // -------------------------------------------------------------------------------------------------------------------
                                // Associations
                                // -------------------------------------------------------------------------------------------------------------------

//                                @xmlElement(required = true)
//                                var associations: Associations,
                              ) extends PrestaShopTimestampedIdentity {
  private def this() = this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
}
