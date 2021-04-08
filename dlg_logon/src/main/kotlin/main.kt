import html.println0
import services.ControllerLogon
import utils.ff

@JsModule("dayjs")
@JsNonModule
@JsName("dayjs")
external fun dayjs(any: Any? = definedExternally): dynamic

/*
fun main() {
    println("Hello Kotlin/JS!! ${dayjs()}")
    println("this year         ${dayjs().year()}")
    println("Valentine         ${dayjs("2020-02-14")}")
    println("Formatted date    ${dayjs().format()}")

    println("teste do zuza 01")

    ff.println0("teste da implementação")
}
*/

//fun main(args: Array<String>) {
fun main() {

    val sUrl = js("document.URL").toString()

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

