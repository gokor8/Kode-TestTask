package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel<MainStatesUI, *>>() {

    @Inject
    lateinit var registrationViewModel: MainViewModel<MainStatesUI, WorkersStateEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun setObservers() {
        viewModel.observe(viewLifecycleOwner) {
            when(it) {
                is MainStatesUI.Success -> {}
                is MainStatesUI.Fail.Error -> {}
                is MainStatesUI.Fail.NoConnection -> {}
            }
        }
    }

    override fun setBind() = FragmentMainBinding.inflate(layoutInflater)

    override fun setViewModel() = registrationViewModel

}