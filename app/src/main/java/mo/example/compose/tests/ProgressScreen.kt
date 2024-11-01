package mo.example.compose.tests

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mo.example.compose.tests.ui.theme.AppTheme

@Composable
fun ProgressScreen(onTimerFinish: () -> Unit) {
    var enabled by remember { mutableStateOf(false) }
    var goVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        enabled = true
    }

    val progress by animateFloatAsState(
        targetValue = if (enabled) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearEasing,
        ),
        label = "circular",
        finishedListener = {
            goVisible = true
            onTimerFinish()
        },
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier.size(64.dp).semantics { contentDescription = "Circular progress" },
            strokeWidth = 2.dp,
            strokeCap = StrokeCap.Round,
        )

        if (goVisible) {
            Text("GO!")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        ProgressScreen(onTimerFinish = {})
    }
}
