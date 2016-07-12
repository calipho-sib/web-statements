package org.nextprot.web.statements.controllers

import play.api.libs.json.Json
import play.api.mvc.Action
import play.api.mvc.Controller
import org.nextprot.parsers.bed.converter.BedServiceStatementConverter
import play.api.libs.json.Writes
import org.nextprot.commons.statements.RawStatement
import org.nextprot.commons.statements.StatementField

import scala.collection.JavaConverters._

class Application extends Controller {

  implicit val rawStatementWrites = new Writes[RawStatement] {
    def writes(statement: RawStatement) = Json.toJson(statement.getKeyValuesMap.asScala);
  }
  
  def listBooks = Action {
    Ok(Json.toJson(BedServiceStatementConverter.convert("msh2")))
  }
/*  
  def statementsForEntry (entryAccession :String) = Action {
    Ok(Json.toJson(BedServiceStatementConverter.convert("msh2")))
  }*/

  def geneStatements (geneName :String) = Action {
    Ok(Json.toJson(BedServiceStatementConverter.convert(geneName.toLowerCase())))
  }

}
