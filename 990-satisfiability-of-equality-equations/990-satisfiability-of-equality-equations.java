class Solution {
    public boolean equationsPossible(String[] equations) {
        return equationsPossible4(equations);
    }
    
    public boolean equationsPossible4(String[] equations) {
        char[] charset = new char[26];

//        Arrays.sort(equations, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.charAt(1) == o2.charAt(1)) {
//                    return 0;
//                }
//                if (o1.charAt(1) == '!') {
//                    return 1;
//                }
//                return -1;
//            }
//        });
//
//        System.out.println(Arrays.toString(equations));
        char operator;
        char lhs, rhs, lhsParent, rhsParent;

        for (String i: equations) {
            operator = i.charAt(1);

            lhs = i.charAt(0);
            rhs = i.charAt(3);

            lhsParent = parentOf(lhs, charset);
            rhsParent = parentOf(rhs, charset);

            if (operator == '=') {
                if (lhsParent != rhsParent) {
                    charset[lhsParent - 97] = rhsParent;
                }
            }
        }

        for (String i: equations) {
            operator = i.charAt(1);

            lhs = i.charAt(0);
            rhs = i.charAt(3);

            lhsParent = parentOf(lhs, charset);
            rhsParent = parentOf(rhs, charset);

            if (operator == '!') {
                if (lhsParent == rhsParent) {
                   return false;
                }
            }
        }

//        System.out.println(Arrays.toString(charset));
//        System.out.println("--PARENTS--");
////
//        for (int i = 0; i < 26; i++) {
//            char p = (char) (i + 97);
//            System.out.println(p + " -> " + parentOf(p, charset));
//        }
        return true;
    }

    char parentOf(char c, char[] charset) {
        if (!isLowercaseAlphabet(charset[c - 97])) {
            return c;
        }
        return parentOf(charset[c - 97], charset);
    }

    boolean isLowercaseAlphabet(char c) {
        return (int) c > 96 && (int) c < (97 + 26);
    }
}