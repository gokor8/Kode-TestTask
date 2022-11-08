package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

sealed interface MainResultVisibility {

    class RVAdapter : MainResultVisibility

    class IError : MainResultVisibility

    class ISearchError : MainResultVisibility
}