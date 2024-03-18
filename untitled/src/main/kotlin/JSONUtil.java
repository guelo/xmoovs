import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class JSONUtil {

    public static void main(String[] args) {
        String a = unescape("""
                "[{\\"ID\\":4972311,\\"imdbID\\":\\"tt0154263\\",\\"Title\\":\\"Bugs Bunny\\\\u0027s Looney Christmas Tales\\",\\"Year\\":1979,\\"Genre\\":\\"Animation\\",\\"Released\\":\\"\\\\/Date(312508800000)\\\\/\\",\\"Director\\":\\"Chuck Jones, Friz Freleng\\",\\"Cast\\":\\"Mel Blanc, June Foray\\",\\"imdbRating\\":7.0,\\"imdbVotes\\":489,\\"Poster\\":\\"/h01L3XtK2BsIWTvlkyIUbxGTKv3.jpg\\",\\"Plot\\":\\"A TV movie special that compiles of a few Looney Tunes episodes centered around an episode of a Christmas Carol, with the part of Scrooge played by Yosemite Sam.\\",\\"Language\\":\\"en\\",\\"Awards\\":null,\\"Image\\":null,\\"CriticRating\\":null,\\"CriticReviews\\":null,\\"Consensus\\":null,\\"MetacriticRating\\":null,\\"MetacriticReviews\\":null,\\"AudienceRating\\":null,\\"AudienceReviews\\":null,\\"DVD\\":null,\\"BoxOffice\\":null,\\"Production\\":null,\\"Trailer\\":null,\\"UserWantsToWatch\\":null,\\"UserSeen\\":null,\\"UserComments\\":null,\\"UserRating\\":null,\\"UserFavourite\\":null,\\"UserRecommends\\":null,\\"UserLikes\\":null,\\"ComboScore\\":67.00,\\"PosterPath\\":\\"/h01L3XtK2BsIWTvlkyIUbxGTKv3.jpg\\",\\"onDVD\\":true,\\"LetterboxdScore\\":64,\\"letterboxdVotes\\":137,\\"RTUrl\\":null,\\"Providers\\":[],\\"isTV\\":false},{\\"ID\\":4972378,\\"imdbID\\":\\"tt0079179\\",\\"Title\\":\\"Fright Before Christmas\\",\\"Year\\":1979,\\"Genre\\":\\"Animation, Family, Comedy\\",\\"Released\\":\\"\\\\/Date(312508800000)\\\\/\\",\\"Director\\":\\"Friz Freleng\\",\\"Cast\\":\\"Mel Blanc\\",\\"imdbRating\\":6.3,\\"imdbVotes\\":266,\\"Poster\\":\\"/7UxfPH40UaBuy1XaEwnuqUUWAZI.jpg\\",\\"Plot\\":\\"The Tasmanian Devil escapes from a plane and lands in Santa\\\\u0027s suit. After taking off in Santa\\\\u0027s sleigh he lands on Bugs\\\\u0027 roof where he tries to eat everything in sight including the present Bugs got for him.\\",\\"Language\\":\\"en\\",\\"Awards\\":null,\\"Image\\":null,\\"CriticRating\\":null,\\"CriticReviews\\":null,\\"Consensus\\":null,\\"MetacriticRating\\":null,\\"MetacriticReviews\\":null,\\"AudienceRating\\":null,\\"AudienceReviews\\":null,\\"DVD\\":null,\\"BoxOffice\\":null,\\"Production\\":null,\\"Trailer\\":null,\\"UserWantsToWatch\\":null,\\"UserSeen\\":null,\\"UserComments\\":null,\\"UserRating\\":null,\\"UserFavourite\\":null,\\"UserRecommends\\":null,\\"UserLikes\\":null,\\"ComboScore\\":62.00,\\"PosterPath\\":\\"/7UxfPH40UaBuy1XaEwnuqUUWAZI.jpg\\",\\"onDVD\\":true,\\"LetterboxdScore\\":60,\\"letterboxdVotes\\":123,\\"RTUrl\\":null,\\"Providers\\":[],\\"isTV\\":false},{\\"ID\\":4984735,\\"imdbID\\":\\"tt0078914\\",\\"Title\\":\\"Bugs Bunny\\\\u0027s Christmas Carol\\",\\"Year\\":1979,\\"Genre\\":\\"Animation, Comedy, TV Movie\\",\\"Released\\":\\"\\\\/Date(312508800000)\\\\/\\",\\"Director\\":\\"Friz Freleng\\",\\"Cast\\":\\"Mel Blanc\\",\\"imdbRating\\":6.6,\\"imdbVotes\\":362,\\"Poster\\":\\"/xXEzEWzSLqr6wbUE6BSYJI2gNKV.jpg\\",\\"Plot\\":\\"Yosemite Sam is miserly Ebenezer Scrooge in this spoof of Charles Dickens\\\\u0027 classic tale. Porky Pig, as Scrooge\\\\u0027s clerk, Bob Cratchit, is fired on Christmas eve for the unpardonable act of using coal to keep warm. When Scrooge evicts Cratchit and his family from their modest dwelling, heroic Bugs Bunny decides to dress like a ghost and teach the hot-tempered miser a lesson on the meaning of Christmas.\\",\\"Language\\":\\"en\\",\\"Awards\\":null,\\"Image\\":null,\\"CriticRating\\":null,\\"CriticReviews\\":null,\\"Consensus\\":null,\\"MetacriticRating\\":null,\\"MetacriticReviews\\":null,\\"AudienceRating\\":null,\\"AudienceReviews\\":null,\\"DVD\\":null,\\"BoxOffice\\":null,\\"Production\\":null,\\"Trailer\\":null,\\"UserWantsToWatch\\":null,\\"UserSeen\\":null,\\"UserComments\\":null,\\"UserRating\\":null,\\"UserFavourite\\":null,\\"UserRecommends\\":null,\\"UserLikes\\":null,\\"ComboScore\\":64.00,\\"PosterPath\\":\\"/xXEzEWzSLqr6wbUE6BSYJI2gNKV.jpg\\",\\"onDVD\\":true,\\"LetterboxdScore\\":62,\\"letterboxdVotes\\":147,\\"RTUrl\\":null,\\"Providers\\":[],\\"isTV\\":false},{\\"ID\\":4899187,\\"imdbID\\":\\"tt0079174\\",\\"Title\\":\\"Freeze Frame\\",\\"Year\\":1979,\\"Genre\\":\\"Animation, Comedy\\",\\"Released\\":null,\\"Director\\":\\"Chuck Jones\\",\\"Cast\\":\\"\\",\\"imdbRating\\":6.7,\\"imdbVotes\\":242,\\"Poster\\":\\"/8y4bsoXtjmEMjjyKcwX72in9mo2.jpg\\",\\"Plot\\":\\"Wile E. Coyote chases the Road Runner through some snowy mountaintops, leading to a series of snow-related traps such as the Acme Blizzard Machine which makes instant snow....a little too instant for the Coyote\\\\u0027s taste.\\",\\"Language\\":\\"en\\",\\"Awards\\":null,\\"Image\\":null,\\"CriticRating\\":65.0,\\"CriticReviews\\":2,\\"Consensus\\":null,\\"MetacriticRating\\":61,\\"MetacriticReviews\\":null,\\"AudienceRating\\":60,\\"AudienceReviews\\":1671,\\"DVD\\":null,\\"BoxOffice\\":null,\\"Production\\":null,\\"Trailer\\":null,\\"UserWantsToWatch\\":null,\\"UserSeen\\":null,\\"UserComments\\":null,\\"UserRating\\":null,\\"UserFavourite\\":null,\\"UserRecommends\\":null,\\"UserLikes\\":null,\\"ComboScore\\":65.00,\\"PosterPath\\":\\"/8y4bsoXtjmEMjjyKcwX72in9mo2.jpg\\",\\"onDVD\\":false,\\"LetterboxdScore\\":64,\\"letterboxdVotes\\":34,\\"RTUrl\\":\\"https://www.rottentomatoes.com/m/freeze_frame\\",\\"Providers\\":[],\\"isTV\\":false}]\"
                """);

        System.out.println(a);

    }

    public static String escape(String input) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int chx = (int) ch;

            // let's not put any nulls in our strings
            assert (chx != 0);

            if (ch == '\n') {
                output.append("\\n");
            } else if (ch == '\t') {
                output.append("\\t");
            } else if (ch == '\r') {
                output.append("\\r");
            } else if (ch == '\\') {
                output.append("\\\\");
            } else if (ch == '"') {
                output.append("\\\"");
            } else if (ch == '\b') {
                output.append("\\b");
            } else if (ch == '\f') {
                output.append("\\f");
            } else if (chx >= 0x10000) {
                assert false : "Java stores as u16, so it should never give us a character that's bigger than 2 bytes. It literally can't.";
            } else if (chx > 127) {
                output.append(String.format("\\u%04x", chx));
            } else {
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static String unescape(String input) {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        while (i < input.length()) {
            char delimiter = input.charAt(i);
            i++; // consume letter or backslash

            if (delimiter == '\\' && i < input.length()) {

                // consume first after backslash
                char ch = input.charAt(i);
                i++;

                if (ch == '\\' || ch == '/' || ch == '"' || ch == '\'') {
                    builder.append(ch);
                } else if (ch == 'n') builder.append('\n');
                else if (ch == 'r') builder.append('\r');
                else if (ch == 't') builder.append('\t');
                else if (ch == 'b') builder.append('\b');
                else if (ch == 'f') builder.append('\f');
                else if (ch == 'u') {

                    StringBuilder hex = new StringBuilder();

                    // expect 4 digits
                    if (i + 4 > input.length()) {
                        throw new RuntimeException("Not enough unicode digits! ");
                    }
                    for (char x : input.substring(i, i + 4).toCharArray()) {
                        if (!Character.isLetterOrDigit(x)) {
                            throw new RuntimeException("Bad character in unicode escape.");
                        }
                        hex.append(Character.toLowerCase(x));
                    }
                    i += 4; // consume those four digits.

                    int code = Integer.parseInt(hex.toString(), 16);
                    builder.append((char) code);
                }
            } else { // it's not a backslash, or it's the last character.
                builder.append(delimiter);
            }
        }

        String esc1 = builder.toString();

        Properties p = new Properties();
        try {
            p.load(new StringReader("key=" + esc1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p.getProperty("key");
    }
}
