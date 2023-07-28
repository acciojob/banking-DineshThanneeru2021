package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(balance<5000)
        {
            throw new Exception("Insufficient Balance");
        }







    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isLicenseValid(tradeLicenseId))
        {
            String reArrangeString=rearrange(tradeLicenseId);
            if(reArrangeString=="")
                throw new Exception("Valid License can not be generated");
            else {
                this.tradeLicenseId=reArrangeString;

            }

        }



    }
    public char getMaxCountChar(int[] count)
    {
        int max=0;
        char ch=0;
        for(int i=0;i<26;i++)
        {
            if(count[i]>max)
            {
                max=count[i];
                ch=(char)((int)'A'+i);
            }
        }
        return ch;

    }
    public String rearrange(String s)
    {
        int n=s.length();
        int[] count=new int[26];
        for(int i=0;i<s.length();i++)
        {
            count[(int)s.charAt(i)-(int)'A']++;
        }
        char max_char=getMaxCountChar(count);
        int max_count=count[(int)max_char-(int)'A'];

        if(max_count>(n+1)/2)
        {
            return "";
        }

        String res="";

        for(int i=0;i<n;i++)
        {
            res+=' ';
        }

        int index=0;
         while(max_count>0)
         {
             res+=res.substring(0,index)+max_char+res.substring(index+1);
             index+=2;
             max_count--;
         }

         count[(int)max_char-(int)'A']=0;
         for(int i=0;i<26;i++)
         {
             while(count[i]>0)
             {
                 index+=(i>=n)?1:index;
                 res+=res.substring(0,index)+(char)((int)'A'+i)+res.substring(index+1);
                 index+=2;
                 count[i]--;
             }
         }
         return res;

    }
    public boolean isLicenseValid(String tradeLicenseId)
    {
        for(int i=0;i<tradeLicenseId.length()-1;i++)
        {
            for(int j=i+1;j<tradeLicenseId.length();j++)
            {
                if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
