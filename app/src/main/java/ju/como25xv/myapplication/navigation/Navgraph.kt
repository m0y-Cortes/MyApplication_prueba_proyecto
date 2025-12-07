package ju.como25xv.myapplication.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ju.como25xv.myapplication.screen.StatsScreen
import ju.como25xv.myapplication.screen.HomeScreen
import ju.como25xv.myapplication.screen.NewExpenseScreen
import ju.como25xv.myapplication.view.ExpenseViewModel

@Composable
fun NavGraph(viewModel: ExpenseViewModel) {
    val navController = rememberNavController()

    Scaffold(
        topBar = { AppTopBar(navController) }
    ) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") { HomeScreen(viewModel) }
                composable("new") { NewExpenseScreen(viewModel, navController) }
                composable("stats") { StatsScreen(viewModel) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(navController: NavHostController) {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF4A4A58)
        ),
        actions = {
            TextButton(onClick = { navController.navigate("home") }) { Text("Home", color = Color.White) }
            TextButton(onClick = { navController.navigate("new") }) { Text("New Expense", color = Color.White) }
            TextButton(onClick = { navController.navigate("stats") }) { Text("Stats", color = Color.White) }
        }
    )
}
