package com.enterprise.lib

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.*

@SuppressLint("ResourceType", "Recycle")
class MaskedCardView @JvmOverloads constructor(context: Context, attrs:AttributeSet? = null, defStyle:Int= R.attr.materialCardViewStyle) :
    MaterialCardView(context,attrs,defStyle){

    init {
        val a = context.obtainStyledAttributes(attrs,R.styleable.MaskedCardView) as TypedArray
        val edgeSize = a.getDimension(R.styleable.MaskedCardView_edgeSizeDp,8f)
        val indexCorner = a.getLayoutDimension(R.styleable.MaskedCardView_cornerSide,0)
        val indexEdge = a.getLayoutDimension(R.styleable.MaskedCardView_edgeSide,1)
        val cornerSize = a.getLayoutDimension(R.styleable.MaskedCardView_cornerSizeDp,8).toFloat()
        val cornerFamily = a.getInt(R.styleable.MaskedCardView_cornerFamilyType,0)
        println(attrs)
        a.recycle()
        shapeAppearanceModel = shapeAppearanceModel.toBuilder().apply {
            when {
                edgeSize > 0 && indexCorner > 0 -> {
                    corner(indexCorner, cornerSize, cornerFamily)
                    edges(indexEdge,edgeSize)
                }
                edgeSize > 0 && indexCorner < 0 -> {
                    edges(indexEdge,edgeSize)
                }
                edgeSize < 0 && indexCorner > 0 -> {
                    corner(indexCorner, cornerSize, cornerFamily)
                }
        }
        }.build()
    }

    private fun ShapeAppearanceModel.Builder.edges(index: Int, edgeSize:Float){
        when (index){
            1 -> {
                setRightEdge(RoundEdgeTreatment(edgeSize))
                setLeftEdge(RoundEdgeTreatment(edgeSize))
            }
            2 -> {
                setTopEdge(RoundEdgeTreatment(edgeSize))
                setBottomEdge(RoundEdgeTreatment(edgeSize))
            }
            3 -> {
                setAllEdges(RoundEdgeTreatment(edgeSize))
            }
        }
    }

    private fun ShapeAppearanceModel.Builder.corner(index:Int, cornerSize:Float, cornerFamily:Int){
        when (index) {
            1 -> {
                setBottomLeftCorner(cornerFamily,cornerSize)
                setTopRightCorner(cornerFamily,cornerSize)
            }
            2 -> {
                setBottomRightCorner(cornerFamily,cornerSize)
                setTopLeftCorner(cornerFamily,cornerSize)
            }
            3 -> {
                setAllCorners(cornerFamily, cornerSize)
            }
        }
    }

    private class RoundEdgeTreatment(val size:Float):EdgeTreatment(),Cloneable{
        override fun getEdgePath(
            length: Float,
            center: Float,
            interpolation: Float,
            shapePath: ShapePath
        ) {
            shapePath.lineTo(center - size, 0f)
            shapePath.addArc(center - size, -size,center + size,size,180f,-180f)
            super.getEdgePath(length, center, interpolation, shapePath)
        }
    }
}