package com.mumbicodes.composelayouts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.mumbicodes.composelayouts.model.Podcast
import com.mumbicodes.composelayouts.model.podcasts
import com.mumbicodes.composelayouts.ui.theme.ComposelayoutsTheme

/**
 * Constraint Layout :
 * a layout that allows you to place composables relative to other composables on the screen
 * */
@Composable
fun Show(
    modifier: Modifier = Modifier,
    podcast: Podcast,
    onShowClicked: () -> Unit = {}
) {
    ConstraintLayout(
        modifier = modifier
            .width(120.dp)
            .wrapContentHeight()
            .clickable {
                onShowClicked()
            }
    ) {
        val (image, category, podcastTitle, podcastOwner) = createRefs()

        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraSmall)
                .height(120.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = podcast.image),
            contentDescription = "${podcast.podcastTitle} banner",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .padding(top = 4.dp)
                .constrainAs(category) {
                    top.linkTo(image.bottom)
                    start.linkTo(image.start)
                    end.linkTo(image.end)

                    width = Dimension.fillToConstraints
                },
            text = podcast.category,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            modifier = Modifier.constrainAs(podcastTitle) {
                top.linkTo(category.bottom)
                start.linkTo(category.start)
                end.linkTo(category.end)

                width = Dimension.fillToConstraints
            },
            text = podcast.podcastTitle,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            modifier = Modifier.constrainAs(podcastOwner) {
                top.linkTo(podcastTitle.bottom)
                start.linkTo(podcastTitle.start)
                end.linkTo(podcastTitle.end)

                width = Dimension.fillToConstraints
            },
            text = podcast.podcastOwner,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun ShowPreview() {
    ComposelayoutsTheme {
        Show(podcast = podcasts.first())
    }
}