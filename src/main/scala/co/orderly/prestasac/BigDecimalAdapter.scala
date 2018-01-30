package co.orderly.prestasac

import javax.xml.bind.annotation.adapters.XmlAdapter

/**
  * Created with IntelliJ IDEA.
  * User: Victor Mercurievv
  * Date: 1/30/2018
  * Time: 1:53 PM
  * Contacts: email: mercurievvss@gmail.com Skype: 'grobokopytoff' or 'mercurievv'
  */
class BigDecimalAdapter extends XmlAdapter[String, BigDecimal]{
  override def unmarshal(v: String): BigDecimal = BigDecimal(v)

  override def marshal(v: BigDecimal): String = v.toString()
}
