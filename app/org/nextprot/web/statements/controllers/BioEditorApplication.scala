package org.nextprot.web.statements.controllers

import scala.collection.JavaConverters.mapAsScalaMapConverter

import org.nextprot.commons.statements.Statement
import org.nextprot.commons.statements.StatementField
import org.nextprot.parsers.bed.converter.BedServiceStatementConverter

import play.api.http.ContentTypes
import play.api.libs.json.Json
import play.api.libs.json.Json.prettyPrint
import play.api.libs.json.Json.toJson
import play.api.libs.json.Writes
import play.api.mvc.Action
import play.api.mvc.Controller

class BioEditorApplication extends Controller {

  //BedServiceStatementConverter.setProxyDir("/Users/dteixeira/Documents/bed/");

  implicit val rawStatementWrites = new Writes[Statement] {
    def writes(statement: Statement) = Json.toJson(statement.asScala);
  }

  def statements(report: String) = Action {
    val statements = BedServiceStatementConverter.convertAll();
    if (report == null) {
      Ok(prettyPrint(toJson(statements))).as(ContentTypes.JSON)
    } else {
      val notes = statements.filter(_.getValue(StatementField.DEBUG_NOTE) != null)
      Ok(prettyPrint(toJson(notes))).as(ContentTypes.JSON);
    }
  }

  def geneStatements(geneName: String, report: String) = Action {
    val statements = BedServiceStatementConverter.convert(geneName.toLowerCase());
    if (report == null) {
      Ok(prettyPrint(toJson(statements))).as(ContentTypes.JSON)
    } else {
      val notes = statements.filter(_.getValue(StatementField.DEBUG_NOTE) != null)
      Ok(prettyPrint(toJson(notes))).as(ContentTypes.JSON);
    }
  }

}
