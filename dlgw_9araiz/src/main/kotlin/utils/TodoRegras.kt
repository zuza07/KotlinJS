package utils

import model.Regras

class TodoRegras {

    //teste aqui
    private val events: LinkedHashMap<String, ArrayList<(Regras) -> Unit>> = linkedMapOf()

    fun on(eventName: String, callback: (Regras) -> Unit) {
        if (events.containsKey(eventName)) {
            events[eventName]?.add(callback)
        } else {
            events[eventName] = arrayListOf(callback)
        }
    }

    fun trigger(eventName: String, task: Regras) {
        if (events.containsKey(eventName)) {
            events.get(eventName)?.forEach {
                it.invoke(task)
            }
        }
    }


}