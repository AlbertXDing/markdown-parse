// //imports necessary JUnit tester addons
// import static org.junit.Assert.*;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.*;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;

// //class header for the .java file
// public class MarkdownParseTest {
//     //Labels the next part of code as the test
//     @Test
//     //creates a test called "addition"
//     public void addition() {
//         //tests whether 2 is equal to 1 + 1
//         assertEquals(2, 1 + 1);
//     }

//     @Test
//     public void testTestFile1() throws IOException{
//         Path fileName = Path.of("test-file.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> result = MarkdownParse.getLinks(contents);
//         assertEquals(result.get(0), "https://something.com");
//         assertEquals(result.get(1), "some-page.html");
//     }

//     @Test
//     public void testTestFile2() throws IOException{
//         Path fileName = Path.of("test-file2.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> result = MarkdownParse.getLinks(contents);
//         List<String> expected = List.of("https://something2.com", "https://something.com", "some-page.html", "youtube.com", "example.com");
//         assertEquals(result, expected);
//     }

//     @Test
//     public void testTestFile3() throws IOException{
//         Path fileName = Path.of("test-file3.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> result = MarkdownParse.getLinks(contents);
//         List<String> expected = List.of("hello.com", "thisiscool.html");
//         assertEquals(result, expected);
//     }

//     @Test
//     public void testTestFile4() throws IOException{
//         Path fileName = Path.of("test-file4.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> result = MarkdownParse.getLinks(contents);
//         List<String> expected = new ArrayList<>();
//         assertEquals(result, expected);
//     }

//     @Test
//     public void testTestFile5() throws IOException{
//         Path fileName = Path.of("test-file-5.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> result = MarkdownParse.getLinks(contents);
//         List<String> expected = List.of("https://something.com", "some-page.html", "google2.com");
//         assertEquals(result, expected);
//     }



// }

import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void snippet1() throws IOException{
        Path fileName = Path.of("s1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
        assertEquals(expected, links);
    }

    @Test
    public void snippet2() throws IOException{
        Path fileName = Path.of("s2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("a.com");
        expected.add("a.com(())");
        expected.add("example.com");
        assertEquals(expected, links);
    }

    @Test
    public void snippet3() throws IOException{
        Path fileName = Path.of("s3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expected, links);
    }
}