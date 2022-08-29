package com.example.core.precentation.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpaceItemDecorator() : RecyclerView.ItemDecoration() {

    private val spaceBottom = 40


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

            outRect.bottom = spaceBottom
        }


}