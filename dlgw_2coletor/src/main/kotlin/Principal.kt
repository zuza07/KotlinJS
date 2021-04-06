import org.w3c.dom.HTMLButtonElement
import kotlin.browser.document
import kotlinx.browser.window
import kotlinx.html.dom.create
import kotlinx.html.id
import kotlinx.html.js.*
import model.aaGenericoEmp
import utils.ff.*
import utils.ff.Companion.println0

class Principal {

    private var btEntrar = document.create.button { id = "btEntrar" } as HTMLButtonElement

    fun show() {
        println0("entrou no show do Principal")
        try {
            btEntrar = document.getElementById("${btEntrar.id}") as HTMLButtonElement
            btEntrar.onclick = { clickEntrar() }
        } catch (e: Exception) {

        }
    }

    fun clickEntrar() {
        println0("realizado click no botão entrar")
        window.alert("realizado click no botão entrar!")
    }
}