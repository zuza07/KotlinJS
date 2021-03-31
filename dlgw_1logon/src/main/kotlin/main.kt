import org.w3c.dom.HTMLDivElement
import services.ControllerLogon
import utils.ff
import html.println0

val  htmlDivApaga: HTMLDivElement? = null

fun main(args: Array<String>) {
//    window.alert("teste")
    var sUrl = js("document.URL").toString()

    ff.gsUrlLogon = sUrl
    if (sUrl.contains("/pro/")) {
        ff.gsDesenvolvedor = "P"
    }

    if (sUrl.contains("/pro/") || sUrl.contains("/hom/")) {
        ff.gsCamView = "html/"
    } else {
        ff.gsCamView = "main/resources/html/"
    }

    println0("abrindo main.logon ${ff.gsCamView}")
    ControllerLogon().abrirCabec("CabecLogon")
}

@JsName("passMapear")
fun mapear(_sTeste: String) {
    ControllerLogon().passMapear()
}
