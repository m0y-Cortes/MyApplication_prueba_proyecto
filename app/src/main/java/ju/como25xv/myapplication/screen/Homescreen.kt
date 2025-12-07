package ju.como25xv.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ju.como25xv.myapplication.model.ExpenseItem
import ju.como25xv.myapplication.view.ExpenseViewModel

@Composable
fun HomeScreen(viewModel: ExpenseViewModel) {
    val expenses by viewModel.expenses.collectAsState()

    Column(Modifier.padding(16.dp)) {
        Text("Most recent", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(expenses.size) { i ->
                ExpenseItem(expenses[i])
                Spacer(Modifier.height(12.dp))
            }
        }
    }
}
