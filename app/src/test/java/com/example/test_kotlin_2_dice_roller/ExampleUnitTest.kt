package com.example.test_kotlin_2_dice_roller

import junit.framework.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test // important anotation !! Idicates to the compiler how to compile that code (as a test)
    fun generates_number() {
        val max: Int = 6
        val dice: Dice = Dice(max)
        val rollResult: Int = dice.roll()

        assertTrue("The value of rollResult was not bewteen 1 and 6", rollResult in 1..max)
    }
}