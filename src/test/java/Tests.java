import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Tests {


    @Test
    public void firstTaskTest() {
        String s1 = "hello";

        Function<String, Integer> lambda = LambdaDemo.stringlength;
        assertEquals(Optional.of(5), Optional.ofNullable(LambdaRunner.run(lambda, s1)));
    }

    @Test
    public void secondTaskTest() {
        String s1 = "hello";
        Function<String, Character> lambda = LambdaDemo.firstsymbol;
        assertEquals(Optional.of('h'), Optional.ofNullable(LambdaRunner.run(lambda, s1)));
        assertNull(LambdaRunner.run(lambda, null));
        assertNull(LambdaRunner.run(lambda, ""));
    }

    @Test
    public void thirdTaskTest() {
        String s2 = "hello world";

        Function<String, Boolean> lambda = LambdaDemo.space;
        assertEquals(true, LambdaRunner.run(lambda, s2));
    }

    @Test
    public void fourthTaskTest() {
        String s3 = "Denis, Ivan, Igor";

        Function<String, Integer> lambda = LambdaDemo.countWordsInString;
        assertEquals(Optional.of(3), Optional.ofNullable(LambdaRunner.run(lambda, s3)));
        assertEquals(Optional.of(3), Optional.ofNullable(LambdaRunner.run(lambda, "aaa,,,aaa,,,aaa")));
    }

    @Test
    public void fifthTaskTest() {
        Human human1 = new Human("Kamaliev", "Denis", "Sergeevich", 20, Gender.MALE);

        Function<? super Human, Integer> lambda = LambdaDemo.getAgeOfHuman;
        assertEquals(Optional.of(20), Optional.ofNullable(LambdaRunner.run(lambda, human1)));
    }

    @Test
    public void sixthTaskTest() {
        Human human1 = new Human("Kamaliev", "Denis", "Sergeevich", 20, Gender.MALE);
        Student human2 = new Student("Ivanov", "Ivan", "Ivanovich", "OmGU", "FMIT", "Math",
                33, Gender.MALE);
        Human human3 = new Human("Kamaliev", "Denis", "Sergeevich", 20, Gender.MALE);

        BiFunction<? super Human, ? super Human, Boolean> lambda = LambdaDemo.equalsFathersName;
        assertEquals(false, LambdaRunner.biFunctionRun(lambda, human1, human2));
        assertEquals(true, LambdaRunner.biFunctionRun(lambda, human1, human3));
    }

    @Test
    public void seventhTaskTest() {
        Human human1 = new Human("Kamaliev", "Denis", "Sergeevich", 20, Gender.MALE);

        Function<? super Human, String> lambda = LambdaDemo.makeStringHuman;
        assertEquals("Kamaliev Denis Sergeevich", LambdaRunner.run(lambda, human1));
    }

    @Test
    public void eightTaskTest() {
        Human human1 = new Human("Kamaliev", "Denis", "Sergeevich", 20, Gender.MALE);

        Function<Human, Human> lambda = LambdaDemo.getOlder;
        assertEquals(21, LambdaRunner.run(lambda, human1).getAge());
    }

    @Test
    public void ninthTaskTest() {
        Human human1 = new Human("Kamaliev", "Denis", "Sergeevich", 20, Gender.MALE);
        Human human3 = new Human("Kamalieva", "Alina", "Sergeevna", 13, Gender.WOMEN);
        Human human4 = new Human("Kamalieva", "Oksana", "Sergeevna", 42, Gender.WOMEN);


        int maxAge1 = 10;
        int maxAge2 = 45;

        assertFalse(LambdaDemo.checkYounger.checkHumansAndMaxAge(human1, human3, human4, maxAge1));
        assertTrue(LambdaDemo.checkYounger.checkHumansAndMaxAge(human1, human3, human4, maxAge2));
    }

    @Test
    public void tenTaskTest() {
        Human human1 = new Human("Kamaliev", "Denis", "Sergeevich", 20, Gender.MALE);
        Student human2 = new Student("Ivanov", "Ivan", "Ivanovich", "OmGU", "FMIT", "Math",
                33, Gender.MALE);
        Human human3 = new Human("Kamalieva", "Alina", "Sergeevna", 13, Gender.WOMEN);


        assertFalse(LambdaRunner.checkAgeRun(LambdaDemo.checkYounger, human1, human2, human3, 10));
        assertTrue(LambdaRunner.checkAgeRun(LambdaDemo.checkYounger, human1, human2, human3, 50));
    }


}