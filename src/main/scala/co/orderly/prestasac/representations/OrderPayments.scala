package co.orderly.prestasac.representations

import co.orderly.narcolepsy.Representation
import co.orderly.narcolepsy.marshallers.jaxb.moxy.CamelCase2Underscore
import co.orderly.prestasac.BigDecimalAdapter
import javax.xml.bind.annotation.{XmlAccessType, XmlAccessorType, XmlRootElement}
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

import java.lang.{Float => JFloat, Integer => JInteger, Long => JLong}
import java.util.{Collection => JCollection, Date => JDate, List => JList}
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters

/**
  * Created with IntelliJ IDEA.
  * User: Victor Mercurievv
  * Date: 7/9/2018
  * Time: 6:27 PM
  * Contacts: email: mercurievvss@gmail.com Skype: 'grobokopytoff' or 'mercurievv'
  */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
case class OrderPayments(
  @xmlElement(required = true)
  var order_payment: OrderPaymentsElement
                        ) extends Representation {
private def this() = this(null)
}

case class OrderPaymentsElement(
                                 var id_order_payment: JLong,
                                 var order_reference: String,
                                 var transaction_id: String,
                                 @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
                                 var amount: BigDecimal,
                                 var payment_method: String,
                               ){
  private def this() = this(null, null, null, null, null)
}
