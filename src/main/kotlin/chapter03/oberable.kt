package example.chapter03

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


fun main(args: Array<String>) {
    val observer:Observer<Any> = object :Observer<Any> {
        override fun onSubscribe(d: Disposable) {
            println("Subscribed to $d")
        }

        override fun onError(e: Throwable) {
            println("Error Occure : $e")
        }

        override fun onComplete() {
            println("All completed")
        }

        override fun onNext(t: Any) {
            println("Next $t")
        }

    }


    val observableOnList: Observable<List<Any>> = Observable.just(listOf("One", 2, "Three", "Four",
    4.5, "Five", 6.0f), listOf("List with Single Item"), listOf(1,2,3,4,5,6))

    observableOnList.subscribe(observer)
}


