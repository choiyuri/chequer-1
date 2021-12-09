import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algorithm {

    public static void main(String[] args) {

        String result = algorithm1("cba", "abcd");

        System.out.printf(result);

    }

    /**
     * S 와 T는 문자열(string)입니다. 두 문자열 모두 소문자 알파벳으로만 이루어져 있습니다.
     * 특히 S에서는 모든 문자가 단 한번씩만 나타납니다. S는 특정한 순서로 정렬이 되어 있습니다. 이
     * 문제의 목적은 T의 정렬 순서를 S의 정렬순서와 맞추는데에 있습니다. 만약 S에서 x보다 y 가 먼저
     * 나왔다면 T에서도 x가 y보다 앞서 정렬되어야 합니다.
     * ● S는 26자를 넘지 않습니다. 그리고 중복된 문자는 없습니다.
     * ● T는 200자를 넘지 않습니다.
     * ● S와T는 모두 소문자 알파벳으로만 이루어져 있습니다.
     *
     * @param S
     * @param T
     * @return
     */
    private static String algorithm1(String S, String T) {

        // String을 Character배열로 변환
        Character[] charObjectArray = T.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        // S문자열의 인덱스를 기준으로 정렬
        Arrays.sort(charObjectArray, Comparator.comparingInt(S::indexOf));

        // 정렬된 Character배열을 String으로 변환하기 위해 Stream객체 생성
        Stream<Character> charStream = Arrays.stream(charObjectArray);

        // String으로 변환
        return charStream.map(String::valueOf).collect(Collectors.joining());
    }
}
