/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Timestamp;

/**
 *
 * @author boody
 */
public class Transaction {

    public int transactions_id;
    public float transaction_ammount;
    public int from_Account;
    public int to_account;
    public Timestamp created_at;

    public Transaction(int transactions_id, float transaction_ammount, int from_Account, int to_account, Timestamp created_at) {
        this.transactions_id = transactions_id;
        this.transaction_ammount = transaction_ammount;
        this.from_Account = from_Account;
        this.to_account = to_account;
        this.created_at = created_at;

    }

    public Transaction() {
    }

}
