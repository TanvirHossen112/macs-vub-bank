public class Client {

    private int ID;
    private int pin;

    /**
     * Construct a Client instance using ID and pin
     *
     * @param int ID
     * @param int pin
     */
    public Client(int ID, int pin) {
        this.ID = ID;
        this.pin = pin;
    }

    /**
     * Response with client's ID
     *
     * @return int
     */
    public int getID() {
        return ID;
    }

    /**
     * Match given pin
     *
     * @param int PIN
     * @return bool
     */
    public boolean pinMatch(int PIN) {
        return this.pin == PIN;
    }

}
