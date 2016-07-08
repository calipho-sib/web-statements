package org.nextprot.web.statements.controllers

import play.api.libs.json.Json
import play.api.mvc.Action
import play.api.mvc.Controller
import org.nextprot.parsers.bed.converter.BedServiceStatementConverter
import play.api.libs.json.Writes
import org.nextprot.commons.statements.RawStatement
import org.nextprot.commons.statements.StatementField

class Application extends Controller {

  implicit val rawStatementWrites = new Writes[RawStatement] {
    def writes(statement: RawStatement) = Json.obj(
      "cv_term_name" -> statement.getValue(StatementField.ANNOT_CV_TERM_NAME)
    )
  }
  
  def listBooks = Action {
    Ok(Json.toJson(BedServiceStatementConverter.convert("msh2")))
  }

}
