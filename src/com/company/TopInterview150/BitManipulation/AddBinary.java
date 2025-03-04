package com.company.TopInterview150.BitManipulation;

public class AddBinary {
    public String addBinary(String a, String b) {
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int maxLen = Math.max(aIndex,bIndex);
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<=maxLen; i++) {
            int numA = aIndex>-1 ? a.charAt(aIndex--) - '0' : 0;
            int numB = bIndex>-1 ? b.charAt(bIndex--) - '0' : 0;

            int sum = numA + numB + carry;
            sb.append(sum%2);
            carry = sum/2;
        }

        if (carry==1) sb.append(1);

        return sb.reverse().toString();
    }
}
