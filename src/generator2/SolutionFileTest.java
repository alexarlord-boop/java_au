package generator2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFileTest {
    public static final List<String> EMPTY_FILE_CONTENT = Collections.singletonList("");
    public static final String TITLE = "Reverse Linked List";
    public static final String URL = "https://leetcode.com/problems/reverse-linked-list/";
    public static final String SOLUTION = "```java\n" +
            "while head != None:\n" +
            "    prev = head\n" +
            "    head = n_node\n" +
            "return prev\n" +
            "```" + "\n";

    public static final String RESULT_STRING = "# OUTPUT\n\n" +
            "+ ["+ TITLE + "](#reverse-linked-list)\n" +
            "<!---->\n\n" + "## " + TITLE + "\n\n" + URL + "\n\n" + SOLUTION;

    public List<String> NOT_EMPTY_FILE_CONTENT = Arrays.asList("# TESTOUTPUT",
            "\n",
            "+ [Reverse Linked List](#reverse-linked-list)",
            "<!---->",
            "\n",
            "## Reverse Linked List",
            "\n",
            "https://leetcode.com/problems/reverse-linked-list/",
            "\n",
            "```java",
            "while head != None:",
            "    prev = head",
            "    head = n_node",
            "return prev",
            "```");

    @Test
    void testNotEmptyMarkdownFile() {
        SolutionFile res = SolutionFile.parseFile(NOT_EMPTY_FILE_CONTENT, Solution.FileType.MARKDOWN, "output");
        List<ItemEntity> lst = List.of(new MarkdownEntity(TITLE, URL, SOLUTION));
        SolutionFile expect = new SolutionFile(lst, Solution.FileType.MARKDOWN, "output");
        assertEquals(expect, res);
    }

    @Test
    void testEmptyMarkdownFile() {
        SolutionFile res = SolutionFile.parseFile(EMPTY_FILE_CONTENT, Solution.FileType.MARKDOWN, "output");
        List<ItemEntity> lst = List.of();
        SolutionFile expect = new SolutionFile(lst, Solution.FileType.MARKDOWN, "output");
        assertEquals(expect, res);
    }

    @Test
    void testToString() {
        SolutionFile result = SolutionFile.parseFile(NOT_EMPTY_FILE_CONTENT, Solution.FileType.MARKDOWN, "output");
        assertEquals(RESULT_STRING, result.toString());
    }
}