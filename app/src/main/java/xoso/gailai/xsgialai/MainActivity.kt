package xoso.gailai.xsgialai

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import xoso.gailai.xsgialai.binding.viewBinding
import xoso.gailai.xsgialai.bottom_nav.BottomAdapter
import xoso.gailai.xsgialai.data.Data
import xoso.gailai.xsgialai.data.DataModel
import xoso.gailai.xsgialai.databinding.ActivityMainBinding
import xoso.gailai.xsgialai.fragments.DetailsFragment
import xoso.gailai.xsgialai.fragments.MainFragment

class MainActivity : AppCompatActivity(), MainFragment.Listener, BottomAdapter.Listener {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var fragments: List<Fragment>

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private lateinit var bottomAdapter: BottomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        fragments = listOf(
            MainFragment(this),
            DetailsFragment(Data.data[0]),
            DetailsFragment(Data.data[1]),
            DetailsFragment(Data.data[2]),
            DetailsFragment(Data.data[3]),
            DetailsFragment(Data.data[4])
        )

        viewPagerAdapter = ViewPagerAdapter(this, fragments)

        val data = Data.data.toMutableList().apply {
            add(
                0,
                DataModel(
                    title = "Home",
                    desc = "",
                    icon = R.drawable.ic_menu,
                    color = R.color.orange
                )
            )
            toList()
        }

        bottomAdapter = BottomAdapter(data, this)

        with(binding){
            with(viewPager){
                offscreenPageLimit = 5
                adapter = viewPagerAdapter
                isUserInputEnabled = false

                registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        hideBottomNav(position == 0)
                    }
                })
            }

            with(menuRecycler){
                adapter = bottomAdapter
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            }

        }
    }

    private fun hideBottomNav(b: Boolean) {
        binding.frameLayout.visibility = if(b) View.GONE else View.VISIBLE
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onBackPressed() {
        if(binding.viewPager.currentItem > 0){
            binding.viewPager.currentItem = 0
        }else AlertDialog.Builder(this)
            .setTitle("Exit Application?")
            .setMessage("Do you want to exit?")
            .setPositiveButton("Ok"){ _,_ -> super.onBackPressed() }
            .setNegativeButton("Cancel"){ d, _ -> d.dismiss()}
            .show()
    }

    override fun onPositionClick(position: Int) {
        binding.viewPager.currentItem = position
    }

    override fun onMenuSelected(position: Int) {
        onPositionClick(position)
    }

}