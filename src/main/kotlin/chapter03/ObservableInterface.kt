package chapter03

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.range(1, 5)

    observable.subscribe(
        { println("Next $it")},
        { println(it)},
        { println("Done") })

    val observer: Observer<Int> = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("New Subscription") }

        override fun onNext(t: Int) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occurred ${e.message}")
        }

        override fun onComplete() {
            println("All Completed")
        }
    }
    observable.subscribe(observer)
}