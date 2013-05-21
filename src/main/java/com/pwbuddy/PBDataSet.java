package com.pwbuddy;

/**
 * @author jakob
 * @version 2013-05-14
 */
public class PBDataSet implements Comparable <PBDataSet> {
    private PBDataSetView dv;
    private int lineCount;
    /**Wenn ein dataSet geöffnet ist soll der Inhalt gerendert werden*/
    private boolean opened;

    private String name;

    public PBDataSet(){
        this.dv = new PBDataSetView();
        this.lineCount = 1;
        this.opened = false;
    }

    /**
     * @return Grafische darstellung des Datensatzes als JPanel
     */
    public PBDataSetView getView(){
        return this.dv;
    }

    /**
     * @return Anzahl der Zeilen welche vom Datensatz belegt werden.
     */
    public int getGridHeight(){
        if(isOpened()){
            return this.lineCount;
        } else {
            return 1; //höhe=1 für die Kopfzeile!
        }
    }

    /**
     * Wenn ein dataSet geöffnet ist soll der Inhalt gerendert werden
     *
     * @return ist der dataSet geöffnet?
     */
    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p/>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p/>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p/>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p/>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p/>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(PBDataSet o) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
