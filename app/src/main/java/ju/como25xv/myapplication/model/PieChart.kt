package ju.como25xv.myapplication.model

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PieChart(values: Map<Category, Double>) {

    val colors = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Yellow
    )

    val total = values.values.sum()
    var startAngle = 0f

    Canvas(
        modifier = Modifier
            .size(200.dp)
            .padding(20.dp)
    ) {
        values.entries.forEachIndexed { index, entry ->
            val sweep = ((entry.value / total) * 360).toFloat()

            drawArc(
                color = colors[index % colors.size],
                startAngle = startAngle,
                sweepAngle = sweep,
                useCenter = true
            )
            startAngle += sweep
        }
    }
}
