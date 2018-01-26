package co.orderly.prestasac.representations.shared

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
// Java
import java.lang.{Long => JLong}

// Scala
import scala.beans.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import co.orderly.narcolepsy.Representation

@XmlAccessorType(XmlAccessType.FIELD)
class PrestaShopListXLink extends Representation {

  @XmlAttribute // ID is a custom attribute
  @BeanProperty
  var id: JLong = _

  @XmlAttribute(namespace = "http://www.w3.org/1999/xlink") // Href is an xlink: attribute
  @BeanProperty
  var href: String = _


  override def equals(other: Any): Boolean = other match {
    case that: PrestaShopListXLink =>
      (that canEqual this) &&
        id == that.id &&
        href == that.href
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[PrestaShopListXLink]

  override def toString = s"PrestaShopListXLink($id, $href, $hashCode)"

  override def hashCode(): Int = {
    val state = Seq(id, href)
    state.filterNot(_ == null).map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
