package ju.como25xv.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import ju.como25xv.myapplication.ui.theme.MyApplicationTheme
import kotlin.getValue
import ju.como25xv.myapplication.view.ExpenseViewModel
import ju.como25xv.myapplication.navigation.NavGraph

class MainActivity : ComponentActivity() {

    private val viewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                NavGraph(viewModel)
            }
        }
    }
}
