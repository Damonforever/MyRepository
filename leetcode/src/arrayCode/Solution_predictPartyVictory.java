package arrayCode;

public class Solution_predictPartyVictory {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }

    static String predictPartyVictory(String senate) {
        char[] ch =new char[senate.length()];
        int countR=0;
        int countD=0;
        for (int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i)=='R'){
                countR++;
            }
            if(senate.charAt(i)=='D'){
                countD++;
            }
            ch[i]=senate.charAt(i);
        }
        boolean[] judge = new boolean[ch.length];
        boolean flag =true;
        boolean flag1 = true;
        while(flag){
            for(int i =0;i<ch.length;i++){
                if(ch[i]=='R'&& judge[i]==false){
                    for(int j=i+1;j<ch.length;j++){
                        if(ch[j]=='D' && judge[j]==false){
                            judge[j]=true;
                            if(countD>0){
                                countD--;
                            }
                            break;
                        }
                        if(j==ch.length-1){
                            flag1=false;
                        }
                    }
                    if(i==ch.length-1 || !flag1){
                        for(int k=0;k<i;k++){
                            if(ch[k]=='D' && judge[k]==false){
                                judge[k]=true;
                                if(countD>0){
                                    countD--;
                                }
                                break;
                            }
                        }
                        flag1=true;
                    }
                }
                if(ch[i]=='D' && judge[i]==false){
                    for(int j=i+1;j<ch.length;j++){
                        if(ch[j]=='R' &&judge[j]==false){
                            judge[j]=true;
                            if(countR>0){
                                countR--;
                            }
                            break;
                        }
                        if(j==ch.length-1){
                            flag1=false;
                        }

                    }
                    if(i==ch.length-1 || !flag1){
                        for(int k=0;k<i;k++){
                            if(ch[k]=='R' && judge[k]==false){
                                judge[k]=true;
                                if(countR>0){
                                    countR--;
                                }
                                break;
                            }
                        }
                        flag1=true;
                    }
                }
            }
            if(countD==0 || countR==0){
                break;
            }
        }
        String str = "";
        if(countD>0){
            str="Dire";
        }
        if(countR>0){
            str="Radiant";
        }
        return str;
    }
//    static String predictPartyVictory(String senate) {
//        char[] ch = senate.toCharArray();
//        boolean[] judge = new boolean[ch.length];
//        int countR=0;
//        int countD=0;
//        boolean flag =true;
//        boolean flag1 = true;
//        for(int m=0;m<ch.length;m++){
//            if(ch[m]=='R'){
//                countR++;
//            }
//            if(ch[m]=='D'){
//                countD++;
//            }
//        }
//        while(flag){
//            for(int i =0;i<ch.length;i++){
//                if(ch[i]=='R'&& judge[i]==false){
//                    for(int j=i+1;j<ch.length;j++){
//                        if(ch[j]=='D' && judge[j]==false){
//                            judge[j]=true;
//                            if(countD>0){
//                                countD--;
//                            }
//                            break;
//                        }
//                        if(j==ch.length-1){
//                            flag1=false;
//                        }
//                    }
//                    if(i==ch.length-1 || !flag1){
//                        for(int k=0;k<i;k++){
//                            if(ch[k]=='D' && judge[k]==false){
//                                judge[k]=true;
//                                if(countD>0){
//                                    countD--;
//                                }
//                                break;
//                            }
//                        }
//                        flag1=true;
//                    }
//                }
//                if(ch[i]=='D' && judge[i]==false){
//                    for(int j=i+1;j<ch.length;j++){
//                        if(ch[j]=='R' &&judge[j]==false){
//                            judge[j]=true;
//                            if(countR>0){
//                                countR--;
//                            }
//                            break;
//                        }
//                        if(j==ch.length-1){
//                            flag1=false;
//                        }
//
//                    }
//                    if(i==ch.length-1 || !flag1){
//                        for(int k=0;k<i;k++){
//                            if(ch[k]=='R' && judge[k]==false){
//                                judge[k]=true;
//                                if(countR>0){
//                                    countR--;
//                                }
//                                break;
//                            }
//                        }
//                        flag1=true;
//                    }
//                }
//            }
//            if(countD==0 || countR==0){
//                break;
//            }
//        }
//        String str = "";
//        if(countD>0){
//            str="Dire";
//        }
//        if(countR>0){
//            str="Radiant";
//        }
//        return str;
//    }
}
