package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.R
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.adapter.ui.TodoAdapter
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.databinding.FragmentTodoListBinding
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model.Todo
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: TodoAdapter
    private val viewModel:TodoViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoListBinding.inflate(
            inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRv()

        binding.fabAddTask.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_todoListFragment_to_addTodoFragment
            )
        }



    }

    private fun setupRv() {
        todoAdapter = TodoAdapter()
        binding.rvTodoList.apply {
            adapter = todoAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)

        }
        viewModel.getAllToDos.observe(requireActivity()) { listTodo ->
            updateUi(listTodo)
            todoAdapter.mTodo = listTodo

        }
    }

    private fun updateUi(listTodo: List<Todo>) {
        if(listTodo.isNotEmpty()){
            binding.rvTodoList.visibility = View.VISIBLE
            binding.cardView.visibility = View.GONE
        }
        else{
            binding.rvTodoList.visibility = View.GONE
            binding.cardView.visibility = View.VISIBLE
        }
    }


}