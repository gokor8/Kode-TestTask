package com.example.kode.test_task.ui.core.provides

import androidx.fragment.app.FragmentActivity
import com.example.kode.domain.core.Provide

interface ProvideActivity : Provide<FragmentActivity>, RequireActivity {

    override fun <P : FragmentActivity> provide() = requireActivity() as P
}