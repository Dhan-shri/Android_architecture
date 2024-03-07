package com.dhanshri.architecture.mvc

import java.util.Observable
import kotlin.jvm.Throws


class Model : Observable() {

    var List1 : MutableList<Int> = arrayListOf()

    init {
        List1 = ArrayList(3)

        List1.add(0)
        List1.add(0)
        List1.add(0)

    }

    // defining getter and setter functions
    // function to return appropriate count
    // value at correct index
    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(the_index: Int) : Int{
        return List1[the_index]
    }

    // function to set appropriate count

    // function to make changes in the activity button's
    // count value when user touch it

    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(the_index: Int) {
        List1[the_index] = List1[the_index] + 1
        setChanged()
        notifyObservers()
    }
}