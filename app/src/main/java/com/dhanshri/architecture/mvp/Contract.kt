package com.dhanshri.architecture.mvp


// This interface class will contain all abstract methods which will be defined later in the View, Model, and Presenter class.

interface Contract {

    interface View{
        fun showProgress()

        fun hideProgress()

        fun setString(string: String?)
    }

    interface Model{
        interface OnFinishedListener{
            fun onFinished(string : String?)
        }
        fun getNextCourse(onFinishedLister : OnFinishedListener?)
    }

    interface Presenter{
        fun onButtonClick()

        fun onDestroy()
    }

}