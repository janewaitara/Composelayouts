package com.mumbicodes.composelayouts.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
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
import com.mumbicodes.composelayouts.R
import com.mumbicodes.composelayouts.model.Podcast
import com.mumbicodes.composelayouts.model.podcasts
import com.mumbicodes.composelayouts.ui.theme.ComposelayoutsTheme

@Composable
fun HorizontalEpisode(
    modifier: Modifier = Modifier,
    podcast: Podcast,
    onEpisodeClicked: () -> Unit = {},
) {
    ConstraintLayout(
        modifier = modifier
            .width(300.dp)
            .wrapContentHeight()
            .clickable {
                onEpisodeClicked()
            }
    ) {
        val (image, podcastTitle, podcastOwner, addIconButton, playIconButton) = createRefs()

        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraSmall)
                .size(72.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            painter = painterResource(id = podcast.image),
            contentDescription = "${podcast.podcastTitle} banner",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .constrainAs(podcastTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                },
            text = podcast.podcastTitle,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            maxLines = 3
        )
        Icon(
            modifier = Modifier
                .constrainAs(addIconButton) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(podcastTitle.start)
                }
                .padding(start = 8.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.plus),
            contentDescription = "Add icon button",
            tint = MaterialTheme.colorScheme.onBackground
        )
        Icon(
            modifier = Modifier
                .constrainAs(playIconButton) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(podcastTitle.end)
                }
                .padding(end = 4.dp)
                .size(20.dp),
            painter = painterResource(id = R.drawable.play),
            contentDescription = "Add icon button",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun HorizontalEpisodePreview() {
    ComposelayoutsTheme {
        Column(
            Modifier
                .size(400.dp)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(48.dp)
        ) {
            HorizontalEpisode(
                podcast = podcasts.first()
            )
            Spacer(Modifier.height(24.dp))
            HorizontalEpisode(
                podcast = podcasts.first()
            )
        }
    }
}