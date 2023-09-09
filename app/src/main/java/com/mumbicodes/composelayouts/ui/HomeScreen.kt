package com.mumbicodes.composelayouts.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mumbicodes.composelayouts.R
import com.mumbicodes.composelayouts.model.Podcast
import com.mumbicodes.composelayouts.model.podcasts
import com.mumbicodes.composelayouts.ui.components.HorizontalEpisode
import com.mumbicodes.composelayouts.ui.components.PodcastSection
import com.mumbicodes.composelayouts.ui.components.Show

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val podcasts by remember { mutableStateOf(podcasts) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TopSection()
        Shows(podcasts = podcasts)
        Episodes(episodes = podcasts)
    }
}

@Preview
@Composable
fun TopSection(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Good morning",
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleSmall,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Icon(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.plus),
            contentDescription = "Add icon button",
            tint = MaterialTheme.colorScheme.onBackground
        )
        Icon(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.plus),
            contentDescription = "Add icon button",
            tint = MaterialTheme.colorScheme.onBackground
        )
        Icon(
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.plus),
            contentDescription = "Add icon button",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}
/**
 * Lazy Row : The horizontally scrolling list that only composes and lays out the currently visible items*/
@Composable
fun Shows(
    modifier: Modifier = Modifier,
    podcasts: List<Podcast>,
) {
    PodcastSection(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        sectionHeader = "Your Shows"
    ) {
        LazyRow(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(podcasts) { podcast ->
                Show(podcast = podcast)
            }
        }
    }
}

/**
 * Lazy horizontal grid layout - It composes only visible columns of the grid.*/
@Preview
@Composable
fun Episodes(
    modifier: Modifier = Modifier,
    episodes: List<Podcast> = podcasts,
) {
    PodcastSection(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        sectionHeader = "New episodes"
    ) {
        LazyHorizontalGrid(
            modifier = Modifier.height(160.dp),
            rows = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(episodes) { podcast ->
                HorizontalEpisode(podcast = podcast)
            }
        }
    }
}

