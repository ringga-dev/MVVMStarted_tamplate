package com.ngga_ring.core.alert

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ngga_ring.core.adapter.EmojiAdapter
import com.ngga_ring.core.databinding.AlertEmojiBinding
import com.ngga_ring.core.emojiList.Expression

class  EmojiAlert() {

     interface OnAmbilWarnaListener {
         fun onCancel(dialog: EmojiAlert?)
         fun onOk(dialog: EmojiAlert?, emoji: String)
         fun onErorr(dialog: EmojiAlert?, message: String?)
     }

    var dialog: AlertDialog? = null
    private val supportsAlpha = false
    val listener: OnAmbilWarnaListener? = null

    fun EmojiAlert(context: Context?, color: Int, listener: OnAmbilWarnaListener?) {
    }

    @SuppressLint("ClickableViewAccessibility")
    fun EmojiAlert(
        context: Context?,
        color: Int,
        supportsAlpha: Boolean,
        listener: OnAmbilWarnaListener?
    ) {
        var emoji = ""

        val binding: AlertEmojiBinding = AlertEmojiBinding.inflate(LayoutInflater.from(context))
        val builder = AlertDialog.Builder(context)
            .setView(binding.root)
            .setCancelable(false)

        val alert = builder.create()
        alert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.rvEmoji.apply {
            layoutManager = StaggeredGridLayoutManager(10, StaggeredGridLayoutManager.VERTICAL)
            adapter = EmojiAdapter(mutableListOf(), context!!) { String ->
                this@EmojiAlert.listener?.onOk(this@EmojiAlert, String)
            }
        }
        binding.rvEmoji.adapter?.let { adapter ->
            if (adapter is EmojiAdapter) {
                adapter.setEmoji(Expression.data)
            }
        }

        alert.show()
    }



}