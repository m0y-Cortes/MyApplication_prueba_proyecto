package ju.como25xv.myapplication.view

import androidx.lifecycle.ViewModel
import ju.como25xv.myapplication.model.Category
import ju.como25xv.myapplication.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExpenseViewModel : ViewModel() {

    private val _expenses = MutableStateFlow<List<Expense>>(emptyList())
    val expenses = _expenses.asStateFlow()

    fun addExpense(title: String, amount: Double, category: Category, description: String) {
        val newExpense = Expense(
            title = title,
            amount = amount,
            category = category,
            description = description
        )
        _expenses.value = _expenses.value + newExpense
    }

    fun getCategoryStats(): Map<Category, Double> {
        return expenses.value.groupBy { it.category }
            .mapValues { (_, list) ->
                list.sumOf { it.amount }
            }
    }
}
