package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.success

import com.bumptech.glide.Glide
import com.example.kode.domain.core.Base
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.FragmentWorkerBinding
import com.example.kode.test_task.di.annotations.worker_fragment.WorkerFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.visibility_handler.VisibilityVGHandler
import java.lang.ref.WeakReference
import javax.inject.Inject

class UISuccessMapper @Inject constructor(
    @WorkerFragmentBinding
    private val binding: WeakReference<FragmentWorkerBinding>,
    private val visibilityVGHandler: VisibilityVGHandler
) : Base.Mapper<WorkerStatesUI.Success, Unit> {

    override fun map(model: WorkerStatesUI.Success) = binding.get()?.apply {

        visibilityVGHandler.comboInverse(llMain, pbLoad, iError.llError)

        with(model) {
            val context = root.context

            Glide.with(context)
                .load(avatarUrl)
                .placeholder(R.drawable.ic_avatar_placeholder)
                .optionalCircleCrop()
                .into(ivAvatar)

            tvFullName.text =
                context.getString(R.string.first_name_last_name, firstName, lastName)

            tvJobSymbols.text = userTag
            tvPosition.text = position
            tvDate.text = birthday
            tvAge.text = context.getString(R.string.worker_age, age)
            tvPhone.text = phone
        }
    }.let {}
}