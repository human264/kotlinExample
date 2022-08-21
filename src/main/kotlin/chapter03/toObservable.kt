package chapter03

import io.reactivex.Observer
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxkotlin.toObservable


fun main(args: Array<String>) {
    val observer : Observer<String> = object : Observer<String> {
        override fun onSubscribe(d: io.reactivex.disposables.Disposable) {
            println("New Subscription")
        }

        override fun onNext(t: String) {
            println("Next $t")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onComplete() {
            println("All Completed")
        }
    }

    val list:List<String> = listOf(
        "String 1", "String 2", "String 3", "String 4"
    )

    val observable: io.reactivex.Observable<String> = list.toObservable()
    observable.subscribe(observer)


}
