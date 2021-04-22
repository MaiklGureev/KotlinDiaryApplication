package ru.gureev.kotlindiaryapplication.presentation.diarydescription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.gureev.kotlindiaryapplication.R

class TaskDescriptionFragment : Fragment() {

    companion object {
        fun newInstance() = TaskDescriptionFragment()
    }

    private lateinit var viewModel: TaskDescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_description_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskDescriptionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}