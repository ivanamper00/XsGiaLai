package xoso.gailai.xsgialai.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import xoso.gailai.xsgialai.R
import xoso.gailai.xsgialai.data.Data
import xoso.gailai.xsgialai.data.DataModel
import xoso.gailai.xsgialai.databinding.CustomBallBinding
import xoso.gailai.xsgialai.databinding.CustomBottomNavBinding

class BallAdapter(private val numbers: List<Int>): RecyclerView.Adapter<BallAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.custom_ball, parent, false)
        return  Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       with(holder.binding){
           textNumber.text = numbers[position].toString()
           ballContainer.setCardBackgroundColor(ContextCompat.getColor(root.context, getColor(position)))
       }
    }

    override fun getItemCount(): Int = numbers.size

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            CustomBallBinding.bind(itemView)
        }
    }

    fun getColor(position: Int): Int{
        return when(position){
            1 -> R.color.red
            2 -> R.color.orange
            3 -> R.color.purple
            4 -> R.color.green
            else -> R.color.blue
        }
    }
}