package ju.como25xv.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import ju.como25xv.myapplication.model.Category
import ju.como25xv.myapplication.view.ExpenseViewModel

@Composable
fun NewExpenseScreen(viewModel: ExpenseViewModel, navController: NavHostController) {

    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(Category.ENTERTAINMENT) }

    Column(Modifier.padding(20.dp)) {

        Text("Title", style = MaterialTheme.typography.headlineMedium)
        TextField(value = title, onValueChange = { title = it })

        Spacer(Modifier.height(10.dp))

        Text("Amount")
        TextField(value = amount, onValueChange = { amount = it })

        Spacer(Modifier.height(10.dp))

        Text("Category")
        Box {
            TextField(
                value = category.label,
                onValueChange = {},
                trailingIcon = {
                    IconButton(onClick = { expanded = true }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                    }
                },
                readOnly = true
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                Category.values().forEach { cat ->
                    DropdownMenuItem(
                        text = { Text(cat.label) },
                        onClick = {
                            category = cat
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(10.dp))

        Text("Description")
        TextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier.height(120.dp)
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                if (title.isNotEmpty() && amount.isNotEmpty()) {
                    viewModel.addExpense(title, amount.toDouble(), category, description)
                    navController.navigate("home")
                }
            }
        ) {
            Text("Add Expense")
        }
    }
}
