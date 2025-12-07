package ju.como25xv.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ju.como25xv.myapplication.view.ExpenseViewModel
import ju.como25xv.myapplication.model.PieChart

@Composable
fun StatsScreen(viewModel: ExpenseViewModel) {

    val stats = viewModel.getCategoryStats()
    val total = stats.values.sum()

    Column(Modifier.padding(20.dp)) {

        PieChart(stats)

        Spacer(Modifier.height(20.dp))

        stats.forEach { (category, value) ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(category.label)
                Text("${((value / total) * 100).toInt()}%")
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}
