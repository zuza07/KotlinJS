package utils

//import model.Task

class TodoEventEmitter {

    private val events: LinkedHashMap<String, ArrayList<(Any) -> Unit>> = linkedMapOf()

    fun on(eventName: String, callback: (Any) -> Unit) {
        if (events.containsKey(eventName)) {
            events[eventName]?.add(callback)
        } else {
            events[eventName] = arrayListOf(callback)
        }
    }

    fun trigger(eventName: String, task: Any) {
        if (events.containsKey(eventName)) {
            events.get(eventName)?.forEach {
                it.invoke(task)
            }
        }
    }


}