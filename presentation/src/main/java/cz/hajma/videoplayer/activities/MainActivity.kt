package cz.hajma.videoplayer.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import cz.hajma.videoplayer.R
import cz.hajma.videoplayer.databinding.ActivityMainBinding
import cz.hajma.videoplayer.viewmodels.MainViewModel
import cz.hajma.videoprehravac.domain.enums.SortOrder
import dagger.hilt.android.AndroidEntryPoint

/**
 * App`s main activity. Shows a list of videos loaded from the internet or from the database if connection is unavailable.
 * Should be a fragment with navigation (androidx.navigation:navigation)
 */
@AndroidEntryPoint
class MainActivity() : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Using MediatorLiveData for observing filter changes would be better,
        // but I can`t make it work right now.
        /*viewModel.chipsMediator.observe(this, Observer {
            viewModel.filterData(viewModel.chipsMediator.value)
        })*/

        viewModel.drmActive.observe(this, Observer {
            viewModel.filter.drm = it
            viewModel.filterData(viewModel.filter)
        })

        viewModel.sdActive.observe(this, Observer {
            viewModel.filter.sd = it
            viewModel.filterData(viewModel.filter)

        })

        viewModel.hdActive.observe(this, Observer {
            viewModel.filter.hd = it
            viewModel.filterData(viewModel.filter)

        })

        viewModel.uhdActive.observe(this, Observer {
            viewModel.filter.uhd = it
            viewModel.filterData(viewModel.filter)

        })

        viewModel.liveActive.observe(this, Observer {
            viewModel.filter.live = it
            viewModel.filterData(viewModel.filter)
        })

        viewModel.subtitlesActive.observe(this, Observer {
            viewModel.filter.subtitles = it
            viewModel.filterData(viewModel.filter)
        })

        // Custom binding adapter could be used here
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_sort_abc -> viewModel.sortData(SortOrder.ALPHABETICAL)
            R.id.action_sort_date_desc -> viewModel.sortData(SortOrder.DATE_DESC)
            R.id.action_sort_date_asc -> viewModel.sortData(SortOrder.DATE_ASC)
        }
        return super.onOptionsItemSelected(item)
    }
}