package hk.ust.cse.comp107x.travel2;

/**
 * Created by Padhavi on 14-05-2017.
 */
public class userchoice {



    //name and address string
    private String name,txt;
    private String time;

    public userchoice() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String gettxt() {
        return txt;
    }

    public void settxt(String txt) {
        this.txt = txt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
