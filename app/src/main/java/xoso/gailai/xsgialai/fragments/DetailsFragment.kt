package xoso.gailai.xsgialai.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import xoso.gailai.xsgialai.R
import xoso.gailai.xsgialai.base.BaseFragment
import xoso.gailai.xsgialai.binding.viewBinding
import xoso.gailai.xsgialai.data.DataModel
import xoso.gailai.xsgialai.databinding.FragmentDetailsBinding

class DetailsFragment(
    private val data: DataModel
): BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {

    override val binding: FragmentDetailsBinding by viewBinding(FragmentDetailsBinding::bind)

    override fun setupViews() {
        with(binding){
            with(recyclerView){
                adapter = BallAdapter(generatedNumbers)
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }

            textTitle.text = data.title
            banner.setBackgroundResource(data.image)
            textContent.text = data.desc
        }
    }

    override fun viewModelObservers() {
    }
}