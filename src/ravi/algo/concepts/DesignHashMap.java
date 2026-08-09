package ravi.algo.concepts;

import java.beans.PropertyEditorSupport;
import java.util.*;
public class DesignHashMap {

    Bucket bucket[];
    int keySpace;

    // initailization of requests hash map
    private HashMap<String, Integer> requests;
    int limit;
    public DesignHashMap() {
        keySpace = 2069;
        bucket = new Bucket[keySpace];
        for (int i = 0; i < keySpace; i++) {
            bucket[i] = new Bucket();
        }
    }

    public DesignHashMap(int limit) {
        keySpace = 2069;
        bucket = new Bucket[keySpace];
        for (int i = 0; i < keySpace; i++) {
            bucket[i] = new Bucket();
        }
        requests = new HashMap<String, Integer> ();
        this.limit = limit;
    }

    public void put(int key, int value) {
        // Write your code here
        int haskkey = key % keySpace;
        bucket[haskkey].update(key, value);

    }

    public int get(int key) {
        // Replace this placeholder return statement with your code
        int haskkey = key % keySpace;
        return bucket[haskkey].get(key);
    }

    public void remove(int key) {
        int haskkey = key % keySpace;
        bucket[haskkey].remove(key);
    }

    // Main method to demonstrate the usage of the HashMap
    public static void main(String args[]) {

        DesignHashMap inputHashMap = new DesignHashMap();
        List<Integer> keys = Arrays.asList(5, 2069, 2070, 2073, 4138, 2068);
        List<Integer> keysList = new ArrayList<>(Arrays.asList(5, 2069, 2070, 2073, 4138, 2068));
        List<Integer> values = Arrays.asList(100, 200, 400, 500, 1000, 5000);
        List<String> funcs = Arrays.asList("Get", "Get", "Put", "Get", "Put", "Get", "Get", "Remove", "Get", "Get", "Remove", "Get");
        List<List<Integer>> funcKeys = Arrays.asList(
                Arrays.asList(5),
                Arrays.asList(2073),
                Arrays.asList(2073, 50),
                Arrays.asList(2073),
                Arrays.asList(121, 110),
                Arrays.asList(121),
                Arrays.asList(2068),
                Arrays.asList(2069),
                Arrays.asList(2069),
                Arrays.asList(2071),
                Arrays.asList(2071),
                Arrays.asList(2071)
        );

        for (int i = 0; i < keys.size(); i++) {
            inputHashMap.put(keys.get(i), values.get(i));
        }

        for (int i = 0; i < funcs.size(); i++) {
            if (funcs.get(i) == "Put") {
                System.out.println(i + 1 + ".\t put(" + funcKeys.get(i).get(0) + ", " + funcKeys.get(i).get(1) + ")");
                if (!(keysList.contains(funcKeys.get(i).get(0)))) {
                    keysList.add(funcKeys.get(i).get(0));
                }
                inputHashMap.put(funcKeys.get(i).get(0), funcKeys.get(i).get(1));
            } else if (funcs.get(i) == "Get") {
                System.out.println(i + 1 + ".\t get(" + funcKeys.get(i).get(0) + ")");
                System.out.println("\t Value returned: " + inputHashMap.get(funcKeys.get(i).get(0)));
            } else if (funcs.get(i) == "Remove") {
                System.out.println(i + 1 + ". \t remove(" + funcKeys.get(i).get(0) + ")");
                inputHashMap.remove(funcKeys.get(i).get(0));
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Fraction to Recurring Decimal
        int[][] inputs = {{0, 4}, {4, 2}, {5, 333}, {2, 3}, {47, 18}, {93, 7}, {-5, 333}, {47, -18},
                {-4, -2}};
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1 + ".\tInput: fraction_to_decimal(");
            for (int j = 0; j < inputs[i].length - 1; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(", ");
            }
            System.out.println(inputs[i][inputs[i].length - 1] + ")");
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Logger Rate Limiter
        int[] times = { 1, 5, 6, 7, 15 };
        String[] messages = {
                "good morning",
                "hello world",
                "good morning",
                "good morning",
                "hello world"
        };
        DesignHashMap obj = new DesignHashMap(7);
        for (int i = 0; i<messages.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tTime, message: {" + times[i] + ", '" + messages[i] + "'}");
            System.out.println("\tMessage request decision: " + obj.messageRequestDecision(times[i], messages[i]));
          //  System.out.println(PrintHyphens.repeat("-", 100));
        }

        // Next Greater Element I


        int[][] A = {
                {2, 4},
                {3, 2, 5},
                {14, 45, 52},
                {1, 3, 2},
                {4, 2},
                {0}
        };
        int[][] B = {
                {1, 2, 3, 4},
                {2, 3, 5, 1},
                {52, 14, 45, 65},
                {1, 3, 2, 4, 5},
                {1, 2, 4, 3},
                {0}
        };

        int x = 1;
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tNums 1 = " + Arrays.toString(A[i]));
            System.out.println("\tNums 2 = " + Arrays.toString(B[i]));
            System.out.print("");
            System.out.println("\tThe Next Greater Element Array = " + Arrays.toString(nextGreaterElement(A[i], B[i])));
         //   System.out.println(PrintHyphens.repeat("-", 100));
        }
        // Isomorphic Strings
        String[] AI = {"egg", "foo", "paper", "badc", "aaeaa"};
        String[] BI = {"all", "bar", "title", "baba", "uuxyy"};
        for (int i = 0; i < AI.length; i++) {
            System.out.println((i + 1) + ".\tString 1 = " + AI[i]);
            System.out.println("\tString 2 = " +   BI[i]);
            System.out.println("\n\tIsomorphic String ? " + isIsomorphic(AI[i], BI[i]));
            //System.out.println(PrintHyphens.repeat("-", 100));
        }

        // Find Duplicate File in System
        List<String[]> inputList = new ArrayList<>();
        inputList.add(new String[]{
                "home/user1 1.txt(hello) 2.txt(world)",
                "home/user2 3.txt(hello)",
                "home/user3/docs 4.txt(world)",
                "home/user3/docs 5.txt(greetings)"
        });
        inputList.add(new String[]{
                "data 1.csv(data1) 2.csv(data2)",
                "data/2021 3.csv(data1) 4.csv(data3)",
                "data/2022 5.csv(data2)",
                "data/2021/backup 6.csv(data3)"
        });
        inputList.add(new String[]{
                "reports/jan 1.doc(report1) 2.doc(report2)",
                "reports/feb 3.doc(report1)",
                "reports/mar 4.doc(report2)",
                "reports/apr 5.doc(report3)"
        });
        inputList.add(new String[]{
                "docs 1.doc(text1) 2.doc(text2)",
                "docs/2020 3.doc(text1)",
                "docs/2021 4.doc(text2)",
                "docs/2021/backup 5.doc(text3)"
        });
        inputList.add(new String[]{
                "csv 1.csv(123) 2.csv(456)",
                "csv/2022 3.csv(123)",
                "csv/2023 4.csv(456) 5.csv(789)",
                "csv/backup 6.csv(789)"
        });

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println((i + 1) + ".\tInput string:");
            for (String path : inputList.get(i)) {
                System.out.println("\t\t" + path);
            }

            List<List<String>> duplicates = findDuplicate(inputList.get(i));

            System.out.println("\n\tDuplicate files: ");
            for (List<String> group : duplicates) {
                System.out.println("\t\t" + String.join(", ", group));
            }
            System.out.println();
        }

        //Dot Product of Two Sparse Vectors

// High Five

        int[][][] testCases = {
                {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}},
                {{1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}},
                {{3, 70}, {4, 60}, {3, 80}, {4, 90}, {3, 100}, {4, 85}, {3, 90}, {4, 100}, {3, 75}, {4, 95}},
                {{5, 60}, {6, 50}, {5, 90}, {6, 70}, {5, 80}, {6, 60}, {5, 70}, {6, 80}, {5, 100}, {6, 100}},
                {{8, 88}, {8, 77}, {9, 85}, {8, 95}, {9, 100}, {8, 100}, {9, 95}, {9, 80}, {8, 92}, {9, 88}}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.print((i + 1) + ".\titems: ");
            for (int[] item : testCases[i]) {
                System.out.print("[" + item[0] + ", " + item[1] + "] ");
            }
            System.out.print("\n\tThe top five averages are: ");
            int[][] result = highFive(testCases[i]);
            for (int[] res : result) {
                System.out.print("[" + res[0] + ", " + res[1] + "] ");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Bulls and Cows
        String[][] testCasesCow = {
                {"5567", "5675"},
                {"1123", "0111"},
                {"1234", "1243"},
                {"9876", "9876"},
                {"5567", "5675"}
        };

        for (int i = 0; i < testCasesCow.length; i++) {
            String secret = testCasesCow[i][0];
            String guess = testCasesCow[i][1];
            System.out.println((i + 1) + ".\tSecret: \"" + secret + "\", Guess: \"" + guess + "\"");
            System.out.println("\n\tHint: \"" + getHint(secret, guess) + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-')); // prints 100 dashes
        }

        // Custom Sort String

        String[][] testCasesSort = {
                {"cba", "abcd"},
                {"xyz", "abcdef"},
                {"bca", "xyz"},
                {"edcba", "abcde"},
                {"abc", "aabbcc"},
                {"abc", "xyz"},
                {"wo", "meow"}
        };

        for (int i = 0; i < testCasesSort.length; i++) {
            String order = testCasesSort[i][0];
            String s = testCasesSort[i][1];
            System.out.println((i + 1) + ".\torder = \"" + order + "\"");
            System.out.println("\ts = \"" + s + "\"");
            System.out.println("\n\tresult = \"" + customSortString(order, s) + "\"");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Number of Distinct Islands

        int[][][] grids = {
                {{1, 1, 0, 0, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 1, 1}, {1, 1, 0, 1, 1}},
                {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 1, 1, 1}},
                {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
                {{1, 0, 0, 1}, {1, 1, 0, 1}, {0, 0, 0, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}}
        };

        for (int i = 0; i < grids.length; i++) {
            System.out.println(i + 1 + ".\tGrid:");
            for (int[] row : grids[i]) {
                System.out.println("\t  " + Arrays.toString(row));
            }
            System.out.println();
            System.out.println("\tNumber of distinct island(s): " + numDistinctIslands(grids[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Number of Wonderful Substrings
        String[] words = {
                "aba",               // Example 1
                "aabb",              // Example 2
                "he",                // Example 3
                "ccj",               // Example 4
                "abcdefghij",        // Example 5
                "jjjjjjjjjj"         // Example 6
        };

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\tword: " + words[i]);
            System.out.println("\n\tNumber of wonderful substrings: " + wonderfulSubstrings(words[i]));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Total Appeal of a String

        String[] strs = {"asd", "bbb", "q", "madam", "hippopotamus"};

        for (int index = 0; index < strs.length; index++) {
            String stringValue = strs[index];
            System.out.println((index + 1) + ".\ts: " + stringValue);
            System.out.println("\tTotal appeal: " + appealSum(stringValue));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Continuous Subarray Sum

        ArrayList<ArrayList<Integer>> testCasesC = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(23, 2, 4, 6, 7)),
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(5, 0, 0, 3)),
                new ArrayList<>(Arrays.asList(0, 1)),
                new ArrayList<>(Arrays.asList(7, 3, 2, 4, 9))
        ));
        int[] kValues = {6, 7, 3, 7, 6};

        for (int i = 0; i < testCasesC.size(); i++) {
            ArrayList<Integer> nums = testCasesC.get(i);
            int k = kValues[i];
            boolean result = checkSubarraySum(nums, k);

            System.out.print((i + 1) + "\tnums: " + nums + "\n\tk: " + k + "\n\tResult: ");
            System.out.println(result ? "True" : "False");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        //Unique Number of Occurrences

        int[][] inputListU = {
                {1, 2, 2, 1, 1, 3},
                {1, 2},
                {3, 5, -2, -3, -2, 5, 3},
                {10, 10, 10, 10},
                {1, 2, 3, 4, 5, 6}
        };

        for (int i = 0; i < inputListU.length; i++) {
            int[] nums = inputListU[i];
            boolean result = uniqueOccurrences(nums);
            System.out.println((i + 1) + ".\tInput: " + java.util.Arrays.toString(nums));
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Longest Happy Prefix



        String[] testCasesL = {
                "rider",
                "ababab",
                "abcabc",
                "aabaacaabaa",
                "xyz",
                "aaaaa"
        };

        for (int i = 0; i < testCasesL.length; i++) {
            String testCase = testCasesL[i];
            String result = longestPrefix(testCase);
            System.out.println((i + 1) + ".\ts: " + testCase);
            System.out.println("\tLongest Happy Prefix: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Find Longest Self-Contained Substring
        String[] testCasesF = {
                "xyyx",      // Expected output: 2 ("yy")
                "abab",      // Expected output: -1 (no valid substring)
                "abacd",     // Expected output: 4 ("abac")
                "aabbcc",    // Expected output: 2 ("aa", "bb", or "cc")
                "abcabcabc"  // Expected output: -1 (all repeated across the string)
        };

        for (int i = 0; i < testCasesF.length; i++) {
            System.out.println((i + 1) + ".\tstring: " + testCasesF[i]);
            int result = maxSubstringLength(testCasesF[i]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

         // Intersection of Two Arrays


        int[][][] arrPairs = {
                { {1, 2, 2, 1}, {2, 2} },
                { {4, 9, 5}, {9, 4, 9, 8, 4} },
                { {1, 3, 7}, {2, 4, 6} },
                { {2, 2, 3, 3, 4}, {3, 3, 4, 4, 5} },
                { {10, 20, 30}, {30, 40, 50} }
        };

        for (int i = 0; i < arrPairs.length; i++) {
            int[] arr1 = arrPairs[i][0];
            int[] arr2 = arrPairs[i][1];

            System.out.println((i + 1) + ".\tarr1: " + Arrays.toString(arr1));
            System.out.println("\tarr2: " + Arrays.toString(arr2) + "\n");
            System.out.println("\tIntersection: " + Arrays.toString(intersection(arr1, arr2)));
            System.out.println("--------------------------------------------------------------------------------------------------");
        }

        // Word Pattern
        String[] patterns = {"abba", "abba", "aaaa", "abba", "abc"};
        String[] strings = {
                "dog cat cat dog",
                "dog cat cat fish",
                "dog cat cat dog",
                "dog dog dog dog",
                "red blue green"
        };

        // Run all test cases
        for (int i = 0; i < patterns.length; i++) {
            boolean result = wordPattern(patterns[i], strings[i]);
            System.out.println((i + 1) + ".");
            System.out.println("\tpattern: " + patterns[i]);
            System.out.println("\tstring: " + strings[i]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Valid Sudoku

        char[][][] boards = get_input_boards();


        for (int i = 0; i < boards.length; i++) {
            char[][] board = boards[i];
            System.out.println((i + 1) + ".\tBoard: ");
            for (char[] row : board) {
                System.out.print("\t\t[");
                for (int j = 0; j < row.length; j++) {
                    System.out.print("'" + row[j] + "'");
                    if (j < row.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }

            if (isValidSudoku(board)) {
                System.out.println("\n\t Result: The board is valid.");
            } else {
                System.out.println("\n\t Result: The board is invalid.");
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
        }

        // Roman to Integer

        List<String> romanInputs = List.of(
                "III",
                "IV",
                "IX",
                "LVIII",
                "MCMXCIV",
                "XII",
                "XXVII",
                "CMXL"
        );

        for (int i = 0; i < romanInputs.size(); i++) {
            String roman = romanInputs.get(i);
            System.out.println((i + 1) + ".\tRoman numeral = \"" + roman + "\"");

            System.out.println("\n\tInteger value = " + romanToInt(roman));
            System.out.println("-".repeat(100));
        }

        //Contiguous Array
        int[][] testCasesa = {
                {0, 1},
                {0, 1, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1},
                {1, 1, 1, 0, 0}
        };

        int i = 0;
        for (int[] nums : testCasesa) {
            System.out.print((i + 1) + ".\tnums: [");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j]);
                if (j + 1 < nums.length) System.out.print(", ");
            }
            System.out.println("]");
   
            System.out.println("\n\tMax Length: " + findMaxLength(nums));
            System.out.println("-".repeat(100));
            i++;
        }

        //Jewels and Stones
        String[][] testcases = {
                { "pQ", "ppPQQq" },
                { "k", "kkkkK" },
                { "LMn", "lLmMNn" },
                { "cD", "ddddccccDD" },
                { "tRz", "RttZzr" }
        };



        for (int ij = 0; ij < testcases.length; ij++) {
            String jewels = testcases[ij][0];
            String stones = testcases[ij][1];

            System.out.println((ij + 1) + "\tjewels: " + jewels + ", stones: " + stones);
            int result = numJewelsInStones(jewels, stones);
            System.out.println("\n\tNumber of Jewels in Stones: " + result);
            System.out.println("-".repeat(100) + "\n");
        }
    // Vowel Spellchecker


        String[][][] testCases1 = {
                {{"Apple", "apple", "APPLE"}, {"apple", "Apple", "APPLE", "aPPLE", "Opple", "applo", "banana"}},
                {{"Stone", "stone", "STone"}, {"STONE", "stone", "Stone", "stane", "stune", "stons"}},
                {{"Bat", "bat", "BaT"}, {"BAT", "bet", "bit", "bot", "but", "bAt", "cat"}},
                {{"hello", "World", "HeLLo"}, {"Hello", "world", "WORLD", "hallo", "wurld", "Werld", "xyz"}},
                {{"Tree", "free", "BREE"}, {"tree", "Tree", "TREE", "trae", "froe", "brie", "BRAE", "gree"}},
        };

        for (int i1 = 0; i1 < testCases1.length; i1++) {
            String[] wordlist = testCases1[i1][0];
            String[] queries = testCases1[i1][1];
            String[] result = spellchecker(wordlist, queries);
            System.out.println((i1 + 1) + ".\tInput array: " + Arrays.toString(wordlist));
            System.out.println("\tTarget: " + Arrays.toString(queries));
            System.out.println("\tResult: " + Arrays.toString(result));
            System.out.println("-".repeat(100));
        }

        // N-Repeated Element in Size 2N Array
        int[][] testCasesN = {
                {9, 5, 6, 9},
                {3, 3, 3, 1, 2, 3},
                {7, 7, 1, 2, 7, 3, 7, 4},
                {0, 0},
                {4, 1, 4, 2, 4, 3, 4, 5, 4, 6},
        };
        for (int iN = 0; iN < testCasesN.length; iN++) {
            int result = repeatedNTimes(testCasesN[iN]);
            System.out.println((iN + 1) + ".\tInput array: " + Arrays.toString(testCasesN[iN]));
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

        // Powerful Integers


        int[][] testCasesPower = {
                {2, 2, 20},
                {1, 1, 5},
                {5, 3, 50},
                {100, 100, 1000000},
                {2, 5, 0},
        };

        for (int idx = 0; idx < testCasesPower.length; idx++) {
            int xVal = testCasesPower[idx][0];
            int yVal = testCasesPower[idx][1];
            int boundVal = testCasesPower[idx][2];
            List<Integer> result = powerfulIntegers(xVal, yVal, boundVal);
            Collections.sort(result);
            System.out.println((idx + 1) + ".\tInput x: " + xVal + ", y: " + yVal + ", bound: " + boundVal);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

        // Before and After Puzzle

        String[][] testCasesPu = {
                {"hello world", "world cup", "cup cake"},
                {"the dog", "dog days", "days are gone", "gone fishing"},
                {"x", "x", "x"},
                {"red car", "car wash", "wash day", "red carpet"},
                {"go big", "big deal", "deal or no deal", "big time"},
        };

        for (int idx = 0; idx < testCasesPu.length; idx++) {
            List<String> result = beforeAndAfterPuzzles(testCasesPu[idx]);
            System.out.println((idx + 1) + ".\tInput array: " + Arrays.toString(testCasesPu[idx]));
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }


        int[][][] testCasesT = {
                {{3, 3, 3}, {3, 3}},
                {{1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}},
                {{7, 7, 7, 7}, {7, 7}},
                {{0, 0, 0}, {0, 0, 0}},
                {{10, 20, 30}, {40, 50, 60}},
        };
        for (int iT = 0; iT < testCasesT.length; iT++) {
            int[] result = intersect(testCasesT[iT][0], testCasesT[iT][1]);
            System.out.println((iT + 1) + ".\tInput array: " + Arrays.toString(testCasesT[iT][0]));
            System.out.println("\tTarget: " + Arrays.toString(testCasesT[iT][1]));
            System.out.println("\tResult: " + Arrays.toString(result));
            System.out.println("-".repeat(100));
        }

        // Subarray Sum Equals K


        int[][] numsArray = {
                {3, 4, 7, 2, -3, 1, 4, 2},
                {1, -1, 0},
                {0, 0, 0, 0},
                {-1, -1, 1},
                {5, 3, -2, 4, -1, 2, -3, 1},
        };
        int[] kArray = {7, 0, 0, 0, 5};

        for (int iss = 0; iss < numsArray.length; iss++) {
            int result = subarraySum(numsArray[iss], kArray[iss]);
            System.out.println((iss + 1) + ".\tInput array: " + Arrays.toString(numsArray[iss]));
            System.out.println("\tTarget: " + kArray[iss]);
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

        // Longest Palindrome


        //  // Identify the Largest Outlier in an Array

        int[][][] testCasesId = {
                {{4, 8, 12, 20}},
                {{3, 3, 6, 100}},
                {{-5, -5, -10, 7}},
                {{0, 0, 0, 1}},
                {{2, 2, 2, 2, 8, 50}},
        };

        String separator = "-".repeat(100);

        for (int is = 0; is < testCasesId.length; is++) {
            int[] nums = testCasesId[is][0];
            int result = getLargestOutlier(nums);

            System.out.print((is + 1) + ".\tInput array: [");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j]);
                if (j + 1 < nums.length) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\tResult: " + result);
            System.out.println(separator);
        }

        //Find the Length of the Longest Common Prefix

        int[][][] testCasessT = {
                {{12, 345, 6789}, {123, 456, 789}},
                {{99, 998, 9999}, {9, 99, 999}},
                {{56001, 78, 234}, {5600, 7, 23}},
                {{100000000}, {100000000}},
                {{11, 22, 33}, {44, 55, 66}},
        };

        for (int ist = 0; ist < testCasessT.length; ist++) {
            int[] arr1 = testCasessT[ist][0];
            int[] arr2 = testCasessT[ist][1];
            int result = longestCommonPrefix(arr1, arr2);

            System.out.println((ist + 1) + ".\tInput arr1: " + Arrays.toString(arr1));
            System.out.println("\tInput arr2: " + Arrays.toString(arr2));
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

    }

    // Find the Length of the Longest Common Prefix

    public static int longestCommonPrefix(int[] arr1, int[] arr2)
    {
        // Replace this placeholder return statement with your code
        return -1;
    }

    // Identify the Largest Outlier in an Array
    public static  int getLargestOutlier(int[] nums)
    {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int result=Integer.MIN_VALUE;
        for(int outlier : freqMap.keySet()){

            int remaining=totalSum-outlier;

            if (remaining % 2 != 0) continue;

            int x = remaining / 2;

            if (!freqMap.containsKey(x)) continue;

            if (x == outlier && freqMap.get(outlier) < 2) continue;

            result = Math.max(result, outlier);

        }

        return result;
    }

    // Longest Palindrome

    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length += 1;
        }

        return length;
    }

    // Subarray Sum Equals K

    public  static int subarraySum(int[] nums, int k)
    {

        int sum=0;
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int num:nums){
            sum+=num;
            int complement=sum-k;
            if(map.containsKey(complement)){
                result+=map.get(complement);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }

        return result;
    }

    //Intersection of Two Arrays II

    public static int[] intersect(int[] nums1, int[] nums2)
    {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num:nums2){

            if(map.containsKey(num) && map.getOrDefault(num,0)>0){
                res.add(num);
                map.put(num,map.get(num)-1);

            }
        }


        return res.stream().mapToInt(m->m).toArray();
    }
    //Before and After Puzzle
    public static List<String> beforeAndAfterPuzzles(String[] phrases)
    {

        Map<String,List<Integer>> first=new HashMap<>();

        List<String> res=new ArrayList<>();
        int i=0;
        for(String str:phrases){
            String[] st=str.split(" ");
            first.computeIfAbsent(st[0],k->new ArrayList<>()).add(i);
            i++;
        }

        Set<String> resultSet = new TreeSet<>();

        for (int in = 0; in < phrases.length; in++) {
            String[] st=phrases[in].split(" ");
            String lastWord=st[st.length-1];
            if(first.containsKey(lastWord)){
                for(int j:first.get(lastWord)){
                    if(in!=j){
                        String restOfSecond = phrases[j].substring(lastWord.length());
                        String merged = phrases[in] + restOfSecond;
                        resultSet.add(merged);
                    }

                }

            }

        }

        return new ArrayList<>(resultSet);
    }

    // Powerful Integers

    public static List<Integer> powerfulIntegers(int x, int y, int bound)
    {

        long powX=1;
        Set<Integer> resul=new HashSet<>();
        while(powX<bound){

            long powY=1;
            while(powX+powY<=bound){
                resul.add((int)(powY+powX));
                if(y==1)
                    break;

                powY*=y;
            }
        if(x==1)
            break;

        powX*=x;


        }
        // Replace this placeholder return statement with your code
        return new ArrayList<>(resul);
    }


    // N-Repeated Element in Size 2N Array

    public static int repeatedNTimes(int[] nums)
    {

        Set<Integer> set=new HashSet<>();

        for(int num:nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);

        }
        return -1;
    }

    // Vowel Spellchecker

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet=new HashSet<>(Arrays.asList(wordlist));

        Map<String,String> capMap=new HashMap<>();

        for(String word:wordlist){
            String lowWord=word.toLowerCase();
            if(!capMap.containsKey(lowWord))
                capMap.put(lowWord,word);

        }

        Map<String,String> vowMap=new HashMap<>();
        for(String word:wordlist){
            String devWord=deVowal(word);
            if(!vowMap.containsKey(devWord))
                vowMap.put(devWord,word);

        }

        String[] answer = new String[queries.length];
        int i=0;
        for(String query:queries){
            if(exactSet.contains(query)){
                answer[i]=query;
            }else if(capMap.containsKey(query)){
                answer[i]=capMap.get(query);
            }else if(vowMap.containsKey(deVowal(query))){
                answer[i]=vowMap.get(deVowal(query));
            }else{
                answer[i]="";
            }
            i++;
        }


        return answer;
    }

    private static String deVowal(String word) {
        StringBuilder sb=new StringBuilder();
        for(char ch:word.toCharArray()){
            if(isVowel(ch)){
                sb.append("*");
            }else{
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }

    private static boolean isVowel(char ch) {
        char low=Character.toLowerCase(ch);
        if(low=='a'  || low=='i' || low=='o' || low=='u' || low=='e' ){
            return true;
        }
        return false;

    }

    //Jewels and Stones
    public static int numJewelsInStones(String jewels, String stones) {

        Map<Character,Integer> map=new HashMap<>();

        for(char ch:stones.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);

        }

        int sum=0;

        for(char ch:jewels.toCharArray()){
            if(map.containsKey(ch))
                sum+=map.get(ch);
        }
        return sum;
    }
//Contiguous Array
    public static int findMaxLength(int[] nums)
    {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        map.put(0,-1);
        int maxL=0;

        for(int i=0;i<nums.length;i++){
            int n=(nums[i]==0)?-1:1;
            count+=n;

            if(!map.containsKey(count)){
                map.put(count,i);
            }

            maxL=Math.max(maxL,i-map.get(count));


        }

        return maxL;
    }

    //Roman to Integer
    public static int romanToInt(String s) {
        Map<String, Integer> valueMap = Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000),
                Map.entry("IV", 4),
                Map.entry("IX", 9),
                Map.entry("XL", 40),
                Map.entry("XC", 90),
                Map.entry("CD", 400),
                Map.entry("CM", 900)
        );

        int i=0;
        int sum=0;
        while(i<s.length()-1){

            String firstCheck=s.substring(i,i+2);
            if(valueMap.containsKey(firstCheck)){
                sum+=valueMap.get(firstCheck);
                i+=2;
                continue;
            }

            String secondCheck=s.substring(i,i+1);
            if(valueMap.containsKey(secondCheck)){
                sum+=valueMap.get(secondCheck);
                i+=1;
            }

        }

        // Replace this placeholder return statement with your code
        return sum;
    }


    public static char[][][] get_input_boards() {
        return new char[][][] {
                {
                        {'.','.','.','.','.','.','.','7','.'},
                        {'2','7','5','.','.','.','3','1','4'},
                        {'.','.','.','.','2','7','.','5','.'},
                        {'9','8','.','.','.','.','.','3','1'},
                        {'.','3','1','8','.','4','.','.','.'},
                        {'.','.','.','1','.','.','8','.','5'},
                        {'7','.','6','2','.','.','1','8','.'},
                        {'.','9','.','7','.','.','.','.','.'},
                        {'4','1','.','.','.','5','.','.','7'}
                },
                {
                        {'5','3','3','6','7','8','9','1','2'},
                        {'6','7','2','1','9','5','3','4','8'},
                        {'1','9','8','3','4','2','5','6','7'},
                        {'8','5','9','7','6','1','4','2','3'},
                        {'4','2','6','8','5','3','7','9','1'},
                        {'7','1','3','9','2','4','8','5','6'},
                        {'9','6','1','5','3','7','2','8','4'},
                        {'2','8','7','4','1','9','6','3','5'},
                        {'3','4','5','2','8','6','1','7','9'}
                },
                {
                        {'6','4','5','9','8','2','1','3','7'},
                        {'7','2','8','3','1','6','5','9','4'},
                        {'3','9','1','5','4','7','6','8','2'},
                        {'9','8','7','1','5','3','4','2','6'},
                        {'4','1','6','2','7','9','8','5','3'},
                        {'5','3','2','8','6','4','7','1','9'},
                        {'8','7','3','6','9','5','2','4','1'},
                        {'2','5','4','7','3','1','9','6','8'},
                        {'1','6','9','4','2','8','3','7','5'}
                },
                {
                        {'6','3','9','4','2','5','7','1','8'},
                        {'6','4','8','1','3','7','9','6','5'},
                        {'5','7','1','9','6','8','3','4','2'},
                        {'1','6','2','7','5','4','8','3','9'},
                        {'4','8','3','6','9','2','5','7','1'},
                        {'9','5','7','3','8','1','6','2','4'},
                        {'8','2','6','5','4','3','1','9','7'},
                        {'3','1','5','2','7','9','4','8','6'},
                        {'7','9','4','8','1','6','2','5','3'}
                },
                {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                }
        };


    }


    //Valid Sudoku
    public static boolean isValidSudoku(char[][] board) {

        List<Set<Integer>> row=new ArrayList<>();
        List<Set<Integer>> col=new ArrayList<>();
        List<Set<Integer>> box=new ArrayList<>();

        for(int i=0;i<9;i++){
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }

        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                int val=board[r][c];

                if (val == '.') {
                    continue;
                }

                int bpos=(r/3)*3+c/3;

                if(row.get(r).contains(val) || col.get(c).contains(val) || box.get(bpos).contains(val) ){
                    return false;
                }

                row.get(r).add(val);
                col.get(c).add(val);
                box.get(bpos).add(val);
            }
        }
        return true;
    }

    // Word Pattern
    public static boolean wordPattern (String pattern, String s) {

        String[] strings=s.split(" ");
        Map<Character,String> map1=new HashMap<>();
        Map<String,Character> map2=new HashMap<>();

        if(strings.length!=pattern.length()) return false;

        for(int i=0;i<pattern.length();i++){
            if(map1.containsKey(pattern.charAt(i)) && !strings[i].equals(map1.get(pattern.charAt(i)))){
                return false;
            }

            if(map2.containsKey(strings[i]) && pattern.charAt(i)!=map2.get(strings[i])){
                return false;
            }


            map1.put(pattern.charAt(i),strings[i]);
            map2.put(strings[i],pattern.charAt(i));
        }

        return true;
    }

    // Intersection of Two Arrays
    public static int[] intersection(int[] arr1, int[] arr2) {
        Set hashSet=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for(int arr:arr2){
            hashSet.add(arr);
        }

        for(int arr:arr1){
            if(hashSet.contains(arr)){
                res.add(arr);
            }
        }
        // Replace this placeholder return statement with your code
        return  res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    // Find Longest Self-Contained Substring

    public static int maxSubstringLength (String s) {

        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();




        for (int i = 0; i < s.length(); i++) {
            if(!first.containsKey(s.charAt(i))){
               first.put(s.charAt(i),i);
            }
            last.put(s.charAt(i),i);
        }

        int max=0;
        for(char c1:first.keySet()){
            int start=first.get(c1);
            int end=last.get(c1);
            int j=start;
            while(j<s.length()){
                char c2=s.charAt(j);

                if(first.get(c2)<start) {
                    break;
                }
                end=Math.max(end,last.get(c2));

                if(j==end && end-start+1!=s.length()){
                    max=Math.max(max,end-start+1);
                }
                j++;
            }


        }
        return max;
    }

    //Longest Happy Prefix

    public static String longestPrefix(String s) {

        long powBase=1;
        long suffixHash=0;
        long prefixHash=0;
        long mod= 1000000007;
        int b=31;

        int length=0;
        int n=s.length();

        for(int i=0;i<n-1;i++){

            prefixHash=( prefixHash*b + s.charAt(i))%mod;
            suffixHash= (suffixHash + s.charAt(n-i-1)*powBase)%mod;
            powBase=(powBase*b)%mod;
            if(prefixHash==suffixHash){
                length=i+1;
            }

        }

         return s.substring(0,length);

    }

    //Unique Number of Occurrences
    public static boolean uniqueOccurrences(int[] nums) {

        Map<Integer,Integer> feqMap=new HashMap<>();
        Set<Integer> mapOfreq=new HashSet<>();

        for(int num:nums){
            feqMap.put(num,feqMap.getOrDefault(num,0)+1);
        }


        for(Map.Entry<Integer,Integer> entry:feqMap.entrySet()){
            int freq=entry.getValue();
            if(mapOfreq.contains(freq)){
                return false;
            }else{
                mapOfreq.add(freq);
            }

        }

        return true;
    }

    //Continuous Subarray Sum
    public  static boolean checkSubarraySum(ArrayList<Integer> nums, int k) {

        Map<Integer,Integer> track=new HashMap<>();

        track.put(-1,0);

        int culSum=0;
        for(int i=0;i<nums.size();i++){
            culSum+=nums.get(i);
            int reminder=culSum%k;

            if(reminder<0)
                reminder+=k;
            if(track.containsKey(reminder)){
                int length=i-track.get(reminder);
                if(length>=2){
                    return true;
                }
            }else{
                track.put(reminder,i);
            }

        }

        // Return this placeholder return statement with your code
        return false;
    }



    // Total Appeal of a String
    public static int appealSum(String s) {

        int sum=0;
        int[] track=new int[26];
        Arrays.fill(track,-1);

        Map<Character,Integer> freq=new HashMap<>();

        int n=s.length();
        for(int i=0;i<n;i++){

            char ch=s.charAt(i);
            sum+=(i-track[ch-'a'])*(n-i);
            track[ch-'a']=i;
        }
        return sum;
    }

    // Number of Wonderful Substrings

    /*

    Position      Prefix      Mask

start         ""          00
0             "a"         01
1             "ab"        11
2             "aba"       10

Prefix = "ab"

a count = 1 (odd)
b count = 1 (odd)

mask = 11
     */

    public static long wonderfulSubstrings(String word)
    {


        // Initialize a frequency map to store the count of each bitmask
        Map<Integer, Integer> freq = new HashMap<>();
        // The empty prefix (bitmask of 0) is considered to be seen once
        freq.put(0, 1);

        // Variable to hold the current bitmask for character parity
        int mask = 0;
        // Result variable to count the number of wonderful substrings
        long res = 0;

        // Iterate through each character in the input word
        for (char c : word.toCharArray()) {
            // Calculate the corresponding bit position for the character
            int bit = c - 'a';  // 'a' is 0, 'b' is 1, ..., 'j' is 9
            // Toggle the bit corresponding to the current character in the mask  , like if it is even and if it again come it become odd

            mask^=(1<<bit);

            // Check if the current mask has been seen before
            if (freq.containsKey(mask)) {
                // If it has, add its frequency to the result
                res += freq.get(mask);
                // Increment the count for this mask in the frequency map
                freq.put(mask, freq.get(mask) + 1);
            } else {
                // If not, initialize its count to 1
                freq.put(mask, 1);
            }

            // Check for all possible characters that can be odd
            for(int odd_c=0;odd_c< 10 ;odd_c++){
                int toggle_mask= mask ^ (1 << odd_c);
                if(freq.containsKey(toggle_mask)){
                    res+=freq.get(toggle_mask);
                }
            }
        }
        return res;
    }

    // Number of Distinct Islands
    public static int numDistinctIslands(int[][] grid) {
        Set<String> visited=new HashSet<>();
        Map<String,Integer> uniqueIslands=new HashMap<>();

        for(int row=0;row< grid.length;row++){
            for(int col=0;col< grid[0].length;col++){
                if(grid[row][col]==1 && !visited.contains(row+","+col)){
                    List<int[]> paths=new ArrayList<>();
                    dfsIland(row,col,row,col,paths,grid,visited);
                    StringBuilder key=new StringBuilder();
                    for(int[] path:paths){
                        key.append(path[0]).append(",").append(path[1]).append(";");
                    }
                    uniqueIslands.put(key.toString(),uniqueIslands.getOrDefault(key,0)+1);
                }
            }
        }

        return uniqueIslands.size();
    }

    private static void dfsIland(int row, int col, int rowOrgin, int colOrigin , List<int[]> paths, int[][] grid, Set<String> visited ) {

        if(row < 0 || col < 0 || row>= grid.length || col >= grid[0].length || visited.contains(row+","+col) || grid[row][col]==0 )
            return;

        visited.add(row+","+col);
        paths.add(new int[]{row-rowOrgin,col-colOrigin});

        dfsIland(row+1,col,rowOrgin,colOrigin,paths,grid,visited);
        dfsIland(row-1,col,rowOrgin,colOrigin,paths,grid,visited);
        dfsIland(row,col+1,rowOrgin,colOrigin,paths,grid,visited);
        dfsIland(row,col-1,rowOrgin,colOrigin,paths,grid,visited);

    }

    // Custom Sort String

    public static String customSortString(String order, String s) {

        Map<Character, Integer> map=new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        StringBuilder res=new StringBuilder();
        for(char c:order.toCharArray()){
            if(map.containsKey(c)){
                int count=map.get(c);
                for(int i=0;i<count;i++){
                    res.append(c);
                }
                map.remove(c);

            }

        }

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            int count= entry.getValue();
            for(int i=0;i<count;i++){
                res.append(entry.getKey());
            }

        }

        return res.toString();
    }

// Bulls and Cows

    public static String getHint (String secret, String guess)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        int bull=0;
        int cow=0;
        char[] secrects=secret.toCharArray();
        char[] guesses=guess.toCharArray();
        for(int i=0;i<secrects.length;i++){

            char s=secrects[i];
            char g=guesses[i];
            if(s==g){
                bull++;
            }else{

                if(map.getOrDefault(s,0)<0) cow++;
                if(map.getOrDefault(g,0)>0) cow++;


                map.put(s,map.getOrDefault(s,0)+1);
                map.put(g,map.getOrDefault(g,0)-1);


            }



        }
        return bull+"A"+cow+"B";
    }




    // High Five

    public static int[][] highFive(int[][] items) {

        Map<Integer,PriorityQueue<Integer>> scoreMap=new TreeMap<>();

        for(int[] scores:items){
                int studentID=scores[0];
                int score=scores[1];
                if(!scoreMap.containsKey(studentID)){
                    PriorityQueue<Integer> queue=new PriorityQueue<>();
                    scoreMap.put(studentID,queue);
                }
                scoreMap.get(studentID).offer(score);
                if(scoreMap.get(studentID).size()>5){
                    scoreMap.get(studentID).poll();
                }
        }

        int[][] result =new int[scoreMap.size()][2];
        int i=0;
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry: scoreMap.entrySet()){
            PriorityQueue<Integer> queue=(PriorityQueue<Integer>)entry.getValue();
            int aggregation=queue.stream().mapToInt(Integer::intValue)
                    .sum()/queue.size();
            result[i][0]=(int)entry.getKey();
            result[i][1]=aggregation;
            i++;

        }
        // Replace this placeholder return statement with your code
        return result;
    }

    // Dot Product of Two Sparse Vectors

    public  Map<Integer,Integer> getSparseVector(int[] nums) {
        Map<Integer,Integer> hashMap= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                hashMap.put(i, nums[i]);
            }
        }
        return hashMap;
    }

    public int dotProduct(Map<Integer,Integer> hashMap1,Map<Integer,Integer> hashMap2) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            int i = entry.getKey();
            int n = entry.getValue();
            if (hashMap2.containsKey(i)) {
                sum += n * hashMap2.get(i);
            }
        }
        return sum;
    }

    // Find Duplicate File in System


    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();

        for(String path:paths) {
            String[] values = path.split(" ");
            String dir = values[0];
            for(int i=1;i<values.length;i++) {
                String[] fileAndClass = values[i].split("\\(");
                String fileName = fileAndClass[1];
                String file = fileAndClass[0];
                String cls = fileName.substring(0, fileName.length() - 1);
                map.computeIfAbsent(cls, x -> new ArrayList<>()).add(dir + "/" + file);
            }
        }

        for(Map.Entry<String,List<String>> keyValue:map.entrySet()){
            if(keyValue.getValue().size()>1){
                result.add(keyValue.getValue());
            }

        }
        return result;
    }

    // Isomorphic Strings

    public static boolean isIsomorphic(String string1, String string2) {
        // Replace this placeholder return statement with your code
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        int n=string1.length();
        for(int i=0;i<n;i++){
            char ch1=string1.charAt(i);
            char ch2=string2.charAt(i);
            if(map1.containsKey(ch1) && !map1.get(ch1).equals(ch2)){
                return false;
            }

            if(map2.containsKey(ch2) && !map2.get(ch2).equals(ch1)){
                return false;
            }

            map1.putIfAbsent(ch1,ch2);
            map2.putIfAbsent(ch2,ch1);
        }
        return true;
    }

    // Next Greater Element I
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {


        int[] ans=new int[nums1.length];
        Map<Integer,Integer> map=new HashMap<>();
        java.util.Stack<Integer> stack=new java.util.Stack<Integer>();

        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                int key=stack.pop();
                map.put(key,nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        for(int i=0;i<nums1.length;i++){

            ans[i]=map.get(nums1[i]);
        }

        // Replace this placeholder return statement with your code
        return ans;
    }

    // Logger Rate Limiter


    public boolean messageRequestDecision(int timestamp, String request) {

        if(!requests.containsKey(request)){
            requests.put(request,timestamp);
            return true;
        }

        if(timestamp-requests.get(request)>=this.limit){
            this.requests.put(request,timestamp);
            return true;
        }else{
            return false;
        }

    }


    //Fraction to Recurring Decimal

    public static String fractionToDecimal(int numerator, int denominator) {

        // Replace this placeholder return statement with your code
        String result = "";
        Map<Long, Integer> reminderMap = new HashMap<>();

        if (numerator == 0) {
            return "0";
        }

        if (numerator < 0 || denominator < 0) {
            result += "-";
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long quotient = num / den;
        long reminder = (num % den) * 10;

        result += quotient;

        if (reminder == 0) {
            return result;
        } else {
            result += ".";
            while (reminder != 0) {
                if (reminderMap.containsKey(reminder)) {
                    int beginning = reminderMap.get(reminder);
                    result = result.substring(0, beginning) + "(" + result.substring(beginning) + ")";
                    break;
                } else {
                    reminderMap.put(reminder, result.length());
                    quotient = reminder / den;
                    reminder = (reminder % den) * 10;
                    result += quotient;
                }

            }

            return result;
        }


    }
}