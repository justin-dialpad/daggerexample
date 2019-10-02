package com.example.dagger_example.thing_feature

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.dagger_example.R
import com.example.dagger_example.thing_feature.presentation.FeatureThingForDisplay

class ThingsAdapter(context: Context) : PagedListAdapter<FeatureThingForDisplay, ThingViewHolder>(
    object : DiffUtil.ItemCallback<FeatureThingForDisplay>() {
        override fun areItemsTheSame(oldItem: FeatureThingForDisplay, newItem: FeatureThingForDisplay): Boolean = oldItem.shortDescription == newItem.shortDescription
        override fun areContentsTheSame(oldItem: FeatureThingForDisplay, newItem: FeatureThingForDisplay): Boolean = oldItem == newItem
    }
) {
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThingViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_thing_item, parent, false)
        return ThingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ThingViewHolder, position: Int) {
        getItem(position).let { thing ->
            holder.itemView.let { view ->
                if (thing == null) {
                    // don't bind data, placeholders exist
                    return
                }
                view as TextView
                view.text = thing.shortDescription
            }
        }
    }
}