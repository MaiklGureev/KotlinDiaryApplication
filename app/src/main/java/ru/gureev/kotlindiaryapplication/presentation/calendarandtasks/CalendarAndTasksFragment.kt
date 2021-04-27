package ru.gureev.kotlindiaryapplication.presentation.calendarandtasks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.gureev.kotlindiaryapplication.App
import ru.gureev.kotlindiaryapplication.databinding.CalendarAndTasksFragmentBinding
import ru.gureev.kotlindiaryapplication.domain.mappers.TaskToTimeIntervalWithTasksMapper
import java.util.*


class CalendarAndTasksFragment : Fragment() {

    private val TAG = "CalendarAndTasksFragment"

    private var _binding: CalendarAndTasksFragmentBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewModel: CalendarAndTasksViewModel

    lateinit var timeIntervalAdapter: TimeIntervalAdapter

    init {
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CalendarAndTasksFragmentBinding.inflate(layoutInflater, container, false)
        timeIntervalAdapter = TimeIntervalAdapter(TaskToTimeIntervalWithTasksMapper())
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CalendarAndTasksViewModel::class.java)

        viewModel.tasksListFlow.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onActivityCreated: $it")
            timeIntervalAdapter.updateTasksList(it)
        })


        binding.calendarView.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
            timeIntervalAdapter.changeCurrentDate(Calendar.getInstance().apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, month)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            })

        })
//        lifecycleScope.launchWhenStarted {
//            delay(500)
//            val tasksRepository = TasksRepositoryImpl()
//            tasksRepository.saveTask(Task().apply {
//                name = "My task"
//                description = "My description"
//                date_start = Calendar.getInstance().also {
//                    it[Calendar.YEAR] = 2021
//                    it[Calendar.MONTH] = 4
//                    it[Calendar.DATE] = 27
//                    it[Calendar.HOUR_OF_DAY] = 5
//                    it[Calendar.MINUTE] = 15
//                }.timeInMillis
//                date_finish = Calendar.getInstance().also {
//                    it[Calendar.YEAR] = 2021
//                    it[Calendar.MONTH] = 7
//                    it[Calendar.DATE] = 27
//                    it[Calendar.HOUR_OF_DAY] = 5
//                    it[Calendar.MINUTE] = 50
//                }.timeInMillis
//            })
//        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = timeIntervalAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}



