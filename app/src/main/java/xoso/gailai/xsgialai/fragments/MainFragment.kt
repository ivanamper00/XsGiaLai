package xoso.gailai.xsgialai.fragments

import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import xoso.gailai.xsgialai.R
import xoso.gailai.xsgialai.base.BaseFragment
import xoso.gailai.xsgialai.binding.viewBinding
import xoso.gailai.xsgialai.bottom_nav.BottomAdapter
import xoso.gailai.xsgialai.data.Data
import xoso.gailai.xsgialai.databinding.FragmentMainBinding

class MainFragment(
    private val listener: Listener
): BaseFragment<FragmentMainBinding>(R.layout.fragment_main), BottomAdapter.Listener {

    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    private val menuAdapter by lazy { BottomAdapter(Data.data, this) }

    private val textData = "Rễ của cây hồ lô càng ăn sâu và lan xa. \"Đúc nhiều\" thậm chí còn được nhắc đến trong Kinh thánh. Xổ số đầu tiên cung cấp giải thưởng tiền mặt có lẽ bắt nguồn từ Florence, Ý, vào thế kỷ 16. Nó được đặt tên là Lotto de Firenze, và nó nhanh chóng lan sang các thành phố khác của Ý. Trò chơi, cũng như cái tên, đã bắt đầu. Xổ số quốc gia của Ý vẫn được gọi là Xổ số, cũng như ở Mỹ và nhiều quốc gia khác.\n" +
            "\n" +
            "Trong thời thuộc địa, xổ số đã trở nên thịnh hành ở Mỹ. Hầu hết được tổ chức cho các mục đích từ thiện hoặc dân sự, chẳng hạn như xây dựng nhà thờ, cầu và trường học. Nhưng xổ số đã bị thất sủng vào giữa thế kỷ 19. Mọi thứ đã thay đổi vào nửa sau của thế kỷ 20. New Hampshire là tiền thân của nó, tổ chức xổ số đầu tiên vào năm 1964. Các bang khác dần dần làm theo. Vào những năm 80 và đặc biệt là những năm 90, trò chơi cổ trở nên hot hơn cả súng lục hai đô la.\n" +
            "\n" +
            "Bạn sẽ thấy mọi người ở mọi lứa tuổi và từ mọi tầng lớp xã hội đang chọn và cào (nghĩa là chọn số và cào lấy vé ngay lập tức). Tại Hoa Kỳ, tổng doanh số bán xổ số hàng năm đã lên đến hàng tỷ đô la. Ở nhiều tiểu bang, tất cả những gì bạn phải trả để có cơ hội thay đổi cuộc đời mình mãi mãi là \$ 1. Bạn có thể mua giấc mơ ở đâu khác với giá một đô la?\n" +
            "\n" +
            "Hãy nhớ rằng không có người, hệ thống hoặc bài báo nào có thể đảm bảo trung thực rằng bạn trở thành người chiến thắng xổ số. Những gì bài viết này cung cấp là tổng quan ngắn gọn về các trò chơi khác nhau và cách chúng chơi. Nó cung cấp cho bạn một loạt các ý tưởng và mẹo về những gì nên làm và những gì nên tránh. Thậm chí còn có lời khuyên về việc phải làm gì nếu bạn giành chiến thắng. Phần lớn, nó trình bày một loạt các chiến lược chọn số để giúp bạn vượt qua những tỷ lệ cược dài hạn đó."


    override fun setupViews() {
       with(binding){
           with(recyclerView){
               adapter = BallAdapter(generatedNumbers)
               layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
           }

           with(recyclerView2){
               adapter = menuAdapter
               layoutManager = LinearLayoutManager(requireContext())
           }

           textContent.text = HtmlCompat.fromHtml(textData, HtmlCompat.FROM_HTML_MODE_LEGACY)
       }
    }

    override fun viewModelObservers() {
    }

    interface Listener {
        fun onPositionClick(position: Int)
    }

    override fun onMenuSelected(position: Int) {
        listener.onPositionClick(position + 1)
    }
}