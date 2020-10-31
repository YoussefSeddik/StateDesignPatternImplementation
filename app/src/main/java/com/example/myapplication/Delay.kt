package com.example.myapplication

import io.reactivex.Observable
import io.reactivex.ObservableEmitter

object Delay {
    fun <T> delayedObservable(block: (ObservableEmitter<Result<T>>) -> Unit): Observable<Result<T>> {
        return Observable.create<Result<T>> {
            try {
                Thread.sleep(2000)
                block(it)
            } catch (e: InterruptedException) {
                println("I was interrupted!")
                e.printStackTrace()
            }
        }
    }
}