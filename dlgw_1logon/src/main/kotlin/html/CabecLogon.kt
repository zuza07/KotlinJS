package html

import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.html.*
import kotlinx.html.dom.*
import kotlinx.html.js.onClickFunction

//import kotlinx.dom. html.js.onClickFunction
//import kotlinx.html.js.onClickFunction

import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLSpanElement
import services.ControllerLogon

class CabecLogon(var formCabec: HTMLDivElement) {
    var btVoltar: HTMLButtonElement? = null

    fun show() {
        formCabec.clear()
        formCabec.appendChild(getForm())
        ControllerLogon.lbErro = document.getElementById("lbErro") as HTMLSpanElement
        ControllerLogon.lbTitulo = document.getElementById("lbTitulo") as HTMLSpanElement
        ControllerLogon.divTitulo = document.getElementById("divTitulo") as HTMLDivElement
    }

    fun getForm(): HTMLElement {

        return document.create.div() {

            div(classes = "form-group navbar-dark bg-dark") {
                id = "formMenu"
                nav {
                    span("dlg-select dlg-font9") {
                        id="lbErro"
                        //text("Teste")
                    }
                    role = "navigation"
                    div("navbar navbar-dark bg-dark") {
                        h3(classes = "dlg-titulo") {
                            text("Dlógica")
                            onClickFunction = {
                                js("location.reload(true)")
                            }
                        }
                        form(classes = "form-inline my-2 my-lg-0") {
                            onSubmit = "return false"
                            button(classes = "btn btn-outline-success my-2 my-sm-0 dlg-font8") {
                                id = "btVoltar"
                                //style = "display:none"

                                onClickFunction = { _ -> ControllerLogon().abrir("Principal", "") }
                                text("Voltar")
                                //disabled = true
                                //style("display","none")
                            }
                        }

                        div("dlg-cabec") {
                            id="divTitulo"
                            span("card-titule") {
                                //span() {
                                id = "lbTitulo"
                                //text("003 - Consulta NFe")
                            }
                        }
                    }
                }
            }
        }
    }
}