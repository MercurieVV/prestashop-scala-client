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
import java.util.{Collection => JCollection}
import java.util.{List => JList}

import scala.beans.BeanProperty

// Scala
import scala.collection.mutable.{Buffer, ArrayBuffer}
import scala.collection.JavaConversions._

// JAXB
import javax.xml.bind.annotation._

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import marshallers.jaxb.moxy.CamelCase2Underscore

// Prestasac
import shared._

/**
  * The Error representation holds the information pertaining to a
  * web service error which occurred in PrestaShop.
  *
  * A typical representation looks like this:
  *
  * <?xml version="1.0" encoding="UTF-8"?>
  * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
  * <errors>
  * <error>
  * <message><![CDATA[Internal error. To see this error please display the PHP errors.]]></message>
  * </error>
  * </errors>
  * </prestashop>
  */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
@XmlType(name = "") // TODO: delete this line if any issues
case class PrestaShopError(

                            var errors: Buffer[PrestaShopErrorRow] = ArrayBuffer[PrestaShopErrorRow]()


                          ) extends ErrorRepresentation {

  @xmlElementWrapper(name = "errors") // Needed to wrap <order_rows> around each <order_row>
  @xmlElement(name = "error", required = true)
  def getErrors: JList[PrestaShopErrorRow] = this.errors

  def setErrors(errors: JList[PrestaShopErrorRow]) {
    this.errors = errors
  }
private def this() = this(null)
}

/**
  * ErrorRow contains the information pertaining to an individual error within
  * the PrestaShopError representation.
  */
@XmlAccessorType(XmlAccessType.FIELD)
case class PrestaShopErrorRow(
                               var message: String
                             ) {
  private def this() = this(null)
}
