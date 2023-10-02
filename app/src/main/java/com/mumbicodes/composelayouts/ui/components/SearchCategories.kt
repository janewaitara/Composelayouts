package com.mumbicodes.composelayouts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mumbicodes.composelayouts.model.Podcast
import com.mumbicodes.composelayouts.model.podcasts
import com.mumbicodes.composelayouts.ui.theme.ComposelayoutsTheme
import com.mumbicodes.composelayouts.ui.theme.categoryColors

@Composable
fun SearchCategories(
    modifier: Modifier = Modifier,
    podcast: Podcast,
) {
    Box(
        modifier = modifier
            .size(160.dp, height = 136.dp)
            .background(color = categoryColors.random())
            .clip(MaterialTheme.shapes.small)
    ) {
        Text(
            modifier = Modifier
                .padding(12.dp),
            text = podcast.category,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleSmall,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Card(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .rotate(28f)
                .offset((36).dp),
            shape = MaterialTheme.shapes.small
        ) {

            Image(
                modifier = Modifier
                    .size(96.dp),
                painter = painterResource(id = podcast.image),
                contentDescription = "${podcast.podcastTitle} banner",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun searchCategoryPreview() {
    ComposelayoutsTheme {
        Scaffold { paddingValues ->
            SearchCategories(
                modifier = Modifier.padding(paddingValues),
                podcast = podcasts.first()
            )
        }
    }
}
