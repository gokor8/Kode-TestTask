package com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel

class MainRV() :
    ListAdapter<WorkerInfoUIModel, MainRV.WorkerViewHolder>(DiffUtilsCallback()) {

    inner class WorkerViewHolder(val viewBinding: ItemMainBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(model: WorkerInfoUIModel) {
            Glide.with(viewBinding.root.context)
                .load(model.avatarUrl)
                .centerCrop()
                .into(viewBinding.ivAvatar)

            //viewBinding.tvCall.text = "${model.name} + ${model.lastName}"
            viewBinding.tvJob.text = model.position
            viewBinding.tvJobSymbols.text = model.userTag
        }
    }

    class DiffUtilsCallback : DiffUtil.ItemCallback<WorkerInfoUIModel>() {
        override fun areItemsTheSame(
            oldItem: WorkerInfoUIModel,
            newItem: WorkerInfoUIModel
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: WorkerInfoUIModel,
            newItem: WorkerInfoUIModel
        ): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder = WorkerViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
