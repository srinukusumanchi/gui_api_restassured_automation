/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2023-04-05
 * Created Time: 5:51 p.m.
 */

package bns.a6.microui.api.pojo.bfbk.employment.services.post;

public class Gross_monthy_income_amt {

    private String currency_cd;

    private Double amount;

    public void setCurrency_cd(String currency_cd){
        this.currency_cd = currency_cd;
    }
    public String getCurrency_cd(){
        return this.currency_cd;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public Double getAmount(){
        return this.amount;
    }
}
