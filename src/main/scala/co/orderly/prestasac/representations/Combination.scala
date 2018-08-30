package co.orderly.prestasac.representations

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
  * Created with IntelliJ IDEA.
  * User: Victor Mercurievv
  * Date: 8/9/2018
  * Time: 5:53 PM
  * Contacts: email: mercurievvss@gmail.com Skype: 'grobokopytoff' or 'mercurievv'
  */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class Combination(
                        @xmlElement(required = true)
                        var order_detail: CombinationElement,

                      ) extends Representation {
  private def this() = this(null)
}

@XmlAccessorType(XmlAccessType.FIELD)
class CombinationElement(
                          @xmlElement(nillable = false)
                          var id: PrestaShopListXLink,
                          @xmlElement(nillable = false)
                          var reference: String,
                          @xmlElement(nillable = false)
                          var idp: JInteger,
                          @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                          var wholesale_price: BigDecimal,
                          @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                          var price: BigDecimal,
                        ) extends Representation {
  private def this() = this(null, null, null)
}
