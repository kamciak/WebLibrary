/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BookPackage;

/**
 *
 * @author Tomek
 */
public class Borrowings extends Reservation {
    private Boolean _deleted;

    public Boolean isDeleted() {
        return _deleted;
    }

    public void setDeleted(Boolean _deleted) {
        this._deleted = _deleted;
    }
}
