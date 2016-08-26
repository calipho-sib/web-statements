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

  //BedServiceStatementConverter.addProxyDir("/Users/dteixeira/Documents/bed/");

  implicit val rawStatementWrites = new Writes[Statement] {
    def writes(statement: Statement) = Json.toJson(statement.asScala);
  }

  def statements(report: String) = Action {
    val result = BedServiceStatementConverter.convertAll();
    val statements = result._1;
    if (report == null) {
      Ok(prettyPrint(toJson(statements))).as(ContentTypes.JSON)
    } else {
      val notes = result._2;
      Ok(prettyPrint(toJson(notes))).as(ContentTypes.JSON);
    }
  }

  def geneStatements(geneName: String, report: String) = Action {
    val result = BedServiceStatementConverter.convert(geneName.toLowerCase());
    val statements = result._1;
    if (report == null) {
      Ok(prettyPrint(toJson(statements))).as(ContentTypes.JSON)
    } else {
      val notes = result._2;
      Ok(prettyPrint(toJson(notes))).as(ContentTypes.JSON);
    }
  }

}
