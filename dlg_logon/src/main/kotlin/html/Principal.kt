package html

import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.form
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import services.ControllerLogon
import kotlin.browser.document

class Principal(var formContainer: HTMLDivElement) {

    private var btTarefas: HTMLButtonElement? = null

    fun show() {
        formContainer.appendChild(getForm())
        mapear()
    }

    private fun mapear() {
        try {
            btTarefas = document.getElementById("btTarefas") as HTMLButtonElement
        } catch (e: Exception) {
            console.log("Erro - mapear")
        }
    }

    private fun getForm(): HTMLDivElement {
        return document.create.div(classes = "dlg-pad-top-5") {
            form("/", null) {
                if (ControllerLogon.lbErro != null) {
                    ControllerLogon.lbErro!!.innerText = ""
                    ControllerLogon.lbErro!!.style.display = ""
                }

                div("form-group") {
                    button() {
                        attributes["class"] = "btn dlg-mobbt100"
                        attributes["type"] = "button"
                        onClickFunction = { _ -> ControllerLogon().abrir("VW005", "") }
                        //text("teste")
                    }
                }
            }
        }
    }
}