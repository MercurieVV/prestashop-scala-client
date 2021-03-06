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
package co.orderly.prestasac.representations.wrappers

// Java
import java.util.{List => JList}

import co.orderly.prestasac.representations._

import scala.beans.BeanProperty

// Scala
import scala.collection.mutable.{Buffer, ArrayBuffer}
import scala.collection.JavaConversions._

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import co.orderly.narcolepsy._

// Prestasac
import co.orderly.prestasac.representations.shared.PrestaShopListXLink

@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
class ProductList extends RepresentationWrapper[ProductListXLink] {

  type rtype = ProductListXLink
  var products: Products = _

  def toList: List[ProductListXLink] = this.products.productLinks.toList

  def fromList(productLinks: List[ProductListXLink]) {
    val p = new Products()
    p.productLinks = productLinks.toBuffer
    p
  }
}

@XmlType(name = "")
@XmlRootElement(name = "products")
class Products {

  var productLinks: Buffer[ProductListXLink] = ArrayBuffer[ProductListXLink]()

  @xmlElement(name = "product", required = true)
  def getProducts: JList[ProductListXLink] = this.productLinks

  def setProducts(products: JList[ProductListXLink]) {
    this.productLinks = productLinks
  }
}
import java.lang.{Long => JLong}

@xmlElement(name = "product", required = true)
@XmlAccessorType(XmlAccessType.FIELD)
class ProductListXLink(
                        @xmlAttribute // ID is a custom attribute
                        override val id: JLong,

                        @xmlAttribute(namespace = "http://www.w3.org/1999/xlink") // Href is an xlink: attribute
                        override val href: String,

                      ) extends PrestaShopListXLink(id, href)
