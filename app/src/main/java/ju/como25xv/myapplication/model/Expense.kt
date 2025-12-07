package ju.como25xv.myapplication.model

data class Expense(
    val title: String,
    val amount: Double,
    val category: Category,
    val description: String
)
