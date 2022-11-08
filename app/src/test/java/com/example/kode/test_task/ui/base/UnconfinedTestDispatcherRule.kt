package com.example.kode.test_task.ui.base

import kotlinx.coroutines.test.UnconfinedTestDispatcher

class UnconfinedTestDispatcherRule : TestDispatcherRule(UnconfinedTestDispatcher())