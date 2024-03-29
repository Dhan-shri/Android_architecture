package com.dhanshri.architecture.mvp

import java.util.PrimitiveIterator

class Presenter (
    private var mainView : Contract.View?,
    private val model: Contract.Model
) : Contract.Presenter, Contract.Model.OnFinishedListener{
    override fun onFinished(string: String?) {
        if (mainView != null){
            mainView!!.setString(string)
            mainView!!.hideProgress()
        }
    }

    override fun onButtonClick() {
        if (mainView != null){
            mainView!!.showProgress()
        }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

}