package leetcode.special.sf2020;

import java.util.HashSet;

public class wolfkill {
    public boolean canVillagersWin(String[] players, int[] credibility) {
        int vi = 8;
        int w = 4;
        HashSet<Integer> survive = new HashSet<Integer>(){{
            add(0);add(1);add(2);add(3);add(4);add(5);
            add(6);add(7);add(8);add(9);add(10);add(11);
        }};
        //first night

        boolean beardead = false;
        int bearposition = -1;
        for (int i = 0; i < 12; i++) {
            if (players[i].equals("bear")){
                bearposition = i;
                break;
            }
        }
        int l = -1, r = -1;
        while (w != 0 && w < vi){
            //night
            int wolfkill = wolfkill(credibility,survive,players);
            vi--;
            credibility[wolfkill] = 100;
            credibility = updatecre(credibility,l,r);
            survive.remove(wolfkill);
            if (players[wolfkill].equals("bear"))
                beardead = true;
            else if(players[wolfkill].equals("hunter")){
                int vote = vote(credibility,survive);
                survive.remove(vote);
                if (players[vote].equals("ww"))
                    w--;
                else
                    vi--;
                if (players[vote].equals("bear"))
                    beardead = true;
            }
            if (w == 0)
                return true;
            if (vi <= w)
                return false;
            if (!beardead){
                credibility[bearposition] = 101;
                l = bearposition;
                r = bearposition;
                while(true){
                    l = (l + 11) % 12;
                    if (survive.contains(l))
                        break;
                }
                while(true){
                    r = (r + 1) % 12;
                    if (survive.contains(r))
                        break;
                }
                if (!players[l].equals("ww") && !players[r].equals("ww")){
                    credibility[l] = 100;
                    credibility[r] = 100;
                    l = -1;
                    r = -1;
                }
                else {
                    credibility[l] /= 2;
                    credibility[r] /= 2;
                }
            }
            //day
            int vote = vote(credibility,survive);
            if (players[vote].equals("idiot")){
                credibility[vote] = 100;
                credibility = updatecre(credibility,l,r);
            }
            else if(players[vote].equals("hunter")){
                credibility[vote] = 100;
                credibility = updatecre(credibility,l,r);
                survive.remove(vote);
                vi--;
                int gunkill = vote(credibility,survive);
                survive.remove(gunkill);
                if (players[gunkill].equals("ww"))
                    w--;
                else
                    vi--;
            }
            else{
                survive.remove(vote);
                if (players[vote].equals("ww"))
                    w--;
                else
                    vi--;
            }
            if (w == 0)
                return true;
            if (vi <= w)
                return false;
        }
        if (w == 0)
            return true;
        if (vi <= w)
            return false;
        return true;
    }

    public int[] updatecre(int[] credibility, int l, int r){
        if(l != -1 && r != -1){
            if (credibility[l] == 100)
                credibility[r] = 0;
            else if(credibility[r] == 100)
                credibility[l] = 0;
        }
        return credibility;
    }

    public int wolfkill(int[] credibility, HashSet<Integer> survive, String[] players){
        int max = -1;
        int kill_number = -1;
        for (Integer integer : survive) {
            if (credibility[integer.intValue()] > max && !players[integer.intValue()].equals("ww")){
                max = credibility[integer.intValue()];
                kill_number = integer.intValue();
            }
        }
        return kill_number;
    }

    public int vote(int[] credibility, HashSet<Integer> survive){
        int min = 1000;
        int vote_number = -1;
        for (int i = 0; i < 12; i++) {
            if (survive.contains(i)){
                if (credibility[i] < min){
                    min = credibility[i];
                    vote_number = i;
                }
            }
        }
        return vote_number;
    }

    public static void main(String[] args) {
        wolfkill w = new wolfkill();
        String[] players = new String[]{"bear", "vil", "vil", "ww", "vil", "vil", "idiot", "ww", "hunter", "ww", "ww", "vil"};
        int[] credibility = new int[]{9, 55, 62, 74, 43, 70, 13, 23, 15, 78, 61, 66};
        String[] players2 = new String[]{"vil", "vil", "vil", "ww", "vil", "ww", "ww", "vil", "ww", "bear", "hunter", "idiot"};
        int[] credibility2 = new int[]{81, 71, 88, 31, 34, 40, 70, 94, 73, 79, 98, 48};

        System.out.println(w.canVillagersWin(players2,credibility2));

    }
}
