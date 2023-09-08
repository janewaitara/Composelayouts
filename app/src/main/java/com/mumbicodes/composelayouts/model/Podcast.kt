package com.mumbicodes.composelayouts.model

import androidx.annotation.DrawableRes
import com.mumbicodes.composelayouts.R

data class Podcast(
    val category: String,
    val podcastTitle: String,
    val podcastOwner: String,
    @DrawableRes val image: Int,
)

val podcasts = listOf(
    Podcast(
        "Technology",
        "Tech Talk: The Latest in Tech News and Trends",
        "John Doe",
        R.drawable.podcast1
    ),
    Podcast(
        "Sports",
        "Sports News: The Latest Scores and Highlights",
        "Jane Smith",
        R.drawable.podcast2
    ),
    Podcast(
        "Comedy",
        "Laugh Out Loud: Hilarious Stand-Up Comedy and Sketches",
        "Bob Johnson",
        R.drawable.podcast3
    ),
    Podcast(
        "Technology",
        "Tech Talk: The Latest in Tech News and Trends",
        "John Doe",
        R.drawable.podcast4
    ),
    Podcast(
        "Sports",
        "Sports News: The Latest Scores and Highlights",
        "Jane Smith",
        R.drawable.podcast5
    ),
    Podcast(
        "Comedy",
        "Laugh Out Loud: Hilarious Stand-Up Comedy and Sketches",
        "Bob Johnson",
        R.drawable.podcast6
    ),
    Podcast(
        "Business",
        "Money Matters: Financial News and Investment Tips",
        "David Lee",
        R.drawable.podcast7
    ),
    Podcast(
        "Health",
        "Healthy Habits: Tips and Tricks for Living a Healthy Lifestyle",
        "Emily Chen",
        R.drawable.podcast8
    ),
    Podcast(
        "Science",
        "Science Spotlight: The Latest Discoveries and Breakthroughs",
        "Michael Brown",
        R.drawable.podcast9
    ),
    Podcast(
        "Education",
        "Learning Lab: Educational Insights and Tips for Teachers and Students",
        "Jessica Kim",
        R.drawable.podcast5
    ),
    Podcast(
        "Entertainment",
        "Pop Culture Picks: The Latest in Movies, TV, and Music",
        "Alex Rodriguez",
        R.drawable.podcast4
    ),
    Podcast(
        "Food",
        "Foodie Finds: The Best Restaurants and Recipes",
        "Samantha Lee",
        R.drawable.podcast3
    ),
    Podcast(
        "Sports",
        "Game Time: The Latest Scores and Analysis",
        "Chris Johnson",
        R.drawable.podcast1
    )
)
