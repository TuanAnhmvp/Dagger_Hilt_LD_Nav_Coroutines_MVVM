package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.adapter.ui

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.databinding.ItemTodoLayoutBinding
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.model.Todo

class TodoAdapter(
    private val onDelete: (Todo) -> Unit): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoLayoutBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Todo>(){
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var mTodo: List<Todo>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentToDo = mTodo[position]

        holder.binding.apply {
            textView.text = currentToDo.todoTitle
        }

        holder.binding.cbTodo.apply {
            this.setOnClickListener {
                holder.binding.apply {
                    if(isChecked){
                        textView.paintFlags = textView.paintFlags or
                                Paint.STRIKE_THRU_TEXT_FLAG
                    } else {
                        textView.paintFlags = textView.paintFlags and
                                Paint.STRIKE_THRU_TEXT_FLAG.inv()
                    }
                }
            }
        }

        holder.binding.itemImageDelete.setOnClickListener { onDelete(currentToDo) }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}