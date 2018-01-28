package co.orderly.prestasac

import javax.xml.bind.annotation.{XmlAttribute, XmlElement, XmlElementWrapper}
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

import scala.annotation.meta.field

/**
  * Created with IntelliJ IDEA.
  * User: Victor Mercurievv
  * Date: 1/28/2018
  * Time: 1:35 AM
  * Contacts: email: mercurievvss@gmail.com Skype: 'grobokopytoff' or 'mercurievv'
  */
package object representations {
  type xmlElement     = XmlElement @field
  type xmlAttribute     = XmlAttribute @field
  type xmlTypeAdapter = XmlJavaTypeAdapter @field
  type xmlJavaTypeAdapter = XmlJavaTypeAdapter @field
  type xmlElementWrapper = XmlElementWrapper @field

}
