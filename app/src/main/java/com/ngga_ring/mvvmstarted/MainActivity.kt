package com.ngga_ring.mvvmstarted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ngga_ring.core.adapter.EmojiAdapter
import com.ngga_ring.core.alert.EmojiAlert
import com.ngga_ring.core.emojiList.Expression
import com.ngga_ring.mvvmstarted.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setupRecler()
//        binding.rvEmoji.adapter?.let { adapter ->
//            if (adapter is EmojiAdapter) {
//                adapter.setEmoji(Expression.data)
//            }
//        }

        EmojiAlert.ShowAlert(this)
    }


    }

//    private fun setupRecler() {
//        binding.rvEmoji.apply {
//            layoutManager = StaggeredGridLayoutManager(10, StaggeredGridLayoutManager.VERTICAL)
//            adapter = EmojiAdapter(mutableListOf(), this@MainActivity){
//                Toast.makeText(this@MainActivity, "$it", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}