package com.example.foody.util

import androidx.recyclerview.widget.DiffUtil
import com.example.foody.models.Result
import org.antlr.v4.gui.TreeTextProvider

class RecipeDiffutil(
        private val oldlist:List<Result>,
        private val newlist:List<Result>
): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldlist[oldItemPosition] === newlist[newItemPosition]
    }

    override fun getOldListSize(): Int {
        return oldlist.size
    }

    override fun getNewListSize(): Int {
        return newlist.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldlist[oldItemPosition] == newlist[newItemPosition]
    }
}