package com.example.sqlcomroom

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sqlcomroom.data.UserDao
import com.example.sqlcomroom.data.UserDatabase
import com.example.sqlcomroom.data.UserRepository
import com.example.sqlcomroom.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(context: Context?) : ViewModel() {


    val lerTodosOsDados: LiveData<List<User>>

    val repository: UserRepository

    init {

        val userDao = UserDatabase.getDataBase(context!!).userDao()
        repository = UserRepository(userDao)
        lerTodosOsDados = repository.lerTodosOsDados
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)

        }


    }


}