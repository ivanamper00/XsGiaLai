package xoso.gailai.xsgialai.bottom_nav

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import xoso.gailai.xsgialai.R
import xoso.gailai.xsgialai.data.Data
import xoso.gailai.xsgialai.data.DataModel
import xoso.gailai.xsgialai.databinding.CustomBottomNavBinding

class BottomAdapter(
    private val menuData: List<DataModel>,
    private val listener: Listener
    ): RecyclerView.Adapter<BottomAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.custom_bottom_nav, parent, false)
        return  Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       with(holder.binding){
           val data = menuData[position]
           iconImage.setBackgroundResource(data.icon)
           cardContainer.setCardBackgroundColor(ContextCompat.getColor(root.context, data.color))
           root.setOnClickListener { listener.onMenuSelected(position) }
       }
    }

    override fun getItemCount(): Int = menuData.size

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            CustomBottomNavBinding.bind(itemView)
        }
    }

    interface Listener {
        fun onMenuSelected(position: Int)
    }
}