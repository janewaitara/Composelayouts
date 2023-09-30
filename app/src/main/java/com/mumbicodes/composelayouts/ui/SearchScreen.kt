package com.mumbicodes.composelayouts.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mumbicodes.composelayouts.model.podcasts
import com.mumbicodes.composelayouts.ui.components.PodcastSection
import com.mumbicodes.composelayouts.ui.components.SearchCategories
import com.mumbicodes.composelayouts.ui.theme.ComposelayoutsTheme

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    val podcasts by remember { mutableStateOf(podcasts) }

    PodcastSection(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        sectionHeader = "Browse all"
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(podcasts) { podcast ->
                SearchCategories(podcast = podcast)
            }
        }
    }
}

/**
 * Lazy vertical grid layout - It composes only visible columns of the grid.*/
@Preview
@Composable
fun SearchScreenPreview() {
    ComposelayoutsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen()
        }
    }
}
