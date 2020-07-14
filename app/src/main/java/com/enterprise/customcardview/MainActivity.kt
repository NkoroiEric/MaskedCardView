package com.enterprise.customcardview

import android.graphics.RectF
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapeAppearanceModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ticketView.apply {
////            shapeAppearanceModel = ShapeAppearanceModel.builder(context, null,
////                    R.attr.materialCardViewStyle,
////                    R.style.Widget_MaterialComponents_CardView)
////                .setAllEdges(RoundEdgeTreatment(50f))
////                .build()
//            requestLayout()
//            invalidate()
//        }
//
//        val roundEdgeTreatment = RoundEdgeTreatment(50f)
//        val shapeAppearanceModel =
//            .build()
//        println(cardView.shapeAppearanceModel.leftEdge)
//        println(cardView.shapeAppearanceModel.rightEdge)
//        println(cardView.shapeAppearanceModel.toString())
//        cardView.shapeAppearanceModel = shapeAppearanceModel
//        println(cardView.shapeAppearanceModel.leftEdge)
//        println(cardView.shapeAppearanceModel.rightEdge)
//        println(cardView.shapeAppearanceModel.toString())

        //val shapeAppearanceModel = ticketView.shapeAppearanceModel
        println(ticketView.getBackground())
        //ticketView.clipToOutline = false
//        val bgDrawable = ticketView.background as MaterialCardViewHelper
//        bgDrawable.shapeAppearanceModel = bgDrawable.shapeAppearanceModel.toBuilder().setAllEdges(RoundEdgeTreatment(50f)).build()
    }
}