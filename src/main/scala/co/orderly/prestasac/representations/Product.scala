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
import java.util.{Date => JDate}
import java.lang.{Float => JFloat}
import java.lang.{Integer => JInteger}
import java.lang.{Long => JLong}

import co.orderly.prestasac.BigDecimalAdapter

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
import marshallers.jaxb.types.DateSpaceTimeAdapter

// Prestasac
import shared._

/**
 * The Product representation holds the information pertaining to a
 * product in the PrestaShop catalogue.
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
class Product extends Representation {

  @xmlElement(required = true)
  var product: ProductElement = _
}

/**
 * The ProductElement holds the core fields for the order.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class ProductElement extends PrestaShopTimestampedIdentity {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------
  var idManufacturer: PrestaShopXLink = _
  var idCategoryDefault: PrestaShopXLink = _

  // TODO: add not_filterable attribute
  var idDefaultCombination: PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------
  var idSupplier: String = _
  var outOfStock: JInteger = _

  // TODO: add in <new>. No idea what data type it should be. But it's nillable
  var cacheDefaultAttribute: JInteger = _

  // TODO: add in <id_default_image>. No idea on datatype. Has not_filterable attribute

  // TODO: add not_filterable attribute
  var positionInCategory: JInteger = _
  var manufacturerName: String = _
  var reference: String = _
  var supplierReference: String = _

  // TODO: add location. No idea on datatype
  var ean13: String = _
  var upc: String = _

  // TODO: add unity. Not sure what it is

  // TODO: add id_tax_rules_group

  // TODO: add id_color_default
  var minimalQuantity: JInteger = _
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var price: BigDecimal = _
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var additionalShippingCost: BigDecimal = _
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var wholesalePrice: BigDecimal = _
  var onSale: JInteger = _
  var onlineOnly: JInteger = _
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var ecotax: BigDecimal = _

  // TODO: check assumption that <unit_price> is a float (it probably is)
  @xmlElement(nillable = true)
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var unitPrice: BigDecimal = _
  var width: JInteger = _
  var height: JInteger = _
  var depth: JInteger = _
  var weight: JInteger = _
  var quantityDiscount: JInteger = _
  var customizable: JInteger = _
  var uploadableFiles: JInteger = _
  var textFields: JInteger = _
  var active: JInteger = _
  var availableForOrder: JInteger = _
  var condition: String = _
  var showPrice: JInteger = _
  var indexed: JInteger = _
  var cacheIsPack: JInteger = _
  var cacheHasAttachment: JInteger = _
  var quantity: JInteger = _

  // TODO: add in <meta_description>

  // TODO: add in <meta_keywords>

  // TODO: add in <meta_title>

  // TODO: add in <link_rewrite>

  // TODO: add in <name>

  // TODO: add in <available_now>

  // TODO: add in <available_later>

  // TODO: add in <description>

  // TODO: add in <description_short>

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: add in <categories>

  // TODO: add in the other associations
}
