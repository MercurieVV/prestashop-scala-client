package co.orderly.prestasac.representations

import javax.xml.bind.annotation.{XmlAttribute, XmlElement, XmlValue}
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

import scala.annotation.meta.field

/**
  * Created with IntelliJ IDEA.
  * User: Victor Mercurievv
  * Date: 1/28/2018
  * Time: 4:44 PM
  * Contacts: email: mercurievvss@gmail.com Skype: 'grobokopytoff' or 'mercurievv'
  */
package object shared {
  type xmlElement     = XmlElement @field
  type xmlTypeAdapter = XmlJavaTypeAdapter @field
  type xmlAttribute = XmlAttribute @field
  type xmlValue = XmlValue @field

}
