package LR5;

public class FifthLab {
    public static void main(String[] args) {
        NumberFinder.numberFinder("Numbers: 199 9 20.676 5.2 3.  .6 342432..4324  - 3223 ");
        NumberFinder.numberFinder("afasfefew");
        System.out.println();


        System.out.println(CorrectPassword.isCorrect("67g73y4"));
        System.out.println(CorrectPassword.isCorrect("rrrrrrrr"));
        System.out.println(CorrectPassword.isCorrect("qqqqqqqqqqqqqqqqq"));
        System.out.println(CorrectPassword.isCorrect("qwe23rq2r232"));
        System.out.println(CorrectPassword.isCorrect("123455531"));
        System.out.println(CorrectPassword.isCorrect("Wfw423f23d"));
        System.out.println(CorrectPassword.isCorrect("1fw42D3f23d"));
        System.out.println(CorrectPassword.isCorrect("1WWWWWWWWWWW"));
        System.out.println();

        System.out.println(HrefConvertor.convert("The quick google.ru brown fox jumps yandex.ru over the lazy dog"));
        System.out.println(HrefConvertor.convert("The javarush.com/groups/posts/regulyarnye-vyrazheniya-v-java"));
        System.out.println(HrefConvertor.convert("https://google.ru"));
        System.out.println(HrefConvertor.convert("google.ru"));
        System.out.println(HrefConvertor.convert("sadffa http://google.ru"));
        System.out.println(HrefConvertor.convert("выаыва"));
        System.out.println();

        System.out.println(CorrectIP.isCorrect("250.21.23.1f"));
        System.out.println(CorrectIP.isCorrect("256.21.23.1"));
        System.out.println(CorrectIP.isCorrect("0000.21.23.1"));
        System.out.println(CorrectIP.isCorrect("1.121.232.13"));
        System.out.println(CorrectIP.isCorrect("27.121.232.13"));
        System.out.println();


        WordFinder.wordFinder("casd dsa cdca ,cd dddcc c,dd CDCD6A cCcD Caas", 'C');
        WordFinder.wordFinder("sadasda", 'C');
    }
}