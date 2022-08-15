package com.example.cleanarchhilt.home.ui.launch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchhilt.R
import com.example.cleanarchhilt.common.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchData()
        observeState()
    }

    private fun observeState() {
        viewModel.liveDataHomeData.observe(this) { homeUiState ->
            when (homeUiState) {
                is HomeUiState.Loader -> {
                    findViewById<ProgressBar>(R.id.progress_bar).visibility = View.VISIBLE
                }
                is HomeUiState.Success -> {
                    findViewById<ProgressBar>(R.id.progress_bar).visibility = View.GONE
                    findViewById<TextView>(R.id.tv_name).text =
                        homeUiState.name
                            .plus(" - ")
                            .plus(homeUiState.launches.size)
                }
                is HomeUiState.Failure -> {
                    findViewById<ProgressBar>(R.id.progress_bar).visibility = View.GONE
                }
            }
        }

        viewModel.liveDataNavigation.observe(this) { navigationState ->
            when (navigationState) {
                is HomeNavigationState.LaunchDetail -> {
                    startLaunchDetailActivity(navigationState)
                }
            }
        }
    }

    private fun startLaunchDetailActivity(launchDetail: HomeNavigationState.LaunchDetail) {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putSerializable(Constants.PARAM_LAUNCH_LINK_URL, launchDetail.url)
        bundle.putSerializable(Constants.PARAM_LAUNCH_LINK_TYPE, launchDetail.link)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
