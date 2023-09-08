package com.mumbicodes.composelayouts.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mumbicodes.composelayouts.ui.theme.ComposelayoutsTheme

@Composable
fun Badge(
    modifier: Modifier,
    contentType: String,
) {

    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.large
            )
            .padding(vertical = 4.dp, horizontal = 12.dp)
    ) {
        Text(
            text = contentType,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview
@Preview("dark theme", "rectangle", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BadgePreview() {
    ComposelayoutsTheme {
        Column(
            Modifier
                .size(200.dp)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(48.dp)
        ) {
            Badge(modifier = Modifier, contentType = "Podcast")
        }
    }
}