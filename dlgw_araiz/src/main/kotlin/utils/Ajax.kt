package utils

import model.Task
import org.w3c.xhr.*
import utils.ff

class Ajax {

    var xhttp: dynamic = XMLHttpRequest()
    //var xhttp = XMLHttpRequest()

    fun getEmpresa(url: String, callback: (XMLHttpRequest) -> Unit) {
        ff.println0(url)
        xhttp.open(
                method = "GET",
                url = url,
                async = true
        )
        xhttp.timeout = 3000
        xhttp.onreadystatechange = {
            if (xhttp.readyState == XMLHttpRequest.DONE && (xhttp.status == 200 || xhttp.status == 0)) {
                callback(xhttp)
                ff.println0("sucesso 200")
            } else if (xhttp.readyState == XMLHttpRequest.DONE) {
                ff.println1("erro no get $url falha=${xhttp.status}")
            }
        }
        xhttp.ontimeout = {
            callback(xhttp)
            console.log("timeout")
        }
        xhttp.send()
    }

    fun get(url: String, callback: (XMLHttpRequest) -> Unit) {
        ff.println0(url)
        xhttp.open(
                method = "GET",
                url = url,
                async = true
        )
        xhttp.onreadystatechange = {
            if (xhttp.readyState == XMLHttpRequest.DONE && (xhttp.status == 200 || xhttp.status == 0)) {
                callback(xhttp)
                ff.println0("sucesso 200")
            } else if (xhttp.readyState == XMLHttpRequest.DONE) {
                ff.println1("erro no get $url falha=${xhttp.status}")
            }
        }
        xhttp.send()
    }

    fun get(url: String, sToken: String, callback: (XMLHttpRequest) -> Unit) {
        var sUrl = ""
        if (!sToken.equals("")) {
            sUrl = url + "/token=" + sToken
        } else {
            sUrl = url
        }

        ff.println0(sUrl)
        xhttp.open(
                method = "GET",
                url = sUrl,
                async = true
                //username = "token",
                //password = sToken
        )
        xhttp.onreadystatechange = {
            if (xhttp.readyState == XMLHttpRequest.DONE && (xhttp.status == 200 || xhttp.status == 0)) {
                callback(xhttp)
            }
        }

        xhttp.setRequestHeader("content-type", "application/json");
        //xhttp.asDynamic().add("token${ff.gsEmpSerie}", sToken);
        //xhttp.setRequestHeader("token${ff.gsEmpSerie}", sToken)
        //xhttp.setRequestHeader("token", sToken)
        xhttp.send(sToken)
    }

    fun get(url: String, sToken: String) {
        var sUrl = ""
        if (!sToken.equals("")) {
            sUrl = url + "/token=" + sToken
        } else {
            sUrl = url
        }
        xhttp.open(
                method = "GET",
                url = sUrl,
                async = true
        )
        xhttp.setRequestHeader("content-type", "application/json");
        xhttp.send(sToken)
    }

    fun post(url: String, task: Task, callback: (XMLHttpRequest) -> Unit) {
        xhttp.open(
                method = "POST",
                url = url,
                async = true
        )
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.onreadystatechange = {
            if (xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200) {
                callback(xhttp)
            }
        }

        xhttp.send(JSON.stringify(task))
    }

    fun post(url: String, task: Task, sToken: String, callback: (XMLHttpRequest) -> Unit) {

        var sUrl = ""
        if (!sToken.equals("")) {
            sUrl = url + "/token=" + sToken
        } else {
            sUrl = url
        }
        //console.log(sUrl)
        xhttp.open(
                method = "POST",
                url = sUrl,
                async = true
        )
        xhttp.onreadystatechange = {
            if (xhttp.readyState == XMLHttpRequest.DONE && (xhttp.status == 200 || xhttp.status == 304)) {
                callback(xhttp)
            }
        }

        xhttp.setRequestHeader("content-type", "application/json");
        //xhttp.asDynamic().add("token${ff.gsEmpSerie}", sToken);
        //xhttp.setRequestHeader("token${ff.gsEmpSerie}", sToken);
        xhttp.send(JSON.stringify(task))
    }

    fun postSimples(url: String, task: Task, sToken: String, callback: (Int) -> Unit) {

        var sUrl = ""
        if (!sToken.equals("")) {
            sUrl = url + "/token=" + sToken
        } else {
            sUrl = url
        }
        //console.log(sUrl)
        xhttp.open(
                method = "POST",
                url = sUrl,
                async = true
        )
        xhttp.onreadystatechange = {
            if (xhttp.readyState == XMLHttpRequest.DONE && (xhttp.status == 200 || xhttp.status == 304)) {
                callback(xhttp.status)
            }
        }

        xhttp.setRequestHeader("content-type", "application/json");
        //xhttp.asDynamic().add("token${ff.gsEmpSerie}", sToken);
        //xhttp.setRequestHeader("token${ff.gsEmpSerie}", sToken);
        xhttp.send(JSON.stringify(task))
    }

    fun put(url: String, task: Task, sToken: String, callback: (XMLHttpRequest) -> Unit) {

        var sUrl = ""
        if (!sToken.equals("")) {
            sUrl = url + "/token=" + sToken
        } else {
            sUrl = url
        }
        //console.log(sUrl)
        xhttp.open(
                method = "PUT",
                url = sUrl,
                async = true
        )
        xhttp.onreadystatechange = {
            if (xhttp.readyState == XMLHttpRequest.DONE && (xhttp.status == 200 || xhttp.status == 304)) {
                callback(xhttp)
            }
        }

        xhttp.setRequestHeader("content-type", "application/json");
        //xhttp.asDynamic().add("token${ff.gsEmpSerie}", sToken);
        //xhttp.setRequestHeader("token${ff.gsEmpSerie}", sToken);
        xhttp.send(JSON.stringify(task))
    }

}