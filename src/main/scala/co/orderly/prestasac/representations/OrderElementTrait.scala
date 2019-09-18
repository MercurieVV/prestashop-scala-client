package co.orderly.prestasac.representations

import co.orderly.narcolepsy.Representation
import co.orderly.narcolepsy.marshallers.jaxb.types.DateSpaceTimeAdapter
import co.orderly.prestasac.BigDecimalAdapter
import co.orderly.prestasac.representations.shared.{PrestaShopTimestampedIdentity, PrestaShopXLink}
// Java
import java.lang.{Float => JFloat, Integer => JInteger, Long => JLong}
import java.util.{Collection => JCollection, Date => JDate, List => JList}
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters

/**
  * Created with IntelliJ IDEA.
  * User: Victor Mercurievv
  * Date: 12/21/2018
  * Time: 7:15 PM
  * Contacts: email: mercurievvss@gmail.com Skype: 'grobokopytoff' or 'mercurievv'
  */
trait OrderElementTrait[AS <: Associations] extends PrestaShopTimestampedIdentity with Representation {
  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------
  var idAddressDelivery: PrestaShopXLink
  var idAddressInvoice: PrestaShopXLink
  var idCart: PrestaShopXLink
  var idCurrency: PrestaShopXLink
  var idLang: PrestaShopXLink
  var idCustomer: PrestaShopXLink
  var idCarrier: PrestaShopXLink

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------
  var module: String
  var invoiceNumber: JLong
  var deliveryNumber: JLong

  @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
  var invoiceDate: JDate

  @xmlElement(nillable = true)
  @xmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
  var deliveryDate: JDate
  var valid: JInteger

  // TODO: fix current state (missing the attributes)
  var currentState: JInteger
  var secureKey: String
  var payment: String
  var recyclable: JInteger
  var gift: JInteger

  @xmlElement(nillable = true)
  var giftMessage: String
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalDiscounts: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalPaid: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalPaidTaxIncl: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalPaidReal: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalProducts: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalProductsWt: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalShipping: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalShippingTaxIncl: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var carrierTaxRate: BigDecimal
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var totalWrapping: BigDecimal

  @xmlElement(nillable = true)
  var shippingNumber: JLong
  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var conversionRate: BigDecimal

  @xmlElement(nillable = false)
  var reference: String

  @xmlElement(nillable = true)
  var return_order_id: String
  @xmlElement(nillable = true)
  var return_imei: String

  @xmlElement(nillable = true)
  var transaction_id: String

  @xmlJavaTypeAdapter(value = classOf[BigDecimalAdapter])
  var return_product_price: BigDecimal


  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  @xmlElement(required = true)
  var associations: AS

}
