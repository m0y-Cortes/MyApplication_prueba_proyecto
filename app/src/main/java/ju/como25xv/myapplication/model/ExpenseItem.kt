package ju.como25xv.myapplication.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExpenseItem(expense: Expense) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFFE8E8E8))
            .padding(16.dp)
    ) {
        Text(expense.title, modifier = Modifier.weight(1f))
        Text("$${expense.amount}")
    }
}
