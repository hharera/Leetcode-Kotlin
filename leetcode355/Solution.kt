package com.harera.leetcode.leetcode355

import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.min

class Twitter() {

    var time = AtomicInteger(1)
    data class Tweet(val userId: Int, val tweetId: Int, val order: Int)

    private val userTweets = List(505) {
        PriorityQueue<Tweet>(compareByDescending {
            it.order
        })
    }

    private val following = List(505) { HashSet<Int>(505) }

    fun postTweet(userId: Int, tweetId: Int) {
        userTweets[userId].add(Tweet(userId, tweetId, time.getAndIncrement()))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        var tweets = mutableListOf<Tweet>()
        (following[userId]).plus(userId).map {
            val _tweets = userTweets[it].toList()
            for (i in 0 until min(10, _tweets.size)) {
                tweets.add(_tweets[_tweets.lastIndex - i])
            }
        }
        tweets.sortByDescending {
            it.order
        }
        val result = mutableListOf<Int>()
        for (i in 0 until min(10, tweets.size)) {
            result.add(tweets[i].tweetId)
        }
        for (i in 10..tweets.lastIndex) {
            val cur = tweets[i]
            userTweets[cur.userId].add(cur)
        }
        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        following[followerId].add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        following[followerId].remove(followeeId)
    }
}

fun main() {
    val solution = Twitter()
    // ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
    // [[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]
    solution.postTweet(1, 5)
    solution.postTweet(1, 3)
    solution.postTweet(1, 101)
    solution.postTweet(1, 13)
    solution.postTweet(1, 10)
    solution.postTweet(1, 2)
    solution.postTweet(1, 94)
    solution.postTweet(1, 505)
    solution.postTweet(1, 333)
    solution.postTweet(1, 22)
    solution.postTweet(1, 11)
    println(solution.getNewsFeed(1))
}