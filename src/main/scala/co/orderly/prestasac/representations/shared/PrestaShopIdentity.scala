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
package co.orderly.prestasac.representations.shared

// Java
import java.util.{Date => JDate}
import java.lang.{Long => JLong}

import co.orderly.narcolepsy.Representation

// Scala
import scala.beans.BeanProperty

// JAXB
import javax.xml.bind.annotation._
import adapters.XmlJavaTypeAdapter

// Narcolepsy
import co.orderly.narcolepsy.marshallers.jaxb.types.DateSpaceTimeAdapter

/**
 * The only field shared by all (singular) PrestaShop representations is id
 */
@XmlAccessorType(XmlAccessType.FIELD)
trait PrestaShopIdentity extends Representation {

  @xmlElement(required = true)
  val id: JLong = 0L
}
