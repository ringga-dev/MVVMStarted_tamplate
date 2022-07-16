package com.ngga_ring.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ngga_ring.core.R
import com.ngga_ring.core.databinding.ItemListBinding

class EmojiAdapter(
    /**
     * create variable
     */
    private var emote: MutableList<String>,
    private var context: Context,
    //upan balik dari view
    private val clickCallback: ((String) -> Unit?)
) : RecyclerView.Adapter<EmojiAdapter.PageHolder>() {

    /**
     * set layout by viewBinding
     */
    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListBinding.bind(view)

    }

    /**
     * set value to view by viewBinding
     */
    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        with(holder) {
            binding.emoji.text = emote[position]

            binding.cardView.setOnClickListener {
                clickCallback(emote[position])
            }
        }
    }

    /**
     * set data to class
     */
    fun setEmoji(r: List<String>) {
        emote.clear()
        emote.addAll(r)
        notifyDataSetChanged()
    }


    /**
     * set layout by layoutInflater
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_list, parent, false)
        )
    }
    /**
     * set size of list
     */
    override fun getItemCount() = emote.size
}