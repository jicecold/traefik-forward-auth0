package dniel.forwardauth

import dniel.forwardauth.infrastructure.endpoints.AppExceptionMapper
import dniel.forwardauth.infrastructure.endpoints.AuthorizeEndpoint
import dniel.forwardauth.infrastructure.endpoints.ServerFaultExceptionMapper
import dniel.forwardauth.infrastructure.endpoints.SigninEndpoint
import org.glassfish.jersey.server.ResourceConfig
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication


/**
 * 8888888888                                                  888        d8888          888    888
 * 888                                                         888       d88888          888    888
 * 888                                                         888      d88P888          888    888
 * 8888888  .d88b.  888d888 888  888  888  8888b.  888d888 .d88888     d88P 888 888  888 888888 88888b.
 * 888     d88""88b 888P"   888  888  888     "88b 888P"  d88" 888    d88P  888 888  888 888    888 "88b
 * 888     888  888 888     888  888  888 .d888888 888    888  888   d88P   888 888  888 888    888  888
 * 888     Y88..88P 888     Y88b 888 d88P 888  888 888    Y88b 888  d8888888888 Y88b 888 Y88b.  888  888
 * 888      "Y88P"  888      "Y8888888P"  "Y888888 888     "Y88888 d88P     888  "Y88888  "Y888 888  888
 *
 * ${Ansi.RED} :: Version ${spring-boot.formatted-version} :: ${Ansi.DEFAULT}
 *
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(AuthProperties::class)
class AuthApplication(val auth: AuthProperties) : ResourceConfig() {
    private val LOGGER = LoggerFactory.getLogger(this.javaClass)

    init {
        register(AppExceptionMapper::class.java)
        register(ServerFaultExceptionMapper::class.java)
        register(AuthorizeEndpoint::class.java)
        register(SigninEndpoint::class.java)

        LOGGER.info(auth.toString());
    }

}

fun main(args: Array<String>) {
    val applicationContext = runApplication<AuthApplication>(*args)
}