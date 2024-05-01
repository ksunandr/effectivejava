package ksan.example.effectivejava.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.*;

import static ksan.example.effectivejava.chapter2.Rank.*;

/**
 * Static factory methods
 * 1. Meaningful Names
 * Static factory methods is that, unlike constructors, have names, it is useful if you need many constructors
 * that do different things and, probably have the same set of input parameters
 *
 * 2. No need to create an object everytime
 * Also these methods, unlike constructors, they are not required to create a new object each time they’re invoked.
 * This allows immutable classes to use preconstructed instances, or to cache
 * instances as they’re constructed, avoiding creating unnecessary duplicate objects.
 * This technique is similar to the Flyweight pattern. It can greatly improve performance if equivalent
 * objects are requested often, especially if they are expensive to create.
 *
 * 3. Can return different classes
 * A third advantage of static factory methods is that, unlike constructors,
 * they can return an object of any subtype of their return type. An API can return objects without
 * making their classes public. Hiding implementation classes leads to a very compact API.
 *
 * 4. Can return different classes for different input
 * And for the same method the class of the returned object can also vary from call to call depending on the input.
 * The class of the returned object can also vary from release to release.
 * 5. A fifth advantage of static factories is that the class of the returned object
 * need not exist when the class containing the method is written.?
 *
 * 6. Llimitation: classes without public or protected constructors cannot be subclassed.
 * Also, they are hard for programmers to differ from other static method.
 *
 */
public class StaticFactoryMethod {


    public static void main(String[] args) throws IOException {
        //example Prime number - простое число
        BigInteger primeBiginteger = BigInteger.probablePrime(4, new Random());
        System.out.println("primeBiginteger = " + primeBiginteger);

        // The Boolean.valueOf(boolean) method illustrates 2. technique: it never creates an object.
        Boolean bool = Boolean.valueOf(true);

        /// about 3? java.util.Collections actually constructs different objects, despite it just util methods
        List<String>  emptyList =  Collections.emptyList();
        System.out.println(emptyList.getClass()); //class java.util.Collections$EmptyList

      Map singletonMap =  Collections.singletonMap("key","value");
        System.out.println(singletonMap.getClass()); //class java.util.Collections$SingletonMap


        //about 4 EnumSet actually can be RegularEnumSet or JumboEnumSet depends on number of elements

        //6. You cannot do it
        //class MyCollections extends java.util.Collections {    }


//Naming
        Date d = Date.from(Instant.now());
        Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
        BigInteger bi = BigInteger.valueOf(Integer.MAX_VALUE);
        StackWalker luke = StackWalker.getInstance();
        FileStore fs = Files.getFileStore(Path.of("/to/"));
        BufferedReader br = Files.newBufferedReader(Path.of("/to/"));
//etc
      //  Object newArray = Array.newInstance(d);
      //  List<Complaint> litany = Collections.list(legacyLitany);
        //instance  getlnstance
       //  create или newlnstance

    }
}

enum Rank {
    JACK, QUEEN, KING
}