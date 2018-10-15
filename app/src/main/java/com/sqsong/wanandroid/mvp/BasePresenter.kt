package com.sqsong.wanandroid.mvp

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V, M> constructor(var mView: V? = null,
                                           var mModel: M? = null,
                                           var mCompositeDisposable: CompositeDisposable? = null) : IPresenter<V> where V : IView, M : IModel {

    override fun onAttach(view: V) {
        mView = view
    }

    override fun onDestroy() {
        mView = null
        mModel?.onDestroy()
        mModel = null
        mCompositeDisposable?.clear()
        mCompositeDisposable = null
    }

}