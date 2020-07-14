package com.enterprise.customcardview

import com.google.android.material.shape.EdgeTreatment
import com.google.android.material.shape.ShapePath

open class RoundEdgeTreatment(val size: Float) : EdgeTreatment(), Cloneable {
    override fun getEdgePath(length: Float, center: Float, interpolation: Float, shapePath: ShapePath) {
        val halfSize = size
        shapePath.lineTo(center-halfSize,0f)
        println("left : ${center - halfSize}")
        println("top : ${ - halfSize}")
        println("right : ${center + halfSize}")
        println("bottom : ${halfSize}")
        shapePath.addArc(center - halfSize , -halfSize + 0,center + halfSize ,halfSize + 0,180f,
            (-180.0).toFloat()
        )
        super.getEdgePath(length, center, interpolation, shapePath)
    }
}