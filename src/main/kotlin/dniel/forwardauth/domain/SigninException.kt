package dniel.forwardauth.domain

import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

class SigninException : WebApplicationException {
    constructor(error: String, description: String? = "no message") : super(
            Response.status(Response.Status.BAD_REQUEST)
                    .entity("${error}: ${description}")
                    .type(MediaType.APPLICATION_JSON)
                    .build())
}