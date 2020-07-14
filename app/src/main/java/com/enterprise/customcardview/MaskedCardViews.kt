package com.enterprise.customcardview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.*


/**
 * A Card view that clips the content of any shape, this should be done upstream in card,
 * working around it for now.
 */
class MaskedCardViews @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = R.attr.materialCardViewStyle
) : MaterialCardView(context, attrs, defStyle) {
    @SuppressLint("RestrictedApi")
    private val pathProvider = ShapeAppearancePathProvider()
    private val path: Path = Path()
    private val shapeAppearance: ShapeAppearanceModel = ShapeAppearanceModel.builder(context, attrs,
        defStyle,
        R.style.Widget_MaterialComponents_CardView)
//        .setRightEdge(RoundEdgeTreatment(50f))
//        .setLeftEdge(RoundEdgeTreatment(50f))
        .setAllEdges(RoundEdgeTreatment(50f))
//        .setBottomLeftCorner(CornerFamily.ROUNDED,24f)
//        .setTopRightCorner(CornerFamily.ROUNDED,24f)
        .setAllCorners(CornerFamily.ROUNDED,24f)
        .build()

    init {
         shapeAppearanceModel = shapeAppearanceModel.toBuilder()
             .setRightEdge(RoundEdgeTreatment(24f * context.resources.displayMetrics.density))
             .setLeftEdge(RoundEdgeTreatment(24f * context.resources.displayMetrics.density))
             .setBottomLeftCorner(CornerFamily.ROUNDED,24f * context.resources.displayMetrics.density)
             .setTopRightCorner(CornerFamily.ROUNDED,24f * context.resources.displayMetrics.density)
             //.setAllCorners(CornerFamily.ROUNDED,83f)
             .build()
        println(24f * context.resources.displayMetrics.density)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            clipToOutline = false
        }
//        requestLayout()
//        invalidate()
    }
//    private val rectF = RectF(0f, 0f, 0f, 0f)
//
//    override fun onDraw(canvas: Canvas) {
//        canvas.clipPath(path)
//        super.onDraw(canvas)
//
//    }
//
//    @SuppressLint("RestrictedApi")
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        rectF.right = w.toFloat()
//        rectF.bottom = h.toFloat()
//        pathProvider.calculatePath(shapeAppearance, 1f, rectF, path)
//        super.onSizeChanged(w, h, oldw, oldh)
//    }
}