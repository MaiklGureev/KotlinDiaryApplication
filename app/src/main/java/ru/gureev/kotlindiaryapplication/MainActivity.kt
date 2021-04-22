package ru.gureev.kotlindiaryapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

//    @Inject lateinit var classA: ClassA
//    @Inject lateinit var classB: ClassB
//
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, CalendarAndTasksFragment.newInstance())
//                .commitNow()
//        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

//        //init dagger2
//        App.appComponent.inject(this)
//
//        //init ViewBinding
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        //use ViewBinding
//        binding.helloWorldText.text = classA.getHelloFromClassB()
//
//        //use Dagger2
//        classB.sayHelloFromToast()
    }


}