package com.harera.leetcode.leetcode843


class Master(private val secret: String) {
    fun guess(word: String): Int {
        var count = 0
        for (i in secret.indices) {
            if (secret[i] == word[i]) {
                count++
            }
        }
        if (count == 6) {
            println("That's it")
        }
        return count
    }
}

class Solution {
    fun findSecretWord(words: Array<String>, master: Master) {
        val word = words[0]
        val listMap: Map<Int, List<String>> = words.groupBy({
            diff(it, word)
        }, {
            it
        })

        val guess = master.guess(word)
        listMap[6 - guess]?.forEach {
            master.guess(it)
        }
    }

    private fun diff(word: String, secret: String): Int {
        var count = 0
        for (i in secret.indices) {
            if (secret[i] == word[i]) {
                count++
            }
        }
        return count
    }
}

fun main() {
    val solution = Solution()
    val words = arrayOf(
        "gaxckt",
        "trlccr",
        "jxwhkz",
        "ycbfps",
        "peayuf",
        "yiejjw",
        "ldzccp",
        "nqsjoa",
        "qrjasy",
        "pcldos",
        "acrtag",
        "buyeia",
        "ubmtpj",
        "drtclz",
        "zqderp",
        "snywek",
        "caoztp",
        "ibpghw",
        "evtkhl",
        "bhpfla",
        "ymqhxk",
        "qkvipb",
        "tvmued",
        "rvbass",
        "axeasm",
        "qolsjg",
        "roswcb",
        "vdjgxx",
        "bugbyv",
        "zipjpc",
        "tamszl",
        "osdifo",
        "dvxlxm",
        "iwmyfb",
        "wmnwhe",
        "hslnop",
        "nkrfwn",
        "puvgve",
        "rqsqpq",
        "jwoswl",
        "tittgf",
        "evqsqe",
        "aishiv",
        "pmwovj",
        "sorbte",
        "hbaczn",
        "coifed",
        "hrctvp",
        "vkytbw",
        "dizcxz",
        "arabol",
        "uywurk",
        "ppywdo",
        "resfls",
        "tmoliy",
        "etriev",
        "oanvlx",
        "wcsnzy",
        "loufkw",
        "onnwcy",
        "novblw",
        "mtxgwe",
        "rgrdbt",
        "ckolob",
        "kxnflb",
        "phonmg",
        "egcdab",
        "cykndr",
        "lkzobv",
        "ifwmwp",
        "jqmbib",
        "mypnvf",
        "lnrgnj",
        "clijwa",
        "kiioqr",
        "syzebr",
        "rqsmhg",
        "sczjmz",
        "hsdjfp",
        "mjcgvm",
        "ajotcx",
        "olgnfv",
        "mjyjxj",
        "wzgbmg",
        "lpcnbj",
        "yjjlwn",
        "blrogv",
        "bdplzs",
        "oxblph",
        "twejel",
        "rupapy",
        "euwrrz",
        "apiqzu",
        "ydcroj",
        "ldvzgq",
        "zailgu",
        "xgqpsr",
        "wxdyho",
        "alrplq",
        "brklfk"
    )
    val master = Master("hbaczn")
    solution.findSecretWord(words, master)
}