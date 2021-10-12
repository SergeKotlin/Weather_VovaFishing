package com.android1.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android1.weather.databinding.MainActivityBinding
import com.android1.weather.databinding.ResultProfileBinding
import com.android1.weather.ui.main.MainFragment
import com.android1.weather.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {

//-    private lateinit var binding: ResultProfileBinding
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(getLayoutInflater())
        setContentView(binding.root) // val view = binding.getRoot()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

/*      val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        И чё? Откуда он Активити знает о viewModel, и где это в ней такие методы?
        binding.name.setText(viewModel.getName())
        binding.button.setOnClickListener { viewModel.userClicked() } */
    }
}

//
// Преимущество MVP - что может напрямую что-то сказать делать вью. А также имеет чёткую логику разделения
// MVVM работает по подпискам.. слушателям. Но она умеет переживать поворот экрана, приучена к отключению view
//
// Если портретная ориентация, Владимир использует MVP. Но если необходима работа в двух ориентациях, то MVVM.