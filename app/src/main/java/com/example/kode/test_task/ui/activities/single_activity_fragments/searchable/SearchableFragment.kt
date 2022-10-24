package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.viewbinding.ViewBinding
import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.SingleActivity
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.SearchResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import com.example.kode.test_task.ui.core.fragments.BaseFragment
import javax.inject.Inject

abstract class SearchableFragment<
        VB : ViewBinding, UIM : UISearchInputState,
        UOM : SearchResultStatesUI,
        > : BaseFragment<VB, SearchableViewModel<UIM, UOM>>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setupSearch()
    }

   /* fun setupSearch() =
        provideActivity<SingleActivity>().binding.iSearch.etSearch.addTextChangedListener {
            viewModel.search(
                stringToSearchInputMapper.map(it.toString())
            )
        }*/
}