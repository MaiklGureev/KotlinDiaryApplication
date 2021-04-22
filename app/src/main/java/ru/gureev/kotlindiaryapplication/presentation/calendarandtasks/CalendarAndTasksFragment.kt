package ru.gureev.kotlindiaryapplication.presentation.calendarandtasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.gureev.kotlindiaryapplication.databinding.CalendarAndTasksFragmentBinding

class CalendarAndTasksFragment : Fragment() {

    private var _binding: CalendarAndTasksFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = CalendarAndTasksFragment()
    }

    private lateinit var viewModel: CalendarAndTasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CalendarAndTasksFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CalendarAndTasksViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onClick(view: View) {

    }


}