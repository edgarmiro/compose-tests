package mo.example.compose.tests.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mo.example.compose.tests.ui.theme.AppTheme

@Composable
fun MenuScreen(
    onProgressClick: () -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
        ) {
            item {
                ListItem(
                    modifier = Modifier.clickable(onClick = onProgressClick),
                    headlineContent = { Text(text = "Go to progress screen") },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        MenuScreen(
            onProgressClick = { },
        )
    }
}
