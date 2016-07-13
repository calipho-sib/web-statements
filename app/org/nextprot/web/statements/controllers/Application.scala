package org.nextprot.web.statements.controllers

import play.api.libs.json.Json
import play.api.mvc.Action
import play.api.mvc.Controller
import org.nextprot.parsers.bed.converter.BedServiceStatementConverter
import play.api.libs.json.Writes
import org.nextprot.commons.statements.RawStatement
import org.nextprot.commons.statements.StatementField

import scala.collection.JavaConverters._
import play.api.http.ContentTypes

class Application extends Controller {

  implicit val rawStatementWrites = new Writes[RawStatement] {
    def writes(statement: RawStatement) = Json.toJson(statement.getKeyValuesMap.asScala);
  }
/*  
  def listBooks = Action {
    val json = Json.toJson(BedServiceStatementConverter.convert("msh2"));
    Ok(Json.prettyPrint(json)).as(ContentTypes.JSON)
  }
  
  def statementsForEntry (entryAccession :String) = Action {
    Ok(Json.toJson(BedServiceStatementConverter.convert("msh2")))
  }*/

  def geneStatements (geneName :String) = Action {
    val json = Json.toJson(BedServiceStatementConverter.convert(geneName.toLowerCase()));
    Ok(Json.prettyPrint(json)).as(ContentTypes.JSON)
  }

}
