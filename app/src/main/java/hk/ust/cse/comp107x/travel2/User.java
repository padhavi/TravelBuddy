package hk.ust.cse.comp107x.travel2;

/**
 * Created by Padhavi on 09-03-2017.
 */


/**
 * Created by Padhavi on 09-02-2017.
 */



public class User {
    private String userName;
    private String email;
    // private boolean hasLoggedInWithPassword;


    /**
     * Required public constructor
     */
    public User() {

    }

    /**
     * Use this constructor to create new User.
     * Takes user name, email and timestampJoined as params
     *
     * @param name
     * @param email
     *
     */
    public User(String name, String email) {
        this.userName = name;
        this.email = email;

        //  this.hasLoggedInWithPassword = false;
    }

    public String getName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }


    /*public boolean isHasLoggedInWithPassword() {
        return hasLoggedInWithPassword;
    }*/
}
