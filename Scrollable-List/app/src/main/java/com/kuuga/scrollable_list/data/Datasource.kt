package com.kuuga.scrollable_list.data

import com.kuuga.scrollable_list.R
import com.kuuga.scrollable_list.model.Affirmation

data class Datasource() {
    fun loadAffirmation(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.kr_1, R.drawable.axel),
            Affirmation(R.string.kr_2, R.drawable.fang_joker),
            Affirmation(R.string.kr_3, R.drawable.black),
            Affirmation(R.string.kr_4, R.drawable.blade),
            Affirmation(R.string.kr_5, R.drawable.build),
            Affirmation(R.string.kr_6, R.drawable.fourze),
            Affirmation(R.string.kr_7, R.drawable.heat_metal),
            Affirmation(R.string.kr_8, R.drawable.zio),
            Affirmation(R.string.kr_9, R.drawable.vulcan),
            Affirmation(R.string.kr_10, R.drawable.ichigo_nigo),
            Affirmation(R.string.kr_11, R.drawable.zero_one)
        )
    }
}
