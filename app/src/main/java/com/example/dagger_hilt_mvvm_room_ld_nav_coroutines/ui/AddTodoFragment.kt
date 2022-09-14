package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.ui

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.R
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.databinding.FragmentAddTodoBinding
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model.Todo
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.viewmodel.TodoViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTodoFragment : Fragment() {

    private var _binding: FragmentAddTodoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TodoViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCancel.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_addTodoFragment_to_todoListFragment
            //
            )
        }

        //handle click btn add
        binding.btnAddTask.setOnClickListener { mView ->
            saveTodo(mView)
        }
    }

    private fun saveTodo(mView: View) {
        val todoName = binding.etTodoName.text.toString().trim()
        if(todoName.isNotEmpty()){
            val todo = Todo(0, todoName)
            viewModel.insertTodo(todo)

            Snackbar.make(mView, "Todo added", Snackbar.LENGTH_SHORT).show()

            mView.findNavController().navigate(R.id.action_addTodoFragment_to_todoListFragment)

        } else {
            val toast = Toast.makeText(
                activity, "Todo title cannot be empty", Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.CENTER, 0,0)
            toast.show()
        }
    }


}