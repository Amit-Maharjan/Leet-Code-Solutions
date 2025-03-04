package com.company.TopInterview150.BitManipulation;

public class AddBinary2 {
    public String addBinary(String a, String b) {
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (aIndex>-1 || bIndex>-1 || carry!=0) {
            int aNum = aIndex>-1 ? a.charAt(aIndex--) - '0' : 0;
            int bNum = bIndex>-1 ? b.charAt(bIndex--) - '0' : 0;
            int sum = aNum + bNum + carry;
            sb.append(sum%2);
            carry = sum/2;
        }

        return sb.reverse().toString();
    }
}
