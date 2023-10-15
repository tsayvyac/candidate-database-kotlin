package com.tsayvyac.candidatedatabase.util

class Helper {
    companion object {
        fun checkLevelBounds(level: Int?): Int? {
            if (level in 0..10)
                return level
            else throw IllegalArgumentException("Level is out of bounds! The level limits are 0 - 10.")
        }
    }
}