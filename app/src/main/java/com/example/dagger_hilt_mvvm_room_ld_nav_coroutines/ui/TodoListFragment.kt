package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.R
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.databinding.FragmentTodoListBinding


class TodoListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!

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

        binding.fabAddTask.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_todoListFragment_to_addTodoFragment
            )
        }



    }


}