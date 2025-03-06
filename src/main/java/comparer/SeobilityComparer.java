package comparer;

import entity.Seobility.Keyword;
import entity.Seobility.SeoResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SeobilityComparer {
    public static void compareSeoResults(SeoResult result1, SeoResult result2) {
        if (result1 == null || result2 == null) {
            System.out.println("One of the SEO results is null. Cannot compare.");
            return;
        }

        System.out.println("🔹 Comparing SEO Results for:");
        System.out.println("📌 URL 1: " + result1.getAnalysedurl());
        System.out.println("📌 URL 2: " + result2.getAnalysedurl());
        System.out.println("----------------------------------------------------");

        // Compare overall scores
        compareValues("Overall Score", result1.getScore(), result2.getScore());

        // Compare load time and file size
        compareValues("Load Time (seconds)",  Double.parseDouble(result1.getQuickfacts().getLoadtime()), Double.parseDouble(result2.getQuickfacts().getLoadtime()));
        compareValues("File Size (KB)", Double.parseDouble(result1.getQuickfacts().getFilesize()), Double.parseDouble(result2.getQuickfacts().getFilesize()));

        // Compare number of hints
        compareValues("Number of Hints", result1.getHints().size(), result2.getHints().size());

        // Compare number of keywords
        compareValues("Number of Keywords", result1.getKeywords().size(), result2.getKeywords().size());

        // Find common and unique keywords
        compareKeywordLists(result1.getKeywords(), result2.getKeywords());

        // Compare page quality, structure, and links
        compareValues("Page Quality Score", result1.getGroupresults().getPagequality().getScore(), result2.getGroupresults().getPagequality().getScore());
        compareValues("Structure Score", result1.getGroupresults().getStructure().getScore(), result2.getGroupresults().getStructure().getScore());
        compareValues("Links Score", result1.getGroupresults().getLinks().getScore(), result2.getGroupresults().getLinks().getScore());

        System.out.println("✅ Comparison Complete!");
    }

    private static void compareValues(String metric, Number value1, Number value2) {
        String better = (value1.doubleValue() > value2.doubleValue()) ? "🔼 Result 1 is better" :
                (value1.doubleValue() < value2.doubleValue()) ? "🔽 Result 2 is better" :
                        "✅ Both are equal";

        System.out.printf("%-30s | %10s | %10s | %s%n", metric, value1, value2, better);
    }

    private static void compareKeywordLists(List<Keyword> keywords1, List<Keyword> keywords2) {
        Set<String> set1 = keywords1.stream().map(Keyword::getKeyword).collect(Collectors.toSet());
        Set<String> set2 = keywords2.stream().map(Keyword::getKeyword).collect(Collectors.toSet());

        Set<String> common = new HashSet<>(set1);
        common.retainAll(set2);

        Set<String> uniqueToFirst = new HashSet<>(set1);
        uniqueToFirst.removeAll(set2);

        Set<String> uniqueToSecond = new HashSet<>(set2);
        uniqueToSecond.removeAll(set1);

        System.out.println("🔹 Common Keywords: " + common);
        System.out.println("🔸 Unique to Result 1: " + uniqueToFirst);
        System.out.println("🔸 Unique to Result 2: " + uniqueToSecond);
    }
}
