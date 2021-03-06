/**
  * NOTE: This class is auto generated by the akka-scala (beta) swagger code generator program.
  * https://github.com/swagger-api/swagger-codegen
  * For any issue or feedback, please open a ticket via https://github.com/swagger-api/swagger-codegen/issues/new
  */
package org.wso2.carbon.apimgt.rest.api.store.models

import org.joda.time.DateTime

case class Token(
                 /* Access token */
                 accessToken: Option[String],
                 /* Valid scopes for the access token */
                 tokenScopes: Option[Seq[String]],
                 /* Maximum validity time for the access token */
                 validityTime: Option[Long])
