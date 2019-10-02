package com.example.dagger_example.thing_feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger_example.R
import com.example.dagger_example.ThingsViewModelFactory
import com.example.dagger_example.thing_feature.domain.FeatureThingsRepository
import com.example.dagger_example.thing_feature.presentation.MainViewModel
import com.example.dagger_example.ui_common.SimpleDividerItemDecoration
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.list_content.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var featureThingsRepository: FeatureThingsRepository

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders
            .of(this, ThingsViewModelFactory(application, featureThingsRepository))
            .get(MainViewModel::class.java)

        val adapter = ThingsAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(SimpleDividerItemDecoration(this))

        viewModel.things
            .observe(this, Observer { things ->
                adapter.submitList(things)
            })
    }
}
