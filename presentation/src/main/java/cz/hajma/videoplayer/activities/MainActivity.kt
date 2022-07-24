package cz.hajma.videoplayer.activities

import android.os.Bundle
import android.widget.MediaController
import android.widget.SearchView
import android.widget.VideoView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.chip.Chip
import cz.hajma.videoplayer.R
import cz.hajma.videoplayer.databinding.ActivityMainBinding
import cz.hajma.videoplayer.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)

        /*viewModel.chipsMediator.observe(this, Observer {
            viewModel.filterData(viewModel.chipsMediator.value)
        })*/

        viewModel.drmActive.observe(this, Observer {
            viewModel.filter.drm = it
            viewModel.filterData(viewModel.filter)
        })

        viewModel.mp4Active.observe(this, Observer {
            viewModel.filter.mp4 = it
            viewModel.filterData(viewModel.filter)

        })

        viewModel.hlsActive.observe(this, Observer {
            viewModel.filter.hls = it
            viewModel.filterData(viewModel.filter)

        })

        viewModel.dashActive.observe(this, Observer {
            viewModel.filter.dash = it
            viewModel.filterData(viewModel.filter)

        })

        viewModel.webmActive.observe(this, Observer {
            viewModel.filter.webM = it
            viewModel.filterData(viewModel.filter)
        })

        var searchbox = findViewById<SearchView>(R.id.search_box)
        searchbox.setOnQueryTextListener(this)

        viewModel.searchQuery.observe(this, Observer {
            viewModel.filter.query = it
            viewModel.filterData(viewModel.filter)
        })

        searchbox.setOnCloseListener {
            viewModel.filter.query = null
            viewModel.filterData(viewModel.filter)
            false
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true;
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        viewModel.searchQuery.postValue(newText)
        return true;
    }
}