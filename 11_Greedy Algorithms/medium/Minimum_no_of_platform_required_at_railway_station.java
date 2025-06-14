//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

import java.util.Arrays;

public class Minimum_no_of_platform_required_at_railway_station {

    public static int minPlatforms(int[] arri,int[] dep){
        Arrays.sort(arri);
        Arrays.sort(dep);
        // System.out.println(Arrays.toString(arri));
        // System.out.println(Arrays.toString(dep));
        int n=arri.length;
        int i=0;
        int j=0;
        int platforms=0;
        int count=0;
        while (i<n) {
            if (arri[i]<=dep[j]) {
                count=count+1;
                i++;
            }
            else if (arri[i]>dep[j]) {
                count=count-1;
                j++;
            }
            platforms=Math.max(platforms, count);
        }
        return platforms;
    }
    public static void main(String[] args) {
        int[] arri={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};

        int ans=minPlatforms(arri,dep);
        System.out.println(ans);
    }
}
