import kotlinx.browser.document
import utils.ff

fun main() {
    document.write("Hello, world! ${teste()}")
}

fun teste(): String {
    val sTeste = "Teste do zuza 02"
    ff.println0(sTeste)
    return "1 - $sTeste"
}