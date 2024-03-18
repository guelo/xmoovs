import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.net.URL
import java.net.URLEncoder

const val URL =
    "https://flickmetrix.com/api2/values/getFilms?amazonRegion=us&cast=&comboScoreMax=100&comboScoreMin=0&countryCode=us&criticRatingMax=100&criticRatingMin=0&criticReviewsMax=1000&criticReviewsMin=0&currentPage=0&deviceID=1&director=&format=movies&genreAND=false&imdbRatingMax=10&imdbRatingMin=0&imdbVotesMax=2800000&imdbVotesMin=0&inCinemas=true&includeDismissed=true&includeSeen=true&includeWantToWatch=true&isCastSearch=false&isDirectorSearch=false&isPersonSearch=false&language=all&letterboxdScoreMax=100&letterboxdScoreMin=0&letterboxdVotesMax=1200000&letterboxdVotesMin=0&metacriticRatingMax=100&metacriticRatingMin=0&metacriticReviewsMax=100&metacriticReviewsMin=0&onAmazonPrime=false&onAmazonVideo=false&onDVD=false&onNetflix=false&pageSize=20&path=%2F&person=&plot=&queryType=GetFilmsToSieve&searchTerm=REPLACE&sharedUser=&sortOrder=comboScoreDesc&title=&token=&watchedRating=0&writer=&yearMax=2022&yearMin=1900"

data class Movie(
    val Title: String,
    val Year: Int,
    val ComboScore: Float,
    val Genre: String,
    val Awards: String,
    val MetacriticRating: String,
    val imdbRating: String,
    val imdbVotes: String,
    val imdbID: String,
)

fun main(args: Array<String>) {
    val file = File(args[0])
    println("Title, Year, ComboScore, Genre, Awards, MetacriticRating, imdbRating, imdbVotes, imdbID")

    file.readLines()
        .map {
            val (a, p) = """(.*?) \((\d+)\)""".toRegex().find(it)?.destructured ?: TODO("fail at $it")
            Pair(a, p.toInt())
        }
        .forEach { (n1, year) ->

            try {
                val name = n1.replace("\\(.*".toRegex(), "")
                val url = URL.replaceFirst("REPLACE", URLEncoder.encode(name, "utf-8"))
                val a = URL(url).readText()
                val json = cleanupJson(a)
                val array = JSONArray(json).filter {
                    (it as JSONObject).getInt("Year") == year
                }

                var obj : JSONObject? = null
                if (array.size > 1) {
                    val nameMatch = array.filter { (it as JSONObject).getString("Title") == name  }
                    if (nameMatch.size == 1) {
                        obj = nameMatch[0] as JSONObject
                    }
                }
                if (array.isNotEmpty()) {
                    obj = array.first() as JSONObject
                }
                if (obj != null ) {

                    val m: Movie = Gson().fromJson(obj.toString(), Movie::class.java)

                    println(with(m) {
                        "\"$Title\", $Year, $ComboScore, \"$Genre\", $Awards, $MetacriticRating, $imdbRating, $imdbVotes, $imdbID"
                    })
                }
            } catch (e: Exception) {
                println(n1 +" $year")
                throw e
            }
        }

}


fun cleanupJson(network: String): String {
    val a = network
        .replace("""\\\"""", "")
        .replace("\\n","")
        .replace("\\r","")
    return a
        .unescape()
        .replaceFirst("\"", "")
        .replace(""""$""".toRegex(), "")
/*
        .replace("\\", "")
*/
}

fun String.unescape() = JSONUtil.unescape(this)
