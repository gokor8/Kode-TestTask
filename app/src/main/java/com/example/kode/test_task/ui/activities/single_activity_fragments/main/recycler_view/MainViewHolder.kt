package com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view

import com.bumptech.glide.Glide
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolder

class MainViewHolder(viewBinding: ItemMainBinding) :
    BaseViewHolder<WorkerInfoUIModel, ItemMainBinding>(viewBinding) {

    override fun onBind(model: WorkerInfoUIModel) {

        /*Glide.with(viewBinding.root.context)
            .load(model.avatarUrl)
            .centerCrop()
            .into(viewBinding.ivAvatar)*/

        viewBinding.tvCall.text = "${model.name} + ${model.lastName}"
        viewBinding.tvJob.text = model.position
        viewBinding.tvJobSymbols.text = model.userTag
    }
}