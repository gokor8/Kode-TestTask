package com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view

import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragmentDirections
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolder

class MainViewHolder(viewBinding: ItemMainBinding) :
    BaseViewHolder<PreviewWorkerInfoUIModel, ItemMainBinding>(viewBinding) {

    override fun setUI(model: PreviewWorkerInfoUIModel) = with(viewBinding) {
        val context = root.context

        Glide.with(context)
            .load(model.avatarUrl)
            .placeholder(R.drawable.ic_avatar_placeholder)
            .optionalCircleCrop()
            .into(ivAvatar)

        tvFullName.text = context.getString(
            R.string.first_name_last_name,
            model.name,
            model.lastName
        )
        tvJob.text = model.position
        tvJobSymbols.text = model.userTag
    }

    override fun setListeners(model: PreviewWorkerInfoUIModel) = with(viewBinding) {
        clMain.setOnClickListener {
            root.findNavController().navigate(
                MainFragmentDirections.actionOpenWorkerFragment(model.id)
            )
        }
    }
}